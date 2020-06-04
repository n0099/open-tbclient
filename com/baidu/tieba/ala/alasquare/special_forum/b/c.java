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
    private TbImageView dRP;
    private ViewGroup fkh;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        brP();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.fkh = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.dRP = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.fcc);
        this.dRP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dRP.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.dRP.setLayoutParams(layoutParams);
        this.fkh.addView(this.dRP);
        this.mMaskView.setVisibility(8);
        this.fkh.addView(this.mMaskView);
        this.dRP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.fkg.fir)) {
                    ba.aVa().a(c.this.mTbPageContext, new String[]{c.this.fkg.fir}, true);
                    com.baidu.tieba.ala.alasquare.c.a.brs().c("c12909", c.this.fkg.fit, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void jj(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.fis || TextUtils.isEmpty(aVar.fip)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void brQ() {
        super.brQ();
        if (this.dRP != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dRP.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.fcc;
            this.dRP.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.fkh;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.dRP.startLoad(aVar.fip, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.brs().c("c12908", this.fkg.fit, 3, "-1");
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
        this.dRP = null;
    }
}
