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
    public BdUniqueId bGE;
    private v ebW;
    private com.baidu.tieba.homepage.concern.view.c ecn;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ebW = new v<n>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, n nVar) {
                if (view != null && h.this.ecn != null && h.this.ecn.getView() != null && nVar != null && nVar.VM() != null && !StringUtils.isNull(nVar.VM().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((h.this.ecn.getHeaderImg() != null && view.getId() == h.this.ecn.getHeaderImg().getId()) || (h.this.ecn.akj() != null && view.getId() == h.this.ecn.akj().getId())) {
                        akVar.s("obj_locate", 1);
                    } else {
                        akVar.s("obj_locate", 2);
                    }
                    akVar.s("obj_type", 2);
                    akVar.aa("tid", nVar.bXi.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, nVar.bXi.getFid());
                    akVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
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
        this.ecn = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.bGE != null) {
            this.ecn.j(this.bGE);
        }
        return new a(this.ecn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.ecp == null) {
            return null;
        }
        nVar.lH(i + 1);
        s.akK().a(nVar.kr("c12351"));
        aVar.ecp.a(nVar);
        aVar.ecp.b(this.ebW);
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends r.a {
        public com.baidu.tieba.homepage.concern.view.c ecp;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.ecp = cVar;
        }
    }
}
