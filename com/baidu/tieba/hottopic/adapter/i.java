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
    private BdUniqueId fmX;
    private com.baidu.tieba.card.data.l hSi;
    private ab<bx> igS;
    private v jHE;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.igS = new ab<bx>() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bx bxVar) {
                int i;
                com.baidu.tieba.card.data.l lVar = i.this.hSi;
                if (lVar != null && lVar.erH != null && !StringUtils.isNull(lVar.erH.getTid())) {
                    if (i.this.jHE.getHeaderImg() != null && view.getId() == i.this.jHE.getHeaderImg().getId()) {
                        i = 1;
                    } else if (i.this.jHE.clw() != null && view.getId() == i.this.jHE.clw().getId()) {
                        i = 1;
                    } else if (i.this.jHE.hTy != null && view.getId() == i.this.jHE.hTy.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).getTopicName();
                    String cKh = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).cKh();
                    bw bhz = lVar.bhz();
                    TiebaStatic.log(new aq("c12941").aj("obj_type", i).dR("tid", bhz.getId()));
                    if ("c10814".equals(lVar.cme())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10814").dR("tid", bhz.getId()).dR("obj_name", topicName).dR("topic_id", cKh));
                    } else if ("c10816".equals(lVar.cme())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new aq("c10816").dR("post_id", bhz.getTid()).dR("obj_name", topicName).dR("topic_id", cKh));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fmX = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a<v> c(ViewGroup viewGroup) {
        this.jHE = new v(this.mPageContext);
        this.jHE.o(this.fmX);
        this.jHE.ol(false);
        this.jHE.currentPageType = 0;
        if (this.jHE.gMs != null) {
            this.jHE.gMs.eQK = 0;
        }
        if (this.jHE.hTy != null) {
            this.jHE.hTy.hUm = 0;
        }
        return new com.baidu.tieba.card.a.a<>(this.jHE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<v> aVar) {
        if (lVar == null || aVar == null || aVar.cmx() == null) {
            return null;
        }
        this.hSi = lVar;
        aVar.cmx().a(new bx(lVar.bhz()));
        aVar.cmx().c(this.igS);
        ((v) ((com.baidu.tieba.card.a.a) this.Vy).cmx()).oq(!(getItem(i + 1) instanceof n));
        return aVar.getView();
    }
}
