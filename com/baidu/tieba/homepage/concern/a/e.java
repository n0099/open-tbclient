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
    public BdUniqueId aON;
    private x cSl;
    private com.baidu.tieba.homepage.concern.view.c cSt;
    private TbPageContext<?> oV;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cSl = new x<n>() { // from class: com.baidu.tieba.homepage.concern.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, n nVar) {
                if (view != null && e.this.cSt != null && e.this.cSt.getView() != null && nVar != null && nVar.MF() != null && !StringUtils.isNull(nVar.MF().getTid())) {
                    aj ajVar = new aj("c12352");
                    if ((e.this.cSt.getHeaderImg() != null && view.getId() == e.this.cSt.getHeaderImg().getId()) || (e.this.cSt.WD() != null && view.getId() == e.this.cSt.WD().getId())) {
                        ajVar.r("obj_locate", 1);
                    } else {
                        ajVar.r("obj_locate", 2);
                    }
                    ajVar.r("obj_type", 2);
                    ajVar.aa("tid", nVar.bcM.getTid());
                    ajVar.g("fid", nVar.bcM.getFid());
                    ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(ajVar);
                }
            }
        };
        this.oV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cSt = new com.baidu.tieba.homepage.concern.view.c(this.oV);
        this.cSt.j(this.aON);
        return new a(this.cSt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.cSv == null) {
            return null;
        }
        nVar.hw(i + 1);
        u.WX().a(nVar.jl("c12351"));
        aVar.cSv.a(nVar);
        aVar.cSv.b(this.cSl);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public com.baidu.tieba.homepage.concern.view.c cSv;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.cSv = cVar;
        }
    }
}
