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
/* loaded from: classes8.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, CardViewHolder<u>> {
    private BdUniqueId fJu;
    private aa<ca> iKM;
    private com.baidu.tieba.card.data.k ivZ;
    private u kpd;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iKM = new aa<ca>() { // from class: com.baidu.tieba.hottopic.adapter.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, ca caVar) {
                int i;
                com.baidu.tieba.card.data.k kVar = h.this.ivZ;
                if (kVar != null && kVar.eMv != null && !StringUtils.isNull(kVar.eMv.getTid())) {
                    if (h.this.kpd.getHeaderImg() != null && view.getId() == h.this.kpd.getHeaderImg().getId()) {
                        i = 1;
                    } else if (h.this.kpd.cuG() != null && view.getId() == h.this.kpd.cuG().getId()) {
                        i = 1;
                    } else if (h.this.kpd.ixo != null && view.getId() == h.this.kpd.ixo.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) h.this.mPageContext.getOrignalPage()).getTopicName();
                    String cUK = ((HotTopicActivity) h.this.mPageContext.getOrignalPage()).cUK();
                    bz boO = kVar.boO();
                    TiebaStatic.log(new aq("c12941").an("obj_type", i).dX("tid", boO.getId()));
                    if ("c10814".equals(kVar.cvo())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10814").dX("tid", boO.getId()).dX("obj_name", topicName).dX("topic_id", cUK));
                    } else if ("c10816".equals(kVar.cvo())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10816").dX("post_id", boO.getTid()).dX("obj_name", topicName).dX("topic_id", cUK));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fJu = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<u> e(ViewGroup viewGroup) {
        this.kpd = new u(this.mPageContext);
        this.kpd.o(this.fJu);
        this.kpd.pr(false);
        this.kpd.currentPageType = 0;
        if (this.kpd.hnz != null) {
            this.kpd.hnz.fmP = 0;
        }
        if (this.kpd.ixo != null) {
            this.kpd.ixo.iyd = 0;
        }
        return new CardViewHolder<>(this.kpd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, CardViewHolder<u> cardViewHolder) {
        if (kVar == null || cardViewHolder == null || cardViewHolder.cvG() == null) {
            return null;
        }
        this.ivZ = kVar;
        cardViewHolder.cvG().a(new ca(kVar.boO()));
        cardViewHolder.cvG().c(this.iKM);
        ((u) ((CardViewHolder) this.Wu).cvG()).pw(!(getItem(i + 1) instanceof n));
        return cardViewHolder.getView();
    }
}
