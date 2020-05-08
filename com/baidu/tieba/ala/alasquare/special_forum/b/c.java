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
    private TbImageView dDD;
    private ViewGroup eXm;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bmp();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.eXm = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.dDD = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.ePk);
        this.dDD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dDD.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.dDD.setLayoutParams(layoutParams);
        this.eXm.addView(this.dDD);
        this.mMaskView.setVisibility(8);
        this.eXm.addView(this.mMaskView);
        this.dDD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.eXl.eVx)) {
                    ba.aOV().a(c.this.mTbPageContext, new String[]{c.this.eXl.eVx}, true);
                    com.baidu.tieba.ala.alasquare.c.a.blS().c("c12909", c.this.eXl.eVz, 3, "-1");
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
        return (aVar == null || 3 != aVar.eVy || TextUtils.isEmpty(aVar.eVv)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bmq() {
        super.bmq();
        if (this.dDD != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dDD.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.ePk;
            this.dDD.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.eXm;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.dDD.startLoad(aVar.eVv, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.blS().c("c12908", this.eXl.eVz, 3, "-1");
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
        this.dDD = null;
    }
}
