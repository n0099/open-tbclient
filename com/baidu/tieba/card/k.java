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
    private View.OnClickListener aBz;
    private HListView cNA;
    public l cNB;
    private com.baidu.tieba.horizonalList.widget.b cNr;
    private TbPageContext<?> mContext;
    private List<com.baidu.tieba.horizonalList.widget.c> mItemList;

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aBz = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.anq() != null) {
                    k.this.anq().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.cNA = new HListView(getContext());
        this.cNA.setHeaderDividersEnabled(false);
        this.cNA.setFooterDividersEnabled(false);
        this.cNA.setSelector(e.f.list_selector_transparent);
        this.cNA.setPadding(tbPageContext.getResources().getDimensionPixelSize(e.C0200e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(e.C0200e.ds4), 0);
        this.cNB = new l(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cNr = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.card_homepage_rec_god_item, this.cNB);
        this.cNr.setOnClickListener(this.aBz);
        this.cNA.setAdapter((ListAdapter) this.cNr);
        this.cLG.addView(this.cNA);
        this.cLF.setVisibility(8);
        this.cLz.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0200e.ds28));
        this.cLA.setVisibility(0);
        this.cLA.setText(this.mContext.getResources().getString(e.j.recommend_frs_hot_thread_more));
        this.cLy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    k.this.mContext.showToast(e.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(k.this.mContext.getPageActivity())));
                }
            }
        });
        this.cNB.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cNA != null && this.cNr != null) {
            al.h(this.cLA, e.d.cp_cont_d);
            al.h(this.cLz, e.d.cp_cont_d);
            this.cNr.dV(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((k) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.I(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cLz.setText(this.mContext.getPageActivity().getResources().getString(e.j.the_gods_you_may_interest_in));
            }
            if (aX(hVar.getDataList())) {
                this.mItemList = hVar.getDataList();
                this.cNr.setData(this.mItemList);
                this.cNr.notifyDataSetChanged();
            }
        }
    }

    private boolean aX(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.I(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.I(this.mItemList) && com.baidu.tbadk.core.util.v.H(this.mItemList) == com.baidu.tbadk.core.util.v.H(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.H(this.mItemList); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.d(this.mItemList, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.d(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.aqk != null && !StringUtils.isNull(iVar.aqk.getUserId()) && iVar2.aqk != null && !StringUtils.isNull(iVar2.aqk.getUserId()) && !iVar.aqk.getUserId().equals(iVar2.aqk.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
