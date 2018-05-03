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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<l, a> implements com.baidu.tieba.a.f {
    public BdUniqueId aTr;
    private String bvX;
    private ab dAP;
    private com.baidu.tieba.homepage.concern.view.c dBg;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dAP = new ab<l>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, l lVar) {
                if (view2 != null && h.this.dBg != null && h.this.dBg.getView() != null && lVar != null && lVar.Pe() != null && !StringUtils.isNull(lVar.Pe().getTid())) {
                    al alVar = new al("c12352");
                    if ((h.this.dBg.getHeaderImg() != null && view2.getId() == h.this.dBg.getHeaderImg().getId()) || (h.this.dBg.afc() != null && view2.getId() == h.this.dBg.afc().getId())) {
                        alVar.r("obj_locate", 1);
                    } else {
                        alVar.r("obj_locate", 2);
                    }
                    alVar.r("obj_type", 2);
                    alVar.ac("tid", lVar.bji.getTid());
                    alVar.f(ImageViewerConfig.FORUM_ID, lVar.bji.getFid());
                    alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(alVar);
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
        this.dBg = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.aTr != null) {
            this.dBg.j(this.aTr);
        }
        return new a(this.dBg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.dBi == null) {
            return null;
        }
        lVar.iN(i + 1);
        v.afy().a(lVar.kC("c12351"));
        if (aVar.dBi instanceof com.baidu.tieba.a.e) {
            aVar.dBi.setPage(this.bvX);
        }
        aVar.dBi.a(lVar);
        aVar.dBi.b(this.dAP);
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public com.baidu.tieba.homepage.concern.view.c dBi;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.dBi = cVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void hY(String str) {
        this.bvX = str;
    }
}
