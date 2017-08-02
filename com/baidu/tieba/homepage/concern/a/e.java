package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<n, a> {
    public BdUniqueId aNy;
    private TbPageContext<?> ako;
    private x cOT;
    private com.baidu.tieba.homepage.concern.view.c cPb;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cOT = new x<n>() { // from class: com.baidu.tieba.homepage.concern.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, n nVar) {
                if (view != null && e.this.cPb != null && e.this.cPb.getView() != null && nVar != null && nVar.MA() != null && !StringUtils.isNull(nVar.MA().getTid())) {
                    aj ajVar = new aj("c12352");
                    if ((e.this.cPb.getHeaderImg() != null && view.getId() == e.this.cPb.getHeaderImg().getId()) || (e.this.cPb.Wc() != null && view.getId() == e.this.cPb.Wc().getId())) {
                        ajVar.r("obj_locate", 1);
                    } else {
                        ajVar.r("obj_locate", 2);
                    }
                    ajVar.r("obj_type", 2);
                    ajVar.aa("tid", nVar.bbB.getTid());
                    ajVar.f("fid", nVar.bbB.getFid());
                    ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(ajVar);
                }
            }
        };
        this.ako = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cPb = new com.baidu.tieba.homepage.concern.view.c(this.ako);
        this.cPb.j(this.aNy);
        return new a(this.cPb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.cPd == null) {
            return null;
        }
        nVar.hu(i + 1);
        u.Ww().a(nVar.jf("c12351"));
        aVar.cPd.a(nVar);
        aVar.cPd.a(this.cOT);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public com.baidu.tieba.homepage.concern.view.c cPd;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.cPd = cVar;
        }
    }
}
