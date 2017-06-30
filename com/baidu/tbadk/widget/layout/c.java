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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class c extends ViewGroup {
    private Paint aLA;
    private int aMA;
    private int aMB;
    private int aMC;
    private String aMD;
    private int aME;
    private int aMF;
    private int aMG;
    private ViewGroup.OnHierarchyChangeListener aMH;
    private BdUniqueId aMp;
    private double aMu;
    private g aMv;
    private com.baidu.adp.lib.e.b<TbImageView> aMz;
    private boolean ahU;

    public c(Context context) {
        super(context);
        this.aMB = -1;
        this.ahU = false;
        this.aMC = w.e.common_color_10082;
        this.aME = 0;
        this.aMH = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aMH);
        this.aLA = new Paint();
        this.aLA.setColor(as.getColor(w.e.cp_cont_i));
        this.aLA.setTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.fontsize32));
        this.aLA.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aLA.getFontMetrics();
        this.aME = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.aMF = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
    }

    public void setImageClickListener(g gVar) {
        this.aMv = gVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aMz = bVar;
    }

    public void setFromCDN(boolean z) {
        this.ahU = z;
    }

    public void setForeColorId(int i) {
        this.aMC = i;
    }

    public void setExtraCenterText(String str) {
        this.aMD = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aMB = i;
        } else {
            this.aMB = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aMu = d;
    }

    public void a(List<String> list, int i, boolean z) {
        int s;
        if (this.aMz != null && (s = z.s(list)) > 0) {
            fp(s);
            int childCount = getChildCount();
            int i2 = this.ahU ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aMv != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m9getInst().getResources().getColor(this.aMC));
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
        this.aMA = i;
    }

    private void fp(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fJ = this.aMz.fJ();
                fJ.setContentDescription(getResources().getString(w.l.editor_image));
                fJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fJ.setDefaultBg(as.getDrawable(w.e.common_color_10220));
                fJ.setPageId(this.aMp);
                addView(fJ);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aMB);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aMA)) / max;
            int i4 = this.aMu > 0.0d ? (int) ((i3 * this.aMu) + 0.5d) : i3;
            if (this.aMG > 0) {
                i4 = this.aMG;
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
                int i6 = (this.aMA + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aMD) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aMD)) {
            float measureText = this.aLA.measureText(this.aMD);
            int g = k.g(getContext(), w.f.ds8);
            int i3 = (int) (i - (measureText / 2.0f));
            int i4 = ((this.aME / 2) + i2) - this.aMF;
            Bitmap cO = as.cO(w.g.home_ic_pic);
            if (cO != null) {
                int width = cO.getWidth();
                int i5 = (int) (i - ((measureText + (width + g)) / 2.0f));
                canvas.drawBitmap(cO, i5, i2 - (cO.getHeight() / 2), (Paint) null);
                i3 = width + i5 + g;
            }
            canvas.drawText(this.aMD, i3, i4, this.aLA);
        }
    }

    public void onChangeSkinType() {
        this.aLA.setColor(as.getColor(w.e.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.aMG = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aMp = bdUniqueId;
    }
}
