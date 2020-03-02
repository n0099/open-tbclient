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
    private TbImageView ddA;
    private ViewGroup etd;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bdu();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.etd = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.ddA = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.elc);
        this.ddA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ddA.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.ddA.setLayoutParams(layoutParams);
        this.etd.addView(this.ddA);
        this.mMaskView.setVisibility(8);
        this.etd.addView(this.mMaskView);
        this.ddA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.etb.erm)) {
                    ba.aGG().a(c.this.mTbPageContext, new String[]{c.this.etb.erm}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bcX().c("c12909", c.this.etb.ero, 3, "-1");
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
        return (aVar == null || 3 != aVar.ern || TextUtils.isEmpty(aVar.erk)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bdv() {
        super.bdv();
        if (this.ddA != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ddA.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.elc;
            this.ddA.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.etd;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.ddA.startLoad(aVar.erk, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bcX().c("c12908", this.etb.ero, 3, "-1");
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
        this.ddA = null;
    }
}
