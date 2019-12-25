package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String La;
    private NEGFeedBackView.a dQa;
    public BdUniqueId dwY;
    com.baidu.tieba.card.z<com.baidu.tieba.card.data.j> fRu;
    private com.baidu.tieba.card.j gXH;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQa = null;
        this.fRu = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (b.this.gXH.ect != view) {
                    if (view == b.this.gXH.eIh.getCommentContainer()) {
                        b.this.b(jVar);
                        i = 5;
                    } else if (view == b.this.gXH.eIU.dep.getCommentContainer()) {
                        b.this.b(jVar);
                    } else if (b.this.gXH.bsc() != null && view.getId() == b.this.gXH.bsc().getId()) {
                        i = 2;
                    } else if (b.this.gXH.bsd() != null && view.getId() == b.this.gXH.bsd().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.axx() != null) {
                        i = jVar.axx().azX().live_type;
                        str = jVar.axx().getTid();
                        j = jVar.axx().azX().live_id;
                    }
                    an anVar = new an("c11824");
                    anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cp(TiebaInitialize.Params.AB_TAG, jVar.bsJ());
                    anVar.s("liveid", j);
                    anVar.Z("obj_type", i);
                    anVar.cp("tid", str);
                    anVar.cp("obj_param1", jVar.getExtra());
                    anVar.cp("obj_source", jVar.getSource());
                    anVar.Z("obj_floor", jVar.bsI());
                    TiebaStatic.log(anVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.cMR, b.this.dwY, jVar.bsI(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public a b(ViewGroup viewGroup) {
        this.gXH = new com.baidu.tieba.card.j(this.mPageContext);
        this.gXH.currentPageType = 2;
        if (this.gXH.eIh != null) {
            this.gXH.eIh.ddq = 2;
        }
        if (this.gXH.eIU != null && this.gXH.eIU.dep != null) {
            this.gXH.eIU.dep.ddq = 2;
        }
        if (this.dwY != null) {
            this.gXH.m(this.dwY);
        }
        return new a(this.gXH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.rh(jVar.position + 1);
        if (aVar.gXJ instanceof com.baidu.tieba.a.e) {
            aVar.gXJ.setPage(this.La);
        }
        aVar.gXJ.rd(i + 1);
        aVar.gXJ.a(jVar);
        aVar.gXJ.c(this.fRu);
        aVar.gXJ.b(this.dQa);
        String str = "";
        if (jVar != null && jVar.axx() != null) {
            int i2 = jVar.axx().azX().live_type;
            String tid = jVar.axx().getTid();
            if (!StringUtils.isNull(jVar.axx().azX().appId)) {
                str = jVar.axx().azX().appId;
            }
            long j = jVar.axx().azX().live_id;
            an anVar = new an("c11823");
            anVar.Z("obj_type", i2);
            anVar.cp(TiebaInitialize.Params.OBJ_PARAM3, str);
            anVar.cp("tid", tid);
            anVar.cp(TiebaInitialize.Params.AB_TAG, jVar.bsJ());
            anVar.s("liveid", j);
            anVar.s("fid", jVar.axx().getFid());
            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cp("obj_param1", jVar.getExtra());
            anVar.cp("obj_source", jVar.getSource());
            anVar.Z("obj_floor", jVar.bsI());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.cMR, this.dwY, jVar.bsI());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.axx() != null) {
            str = jVar.axx().getTid();
        }
        an anVar = new an("c12942");
        anVar.Z("obj_locate", 1);
        anVar.Z("obj_type", 5);
        anVar.cp("tid", str);
        anVar.cp("obj_source", jVar.getSource());
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dQa = aVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.j gXJ;

        public a(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.gXJ = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void wq(String str) {
        this.La = str;
    }
}
