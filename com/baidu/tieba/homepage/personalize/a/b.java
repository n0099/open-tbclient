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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.m;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    public BdUniqueId aRF;
    private String bHB;
    private NEGFeedBackView.a biW;
    ad<com.baidu.tieba.card.data.j> dTj;
    private m dYg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.biW = null;
        this.dTj = new ad<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (b.this.dYg.bIN != view) {
                    if (view == b.this.dYg.bHO.getCommentContainer() || view == b.this.dYg.bIC.ayr.getCommentContainer()) {
                        String str = "";
                        if (jVar != null && jVar.Td() != null) {
                            str = jVar.Td().getTid();
                        }
                        an anVar = new an("c12942");
                        anVar.r("obj_locate", 1);
                        anVar.r("obj_type", 5);
                        anVar.af("tid", str);
                        anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                        TiebaStatic.log(anVar);
                        return;
                    }
                    return;
                }
                int i = 0;
                String str2 = "";
                long j = 0;
                if (jVar != null && jVar.Td() != null) {
                    i = jVar.Td().vD().live_type;
                    str2 = jVar.Td().getTid();
                    j = jVar.Td().vD().live_id;
                }
                an anVar2 = new an("c11824");
                anVar2.af("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.af("ab_tag", jVar.ajk());
                anVar2.f("liveid", j);
                anVar2.r("obj_type", i);
                anVar2.af("tid", str2);
                anVar2.af("obj_param1", jVar.getExtra());
                anVar2.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                TiebaStatic.log(anVar2);
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dYg = new m(this.mPageContext);
        this.dYg.currentPageType = 2;
        if (this.dYg.bHO != null) {
            this.dYg.bHO.ajY = 2;
        }
        if (this.dYg.bIC != null && this.dYg.bIC.ayr != null) {
            this.dYg.bIC.ayr.ajY = 2;
        }
        if (this.aRF != null) {
            this.dYg.j(this.aRF);
        }
        return new a(this.dYg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.iX(i + 1);
        }
        if (aVar.dYi instanceof com.baidu.tieba.a.e) {
            aVar.dYi.setPage(this.bHB);
        }
        aVar.dYi.a(jVar);
        aVar.dYi.b(this.dTj);
        aVar.dYi.a(this.biW);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.Td() != null) {
            int i2 = jVar.Td().vD().live_type;
            String tid = jVar.Td().getTid();
            if (!StringUtils.isNull(jVar.Td().vD().appId)) {
                str = jVar.Td().vD().appId;
                j = jVar.Td().vD().live_id;
            }
            an anVar = new an("c11823");
            anVar.r("obj_type", i2);
            anVar.af("obj_param3", str);
            anVar.af("tid", tid);
            anVar.af("ab_tag", jVar.ajk());
            anVar.f("liveid", j);
            anVar.f(ImageViewerConfig.FORUM_ID, jVar.Td().getFid());
            anVar.af("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.af("obj_param1", jVar.getExtra());
            anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            TiebaStatic.log(anVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.biW = aVar;
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public m dYi;

        public a(m mVar) {
            super(mVar.getView());
            this.dYi = mVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }
}
