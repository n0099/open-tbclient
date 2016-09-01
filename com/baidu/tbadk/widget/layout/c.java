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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class c extends ViewGroup {
    private double aGR;
    private h aGS;
    private com.baidu.adp.lib.f.b<TbImageView> aGW;
    private int aGX;
    private int aGY;
    private int aGZ;
    private Paint aGc;
    private String aHa;
    private int aHb;
    private ViewGroup.OnHierarchyChangeListener aHc;
    private boolean adl;

    public c(Context context) {
        super(context);
        this.aGY = -1;
        this.adl = false;
        this.aGZ = t.d.common_color_10082;
        this.aHb = 0;
        this.aHc = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aHc);
        this.aGc = new Paint();
        this.aGc.setColor(av.getColor(t.d.cp_cont_g));
        this.aGc.setTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(t.e.fontsize32));
        this.aGc.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aGc.getFontMetrics();
        this.aHb = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public void setImageClickListener(h hVar) {
        this.aGS = hVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aGW = bVar;
    }

    public void setFromCDN(boolean z) {
        this.adl = z;
    }

    public void setForeColorId(int i) {
        this.aGZ = i;
    }

    public void setExtraCenterText(String str) {
        this.aHa = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aGY = i;
        } else {
            this.aGY = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aGR = d;
    }

    public void a(List<String> list, int i, boolean z) {
        int s;
        if (this.aGW != null && (s = y.s(list)) > 0) {
            fr(s);
            int childCount = getChildCount();
            int i2 = this.adl ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aGS != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m9getInst().getResources().getColor(this.aGZ));
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
        this.aGX = i;
    }

    private void fr(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView ey = this.aGW.ey();
                ey.setContentDescription(getResources().getString(t.j.log_msg_pic));
                ey.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ey.setDefaultBg(av.getDrawable(t.d.common_color_10220));
                addView(ey);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aGY);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aGX)) / max;
            int i4 = (childCount != 1 || this.aGR <= 0.0d) ? i3 : (int) ((i3 * this.aGR) + 0.5d);
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
                int i6 = (this.aGX + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aHa) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            int measuredWidth = childAt.getMeasuredWidth();
            b(canvas, getMeasuredWidth() - (measuredWidth / 2), getMeasuredHeight() - (measuredWidth / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aHa)) {
            canvas.drawText(this.aHa, (int) (i - (this.aGc.measureText(this.aHa) / 2.0f)), (this.aHb / 2) + i2, this.aGc);
        }
    }

    public void ti() {
        this.aGc.setColor(av.getColor(t.d.cp_cont_g));
        invalidate();
    }
}
