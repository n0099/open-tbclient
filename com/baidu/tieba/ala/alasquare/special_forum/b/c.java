package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends a {
    private TbImageView eXC;
    private ViewGroup gzm;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        bTc();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void init() {
        this.gzm = new FrameLayout(this.mTbPageContext.getPageActivity());
        this.eXC = new TbImageView(this.mTbPageContext.getPageActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mScreenWidth, this.gqZ);
        this.eXC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eXC.setDefaultErrorResource(R.drawable.pic_live_ufan);
        this.eXC.setLayoutParams(layoutParams);
        this.gzm.addView(this.eXC);
        this.mMaskView.setVisibility(8);
        this.gzm.addView(this.mMaskView);
        this.eXC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.gzl.gxx)) {
                    bf.bua().a(c.this.mTbPageContext, new String[]{c.this.gzl.gxx}, true);
                    com.baidu.tieba.ala.alasquare.c.a.bSH().c("c12909", c.this.gzl.gxz, 3, "-1");
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void lX(boolean z) {
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        return (aVar == null || 3 != aVar.gxy || TextUtils.isEmpty(aVar.gxv)) ? false : true;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void bTd() {
        super.bTd();
        if (this.eXC != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eXC.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.gqZ;
            this.eXC.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public View getContentView() {
        return this.gzm;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.b.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        super.a(aVar);
        this.eXC.startLoad(aVar.gxv, 10, false);
        com.baidu.tieba.ala.alasquare.c.a.bSH().c("c12908", this.gzl.gxz, 3, "-1");
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
        this.eXC = null;
    }
}
