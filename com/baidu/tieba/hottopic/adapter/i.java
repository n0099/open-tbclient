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
/* loaded from: classes21.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<u>> {
    private BdUniqueId fey;
    private com.baidu.tieba.card.data.l hFL;
    private aa<bx> hUs;
    private u jvf;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hUs = new aa<bx>() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bx bxVar) {
                int i;
                com.baidu.tieba.card.data.l lVar = i.this.hFL;
                if (lVar != null && lVar.eji != null && !StringUtils.isNull(lVar.eji.getTid())) {
                    if (i.this.jvf.getHeaderImg() != null && view.getId() == i.this.jvf.getHeaderImg().getId()) {
                        i = 1;
                    } else if (i.this.jvf.cip() != null && view.getId() == i.this.jvf.cip().getId()) {
                        i = 1;
                    } else if (i.this.jvf.hHb != null && view.getId() == i.this.jvf.hHb.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).getTopicName();
                    String cHa = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).cHa();
                    bw bfG = lVar.bfG();
                    TiebaStatic.log(new aq("c12941").aj("obj_type", i).dK("tid", bfG.getId()));
                    if ("c10814".equals(lVar.ciX())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10814").dK("tid", bfG.getId()).dK("obj_name", topicName).dK("topic_id", cHa));
                    } else if ("c10816".equals(lVar.ciX())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10816").dK("post_id", bfG.getTid()).dK("obj_name", topicName).dK("topic_id", cHa));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fey = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a<u> c(ViewGroup viewGroup) {
        this.jvf = new u(this.mPageContext);
        this.jvf.o(this.fey);
        this.jvf.nT(false);
        this.jvf.currentPageType = 0;
        if (this.jvf.gAE != null) {
            this.jvf.gAE.eIo = 0;
        }
        if (this.jvf.hHb != null) {
            this.jvf.hHb.hHP = 0;
        }
        return new com.baidu.tieba.card.a.a<>(this.jvf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<u> aVar) {
        if (lVar == null || aVar == null || aVar.cjq() == null) {
            return null;
        }
        this.hFL = lVar;
        aVar.cjq().a(new bx(lVar.bfG()));
        aVar.cjq().c(this.hUs);
        ((u) ((com.baidu.tieba.card.a.a) this.Vx).cjq()).nY(!(getItem(i + 1) instanceof n));
        return aVar.getView();
    }
}
