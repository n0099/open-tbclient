package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.card.data.CardHListViewData;
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.frs.p<CardHListViewData, com.baidu.tieba.card.b.a<com.baidu.tieba.card.r>> implements cg, com.baidu.tieba.frs.d.e {
    private ci cgM;
    private String mForumName;

    public static void bh(long j) {
        if (j > 0 && cnC != null && !TextUtils.isEmpty(cnC.cnu)) {
            au auVar = new au("c11958");
            auVar.f("tid", j);
            auVar.Z("fid", cnC.cnu);
            TiebaStatic.log(auVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cgM = new s(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a(new com.baidu.tieba.card.r(this.ajP));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardHListViewData cardHListViewData, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.Wp() == null) {
            return null;
        }
        aVar.Wp().a((com.baidu.tieba.card.a) cardHListViewData);
        aVar.Wp().a(this.cgM);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cg
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
