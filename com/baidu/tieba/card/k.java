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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends b<com.baidu.tieba.card.data.h> {
    private TbPageContext<?> adf;
    private View.OnClickListener alg;
    private com.baidu.tieba.horizonalList.widget.b cnK;
    private HListView cnT;
    public l cnU;
    private List<com.baidu.tieba.horizonalList.widget.c> cnV;

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.alg = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.aeZ() != null) {
                    k.this.aeZ().a(view2, null);
                }
            }
        };
        this.adf = tbPageContext;
        this.cnT = new HListView(getContext());
        this.cnT.setHeaderDividersEnabled(false);
        this.cnT.setFooterDividersEnabled(false);
        this.cnT.setSelector(d.f.list_selector_transparent);
        this.cnT.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.cnU = new l(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cnK = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.card_homepage_rec_god_item, this.cnU);
        this.cnK.setOnClickListener(this.alg);
        this.cnT.setAdapter((ListAdapter) this.cnK);
        this.clX.addView(this.cnT);
        this.clW.setVisibility(8);
        this.clQ.setTextSize(0, com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.ds28));
        this.clR.setVisibility(0);
        this.clR.setText(this.adf.getResources().getString(d.k.recommend_frs_hot_thread_more));
        this.clP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    k.this.adf.showToast(d.k.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(k.this.adf.getPageActivity())));
                }
            }
        });
        this.cnU.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cnT != null && this.cnK != null) {
            ak.h(this.clR, d.C0126d.cp_cont_d);
            ak.h(this.clQ, d.C0126d.cp_cont_d);
            this.cnK.dh(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((k) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.w(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.clQ.setText(this.adf.getPageActivity().getResources().getString(d.k.the_gods_you_may_interest_in));
            }
            if (aC(hVar.getDataList())) {
                this.cnV = hVar.getDataList();
                this.cnK.setData(this.cnV);
                this.cnK.notifyDataSetChanged();
            }
        }
    }

    private boolean aC(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.w(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.w(this.cnV) && com.baidu.tbadk.core.util.v.v(this.cnV) == com.baidu.tbadk.core.util.v.v(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.v(this.cnV); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(this.cnV, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.aae != null && !StringUtils.isNull(iVar.aae.getUserId()) && iVar2.aae != null && !StringUtils.isNull(iVar2.aae.getUserId()) && !iVar.aae.getUserId().equals(iVar2.aae.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
