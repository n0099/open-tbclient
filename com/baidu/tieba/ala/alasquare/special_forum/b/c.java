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
/* loaded from: classes9.dex */
public class c extends a {
    private TbImageView fcv;
    private ViewGroup gFJ;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bRP();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gFJ = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.fcv = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.gxr);
        this.fcv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fcv.setLayoutParams(layoutParams);
        this.gFJ.addView(this.fcv);
        this.mMaskView.setVisibility(8);
        this.gFJ.addView(this.mMaskView);
        this.fcv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.gFI.gDU)) {
                    be.bsB().a(c.this.mTbPageContext, new String[]{c.this.gFI.gDU}, true);
                    com.baidu.tieba.ala.alasquare.b.a.bRu().c("c12909", c.this.gFI.gDW, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void mq(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.gDV || TextUtils.isEmpty(aVar.gDS)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bRQ() {
        super.bRQ();
        if (this.fcv != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fcv.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.gxr;
            this.fcv.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gFJ;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.fcv.startLoad(aVar.gDS, 10, false);
        com.baidu.tieba.ala.alasquare.b.a.bRu().c("c12908", this.gFI.gDW, 3, "-1");
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
        this.fcv = null;
    }
}
