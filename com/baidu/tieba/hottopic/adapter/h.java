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
/* loaded from: classes7.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, CardViewHolder<v>> {
    private BdUniqueId fIy;
    private ab<cc> iNL;
    private com.baidu.tieba.card.data.k iyT;
    private v kuV;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iNL = new ab<cc>() { // from class: com.baidu.tieba.hottopic.adapter.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, cc ccVar) {
                int i;
                com.baidu.tieba.card.data.k kVar = h.this.iyT;
                if (kVar != null && kVar.eLr != null && !StringUtils.isNull(kVar.eLr.getTid())) {
                    if (h.this.kuV.getHeaderImg() != null && view.getId() == h.this.kuV.getHeaderImg().getId()) {
                        i = 1;
                    } else if (h.this.kuV.csm() != null && view.getId() == h.this.kuV.csm().getId()) {
                        i = 1;
                    } else if (h.this.kuV.iAm != null && view.getId() == h.this.kuV.iAm.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) h.this.mPageContext.getOrignalPage()).getTopicName();
                    String cTg = ((HotTopicActivity) h.this.mPageContext.getOrignalPage()).cTg();
                    cb blp = kVar.blp();
                    TiebaStatic.log(new ar("c12941").aq("obj_type", i).dR("tid", blp.getId()));
                    if ("c10814".equals(kVar.csW())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ar("c10814").dR("tid", blp.getId()).dR("obj_name", topicName).dR("topic_id", cTg));
                    } else if ("c10816".equals(kVar.csW())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ar("c10816").dR("post_id", blp.getTid()).dR("obj_name", topicName).dR("topic_id", cTg));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fIy = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<v> e(ViewGroup viewGroup) {
        this.kuV = new v(this.mPageContext);
        this.kuV.o(this.fIy);
        this.kuV.px(false);
        this.kuV.currentPageType = 0;
        if (this.kuV.hpe != null) {
            this.kuV.hpe.flV = 0;
        }
        if (this.kuV.iAm != null) {
            this.kuV.iAm.iBd = 0;
        }
        return new CardViewHolder<>(this.kuV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, CardViewHolder<v> cardViewHolder) {
        if (kVar == null || cardViewHolder == null || cardViewHolder.cto() == null) {
            return null;
        }
        this.iyT = kVar;
        cardViewHolder.cto().a(new cc(kVar.blp()));
        cardViewHolder.cto().c(this.iNL);
        ((v) ((CardViewHolder) this.XI).cto()).pC(!(getItem(i + 1) instanceof n));
        return cardViewHolder.getView();
    }
}
