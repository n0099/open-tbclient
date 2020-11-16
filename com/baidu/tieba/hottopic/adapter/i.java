package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.v;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
/* loaded from: classes20.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<v>> {
    private BdUniqueId fsa;
    private com.baidu.tieba.card.data.k hYF;
    private ab<by> inF;
    private v jOm;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.inF = new ab<by>() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, by byVar) {
                int i;
                com.baidu.tieba.card.data.k kVar = i.this.hYF;
                if (kVar != null && kVar.evQ != null && !StringUtils.isNull(kVar.evQ.getTid())) {
                    if (i.this.jOm.getHeaderImg() != null && view.getId() == i.this.jOm.getHeaderImg().getId()) {
                        i = 1;
                    } else if (i.this.jOm.cnz() != null && view.getId() == i.this.jOm.cnz().getId()) {
                        i = 1;
                    } else if (i.this.jOm.hZV != null && view.getId() == i.this.jOm.hZV.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).getTopicName();
                    String cMp = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).cMp();
                    bx bjd = kVar.bjd();
                    TiebaStatic.log(new ar("c12941").ak("obj_type", i).dR("tid", bjd.getId()));
                    if ("c10814".equals(kVar.coh())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ar("c10814").dR("tid", bjd.getId()).dR("obj_name", topicName).dR("topic_id", cMp));
                    } else if ("c10816".equals(kVar.coh())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ar("c10816").dR("post_id", bjd.getTid()).dR("obj_name", topicName).dR("topic_id", cMp));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fsa = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<v> c(ViewGroup viewGroup) {
        this.jOm = new v(this.mPageContext);
        this.jOm.o(this.fsa);
        this.jOm.ox(false);
        this.jOm.currentPageType = 0;
        if (this.jOm.gSy != null) {
            this.jOm.gSy.eVJ = 0;
        }
        if (this.jOm.hZV != null) {
            this.jOm.hZV.iaK = 0;
        }
        return new com.baidu.tieba.card.a.a<>(this.jOm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<v> aVar) {
        if (kVar == null || aVar == null || aVar.coz() == null) {
            return null;
        }
        this.hYF = kVar;
        aVar.coz().a(new by(kVar.bjd()));
        aVar.coz().c(this.inF);
        ((v) ((com.baidu.tieba.card.a.a) this.Vz).coz()).oC(!(getItem(i + 1) instanceof n));
        return aVar.getView();
    }
}
