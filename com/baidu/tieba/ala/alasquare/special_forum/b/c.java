package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends a {
    private TbImageView eLx;
    private ViewGroup glH;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bNx();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.glH = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.eLx = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.gdr);
        this.eLx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eLx.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.eLx.setLayoutParams(layoutParams);
        this.glH.addView(this.eLx);
        this.mMaskView.setVisibility(8);
        this.glH.addView(this.mMaskView);
        this.eLx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.glG.gjS)) {
                    be.boR().a(c.this.mTbPageContext, new String[]{c.this.glG.gjS}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bNc().c("c12909", c.this.glG.gjU, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void ls(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.gjT || TextUtils.isEmpty(aVar.gjQ)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bNy() {
        super.bNy();
        if (this.eLx != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eLx.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.gdr;
            this.eLx.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.glH;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.eLx.startLoad(aVar.gjQ, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bNc().c("c12908", this.glG.gjU, 3, "-1");
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
        this.eLx = null;
    }
}
