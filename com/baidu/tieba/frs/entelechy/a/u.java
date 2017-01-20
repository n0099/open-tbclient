package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.at;
/* loaded from: classes.dex */
public class u extends at<CardHListViewData, com.baidu.tieba.card.b.a<com.baidu.tieba.card.r>> implements cd, com.baidu.tieba.frs.e.e {
    private TbPageContext<?> FY;
    private cf bLI;
    private String mForumName;

    public static void aW(long j) {
        if (j > 0 && bTj != null && !TextUtils.isEmpty(bTj.bTb)) {
            ar arVar = new ar("c11958");
            arVar.g("tid", j);
            arVar.ab("fid", bTj.bTb);
            TiebaStatic.log(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public u(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bLI = new v(this);
        this.FY = baseActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.b.a(new com.baidu.tieba.card.r(this.FY));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.at, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardHListViewData cardHListViewData, com.baidu.tieba.card.b.a aVar) {
        if (aVar == null || aVar.Sd() == null) {
            return null;
        }
        aVar.Sd().onBindDataToView(cardHListViewData);
        aVar.Sd().setOnSubCardOnClickListenner(this.bLI);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.cd
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
