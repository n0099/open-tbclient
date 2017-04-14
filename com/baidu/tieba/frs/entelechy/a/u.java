package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.av;
/* loaded from: classes.dex */
public class u extends av<CardHListViewData, com.baidu.tieba.card.b.a<com.baidu.tieba.card.r>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> ajT;
    private cf bSC;
    private String mForumName;

    public static void aW(long j) {
        if (j > 0 && bYW != null && !TextUtils.isEmpty(bYW.bYO)) {
            as asVar = new as("c11958");
            asVar.g("tid", j);
            asVar.aa("fid", bYW.bYO);
            TiebaStatic.log(asVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public u(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bSC = new v(this);
        this.ajT = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a(new com.baidu.tieba.card.r(this.ajT));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardHListViewData cardHListViewData, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.Tz() == null) {
            return null;
        }
        aVar.Tz().onBindDataToView(cardHListViewData);
        aVar.Tz().setOnSubCardOnClickListenner(this.bSC);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
