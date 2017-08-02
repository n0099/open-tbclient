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
    private Paint aMI;
    private double aND;
    private d aNE;
    private com.baidu.adp.lib.e.b<TbImageView> aNI;
    private int aNJ;
    private int aNK;
    private int aNL;
    private String aNM;
    private int aNN;
    private int aNO;
    private int aNP;
    private ViewGroup.OnHierarchyChangeListener aNQ;
    private BdUniqueId aNy;
    private boolean aiq;

    public b(Context context) {
        super(context);
        this.aNK = -1;
        this.aiq = false;
        this.aNL = d.e.common_color_10082;
        this.aNN = 0;
        this.aNQ = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.layout.b.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof TbImageView) && b.this.aNI != null) {
                    b.this.aNI.n((TbImageView) view2);
                }
            }
        };
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aNQ);
        this.aMI = new Paint();
        this.aMI.setColor(ai.getColor(d.e.cp_cont_i));
        this.aMI.setTextSize(TbadkCoreApplication.getInst().getResources().getDimension(d.f.fontsize32));
        this.aMI.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aMI.getFontMetrics();
        this.aNN = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        this.aNO = ((int) (fontMetrics.ascent - fontMetrics.top)) + 4;
    }

    public void setImageClickListener(d dVar) {
        this.aNE = dVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.aNI = bVar;
    }

    public void setFromCDN(boolean z) {
        this.aiq = z;
    }

    public void setForeColorId(int i) {
        this.aNL = i;
    }

    public void setExtraCenterText(String str) {
        this.aNM = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aNK = i;
        } else {
            this.aNK = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void setSingleImageRatio(double d) {
        this.aND = d;
    }

    public void a(List<String> list, int i, final boolean z) {
        int u;
        if (this.aNI != null && (u = u.u(list)) > 0) {
            fs(u);
            int childCount = getChildCount();
            int i2 = this.aiq ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    final boolean z2 = i3 == childCount + (-1);
                    if (this.aNE != null) {
                        final int i4 = i + i3;
                        tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.layout.b.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (b.this.aNE != null) {
                                    b.this.aNE.c(view, i4, z && z2);
                                }
                            }
                        });
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.getInst().getResources().getColor(this.aNL));
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
        this.aNJ = i;
    }

    private void fs(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView fH = this.aNI.fH();
                fH.setContentDescription(getResources().getString(d.l.editor_image));
                fH.setScaleType(ImageView.ScaleType.CENTER_CROP);
                fH.setDefaultBg(ai.getDrawable(d.e.common_color_10220));
                fH.setPageId(this.aNy);
                addView(fH);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aNK);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aNJ)) / max;
            int i4 = this.aND > 0.0d ? (int) ((i3 * this.aND) + 0.5d) : i3;
            if (this.aNP > 0) {
                i4 = this.aNP;
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
                int i6 = (this.aNJ + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aNM) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            b(canvas, getMeasuredWidth() - (childAt.getMeasuredWidth() / 2), getMeasuredHeight() - (childAt.getMeasuredHeight() / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aNM)) {
            float measureText = this.aMI.measureText(this.aNM);
            int g = k.g(getContext(), d.f.ds8);
            int i3 = (int) (i - (measureText / 2.0f));
            int i4 = ((this.aNN / 2) + i2) - this.aNO;
            Bitmap cQ = ai.cQ(d.g.home_ic_pic);
            if (cQ != null) {
                int width = cQ.getWidth();
                int i5 = (int) (i - ((measureText + (width + g)) / 2.0f));
                canvas.drawBitmap(cQ, i5, i2 - (cQ.getHeight() / 2), (Paint) null);
                i3 = width + i5 + g;
            }
            canvas.drawText(this.aNM, i3, i4, this.aMI);
        }
    }

    public void onChangeSkinType() {
        this.aMI.setColor(ai.getColor(d.e.cp_cont_i));
        invalidate();
    }

    public void setFixedImageHeight(int i) {
        this.aNP = i;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aNy = bdUniqueId;
    }
}
