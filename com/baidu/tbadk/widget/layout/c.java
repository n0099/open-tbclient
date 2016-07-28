package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class c extends ViewGroup {
    private Paint aCV;
    private double aDK;
    private h aDL;
    private com.baidu.adp.lib.f.b<TbImageView> aDP;
    private int aDQ;
    private int aDR;
    private int aDS;
    private String aDT;
    private int aDU;
    private ViewGroup.OnHierarchyChangeListener aDV;
    private boolean aav;

    public c(Context context) {
        super(context);
        this.aDR = -1;
        this.aav = false;
        this.aDS = u.d.common_color_10082;
        this.aDU = 0;
        this.aDV = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aDV);
        this.aCV = new Paint();
        this.aCV.setColor(av.getColor(u.d.cp_cont_g));
        this.aCV.setTextSize(TbadkCoreApplication.m10getInst().getResources().getDimension(u.e.fontsize32));
        this.aCV.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aCV.getFontMetrics();
        this.aDU = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public void setImageClickListener(h hVar) {
        this.aDL = hVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aDP = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aav = z;
    }

    public void setForeColorId(int i) {
        this.aDS = i;
    }

    public void setExtraCenterText(String str) {
        this.aDT = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aDR = i;
        } else {
            this.aDR = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aDK = d;
    }

    public void a(List<String> list, int i, boolean z) {
        int s;
        if (this.aDP != null && (s = y.s(list)) > 0) {
            fd(s);
            int childCount = getChildCount();
            int i2 = this.aav ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aDL != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m10getInst().getResources().getColor(this.aDS));
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
        this.aDQ = i;
    }

    private void fd(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView dD = this.aDP.dD();
                dD.setContentDescription(getResources().getString(u.j.log_msg_pic));
                dD.setScaleType(ImageView.ScaleType.CENTER_CROP);
                dD.setDefaultBg(av.getDrawable(u.d.common_color_10220));
                addView(dD);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aDR);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aDQ)) / max;
            int i4 = (childCount != 1 || this.aDK <= 0.0d) ? i3 : (int) ((i3 * this.aDK) + 0.5d);
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
                int i6 = (this.aDQ + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aDT) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            int measuredWidth = childAt.getMeasuredWidth();
            b(canvas, getMeasuredWidth() - (measuredWidth / 2), getMeasuredHeight() - (measuredWidth / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aDT)) {
            canvas.drawText(this.aDT, (int) (i - (this.aCV.measureText(this.aDT) / 2.0f)), (this.aDU / 2) + i2, this.aCV);
        }
    }

    public void sd() {
        this.aCV.setColor(av.getColor(u.d.cp_cont_g));
        invalidate();
    }
}
