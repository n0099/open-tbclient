package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.horizonalList.widget.n {
    private TbPageContext aaX;
    private com.baidu.tbadk.core.view.userLike.c brx;
    public ClickableHeaderImageView bse;
    public TextView bsf;
    public TextView bsg;
    public EntelechyUserLikeButton bsh;
    private com.baidu.tieba.card.data.k bsi;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public p(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new q(this);
        this.aaX = tbPageContext;
        this.bse = (ClickableHeaderImageView) view.findViewById(w.h.rec_god_item_header);
        this.bse.setGodIconMargin(w.f.ds6);
        this.bsf = (TextView) view.findViewById(w.h.rec_god_item_user_name);
        this.bsg = (TextView) view.findViewById(w.h.rec_god_item_user_describe);
        this.bsh = (EntelechyUserLikeButton) view.findViewById(w.h.rec_god_item_user_like_btn);
        this.brx = new com.baidu.tbadk.core.view.userLike.c(this.aaX, this.bsh);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n V(View view) {
        p pVar = new p(view, this.aaX);
        pVar.brx.i(this.uniqueId);
        return pVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar instanceof com.baidu.tieba.card.data.k) {
            this.bsi = (com.baidu.tieba.card.data.k) lVar;
            if (this.bsi.author != null) {
                getView().setTag(w.h.rec_god_item_root, this.bsi.author.getUserId());
                this.bse.setTag(w.h.rec_god_item_root, this.bsi.author.getUserId());
                this.bsh.setTag(this.bsi.author);
                this.bse.setData(this.bsi.author);
                this.bse.setAfterClickListener(this.asT);
                this.bsf.setText(com.baidu.tbadk.core.util.au.t(this.bsi.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bsi.author.getGodUserData() != null) {
                    this.bsg.setText(com.baidu.tbadk.core.util.au.t(this.bsi.author.getGodUserData().getIntro(), 6));
                }
                this.brx.a(this.bsi.author);
                onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bsf, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.bsg, w.e.cp_cont_d);
            if (this.bsh != null) {
                this.bsh.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
