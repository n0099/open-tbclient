package com.baidu.tbadk.widget.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class c extends ViewGroup {
    private boolean ZM;
    private h aCU;
    private com.baidu.adp.lib.f.b<TbImageView> aCY;
    private int aCZ;
    private Paint aCf;
    private int aDa;
    private int aDb;
    private String aDc;
    private int aDd;
    private ViewGroup.OnHierarchyChangeListener aDe;

    public c(Context context) {
        super(context);
        this.aDa = -1;
        this.ZM = false;
        this.aDb = u.d.common_color_10082;
        this.aDd = 0;
        this.aDe = new d(this);
        init();
    }

    private void init() {
        setOnHierarchyChangeListener(this.aDe);
        this.aCf = new Paint();
        this.aCf.setColor(av.getColor(u.d.cp_cont_g));
        this.aCf.setTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(u.e.fontsize32));
        this.aCf.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.aCf.getFontMetrics();
        this.aDd = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public void setImageClickListener(h hVar) {
        this.aCU = hVar;
    }

    public void setImageViewObjectPool(com.baidu.adp.lib.f.b<TbImageView> bVar) {
        this.aCY = bVar;
    }

    public void setFromCDN(boolean z) {
        this.ZM = z;
    }

    public void setForeColorId(int i) {
        this.aDb = i;
    }

    public void setExtraCenterText(String str) {
        this.aDc = str;
    }

    public void setImageMaxChildCount(int i) {
        if (i > 0) {
            this.aDa = i;
        } else {
            this.aDa = -1;
        }
    }

    public void f(List<String> list, int i) {
        a(list, i, false);
    }

    public void a(List<String> list, int i, boolean z) {
        int s;
        if (this.aCY != null && (s = y.s(list)) > 0) {
            fd(s);
            int childCount = getChildCount();
            int i2 = this.ZM ? 13 : 14;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    boolean z2 = i3 == childCount + (-1);
                    if (this.aCU != null) {
                        tbImageView.setOnClickListener(new e(this, i + i3, z, z2));
                    }
                    if (z && z2) {
                        tbImageView.setForegroundColor(TbadkCoreApplication.m9getInst().getResources().getColor(this.aDb));
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
        this.aCZ = i;
    }

    private void fd(int i) {
        int childCount = getChildCount() - i;
        if (childCount > 0) {
            removeViews(i, childCount);
        } else if (childCount < 0) {
            int abs = Math.abs(childCount);
            for (int i2 = 0; i2 < abs; i2++) {
                TbImageView dE = this.aCY.dE();
                dE.setContentDescription(getResources().getString(u.j.log_msg_pic));
                dE.setScaleType(ImageView.ScaleType.CENTER_CROP);
                dE.setDefaultBg(av.getDrawable(u.d.common_color_10220));
                addView(dE);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (childCount > 0) {
            int max = Math.max(childCount, this.aDa);
            int size = View.MeasureSpec.getSize(i);
            int i3 = (size - ((max - 1) * this.aCZ)) / max;
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
                int i6 = (this.aCZ + measuredWidth) * i5;
                childAt.layout(i6, 0, measuredWidth + i6, i4 - i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int childCount;
        View childAt;
        super.dispatchDraw(canvas);
        if (!StringUtils.isNull(this.aDc) && (childCount = getChildCount()) > 0 && (childAt = getChildAt(childCount - 1)) != null) {
            int measuredWidth = childAt.getMeasuredWidth();
            b(canvas, getMeasuredWidth() - (measuredWidth / 2), getMeasuredHeight() - (measuredWidth / 2));
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aDc)) {
            canvas.drawText(this.aDc, (int) (i - (this.aCf.measureText(this.aDc) / 2.0f)), (this.aDd / 2) + i2, this.aCf);
        }
    }

    public void se() {
        this.aCf.setColor(av.getColor(u.d.cp_cont_g));
        invalidate();
    }
}
