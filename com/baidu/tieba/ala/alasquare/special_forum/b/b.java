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
    private TbImageView eXC;
    private ViewGroup gzm;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        bTc();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gzm = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.eXC = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.gqZ);
        this.eXC.setDefaultBgResource(R.drawable.pic_live_ufan);
        this.eXC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eXC.setLayoutParams(layoutParams);
        this.gzm.addView(this.eXC);
        this.mMaskView.setVisibility(8);
        this.gzm.addView(this.mMaskView);
        this.eXC.setClickable(false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void lX(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bTd() {
        super.bTd();
        if (this.eXC != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eXC.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.gqZ;
            this.eXC.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gzm;
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
        this.eXC = null;
    }
}
