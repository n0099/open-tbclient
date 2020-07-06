package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends a {
    private TbImageView dYH;
    private ViewGroup fvu;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        buM();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fvu = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.dYH = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.fnm);
        this.dYH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dYH.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.dYH.setLayoutParams(layoutParams);
        this.fvu.addView(this.dYH);
        this.mMaskView.setVisibility(8);
        this.fvu.addView(this.mMaskView);
        this.dYH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.fvt.ftF)) {
                    bc.aWU().a(c.this.mTbPageContext, new String[]{c.this.fvt.ftF}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bup().c("c12909", c.this.fvt.ftH, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void jw(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.ftG || TextUtils.isEmpty(aVar.ftD)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void buN() {
        super.buN();
        if (this.dYH != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dYH.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.fnm;
            this.dYH.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fvu;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.dYH.startLoad(aVar.ftD, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bup().c("c12908", this.fvt.ftH, 3, "-1");
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
        this.dYH = null;
    }
}
