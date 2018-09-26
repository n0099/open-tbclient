package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class GodHeadImageView extends FrameLayout {
    private a dqm;
    private ImageView dqn;
    private int dqo;
    private int dqp;
    private int dqq;
    private int dqr;
    private int dqt;
    private int dqu;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds6);
    private static final int dqs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.dqo = 0;
        this.dqp = this.dqo;
        this.dqq = 1;
        this.dqr = this.dqq;
        this.dqt = DS6;
        this.dqu = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dqo = 0;
        this.dqp = this.dqo;
        this.dqq = 1;
        this.dqr = this.dqq;
        this.dqt = DS6;
        this.dqu = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dqo = 0;
        this.dqp = this.dqo;
        this.dqq = 1;
        this.dqr = this.dqq;
        this.dqt = DS6;
        this.dqu = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.l.GodHeadImageView);
            this.dqt = obtainStyledAttributes.getDimensionPixelSize(e.l.GodHeadImageView_extra_padding, DS6);
            this.dqr = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_shape_type, this.dqq);
            this.dqp = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_show_type, this.dqo);
            this.dqu = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.dqm = new a(getContext());
        this.dqn = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dqm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dqm, layoutParams);
        addView(this.dqn, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.dqp = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.dqr = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.dqm.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.dqp) {
            case 0:
                this.dqm.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.dqm.setPadding(dqs, dqs, 0, 0);
                break;
        }
        switch (this.dqr) {
            case 1:
                this.dqm.setIsRound(true);
                if (this.dqp == 0) {
                    al.c(this.dqn, e.f.pic_shen_avatar_big);
                    return;
                } else {
                    al.c(this.dqn, e.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.dqm.setIsRound(false);
                this.dqm.setRadius(this.dqu);
                al.c(this.dqn, e.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.dqm.setIsRound(true);
                al.c(this.dqn, e.f.browser_null_drawable);
                return;
            default:
                this.dqm.setIsRound(false);
                this.dqm.setRadius(this.dqu);
                al.c(this.dqn, e.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.dqu = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.dqt != i) {
            this.dqt = i;
            this.dqm.invalidate();
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
            if (GodHeadImageView.this.dqp == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.dqt, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.dqt, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
