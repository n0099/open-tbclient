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
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<l, a> implements com.baidu.tieba.a.f {
    public BdUniqueId aUU;
    private String bNq;
    private com.baidu.tieba.homepage.concern.view.c eaL;
    private ad eav;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eav = new ad<l>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, l lVar) {
                if (view != null && h.this.eaL != null && h.this.eaL.getView() != null && lVar != null && lVar.UT() != null && !StringUtils.isNull(lVar.UT().getTid())) {
                    am amVar = new am("c12352");
                    if ((h.this.eaL.getHeaderImg() != null && view.getId() == h.this.eaL.getHeaderImg().getId()) || (h.this.eaL.akp() != null && view.getId() == h.this.eaL.akp().getId())) {
                        amVar.w("obj_locate", 1);
                    } else {
                        amVar.w("obj_locate", 2);
                    }
                    amVar.w("obj_type", 2);
                    amVar.al("tid", lVar.bzB.getTid());
                    amVar.g(ImageViewerConfig.FORUM_ID, lVar.bzB.getFid());
                    amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    amVar.w("obj_param1", lVar.alc() ? 2 : 1);
                    TiebaStatic.log(amVar);
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
        final com.baidu.tieba.homepage.concern.view.c cVar = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.aUU != null) {
            cVar.j(this.aUU);
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
        this.eaL = cVar;
        return new a(this.eaL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.eaO == null) {
            return null;
        }
        lVar.jv(i + 1);
        v.akM().a(lVar.lI("c12351"));
        if (aVar.eaO instanceof com.baidu.tieba.a.e) {
            aVar.eaO.setPage(this.bNq);
        }
        aVar.eaO.a(lVar);
        aVar.eaO.b(this.eav);
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public com.baidu.tieba.homepage.concern.view.c eaO;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.eaO = cVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }
}
