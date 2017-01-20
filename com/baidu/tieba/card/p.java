package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.horizonalList.widget.n {
    private TbPageContext Fp;
    private com.baidu.tbadk.core.view.userLike.c bkN;
    public ClickableHeaderImageView blt;
    public TextView blu;
    public TextView blv;
    public EntelechyUserLikeButton blw;
    private com.baidu.tieba.card.data.k blx;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public p(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new q(this);
        this.Fp = tbPageContext;
        this.blt = (ClickableHeaderImageView) view.findViewById(r.h.rec_god_item_header);
        this.blt.setGodIconMargin(r.f.ds6);
        this.blu = (TextView) view.findViewById(r.h.rec_god_item_user_name);
        this.blv = (TextView) view.findViewById(r.h.rec_god_item_user_describe);
        this.blw = (EntelechyUserLikeButton) view.findViewById(r.h.rec_god_item_user_like_btn);
        this.bkN = new com.baidu.tbadk.core.view.userLike.c(this.Fp, this.blw);
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n X(View view) {
        return new p(view, this.Fp);
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar instanceof com.baidu.tieba.card.data.k) {
            this.blx = (com.baidu.tieba.card.data.k) lVar;
            if (this.blx.author != null) {
                getView().setTag(r.h.rec_god_item_root, this.blx.author.getUserId());
                this.blt.setTag(r.h.rec_god_item_root, this.blx.author.getUserId());
                this.blw.setTag(this.blx.author);
                this.blt.setData(this.blx.author);
                this.blt.setAfterClickListener(this.ani);
                this.blu.setText(com.baidu.tbadk.core.util.at.t(this.blx.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.blx.author.getGodUserData() != null) {
                    this.blv.setText(com.baidu.tbadk.core.util.at.t(this.blx.author.getGodUserData().getIntro(), 6));
                }
                this.bkN.a(this.blx.author);
                onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.i((View) this.blu, r.e.cp_cont_b);
            com.baidu.tbadk.core.util.ap.i((View) this.blv, r.e.cp_cont_d);
            if (this.blw != null) {
                this.blw.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
