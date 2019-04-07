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
    private NEGFeedBackView.a cIV;
    public BdUniqueId cnZ;
    ab<com.baidu.tieba.card.data.j> eEg;
    private com.baidu.tieba.card.l fLA;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cIV = null;
        this.eEg = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i;
                if (b.this.fLA.dry != view) {
                    if (view == b.this.fLA.drm.getCommentContainer()) {
                        b.this.b(jVar);
                        com.baidu.tieba.q.c.cdp().b(b.this.cnZ, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 5, jVar.aQN(), false, null, null));
                        return;
                    } else if (view == b.this.fLA.drn.bTB.getCommentContainer()) {
                        b.this.b(jVar);
                        return;
                    } else if (b.this.fLA.aQj() == null || view.getId() != b.this.fLA.aQj().getId()) {
                        if (b.this.fLA.aQk() != null && view.getId() == b.this.fLA.aQk().getId()) {
                            com.baidu.tieba.q.c.cdp().b(b.this.cnZ, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aQN(), false, null, null));
                            return;
                        }
                        return;
                    } else {
                        com.baidu.tieba.q.c.cdp().b(b.this.cnZ, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aQN(), false, null, null));
                        return;
                    }
                }
                String str = "";
                long j = 0;
                if (jVar == null || jVar.WO() == null) {
                    i = 0;
                } else {
                    i = jVar.WO().Zh().live_type;
                    str = jVar.WO().getTid();
                    j = jVar.WO().Zh().live_id;
                }
                am amVar = new am("c11824");
                amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.bJ("ab_tag", jVar.aQO());
                amVar.k("liveid", j);
                amVar.T("obj_type", i);
                amVar.bJ("tid", str);
                amVar.bJ("obj_param1", jVar.getExtra());
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                amVar.T("obj_floor", jVar.aQN());
                TiebaStatic.log(amVar);
                com.baidu.tieba.q.c.cdp().b(b.this.cnZ, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 1, jVar.aQN(), false, null, null));
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.fLA = new com.baidu.tieba.card.l(this.mPageContext);
        this.fLA.currentPageType = 2;
        if (this.fLA.drm != null) {
            this.fLA.drm.bSJ = 2;
        }
        if (this.fLA.drn != null && this.fLA.drn.bTB != null) {
            this.fLA.drn.bTB.bSJ = 2;
        }
        if (this.cnZ != null) {
            this.fLA.k(this.cnZ);
        }
        return new a(this.fLA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.oo(jVar.position + 1);
        if (aVar.fLC instanceof com.baidu.tieba.a.e) {
            aVar.fLC.setPage(this.YA);
        }
        aVar.fLC.ok(i + 1);
        aVar.fLC.a(jVar);
        aVar.fLC.d(this.eEg);
        aVar.fLC.b(this.cIV);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.WO() != null) {
            int i2 = jVar.WO().Zh().live_type;
            String tid = jVar.WO().getTid();
            if (!StringUtils.isNull(jVar.WO().Zh().appId)) {
                str = jVar.WO().Zh().appId;
                j = jVar.WO().Zh().live_id;
            }
            am amVar = new am("c11823");
            amVar.T("obj_type", i2);
            amVar.bJ("obj_param3", str);
            amVar.bJ("tid", tid);
            amVar.bJ("ab_tag", jVar.aQO());
            amVar.k("liveid", j);
            amVar.k(ImageViewerConfig.FORUM_ID, jVar.WO().getFid());
            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bJ("obj_param1", jVar.getExtra());
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            amVar.T("obj_floor", jVar.aQN());
            TiebaStatic.log(amVar);
        }
        com.baidu.tieba.q.c.cdp().a(this.cnZ, jVar.threadData != null ? jVar.threadData.getId() : null, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_exp", jVar.aQN(), false, null, null));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.WO() != null) {
            str = jVar.WO().getTid();
        }
        am amVar = new am("c12942");
        amVar.T("obj_locate", 1);
        amVar.T("obj_type", 5);
        amVar.bJ("tid", str);
        amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
        TiebaStatic.log(amVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cIV = aVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.l fLC;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.fLC = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YA = str;
    }
}
