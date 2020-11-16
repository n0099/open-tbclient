package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends a {
    private TbImageView eQn;
    private ViewGroup grb;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bPq();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.grb = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.eQn = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.giO);
        this.eQn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eQn.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.eQn.setLayoutParams(layoutParams);
        this.grb.addView(this.eQn);
        this.mMaskView.setVisibility(8);
        this.grb.addView(this.mMaskView);
        this.eQn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.gra.gpm)) {
                    bf.bqF().a(c.this.mTbPageContext, new String[]{c.this.gra.gpm}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bOV().c("c12909", c.this.gra.gpo, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void lC(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.gpn || TextUtils.isEmpty(aVar.gpk)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bPr() {
        super.bPr();
        if (this.eQn != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eQn.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.giO;
            this.eQn.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.grb;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.eQn.startLoad(aVar.gpk, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bOV().c("c12908", this.gra.gpo, 3, "-1");
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
        this.eQn = null;
    }
}
