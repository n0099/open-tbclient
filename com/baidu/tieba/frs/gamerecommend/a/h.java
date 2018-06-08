package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.ab;
/* loaded from: classes3.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.g, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i>> {
    private com.baidu.tieba.card.i dsT;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.g.cOf);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> onCreateViewHolder(ViewGroup viewGroup) {
        this.dsT = new com.baidu.tieba.card.i(this.mPageContext);
        return new com.baidu.tieba.card.a.a<>(this.dsT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.g gVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.i> aVar) {
        if (aVar.ajG() == null) {
            return null;
        }
        aVar.ajG().a(gVar);
        aVar.ajG().b(new ab<com.baidu.tieba.e.g>() { // from class: com.baidu.tieba.frs.gamerecommend.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.e.g gVar2) {
                TiebaStatic.log(new am("c13047").r("obj_locate", 1).ah(ImageViewerConfig.FORUM_ID, h.this.mForumId));
                ay.zG().a((TbPageContext) com.baidu.adp.base.i.ad(view2.getContext()), new String[]{gVar2.anw().score_url}, true);
            }
        });
        aVar.ajG().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return aVar.ajG().getView();
    }
}
