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
    private String Gc;
    public BdUniqueId cJo;
    private NEGFeedBackView.a dcg;
    ab<com.baidu.tieba.card.data.j> fcR;
    private com.baidu.tieba.card.l gkm;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dcg = null;
        this.fcR = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i;
                if (b.this.gkm.dTz != view) {
                    if (view == b.this.gkm.dTn.getCommentContainer()) {
                        b.this.b(jVar);
                        com.baidu.tieba.q.c.cni().b(b.this.cJo, com.baidu.tieba.q.a.a(jVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 5, jVar.baE(), false, (String) null, (String) null));
                        return;
                    } else if (view == b.this.gkm.dTo.cqW.getCommentContainer()) {
                        b.this.b(jVar);
                        return;
                    } else if (b.this.gkm.aZZ() == null || view.getId() != b.this.gkm.aZZ().getId()) {
                        if (b.this.gkm.baa() != null && view.getId() == b.this.gkm.baa().getId()) {
                            com.baidu.tieba.q.c.cni().b(b.this.cJo, com.baidu.tieba.q.a.a(jVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 2, jVar.baE(), false, (String) null, (String) null));
                            return;
                        }
                        return;
                    } else {
                        com.baidu.tieba.q.c.cni().b(b.this.cJo, com.baidu.tieba.q.a.a(jVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 2, jVar.baE(), false, (String) null, (String) null));
                        return;
                    }
                }
                String str = "";
                long j = 0;
                if (jVar == null || jVar.agG() == null) {
                    i = 0;
                } else {
                    i = jVar.agG().aiX().live_type;
                    str = jVar.agG().getTid();
                    j = jVar.agG().aiX().live_id;
                }
                an anVar = new an("c11824");
                anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                anVar.bS(TiebaInitialize.Params.AB_TAG, jVar.baF());
                anVar.p("liveid", j);
                anVar.O("obj_type", i);
                anVar.bS("tid", str);
                anVar.bS("obj_param1", jVar.getExtra());
                anVar.bS("obj_source", jVar.getSource());
                anVar.O("obj_floor", jVar.baE());
                TiebaStatic.log(anVar);
                com.baidu.tieba.q.c.cni().b(b.this.cJo, com.baidu.tieba.q.a.a(jVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, jVar.baE(), false, (String) null, (String) null));
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public a b(ViewGroup viewGroup) {
        this.gkm = new com.baidu.tieba.card.l(this.mPageContext);
        this.gkm.currentPageType = 2;
        if (this.gkm.dTn != null) {
            this.gkm.dTn.cqc = 2;
        }
        if (this.gkm.dTo != null && this.gkm.dTo.cqW != null) {
            this.gkm.dTo.cqW.cqc = 2;
        }
        if (this.cJo != null) {
            this.gkm.l(this.cJo);
        }
        return new a(this.gkm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.oO(jVar.position + 1);
        if (aVar.gko instanceof com.baidu.tieba.a.e) {
            aVar.gko.setPage(this.Gc);
        }
        aVar.gko.oK(i + 1);
        aVar.gko.a(jVar);
        aVar.gko.d(this.fcR);
        aVar.gko.b(this.dcg);
        String str = "";
        if (jVar != null && jVar.agG() != null) {
            int i2 = jVar.agG().aiX().live_type;
            String tid = jVar.agG().getTid();
            if (!StringUtils.isNull(jVar.agG().aiX().appId)) {
                str = jVar.agG().aiX().appId;
            }
            long j = jVar.agG().aiX().live_id;
            an anVar = new an("c11823");
            anVar.O("obj_type", i2);
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM3, str);
            anVar.bS("tid", tid);
            anVar.bS(TiebaInitialize.Params.AB_TAG, jVar.baF());
            anVar.p("liveid", j);
            anVar.p("fid", jVar.agG().getFid());
            anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.bS("obj_param1", jVar.getExtra());
            anVar.bS("obj_source", jVar.getSource());
            anVar.O("obj_floor", jVar.baE());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.q.c.cni().a(this.cJo, jVar.caz != null ? jVar.caz.getId() : null, com.baidu.tieba.q.a.a(jVar.caz, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", jVar.baE(), false, null, null));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.agG() != null) {
            str = jVar.agG().getTid();
        }
        an anVar = new an("c12942");
        anVar.O("obj_locate", 1);
        anVar.O("obj_type", 5);
        anVar.bS("tid", str);
        anVar.bS("obj_source", jVar.getSource());
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dcg = aVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.l gko;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.gko = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }
}
