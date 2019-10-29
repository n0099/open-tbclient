package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b extends a {
    private TbImageView cmP;
    private ViewGroup dDu;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        aKl();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.dDu = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.cmP = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.dwC);
        this.cmP.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.cmP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cmP.setLayoutParams(layoutParams);
        this.dDu.addView(this.cmP);
        this.mMaskView.setVisibility(8);
        this.dDu.addView(this.mMaskView);
        this.cmP.setClickable(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void gA(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void aKm() {
        super.aKm();
        if (this.cmP != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cmP.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.dwC;
            this.cmP.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.dDu;
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
        this.cmP = null;
    }
}
