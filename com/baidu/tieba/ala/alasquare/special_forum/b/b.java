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
    private TbImageView eRm;
    private ViewGroup gru;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        bPX();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gru = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.eRm = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.gjh);
        this.eRm.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.eRm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eRm.setLayoutParams(layoutParams);
        this.gru.addView(this.eRm);
        this.mMaskView.setVisibility(8);
        this.gru.addView(this.mMaskView);
        this.eRm.setClickable(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void lB(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bPY() {
        super.bPY();
        if (this.eRm != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eRm.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.gjh;
            this.eRm.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gru;
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
        this.eRm = null;
    }
}
