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
    private NEGFeedBackView.a cSD;
    public BdUniqueId cxx;
    ab<com.baidu.tieba.card.data.j> eZd;
    private com.baidu.tieba.card.l giX;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cSD = null;
        this.eZd = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i;
                if (b.this.giX.dFz != view) {
                    if (view == b.this.giX.dFn.getCommentContainer()) {
                        b.this.b(jVar);
                        com.baidu.tieba.q.c.coo().b(b.this.cxx, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 5, jVar.aZX(), false, (String) null, (String) null));
                        return;
                    } else if (view == b.this.giX.dFo.ccA.getCommentContainer()) {
                        b.this.b(jVar);
                        return;
                    } else if (b.this.giX.aZs() == null || view.getId() != b.this.giX.aZs().getId()) {
                        if (b.this.giX.aZt() != null && view.getId() == b.this.giX.aZt().getId()) {
                            com.baidu.tieba.q.c.coo().b(b.this.cxx, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aZX(), false, (String) null, (String) null));
                            return;
                        }
                        return;
                    } else {
                        com.baidu.tieba.q.c.coo().b(b.this.cxx, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aZX(), false, (String) null, (String) null));
                        return;
                    }
                }
                String str = "";
                long j = 0;
                if (jVar == null || jVar.acx() == null) {
                    i = 0;
                } else {
                    i = jVar.acx().aeQ().live_type;
                    str = jVar.acx().getTid();
                    j = jVar.acx().aeQ().live_id;
                }
                an anVar = new an("c11824");
                anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.bT("ab_tag", jVar.aZY());
                anVar.l("liveid", j);
                anVar.P("obj_type", i);
                anVar.bT("tid", str);
                anVar.bT("obj_param1", jVar.baa());
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                anVar.P("obj_floor", jVar.aZX());
                TiebaStatic.log(anVar);
                com.baidu.tieba.q.c.coo().b(b.this.cxx, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 1, jVar.aZX(), false, (String) null, (String) null));
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bi */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.giX = new com.baidu.tieba.card.l(this.mPageContext);
        this.giX.currentPageType = 2;
        if (this.giX.dFn != null) {
            this.giX.dFn.cbF = 2;
        }
        if (this.giX.dFo != null && this.giX.dFo.ccA != null) {
            this.giX.dFo.ccA.cbF = 2;
        }
        if (this.cxx != null) {
            this.giX.l(this.cxx);
        }
        return new a(this.giX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.pI(jVar.position + 1);
        if (aVar.giZ instanceof com.baidu.tieba.a.e) {
            aVar.giZ.setPage(this.WN);
        }
        aVar.giZ.pE(i + 1);
        aVar.giZ.a(jVar);
        aVar.giZ.d(this.eZd);
        aVar.giZ.b(this.cSD);
        String str = "";
        if (jVar != null && jVar.acx() != null) {
            int i2 = jVar.acx().aeQ().live_type;
            String tid = jVar.acx().getTid();
            if (!StringUtils.isNull(jVar.acx().aeQ().appId)) {
                str = jVar.acx().aeQ().appId;
            }
            long j = jVar.acx().aeQ().live_id;
            an anVar = new an("c11823");
            anVar.P("obj_type", i2);
            anVar.bT("obj_param3", str);
            anVar.bT("tid", tid);
            anVar.bT("ab_tag", jVar.aZY());
            anVar.l("liveid", j);
            anVar.l("fid", jVar.acx().getFid());
            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bT("obj_param1", jVar.baa());
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            anVar.P("obj_floor", jVar.aZX());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.q.c.coo().a(this.cxx, jVar.threadData != null ? jVar.threadData.getId() : null, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_exp", jVar.aZX(), false, null, null));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.acx() != null) {
            str = jVar.acx().getTid();
        }
        an anVar = new an("c12942");
        anVar.P("obj_locate", 1);
        anVar.P("obj_type", 5);
        anVar.bT("tid", str);
        anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cSD = aVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.l giZ;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.giZ = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }
}
