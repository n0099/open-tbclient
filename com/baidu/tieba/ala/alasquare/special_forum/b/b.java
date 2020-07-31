package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends a {
    private TbImageView eeU;
    private ViewGroup fAB;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        bxV();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fAB = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.eeU = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.fsv);
        this.eeU.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.eeU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eeU.setLayoutParams(layoutParams);
        this.fAB.addView(this.eeU);
        this.mMaskView.setVisibility(8);
        this.fAB.addView(this.mMaskView);
        this.eeU.setClickable(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void ka(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bxW() {
        super.bxW();
        if (this.eeU != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eeU.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.fsv;
            this.eeU.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fAB;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onChangeSkinType(int i) {
        if (1 == i) {
            this.mMaskView.setVisibility(0);
        } else {
            this.mMaskView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void startPlay() {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void stopPlay() {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void onDestroy() {
        this.eeU = null;
    }
}
