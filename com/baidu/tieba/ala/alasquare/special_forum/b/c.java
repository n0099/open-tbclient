package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends a {
    private TbImageView cmP;
    private ViewGroup dDu;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        aKl();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.dDu = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.cmP = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.dwC);
        this.cmP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cmP.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.cmP.setLayoutParams(layoutParams);
        this.dDu.addView(this.cmP);
        this.mMaskView.setVisibility(8);
        this.dDu.addView(this.mMaskView);
        this.cmP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.dDt.dBU)) {
                    ba.amQ().a(c.this.mTbPageContext, new String[]{c.this.dDt.dBU}, true);
                    com.baidu.tieba.ala.alasquare.c.a.aJO().c("c12909", c.this.dDt.dBW, 3, LivenessStat.TYPE_STRING_DEFAULT);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void gA(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.dBV || TextUtils.isEmpty(aVar.dBS)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void aKm() {
        super.aKm();
        if (this.cmP != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cmP.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.dwC;
            this.cmP.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.dDu;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.cmP.startLoad(aVar.dBS, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.aJO().c("c12908", this.dDt.dBW, 3, LivenessStat.TYPE_STRING_DEFAULT);
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
        this.cmP = null;
    }
}
