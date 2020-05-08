package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends a {
    private TbImageView dDD;
    private ViewGroup eXm;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        bmp();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.eXm = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.dDD = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.ePk);
        this.dDD.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.dDD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dDD.setLayoutParams(layoutParams);
        this.eXm.addView(this.dDD);
        this.mMaskView.setVisibility(8);
        this.eXm.addView(this.mMaskView);
        this.dDD.setClickable(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void iR(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bmq() {
        super.bmq();
        if (this.dDD != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dDD.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.ePk;
            this.dDD.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.eXm;
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
        this.dDD = null;
    }
}
