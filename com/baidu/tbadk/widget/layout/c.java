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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class c extends ViewGroup {
    private boolean Zv;
    private Paint aBF;
    private int aCA;
    private int aCB;
    private String aCC;
    private int aCD;
    private ViewGroup.OnHierarchyChangeListener aCE;
    private g aCu;
    private com.baidu.adp.lib.f.b<TbImageView> aCy;
    private int aCz;

    public c(Context context) {
        super(context);
        this.aCA = -1;
        this.Zv = false;
        this.aCB = t.d.black_alpha30;
        this.aCD = 0;
        this.aCE = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aCE);
        this.aBF = new Paint();
        this.aBF.setColor(at.getColor(t.d.cp_cont_g));
        this.aBF.setTextSize(TbadkCoreApplication.m11getInst().getResources().getDimension(t.e.fontsize32));
        this.aBF.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aBF.getFontMetrics();
        this.aCD = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public void setImageClickListener(g gVar) {
        this.aCu = gVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aCy = bVar;
    }

    public void setFromCDN(boolean z) {
        this.Zv = z;
    }

    public void setForeColorId(int i) {
        this.aCB = i;
    }

    public void setExtraCenterText(String str) {
        this.aCC = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aCA = i;
        } else {
            this.aCA = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void a(List<String> list, int i, boolean z) {
        int r;
        if (this.aCy != null && (r = y.r(list)) > 0) {
            eY(r);
            int childCount = getChildCount();
            int i2 = this.Zv ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aCu != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m11getInst().getResources().getColor(this.aCB));
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
        this.aCz = i;
    }

    private void eY(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView dD = this.aCy.dD();
                dD.setContentDescription(getResources().getString(t.j.log_msg_pic));
                dD.setScaleType(ImageView.ScaleType.CENTER_CROP);
                dD.setDefaultBg(at.getDrawable(t.d.pb_default_image_bg));
                addView(dD);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aCA);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aCz)) / max;
            setMeasuredDimension(size, i3);
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != null) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
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
                int i6 = (this.aCz + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aCC) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            int measuredWidth = childAt.getMeasuredWidth();
            b(canvas, getMeasuredWidth() - (measuredWidth / 2), getMeasuredHeight() - (measuredWidth / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aCC)) {
            canvas.drawText(this.aCC, (int) (i - (this.aBF.measureText(this.aCC) / 2.0f)), (this.aCD / 2) + i2, this.aBF);
        }
    }

    public void sf() {
        this.aBF.setColor(at.getColor(t.d.cp_cont_g));
        invalidate();
    }
}
