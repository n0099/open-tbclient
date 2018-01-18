package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> {
    public BdUniqueId bGw;
    private v ebB;
    private com.baidu.tieba.homepage.concern.view.a ebF;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ebB = new v<k>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, k kVar) {
                if (view != null && c.this.ebF != null && c.this.ebF.getView() != null && kVar != null && kVar.VK() != null && !StringUtils.isNull(kVar.VK().getTid())) {
                    boolean z = view == c.this.ebF.getHeaderImg();
                    ak akVar = new ak("c12352");
                    akVar.s("obj_locate", z ? 1 : 2);
                    akVar.ab("obj_type", kVar.akQ());
                    akVar.ab("tid", kVar.threadData.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
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
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.ebF = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.bGw != null) {
            this.ebF.j(this.bGw);
        }
        return new com.baidu.tieba.card.a.a<>(this.ebF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (kVar == null || aVar == null || aVar.alk() == null) {
            return null;
        }
        kVar.lH(i + 1);
        s.akF().a(kVar.kj("c12351"));
        aVar.alk().a(kVar);
        aVar.alk().b(this.ebB);
        return aVar.getView();
    }
}
