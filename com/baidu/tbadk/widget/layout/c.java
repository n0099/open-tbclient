package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class c extends ViewGroup {
    private Paint aGr;
    private double aHg;
    private h aHh;
    private com.baidu.adp.lib.f.b<TbImageView> aHl;
    private int aHm;
    private int aHn;
    private int aHo;
    private String aHp;
    private int aHq;
    private ViewGroup.OnHierarchyChangeListener aHr;
    private boolean adU;

    public c(Context context) {
        super(context);
        this.aHn = -1;
        this.adU = false;
        this.aHo = r.d.common_color_10082;
        this.aHq = 0;
        this.aHr = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aHr);
        this.aGr = new Paint();
        this.aGr.setColor(at.getColor(r.d.cp_cont_g));
        this.aGr.setTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.fontsize32));
        this.aGr.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aGr.getFontMetrics();
        this.aHq = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public void setImageClickListener(h hVar) {
        this.aHh = hVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aHl = bVar;
    }

    public void setFromCDN(boolean z) {
        this.adU = z;
    }

    public void setForeColorId(int i) {
        this.aHo = i;
    }

    public void setExtraCenterText(String str) {
        this.aHp = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aHn = i;
        } else {
            this.aHn = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aHg = d;
    }

    public void a(List<String> list, int i, boolean z) {
        int s;
        if (this.aHl != null && (s = x.s(list)) > 0) {
            ft(s);
            int childCount = getChildCount();
            int i2 = this.adU ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aHh != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m9getInst().getResources().getColor(this.aHo));
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
        this.aHm = i;
    }

    private void ft(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView ey = this.aHl.ey();
                ey.setContentDescription(getResources().getString(r.j.log_msg_pic));
                ey.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ey.setDefaultBg(at.getDrawable(r.d.common_color_10220));
                addView(ey);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aHn);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aHm)) / max;
            int i4 = this.aHg > 0.0d ? (int) ((i3 * this.aHg) + 0.5d) : i3;
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
                int i6 = (this.aHm + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aHp) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aHp)) {
            canvas.drawText(this.aHp, (int) (i - (this.aGr.measureText(this.aHp) / 2.0f)), (this.aHq / 2) + i2, this.aGr);
        }
    }

    public void tB() {
        this.aGr.setColor(at.getColor(r.d.cp_cont_g));
        invalidate();
    }
}
