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
    private TbPageContext aaY;
    private com.baidu.tbadk.core.view.userLike.c btP;
    public EntelechyUserLikeButton buA;
    private com.baidu.tieba.card.data.k buB;
    public ClickableHeaderImageView buw;
    public TextView bux;
    public TextView buz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public p(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new q(this);
        this.aaY = tbPageContext;
        this.buw = (ClickableHeaderImageView) view.findViewById(w.h.rec_god_item_header);
        this.buw.setGodIconMargin(w.f.ds6);
        this.bux = (TextView) view.findViewById(w.h.rec_god_item_user_name);
        this.buz = (TextView) view.findViewById(w.h.rec_god_item_user_describe);
        this.buA = (EntelechyUserLikeButton) view.findViewById(w.h.rec_god_item_user_like_btn);
        this.btP = new com.baidu.tbadk.core.view.userLike.c(this.aaY, this.buA);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n V(View view) {
        p pVar = new p(view, this.aaY);
        pVar.btP.i(this.uniqueId);
        return pVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar instanceof com.baidu.tieba.card.data.k) {
            this.buB = (com.baidu.tieba.card.data.k) lVar;
            if (this.buB.author != null) {
                getView().setTag(w.h.rec_god_item_root, this.buB.author.getUserId());
                this.buw.setTag(w.h.rec_god_item_root, this.buB.author.getUserId());
                this.buA.setTag(this.buB.author);
                this.buw.setData(this.buB.author);
                this.buw.setAfterClickListener(this.asV);
                this.bux.setText(com.baidu.tbadk.core.util.au.t(this.buB.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.buB.author.getGodUserData() != null) {
                    this.buz.setText(com.baidu.tbadk.core.util.au.t(this.buB.author.getGodUserData().getIntro(), 6));
                }
                this.btP.a(this.buB.author);
                onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bux, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.buz, w.e.cp_cont_d);
            if (this.buA != null) {
                this.buA.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
