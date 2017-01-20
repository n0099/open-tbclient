package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class c extends ViewGroup {
    private Paint aEA;
    private ViewGroup.OnHierarchyChangeListener aFA;
    private double aFp;
    private h aFq;
    private com.baidu.adp.lib.e.b<TbImageView> aFu;
    private int aFv;
    private int aFw;
    private int aFx;
    private String aFy;
    private int aFz;
    private boolean acy;

    public c(Context context) {
        super(context);
        this.aFw = -1;
        this.acy = false;
        this.aFx = r.e.common_color_10082;
        this.aFz = 0;
        this.aFA = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aFA);
        this.aEA = new Paint();
        this.aEA.setColor(ap.getColor(r.e.cp_cont_g));
        this.aEA.setTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(r.f.fontsize32));
        this.aEA.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aEA.getFontMetrics();
        this.aFz = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public void setImageClickListener(h hVar) {
        this.aFq = hVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aFu = bVar;
    }

    public void setFromCDN(boolean z) {
        this.acy = z;
    }

    public void setForeColorId(int i) {
        this.aFx = i;
    }

    public void setExtraCenterText(String str) {
        this.aFy = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aFw = i;
        } else {
            this.aFw = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aFp = d;
    }

    public void a(List<String> list, int i, boolean z) {
        int r;
        if (this.aFu != null && (r = w.r(list)) > 0) {
            fu(r);
            int childCount = getChildCount();
            int i2 = this.acy ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aFq != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m9getInst().getResources().getColor(this.aFx));
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
        this.aFv = i;
    }

    private void fu(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView ew = this.aFu.ew();
                ew.setContentDescription(getResources().getString(r.l.log_msg_pic));
                ew.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ew.setDefaultBg(ap.getDrawable(r.e.common_color_10220));
                addView(ew);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aFw);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aFv)) / max;
            int i4 = this.aFp > 0.0d ? (int) ((i3 * this.aFp) + 0.5d) : i3;
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
                int i6 = (this.aFv + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aFy) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aFy)) {
            canvas.drawText(this.aFy, (int) (i - (this.aEA.measureText(this.aFy) / 2.0f)), (this.aFz / 2) + i2, this.aEA);
        }
    }

    public void tg() {
        this.aEA.setColor(ap.getColor(r.e.cp_cont_g));
        invalidate();
    }
}
