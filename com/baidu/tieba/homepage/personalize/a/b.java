package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String YA;
    private NEGFeedBackView.a cIT;
    public BdUniqueId cnX;
    ab<com.baidu.tieba.card.data.j> eEv;
    private com.baidu.tieba.card.l fLM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cIT = null;
        this.eEv = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i;
                if (b.this.fLM.drv != view) {
                    if (view == b.this.fLM.drj.getCommentContainer()) {
                        b.this.b(jVar);
                        com.baidu.tieba.q.c.cdt().b(b.this.cnX, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 5, jVar.aQP(), false, null, null));
                        return;
                    } else if (view == b.this.fLM.drk.bTz.getCommentContainer()) {
                        b.this.b(jVar);
                        return;
                    } else if (b.this.fLM.aQl() == null || view.getId() != b.this.fLM.aQl().getId()) {
                        if (b.this.fLM.aQm() != null && view.getId() == b.this.fLM.aQm().getId()) {
                            com.baidu.tieba.q.c.cdt().b(b.this.cnX, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aQP(), false, null, null));
                            return;
                        }
                        return;
                    } else {
                        com.baidu.tieba.q.c.cdt().b(b.this.cnX, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aQP(), false, null, null));
                        return;
                    }
                }
                String str = "";
                long j = 0;
                if (jVar == null || jVar.WR() == null) {
                    i = 0;
                } else {
                    i = jVar.WR().Zk().live_type;
                    str = jVar.WR().getTid();
                    j = jVar.WR().Zk().live_id;
                }
                am amVar = new am("c11824");
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.bJ("ab_tag", jVar.aQQ());
                amVar.k("liveid", j);
                amVar.T("obj_type", i);
                amVar.bJ("tid", str);
                amVar.bJ("obj_param1", jVar.getExtra());
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                amVar.T("obj_floor", jVar.aQP());
                TiebaStatic.log(amVar);
                com.baidu.tieba.q.c.cdt().b(b.this.cnX, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 1, jVar.aQP(), false, null, null));
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.fLM = new com.baidu.tieba.card.l(this.mPageContext);
        this.fLM.currentPageType = 2;
        if (this.fLM.drj != null) {
            this.fLM.drj.bSH = 2;
        }
        if (this.fLM.drk != null && this.fLM.drk.bTz != null) {
            this.fLM.drk.bTz.bSH = 2;
        }
        if (this.cnX != null) {
            this.fLM.k(this.cnX);
        }
        return new a(this.fLM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.os(jVar.position + 1);
        if (aVar.fLO instanceof com.baidu.tieba.a.e) {
            aVar.fLO.setPage(this.YA);
        }
        aVar.fLO.oo(i + 1);
        aVar.fLO.a(jVar);
        aVar.fLO.d(this.eEv);
        aVar.fLO.b(this.cIT);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.WR() != null) {
            int i2 = jVar.WR().Zk().live_type;
            String tid = jVar.WR().getTid();
            if (!StringUtils.isNull(jVar.WR().Zk().appId)) {
                str = jVar.WR().Zk().appId;
                j = jVar.WR().Zk().live_id;
            }
            am amVar = new am("c11823");
            amVar.T("obj_type", i2);
            amVar.bJ("obj_param3", str);
            amVar.bJ("tid", tid);
            amVar.bJ("ab_tag", jVar.aQQ());
            amVar.k("liveid", j);
            amVar.k(ImageViewerConfig.FORUM_ID, jVar.WR().getFid());
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bJ("obj_param1", jVar.getExtra());
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            amVar.T("obj_floor", jVar.aQP());
            TiebaStatic.log(amVar);
        }
        com.baidu.tieba.q.c.cdt().a(this.cnX, jVar.threadData != null ? jVar.threadData.getId() : null, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_exp", jVar.aQP(), false, null, null));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.WR() != null) {
            str = jVar.WR().getTid();
        }
        am amVar = new am("c12942");
        amVar.T("obj_locate", 1);
        amVar.T("obj_type", 5);
        amVar.bJ("tid", str);
        amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
        TiebaStatic.log(amVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cIT = aVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.l fLO;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.fLO = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void qL(String str) {
        this.YA = str;
    }
}
