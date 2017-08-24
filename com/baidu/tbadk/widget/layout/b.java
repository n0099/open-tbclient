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
    private Paint aNY;
    private BdUniqueId aOO;
    private double aOT;
    private d aOU;
    private com.baidu.adp.lib.e.b<TbImageView> aOY;
    private int aOZ;
    private int aPa;
    private int aPb;
    private String aPc;
    private int aPd;
    private int aPe;
    private int aPf;
    private ViewGroup.OnHierarchyChangeListener aPg;
    private boolean ajL;

    public b(Context context) {
        super(context);
        this.aPa = -1;
        this.ajL = false;
        this.aPb = d.e.common_color_10082;
        this.aPd = 0;
        this.aPg = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.b.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && b.this.aOY != null) {
                    b.this.aOY.n((TbImageView) view2);
                }
            }
        };
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aPg);
        this.aNY = new Paint();
        this.aNY.setColor(ai.getColor(d.e.cp_cont_i));
        this.aNY.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize32));
        this.aNY.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aNY.getFontMetrics();
        this.aPd = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.aPe = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
    }

    public void setImageClickListener(d dVar) {
        this.aOU = dVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aOY = bVar;
    }

    public void setFromCDN(boolean z) {
        this.ajL = z;
    }

    public void setForeColorId(int i) {
        this.aPb = i;
    }

    public void setExtraCenterText(String str) {
        this.aPc = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aPa = i;
        } else {
            this.aPa = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aOT = d;
    }

    public void a(List<String> list, int i, final boolean z) {
        int u;
        if (this.aOY != null && (u = u.u(list)) > 0) {
            fu(u);
            int childCount = getChildCount();
            int i2 = this.ajL ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    final boolean z2 = i3 == childCount + (-1);
                    if (this.aOU != null) {
                        final int i4 = i + i3;
                        tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.b.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (b.this.aOU != null) {
                                    b.this.aOU.c(view, i4, z && z2);
                                }
                            }
                        });
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(this.aPb));
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
        this.aOZ = i;
    }

    private void fu(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fS = this.aOY.fS();
                fS.setContentDescription(getResources().getString(d.l.editor_image));
                fS.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fS.setDefaultBg(ai.getDrawable(d.e.common_color_10220));
                fS.setPageId(this.aOO);
                addView(fS);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aPa);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aOZ)) / max;
            int i4 = this.aOT > 0.0d ? (int) ((i3 * this.aOT) + 0.5d) : i3;
            if (this.aPf > 0) {
                i4 = this.aPf;
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
                int i6 = (this.aOZ + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aPc) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aPc)) {
            float measureText = this.aNY.measureText(this.aPc);
            int g = k.g(getContext(), d.f.ds8);
            int i3 = (int) (i - (measureText / 2.0f));
            int i4 = ((this.aPd / 2) + i2) - this.aPe;
            Bitmap cS = ai.cS(d.g.home_ic_pic);
            if (cS != null) {
                int width = cS.getWidth();
                int i5 = (int) (i - ((measureText + (width + g)) / 2.0f));
                canvas.drawBitmap(cS, i5, i2 - (cS.getHeight() / 2), (Paint) null);
                i3 = width + i5 + g;
            }
            canvas.drawText(this.aPc, i3, i4, this.aNY);
        }
    }

    public void onChangeSkinType() {
        this.aNY.setColor(ai.getColor(d.e.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.aPf = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOO = bdUniqueId;
    }
}
