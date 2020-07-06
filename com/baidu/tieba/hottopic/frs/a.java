package com.baidu.tieba.hottopic.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.w;
import com.baidu.tieba.card.x;
import com.baidu.tieba.frs.j;
/* loaded from: classes8.dex */
public class a extends j<bu, com.baidu.tieba.card.a.a<w>> implements x {
    private aa<bu> fpn;
    private String mFrom;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.fpn = new aa<bu>() { // from class: com.baidu.tieba.hottopic.frs.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bu buVar, Object obj) {
            }
        };
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.frs.j
    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mPageContext = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.card.x
    public String OP() {
        return "FrsHottopicVideoDelegateAdapter";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<w> b(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new w(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, com.baidu.tieba.card.a.a<w> aVar) {
        if (aVar == null || aVar.bPh() == null) {
            return null;
        }
        aVar.bPh().c(this.fpn);
        aVar.bPh().a(buVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.x
    public void setFrom(String str) {
        this.mFrom = str;
    }
}
