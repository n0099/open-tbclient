package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.u;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
/* loaded from: classes8.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<u>> {
    private BdUniqueId eyE;
    private com.baidu.tieba.card.data.k gRm;
    private aa<bv> hfO;
    private u iCq;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hfO = new aa<bv>() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bv bvVar) {
                int i;
                com.baidu.tieba.card.data.k kVar = i.this.gRm;
                if (kVar != null && kVar.dLi != null && !StringUtils.isNull(kVar.dLi.getTid())) {
                    if (i.this.iCq.getHeaderImg() != null && view.getId() == i.this.iCq.getHeaderImg().getId()) {
                        i = 1;
                    } else if (i.this.iCq.bOh() != null && view.getId() == i.this.iCq.bOh().getId()) {
                        i = 1;
                    } else if (i.this.iCq.gSC != null && view.getId() == i.this.iCq.gSC.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).getTopicName();
                    String clq = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).clq();
                    bu aPS = kVar.aPS();
                    TiebaStatic.log(new ao("c12941").ag("obj_type", i).dk("tid", aPS.getId()));
                    if ("c10814".equals(kVar.bOO())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ao("c10814").dk("tid", aPS.getId()).dk("obj_name", topicName).dk("topic_id", clq));
                    } else if ("c10816".equals(kVar.bOO())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ao("c10816").dk("post_id", aPS.getTid()).dk("obj_name", topicName).dk("topic_id", clq));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eyE = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<u> b(ViewGroup viewGroup) {
        this.iCq = new u(this.mPageContext);
        this.iCq.o(this.eyE);
        this.iCq.lY(false);
        this.iCq.currentPageType = 0;
        if (this.iCq.fRI != null) {
            this.iCq.fRI.edR = 0;
        }
        if (this.iCq.gSC != null) {
            this.iCq.gSC.gTq = 0;
        }
        return new com.baidu.tieba.card.a.a<>(this.iCq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<u> aVar) {
        if (kVar == null || aVar == null || aVar.bPh() == null) {
            return null;
        }
        this.gRm = kVar;
        aVar.bPh().a(new bv(kVar.aPS()));
        aVar.bPh().c(this.hfO);
        ((u) ((com.baidu.tieba.card.a.a) this.Up).bPh()).md(!(getItem(i + 1) instanceof n));
        return aVar.getView();
    }
}
