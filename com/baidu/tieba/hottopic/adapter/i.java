package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.v;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.n;
/* loaded from: classes21.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<v>> {
    private BdUniqueId fzO;
    private com.baidu.tieba.card.data.k ijC;
    private ab<bz> iyx;
    private v kbP;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iyx = new ab<bz>() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bz bzVar) {
                int i;
                com.baidu.tieba.card.data.k kVar = i.this.ijC;
                if (kVar != null && kVar.eCR != null && !StringUtils.isNull(kVar.eCR.getTid())) {
                    if (i.this.kbP.getHeaderImg() != null && view.getId() == i.this.kbP.getHeaderImg().getId()) {
                        i = 1;
                    } else if (i.this.kbP.crM() != null && view.getId() == i.this.kbP.crM().getId()) {
                        i = 1;
                    } else if (i.this.kbP.ikR != null && view.getId() == i.this.kbP.ikR.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).getTopicName();
                    String cRD = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).cRD();
                    by bmn = kVar.bmn();
                    TiebaStatic.log(new ar("c12941").al("obj_type", i).dY("tid", bmn.getId()));
                    if ("c10814".equals(kVar.csu())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ar("c10814").dY("tid", bmn.getId()).dY("obj_name", topicName).dY("topic_id", cRD));
                    } else if ("c10816".equals(kVar.csu())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ar("c10816").dY("post_id", bmn.getTid()).dY("obj_name", topicName).dY("topic_id", cRD));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fzO = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<v> c(ViewGroup viewGroup) {
        this.kbP = new v(this.mPageContext);
        this.kbP.o(this.fzO);
        this.kbP.oT(false);
        this.kbP.currentPageType = 0;
        if (this.kbP.hbL != null) {
            this.kbP.hbL.fdg = 0;
        }
        if (this.kbP.ikR != null) {
            this.kbP.ikR.ilG = 0;
        }
        return new com.baidu.tieba.card.a.a<>(this.kbP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<v> aVar) {
        if (kVar == null || aVar == null || aVar.csM() == null) {
            return null;
        }
        this.ijC = kVar;
        aVar.csM().a(new bz(kVar.bmn()));
        aVar.csM().c(this.iyx);
        ((v) ((com.baidu.tieba.card.a.a) this.Wx).csM()).oY(!(getItem(i + 1) instanceof n));
        return aVar.getView();
    }
}
