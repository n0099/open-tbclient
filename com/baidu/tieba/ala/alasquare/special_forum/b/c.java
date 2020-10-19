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
    private TbImageView eDb;
    private ViewGroup gbD;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bKV();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gbD = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.eDb = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.fTo);
        this.eDb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eDb.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.eDb.setLayoutParams(layoutParams);
        this.gbD.addView(this.eDb);
        this.mMaskView.setVisibility(8);
        this.gbD.addView(this.mMaskView);
        this.eDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.gbC.fZN)) {
                    be.bmY().a(c.this.mTbPageContext, new String[]{c.this.gbC.fZN}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bKA().c("c12909", c.this.gbC.fZP, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void la(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.fZO || TextUtils.isEmpty(aVar.fZL)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bKW() {
        super.bKW();
        if (this.eDb != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eDb.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.fTo;
            this.eDb.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gbD;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.eDb.startLoad(aVar.fZL, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bKA().c("c12908", this.gbC.fZP, 3, "-1");
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
        this.eDb = null;
    }
}
