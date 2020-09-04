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
    private TbImageView eoz;
    private ViewGroup fLX;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bGV();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fLX = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.eoz = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.fDT);
        this.eoz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eoz.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.eoz.setLayoutParams(layoutParams);
        this.fLX.addView(this.eoz);
        this.mMaskView.setVisibility(8);
        this.fLX.addView(this.mMaskView);
        this.eoz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.fLW.fKi)) {
                    be.bju().a(c.this.mTbPageContext, new String[]{c.this.fLW.fKi}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bGy().c("c12909", c.this.fLW.fKk, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void kA(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.fKj || TextUtils.isEmpty(aVar.fKg)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bGW() {
        super.bGW();
        if (this.eoz != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eoz.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.fDT;
            this.eoz.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fLX;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.eoz.startLoad(aVar.fKg, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bGy().c("c12908", this.fLW.fKk, 3, "-1");
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
        this.eoz = null;
    }
}
