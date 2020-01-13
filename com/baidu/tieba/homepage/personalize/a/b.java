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
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String Lg;
    private NEGFeedBackView.a dQj;
    public BdUniqueId dxg;
    com.baidu.tieba.card.z<com.baidu.tieba.card.data.j> fUE;
    private com.baidu.tieba.card.j hbf;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQj = null;
        this.fUE = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (b.this.hbf.ecC != view) {
                    if (view == b.this.hbf.eJr.getCommentContainer()) {
                        b.this.b(jVar);
                        i = 5;
                    } else if (view == b.this.hbf.eKe.deA.getCommentContainer()) {
                        b.this.b(jVar);
                    } else if (b.this.hbf.bte() != null && view.getId() == b.this.hbf.bte().getId()) {
                        i = 2;
                    } else if (b.this.hbf.btf() != null && view.getId() == b.this.hbf.btf().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.axQ() != null) {
                        i = jVar.axQ().aAq().live_type;
                        str = jVar.axQ().getTid();
                        j = jVar.axQ().aAq().live_id;
                    }
                    an anVar = new an("c11824");
                    anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cp(TiebaInitialize.Params.AB_TAG, jVar.btL());
                    anVar.s("liveid", j);
                    anVar.Z("obj_type", i);
                    anVar.cp("tid", str);
                    anVar.cp("obj_param1", jVar.getExtra());
                    anVar.cp("obj_source", jVar.getSource());
                    anVar.Z("obj_floor", jVar.btK());
                    TiebaStatic.log(anVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.cNb, b.this.dxg, jVar.btK(), i);
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
        this.hbf = new com.baidu.tieba.card.j(this.mPageContext, this.dxg);
        this.hbf.currentPageType = 2;
        if (this.hbf.eJr != null) {
            this.hbf.eJr.ddB = 2;
        }
        if (this.hbf.eKe != null && this.hbf.eKe.deA != null) {
            this.hbf.eKe.deA.ddB = 2;
        }
        if (this.dxg != null) {
            this.hbf.m(this.dxg);
        }
        return new a(this.hbf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.rm(jVar.position + 1);
        if (aVar.hbh instanceof com.baidu.tieba.a.e) {
            aVar.hbh.setPage(this.Lg);
        }
        aVar.hbh.ri(i + 1);
        aVar.hbh.a(jVar);
        aVar.hbh.c(this.fUE);
        aVar.hbh.b(this.dQj);
        String str = "";
        if (jVar != null && jVar.axQ() != null) {
            int i2 = jVar.axQ().aAq().live_type;
            String tid = jVar.axQ().getTid();
            if (!StringUtils.isNull(jVar.axQ().aAq().appId)) {
                str = jVar.axQ().aAq().appId;
            }
            long j = jVar.axQ().aAq().live_id;
            an anVar = new an("c11823");
            anVar.Z("obj_type", i2);
            anVar.cp(TiebaInitialize.Params.OBJ_PARAM3, str);
            anVar.cp("tid", tid);
            anVar.cp(TiebaInitialize.Params.AB_TAG, jVar.btL());
            anVar.s("liveid", j);
            anVar.s("fid", jVar.axQ().getFid());
            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.cp("obj_param1", jVar.getExtra());
            anVar.cp("obj_source", jVar.getSource());
            anVar.Z("obj_floor", jVar.btK());
            TiebaStatic.log(anVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.cNb, this.dxg, jVar.btK());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.axQ() != null) {
            str = jVar.axQ().getTid();
        }
        an anVar = new an("c12942");
        anVar.Z("obj_locate", 1);
        anVar.Z("obj_type", 5);
        anVar.cp("tid", str);
        anVar.cp("obj_source", jVar.getSource());
        TiebaStatic.log(anVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dQj = aVar;
    }

    /* loaded from: classes7.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.j hbh;

        public a(com.baidu.tieba.card.j jVar) {
            super(jVar.getView());
            this.hbh = jVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }
}
