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
    private NEGFeedBackView.a cRg;
    public BdUniqueId cwh;
    ab<com.baidu.tieba.card.data.j> eUc;
    private com.baidu.tieba.card.l gcJ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cRg = null;
        this.eUc = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i;
                if (b.this.gcJ.dCe != view) {
                    if (view == b.this.gcJ.dBS.getCommentContainer()) {
                        b.this.b(jVar);
                        com.baidu.tieba.q.c.clv().b(b.this.cwh, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 5, jVar.aXZ(), false, (String) null, (String) null));
                        return;
                    } else if (view == b.this.gcJ.dBT.cbw.getCommentContainer()) {
                        b.this.b(jVar);
                        return;
                    } else if (b.this.gcJ.aXv() == null || view.getId() != b.this.gcJ.aXv().getId()) {
                        if (b.this.gcJ.aXw() != null && view.getId() == b.this.gcJ.aXw().getId()) {
                            com.baidu.tieba.q.c.clv().b(b.this.cwh, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aXZ(), false, (String) null, (String) null));
                            return;
                        }
                        return;
                    } else {
                        com.baidu.tieba.q.c.clv().b(b.this.cwh, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aXZ(), false, (String) null, (String) null));
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
                amVar.bT("ab_tag", jVar.aYa());
                amVar.l("liveid", j);
                amVar.P("obj_type", i);
                amVar.bT("tid", str);
                amVar.bT("obj_param1", jVar.getExtra());
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                amVar.P("obj_floor", jVar.aXZ());
                TiebaStatic.log(amVar);
                com.baidu.tieba.q.c.clv().b(b.this.cwh, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 1, jVar.aXZ(), false, (String) null, (String) null));
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.gcJ = new com.baidu.tieba.card.l(this.mPageContext);
        this.gcJ.currentPageType = 2;
        if (this.gcJ.dBS != null) {
            this.gcJ.dBS.caC = 2;
        }
        if (this.gcJ.dBT != null && this.gcJ.dBT.cbw != null) {
            this.gcJ.dBT.cbw.caC = 2;
        }
        if (this.cwh != null) {
            this.gcJ.k(this.cwh);
        }
        return new a(this.gcJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        jVar.ps(jVar.position + 1);
        if (aVar.gcL instanceof com.baidu.tieba.a.e) {
            aVar.gcL.setPage(this.Wt);
        }
        aVar.gcL.po(i + 1);
        aVar.gcL.a(jVar);
        aVar.gcL.d(this.eUc);
        aVar.gcL.b(this.cRg);
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
            amVar.bT("ab_tag", jVar.aYa());
            amVar.l("liveid", j);
            amVar.l("fid", jVar.abv().getFid());
            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.bT("obj_param1", jVar.getExtra());
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            amVar.P("obj_floor", jVar.aXZ());
            TiebaStatic.log(amVar);
        }
        com.baidu.tieba.q.c.clv().a(this.cwh, jVar.threadData != null ? jVar.threadData.getId() : null, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_exp", jVar.aXZ(), false, null, null));
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
        this.cRg = aVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.card.l gcL;

        public a(com.baidu.tieba.card.l lVar) {
            super(lVar.getView());
            this.gcL = lVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }
}
