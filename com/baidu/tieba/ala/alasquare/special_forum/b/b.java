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
    private TbImageView eqP;
    private ViewGroup fPl;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        bIl();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fPl = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.eqP = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.fHf);
        this.eqP.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.eqP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eqP.setLayoutParams(layoutParams);
        this.fPl.addView(this.eqP);
        this.mMaskView.setVisibility(8);
        this.fPl.addView(this.mMaskView);
        this.eqP.setClickable(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void kC(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bIm() {
        super.bIm();
        if (this.eqP != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eqP.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.fHf;
            this.eqP.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fPl;
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
        this.eqP = null;
    }
}
