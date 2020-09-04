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
/* loaded from: classes15.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<u>> {
    private BdUniqueId ePz;
    private com.baidu.tieba.card.data.l hjO;
    private aa<bx> hyv;
    private u iXA;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hyv = new aa<bx>() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bx bxVar) {
                int i;
                com.baidu.tieba.card.data.l lVar = i.this.hjO;
                if (lVar != null && lVar.dUW != null && !StringUtils.isNull(lVar.dUW.getTid())) {
                    if (i.this.iXA.getHeaderImg() != null && view.getId() == i.this.iXA.getHeaderImg().getId()) {
                        i = 1;
                    } else if (i.this.iXA.cbE() != null && view.getId() == i.this.iXA.cbE().getId()) {
                        i = 1;
                    } else if (i.this.iXA.hle != null && view.getId() == i.this.iXA.hle.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).getTopicName();
                    String czK = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).czK();
                    bw bce = lVar.bce();
                    TiebaStatic.log(new aq("c12941").ai("obj_type", i).dD("tid", bce.getId()));
                    if ("c10814".equals(lVar.ccm())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10814").dD("tid", bce.getId()).dD("obj_name", topicName).dD("topic_id", czK));
                    } else if ("c10816".equals(lVar.ccm())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10816").dD("post_id", bce.getTid()).dD("obj_name", topicName).dD("topic_id", czK));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.ePz = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<u> b(ViewGroup viewGroup) {
        this.iXA = new u(this.mPageContext);
        this.iXA.p(this.ePz);
        this.iXA.ni(false);
        this.iXA.currentPageType = 0;
        if (this.iXA.gje != null) {
            this.iXA.gje.eua = 0;
        }
        if (this.iXA.hle != null) {
            this.iXA.hle.hlS = 0;
        }
        return new com.baidu.tieba.card.a.a<>(this.iXA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<u> aVar) {
        if (lVar == null || aVar == null || aVar.ccF() == null) {
            return null;
        }
        this.hjO = lVar;
        aVar.ccF().a(new bx(lVar.bce()));
        aVar.ccF().c(this.hyv);
        ((u) ((com.baidu.tieba.card.a.a) this.UO).ccF()).nn(!(getItem(i + 1) instanceof n));
        return aVar.getView();
    }
}
