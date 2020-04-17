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
    private TbImageView dDz;
    private ViewGroup eXh;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bmr();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.eXh = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.dDz = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.ePf);
        this.dDz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dDz.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.dDz.setLayoutParams(layoutParams);
        this.eXh.addView(this.dDz);
        this.mMaskView.setVisibility(8);
        this.eXh.addView(this.mMaskView);
        this.dDz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.eXg.eVs)) {
                    ba.aOY().a(c.this.mTbPageContext, new String[]{c.this.eXg.eVs}, true);
                    com.baidu.tieba.ala.alasquare.c.a.blU().c("c12909", c.this.eXg.eVu, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void iR(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.eVt || TextUtils.isEmpty(aVar.eVq)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bms() {
        super.bms();
        if (this.dDz != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dDz.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.ePf;
            this.dDz.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.eXh;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.dDz.startLoad(aVar.eVq, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.blU().c("c12908", this.eXg.eVu, 3, "-1");
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
        this.dDz = null;
    }
}
