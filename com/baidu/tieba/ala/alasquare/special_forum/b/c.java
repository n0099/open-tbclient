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
/* loaded from: classes2.dex */
public class c extends a {
    private TbImageView cZu;
    private ViewGroup eoR;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bbd();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.eoR = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.cZu = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.egX);
        this.cZu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cZu.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.cZu.setLayoutParams(layoutParams);
        this.eoR.addView(this.cZu);
        this.mMaskView.setVisibility(8);
        this.eoR.addView(this.mMaskView);
        this.cZu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.eoQ.emY)) {
                    ba.aEt().a(c.this.mTbPageContext, new String[]{c.this.eoQ.emY}, true);
                    com.baidu.tieba.ala.alasquare.c.a.baG().c("c12909", c.this.eoQ.ena, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hK(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.emZ || TextUtils.isEmpty(aVar.emW)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bbe() {
        super.bbe();
        if (this.cZu != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cZu.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.egX;
            this.cZu.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.eoR;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.cZu.startLoad(aVar.emW, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.baG().c("c12908", this.eoQ.ena, 3, "-1");
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
        this.cZu = null;
    }
}
