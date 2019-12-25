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
    private TbImageView cZk;
    private ViewGroup enD;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        baI();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.enD = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.cZk = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.egN);
        this.cZk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cZk.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.cZk.setLayoutParams(layoutParams);
        this.enD.addView(this.cZk);
        this.mMaskView.setVisibility(8);
        this.enD.addView(this.mMaskView);
        this.cZk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.enC.emb)) {
                    ba.aEa().a(c.this.mTbPageContext, new String[]{c.this.enC.emb}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bal().c("c12909", c.this.enC.emd, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void hF(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.emc || TextUtils.isEmpty(aVar.elZ)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void baJ() {
        super.baJ();
        if (this.cZk != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cZk.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.egN;
            this.cZk.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.enD;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.cZk.startLoad(aVar.elZ, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bal().c("c12908", this.enC.emd, 3, "-1");
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
        this.cZk = null;
    }
}
