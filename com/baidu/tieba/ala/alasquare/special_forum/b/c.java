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
    private TbImageView ddN;
    private ViewGroup etq;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bdv();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.etq = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.ddN = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.elp);
        this.ddN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ddN.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.ddN.setLayoutParams(layoutParams);
        this.etq.addView(this.ddN);
        this.mMaskView.setVisibility(8);
        this.etq.addView(this.mMaskView);
        this.ddN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.etp.erA)) {
                    ba.aGG().a(c.this.mTbPageContext, new String[]{c.this.etp.erA}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bcY().c("c12909", c.this.etp.erC, 3, "-1");
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
        return (aVar == null || 3 != aVar.erB || TextUtils.isEmpty(aVar.ery)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bdw() {
        super.bdw();
        if (this.ddN != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ddN.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.elp;
            this.ddN.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.etq;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.ddN.startLoad(aVar.ery, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bcY().c("c12908", this.etp.erC, 3, "-1");
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
        this.ddN = null;
    }
}
