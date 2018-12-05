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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.v;
/* loaded from: classes6.dex */
public class h extends com.baidu.adp.widget.ListView.a<l, a> implements com.baidu.tieba.a.f {
    public BdUniqueId bdE;
    private String caw;
    private ad eqD;
    private com.baidu.tieba.homepage.concern.view.c eqT;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eqD = new ad<l>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, l lVar) {
                if (view != null && h.this.eqT != null && h.this.eqT.getView() != null && lVar != null && lVar.ZR() != null && !StringUtils.isNull(lVar.ZR().getTid())) {
                    am amVar = new am("c12352");
                    if ((h.this.eqT.getHeaderImg() != null && view.getId() == h.this.eqT.getHeaderImg().getId()) || (h.this.eqT.apf() != null && view.getId() == h.this.eqT.apf().getId())) {
                        amVar.x("obj_locate", 1);
                    } else {
                        amVar.x("obj_locate", 2);
                    }
                    amVar.x("obj_type", 2);
                    amVar.aA("tid", lVar.bMJ.getTid());
                    amVar.i(ImageViewerConfig.FORUM_ID, lVar.bMJ.getFid());
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    amVar.x("obj_param1", lVar.apT() ? 2 : 1);
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.homepage.concern.view.c cVar = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.bdE != null) {
            cVar.j(this.bdE);
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
        this.eqT = cVar;
        return new a(this.eqT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.eqW == null) {
            return null;
        }
        lVar.kC(i + 1);
        v.apD().a(lVar.mK("c12351"));
        if (aVar.eqW instanceof com.baidu.tieba.a.e) {
            aVar.eqW.setPage(this.caw);
        }
        aVar.eqW.a(lVar);
        aVar.eqW.b(this.eqD);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public com.baidu.tieba.homepage.concern.view.c eqW;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.eqW = cVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }
}
