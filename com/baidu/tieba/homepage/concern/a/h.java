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
    public BdUniqueId bGw;
    private v ebB;
    private com.baidu.tieba.homepage.concern.view.c ebS;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ebB = new v<n>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, n nVar) {
                if (view != null && h.this.ebS != null && h.this.ebS.getView() != null && nVar != null && nVar.VK() != null && !StringUtils.isNull(nVar.VK().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((h.this.ebS.getHeaderImg() != null && view.getId() == h.this.ebS.getHeaderImg().getId()) || (h.this.ebS.ake() != null && view.getId() == h.this.ebS.ake().getId())) {
                        akVar.s("obj_locate", 1);
                    } else {
                        akVar.s("obj_locate", 2);
                    }
                    akVar.s("obj_type", 2);
                    akVar.ab("tid", nVar.bXa.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, nVar.bXa.getFid());
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
    /* renamed from: aO */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.ebS = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.bGw != null) {
            this.ebS.j(this.bGw);
        }
        return new a(this.ebS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.ebU == null) {
            return null;
        }
        nVar.lH(i + 1);
        s.akF().a(nVar.kk("c12351"));
        aVar.ebU.a(nVar);
        aVar.ebU.b(this.ebB);
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends r.a {
        public com.baidu.tieba.homepage.concern.view.c ebU;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.ebU = cVar;
        }
    }
}
