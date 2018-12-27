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
    public BdUniqueId bdH;
    private NEGFeedBackView.a bxa;
    private String caz;
    ad<com.baidu.tieba.card.data.j> etv;
    private m eyy;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bxa = null;
        this.etv = new ad<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                int i;
                if (b.this.eyy.cbK != view) {
                    if (view == b.this.eyy.caM.getCommentContainer()) {
                        b.this.b(jVar);
                        com.baidu.tieba.q.c.bBT().b(b.this.bdH, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 5, jVar.aqC(), false, null, null));
                        return;
                    } else if (view == b.this.eyy.cbz.aKk.getCommentContainer()) {
                        b.this.b(jVar);
                        return;
                    } else if (b.this.eyy.getHeaderImg() == null || view.getId() != b.this.eyy.getHeaderImg().getId()) {
                        if (b.this.eyy.apV() != null && view.getId() == b.this.eyy.apV().getId()) {
                            com.baidu.tieba.q.c.bBT().b(b.this.bdH, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aqC(), false, null, null));
                            return;
                        }
                        return;
                    } else {
                        com.baidu.tieba.q.c.bBT().b(b.this.bdH, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 2, jVar.aqC(), false, null, null));
                        return;
                    }
                }
                String str = "";
                long j = 0;
                if (jVar == null || jVar.ZT() == null) {
                    i = 0;
                } else {
                    i = jVar.ZT().Aa().live_type;
                    str = jVar.ZT().getTid();
                    j = jVar.ZT().Aa().live_id;
                }
                am amVar = new am("c11824");
                amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
                amVar.aA("ab_tag", jVar.aqE());
                amVar.i("liveid", j);
                amVar.x("obj_type", i);
                amVar.aA("tid", str);
                amVar.aA("obj_param1", jVar.getExtra());
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                amVar.x("obj_floor", jVar.aqC());
                TiebaStatic.log(amVar);
                com.baidu.tieba.q.c.bBT().b(b.this.bdH, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_click", 1, jVar.aqC(), false, null, null));
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.eyy = new m(this.mPageContext);
        this.eyy.currentPageType = 2;
        if (this.eyy.caM != null) {
            this.eyy.caM.avM = 2;
        }
        if (this.eyy.cbz != null && this.eyy.cbz.aKk != null) {
            this.eyy.cbz.aKk.avM = 2;
        }
        if (this.bdH != null) {
            this.eyy.j(this.bdH);
        }
        return new a(this.eyy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.kP(i + 1);
        }
        if (aVar.eyA instanceof com.baidu.tieba.a.e) {
            aVar.eyA.setPage(this.caz);
        }
        aVar.eyA.kL(i + 1);
        aVar.eyA.a(jVar);
        aVar.eyA.b(this.etv);
        aVar.eyA.a(this.bxa);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.ZT() != null) {
            int i2 = jVar.ZT().Aa().live_type;
            String tid = jVar.ZT().getTid();
            if (!StringUtils.isNull(jVar.ZT().Aa().appId)) {
                str = jVar.ZT().Aa().appId;
                j = jVar.ZT().Aa().live_id;
            }
            am amVar = new am("c11823");
            amVar.x("obj_type", i2);
            amVar.aA("obj_param3", str);
            amVar.aA("tid", tid);
            amVar.aA("ab_tag", jVar.aqE());
            amVar.i("liveid", j);
            amVar.i(ImageViewerConfig.FORUM_ID, jVar.ZT().getFid());
            amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.aA("obj_param1", jVar.getExtra());
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            amVar.x("obj_floor", jVar.aqC());
            TiebaStatic.log(amVar);
        }
        com.baidu.tieba.q.c.bBT().a(this.bdH, jVar.threadData != null ? jVar.threadData.getId() : null, com.baidu.tieba.q.a.a(jVar.threadData, "a002", "common_exp", jVar.aqC(), false, null, null));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.card.data.j jVar) {
        String str = "";
        if (jVar != null && jVar.ZT() != null) {
            str = jVar.ZT().getTid();
        }
        am amVar = new am("c12942");
        amVar.x("obj_locate", 1);
        amVar.x("obj_type", 5);
        amVar.aA("tid", str);
        amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
        TiebaStatic.log(amVar);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bxa = aVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public m eyA;

        public a(m mVar) {
            super(mVar.getView());
            this.eyA = mVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void jL(String str) {
        this.caz = str;
    }
}
