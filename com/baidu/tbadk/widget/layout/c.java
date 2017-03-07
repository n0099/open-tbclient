package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class c extends ViewGroup {
    private Paint aJX;
    private double aKM;
    private h aKN;
    private com.baidu.adp.lib.e.b<TbImageView> aKR;
    private int aKS;
    private int aKT;
    private int aKU;
    private String aKV;
    private int aKW;
    private ViewGroup.OnHierarchyChangeListener aKX;
    private boolean ahO;

    public c(Context context) {
        super(context);
        this.aKT = -1;
        this.ahO = false;
        this.aKU = w.e.common_color_10082;
        this.aKW = 0;
        this.aKX = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aKX);
        this.aJX = new Paint();
        this.aJX.setColor(aq.getColor(w.e.cp_cont_g));
        this.aJX.setTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.fontsize32));
        this.aJX.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aJX.getFontMetrics();
        this.aKW = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public void setImageClickListener(h hVar) {
        this.aKN = hVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aKR = bVar;
    }

    public void setFromCDN(boolean z) {
        this.ahO = z;
    }

    public void setForeColorId(int i) {
        this.aKU = i;
    }

    public void setExtraCenterText(String str) {
        this.aKV = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aKT = i;
        } else {
            this.aKT = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aKM = d;
    }

    public void a(List<String> list, int i, boolean z) {
        int p;
        if (this.aKR != null && (p = x.p(list)) > 0) {
            fn(p);
            int childCount = getChildCount();
            int i2 = this.ahO ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aKN != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m9getInst().getResources().getColor(this.aKU));
                    } else {
                        tbImageView.setForegroundColor(0);
                    }
                    tbImageView.c(list.get(i3), i2, false);
                }
                i3++;
            }
        }
    }

    public void setImagePadding(int i) {
        this.aKS = i;
    }

    private void fn(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fE = this.aKR.fE();
                fE.setContentDescription(getResources().getString(w.l.log_msg_pic));
                fE.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fE.setDefaultBg(aq.getDrawable(w.e.common_color_10220));
                addView(fE);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aKT);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aKS)) / max;
            int i4 = this.aKM > 0.0d ? (int) ((i3 * this.aKM) + 0.5d) : i3;
            setMeasuredDimension(size, i4);
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int i6 = (this.aKS + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aKV) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aKV)) {
            canvas.drawText(this.aKV, (int) (i - (this.aJX.measureText(this.aKV) / 2.0f)), (this.aKW / 2) + i2, this.aJX);
        }
    }

    public void tD() {
        this.aJX.setColor(aq.getColor(w.e.cp_cont_g));
        invalidate();
    }
}
