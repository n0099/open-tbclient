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
    public BdUniqueId beu;
    private String cbl;
    private ad euc;
    private com.baidu.tieba.homepage.concern.view.c eus;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.euc = new ad<l>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, l lVar) {
                if (view != null && h.this.eus != null && h.this.eus.getView() != null && lVar != null && lVar.aaq() != null && !StringUtils.isNull(lVar.aaq().getTid())) {
                    am amVar = new am("c12352");
                    if ((h.this.eus.getHeaderImg() != null && view.getId() == h.this.eus.getHeaderImg().getId()) || (h.this.eus.aqs() != null && view.getId() == h.this.eus.aqs().getId())) {
                        amVar.y("obj_locate", 1);
                    } else {
                        amVar.y("obj_locate", 2);
                    }
                    amVar.y("obj_type", 2);
                    amVar.aB("tid", lVar.bNA.getTid());
                    amVar.i(ImageViewerConfig.FORUM_ID, lVar.bNA.getFid());
                    amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    amVar.y("obj_param1", lVar.arf() ? 2 : 1);
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.homepage.concern.view.c cVar = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.beu != null) {
            cVar.j(this.beu);
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
        this.eus = cVar;
        return new a(this.eus);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.euv == null) {
            return null;
        }
        lVar.kP(i + 1);
        v.aqP().a(lVar.nd("c12351"));
        if (aVar.euv instanceof com.baidu.tieba.a.e) {
            aVar.euv.setPage(this.cbl);
        }
        aVar.euv.a(lVar);
        aVar.euv.b(this.euc);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public com.baidu.tieba.homepage.concern.view.c euv;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.euv = cVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbl = str;
    }
}
