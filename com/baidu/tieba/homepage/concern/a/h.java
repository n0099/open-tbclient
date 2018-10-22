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
    public BdUniqueId aZt;
    private String bVS;
    private com.baidu.tieba.homepage.concern.view.c eiF;
    private ad eip;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eip = new ad<l>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, l lVar) {
                if (view != null && h.this.eiF != null && h.this.eiF.getView() != null && lVar != null && lVar.YB() != null && !StringUtils.isNull(lVar.YB().getTid())) {
                    am amVar = new am("c12352");
                    if ((h.this.eiF.getHeaderImg() != null && view.getId() == h.this.eiF.getHeaderImg().getId()) || (h.this.eiF.anS() != null && view.getId() == h.this.eiF.anS().getId())) {
                        amVar.x("obj_locate", 1);
                    } else {
                        amVar.x("obj_locate", 2);
                    }
                    amVar.x("obj_type", 2);
                    amVar.ax("tid", lVar.bIj.getTid());
                    amVar.h(ImageViewerConfig.FORUM_ID, lVar.bIj.getFid());
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    amVar.x("obj_param1", lVar.aoF() ? 2 : 1);
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
        if (this.aZt != null) {
            cVar.j(this.aZt);
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
        this.eiF = cVar;
        return new a(this.eiF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.eiI == null) {
            return null;
        }
        lVar.jT(i + 1);
        v.aop().a(lVar.mk("c12351"));
        if (aVar.eiI instanceof com.baidu.tieba.a.e) {
            aVar.eiI.setPage(this.bVS);
        }
        aVar.eiI.a(lVar);
        aVar.eiI.b(this.eip);
        return aVar.getView();
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public com.baidu.tieba.homepage.concern.view.c eiI;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.eiI = cVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }
}
