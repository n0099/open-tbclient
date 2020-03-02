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
    public BdUniqueId dBk;
    private NEGFeedBackView.a dUq;
    com.baidu.tieba.card.z<com.baidu.tieba.card.data.j> fWH;
    private com.baidu.tieba.card.j hdh;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dUq = null;
        this.fWH = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (b.this.hdh.egG != view) {
                    if (view == b.this.hdh.eNm.getCommentContainer()) {
                        b.this.b(jVar);
                        i = 5;
                    } else if (view == b.this.hdh.eNY.diH.getCommentContainer()) {
                        b.this.b(jVar);
                    } else if (b.this.hdh.buK() != null && view.getId() == b.this.hdh.buK().getId()) {
                        i = 2;
                    } else if (b.this.hdh.buL() != null && view.getId() == b.this.hdh.buL().getId()) {
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
                    anVar.cy(TiebaInitialize.Params.AB_TAG, jVar.bvr());
                    anVar.s("liveid", j);
                    anVar.X("obj_type", i);
                    anVar.cy("tid", str);
                    anVar.cy("obj_param1", jVar.getExtra());
                    anVar.cy("obj_source", jVar.getSource());
                    anVar.X("obj_floor", jVar.bvq());
                    TiebaStatic.log(anVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.cRf, b.this.dBk, jVar.bvq(), i);
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
        this.hdh = new com.baidu.tieba.card.j(this.mPageContext, this.dBk);
        this.hdh.currentPageType = 2;
        if (this.hdh.eNm != null) {
            this.hdh.eNm.dhG = 2;
        }
        if (this.hdh.eNY != null && this.hdh.eNY.diH != null) {
            this.hdh.eNY.diH.dhG = 2;
        }
        if (this.dBk != null) {
            this.hdh.m(this.dBk);
        }
        return new a(this.hdh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.rt(jVar.position + 1);
        if (aVar.hdj instanceof com.baidu.tieba.a.e) {
            aVar.hdj.setPage(this.LC);
        }
        aVar.hdj.rp(i + 1);
        aVar.hdj.a(jVar);
        aVar.hdj.c(this.fWH);
        aVar.hdj.b(this.dUq);
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
            anVar.cy(TiebaInitialize.Params.AB_TAG, jVar.bvr());
            anVar.s("liveid", j);
            anVar.s("fid", jVar.aAg().getFid());
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cy("obj_param1", jVar.getExtra());
            anVar.cy("obj_source", jVar.getSource());
            anVar.X("obj_floor", jVar.bvq());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.cRf, this.dBk, jVar.bvq());
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
        this.dUq = aVar;
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.j hdj;

        public a(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.hdj = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }
}
