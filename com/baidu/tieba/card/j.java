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
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends b<com.baidu.tieba.card.data.h> {
    private View.OnClickListener bNu;
    private List<com.baidu.tieba.horizonalList.widget.c> bkN;
    private com.baidu.tieba.horizonalList.widget.b ehi;
    private HListView ehr;
    public k ehs;
    private TbPageContext<?> mContext;

    public j(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bNu = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aQh() != null) {
                    j.this.aQh().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ehr = new HListView(getContext());
        this.ehr.setHeaderDividersEnabled(false);
        this.ehr.setFooterDividersEnabled(false);
        this.ehr.setSelector(d.f.list_selector_transparent);
        this.ehr.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.ehs = new k(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.ehi = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.card_homepage_rec_god_item, this.ehs);
        this.ehi.setOnClickListener(this.bNu);
        this.ehr.setAdapter((ListAdapter) this.ehi);
        this.efC.addView(this.ehr);
        this.efB.setVisibility(8);
        this.efv.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds28));
        this.efw.setVisibility(0);
        this.efw.setText(this.mContext.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.efu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    j.this.mContext.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(j.this.mContext.getPageActivity())));
                }
            }
        });
        this.ehs.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.ehr != null && this.ehi != null) {
            al.j(this.efw, d.C0277d.cp_cont_d);
            al.j(this.efv, d.C0277d.cp_cont_d);
            this.ehi.hN(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((j) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.T(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.efv.setText(this.mContext.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (bp(hVar.getDataList())) {
                this.bkN = hVar.getDataList();
                this.ehi.setData(this.bkN);
                this.ehi.notifyDataSetChanged();
            }
        }
    }

    private boolean bp(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.T(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.T(this.bkN) && com.baidu.tbadk.core.util.v.S(this.bkN) == com.baidu.tbadk.core.util.v.S(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.S(this.bkN); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(this.bkN, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.bBG != null && !StringUtils.isNull(iVar.bBG.getUserId()) && iVar2.bBG != null && !StringUtils.isNull(iVar2.bBG.getUserId()) && !iVar.bBG.getUserId().equals(iVar2.bBG.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
