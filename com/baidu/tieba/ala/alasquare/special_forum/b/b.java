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
    private TbImageView dRP;
    private ViewGroup fkh;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        brP();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fkh = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.dRP = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.fcc);
        this.dRP.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.dRP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dRP.setLayoutParams(layoutParams);
        this.fkh.addView(this.dRP);
        this.mMaskView.setVisibility(8);
        this.fkh.addView(this.mMaskView);
        this.dRP.setClickable(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void jj(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void brQ() {
        super.brQ();
        if (this.dRP != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dRP.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.fcc;
            this.dRP.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fkh;
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
        this.dRP = null;
    }
}
