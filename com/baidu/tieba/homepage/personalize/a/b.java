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
    private String bGM;
    private NEGFeedBackView.a bir;
    ad<com.baidu.tieba.card.data.j> dQw;
    private m dUo;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bir = null;
        this.dQw = new ad<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (b.this.dUo.cvV != view) {
                    if (view == b.this.dUo.bGZ.getCommentContainer() || view == b.this.dUo.bHN.ayE.getCommentContainer()) {
                        String str = "";
                        if (jVar != null && jVar.SV() != null) {
                            str = jVar.SV().getTid();
                        }
                        an anVar = new an("c12942");
                        anVar.r("obj_locate", 1);
                        anVar.r("obj_type", 5);
                        anVar.ah("tid", str);
                        anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                        TiebaStatic.log(anVar);
                        return;
                    }
                    return;
                }
                int i = 0;
                String str2 = "";
                long j = 0;
                if (jVar != null && jVar.SV() != null) {
                    i = jVar.SV().vO().live_type;
                    str2 = jVar.SV().getTid();
                    j = jVar.SV().vO().live_id;
                }
                an anVar2 = new an("c11824");
                anVar2.ah("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.ah("ab_tag", jVar.aiL());
                anVar2.f("liveid", j);
                anVar2.r("obj_type", i);
                anVar2.ah("tid", str2);
                anVar2.ah("obj_param1", jVar.getExtra());
                anVar2.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                TiebaStatic.log(anVar2);
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dUo = new m(this.mPageContext);
        this.dUo.currentPageType = 2;
        if (this.dUo.bGZ != null) {
            this.dUo.bGZ.akz = 2;
        }
        if (this.dUo.bHN != null && this.dUo.bHN.ayE != null) {
            this.dUo.bHN.ayE.akz = 2;
        }
        if (this.aRF != null) {
            this.dUo.j(this.aRF);
        }
        return new a(this.dUo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.iL(i + 1);
        }
        if (aVar.dUq instanceof com.baidu.tieba.a.e) {
            aVar.dUq.setPage(this.bGM);
        }
        aVar.dUq.a(jVar);
        aVar.dUq.b(this.dQw);
        aVar.dUq.a(this.bir);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.SV() != null) {
            int i2 = jVar.SV().vO().live_type;
            String tid = jVar.SV().getTid();
            if (!StringUtils.isNull(jVar.SV().vO().appId)) {
                str = jVar.SV().vO().appId;
                j = jVar.SV().vO().live_id;
            }
            an anVar = new an("c11823");
            anVar.r("obj_type", i2);
            anVar.ah("obj_param3", str);
            anVar.ah("tid", tid);
            anVar.ah("ab_tag", jVar.aiL());
            anVar.f("liveid", j);
            anVar.f(ImageViewerConfig.FORUM_ID, jVar.SV().getFid());
            anVar.ah("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.ah("obj_param1", jVar.getExtra());
            anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            TiebaStatic.log(anVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bir = aVar;
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public m dUq;

        public a(m mVar) {
            super(mVar.getView());
            this.dUq = mVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }
}
