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
    public BdUniqueId aNy;
    private TbPageContext<?> ako;
    private com.baidu.tieba.homepage.concern.view.a cOS;
    private x cOT;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cOT = new x<k>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, k kVar) {
                if (view != null && b.this.cOS != null && b.this.cOS.getView() != null && kVar != null && kVar.MA() != null && !StringUtils.isNull(kVar.MA().getTid())) {
                    boolean z = view == b.this.cOS.getHeaderImg();
                    aj ajVar = new aj("c12352");
                    ajVar.r("obj_locate", z ? 1 : 2);
                    ajVar.aa("obj_type", kVar.WD());
                    ajVar.aa("tid", kVar.threadData.getTid());
                    ajVar.f("fid", kVar.threadData.getFid());
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
    /* renamed from: w */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.cOS = new com.baidu.tieba.homepage.concern.view.a(this.ako);
        this.cOS.j(this.aNy);
        return new com.baidu.tieba.card.a.a<>(this.cOS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (kVar == null || aVar == null || aVar.WX() == null) {
            return null;
        }
        kVar.hu(i + 1);
        u.Ww().a(kVar.jf("c12351"));
        aVar.WX().a(kVar);
        aVar.WX().a(this.cOT);
        return aVar.getView();
    }
}
