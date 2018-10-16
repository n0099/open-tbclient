package com.baidu.tieba.card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GodSquareActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes6.dex */
public class k extends b<com.baidu.tieba.card.data.h> {
    private View.OnClickListener aAK;
    private com.baidu.tieba.horizonalList.widget.b cMl;
    private HListView cMu;
    public l cMv;
    private TbPageContext<?> mContext;
    private List<com.baidu.tieba.horizonalList.widget.c> mItemList;

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aAK = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.anO() != null) {
                    k.this.anO().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.cMu = new HListView(getContext());
        this.cMu.setHeaderDividersEnabled(false);
        this.cMu.setFooterDividersEnabled(false);
        this.cMu.setSelector(e.f.list_selector_transparent);
        this.cMu.setPadding(tbPageContext.getResources().getDimensionPixelSize(e.C0175e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(e.C0175e.ds4), 0);
        this.cMv = new l(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cMl = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.card_homepage_rec_god_item, this.cMv);
        this.cMl.setOnClickListener(this.aAK);
        this.cMu.setAdapter((ListAdapter) this.cMl);
        this.cKA.addView(this.cMu);
        this.cKz.setVisibility(8);
        this.cKt.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0175e.ds28));
        this.cKu.setVisibility(0);
        this.cKu.setText(this.mContext.getResources().getString(e.j.recommend_frs_hot_thread_more));
        this.cKs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    k.this.mContext.showToast(e.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(k.this.mContext.getPageActivity())));
                }
            }
        });
        this.cMv.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cMu != null && this.cMl != null) {
            al.h(this.cKu, e.d.cp_cont_d);
            al.h(this.cKt, e.d.cp_cont_d);
            this.cMl.dH(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((k) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.J(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cKt.setText(this.mContext.getPageActivity().getResources().getString(e.j.the_gods_you_may_interest_in));
            }
            if (aZ(hVar.getDataList())) {
                this.mItemList = hVar.getDataList();
                this.cMl.setData(this.mItemList);
                this.cMl.notifyDataSetChanged();
            }
        }
    }

    private boolean aZ(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.J(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.J(this.mItemList) && com.baidu.tbadk.core.util.v.I(this.mItemList) == com.baidu.tbadk.core.util.v.I(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.I(this.mItemList); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.d(this.mItemList, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.d(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.apx != null && !StringUtils.isNull(iVar.apx.getUserId()) && iVar2.apx != null && !StringUtils.isNull(iVar2.apx.getUserId()) && !iVar.apx.getUserId().equals(iVar2.apx.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
