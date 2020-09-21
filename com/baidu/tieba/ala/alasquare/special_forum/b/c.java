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
    private TbImageView eqP;
    private ViewGroup fPl;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bIl();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fPl = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.eqP = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.fHf);
        this.eqP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eqP.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.eqP.setLayoutParams(layoutParams);
        this.fPl.addView(this.eqP);
        this.mMaskView.setVisibility(8);
        this.fPl.addView(this.mMaskView);
        this.eqP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.fPk.fNw)) {
                    be.bkp().a(c.this.mTbPageContext, new String[]{c.this.fPk.fNw}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bHO().c("c12909", c.this.fPk.fNy, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void kC(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.fNx || TextUtils.isEmpty(aVar.fNu)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bIm() {
        super.bIm();
        if (this.eqP != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eqP.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.fHf;
            this.eqP.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fPl;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.eqP.startLoad(aVar.fNu, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bHO().c("c12908", this.fPk.fNy, 3, "-1");
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
        this.eqP = null;
    }
}
