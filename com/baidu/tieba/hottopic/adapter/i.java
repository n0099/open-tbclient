package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.u;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
/* loaded from: classes20.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<u>> {
    private BdUniqueId eSq;
    private aa<bx> hFx;
    private com.baidu.tieba.card.data.l hqR;
    private u jgg;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hFx = new aa<bx>() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bx bxVar) {
                int i;
                com.baidu.tieba.card.data.l lVar = i.this.hqR;
                if (lVar != null && lVar.dXg != null && !StringUtils.isNull(lVar.dXg.getTid())) {
                    if (i.this.jgg.getHeaderImg() != null && view.getId() == i.this.jgg.getHeaderImg().getId()) {
                        i = 1;
                    } else if (i.this.jgg.ceT() != null && view.getId() == i.this.jgg.ceT().getId()) {
                        i = 1;
                    } else if (i.this.jgg.hsh != null && view.getId() == i.this.jgg.hsh.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).getTopicName();
                    String cDr = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).cDr();
                    bw bcY = lVar.bcY();
                    TiebaStatic.log(new aq("c12941").ai("obj_type", i).dF("tid", bcY.getId()));
                    if ("c10814".equals(lVar.cfB())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10814").dF("tid", bcY.getId()).dF("obj_name", topicName).dF("topic_id", cDr));
                    } else if ("c10816".equals(lVar.cfB())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10816").dF("post_id", bcY.getTid()).dF("obj_name", topicName).dF("topic_id", cDr));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eSq = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<u> c(ViewGroup viewGroup) {
        this.jgg = new u(this.mPageContext);
        this.jgg.o(this.eSq);
        this.jgg.no(false);
        this.jgg.currentPageType = 0;
        if (this.jgg.gml != null) {
            this.jgg.gml.ewe = 0;
        }
        if (this.jgg.hsh != null) {
            this.jgg.hsh.hsV = 0;
        }
        return new com.baidu.tieba.card.a.a<>(this.jgg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<u> aVar) {
        if (lVar == null || aVar == null || aVar.cfU() == null) {
            return null;
        }
        this.hqR = lVar;
        aVar.cfU().a(new bx(lVar.bcY()));
        aVar.cfU().c(this.hFx);
        ((u) ((com.baidu.tieba.card.a.a) this.Vh).cfU()).nt(!(getItem(i + 1) instanceof n));
        return aVar.getView();
    }
}
