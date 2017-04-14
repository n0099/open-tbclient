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
    private Paint aKn;
    private double aLc;
    private g aLd;
    private com.baidu.adp.lib.e.b<TbImageView> aLh;
    private int aLi;
    private int aLj;
    private int aLk;
    private String aLl;
    private int aLm;
    private ViewGroup.OnHierarchyChangeListener aLn;
    private boolean aic;

    public c(Context context) {
        super(context);
        this.aLj = -1;
        this.aic = false;
        this.aLk = w.e.common_color_10082;
        this.aLm = 0;
        this.aLn = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aLn);
        this.aKn = new Paint();
        this.aKn.setColor(aq.getColor(w.e.cp_cont_g));
        this.aKn.setTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.fontsize32));
        this.aKn.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aKn.getFontMetrics();
        this.aLm = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public void setImageClickListener(g gVar) {
        this.aLd = gVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aLh = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aic = z;
    }

    public void setForeColorId(int i) {
        this.aLk = i;
    }

    public void setExtraCenterText(String str) {
        this.aLl = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aLj = i;
        } else {
            this.aLj = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aLc = d;
    }

    public void a(List<String> list, int i, boolean z) {
        int p;
        if (this.aLh != null && (p = x.p(list)) > 0) {
            fq(p);
            int childCount = getChildCount();
            int i2 = this.aic ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aLd != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m9getInst().getResources().getColor(this.aLk));
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
        this.aLi = i;
    }

    private void fq(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fJ = this.aLh.fJ();
                fJ.setContentDescription(getResources().getString(w.l.editor_image));
                fJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fJ.setDefaultBg(aq.getDrawable(w.e.common_color_10220));
                addView(fJ);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aLj);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aLi)) / max;
            int i4 = this.aLc > 0.0d ? (int) ((i3 * this.aLc) + 0.5d) : i3;
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
                int i6 = (this.aLi + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aLl) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aLl)) {
            canvas.drawText(this.aLl, (int) (i - (this.aKn.measureText(this.aLl) / 2.0f)), (this.aLm / 2) + i2, this.aKn);
        }
    }

    public void onChangeSkinType() {
        this.aKn.setColor(aq.getColor(w.e.cp_cont_g));
        invalidate();
    }
}
