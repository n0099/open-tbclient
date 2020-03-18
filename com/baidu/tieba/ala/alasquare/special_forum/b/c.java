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
    private TbImageView dea;
    private ViewGroup etM;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bdA();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.etM = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.dea = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.elF);
        this.dea.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dea.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.dea.setLayoutParams(layoutParams);
        this.etM.addView(this.dea);
        this.mMaskView.setVisibility(8);
        this.etM.addView(this.mMaskView);
        this.dea.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.etL.erW)) {
                    ba.aGK().a(c.this.mTbPageContext, new String[]{c.this.etL.erW}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bdd().c("c12909", c.this.etL.erY, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hS(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.erX || TextUtils.isEmpty(aVar.erU)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bdB() {
        super.bdB();
        if (this.dea != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dea.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.elF;
            this.dea.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.etM;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.dea.startLoad(aVar.erU, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bdd().c("c12908", this.etL.erY, 3, "-1");
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
        this.dea = null;
    }
}
