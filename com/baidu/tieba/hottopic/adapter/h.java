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
    private ab<cc> iMc;
    private com.baidu.tieba.card.data.k ixk;
    private v ksT;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iMc = new ab<cc>() { // from class: com.baidu.tieba.hottopic.adapter.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, cc ccVar) {
                int i;
                com.baidu.tieba.card.data.k kVar = h.this.ixk;
                if (kVar != null && kVar.eJQ != null && !StringUtils.isNull(kVar.eJQ.getTid())) {
                    if (h.this.ksT.getHeaderImg() != null && view.getId() == h.this.ksT.getHeaderImg().getId()) {
                        i = 1;
                    } else if (h.this.ksT.csg() != null && view.getId() == h.this.ksT.csg().getId()) {
                        i = 1;
                    } else if (h.this.ksT.iyD != null && view.getId() == h.this.ksT.iyD.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) h.this.mPageContext.getOrignalPage()).getTopicName();
                    String cSZ = ((HotTopicActivity) h.this.mPageContext.getOrignalPage()).cSZ();
                    cb bln = kVar.bln();
                    TiebaStatic.log(new ar("c12941").ap("obj_type", i).dR("tid", bln.getId()));
                    if ("c10814".equals(kVar.csQ())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ar("c10814").dR("tid", bln.getId()).dR("obj_name", topicName).dR("topic_id", cSZ));
                    } else if ("c10816".equals(kVar.csQ())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ar("c10816").dR("post_id", bln.getTid()).dR("obj_name", topicName).dR("topic_id", cSZ));
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
        this.ksT = new v(this.mPageContext);
        this.ksT.o(this.fGZ);
        this.ksT.px(false);
        this.ksT.currentPageType = 0;
        if (this.ksT.hnu != null) {
            this.ksT.hnu.fkw = 0;
        }
        if (this.ksT.iyD != null) {
            this.ksT.iyD.izu = 0;
        }
        return new CardViewHolder<>(this.ksT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, CardViewHolder<v> cardViewHolder) {
        if (kVar == null || cardViewHolder == null || cardViewHolder.cti() == null) {
            return null;
        }
        this.ixk = kVar;
        cardViewHolder.cti().a(new cc(kVar.bln()));
        cardViewHolder.cti().c(this.iMc);
        ((v) ((CardViewHolder) this.Wo).cti()).pC(!(getItem(i + 1) instanceof n));
        return cardViewHolder.getView();
    }
}
