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
    public BdUniqueId aOO;
    private com.baidu.tieba.homepage.concern.view.a cSk;
    private x cSl;
    private TbPageContext<?> oW;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cSl = new x<k>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, k kVar) {
                if (view != null && b.this.cSk != null && b.this.cSk.getView() != null && kVar != null && kVar.MF() != null && !StringUtils.isNull(kVar.MF().getTid())) {
                    boolean z = view == b.this.cSk.getHeaderImg();
                    aj ajVar = new aj("c12352");
                    ajVar.r("obj_locate", z ? 1 : 2);
                    ajVar.aa("obj_type", kVar.Xb());
                    ajVar.aa("tid", kVar.threadData.getTid());
                    ajVar.g("fid", kVar.threadData.getFid());
                    ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(ajVar);
                }
            }
        };
        this.oW = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.cSk = new com.baidu.tieba.homepage.concern.view.a(this.oW);
        this.cSk.j(this.aOO);
        return new com.baidu.tieba.card.a.a<>(this.cSk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (kVar == null || aVar == null || aVar.Xv() == null) {
            return null;
        }
        kVar.hw(i + 1);
        u.WU().a(kVar.jo("c12351"));
        aVar.Xv().a(kVar);
        aVar.Xv().b(this.cSl);
        return aVar.getView();
    }
}
