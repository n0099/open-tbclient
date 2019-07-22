package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, a> implements com.baidu.tieba.a.f {
    private String WN;
    public BdUniqueId cxx;
    private ab eZd;
    private com.baidu.tieba.homepage.concern.view.b gcO;
    private TbPageContext<?> mPageContext;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eZd = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (view != null && n.this.gcO != null && n.this.gcO.getView() != null && lVar != null && lVar.acx() != null && !StringUtils.isNull(lVar.acx().getTid())) {
                    an anVar = new an("c12352");
                    if ((n.this.gcO.getHeaderImg() != null && view.getId() == n.this.gcO.getHeaderImg().getId()) || (n.this.gcO.aZt() != null && view.getId() == n.this.gcO.aZt().getId())) {
                        anVar.P("obj_locate", 1);
                    } else {
                        anVar.P("obj_locate", 2);
                    }
                    anVar.P("obj_type", 2);
                    anVar.bT("tid", lVar.threadData.getTid());
                    anVar.l("fid", lVar.threadData.getFid());
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    anVar.P("obj_param1", lVar.bad() ? 2 : 1);
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.homepage.concern.view.b bVar = new com.baidu.tieba.homepage.concern.view.b(this.mPageContext);
        if (this.cxx != null) {
            bVar.l(this.cxx);
        }
        if (!isPreloadSizeReady(1)) {
            bVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.concern.a.n.2
                @Override // com.baidu.adp.widget.a.b
                public void j(int i, int i2, int i3) {
                    n.this.setPreloadSize(i, i2, i3);
                    if (n.this.isPreloadSizeReady(1)) {
                        bVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        this.gcO = bVar;
        return new a(this.gcO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.gcR == null) {
            return null;
        }
        lVar.pI(i + 1);
        t.aZN().c(lVar.vD("c12351"));
        if (aVar.gcR instanceof com.baidu.tieba.a.e) {
            aVar.gcR.setPage(this.WN);
        }
        aVar.gcR.a(lVar);
        aVar.gcR.d(this.eZd);
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.homepage.concern.view.b gcR;

        public a(com.baidu.tieba.homepage.concern.view.b bVar) {
            super(bVar.getView());
            this.gcR = bVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }
}
