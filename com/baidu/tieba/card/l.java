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
public class l extends com.baidu.tieba.horizonalList.widget.m {
    private TbPageContext aat;
    public ClickableHeaderImageView bus;
    public TextView but;
    public TextView buu;
    public EntelechyUserLikeButton buv;
    private com.baidu.tbadk.core.view.userLike.c buw;
    private com.baidu.tieba.card.data.i bux;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public l(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new m(this);
        this.aat = tbPageContext;
        this.bus = (ClickableHeaderImageView) view.findViewById(w.h.rec_god_item_header);
        this.bus.setGodIconMargin(w.f.ds6);
        this.but = (TextView) view.findViewById(w.h.rec_god_item_user_name);
        this.buu = (TextView) view.findViewById(w.h.rec_god_item_user_describe);
        this.buv = (EntelechyUserLikeButton) view.findViewById(w.h.rec_god_item_user_like_btn);
        this.buw = new com.baidu.tbadk.core.view.userLike.c(this.aat, this.buv);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public com.baidu.tieba.horizonalList.widget.m U(View view) {
        l lVar = new l(view, this.aat);
        lVar.buw.i(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public void a(com.baidu.tieba.horizonalList.widget.k kVar) {
        if (kVar instanceof com.baidu.tieba.card.data.i) {
            this.bux = (com.baidu.tieba.card.data.i) kVar;
            if (this.bux.author != null) {
                getView().setTag(w.h.rec_god_item_root, this.bux.author.getUserId());
                this.bus.setTag(w.h.rec_god_item_root, this.bux.author.getUserId());
                this.buv.setTag(this.bux.author);
                this.bus.setData(this.bux.author);
                this.bus.setAfterClickListener(this.asZ);
                this.but.setText(com.baidu.tbadk.core.util.au.t(this.bux.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bux.author.getGodUserData() != null) {
                    this.buu.setText(com.baidu.tbadk.core.util.au.t(this.bux.author.getGodUserData().getIntro(), 6));
                }
                this.buw.a(this.bux.author);
                onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.m
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.i(this.but, w.e.cp_cont_b);
            com.baidu.tbadk.core.util.aq.i(this.buu, w.e.cp_cont_d);
            if (this.buv != null) {
                this.buv.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
