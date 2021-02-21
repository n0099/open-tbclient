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
/* loaded from: classes10.dex */
public class c extends a {
    private TbImageView feK;
    private ViewGroup gIH;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bSz();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gIH = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.feK = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.gAp);
        this.feK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.feK.setLayoutParams(layoutParams);
        this.gIH.addView(this.feK);
        this.mMaskView.setVisibility(8);
        this.gIH.addView(this.mMaskView);
        this.feK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.gIG.gGS)) {
                    bf.bsV().a(c.this.mTbPageContext, new String[]{c.this.gIG.gGS}, true);
                    com.baidu.tieba.ala.alasquare.b.a.bSe().c("c12909", c.this.gIG.gGU, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void mu(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.gGT || TextUtils.isEmpty(aVar.gGQ)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bSA() {
        super.bSA();
        if (this.feK != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.feK.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.gAp;
            this.feK.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gIH;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.feK.startLoad(aVar.gGQ, 10, false);
        com.baidu.tieba.ala.alasquare.b.a.bSe().c("c12908", this.gIG.gGU, 3, "-1");
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
        this.feK = null;
    }
}
