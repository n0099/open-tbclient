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
    private TbPageContext aat;
    public ClickableHeaderImageView bAZ;
    public TextView bBa;
    public TextView bBb;
    public EntelechyUserLikeButton bBc;
    private com.baidu.tbadk.core.view.userLike.c bBd;
    private com.baidu.tieba.card.data.i bBe;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public p(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new q(this);
        this.aat = tbPageContext;
        this.bAZ = (ClickableHeaderImageView) view.findViewById(w.h.rec_god_item_header);
        this.bAZ.setGodIconMargin(w.f.ds6);
        this.bBa = (TextView) view.findViewById(w.h.rec_god_item_user_name);
        this.bBb = (TextView) view.findViewById(w.h.rec_god_item_user_describe);
        this.bBc = (EntelechyUserLikeButton) view.findViewById(w.h.rec_god_item_user_like_btn);
        this.bBd = new com.baidu.tbadk.core.view.userLike.c(this.aat, this.bBc);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public com.baidu.tieba.horizonalList.widget.m V(View view) {
        p pVar = new p(view, this.aat);
        pVar.bBd.i(this.uniqueId);
        return pVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public void a(com.baidu.tieba.horizonalList.widget.k kVar) {
        if (kVar instanceof com.baidu.tieba.card.data.i) {
            this.bBe = (com.baidu.tieba.card.data.i) kVar;
            if (this.bBe.author != null) {
                getView().setTag(w.h.rec_god_item_root, this.bBe.author.getUserId());
                this.bAZ.setTag(w.h.rec_god_item_root, this.bBe.author.getUserId());
                this.bBc.setTag(this.bBe.author);
                this.bAZ.setData(this.bBe.author);
                this.bAZ.setAfterClickListener(this.atM);
                this.bBa.setText(com.baidu.tbadk.core.util.aw.s(this.bBe.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bBe.author.getGodUserData() != null) {
                    this.bBb.setText(com.baidu.tbadk.core.util.aw.s(this.bBe.author.getGodUserData().getIntro(), 6));
                }
                this.bBd.a(this.bBe.author);
                onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.i(this.bBa, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.as.i(this.bBb, w.e.cp_cont_d);
            if (this.bBc != null) {
                this.bBc.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
