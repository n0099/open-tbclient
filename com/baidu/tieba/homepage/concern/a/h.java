package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<n, a> {
    public BdUniqueId bGo;
    private com.baidu.tieba.homepage.concern.view.c eaI;
    private v ear;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ear = new v<n>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, n nVar) {
                if (view != null && h.this.eaI != null && h.this.eaI.getView() != null && nVar != null && nVar.VW() != null && !StringUtils.isNull(nVar.VW().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((h.this.eaI.getHeaderImg() != null && view.getId() == h.this.eaI.getHeaderImg().getId()) || (h.this.eaI.ajb() != null && view.getId() == h.this.eaI.ajb().getId())) {
                        akVar.s("obj_locate", 1);
                    } else {
                        akVar.s("obj_locate", 2);
                    }
                    akVar.s("obj_type", 2);
                    akVar.ab("tid", nVar.bWT.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, nVar.bWT.getFid());
                    akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
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
        this.eaI = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.bGo != null) {
            this.eaI.j(this.bGo);
        }
        return new a(this.eaI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.eaK == null) {
            return null;
        }
        nVar.lE(i + 1);
        s.ajC().a(nVar.kc("c12351"));
        aVar.eaK.a(nVar);
        aVar.eaK.b(this.ear);
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends r.a {
        public com.baidu.tieba.homepage.concern.view.c eaK;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.eaK = cVar;
        }
    }
}
