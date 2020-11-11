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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.v;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
/* loaded from: classes21.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<v>> {
    private BdUniqueId fsQ;
    private com.baidu.tieba.card.data.l hYf;
    private ab<bx> imQ;
    private v jNC;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.imQ = new ab<bx>() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bx bxVar) {
                int i;
                com.baidu.tieba.card.data.l lVar = i.this.hYf;
                if (lVar != null && lVar.exA != null && !StringUtils.isNull(lVar.exA.getTid())) {
                    if (i.this.jNC.getHeaderImg() != null && view.getId() == i.this.jNC.getHeaderImg().getId()) {
                        i = 1;
                    } else if (i.this.jNC.cnX() != null && view.getId() == i.this.jNC.cnX().getId()) {
                        i = 1;
                    } else if (i.this.jNC.hZv != null && view.getId() == i.this.jNC.hZv.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).getTopicName();
                    String cMI = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).cMI();
                    bw bjZ = lVar.bjZ();
                    TiebaStatic.log(new aq("c12941").al("obj_type", i).dR("tid", bjZ.getId()));
                    if ("c10814".equals(lVar.coF())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10814").dR("tid", bjZ.getId()).dR("obj_name", topicName).dR("topic_id", cMI));
                    } else if ("c10816".equals(lVar.coF())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10816").dR("post_id", bjZ.getTid()).dR("obj_name", topicName).dR("topic_id", cMI));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fsQ = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<v> c(ViewGroup viewGroup) {
        this.jNC = new v(this.mPageContext);
        this.jNC.o(this.fsQ);
        this.jNC.ou(false);
        this.jNC.currentPageType = 0;
        if (this.jNC.gSR != null) {
            this.jNC.gSR.eWz = 0;
        }
        if (this.jNC.hZv != null) {
            this.jNC.hZv.iaj = 0;
        }
        return new com.baidu.tieba.card.a.a<>(this.jNC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<v> aVar) {
        if (lVar == null || aVar == null || aVar.coY() == null) {
            return null;
        }
        this.hYf = lVar;
        aVar.coY().a(new bx(lVar.bjZ()));
        aVar.coY().c(this.imQ);
        ((v) ((com.baidu.tieba.card.a.a) this.Vy).coY()).oz(!(getItem(i + 1) instanceof n));
        return aVar.getView();
    }
}
