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
/* loaded from: classes9.dex */
public class c extends a {
    private TbImageView fgj;
    private ViewGroup gKq;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bSF();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gKq = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.fgj = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.gBY);
        this.fgj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fgj.setLayoutParams(layoutParams);
        this.gKq.addView(this.fgj);
        this.mMaskView.setVisibility(8);
        this.gKq.addView(this.mMaskView);
        this.fgj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.gKp.gIB)) {
                    bf.bsY().a(c.this.mTbPageContext, new String[]{c.this.gKp.gIB}, true);
                    com.baidu.tieba.ala.alasquare.b.a.bSk().c("c12909", c.this.gKp.gID, 3, "-1");
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
        return (aVar == null || 3 != aVar.gIC || TextUtils.isEmpty(aVar.gIz)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bSG() {
        super.bSG();
        if (this.fgj != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fgj.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.gBY;
            this.fgj.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gKq;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.fgj.startLoad(aVar.gIz, 10, false);
        com.baidu.tieba.ala.alasquare.b.a.bSk().c("c12908", this.gKp.gID, 3, "-1");
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
        this.fgj = null;
    }
}
