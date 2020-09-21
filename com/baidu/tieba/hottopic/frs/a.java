package com.baidu.tieba.hottopic.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.w;
import com.baidu.tieba.card.x;
import com.baidu.tieba.frs.k;
/* loaded from: classes20.dex */
public class a extends k<bw, com.baidu.tieba.card.a.a<w>> implements x {
    private aa<bw> fJh;
    private String mFrom;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.fJh = new aa<bw>() { // from class: com.baidu.tieba.hottopic.frs.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bw bwVar, Object obj) {
            }
        };
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.frs.k
    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.mPageContext = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.card.x
    public String VJ() {
        return "FrsHottopicVideoDelegateAdapter";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<w> c(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a<>(new w(this.mPageContext, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, com.baidu.tieba.card.a.a<w> aVar) {
        if (aVar == null || aVar.cfU() == null) {
            return null;
        }
        aVar.cfU().c(this.fJh);
        aVar.cfU().a(bwVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.x
    public void setFrom(String str) {
        this.mFrom = str;
    }
}
