package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.ad;
/* loaded from: classes3.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.g, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private com.baidu.tieba.card.i dNv;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.g.dcO);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> onCreateViewHolder(ViewGroup viewGroup) {
        this.dNv = new com.baidu.tieba.card.i(this.mPageContext);
        return new com.baidu.tieba.card.a.a<>(this.dNv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.g gVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> aVar) {
        if (aVar.aoP() == null) {
            return null;
        }
        aVar.aoP().a(gVar);
        aVar.aoP().b(new ad<com.baidu.tieba.e.g>() { // from class: com.baidu.tieba.frs.gamerecommend.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view2, com.baidu.tieba.e.g gVar2) {
                TiebaStatic.log(new am("c13047").x("obj_locate", 1).ax(ImageViewerConfig.FORUM_ID, h.this.mForumId));
                ay.CU().a((TbPageContext) com.baidu.adp.base.i.aK(view2.getContext()), new String[]{gVar2.asB().score_url}, true);
            }
        });
        aVar.aoP().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.aoP().getView();
    }
}
