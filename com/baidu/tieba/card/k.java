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
    private View.OnClickListener aFC;
    private HListView cXI;
    public l cXJ;
    private com.baidu.tieba.horizonalList.widget.b cXz;
    private TbPageContext<?> mContext;
    private List<com.baidu.tieba.horizonalList.widget.c> mItemList;

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aFC = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.aqp() != null) {
                    k.this.aqp().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.cXI = new HListView(getContext());
        this.cXI.setHeaderDividersEnabled(false);
        this.cXI.setFooterDividersEnabled(false);
        this.cXI.setSelector(e.f.list_selector_transparent);
        this.cXI.setPadding(tbPageContext.getResources().getDimensionPixelSize(e.C0210e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(e.C0210e.ds4), 0);
        this.cXJ = new l(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cXz = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.card_homepage_rec_god_item, this.cXJ);
        this.cXz.setOnClickListener(this.aFC);
        this.cXI.setAdapter((ListAdapter) this.cXz);
        this.cVO.addView(this.cXI);
        this.cVN.setVisibility(8);
        this.cVH.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.ds28));
        this.cVI.setVisibility(0);
        this.cVI.setText(this.mContext.getResources().getString(e.j.recommend_frs_hot_thread_more));
        this.cVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    k.this.mContext.showToast(e.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(k.this.mContext.getPageActivity())));
                }
            }
        });
        this.cXJ.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cXI != null && this.cXz != null) {
            al.h(this.cVI, e.d.cp_cont_d);
            al.h(this.cVH, e.d.cp_cont_d);
            this.cXz.ej(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((k) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.I(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cVH.setText(this.mContext.getPageActivity().getResources().getString(e.j.the_gods_you_may_interest_in));
            }
            if (bb(hVar.getDataList())) {
                this.mItemList = hVar.getDataList();
                this.cXz.setData(this.mItemList);
                this.cXz.notifyDataSetChanged();
            }
        }
    }

    private boolean bb(List<com.baidu.tieba.horizonalList.widget.c> list) {
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
                    if (iVar.aum != null && !StringUtils.isNull(iVar.aum.getUserId()) && iVar2.aum != null && !StringUtils.isNull(iVar2.aum.getUserId()) && !iVar.aum.getUserId().equals(iVar2.aum.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
