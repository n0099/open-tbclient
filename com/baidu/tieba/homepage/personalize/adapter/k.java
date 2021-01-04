package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> {
    private com.baidu.adp.widget.ListView.s anl;
    public BdUniqueId fJu;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.k> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.s sVar = new com.baidu.card.s(this.mPageContext.getPageActivity());
        sVar.tm();
        aVar.a((com.baidu.card.h) sVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.anl);
        a2.setSourceForPb(2);
        ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fJu);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.k.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) nVar) != null && kVar.eSD && kVar.eMv != null && kVar.eMv.btx() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", String.valueOf(kVar.eMv.btx().item_id));
                    hashMap.put("source", 1);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                } else if ((nVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    com.baidu.tieba.card.data.k kVar2 = (com.baidu.tieba.card.data.k) nVar;
                    kVar2.objType = 1;
                    ay.a((com.baidu.tbadk.core.data.a) kVar2, view.getContext(), 4, false);
                    ((ThreadCardViewHolder) view.getTag()).ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eMv == null) {
            return null;
        }
        kVar.yA(kVar.position + 1);
        threadCardViewHolder.ty().setPosition(i);
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.getView();
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.anl = sVar;
    }
}
