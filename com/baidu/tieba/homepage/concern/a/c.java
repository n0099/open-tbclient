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
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> {
    public BdUniqueId aSv;
    private v dmZ;
    private com.baidu.tieba.homepage.concern.view.a dnd;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dmZ = new v<k>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, k kVar) {
                if (view != null && c.this.dnd != null && c.this.dnd.getView() != null && kVar != null && kVar.Ox() != null && !StringUtils.isNull(kVar.Ox().getTid())) {
                    boolean z = view == c.this.dnd.getHeaderImg();
                    ak akVar = new ak("c12352");
                    akVar.r("obj_locate", z ? 1 : 2);
                    akVar.ac("obj_type", kVar.abY());
                    akVar.ac("tid", kVar.threadData.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
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
    /* renamed from: U */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.dnd = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.aSv != null) {
            this.dnd.k(this.aSv);
        }
        return new com.baidu.tieba.card.a.a<>(this.dnd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (kVar == null || aVar == null || aVar.acs() == null) {
            return null;
        }
        kVar.iE(i + 1);
        s.abU().a(kVar.jX("c12351"));
        aVar.acs().a(kVar);
        aVar.acs().b(this.dmZ);
        return aVar.getView();
    }
}
