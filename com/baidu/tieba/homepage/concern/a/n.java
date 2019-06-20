package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, a> implements com.baidu.tieba.a.f {
    private String Ws;
    public BdUniqueId cwi;
    private ab eUc;
    private com.baidu.tieba.homepage.concern.view.b fXR;
    private TbPageContext<?> mPageContext;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eUc = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (view != null && n.this.fXR != null && n.this.fXR.getView() != null && lVar != null && lVar.abv() != null && !StringUtils.isNull(lVar.abv().getTid())) {
                    am amVar = new am("c12352");
                    if ((n.this.fXR.getHeaderImg() != null && view.getId() == n.this.fXR.getHeaderImg().getId()) || (n.this.fXR.aXw() != null && view.getId() == n.this.fXR.aXw().getId())) {
                        amVar.P("obj_locate", 1);
                    } else {
                        amVar.P("obj_locate", 2);
                    }
                    amVar.P("obj_type", 2);
                    amVar.bT("tid", lVar.threadData.getTid());
                    amVar.l("fid", lVar.threadData.getFid());
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    amVar.P("obj_param1", lVar.aYe() ? 2 : 1);
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bb */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.homepage.concern.view.b bVar = new com.baidu.tieba.homepage.concern.view.b(this.mPageContext);
        if (this.cwi != null) {
            bVar.k(this.cwi);
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
        this.fXR = bVar;
        return new a(this.fXR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.fXU == null) {
            return null;
        }
        lVar.ps(i + 1);
        t.aXP().b(lVar.uY("c12351"));
        if (aVar.fXU instanceof com.baidu.tieba.a.e) {
            aVar.fXU.setPage(this.Ws);
        }
        aVar.fXU.a(lVar);
        aVar.fXU.d(this.eUc);
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.homepage.concern.view.b fXU;

        public a(com.baidu.tieba.homepage.concern.view.b bVar) {
            super(bVar.getView());
            this.fXU = bVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void rU(String str) {
        this.Ws = str;
    }
}
