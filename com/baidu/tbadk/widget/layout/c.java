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
    private Paint aKp;
    private double aLe;
    private g aLf;
    private com.baidu.adp.lib.e.b<TbImageView> aLj;
    private int aLk;
    private int aLl;
    private int aLm;
    private String aLn;
    private int aLo;
    private ViewGroup.OnHierarchyChangeListener aLp;
    private boolean aid;

    public c(Context context) {
        super(context);
        this.aLl = -1;
        this.aid = false;
        this.aLm = w.e.common_color_10082;
        this.aLo = 0;
        this.aLp = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aLp);
        this.aKp = new Paint();
        this.aKp.setColor(aq.getColor(w.e.cp_cont_g));
        this.aKp.setTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.fontsize32));
        this.aKp.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aKp.getFontMetrics();
        this.aLo = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public void setImageClickListener(g gVar) {
        this.aLf = gVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aLj = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aid = z;
    }

    public void setForeColorId(int i) {
        this.aLm = i;
    }

    public void setExtraCenterText(String str) {
        this.aLn = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aLl = i;
        } else {
            this.aLl = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aLe = d;
    }

    public void a(List<String> list, int i, boolean z) {
        int p;
        if (this.aLj != null && (p = x.p(list)) > 0) {
            fq(p);
            int childCount = getChildCount();
            int i2 = this.aid ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aLf != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m9getInst().getResources().getColor(this.aLm));
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
        this.aLk = i;
    }

    private void fq(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fK = this.aLj.fK();
                fK.setContentDescription(getResources().getString(w.l.editor_image));
                fK.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fK.setDefaultBg(aq.getDrawable(w.e.common_color_10220));
                addView(fK);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aLl);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aLk)) / max;
            int i4 = this.aLe > 0.0d ? (int) ((i3 * this.aLe) + 0.5d) : i3;
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
                int i6 = (this.aLk + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aLn) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aLn)) {
            canvas.drawText(this.aLn, (int) (i - (this.aKp.measureText(this.aLn) / 2.0f)), (this.aLo / 2) + i2, this.aKp);
        }
    }

    public void onChangeSkinType() {
        this.aKp.setColor(aq.getColor(w.e.cp_cont_g));
        invalidate();
    }
}
