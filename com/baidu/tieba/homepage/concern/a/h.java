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
    private String bWE;
    public BdUniqueId bag;
    private ad ejJ;
    private com.baidu.tieba.homepage.concern.view.c ejZ;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ejJ = new ad<l>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, l lVar) {
                if (view != null && h.this.ejZ != null && h.this.ejZ.getView() != null && lVar != null && lVar.YL() != null && !StringUtils.isNull(lVar.YL().getTid())) {
                    am amVar = new am("c12352");
                    if ((h.this.ejZ.getHeaderImg() != null && view.getId() == h.this.ejZ.getHeaderImg().getId()) || (h.this.ejZ.ant() != null && view.getId() == h.this.ejZ.ant().getId())) {
                        amVar.x("obj_locate", 1);
                    } else {
                        amVar.x("obj_locate", 2);
                    }
                    amVar.x("obj_type", 2);
                    amVar.ax("tid", lVar.bIU.getTid());
                    amVar.h(ImageViewerConfig.FORUM_ID, lVar.bIU.getFid());
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    amVar.x("obj_param1", lVar.aog() ? 2 : 1);
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
        if (this.bag != null) {
            cVar.j(this.bag);
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
        this.ejZ = cVar;
        return new a(this.ejZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.ekc == null) {
            return null;
        }
        lVar.km(i + 1);
        v.anQ().a(lVar.ml("c12351"));
        if (aVar.ekc instanceof com.baidu.tieba.a.e) {
            aVar.ekc.setPage(this.bWE);
        }
        aVar.ekc.a(lVar);
        aVar.ekc.b(this.ejJ);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public com.baidu.tieba.homepage.concern.view.c ekc;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.ekc = cVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }
}
