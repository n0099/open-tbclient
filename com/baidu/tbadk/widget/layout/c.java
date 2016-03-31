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
    private Paint aFv;
    private com.baidu.adp.lib.f.b<TbImageView> aGB;
    private int aGC;
    private int aGD;
    private int aGE;
    private String aGF;
    private int aGG;
    private ViewGroup.OnHierarchyChangeListener aGH;
    private g aGx;
    private boolean adX;

    public c(Context context) {
        super(context);
        this.aGD = -1;
        this.adX = false;
        this.aGE = t.d.black_alpha30;
        this.aGG = 0;
        this.aGH = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aGH);
        this.aFv = new Paint();
        this.aFv.setColor(at.getColor(t.d.cp_cont_g));
        this.aFv.setTextSize(TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.fontsize32));
        this.aFv.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aFv.getFontMetrics();
        this.aGG = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public void setImageClickListener(g gVar) {
        this.aGx = gVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aGB = bVar;
    }

    public void setFromCDN(boolean z) {
        this.adX = z;
    }

    public void setForeColorId(int i) {
        this.aGE = i;
    }

    public void setExtraCenterText(String str) {
        this.aGF = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aGD = i;
        } else {
            this.aGD = -1;
        }
    }

    public void e(List<String> list, int i) {
        a(list, i, false);
    }

    public void a(List<String> list, int i, boolean z) {
        int p;
        if (this.aGB != null && (p = y.p(list)) > 0) {
            ft(p);
            int childCount = getChildCount();
            int i2 = this.adX ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aGx != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m411getInst().getResources().getColor(this.aGE));
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
        this.aGC = i;
    }

    private void ft(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView hp = this.aGB.hp();
                hp.setContentDescription(getResources().getString(t.j.log_msg_pic));
                hp.setScaleType(ImageView.ScaleType.CENTER_CROP);
                hp.setDefaultBg(at.getDrawable(t.d.pb_default_image_bg));
                addView(hp);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aGD);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aGC)) / max;
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
                int i6 = (this.aGC + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aGF) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            int measuredWidth = childAt.getMeasuredWidth();
            b(canvas, getMeasuredWidth() - (measuredWidth / 2), getMeasuredHeight() - (measuredWidth / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aGF)) {
            canvas.drawText(this.aGF, (int) (i - (this.aFv.measureText(this.aGF) / 2.0f)), (this.aGG / 2) + i2, this.aFv);
        }
    }

    public void uA() {
        this.aFv.setColor(at.getColor(t.d.cp_cont_g));
        invalidate();
    }
}
