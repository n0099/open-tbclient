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
    private BdUniqueId ePv;
    private com.baidu.tieba.card.data.l hjK;
    private aa<bx> hyp;
    private u iXu;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hyp = new aa<bx>() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bx bxVar) {
                int i;
                com.baidu.tieba.card.data.l lVar = i.this.hjK;
                if (lVar != null && lVar.dUS != null && !StringUtils.isNull(lVar.dUS.getTid())) {
                    if (i.this.iXu.getHeaderImg() != null && view.getId() == i.this.iXu.getHeaderImg().getId()) {
                        i = 1;
                    } else if (i.this.iXu.cbD() != null && view.getId() == i.this.iXu.cbD().getId()) {
                        i = 1;
                    } else if (i.this.iXu.hla != null && view.getId() == i.this.iXu.hla.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).getTopicName();
                    String czJ = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).czJ();
                    bw bce = lVar.bce();
                    TiebaStatic.log(new aq("c12941").ai("obj_type", i).dD("tid", bce.getId()));
                    if ("c10814".equals(lVar.ccl())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10814").dD("tid", bce.getId()).dD("obj_name", topicName).dD("topic_id", czJ));
                    } else if ("c10816".equals(lVar.ccl())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10816").dD("post_id", bce.getTid()).dD("obj_name", topicName).dD("topic_id", czJ));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.ePv = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<u> b(ViewGroup viewGroup) {
        this.iXu = new u(this.mPageContext);
        this.iXu.p(this.ePv);
        this.iXu.ng(false);
        this.iXu.currentPageType = 0;
        if (this.iXu.gja != null) {
            this.iXu.gja.etW = 0;
        }
        if (this.iXu.hla != null) {
            this.iXu.hla.hlO = 0;
        }
        return new com.baidu.tieba.card.a.a<>(this.iXu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<u> aVar) {
        if (lVar == null || aVar == null || aVar.ccE() == null) {
            return null;
        }
        this.hjK = lVar;
        aVar.ccE().a(new bx(lVar.bce()));
        aVar.ccE().c(this.hyp);
        ((u) ((com.baidu.tieba.card.a.a) this.UO).ccE()).nl(!(getItem(i + 1) instanceof n));
        return aVar.getView();
    }
}
