package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends a {
    private TbImageView fhd;
    private ViewGroup gKp;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        bVG();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gKp = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.fhd = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.gBY);
        this.fhd.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.fhd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fhd.setLayoutParams(layoutParams);
        this.gKp.addView(this.fhd);
        this.mMaskView.setVisibility(8);
        this.gKp.addView(this.mMaskView);
        this.fhd.setClickable(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void mu(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bVH() {
        super.bVH();
        if (this.fhd != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fhd.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.gBY;
            this.fhd.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gKp;
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
        this.fhd = null;
    }
}
