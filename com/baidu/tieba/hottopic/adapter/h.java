package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.card.u;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
/* loaded from: classes7.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, CardViewHolder<u>> {
    private BdUniqueId fEN;
    private aa<ca> iGf;
    private com.baidu.tieba.card.data.k irs;
    private u kky;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iGf = new aa<ca>() { // from class: com.baidu.tieba.hottopic.adapter.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, ca caVar) {
                int i;
                com.baidu.tieba.card.data.k kVar = h.this.irs;
                if (kVar != null && kVar.eHK != null && !StringUtils.isNull(kVar.eHK.getTid())) {
                    if (h.this.kky.getHeaderImg() != null && view.getId() == h.this.kky.getHeaderImg().getId()) {
                        i = 1;
                    } else if (h.this.kky.cqP() != null && view.getId() == h.this.kky.cqP().getId()) {
                        i = 1;
                    } else if (h.this.kky.isH != null && view.getId() == h.this.kky.isH.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) h.this.mPageContext.getOrignalPage()).getTopicName();
                    String cQT = ((HotTopicActivity) h.this.mPageContext.getOrignalPage()).cQT();
                    bz bkV = kVar.bkV();
                    TiebaStatic.log(new aq("c12941").an("obj_type", i).dW("tid", bkV.getId()));
                    if ("c10814".equals(kVar.crx())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10814").dW("tid", bkV.getId()).dW("obj_name", topicName).dW("topic_id", cQT));
                    } else if ("c10816".equals(kVar.crx())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10816").dW("post_id", bkV.getTid()).dW("obj_name", topicName).dW("topic_id", cQT));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fEN = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<u> e(ViewGroup viewGroup) {
        this.kky = new u(this.mPageContext);
        this.kky.o(this.fEN);
        this.kky.pn(false);
        this.kky.currentPageType = 0;
        if (this.kky.hiT != null) {
            this.kky.hiT.fie = 0;
        }
        if (this.kky.isH != null) {
            this.kky.isH.itw = 0;
        }
        return new CardViewHolder<>(this.kky);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, CardViewHolder<u> cardViewHolder) {
        if (kVar == null || cardViewHolder == null || cardViewHolder.crP() == null) {
            return null;
        }
        this.irs = kVar;
        cardViewHolder.crP().a(new ca(kVar.bkV()));
        cardViewHolder.crP().c(this.iGf);
        ((u) ((CardViewHolder) this.Ws).crP()).ps(!(getItem(i + 1) instanceof n));
        return cardViewHolder.getView();
    }
}
