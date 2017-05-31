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
public class p extends com.baidu.tieba.horizonalList.widget.m {
    private TbPageContext aas;
    public ClickableHeaderImageView bAg;
    public TextView bAh;
    public TextView bAi;
    public EntelechyUserLikeButton bAj;
    private com.baidu.tbadk.core.view.userLike.c bAk;
    private com.baidu.tieba.card.data.i bAl;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public p(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new q(this);
        this.aas = tbPageContext;
        this.bAg = (ClickableHeaderImageView) view.findViewById(w.h.rec_god_item_header);
        this.bAg.setGodIconMargin(w.f.ds6);
        this.bAh = (TextView) view.findViewById(w.h.rec_god_item_user_name);
        this.bAi = (TextView) view.findViewById(w.h.rec_god_item_user_describe);
        this.bAj = (EntelechyUserLikeButton) view.findViewById(w.h.rec_god_item_user_like_btn);
        this.bAk = new com.baidu.tbadk.core.view.userLike.c(this.aas, this.bAj);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public com.baidu.tieba.horizonalList.widget.m U(View view) {
        p pVar = new p(view, this.aas);
        pVar.bAk.i(this.uniqueId);
        return pVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public void a(com.baidu.tieba.horizonalList.widget.k kVar) {
        if (kVar instanceof com.baidu.tieba.card.data.i) {
            this.bAl = (com.baidu.tieba.card.data.i) kVar;
            if (this.bAl.author != null) {
                getView().setTag(w.h.rec_god_item_root, this.bAl.author.getUserId());
                this.bAg.setTag(w.h.rec_god_item_root, this.bAl.author.getUserId());
                this.bAj.setTag(this.bAl.author);
                this.bAg.setData(this.bAl.author);
                this.bAg.setAfterClickListener(this.asJ);
                this.bAh.setText(com.baidu.tbadk.core.util.au.s(this.bAl.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bAl.author.getGodUserData() != null) {
                    this.bAi.setText(com.baidu.tbadk.core.util.au.s(this.bAl.author.getGodUserData().getIntro(), 6));
                }
                this.bAk.a(this.bAl.author);
                onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.bAh, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.bAi, w.e.cp_cont_d);
            if (this.bAj != null) {
                this.bAj.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
