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
    private com.baidu.tieba.card.data.k ijE;
    private ab<bz> iyz;
    private v kbR;
    private TbPageContext<HotTopicActivity> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.iyz = new ab<bz>() { // from class: com.baidu.tieba.hottopic.adapter.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bz bzVar) {
                int i;
                com.baidu.tieba.card.data.k kVar = i.this.ijE;
                if (kVar != null && kVar.eCR != null && !StringUtils.isNull(kVar.eCR.getTid())) {
                    if (i.this.kbR.getHeaderImg() != null && view.getId() == i.this.kbR.getHeaderImg().getId()) {
                        i = 1;
                    } else if (i.this.kbR.crN() != null && view.getId() == i.this.kbR.crN().getId()) {
                        i = 1;
                    } else if (i.this.kbR.ikT != null && view.getId() == i.this.kbR.ikT.getId()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    String topicName = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).getTopicName();
                    String cRE = ((HotTopicActivity) i.this.mPageContext.getOrignalPage()).cRE();
                    by bmn = kVar.bmn();
                    TiebaStatic.log(new ar("c12941").al("obj_type", i).dY("tid", bmn.getId()));
                    if ("c10814".equals(kVar.csv())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ar("c10814").dY("tid", bmn.getId()).dY("obj_name", topicName).dY("topic_id", cRE));
                    } else if ("c10816".equals(kVar.csv())) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                        TiebaStatic.log(new ar("c10816").dY("post_id", bmn.getTid()).dY("obj_name", topicName).dY("topic_id", cRE));
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
        this.kbR = new v(this.mPageContext);
        this.kbR.o(this.fzO);
        this.kbR.oT(false);
        this.kbR.currentPageType = 0;
        if (this.kbR.hbN != null) {
            this.kbR.hbN.fdg = 0;
        }
        if (this.kbR.ikT != null) {
            this.kbR.ikT.ilI = 0;
        }
        return new com.baidu.tieba.card.a.a<>(this.kbR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<v> aVar) {
        if (kVar == null || aVar == null || aVar.csN() == null) {
            return null;
        }
        this.ijE = kVar;
        aVar.csN().a(new bz(kVar.bmn()));
        aVar.csN().c(this.iyz);
        ((v) ((com.baidu.tieba.card.a.a) this.Wx).csN()).oY(!(getItem(i + 1) instanceof n));
        return aVar.getView();
    }
}
