package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class GodHeadImageView extends FrameLayout {
    private int dkA;
    private int dkB;
    private a dkt;
    private ImageView dku;
    private int dkv;
    private int dkw;
    private int dkx;
    private int dky;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds6);
    private static final int dkz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.dkv = 0;
        this.dkw = this.dkv;
        this.dkx = 1;
        this.dky = this.dkx;
        this.dkA = DS6;
        this.dkB = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dkv = 0;
        this.dkw = this.dkv;
        this.dkx = 1;
        this.dky = this.dkx;
        this.dkA = DS6;
        this.dkB = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dkv = 0;
        this.dkw = this.dkv;
        this.dkx = 1;
        this.dky = this.dkx;
        this.dkA = DS6;
        this.dkB = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.l.GodHeadImageView);
            this.dkA = obtainStyledAttributes.getDimensionPixelSize(f.l.GodHeadImageView_extra_padding, DS6);
            this.dky = obtainStyledAttributes.getInteger(f.l.GodHeadImageView_shape_type, this.dkx);
            this.dkw = obtainStyledAttributes.getInteger(f.l.GodHeadImageView_show_type, this.dkv);
            this.dkB = obtainStyledAttributes.getInteger(f.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.dkt = new a(getContext());
        this.dku = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dkt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dkt, layoutParams);
        addView(this.dku, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.dkw = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.dky = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.dkt.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.dkw) {
            case 0:
                this.dkt.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.dkt.setPadding(dkz, dkz, 0, 0);
                break;
        }
        switch (this.dky) {
            case 1:
                this.dkt.setIsRound(true);
                if (this.dkw == 0) {
                    am.c(this.dku, f.C0146f.pic_shen_avatar_big);
                    return;
                } else {
                    am.c(this.dku, f.C0146f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.dkt.setIsRound(false);
                this.dkt.setRadius(this.dkB);
                am.c(this.dku, f.C0146f.pic_frs_shen_avatar);
                return;
            case 3:
                this.dkt.setIsRound(true);
                am.c(this.dku, f.C0146f.browser_null_drawable);
                return;
            default:
                this.dkt.setIsRound(false);
                this.dkt.setRadius(this.dkB);
                am.c(this.dku, f.C0146f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.dkB = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.dkA != i) {
            this.dkA = i;
            this.dkt.invalidate();
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
            if (GodHeadImageView.this.dkw == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.dkA, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.dkA, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
