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
    private TbImageView clX;
    private ViewGroup dCD;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        aKj();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.dCD = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.clX = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.dvL);
        this.clX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.clX.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.clX.setLayoutParams(layoutParams);
        this.dCD.addView(this.clX);
        this.mMaskView.setVisibility(8);
        this.dCD.addView(this.mMaskView);
        this.clX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.dCC.dBd)) {
                    ba.amO().a(c.this.mTbPageContext, new String[]{c.this.dCC.dBd}, true);
                    com.baidu.tieba.ala.alasquare.c.a.aJM().c("c12909", c.this.dCC.dBf, 3, LivenessStat.TYPE_STRING_DEFAULT);
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
        return (aVar == null || 3 != aVar.dBe || TextUtils.isEmpty(aVar.dBb)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void aKk() {
        super.aKk();
        if (this.clX != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.clX.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.dvL;
            this.clX.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.dCD;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.clX.startLoad(aVar.dBb, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.aJM().c("c12908", this.dCC.dBf, 3, LivenessStat.TYPE_STRING_DEFAULT);
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
        this.clX = null;
    }
}
