package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.u;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
/* loaded from: classes15.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<u>> {
    private BdUniqueId eEU;
    private com.baidu.tieba.card.data.k gWR;
    private aa<bw> hly;
    private u iIu;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.hly = new aa<bw>() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bw bwVar) {
                int i;
                com.baidu.tieba.card.data.k kVar = i.this.gWR;
                if (kVar != null && kVar.dLK != null && !StringUtils.isNull(kVar.dLK.getTid())) {
                    if (i.this.iIu.getHeaderImg() != null && view.getId() == i.this.iIu.getHeaderImg().getId()) {
                        i = 1;
                    } else if (i.this.iIu.bRr() != null && view.getId() == i.this.iIu.bRr().getId()) {
                        i = 1;
                    } else if (i.this.iIu.gYh != null && view.getId() == i.this.iIu.gYh.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).getTopicName();
                    String coQ = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).coQ();
                    bv aTN = kVar.aTN();
                    TiebaStatic.log(new ap("c12941").ah("obj_type", i).dn("tid", aTN.getId()));
                    if ("c10814".equals(kVar.bRZ())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ap("c10814").dn("tid", aTN.getId()).dn("obj_name", topicName).dn("topic_id", coQ));
                    } else if ("c10816".equals(kVar.bRZ())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ap("c10816").dn("post_id", aTN.getTid()).dn("obj_name", topicName).dn("topic_id", coQ));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eEU = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<u> b(ViewGroup viewGroup) {
        this.iIu = new u(this.mPageContext);
        this.iIu.p(this.eEU);
        this.iIu.mD(false);
        this.iIu.currentPageType = 0;
        if (this.iIu.fXb != null) {
            this.iIu.fXb.ekb = 0;
        }
        if (this.iIu.gYh != null) {
            this.iIu.gYh.gYV = 0;
        }
        return new com.baidu.tieba.card.a.a<>(this.iIu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<u> aVar) {
        if (kVar == null || aVar == null || aVar.bSs() == null) {
            return null;
        }
        this.gWR = kVar;
        aVar.bSs().a(new bw(kVar.aTN()));
        aVar.bSs().c(this.hly);
        ((u) ((com.baidu.tieba.card.a.a) this.Uj).bSs()).mI(!(getItem(i + 1) instanceof n));
        return aVar.getView();
    }
}
