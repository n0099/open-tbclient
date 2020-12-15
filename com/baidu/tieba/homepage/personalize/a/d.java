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
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String aiw;
    private NEGFeedBackView.a fWC;
    public BdUniqueId fzO;
    com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j> iyz;
    private com.baidu.tieba.card.l jSM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fWC = null;
        this.iyz = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i = 0;
                if (d.this.jSM.gfP != view) {
                    if (view == d.this.jSM.hbN.getCommentContainer()) {
                        d.this.a(jVar, view);
                        i = 5;
                    } else if (view == d.this.jSM.igX.getCommentContainer()) {
                        d.this.a(jVar, view);
                    } else if (d.this.jSM.crM() != null && view.getId() == d.this.jSM.crM().getId()) {
                        i = 2;
                    } else if (d.this.jSM.crN() != null && view.getId() == d.this.jSM.crN().getId()) {
                        i = 2;
                    }
                } else {
                    String str = "";
                    long j = 0;
                    if (jVar != null && jVar.bmn() != null) {
                        i = jVar.bmn().bpj().live_type;
                        str = jVar.bmn().getTid();
                        j = jVar.bmn().bpj().live_id;
                    }
                    ar arVar = new ar("c11824");
                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dY("ab_tag", jVar.csu());
                    arVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    arVar.al("obj_type", i);
                    arVar.dY("tid", str);
                    arVar.dY("obj_param1", jVar.getExtra());
                    arVar.dY("obj_source", jVar.getSource());
                    arVar.al("obj_floor", jVar.cst());
                    TiebaStatic.log(arVar);
                    i = 1;
                }
                if (i != 0) {
                    com.baidu.tieba.homepage.personalize.c.a.a(jVar.eCR, d.this.fzO, jVar.cst(), i);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public a c(ViewGroup viewGroup) {
        this.jSM = new com.baidu.tieba.card.l(this.mPageContext, this.fzO);
        this.jSM.ye(2);
        if (this.fzO != null) {
            this.jSM.o(this.fzO);
        }
        return new a(this.jSM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.ym(jVar.position + 1);
        if (aVar.jSO instanceof com.baidu.tieba.a.e) {
            aVar.jSO.setPage(this.aiw);
        }
        aVar.jSO.yj(i + 1);
        aVar.jSO.a(jVar);
        aVar.jSO.c(this.iyz);
        aVar.jSO.b(this.fWC);
        String str = "";
        if (jVar != null && jVar.bmn() != null) {
            int i2 = jVar.bmn().bpj().live_type;
            String tid = jVar.bmn().getTid();
            if (!StringUtils.isNull(jVar.bmn().bpj().appId)) {
                str = jVar.bmn().bpj().appId;
            }
            long j = jVar.bmn().bpj().live_id;
            ar arVar = new ar("c11823");
            arVar.al("obj_type", i2);
            arVar.dY(TiebaInitialize.Params.OBJ_PARAM3, str);
            arVar.dY("tid", tid);
            arVar.dY("ab_tag", jVar.csu());
            arVar.w(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
            arVar.w("fid", jVar.bmn().getFid());
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dY("obj_param1", jVar.getExtra());
            arVar.dY("obj_source", jVar.getSource());
            arVar.al("obj_floor", jVar.cst());
            TiebaStatic.log(arVar);
        }
        com.baidu.tieba.homepage.personalize.c.a.a(jVar.eCR, this.fzO, jVar.cst());
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.card.data.j jVar, View view) {
        String str = "";
        String str2 = "";
        if (jVar != null && jVar.bmn() != null) {
            str = jVar.bmn().getTid();
            str2 = jVar.bmn().getNid();
        }
        ar arVar = new ar("c12942");
        arVar.al("obj_locate", 1);
        arVar.al("obj_type", 5);
        arVar.dY("tid", str);
        arVar.dY("obj_source", jVar.getSource());
        arVar.dY("nid", str2);
        com.baidu.tbadk.pageExtra.c bM = com.baidu.tbadk.pageExtra.d.bM(view);
        if (bM != null) {
            arVar.dY("obj_cur_page", bM.getCurrentPageKey());
        }
        if (com.baidu.tbadk.pageExtra.d.bET() != null) {
            arVar.dY("obj_pre_page", com.baidu.tbadk.pageExtra.d.bET());
        }
        TiebaStatic.log(arVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fWC = aVar;
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public com.baidu.tieba.card.l jSO;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.jSO = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }
}
