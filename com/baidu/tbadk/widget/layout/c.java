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
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class c extends ViewGroup {
    private Paint aFB;
    private int aGA;
    private ViewGroup.OnHierarchyChangeListener aGB;
    private double aGq;
    private h aGr;
    private com.baidu.adp.lib.f.b<TbImageView> aGv;
    private int aGw;
    private int aGx;
    private int aGy;
    private String aGz;
    private boolean adw;

    public c(Context context) {
        super(context);
        this.aGx = -1;
        this.adw = false;
        this.aGy = r.d.common_color_10082;
        this.aGA = 0;
        this.aGB = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aGB);
        this.aFB = new Paint();
        this.aFB.setColor(av.getColor(r.d.cp_cont_g));
        this.aFB.setTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.fontsize32));
        this.aFB.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aFB.getFontMetrics();
        this.aGA = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public void setImageClickListener(h hVar) {
        this.aGr = hVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aGv = bVar;
    }

    public void setFromCDN(boolean z) {
        this.adw = z;
    }

    public void setForeColorId(int i) {
        this.aGy = i;
    }

    public void setExtraCenterText(String str) {
        this.aGz = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aGx = i;
        } else {
            this.aGx = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aGq = d;
    }

    public void a(List<String> list, int i, boolean z) {
        int s;
        if (this.aGv != null && (s = y.s(list)) > 0) {
            fq(s);
            int childCount = getChildCount();
            int i2 = this.adw ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aGr != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m9getInst().getResources().getColor(this.aGy));
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
        this.aGw = i;
    }

    private void fq(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView ey = this.aGv.ey();
                ey.setContentDescription(getResources().getString(r.j.log_msg_pic));
                ey.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ey.setDefaultBg(av.getDrawable(r.d.common_color_10220));
                addView(ey);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aGx);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aGw)) / max;
            int i4 = (childCount != 1 || this.aGq <= 0.0d) ? i3 : (int) ((i3 * this.aGq) + 0.5d);
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
                int i6 = (this.aGw + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aGz) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            int measuredWidth = childAt.getMeasuredWidth();
            b(canvas, getMeasuredWidth() - (measuredWidth / 2), getMeasuredHeight() - (measuredWidth / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aGz)) {
            canvas.drawText(this.aGz, (int) (i - (this.aFB.measureText(this.aGz) / 2.0f)), (this.aGA / 2) + i2, this.aFB);
        }
    }

    public void tx() {
        this.aFB.setColor(av.getColor(r.d.cp_cont_g));
        invalidate();
    }
}
