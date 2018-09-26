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
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    public BdUniqueId aUU;
    private String bNq;
    private NEGFeedBackView.a boM;
    ad<com.baidu.tieba.card.data.j> eav;
    private m efx;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.boM = null;
        this.eav = new ad<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (b.this.efx.bOC != view) {
                    if (view == b.this.efx.bND.getCommentContainer() || view == b.this.efx.bOr.aBl.getCommentContainer()) {
                        String str = "";
                        if (jVar != null && jVar.UT() != null) {
                            str = jVar.UT().getTid();
                        }
                        am amVar = new am("c12942");
                        amVar.w("obj_locate", 1);
                        amVar.w("obj_type", 5);
                        amVar.al("tid", str);
                        amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                        TiebaStatic.log(amVar);
                        return;
                    }
                    return;
                }
                int i = 0;
                String str2 = "";
                long j = 0;
                if (jVar != null && jVar.UT() != null) {
                    i = jVar.UT().wG().live_type;
                    str2 = jVar.UT().getTid();
                    j = jVar.UT().wG().live_id;
                }
                am amVar2 = new am("c11824");
                amVar2.al("uid", TbadkCoreApplication.getCurrentAccount());
                amVar2.al("ab_tag", jVar.akY());
                amVar2.g("liveid", j);
                amVar2.w("obj_type", i);
                amVar2.al("tid", str2);
                amVar2.al("obj_param1", jVar.getExtra());
                amVar2.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                TiebaStatic.log(amVar2);
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.efx = new m(this.mPageContext);
        this.efx.currentPageType = 2;
        if (this.efx.bND != null) {
            this.efx.bND.amD = 2;
        }
        if (this.efx.bOr != null && this.efx.bOr.aBl != null) {
            this.efx.bOr.aBl.amD = 2;
        }
        if (this.aUU != null) {
            this.efx.j(this.aUU);
        }
        return new a(this.efx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.jv(i + 1);
        }
        if (aVar.efz instanceof com.baidu.tieba.a.e) {
            aVar.efz.setPage(this.bNq);
        }
        aVar.efz.a(jVar);
        aVar.efz.b(this.eav);
        aVar.efz.a(this.boM);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.UT() != null) {
            int i2 = jVar.UT().wG().live_type;
            String tid = jVar.UT().getTid();
            if (!StringUtils.isNull(jVar.UT().wG().appId)) {
                str = jVar.UT().wG().appId;
                j = jVar.UT().wG().live_id;
            }
            am amVar = new am("c11823");
            amVar.w("obj_type", i2);
            amVar.al("obj_param3", str);
            amVar.al("tid", tid);
            amVar.al("ab_tag", jVar.akY());
            amVar.g("liveid", j);
            amVar.g(ImageViewerConfig.FORUM_ID, jVar.UT().getFid());
            amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.al("obj_param1", jVar.getExtra());
            amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            TiebaStatic.log(amVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.boM = aVar;
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public m efz;

        public a(m mVar) {
            super(mVar.getView());
            this.efz = mVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }
}
