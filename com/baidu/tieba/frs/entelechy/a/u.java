package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.card.n;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.frs.p<CardHListViewData, com.baidu.tieba.card.b.a<n>> implements cb, com.baidu.tieba.frs.c.e {
    private cd bSN;
    private String mForumName;

    public static void aQ(long j) {
        if (j > 0 && bZb != null && !TextUtils.isEmpty(bZb.bYT)) {
            as asVar = new as("c11958");
            asVar.g("tid", j);
            asVar.aa("fid", bZb.bYT);
            TiebaStatic.log(asVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.bSN = new v(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a(new n(this.ajr));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardHListViewData cardHListViewData, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.TU() == null) {
            return null;
        }
        aVar.TU().onBindDataToView(cardHListViewData);
        aVar.TU().setOnSubCardOnClickListenner(this.bSN);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cb
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
