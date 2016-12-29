package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.entelechy.view.bb;
/* loaded from: classes.dex */
public class u extends au<CardHListViewData, com.baidu.tieba.card.a.a<com.baidu.tieba.card.r>> implements bb, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GO;
    private cb bFq;
    private String mForumName;

    public static void ba(long j) {
        if (j > 0 && bMV != null && !TextUtils.isEmpty(bMV.bMN)) {
            at atVar = new at("c11958");
            atVar.g("tid", j);
            atVar.ab("fid", bMV.bMN);
            TiebaStatic.log(atVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public u(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bFq = new v(this);
        this.GO = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a a(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a(new com.baidu.tieba.card.r(this.GO));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.au, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, CardHListViewData cardHListViewData, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.Po() == null) {
            return null;
        }
        aVar.Po().onBindDataToView(cardHListViewData);
        aVar.Po().setOnSubCardOnClickListenner(this.bFq);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.entelechy.view.bb
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
