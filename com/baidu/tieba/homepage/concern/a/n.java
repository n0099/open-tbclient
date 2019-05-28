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
    private String Wt;
    public BdUniqueId cwh;
    private ab eUc;
    private com.baidu.tieba.homepage.concern.view.b fXP;
    private TbPageContext<?> mPageContext;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eUc = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (view != null && n.this.fXP != null && n.this.fXP.getView() != null && lVar != null && lVar.abv() != null && !StringUtils.isNull(lVar.abv().getTid())) {
                    am amVar = new am("c12352");
                    if ((n.this.fXP.getHeaderImg() != null && view.getId() == n.this.fXP.getHeaderImg().getId()) || (n.this.fXP.aXw() != null && view.getId() == n.this.fXP.aXw().getId())) {
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
        if (this.cwh != null) {
            bVar.k(this.cwh);
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
        this.fXP = bVar;
        return new a(this.fXP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.fXS == null) {
            return null;
        }
        lVar.ps(i + 1);
        t.aXP().b(lVar.uZ("c12351"));
        if (aVar.fXS instanceof com.baidu.tieba.a.e) {
            aVar.fXS.setPage(this.Wt);
        }
        aVar.fXS.a(lVar);
        aVar.fXS.d(this.eUc);
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.homepage.concern.view.b fXS;

        public a(com.baidu.tieba.homepage.concern.view.b bVar) {
            super(bVar.getView());
            this.fXS = bVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }
}
