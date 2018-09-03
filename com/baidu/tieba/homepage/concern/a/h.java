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
    public BdUniqueId aRC;
    private String bHB;
    private ad dTe;
    private com.baidu.tieba.homepage.concern.view.c dTt;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dTe = new ad<l>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, l lVar) {
                if (view != null && h.this.dTt != null && h.this.dTt.getView() != null && lVar != null && lVar.Tg() != null && !StringUtils.isNull(lVar.Tg().getTid())) {
                    an anVar = new an("c12352");
                    if ((h.this.dTt.getHeaderImg() != null && view.getId() == h.this.dTt.getHeaderImg().getId()) || (h.this.dTt.aiF() != null && view.getId() == h.this.dTt.aiF().getId())) {
                        anVar.r("obj_locate", 1);
                    } else {
                        anVar.r("obj_locate", 2);
                    }
                    anVar.r("obj_type", 2);
                    anVar.ae("tid", lVar.btL.getTid());
                    anVar.f(ImageViewerConfig.FORUM_ID, lVar.btL.getFid());
                    anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    anVar.r("obj_param1", lVar.ajr() ? 2 : 1);
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
        this.dTt = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.aRC != null) {
            this.dTt.j(this.aRC);
        }
        return new a(this.dTt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.dTv == null) {
            return null;
        }
        lVar.iW(i + 1);
        v.ajb().a(lVar.lg("c12351"));
        if (aVar.dTv instanceof com.baidu.tieba.a.e) {
            aVar.dTv.setPage(this.bHB);
        }
        aVar.dTv.a(lVar);
        aVar.dTv.b(this.dTe);
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public com.baidu.tieba.homepage.concern.view.c dTv;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.dTv = cVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }
}
