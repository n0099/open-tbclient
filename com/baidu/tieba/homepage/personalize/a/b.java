package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String GC;
    public BdUniqueId cKf;
    private NEGFeedBackView.a dcY;
    ab<com.baidu.tieba.card.data.j> fdI;
    private com.baidu.tieba.card.l gld;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dcY = null;
        this.fdI = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i;
                if (b.this.gld.dUq != view) {
                    if (view == b.this.gld.dUe.getCommentContainer()) {
                        b.this.b(jVar);
                        com.baidu.tieba.q.c.cnk().b(b.this.cKf, com.baidu.tieba.q.a.a(jVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 5, jVar.baG(), false, (String) null, (String) null));
                        return;
                    } else if (view == b.this.gld.dUf.crO.getCommentContainer()) {
                        b.this.b(jVar);
                        return;
                    } else if (b.this.gld.bab() == null || view.getId() != b.this.gld.bab().getId()) {
                        if (b.this.gld.bac() != null && view.getId() == b.this.gld.bac().getId()) {
                            com.baidu.tieba.q.c.cnk().b(b.this.cKf, com.baidu.tieba.q.a.a(jVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 2, jVar.baG(), false, (String) null, (String) null));
                            return;
                        }
                        return;
                    } else {
                        com.baidu.tieba.q.c.cnk().b(b.this.cKf, com.baidu.tieba.q.a.a(jVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 2, jVar.baG(), false, (String) null, (String) null));
                        return;
                    }
                }
                String str = "";
                long j = 0;
                if (jVar == null || jVar.agI() == null) {
                    i = 0;
                } else {
                    i = jVar.agI().aiZ().live_type;
                    str = jVar.agI().getTid();
                    j = jVar.agI().aiZ().live_id;
                }
                an anVar = new an("c11824");
                anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.bS(TiebaInitialize.Params.AB_TAG, jVar.baH());
                anVar.p("liveid", j);
                anVar.O("obj_type", i);
                anVar.bS("tid", str);
                anVar.bS("obj_param1", jVar.getExtra());
                anVar.bS("obj_source", jVar.getSource());
                anVar.O("obj_floor", jVar.baG());
                TiebaStatic.log(anVar);
                com.baidu.tieba.q.c.cnk().b(b.this.cKf, com.baidu.tieba.q.a.a(jVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, jVar.baG(), false, (String) null, (String) null));
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public a b(ViewGroup viewGroup) {
        this.gld = new com.baidu.tieba.card.l(this.mPageContext);
        this.gld.currentPageType = 2;
        if (this.gld.dUe != null) {
            this.gld.dUe.cqT = 2;
        }
        if (this.gld.dUf != null && this.gld.dUf.crO != null) {
            this.gld.dUf.crO.cqT = 2;
        }
        if (this.cKf != null) {
            this.gld.l(this.cKf);
        }
        return new a(this.gld);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.oP(jVar.position + 1);
        if (aVar.glf instanceof com.baidu.tieba.a.e) {
            aVar.glf.setPage(this.GC);
        }
        aVar.glf.oL(i + 1);
        aVar.glf.a(jVar);
        aVar.glf.d(this.fdI);
        aVar.glf.b(this.dcY);
        String str = "";
        if (jVar != null && jVar.agI() != null) {
            int i2 = jVar.agI().aiZ().live_type;
            String tid = jVar.agI().getTid();
            if (!StringUtils.isNull(jVar.agI().aiZ().appId)) {
                str = jVar.agI().aiZ().appId;
            }
            long j = jVar.agI().aiZ().live_id;
            an anVar = new an("c11823");
            anVar.O("obj_type", i2);
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM3, str);
            anVar.bS("tid", tid);
            anVar.bS(TiebaInitialize.Params.AB_TAG, jVar.baH());
            anVar.p("liveid", j);
            anVar.p("fid", jVar.agI().getFid());
            anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bS("obj_param1", jVar.getExtra());
            anVar.bS("obj_source", jVar.getSource());
            anVar.O("obj_floor", jVar.baG());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.q.c.cnk().a(this.cKf, jVar.cbq != null ? jVar.cbq.getId() : null, com.baidu.tieba.q.a.a(jVar.cbq, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", jVar.baG(), false, null, null));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.agI() != null) {
            str = jVar.agI().getTid();
        }
        an anVar = new an("c12942");
        anVar.O("obj_locate", 1);
        anVar.O("obj_type", 5);
        anVar.bS("tid", str);
        anVar.bS("obj_source", jVar.getSource());
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dcY = aVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.l glf;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.glf = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }
}
