package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class c extends ViewGroup {
    private Paint aKy;
    private int aLA;
    private int aLB;
    private ViewGroup.OnHierarchyChangeListener aLC;
    private BdUniqueId aLk;
    private double aLp;
    private g aLq;
    private com.baidu.adp.lib.e.b<TbImageView> aLu;
    private int aLv;
    private int aLw;
    private int aLx;
    private String aLy;
    private int aLz;
    private boolean ahv;

    public c(Context context) {
        super(context);
        this.aLw = -1;
        this.ahv = false;
        this.aLx = w.e.common_color_10082;
        this.aLz = 0;
        this.aLC = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aLC);
        this.aKy = new Paint();
        this.aKy.setColor(aq.getColor(w.e.cp_cont_i));
        this.aKy.setTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.fontsize32));
        this.aKy.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aKy.getFontMetrics();
        this.aLz = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.aLA = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
    }

    public void setImageClickListener(g gVar) {
        this.aLq = gVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aLu = bVar;
    }

    public void setFromCDN(boolean z) {
        this.ahv = z;
    }

    public void setForeColorId(int i) {
        this.aLx = i;
    }

    public void setExtraCenterText(String str) {
        this.aLy = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aLw = i;
        } else {
            this.aLw = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aLp = d;
    }

    public void a(List<String> list, int i, boolean z) {
        int q;
        if (this.aLu != null && (q = x.q(list)) > 0) {
            fm(q);
            int childCount = getChildCount();
            int i2 = this.ahv ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aLq != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m9getInst().getResources().getColor(this.aLx));
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
        this.aLv = i;
    }

    private void fm(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fK = this.aLu.fK();
                fK.setContentDescription(getResources().getString(w.l.editor_image));
                fK.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fK.setDefaultBg(aq.getDrawable(w.e.common_color_10220));
                fK.setPageId(this.aLk);
                addView(fK);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aLw);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aLv)) / max;
            int i4 = this.aLp > 0.0d ? (int) ((i3 * this.aLp) + 0.5d) : i3;
            if (this.aLB > 0) {
                i4 = this.aLB;
            }
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
                int i6 = (this.aLv + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aLy) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aLy)) {
            float measureText = this.aKy.measureText(this.aLy);
            int g = k.g(getContext(), w.f.ds8);
            int i3 = (int) (i - (measureText / 2.0f));
            int i4 = ((this.aLz / 2) + i2) - this.aLA;
            Bitmap cL = aq.cL(w.g.home_ic_pic);
            if (cL != null) {
                int width = cL.getWidth();
                int i5 = (int) (i - ((measureText + (width + g)) / 2.0f));
                canvas.drawBitmap(cL, i5, i2 - (cL.getHeight() / 2), (Paint) null);
                i3 = width + i5 + g;
            }
            canvas.drawText(this.aLy, i3, i4, this.aKy);
        }
    }

    public void onChangeSkinType() {
        this.aKy.setColor(aq.getColor(w.e.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.aLB = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aLk = bdUniqueId;
    }
}
