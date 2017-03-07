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
    private TbPageContext aaI;
    private com.baidu.tbadk.core.view.userLike.c brF;
    public ClickableHeaderImageView bsm;
    public TextView bsn;
    public TextView bso;
    public EntelechyUserLikeButton bsp;
    private com.baidu.tieba.card.data.k bsq;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public p(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new q(this);
        this.aaI = tbPageContext;
        this.bsm = (ClickableHeaderImageView) view.findViewById(w.h.rec_god_item_header);
        this.bsm.setGodIconMargin(w.f.ds6);
        this.bsn = (TextView) view.findViewById(w.h.rec_god_item_user_name);
        this.bso = (TextView) view.findViewById(w.h.rec_god_item_user_describe);
        this.bsp = (EntelechyUserLikeButton) view.findViewById(w.h.rec_god_item_user_like_btn);
        this.brF = new com.baidu.tbadk.core.view.userLike.c(this.aaI, this.bsp);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n V(View view) {
        p pVar = new p(view, this.aaI);
        pVar.brF.i(this.uniqueId);
        return pVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar instanceof com.baidu.tieba.card.data.k) {
            this.bsq = (com.baidu.tieba.card.data.k) lVar;
            if (this.bsq.author != null) {
                getView().setTag(w.h.rec_god_item_root, this.bsq.author.getUserId());
                this.bsm.setTag(w.h.rec_god_item_root, this.bsq.author.getUserId());
                this.bsp.setTag(this.bsq.author);
                this.bsm.setData(this.bsq.author);
                this.bsm.setAfterClickListener(this.asD);
                this.bsn.setText(com.baidu.tbadk.core.util.au.t(this.bsq.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bsq.author.getGodUserData() != null) {
                    this.bso.setText(com.baidu.tbadk.core.util.au.t(this.bsq.author.getGodUserData().getIntro(), 6));
                }
                this.brF.a(this.bsq.author);
                onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i((View) this.bsn, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i((View) this.bso, w.e.cp_cont_d);
            if (this.bsp != null) {
                this.bsp.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
