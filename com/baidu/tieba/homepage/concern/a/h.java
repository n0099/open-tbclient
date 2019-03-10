package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class h extends com.baidu.adp.widget.ListView.a<l, a> implements com.baidu.tieba.a.f {
    private String Yz;
    public BdUniqueId cnX;
    private ab eEz;
    private com.baidu.tieba.homepage.concern.view.c fGQ;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eEz = new ab<l>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, l lVar) {
                if (view != null && h.this.fGQ != null && h.this.fGQ.getView() != null && lVar != null && lVar.WR() != null && !StringUtils.isNull(lVar.WR().getTid())) {
                    am amVar = new am("c12352");
                    if ((h.this.fGQ.getHeaderImg() != null && view.getId() == h.this.fGQ.getHeaderImg().getId()) || (h.this.fGQ.aQn() != null && view.getId() == h.this.fGQ.aQn().getId())) {
                        amVar.T("obj_locate", 1);
                    } else {
                        amVar.T("obj_locate", 2);
                    }
                    amVar.T("obj_type", 2);
                    amVar.bJ("tid", lVar.cZD.getTid());
                    amVar.k(ImageViewerConfig.FORUM_ID, lVar.cZD.getFid());
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    amVar.T("obj_param1", lVar.aQV() ? 2 : 1);
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
        final com.baidu.tieba.homepage.concern.view.c cVar = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.cnX != null) {
            cVar.k(this.cnX);
        }
        if (!isPreloadSizeReady(1)) {
            cVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.homepage.concern.a.h.2
                @Override // com.baidu.adp.widget.a.b
                public void k(int i, int i2, int i3) {
                    h.this.setPreloadSize(i, i2, i3);
                    if (h.this.isPreloadSizeReady(1)) {
                        cVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        this.fGQ = cVar;
        return new a(this.fGQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.fGT == null) {
            return null;
        }
        lVar.os(i + 1);
        t.aQG().b(lVar.tJ("c12351"));
        if (aVar.fGT instanceof com.baidu.tieba.a.e) {
            aVar.fGT.setPage(this.Yz);
        }
        aVar.fGT.a(lVar);
        aVar.fGT.d(this.eEz);
        return aVar.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public com.baidu.tieba.homepage.concern.view.c fGT;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.fGT = cVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void qN(String str) {
        this.Yz = str;
    }
}
