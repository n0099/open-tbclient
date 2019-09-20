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
    private String WM;
    private NEGFeedBackView.a cTD;
    public BdUniqueId cyA;
    ab<com.baidu.tieba.card.data.j> faX;
    private com.baidu.tieba.card.l glF;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cTD = null;
        this.faX = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i;
                if (b.this.glF.dHr != view) {
                    if (view == b.this.glF.dHf.getCommentContainer()) {
                        b.this.b(jVar);
                        com.baidu.tieba.q.c.cpt().b(b.this.cyA, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 5, jVar.baD(), false, (String) null, (String) null));
                        return;
                    } else if (view == b.this.glF.dHg.cdA.getCommentContainer()) {
                        b.this.b(jVar);
                        return;
                    } else if (b.this.glF.aZY() == null || view.getId() != b.this.glF.aZY().getId()) {
                        if (b.this.glF.aZZ() != null && view.getId() == b.this.glF.aZZ().getId()) {
                            com.baidu.tieba.q.c.cpt().b(b.this.cyA, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.baD(), false, (String) null, (String) null));
                            return;
                        }
                        return;
                    } else {
                        com.baidu.tieba.q.c.cpt().b(b.this.cyA, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.baD(), false, (String) null, (String) null));
                        return;
                    }
                }
                String str = "";
                long j = 0;
                if (jVar == null || jVar.acC() == null) {
                    i = 0;
                } else {
                    i = jVar.acC().aeV().live_type;
                    str = jVar.acC().getTid();
                    j = jVar.acC().aeV().live_id;
                }
                an anVar = new an("c11824");
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.bT("ab_tag", jVar.baE());
                anVar.n("liveid", j);
                anVar.P("obj_type", i);
                anVar.bT("tid", str);
                anVar.bT("obj_param1", jVar.baG());
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                anVar.P("obj_floor", jVar.baD());
                TiebaStatic.log(anVar);
                com.baidu.tieba.q.c.cpt().b(b.this.cyA, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 1, jVar.baD(), false, (String) null, (String) null));
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.glF = new com.baidu.tieba.card.l(this.mPageContext);
        this.glF.currentPageType = 2;
        if (this.glF.dHf != null) {
            this.glF.dHf.ccG = 2;
        }
        if (this.glF.dHg != null && this.glF.dHg.cdA != null) {
            this.glF.dHg.cdA.ccG = 2;
        }
        if (this.cyA != null) {
            this.glF.l(this.cyA);
        }
        return new a(this.glF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.pN(jVar.position + 1);
        if (aVar.glH instanceof com.baidu.tieba.a.e) {
            aVar.glH.setPage(this.WM);
        }
        aVar.glH.pJ(i + 1);
        aVar.glH.a(jVar);
        aVar.glH.d(this.faX);
        aVar.glH.b(this.cTD);
        String str = "";
        if (jVar != null && jVar.acC() != null) {
            int i2 = jVar.acC().aeV().live_type;
            String tid = jVar.acC().getTid();
            if (!StringUtils.isNull(jVar.acC().aeV().appId)) {
                str = jVar.acC().aeV().appId;
            }
            long j = jVar.acC().aeV().live_id;
            an anVar = new an("c11823");
            anVar.P("obj_type", i2);
            anVar.bT("obj_param3", str);
            anVar.bT("tid", tid);
            anVar.bT("ab_tag", jVar.baE());
            anVar.n("liveid", j);
            anVar.n("fid", jVar.acC().getFid());
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bT("obj_param1", jVar.baG());
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            anVar.P("obj_floor", jVar.baD());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.q.c.cpt().a(this.cyA, jVar.threadData != null ? jVar.threadData.getId() : null, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_exp", jVar.baD(), false, null, null));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.acC() != null) {
            str = jVar.acC().getTid();
        }
        an anVar = new an("c12942");
        anVar.P("obj_locate", 1);
        anVar.P("obj_type", 5);
        anVar.bT("tid", str);
        anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cTD = aVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.l glH;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.glH = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
        this.WM = str;
    }
}
