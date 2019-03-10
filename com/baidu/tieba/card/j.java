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
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends b<h> {
    private View.OnClickListener bNt;
    private List<com.baidu.tieba.horizonalList.widget.c> bkM;
    private com.baidu.tieba.horizonalList.widget.b ehm;
    private HListView ehv;
    public k ehw;
    private TbPageContext<?> mContext;

    public j(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bNt = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aQi() != null) {
                    j.this.aQi().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ehv = new HListView(getContext());
        this.ehv.setHeaderDividersEnabled(false);
        this.ehv.setFooterDividersEnabled(false);
        this.ehv.setSelector(d.f.list_selector_transparent);
        this.ehv.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.ehw = new k(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.ehm = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.card_homepage_rec_god_item, this.ehw);
        this.ehm.setOnClickListener(this.bNt);
        this.ehv.setAdapter((ListAdapter) this.ehm);
        this.efG.addView(this.ehv);
        this.efF.setVisibility(8);
        this.efz.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds28));
        this.efA.setVisibility(0);
        this.efA.setText(this.mContext.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.efy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    j.this.mContext.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(j.this.mContext.getPageActivity())));
                }
            }
        });
        this.ehw.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.ehv != null && this.ehm != null) {
            al.j(this.efA, d.C0236d.cp_cont_d);
            al.j(this.efz, d.C0236d.cp_cont_d);
            this.ehm.hN(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(h hVar) {
        super.a((j) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.T(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.efz.setText(this.mContext.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (bp(hVar.getDataList())) {
                this.bkM = hVar.getDataList();
                this.ehm.setData(this.bkM);
                this.ehm.notifyDataSetChanged();
            }
        }
    }

    private boolean bp(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.T(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.T(this.bkM) && com.baidu.tbadk.core.util.v.S(this.bkM) == com.baidu.tbadk.core.util.v.S(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.S(this.bkM); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(this.bkM, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.bBE != null && !StringUtils.isNull(iVar.bBE.getUserId()) && iVar2.bBE != null && !StringUtils.isNull(iVar2.bBE.getUserId()) && !iVar.bBE.getUserId().equals(iVar2.bBE.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
