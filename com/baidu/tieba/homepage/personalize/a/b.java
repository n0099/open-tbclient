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
    public BdUniqueId aRC;
    private String bHB;
    private NEGFeedBackView.a bjc;
    ad<com.baidu.tieba.card.data.j> dTe;
    private m dYd;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bjc = null;
        this.dTe = new ad<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (b.this.dYd.bIN != view) {
                    if (view == b.this.dYd.bHO.getCommentContainer() || view == b.this.dYd.bIC.ayo.getCommentContainer()) {
                        String str = "";
                        if (jVar != null && jVar.Tg() != null) {
                            str = jVar.Tg().getTid();
                        }
                        an anVar = new an("c12942");
                        anVar.r("obj_locate", 1);
                        anVar.r("obj_type", 5);
                        anVar.ae("tid", str);
                        anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                        TiebaStatic.log(anVar);
                        return;
                    }
                    return;
                }
                int i = 0;
                String str2 = "";
                long j = 0;
                if (jVar != null && jVar.Tg() != null) {
                    i = jVar.Tg().vC().live_type;
                    str2 = jVar.Tg().getTid();
                    j = jVar.Tg().vC().live_id;
                }
                an anVar2 = new an("c11824");
                anVar2.ae("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.ae("ab_tag", jVar.ajn());
                anVar2.f("liveid", j);
                anVar2.r("obj_type", i);
                anVar2.ae("tid", str2);
                anVar2.ae("obj_param1", jVar.getExtra());
                anVar2.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
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
        this.dYd = new m(this.mPageContext);
        this.dYd.currentPageType = 2;
        if (this.dYd.bHO != null) {
            this.dYd.bHO.ajY = 2;
        }
        if (this.dYd.bIC != null && this.dYd.bIC.ayo != null) {
            this.dYd.bIC.ayo.ajY = 2;
        }
        if (this.aRC != null) {
            this.dYd.j(this.aRC);
        }
        return new a(this.dYd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.iW(i + 1);
        }
        if (aVar.dYf instanceof com.baidu.tieba.a.e) {
            aVar.dYf.setPage(this.bHB);
        }
        aVar.dYf.a(jVar);
        aVar.dYf.b(this.dTe);
        aVar.dYf.a(this.bjc);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.Tg() != null) {
            int i2 = jVar.Tg().vC().live_type;
            String tid = jVar.Tg().getTid();
            if (!StringUtils.isNull(jVar.Tg().vC().appId)) {
                str = jVar.Tg().vC().appId;
                j = jVar.Tg().vC().live_id;
            }
            an anVar = new an("c11823");
            anVar.r("obj_type", i2);
            anVar.ae("obj_param3", str);
            anVar.ae("tid", tid);
            anVar.ae("ab_tag", jVar.ajn());
            anVar.f("liveid", j);
            anVar.f(ImageViewerConfig.FORUM_ID, jVar.Tg().getFid());
            anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.ae("obj_param1", jVar.getExtra());
            anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            TiebaStatic.log(anVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bjc = aVar;
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public m dYf;

        public a(m mVar) {
            super(mVar.getView());
            this.dYf = mVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }
}
