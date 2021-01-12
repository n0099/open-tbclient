package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<by, ThreadCardViewHolder<bz>> {
    public BdUniqueId fEN;
    private BdTypeRecyclerView jld;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.fEN = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<bz> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.s sVar = new com.baidu.card.s(this.mPageContext.getPageActivity());
        sVar.tb();
        aVar.a((com.baidu.card.h) sVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.jld);
        a2.setSourceForPb(2);
        ThreadCardViewHolder<bz> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fEN);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.g.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (nVar instanceof by) {
                    if (((by) nVar).eHK.getType() == bz.eOR) {
                        BdToast.b(g.this.mPageContext.getContext(), g.this.mPageContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqk();
                        return;
                    }
                    by byVar = (by) nVar;
                    if (byVar.eHK != null && byVar.eNS && byVar.eHK.bpE() != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("itemID", String.valueOf(byVar.eHK.bpE().item_id));
                        hashMap.put("source", 3);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                        return;
                    }
                }
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    bz bzVar = ((by) nVar).eHK;
                    bzVar.objType = 1;
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), 2, false);
                    ((ThreadCardViewHolder) view.getTag()).tm().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, ThreadCardViewHolder<bz> threadCardViewHolder) {
        if (byVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || byVar.eHK == null) {
            return null;
        }
        byVar.eHK.eMg = getPositionByType(i) + 1;
        threadCardViewHolder.tm().setPosition(i);
        threadCardViewHolder.b((ThreadCardViewHolder<bz>) byVar.eHK);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.getView();
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        this.jld = bdTypeRecyclerView;
    }
}
