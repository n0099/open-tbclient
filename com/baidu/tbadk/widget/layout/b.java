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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class b extends ViewGroup {
    private Paint aNW;
    private BdUniqueId aOM;
    private double aOR;
    private d aOS;
    private com.baidu.adp.lib.e.b<TbImageView> aOW;
    private int aOX;
    private int aOY;
    private int aOZ;
    private String aPa;
    private int aPb;
    private int aPc;
    private int aPd;
    private ViewGroup.OnHierarchyChangeListener aPe;
    private boolean ajJ;

    public b(Context context) {
        super(context);
        this.aOY = -1;
        this.ajJ = false;
        this.aOZ = d.e.common_color_10082;
        this.aPb = 0;
        this.aPe = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.b.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && b.this.aOW != null) {
                    b.this.aOW.n((TbImageView) view2);
                }
            }
        };
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aPe);
        this.aNW = new Paint();
        this.aNW.setColor(ai.getColor(d.e.cp_cont_i));
        this.aNW.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize32));
        this.aNW.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aNW.getFontMetrics();
        this.aPb = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.aPc = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
    }

    public void setImageClickListener(d dVar) {
        this.aOS = dVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aOW = bVar;
    }

    public void setFromCDN(boolean z) {
        this.ajJ = z;
    }

    public void setForeColorId(int i) {
        this.aOZ = i;
    }

    public void setExtraCenterText(String str) {
        this.aPa = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aOY = i;
        } else {
            this.aOY = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aOR = d;
    }

    public void a(List<String> list, int i, final boolean z) {
        int u;
        if (this.aOW != null && (u = u.u(list)) > 0) {
            fu(u);
            int childCount = getChildCount();
            int i2 = this.ajJ ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    final boolean z2 = i3 == childCount + (-1);
                    if (this.aOS != null) {
                        final int i4 = i + i3;
                        tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.b.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (b.this.aOS != null) {
                                    b.this.aOS.c(view, i4, z && z2);
                                }
                            }
                        });
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(this.aOZ));
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
        this.aOX = i;
    }

    private void fu(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fS = this.aOW.fS();
                fS.setContentDescription(getResources().getString(d.l.editor_image));
                fS.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fS.setDefaultBg(ai.getDrawable(d.e.common_color_10220));
                fS.setPageId(this.aOM);
                addView(fS);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aOY);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aOX)) / max;
            int i4 = this.aOR > 0.0d ? (int) ((i3 * this.aOR) + 0.5d) : i3;
            if (this.aPd > 0) {
                i4 = this.aPd;
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
                int i6 = (this.aOX + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aPa) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aPa)) {
            float measureText = this.aNW.measureText(this.aPa);
            int g = k.g(getContext(), d.f.ds8);
            int i3 = (int) (i - (measureText / 2.0f));
            int i4 = ((this.aPb / 2) + i2) - this.aPc;
            Bitmap cS = ai.cS(d.g.home_ic_pic);
            if (cS != null) {
                int width = cS.getWidth();
                int i5 = (int) (i - ((measureText + (width + g)) / 2.0f));
                canvas.drawBitmap(cS, i5, i2 - (cS.getHeight() / 2), (Paint) null);
                i3 = width + i5 + g;
            }
            canvas.drawText(this.aPa, i3, i4, this.aNW);
        }
    }

    public void onChangeSkinType() {
        this.aNW.setColor(ai.getColor(d.e.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.aPd = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOM = bdUniqueId;
    }
}
