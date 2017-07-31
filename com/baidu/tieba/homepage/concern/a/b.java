package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> {
    public BdUniqueId aOM;
    private TbPageContext<?> alI;
    private com.baidu.tieba.homepage.concern.view.a cQl;
    private x cQm;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cQm = new x<k>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, k kVar) {
                if (view != null && b.this.cQl != null && b.this.cQl.getView() != null && kVar != null && kVar.MF() != null && !StringUtils.isNull(kVar.MF().getTid())) {
                    boolean z = view == b.this.cQl.getHeaderImg();
                    aj ajVar = new aj("c12352");
                    ajVar.r("obj_locate", z ? 1 : 2);
                    ajVar.aa("obj_type", kVar.WI());
                    ajVar.aa("tid", kVar.threadData.getTid());
                    ajVar.g("fid", kVar.threadData.getFid());
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
    /* renamed from: w */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.cQl = new com.baidu.tieba.homepage.concern.view.a(this.alI);
        this.cQl.j(this.aOM);
        return new com.baidu.tieba.card.a.a<>(this.cQl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (kVar == null || aVar == null || aVar.Xc() == null) {
            return null;
        }
        kVar.hv(i + 1);
        u.WB().a(kVar.jk("c12351"));
        aVar.Xc().a(kVar);
        aVar.Xc().a(this.cQm);
        return aVar.getView();
    }
}
