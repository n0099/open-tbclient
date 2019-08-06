package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String WN;
    private NEGFeedBackView.a cSK;
    public BdUniqueId cxE;
    ab<com.baidu.tieba.card.data.j> eZr;
    private com.baidu.tieba.card.l gjN;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cSK = null;
        this.eZr = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i;
                if (b.this.gjN.dFG != view) {
                    if (view == b.this.gjN.dFu.getCommentContainer()) {
                        b.this.b(jVar);
                        com.baidu.tieba.q.c.coG().b(b.this.cxE, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 5, jVar.aZZ(), false, (String) null, (String) null));
                        return;
                    } else if (view == b.this.gjN.dFv.ccH.getCommentContainer()) {
                        b.this.b(jVar);
                        return;
                    } else if (b.this.gjN.aZu() == null || view.getId() != b.this.gjN.aZu().getId()) {
                        if (b.this.gjN.aZv() != null && view.getId() == b.this.gjN.aZv().getId()) {
                            com.baidu.tieba.q.c.coG().b(b.this.cxE, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aZZ(), false, (String) null, (String) null));
                            return;
                        }
                        return;
                    } else {
                        com.baidu.tieba.q.c.coG().b(b.this.cxE, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aZZ(), false, (String) null, (String) null));
                        return;
                    }
                }
                String str = "";
                long j = 0;
                if (jVar == null || jVar.acy() == null) {
                    i = 0;
                } else {
                    i = jVar.acy().aeR().live_type;
                    str = jVar.acy().getTid();
                    j = jVar.acy().aeR().live_id;
                }
                an anVar = new an("c11824");
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.bT("ab_tag", jVar.baa());
                anVar.l("liveid", j);
                anVar.P("obj_type", i);
                anVar.bT("tid", str);
                anVar.bT("obj_param1", jVar.bac());
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                anVar.P("obj_floor", jVar.aZZ());
                TiebaStatic.log(anVar);
                com.baidu.tieba.q.c.coG().b(b.this.cxE, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 1, jVar.aZZ(), false, (String) null, (String) null));
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.gjN = new com.baidu.tieba.card.l(this.mPageContext);
        this.gjN.currentPageType = 2;
        if (this.gjN.dFu != null) {
            this.gjN.dFu.cbM = 2;
        }
        if (this.gjN.dFv != null && this.gjN.dFv.ccH != null) {
            this.gjN.dFv.ccH.cbM = 2;
        }
        if (this.cxE != null) {
            this.gjN.l(this.cxE);
        }
        return new a(this.gjN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.pJ(jVar.position + 1);
        if (aVar.gjP instanceof com.baidu.tieba.a.e) {
            aVar.gjP.setPage(this.WN);
        }
        aVar.gjP.pF(i + 1);
        aVar.gjP.a(jVar);
        aVar.gjP.d(this.eZr);
        aVar.gjP.b(this.cSK);
        String str = "";
        if (jVar != null && jVar.acy() != null) {
            int i2 = jVar.acy().aeR().live_type;
            String tid = jVar.acy().getTid();
            if (!StringUtils.isNull(jVar.acy().aeR().appId)) {
                str = jVar.acy().aeR().appId;
            }
            long j = jVar.acy().aeR().live_id;
            an anVar = new an("c11823");
            anVar.P("obj_type", i2);
            anVar.bT("obj_param3", str);
            anVar.bT("tid", tid);
            anVar.bT("ab_tag", jVar.baa());
            anVar.l("liveid", j);
            anVar.l("fid", jVar.acy().getFid());
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bT("obj_param1", jVar.bac());
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            anVar.P("obj_floor", jVar.aZZ());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.q.c.coG().a(this.cxE, jVar.threadData != null ? jVar.threadData.getId() : null, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_exp", jVar.aZZ(), false, null, null));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.acy() != null) {
            str = jVar.acy().getTid();
        }
        an anVar = new an("c12942");
        anVar.P("obj_locate", 1);
        anVar.P("obj_type", 5);
        anVar.bT("tid", str);
        anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cSK = aVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.l gjP;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.gjP = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }
}
