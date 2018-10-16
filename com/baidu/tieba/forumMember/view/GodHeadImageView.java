package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class GodHeadImageView extends FrameLayout {
    private a dyn;
    private ImageView dyo;
    private int dyp;
    private int dyq;
    private int dyr;
    private int dys;
    private int dyu;
    private int dyv;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds6);
    private static final int dyt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.dyp = 0;
        this.dyq = this.dyp;
        this.dyr = 1;
        this.dys = this.dyr;
        this.dyu = DS6;
        this.dyv = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dyp = 0;
        this.dyq = this.dyp;
        this.dyr = 1;
        this.dys = this.dyr;
        this.dyu = DS6;
        this.dyv = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dyp = 0;
        this.dyq = this.dyp;
        this.dyr = 1;
        this.dys = this.dyr;
        this.dyu = DS6;
        this.dyv = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.l.GodHeadImageView);
            this.dyu = obtainStyledAttributes.getDimensionPixelSize(e.l.GodHeadImageView_extra_padding, DS6);
            this.dys = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_shape_type, this.dyr);
            this.dyq = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_show_type, this.dyp);
            this.dyv = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.dyn = new a(getContext());
        this.dyo = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dyn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dyn, layoutParams);
        addView(this.dyo, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.dyq = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.dys = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.dyn.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.dyq) {
            case 0:
                this.dyn.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.dyn.setPadding(dyt, dyt, 0, 0);
                break;
        }
        switch (this.dys) {
            case 1:
                this.dyn.setIsRound(true);
                if (this.dyq == 0) {
                    al.c(this.dyo, e.f.pic_shen_avatar_big);
                    return;
                } else {
                    al.c(this.dyo, e.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.dyn.setIsRound(false);
                this.dyn.setRadius(this.dyv);
                al.c(this.dyo, e.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.dyn.setIsRound(true);
                al.c(this.dyo, e.f.browser_null_drawable);
                return;
            default:
                this.dyn.setIsRound(false);
                this.dyn.setRadius(this.dyv);
                al.c(this.dyo, e.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.dyv = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.dyu != i) {
            this.dyu = i;
            this.dyn.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.dyq == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.dyu, AiAppsFileUtils.GB);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.dyu, AiAppsFileUtils.GB);
            }
            super.onMeasure(i, i2);
        }
    }
}
