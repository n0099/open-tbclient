package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String Wt;
    private NEGFeedBackView.a cRf;
    public BdUniqueId cwh;
    ab<com.baidu.tieba.card.data.j> eUb;
    private com.baidu.tieba.card.l gcI;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cRf = null;
        this.eUb = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i;
                if (b.this.gcI.dCd != view) {
                    if (view == b.this.gcI.dBR.getCommentContainer()) {
                        b.this.b(jVar);
                        com.baidu.tieba.q.c.clt().b(b.this.cwh, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 5, jVar.aXW(), false, (String) null, (String) null));
                        return;
                    } else if (view == b.this.gcI.dBS.cbw.getCommentContainer()) {
                        b.this.b(jVar);
                        return;
                    } else if (b.this.gcI.aXs() == null || view.getId() != b.this.gcI.aXs().getId()) {
                        if (b.this.gcI.aXt() != null && view.getId() == b.this.gcI.aXt().getId()) {
                            com.baidu.tieba.q.c.clt().b(b.this.cwh, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aXW(), false, (String) null, (String) null));
                            return;
                        }
                        return;
                    } else {
                        com.baidu.tieba.q.c.clt().b(b.this.cwh, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aXW(), false, (String) null, (String) null));
                        return;
                    }
                }
                String str = "";
                long j = 0;
                if (jVar == null || jVar.abv() == null) {
                    i = 0;
                } else {
                    i = jVar.abv().adO().live_type;
                    str = jVar.abv().getTid();
                    j = jVar.abv().adO().live_id;
                }
                am amVar = new am("c11824");
                amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.bT("ab_tag", jVar.aXX());
                amVar.l("liveid", j);
                amVar.P("obj_type", i);
                amVar.bT("tid", str);
                amVar.bT("obj_param1", jVar.getExtra());
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                amVar.P("obj_floor", jVar.aXW());
                TiebaStatic.log(amVar);
                com.baidu.tieba.q.c.clt().b(b.this.cwh, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 1, jVar.aXW(), false, (String) null, (String) null));
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.gcI = new com.baidu.tieba.card.l(this.mPageContext);
        this.gcI.currentPageType = 2;
        if (this.gcI.dBR != null) {
            this.gcI.dBR.caC = 2;
        }
        if (this.gcI.dBS != null && this.gcI.dBS.cbw != null) {
            this.gcI.dBS.cbw.caC = 2;
        }
        if (this.cwh != null) {
            this.gcI.k(this.cwh);
        }
        return new a(this.gcI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.ps(jVar.position + 1);
        if (aVar.gcK instanceof com.baidu.tieba.a.e) {
            aVar.gcK.setPage(this.Wt);
        }
        aVar.gcK.po(i + 1);
        aVar.gcK.a(jVar);
        aVar.gcK.d(this.eUb);
        aVar.gcK.b(this.cRf);
        String str = "";
        if (jVar != null && jVar.abv() != null) {
            int i2 = jVar.abv().adO().live_type;
            String tid = jVar.abv().getTid();
            if (!StringUtils.isNull(jVar.abv().adO().appId)) {
                str = jVar.abv().adO().appId;
            }
            long j = jVar.abv().adO().live_id;
            am amVar = new am("c11823");
            amVar.P("obj_type", i2);
            amVar.bT("obj_param3", str);
            amVar.bT("tid", tid);
            amVar.bT("ab_tag", jVar.aXX());
            amVar.l("liveid", j);
            amVar.l("fid", jVar.abv().getFid());
            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bT("obj_param1", jVar.getExtra());
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            amVar.P("obj_floor", jVar.aXW());
            TiebaStatic.log(amVar);
        }
        com.baidu.tieba.q.c.clt().a(this.cwh, jVar.threadData != null ? jVar.threadData.getId() : null, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_exp", jVar.aXW(), false, null, null));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.abv() != null) {
            str = jVar.abv().getTid();
        }
        am amVar = new am("c12942");
        amVar.P("obj_locate", 1);
        amVar.P("obj_type", 5);
        amVar.bT("tid", str);
        amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
        TiebaStatic.log(amVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cRf = aVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.l gcK;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.gcK = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }
}
