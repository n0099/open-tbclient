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
    private Paint aNH;
    private double aOC;
    private d aOD;
    private com.baidu.adp.lib.e.b<TbImageView> aOH;
    private int aOI;
    private int aOJ;
    private int aOK;
    private String aOL;
    private int aOM;
    private int aON;
    private int aOO;
    private ViewGroup.OnHierarchyChangeListener aOP;
    private BdUniqueId aOx;
    private boolean ajf;

    public b(Context context) {
        super(context);
        this.aOJ = -1;
        this.ajf = false;
        this.aOK = d.e.common_color_10082;
        this.aOM = 0;
        this.aOP = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.b.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && b.this.aOH != null) {
                    b.this.aOH.m((TbImageView) view2);
                }
            }
        };
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aOP);
        this.aNH = new Paint();
        this.aNH.setColor(aj.getColor(d.e.cp_cont_i));
        this.aNH.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize32));
        this.aNH.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aNH.getFontMetrics();
        this.aOM = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.aON = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
    }

    public void setImageClickListener(d dVar) {
        this.aOD = dVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aOH = bVar;
    }

    public void setFromCDN(boolean z) {
        this.ajf = z;
    }

    public void setForeColorId(int i) {
        this.aOK = i;
    }

    public void setExtraCenterText(String str) {
        this.aOL = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aOJ = i;
        } else {
            this.aOJ = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aOC = d;
    }

    public void a(List<String> list, int i, final boolean z) {
        int u;
        if (this.aOH != null && (u = v.u(list)) > 0) {
            fu(u);
            int childCount = getChildCount();
            int i2 = this.ajf ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    final boolean z2 = i3 == childCount + (-1);
                    if (this.aOD != null) {
                        final int i4 = i + i3;
                        tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.b.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (b.this.aOD != null) {
                                    b.this.aOD.c(view, i4, z && z2);
                                }
                            }
                        });
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(this.aOK));
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
        this.aOI = i;
    }

    private void fu(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fI = this.aOH.fI();
                fI.setContentDescription(getResources().getString(d.l.editor_image));
                fI.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fI.setDefaultBg(aj.getDrawable(d.e.common_color_10220));
                fI.setPageId(this.aOx);
                addView(fI);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aOJ);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aOI)) / max;
            int i4 = this.aOC > 0.0d ? (int) ((i3 * this.aOC) + 0.5d) : i3;
            if (this.aOO > 0) {
                i4 = this.aOO;
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
                int i6 = (this.aOI + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aOL) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aOL)) {
            float measureText = this.aNH.measureText(this.aOL);
            int g = k.g(getContext(), d.f.ds8);
            int i3 = (int) (i - (measureText / 2.0f));
            int i4 = ((this.aOM / 2) + i2) - this.aON;
            Bitmap cT = aj.cT(d.g.home_ic_pic);
            if (cT != null) {
                int width = cT.getWidth();
                int i5 = (int) (i - ((measureText + (width + g)) / 2.0f));
                canvas.drawBitmap(cT, i5, i2 - (cT.getHeight() / 2), (Paint) null);
                i3 = width + i5 + g;
            }
            canvas.drawText(this.aOL, i3, i4, this.aNH);
        }
    }

    public void onChangeSkinType() {
        this.aNH.setColor(aj.getColor(d.e.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.aOO = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOx = bdUniqueId;
    }
}
