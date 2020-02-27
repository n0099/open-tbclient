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
    public BdUniqueId dBj;
    private NEGFeedBackView.a dUp;
    com.baidu.tieba.card.z<com.baidu.tieba.card.data.j> fWF;
    private com.baidu.tieba.card.j hdf;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dUp = null;
        this.fWF = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (b.this.hdf.egF != view) {
                    if (view == b.this.hdf.eNl.getCommentContainer()) {
                        b.this.b(jVar);
                        i = 5;
                    } else if (view == b.this.hdf.eNX.diG.getCommentContainer()) {
                        b.this.b(jVar);
                    } else if (b.this.hdf.buI() != null && view.getId() == b.this.hdf.buI().getId()) {
                        i = 2;
                    } else if (b.this.hdf.buJ() != null && view.getId() == b.this.hdf.buJ().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.aAe() != null) {
                        i = jVar.aAe().aCF().live_type;
                        str = jVar.aAe().getTid();
                        j = jVar.aAe().aCF().live_id;
                    }
                    an anVar = new an("c11824");
                    anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cy(TiebaInitialize.Params.AB_TAG, jVar.bvp());
                    anVar.s("liveid", j);
                    anVar.X("obj_type", i);
                    anVar.cy("tid", str);
                    anVar.cy("obj_param1", jVar.getExtra());
                    anVar.cy("obj_source", jVar.getSource());
                    anVar.X("obj_floor", jVar.bvo());
                    TiebaStatic.log(anVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.cRe, b.this.dBj, jVar.bvo(), i);
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
        this.hdf = new com.baidu.tieba.card.j(this.mPageContext, this.dBj);
        this.hdf.currentPageType = 2;
        if (this.hdf.eNl != null) {
            this.hdf.eNl.dhF = 2;
        }
        if (this.hdf.eNX != null && this.hdf.eNX.diG != null) {
            this.hdf.eNX.diG.dhF = 2;
        }
        if (this.dBj != null) {
            this.hdf.m(this.dBj);
        }
        return new a(this.hdf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.rt(jVar.position + 1);
        if (aVar.hdh instanceof com.baidu.tieba.a.e) {
            aVar.hdh.setPage(this.LC);
        }
        aVar.hdh.rp(i + 1);
        aVar.hdh.a(jVar);
        aVar.hdh.c(this.fWF);
        aVar.hdh.b(this.dUp);
        String str = "";
        if (jVar != null && jVar.aAe() != null) {
            int i2 = jVar.aAe().aCF().live_type;
            String tid = jVar.aAe().getTid();
            if (!StringUtils.isNull(jVar.aAe().aCF().appId)) {
                str = jVar.aAe().aCF().appId;
            }
            long j = jVar.aAe().aCF().live_id;
            an anVar = new an("c11823");
            anVar.X("obj_type", i2);
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM3, str);
            anVar.cy("tid", tid);
            anVar.cy(TiebaInitialize.Params.AB_TAG, jVar.bvp());
            anVar.s("liveid", j);
            anVar.s("fid", jVar.aAe().getFid());
            anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cy("obj_param1", jVar.getExtra());
            anVar.cy("obj_source", jVar.getSource());
            anVar.X("obj_floor", jVar.bvo());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.cRe, this.dBj, jVar.bvo());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.aAe() != null) {
            str = jVar.aAe().getTid();
        }
        an anVar = new an("c12942");
        anVar.X("obj_locate", 1);
        anVar.X("obj_type", 5);
        anVar.cy("tid", str);
        anVar.cy("obj_source", jVar.getSource());
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUp = aVar;
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.j hdh;

        public a(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.hdh = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }
}
