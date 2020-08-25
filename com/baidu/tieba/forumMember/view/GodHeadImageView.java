package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class GodHeadImageView extends FrameLayout {
    private a hQo;
    private ImageView hQp;
    private int hQq;
    private int hQr;
    private int hQs;
    private int hQt;
    private int hQv;
    private int mRadius;
    private static final int aYz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int hQu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.hQq = 0;
        this.hQr = this.hQq;
        this.hQs = 1;
        this.hQt = this.hQs;
        this.hQv = aYz;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hQq = 0;
        this.hQr = this.hQq;
        this.hQs = 1;
        this.hQt = this.hQs;
        this.hQv = aYz;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hQq = 0;
        this.hQr = this.hQq;
        this.hQs = 1;
        this.hQt = this.hQs;
        this.hQv = aYz;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.hQv = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, aYz);
            this.hQt = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.hQs);
            this.hQr = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.hQq);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.hQo = new a(getContext());
        this.hQp = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.hQo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.hQo, layoutParams);
        addView(this.hQp, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.hQr = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.hQt = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.hQo.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.hQr) {
            case 0:
                this.hQo.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.hQo.setPadding(hQu, hQu, 0, 0);
                break;
        }
        switch (this.hQt) {
            case 1:
                this.hQo.setIsRound(true);
                if (this.hQr == 0) {
                    ap.setImageResource(this.hQp, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ap.setImageResource(this.hQp, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.hQo.setIsRound(false);
                this.hQo.setRadius(this.mRadius);
                ap.setImageResource(this.hQp, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.hQo.setIsRound(true);
                ap.setImageResource(this.hQp, R.drawable.browser_null_drawable);
                return;
            default:
                this.hQo.setIsRound(false);
                this.hQo.setRadius(this.mRadius);
                ap.setImageResource(this.hQp, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.hQv != i) {
            this.hQv = i;
            this.hQo.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.hQr == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.hQv, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.hQv, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
