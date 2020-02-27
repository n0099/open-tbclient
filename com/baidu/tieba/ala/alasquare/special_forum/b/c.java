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
    private TbImageView ddz;
    private ViewGroup etb;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bds();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.etb = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.ddz = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.elb);
        this.ddz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ddz.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.ddz.setLayoutParams(layoutParams);
        this.etb.addView(this.ddz);
        this.mMaskView.setVisibility(8);
        this.etb.addView(this.mMaskView);
        this.ddz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.eta.erl)) {
                    ba.aGE().a(c.this.mTbPageContext, new String[]{c.this.eta.erl}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bcV().c("c12909", c.this.eta.ern, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hR(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.erm || TextUtils.isEmpty(aVar.erj)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bdt() {
        super.bdt();
        if (this.ddz != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ddz.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.elb;
            this.ddz.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.etb;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.ddz.startLoad(aVar.erj, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bcV().c("c12908", this.eta.ern, 3, "-1");
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
        this.ddz = null;
    }
}
