package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<n, a> {
    public BdUniqueId aSy;
    private v dof;
    private com.baidu.tieba.homepage.concern.view.c dow;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dof = new v<n>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, n nVar) {
                if (view != null && h.this.dow != null && h.this.dow.getView() != null && nVar != null && nVar.Ox() != null && !StringUtils.isNull(nVar.Ox().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((h.this.dow.getHeaderImg() != null && view.getId() == h.this.dow.getHeaderImg().getId()) || (h.this.dow.abw() != null && view.getId() == h.this.dow.abw().getId())) {
                        akVar.r("obj_locate", 1);
                    } else {
                        akVar.r("obj_locate", 2);
                    }
                    akVar.r("obj_type", 2);
                    akVar.ac("tid", nVar.bjE.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, nVar.bjE.getFid());
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dow = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.aSy != null) {
            this.dow.k(this.aSy);
        }
        return new a(this.dow);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.doy == null) {
            return null;
        }
        nVar.iG(i + 1);
        s.abW().a(nVar.jW("c12351"));
        aVar.doy.a(nVar);
        aVar.doy.b(this.dof);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public com.baidu.tieba.homepage.concern.view.c doy;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.doy = cVar;
        }
    }
}
