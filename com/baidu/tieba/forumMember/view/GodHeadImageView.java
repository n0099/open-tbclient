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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class GodHeadImageView extends FrameLayout {
    private int dkA;
    private int dkC;
    private int dkD;
    private a dkv;
    private ImageView dkw;
    private int dkx;
    private int dky;
    private int dkz;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int dkB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.dkx = 0;
        this.dky = this.dkx;
        this.dkz = 1;
        this.dkA = this.dkz;
        this.dkC = DS6;
        this.dkD = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dkx = 0;
        this.dky = this.dkx;
        this.dkz = 1;
        this.dkA = this.dkz;
        this.dkC = DS6;
        this.dkD = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dkx = 0;
        this.dky = this.dkx;
        this.dkz = 1;
        this.dkA = this.dkz;
        this.dkC = DS6;
        this.dkD = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.GodHeadImageView);
            this.dkC = obtainStyledAttributes.getDimensionPixelSize(d.l.GodHeadImageView_extra_padding, DS6);
            this.dkA = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_shape_type, this.dkz);
            this.dky = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_show_type, this.dkx);
            this.dkD = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.dkv = new a(getContext());
        this.dkw = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dkv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dkv, layoutParams);
        addView(this.dkw, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.dky = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.dkA = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.dkv.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.dky) {
            case 0:
                this.dkv.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.dkv.setPadding(dkB, dkB, 0, 0);
                break;
        }
        switch (this.dkA) {
            case 1:
                this.dkv.setIsRound(true);
                if (this.dky == 0) {
                    am.c(this.dkw, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    am.c(this.dkw, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.dkv.setIsRound(false);
                this.dkv.setRadius(this.dkD);
                am.c(this.dkw, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.dkv.setIsRound(true);
                am.c(this.dkw, d.f.browser_null_drawable);
                return;
            default:
                this.dkv.setIsRound(false);
                this.dkv.setRadius(this.dkD);
                am.c(this.dkw, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.dkD = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.dkC != i) {
            this.dkC = i;
            this.dkv.invalidate();
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
            if (GodHeadImageView.this.dky == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.dkC, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.dkC, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
