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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<ca, ThreadCardViewHolder<cb>> {
    public BdUniqueId fIy;
    private BdTypeRecyclerView jsH;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.fIy = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<cb> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.s sVar = new com.baidu.card.s(this.mPageContext.getPageActivity());
        sVar.sY();
        aVar.a((com.baidu.card.h) sVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.jsH);
        a2.setSourceForPb(2);
        ThreadCardViewHolder<cb> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fIy);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.g.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (nVar instanceof ca) {
                    if (((ca) nVar).eLr.getType() == cb.eSE) {
                        BdToast.b(g.this.mPageContext.getContext(), g.this.mPageContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
                        return;
                    }
                    ca caVar = (ca) nVar;
                    if (caVar.eLr != null && caVar.eRF && caVar.eLr.bpY() != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("itemID", String.valueOf(caVar.eLr.bpY().item_id));
                        hashMap.put("source", 3);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                        return;
                    }
                }
                if ((nVar instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    cb cbVar = ((ca) nVar).eLr;
                    cbVar.objType = 1;
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), 2, false);
                    ((ThreadCardViewHolder) view.getTag()).tj().b(new a.C0095a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, ThreadCardViewHolder<cb> threadCardViewHolder) {
        if (caVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || caVar.eLr == null) {
            return null;
        }
        caVar.eLr.ePT = getPositionByType(i) + 1;
        threadCardViewHolder.tj().setPosition(i);
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) caVar.eLr);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.getView();
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        this.jsH = bdTypeRecyclerView;
    }
}
