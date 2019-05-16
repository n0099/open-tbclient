package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.topic.topictab.b.a, z<com.baidu.tieba.homepage.topic.topictab.b.a>> implements com.baidu.tieba.a.f {
    private String Wt;
    private NEGFeedBackView.a cRf;
    public BdUniqueId cwh;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public z<com.baidu.tieba.homepage.topic.topictab.b.a> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.tieba.homepage.personalize.view.e eVar = new com.baidu.tieba.homepage.personalize.view.e(this.mContext, this.mPageContext);
        eVar.setTag(this.mPageId);
        aVar.b(eVar);
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        aVar.qq().bt(0);
        aVar.qq().bu(0);
        aVar.qq().bv(0);
        aVar.qq().bs(0);
        aVar.qq().br(0);
        x qr = aVar.qr();
        qr.bq(2);
        z<com.baidu.tieba.homepage.topic.topictab.b.a> zVar = new z<>(qr);
        zVar.setPageId(this.cwh);
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.topic.topictab.b.a aVar, z<com.baidu.tieba.homepage.topic.topictab.b.a> zVar) {
        if (aVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        TiebaStatic.log(new am("c13448"));
        zVar.qs().setPage(this.Wt);
        zVar.qt().a(this.cRf);
        zVar.a(aVar);
        zVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cRf = aVar;
    }
}
