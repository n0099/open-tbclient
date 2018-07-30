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
    private String bHB;
    private ad dTj;
    private com.baidu.tieba.homepage.concern.view.c dTy;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dTj = new ad<l>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, l lVar) {
                if (view != null && h.this.dTy != null && h.this.dTy.getView() != null && lVar != null && lVar.Td() != null && !StringUtils.isNull(lVar.Td().getTid())) {
                    an anVar = new an("c12352");
                    if ((h.this.dTy.getHeaderImg() != null && view.getId() == h.this.dTy.getHeaderImg().getId()) || (h.this.dTy.aiC() != null && view.getId() == h.this.dTy.aiC().getId())) {
                        anVar.r("obj_locate", 1);
                    } else {
                        anVar.r("obj_locate", 2);
                    }
                    anVar.r("obj_type", 2);
                    anVar.af("tid", lVar.btJ.getTid());
                    anVar.f(ImageViewerConfig.FORUM_ID, lVar.btJ.getFid());
                    anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    anVar.r("obj_param1", lVar.ajo() ? 2 : 1);
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
        this.dTy = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.aRF != null) {
            this.dTy.j(this.aRF);
        }
        return new a(this.dTy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.dTA == null) {
            return null;
        }
        lVar.iX(i + 1);
        v.aiY().a(lVar.le("c12351"));
        if (aVar.dTA instanceof com.baidu.tieba.a.e) {
            aVar.dTA.setPage(this.bHB);
        }
        aVar.dTA.a(lVar);
        aVar.dTA.b(this.dTj);
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public com.baidu.tieba.homepage.concern.view.c dTA;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.dTA = cVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }
}
