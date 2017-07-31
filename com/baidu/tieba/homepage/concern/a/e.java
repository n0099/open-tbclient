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
    public BdUniqueId aOM;
    private TbPageContext<?> alI;
    private x cQm;
    private com.baidu.tieba.homepage.concern.view.c cQu;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cQm = new x<n>() { // from class: com.baidu.tieba.homepage.concern.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, n nVar) {
                if (view != null && e.this.cQu != null && e.this.cQu.getView() != null && nVar != null && nVar.MF() != null && !StringUtils.isNull(nVar.MF().getTid())) {
                    aj ajVar = new aj("c12352");
                    if ((e.this.cQu.getHeaderImg() != null && view.getId() == e.this.cQu.getHeaderImg().getId()) || (e.this.cQu.Wh() != null && view.getId() == e.this.cQu.Wh().getId())) {
                        ajVar.r("obj_locate", 1);
                    } else {
                        ajVar.r("obj_locate", 2);
                    }
                    ajVar.r("obj_type", 2);
                    ajVar.aa("tid", nVar.bcL.getTid());
                    ajVar.g("fid", nVar.bcL.getFid());
                    ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(ajVar);
                }
            }
        };
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cQu = new com.baidu.tieba.homepage.concern.view.c(this.alI);
        this.cQu.j(this.aOM);
        return new a(this.cQu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        if (nVar == null || aVar == null || aVar.cQw == null) {
            return null;
        }
        nVar.hv(i + 1);
        u.WB().a(nVar.jk("c12351"));
        aVar.cQw.a(nVar);
        aVar.cQw.a(this.cQm);
        return aVar.getView();
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public com.baidu.tieba.homepage.concern.view.c cQw;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.cQw = cVar;
        }
    }
}
