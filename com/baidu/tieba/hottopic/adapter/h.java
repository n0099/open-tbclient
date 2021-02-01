package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.cc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.card.v;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
/* loaded from: classes8.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, CardViewHolder<v>> {
    private BdUniqueId fGZ;
    private ab<cc> iLO;
    private com.baidu.tieba.card.data.k iwW;
    private v ksF;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iLO = new ab<cc>() { // from class: com.baidu.tieba.hottopic.adapter.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, cc ccVar) {
                int i;
                com.baidu.tieba.card.data.k kVar = h.this.iwW;
                if (kVar != null && kVar.eJQ != null && !StringUtils.isNull(kVar.eJQ.getTid())) {
                    if (h.this.ksF.getHeaderImg() != null && view.getId() == h.this.ksF.getHeaderImg().getId()) {
                        i = 1;
                    } else if (h.this.ksF.crZ() != null && view.getId() == h.this.ksF.crZ().getId()) {
                        i = 1;
                    } else if (h.this.ksF.iyp != null && view.getId() == h.this.ksF.iyp.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) h.this.mPageContext.getOrignalPage()).getTopicName();
                    String cSS = ((HotTopicActivity) h.this.mPageContext.getOrignalPage()).cSS();
                    cb bln = kVar.bln();
                    TiebaStatic.log(new ar("c12941").ap("obj_type", i).dR("tid", bln.getId()));
                    if ("c10814".equals(kVar.csJ())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ar("c10814").dR("tid", bln.getId()).dR("obj_name", topicName).dR("topic_id", cSS));
                    } else if ("c10816".equals(kVar.csJ())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ar("c10816").dR("post_id", bln.getTid()).dR("obj_name", topicName).dR("topic_id", cSS));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fGZ = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<v> e(ViewGroup viewGroup) {
        this.ksF = new v(this.mPageContext);
        this.ksF.o(this.fGZ);
        this.ksF.px(false);
        this.ksF.currentPageType = 0;
        if (this.ksF.hng != null) {
            this.ksF.hng.fkw = 0;
        }
        if (this.ksF.iyp != null) {
            this.ksF.iyp.izg = 0;
        }
        return new CardViewHolder<>(this.ksF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, CardViewHolder<v> cardViewHolder) {
        if (kVar == null || cardViewHolder == null || cardViewHolder.ctb() == null) {
            return null;
        }
        this.iwW = kVar;
        cardViewHolder.ctb().a(new cc(kVar.bln()));
        cardViewHolder.ctb().c(this.iLO);
        ((v) ((CardViewHolder) this.Wo).ctb()).pC(!(getItem(i + 1) instanceof n));
        return cardViewHolder.getView();
    }
}
