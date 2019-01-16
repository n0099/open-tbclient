package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.m;
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    public BdUniqueId bes;
    private NEGFeedBackView.a bxO;
    private String cbk;
    ad<com.baidu.tieba.card.data.j> eub;
    private m ezi;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bxO = null;
        this.eub = new ad<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i;
                if (b.this.ezi.ccw != view) {
                    if (view == b.this.ezi.cbx.getCommentContainer()) {
                        b.this.b(jVar);
                        com.baidu.tieba.q.c.bCC().b(b.this.bes, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 5, jVar.aqZ(), false, null, null));
                        return;
                    } else if (view == b.this.ezi.cck.aKM.getCommentContainer()) {
                        b.this.b(jVar);
                        return;
                    } else if (b.this.ezi.getHeaderImg() == null || view.getId() != b.this.ezi.getHeaderImg().getId()) {
                        if (b.this.ezi.aqs() != null && view.getId() == b.this.ezi.aqs().getId()) {
                            com.baidu.tieba.q.c.bCC().b(b.this.bes, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aqZ(), false, null, null));
                            return;
                        }
                        return;
                    } else {
                        com.baidu.tieba.q.c.bCC().b(b.this.bes, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aqZ(), false, null, null));
                        return;
                    }
                }
                String str = "";
                long j = 0;
                if (jVar == null || jVar.aaq() == null) {
                    i = 0;
                } else {
                    i = jVar.aaq().An().live_type;
                    str = jVar.aaq().getTid();
                    j = jVar.aaq().An().live_id;
                }
                am amVar = new am("c11824");
                amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.aB("ab_tag", jVar.arb());
                amVar.i("liveid", j);
                amVar.y("obj_type", i);
                amVar.aB("tid", str);
                amVar.aB("obj_param1", jVar.getExtra());
                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                amVar.y("obj_floor", jVar.aqZ());
                TiebaStatic.log(amVar);
                com.baidu.tieba.q.c.bCC().b(b.this.bes, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 1, jVar.aqZ(), false, null, null));
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.ezi = new m(this.mPageContext);
        this.ezi.currentPageType = 2;
        if (this.ezi.cbx != null) {
            this.ezi.cbx.awo = 2;
        }
        if (this.ezi.cck != null && this.ezi.cck.aKM != null) {
            this.ezi.cck.aKM.awo = 2;
        }
        if (this.bes != null) {
            this.ezi.j(this.bes);
        }
        return new a(this.ezi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.kP(i + 1);
        }
        if (aVar.ezk instanceof com.baidu.tieba.a.e) {
            aVar.ezk.setPage(this.cbk);
        }
        aVar.ezk.kL(i + 1);
        aVar.ezk.a(jVar);
        aVar.ezk.b(this.eub);
        aVar.ezk.a(this.bxO);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.aaq() != null) {
            int i2 = jVar.aaq().An().live_type;
            String tid = jVar.aaq().getTid();
            if (!StringUtils.isNull(jVar.aaq().An().appId)) {
                str = jVar.aaq().An().appId;
                j = jVar.aaq().An().live_id;
            }
            am amVar = new am("c11823");
            amVar.y("obj_type", i2);
            amVar.aB("obj_param3", str);
            amVar.aB("tid", tid);
            amVar.aB("ab_tag", jVar.arb());
            amVar.i("liveid", j);
            amVar.i(ImageViewerConfig.FORUM_ID, jVar.aaq().getFid());
            amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.aB("obj_param1", jVar.getExtra());
            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            amVar.y("obj_floor", jVar.aqZ());
            TiebaStatic.log(amVar);
        }
        com.baidu.tieba.q.c.bCC().a(this.bes, jVar.threadData != null ? jVar.threadData.getId() : null, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_exp", jVar.aqZ(), false, null, null));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.aaq() != null) {
            str = jVar.aaq().getTid();
        }
        am amVar = new am("c12942");
        amVar.y("obj_locate", 1);
        amVar.y("obj_type", 5);
        amVar.aB("tid", str);
        amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
        TiebaStatic.log(amVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bxO = aVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public m ezk;

        public a(m mVar) {
            super(mVar.getView());
            this.ezk = mVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbk = str;
    }
}
