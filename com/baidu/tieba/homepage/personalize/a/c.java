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
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String LC;
    public BdUniqueId dBK;
    private NEGFeedBackView.a dUT;
    com.baidu.tieba.card.z<com.baidu.tieba.card.data.j> fXC;
    private com.baidu.tieba.card.j heK;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dUT = null;
        this.fXC = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (c.this.heK.ehj != view) {
                    if (view == c.this.heK.eNX.getCommentContainer()) {
                        c.this.b(jVar);
                        i = 5;
                    } else if (view == c.this.heK.eOJ.djh.getCommentContainer()) {
                        c.this.b(jVar);
                    } else if (c.this.heK.buQ() != null && view.getId() == c.this.heK.buQ().getId()) {
                        i = 2;
                    } else if (c.this.heK.buR() != null && view.getId() == c.this.heK.buR().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.aAj() != null) {
                        i = jVar.aAj().aCK().live_type;
                        str = jVar.aAj().getTid();
                        j = jVar.aAj().aCK().live_id;
                    }
                    an anVar = new an("c11824");
                    anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cx(TiebaInitialize.Params.AB_TAG, jVar.bvx());
                    anVar.s("liveid", j);
                    anVar.X("obj_type", i);
                    anVar.cx("tid", str);
                    anVar.cx("obj_param1", jVar.getExtra());
                    anVar.cx("obj_source", jVar.getSource());
                    anVar.X("obj_floor", jVar.bvw());
                    TiebaStatic.log(anVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.cRt, c.this.dBK, jVar.bvw(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public a b(ViewGroup viewGroup) {
        this.heK = new com.baidu.tieba.card.j(this.mPageContext, this.dBK);
        this.heK.currentPageType = 2;
        if (this.heK.eNX != null) {
            this.heK.eNX.dih = 2;
        }
        if (this.heK.eOJ != null && this.heK.eOJ.djh != null) {
            this.heK.eOJ.djh.dih = 2;
        }
        if (this.dBK != null) {
            this.heK.m(this.dBK);
        }
        return new a(this.heK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.rv(jVar.position + 1);
        if (aVar.heM instanceof com.baidu.tieba.a.e) {
            aVar.heM.setPage(this.LC);
        }
        aVar.heM.rr(i + 1);
        aVar.heM.a(jVar);
        aVar.heM.c(this.fXC);
        aVar.heM.b(this.dUT);
        String str = "";
        if (jVar != null && jVar.aAj() != null) {
            int i2 = jVar.aAj().aCK().live_type;
            String tid = jVar.aAj().getTid();
            if (!StringUtils.isNull(jVar.aAj().aCK().appId)) {
                str = jVar.aAj().aCK().appId;
            }
            long j = jVar.aAj().aCK().live_id;
            an anVar = new an("c11823");
            anVar.X("obj_type", i2);
            anVar.cx(TiebaInitialize.Params.OBJ_PARAM3, str);
            anVar.cx("tid", tid);
            anVar.cx(TiebaInitialize.Params.AB_TAG, jVar.bvx());
            anVar.s("liveid", j);
            anVar.s("fid", jVar.aAj().getFid());
            anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cx("obj_param1", jVar.getExtra());
            anVar.cx("obj_source", jVar.getSource());
            anVar.X("obj_floor", jVar.bvw());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.cRt, this.dBK, jVar.bvw());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.aAj() != null) {
            str = jVar.aAj().getTid();
        }
        an anVar = new an("c12942");
        anVar.X("obj_locate", 1);
        anVar.X("obj_type", 5);
        anVar.cx("tid", str);
        anVar.cx("obj_source", jVar.getSource());
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUT = aVar;
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.j heM;

        public a(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.heM = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }
}
