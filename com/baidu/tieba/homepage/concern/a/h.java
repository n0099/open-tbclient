package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<l, a> implements com.baidu.tieba.a.f {
    public BdUniqueId aRF;
    private String bGM;
    private com.baidu.tieba.homepage.concern.view.c dQL;
    private ad dQw;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQw = new ad<l>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, l lVar) {
                if (view != null && h.this.dQL != null && h.this.dQL.getView() != null && lVar != null && lVar.SV() != null && !StringUtils.isNull(lVar.SV().getTid())) {
                    an anVar = new an("c12352");
                    if ((h.this.dQL.getHeaderImg() != null && view.getId() == h.this.dQL.getHeaderImg().getId()) || (h.this.dQL.aid() != null && view.getId() == h.this.dQL.aid().getId())) {
                        anVar.r("obj_locate", 1);
                    } else {
                        anVar.r("obj_locate", 2);
                    }
                    anVar.r("obj_type", 2);
                    anVar.ah("tid", lVar.btc.getTid());
                    anVar.f(ImageViewerConfig.FORUM_ID, lVar.btc.getFid());
                    anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    anVar.r("obj_param1", lVar.aiP() ? 2 : 1);
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dQL = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.aRF != null) {
            this.dQL.j(this.aRF);
        }
        return new a(this.dQL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.dQN == null) {
            return null;
        }
        lVar.iL(i + 1);
        v.aiz().a(lVar.lf("c12351"));
        if (aVar.dQN instanceof com.baidu.tieba.a.e) {
            aVar.dQN.setPage(this.bGM);
        }
        aVar.dQN.a(lVar);
        aVar.dQN.b(this.dQw);
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public com.baidu.tieba.homepage.concern.view.c dQN;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.dQN = cVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }
}
