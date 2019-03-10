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
    private String Yz;
    private NEGFeedBackView.a cIW;
    public BdUniqueId cnX;
    ab<com.baidu.tieba.card.data.j> eEz;
    private com.baidu.tieba.card.l fLN;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cIW = null;
        this.eEz = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i;
                if (b.this.fLN.drz != view) {
                    if (view == b.this.fLN.drn.getCommentContainer()) {
                        b.this.b(jVar);
                        com.baidu.tieba.q.c.cdr().b(b.this.cnX, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 5, jVar.aQQ(), false, null, null));
                        return;
                    } else if (view == b.this.fLN.dro.bTy.getCommentContainer()) {
                        b.this.b(jVar);
                        return;
                    } else if (b.this.fLN.aQm() == null || view.getId() != b.this.fLN.aQm().getId()) {
                        if (b.this.fLN.aQn() != null && view.getId() == b.this.fLN.aQn().getId()) {
                            com.baidu.tieba.q.c.cdr().b(b.this.cnX, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aQQ(), false, null, null));
                            return;
                        }
                        return;
                    } else {
                        com.baidu.tieba.q.c.cdr().b(b.this.cnX, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aQQ(), false, null, null));
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
                amVar.bJ("ab_tag", jVar.aQR());
                amVar.k("liveid", j);
                amVar.T("obj_type", i);
                amVar.bJ("tid", str);
                amVar.bJ("obj_param1", jVar.getExtra());
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                amVar.T("obj_floor", jVar.aQQ());
                TiebaStatic.log(amVar);
                com.baidu.tieba.q.c.cdr().b(b.this.cnX, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 1, jVar.aQQ(), false, null, null));
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.fLN = new com.baidu.tieba.card.l(this.mPageContext);
        this.fLN.currentPageType = 2;
        if (this.fLN.drn != null) {
            this.fLN.drn.bSG = 2;
        }
        if (this.fLN.dro != null && this.fLN.dro.bTy != null) {
            this.fLN.dro.bTy.bSG = 2;
        }
        if (this.cnX != null) {
            this.fLN.k(this.cnX);
        }
        return new a(this.fLN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.os(jVar.position + 1);
        if (aVar.fLP instanceof com.baidu.tieba.a.e) {
            aVar.fLP.setPage(this.Yz);
        }
        aVar.fLP.oo(i + 1);
        aVar.fLP.a(jVar);
        aVar.fLP.d(this.eEz);
        aVar.fLP.b(this.cIW);
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
            amVar.bJ("ab_tag", jVar.aQR());
            amVar.k("liveid", j);
            amVar.k(ImageViewerConfig.FORUM_ID, jVar.WR().getFid());
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bJ("obj_param1", jVar.getExtra());
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            amVar.T("obj_floor", jVar.aQQ());
            TiebaStatic.log(amVar);
        }
        com.baidu.tieba.q.c.cdr().a(this.cnX, jVar.threadData != null ? jVar.threadData.getId() : null, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_exp", jVar.aQQ(), false, null, null));
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
        this.cIW = aVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.l fLP;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.fLP = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void qN(String str) {
        this.Yz = str;
    }
}
