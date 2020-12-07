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
/* loaded from: classes6.dex */
public class c extends a {
    private TbImageView eXC;
    private ViewGroup gzk;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bTb();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gzk = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.eXC = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.gqX);
        this.eXC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eXC.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.eXC.setLayoutParams(layoutParams);
        this.gzk.addView(this.eXC);
        this.mMaskView.setVisibility(8);
        this.gzk.addView(this.mMaskView);
        this.eXC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.gzj.gxv)) {
                    bf.bua().a(c.this.mTbPageContext, new String[]{c.this.gzj.gxv}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bSG().c("c12909", c.this.gzj.gxx, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void lX(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.gxw || TextUtils.isEmpty(aVar.gxt)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bTc() {
        super.bTc();
        if (this.eXC != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eXC.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.gqX;
            this.eXC.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gzk;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.eXC.startLoad(aVar.gxt, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bSG().c("c12908", this.gzj.gxx, 3, "-1");
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
