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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class b extends ViewGroup {
    private Paint aNE;
    private d aOA;
    private com.baidu.adp.lib.e.b<TbImageView> aOE;
    private int aOF;
    private int aOG;
    private int aOH;
    private String aOI;
    private int aOJ;
    private int aOK;
    private int aOL;
    private ViewGroup.OnHierarchyChangeListener aOM;
    private BdUniqueId aOu;
    private double aOz;
    private boolean aje;

    public b(Context context) {
        super(context);
        this.aOG = -1;
        this.aje = false;
        this.aOH = d.e.common_color_10082;
        this.aOJ = 0;
        this.aOM = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.b.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && b.this.aOE != null) {
                    b.this.aOE.m((TbImageView) view2);
                }
            }
        };
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aOM);
        this.aNE = new Paint();
        this.aNE.setColor(aj.getColor(d.e.cp_cont_i));
        this.aNE.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize32));
        this.aNE.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aNE.getFontMetrics();
        this.aOJ = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.aOK = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
    }

    public void setImageClickListener(d dVar) {
        this.aOA = dVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aOE = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aje = z;
    }

    public void setForeColorId(int i) {
        this.aOH = i;
    }

    public void setExtraCenterText(String str) {
        this.aOI = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aOG = i;
        } else {
            this.aOG = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aOz = d;
    }

    public void a(List<String> list, int i, final boolean z) {
        int u;
        if (this.aOE != null && (u = v.u(list)) > 0) {
            fu(u);
            int childCount = getChildCount();
            int i2 = this.aje ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    final boolean z2 = i3 == childCount + (-1);
                    if (this.aOA != null) {
                        final int i4 = i + i3;
                        tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.b.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (b.this.aOA != null) {
                                    b.this.aOA.c(view, i4, z && z2);
                                }
                            }
                        });
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(this.aOH));
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
        this.aOF = i;
    }

    private void fu(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fI = this.aOE.fI();
                fI.setContentDescription(getResources().getString(d.l.editor_image));
                fI.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fI.setDefaultBg(aj.getDrawable(d.e.common_color_10220));
                fI.setPageId(this.aOu);
                addView(fI);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aOG);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aOF)) / max;
            int i4 = this.aOz > 0.0d ? (int) ((i3 * this.aOz) + 0.5d) : i3;
            if (this.aOL > 0) {
                i4 = this.aOL;
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
                int i6 = (this.aOF + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aOI) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aOI)) {
            float measureText = this.aNE.measureText(this.aOI);
            int f = k.f(getContext(), d.f.ds8);
            int i3 = (int) (i - (measureText / 2.0f));
            int i4 = ((this.aOJ / 2) + i2) - this.aOK;
            Bitmap cT = aj.cT(d.g.home_ic_pic);
            if (cT != null) {
                int width = cT.getWidth();
                int i5 = (int) (i - ((measureText + (width + f)) / 2.0f));
                canvas.drawBitmap(cT, i5, i2 - (cT.getHeight() / 2), (Paint) null);
                i3 = width + i5 + f;
            }
            canvas.drawText(this.aOI, i3, i4, this.aNE);
        }
    }

    public void onChangeSkinType() {
        this.aNE.setColor(aj.getColor(d.e.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.aOL = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOu = bdUniqueId;
    }
}
