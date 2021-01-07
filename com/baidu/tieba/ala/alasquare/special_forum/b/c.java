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
/* loaded from: classes10.dex */
public class c extends a {
    private TbImageView fhd;
    private ViewGroup gKp;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bVH();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gKp = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.fhd = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.gBY);
        this.fhd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fhd.setLayoutParams(layoutParams);
        this.gKp.addView(this.fhd);
        this.mMaskView.setVisibility(8);
        this.gKp.addView(this.mMaskView);
        this.fhd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.gKo.gIA)) {
                    be.bwv().a(c.this.mTbPageContext, new String[]{c.this.gKo.gIA}, true);
                    com.baidu.tieba.ala.alasquare.b.a.bVm().c("c12909", c.this.gKo.gIC, 3, "-1");
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
        return (aVar == null || 3 != aVar.gIB || TextUtils.isEmpty(aVar.gIy)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bVI() {
        super.bVI();
        if (this.fhd != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fhd.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.gBY;
            this.fhd.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gKp;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.fhd.startLoad(aVar.gIy, 10, false);
        com.baidu.tieba.ala.alasquare.b.a.bVm().c("c12908", this.gKo.gIC, 3, "-1");
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
        this.fhd = null;
    }
}
