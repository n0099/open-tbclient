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
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String LC;
    public BdUniqueId dBx;
    private NEGFeedBackView.a dUD;
    com.baidu.tieba.card.z<com.baidu.tieba.card.data.j> fWU;
    private com.baidu.tieba.card.j hdt;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dUD = null;
        this.fWU = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (b.this.hdt.egT != view) {
                    if (view == b.this.hdt.eNz.getCommentContainer()) {
                        b.this.b(jVar);
                        i = 5;
                    } else if (view == b.this.hdt.eOl.diU.getCommentContainer()) {
                        b.this.b(jVar);
                    } else if (b.this.hdt.buL() != null && view.getId() == b.this.hdt.buL().getId()) {
                        i = 2;
                    } else if (b.this.hdt.buM() != null && view.getId() == b.this.hdt.buM().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.aAg() != null) {
                        i = jVar.aAg().aCH().live_type;
                        str = jVar.aAg().getTid();
                        j = jVar.aAg().aCH().live_id;
                    }
                    an anVar = new an("c11824");
                    anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cy(TiebaInitialize.Params.AB_TAG, jVar.bvs());
                    anVar.s("liveid", j);
                    anVar.X("obj_type", i);
                    anVar.cy("tid", str);
                    anVar.cy("obj_param1", jVar.getExtra());
                    anVar.cy("obj_source", jVar.getSource());
                    anVar.X("obj_floor", jVar.bvr());
                    TiebaStatic.log(anVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.cRg, b.this.dBx, jVar.bvr(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public a b(ViewGroup viewGroup) {
        this.hdt = new com.baidu.tieba.card.j(this.mPageContext, this.dBx);
        this.hdt.currentPageType = 2;
        if (this.hdt.eNz != null) {
            this.hdt.eNz.dhT = 2;
        }
        if (this.hdt.eOl != null && this.hdt.eOl.diU != null) {
            this.hdt.eOl.diU.dhT = 2;
        }
        if (this.dBx != null) {
            this.hdt.m(this.dBx);
        }
        return new a(this.hdt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.rt(jVar.position + 1);
        if (aVar.hdv instanceof com.baidu.tieba.a.e) {
            aVar.hdv.setPage(this.LC);
        }
        aVar.hdv.rp(i + 1);
        aVar.hdv.a(jVar);
        aVar.hdv.c(this.fWU);
        aVar.hdv.b(this.dUD);
        String str = "";
        if (jVar != null && jVar.aAg() != null) {
            int i2 = jVar.aAg().aCH().live_type;
            String tid = jVar.aAg().getTid();
            if (!StringUtils.isNull(jVar.aAg().aCH().appId)) {
                str = jVar.aAg().aCH().appId;
            }
            long j = jVar.aAg().aCH().live_id;
            an anVar = new an("c11823");
            anVar.X("obj_type", i2);
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM3, str);
            anVar.cy("tid", tid);
            anVar.cy(TiebaInitialize.Params.AB_TAG, jVar.bvs());
            anVar.s("liveid", j);
            anVar.s("fid", jVar.aAg().getFid());
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cy("obj_param1", jVar.getExtra());
            anVar.cy("obj_source", jVar.getSource());
            anVar.X("obj_floor", jVar.bvr());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.cRg, this.dBx, jVar.bvr());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.aAg() != null) {
            str = jVar.aAg().getTid();
        }
        an anVar = new an("c12942");
        anVar.X("obj_locate", 1);
        anVar.X("obj_type", 5);
        anVar.cy("tid", str);
        anVar.cy("obj_source", jVar.getSource());
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUD = aVar;
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.j hdv;

        public a(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.hdv = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }
}
