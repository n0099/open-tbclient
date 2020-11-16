package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
/* loaded from: classes21.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String ahw;
    private NEGFeedBackView.a fOM;
    public BdUniqueId fsa;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j> inF;
    private com.baidu.tieba.card.l jFh;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fOM = null;
        this.inF = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (d.this.jFh.fXC != view) {
                    if (view == d.this.jFh.gSy.getCommentContainer()) {
                        d.this.b(jVar);
                        i = 5;
                    } else if (view == d.this.jFh.hVY.getCommentContainer()) {
                        d.this.b(jVar);
                    } else if (d.this.jFh.cny() != null && view.getId() == d.this.jFh.cny().getId()) {
                        i = 2;
                    } else if (d.this.jFh.cnz() != null && view.getId() == d.this.jFh.cnz().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.bjd() != null) {
                        i = jVar.bjd().blW().live_type;
                        str = jVar.bjd().getTid();
                        j = jVar.bjd().blW().live_id;
                    }
                    ar arVar = new ar("c11824");
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dR("ab_tag", jVar.cog());
                    arVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    arVar.ak("obj_type", i);
                    arVar.dR("tid", str);
                    arVar.dR("obj_param1", jVar.getExtra());
                    arVar.dR("obj_source", jVar.getSource());
                    arVar.ak("obj_floor", jVar.cof());
                    TiebaStatic.log(arVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.evQ, d.this.fsa, jVar.cof(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public a c(ViewGroup viewGroup) {
        this.jFh = new com.baidu.tieba.card.l(this.mPageContext, this.fsa);
        this.jFh.xy(2);
        if (this.fsa != null) {
            this.jFh.o(this.fsa);
        }
        return new a(this.jFh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.xH(jVar.position + 1);
        if (aVar.jFj instanceof com.baidu.tieba.a.e) {
            aVar.jFj.setPage(this.ahw);
        }
        aVar.jFj.xD(i + 1);
        aVar.jFj.a(jVar);
        aVar.jFj.c(this.inF);
        aVar.jFj.b(this.fOM);
        String str = "";
        if (jVar != null && jVar.bjd() != null) {
            int i2 = jVar.bjd().blW().live_type;
            String tid = jVar.bjd().getTid();
            if (!StringUtils.isNull(jVar.bjd().blW().appId)) {
                str = jVar.bjd().blW().appId;
            }
            long j = jVar.bjd().blW().live_id;
            ar arVar = new ar("c11823");
            arVar.ak("obj_type", i2);
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, str);
            arVar.dR("tid", tid);
            arVar.dR("ab_tag", jVar.cog());
            arVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            arVar.w("fid", jVar.bjd().getFid());
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("obj_param1", jVar.getExtra());
            arVar.dR("obj_source", jVar.getSource());
            arVar.ak("obj_floor", jVar.cof());
            TiebaStatic.log(arVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.evQ, this.fsa, jVar.cof());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        String str2 = "";
        if (jVar != null && jVar.bjd() != null) {
            str = jVar.bjd().getTid();
            str2 = jVar.bjd().getNid();
        }
        ar arVar = new ar("c12942");
        arVar.ak("obj_locate", 1);
        arVar.ak("obj_type", 5);
        arVar.dR("tid", str);
        arVar.dR("obj_source", jVar.getSource());
        arVar.dR("nid", str2);
        TiebaStatic.log(arVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fOM = aVar;
    }

    /* loaded from: classes21.dex */
    public static class a extends af.a {
        public com.baidu.tieba.card.l jFj;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.jFj = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }
}
