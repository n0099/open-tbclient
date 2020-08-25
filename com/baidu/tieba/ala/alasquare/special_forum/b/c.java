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
    private TbImageView eov;
    private ViewGroup fLT;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bGU();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fLT = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.eov = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.fDP);
        this.eov.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eov.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.eov.setLayoutParams(layoutParams);
        this.fLT.addView(this.eov);
        this.mMaskView.setVisibility(8);
        this.fLT.addView(this.mMaskView);
        this.eov.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.fLS.fKe)) {
                    be.bju().a(c.this.mTbPageContext, new String[]{c.this.fLS.fKe}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bGx().c("c12909", c.this.fLS.fKg, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void ky(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.fKf || TextUtils.isEmpty(aVar.fKc)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bGV() {
        super.bGV();
        if (this.eov != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eov.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.fDP;
            this.eov.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fLT;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.eov.startLoad(aVar.fKc, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bGx().c("c12908", this.fLS.fKg, 3, "-1");
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
        this.eov = null;
    }
}
