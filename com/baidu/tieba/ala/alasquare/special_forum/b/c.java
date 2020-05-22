package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends a {
    private TbImageView dRP;
    private ViewGroup fjW;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        brN();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fjW = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.dRP = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.fbR);
        this.dRP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dRP.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.dRP.setLayoutParams(layoutParams);
        this.fjW.addView(this.dRP);
        this.mMaskView.setVisibility(8);
        this.fjW.addView(this.mMaskView);
        this.dRP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.fjV.fig)) {
                    ba.aUZ().a(c.this.mTbPageContext, new String[]{c.this.fjV.fig}, true);
                    com.baidu.tieba.ala.alasquare.c.a.brq().c("c12909", c.this.fjV.fii, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void jj(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.fih || TextUtils.isEmpty(aVar.fie)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void brO() {
        super.brO();
        if (this.dRP != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dRP.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.fbR;
            this.dRP.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fjW;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.dRP.startLoad(aVar.fie, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.brq().c("c12908", this.fjV.fii, 3, "-1");
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
