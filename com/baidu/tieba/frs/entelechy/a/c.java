package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<ar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.h>> implements com.baidu.tieba.frs.e.c {
    private v clL;
    private com.baidu.tieba.frs.entelechy.view.h dKj;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.clL = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && c.this.dKj != null && c.this.dKj.getView() != null && c.this.dKj.dLU != null && bdVar != null && !StringUtils.isNull(bdVar.getTid())) {
                    if (view.getId() == d.g.card_root_view) {
                        com.baidu.tieba.frs.e.b.azQ().a(com.baidu.tieba.frs.e.c.dUe, bdVar, 1);
                    } else if (view.getId() == d.g.avatar) {
                        com.baidu.tieba.frs.e.b.azQ().a(com.baidu.tieba.frs.e.c.dUe, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.dUe, bdVar.zM());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.dKj = new com.baidu.tieba.frs.entelechy.view.h(this.mPageContext, this.mPageId);
        this.dKj.h(this.mPageId);
        return new com.baidu.tieba.card.a.a(this.dKj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ar arVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.alX() == null) {
            return null;
        }
        aVar.alX().a(arVar);
        aVar.alX().b(this.clL);
        com.baidu.tieba.frs.e.b.azQ().a(dUe, arVar);
        return aVar.getView();
    }
}
