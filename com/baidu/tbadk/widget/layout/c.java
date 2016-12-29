package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class c extends ViewGroup {
    private Paint aFL;
    private double aGA;
    private h aGB;
    private com.baidu.adp.lib.f.b<TbImageView> aGF;
    private int aGG;
    private int aGH;
    private int aGI;
    private String aGJ;
    private int aGK;
    private ViewGroup.OnHierarchyChangeListener aGL;
    private boolean adn;

    public c(Context context) {
        super(context);
        this.aGH = -1;
        this.adn = false;
        this.aGI = r.d.common_color_10082;
        this.aGK = 0;
        this.aGL = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aGL);
        this.aFL = new Paint();
        this.aFL.setColor(ar.getColor(r.d.cp_cont_g));
        this.aFL.setTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.fontsize32));
        this.aFL.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aFL.getFontMetrics();
        this.aGK = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public void setImageClickListener(h hVar) {
        this.aGB = hVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aGF = bVar;
    }

    public void setFromCDN(boolean z) {
        this.adn = z;
    }

    public void setForeColorId(int i) {
        this.aGI = i;
    }

    public void setExtraCenterText(String str) {
        this.aGJ = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aGH = i;
        } else {
            this.aGH = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aGA = d;
    }

    public void a(List<String> list, int i, boolean z) {
        int s;
        if (this.aGF != null && (s = x.s(list)) > 0) {
            ft(s);
            int childCount = getChildCount();
            int i2 = this.adn ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aGB != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m9getInst().getResources().getColor(this.aGI));
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
        this.aGG = i;
    }

    private void ft(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView ey = this.aGF.ey();
                ey.setContentDescription(getResources().getString(r.j.log_msg_pic));
                ey.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ey.setDefaultBg(ar.getDrawable(r.d.common_color_10220));
                addView(ey);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aGH);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aGG)) / max;
            int i4 = this.aGA > 0.0d ? (int) ((i3 * this.aGA) + 0.5d) : i3;
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
                int i6 = (this.aGG + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aGJ) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aGJ)) {
            canvas.drawText(this.aGJ, (int) (i - (this.aFL.measureText(this.aGJ) / 2.0f)), (this.aGK / 2) + i2, this.aFL);
        }
    }

    public void tm() {
        this.aFL.setColor(ar.getColor(r.d.cp_cont_g));
        invalidate();
    }
}
