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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes.dex */
public class f extends b<com.baidu.tieba.card.data.h> {
    private TbPageContext<?> aRR;
    private View.OnClickListener aZN;
    private com.baidu.tieba.horizonalList.widget.c cVQ;
    private HListView cWc;
    public g cWd;
    private List<com.baidu.tieba.horizonalList.widget.d> cWe;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aZN = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.akP() != null) {
                    f.this.akP().a(view, null);
                }
            }
        };
        this.aRR = tbPageContext;
        this.cWc = new HListView(getContext());
        this.cWc.setHeaderDividersEnabled(false);
        this.cWc.setFooterDividersEnabled(false);
        this.cWc.setSelector(d.f.list_selector_transparent);
        this.cWc.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.cWd = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cVQ = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.card_homepage_rec_god_item, this.cWd);
        this.cVQ.setOnClickListener(this.aZN);
        this.cWc.setAdapter((ListAdapter) this.cVQ);
        this.cVD.addView(this.cWc);
        this.cVC.setVisibility(8);
        this.cVw.setTextSize(0, com.baidu.adp.lib.util.l.t(this.aRR.getPageActivity(), d.e.ds28));
        this.cVx.setVisibility(0);
        this.cVx.setText(this.aRR.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.cVv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.aRR.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(f.this.aRR.getPageActivity())));
                }
            }
        });
        this.cWd.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cWc != null && this.cVQ != null) {
            aj.r(this.cVx, d.C0140d.cp_cont_d);
            aj.r(this.cVw, d.C0140d.cp_cont_d);
            this.cVQ.gi(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.E(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cVw.setText(this.aRR.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (aH(hVar.getDataList())) {
                this.cWe = hVar.getDataList();
                this.cVQ.setData(this.cWe);
                this.cVQ.notifyDataSetChanged();
            }
        }
    }

    private boolean aH(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.E(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.E(this.cWe) && com.baidu.tbadk.core.util.v.D(this.cWe) == com.baidu.tbadk.core.util.v.D(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.D(this.cWe); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(this.cWe, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(list, i);
                if ((dVar instanceof com.baidu.tieba.card.data.i) && (dVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) dVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) dVar2;
                    if (iVar.aOQ != null && !StringUtils.isNull(iVar.aOQ.getUserId()) && iVar2.aOQ != null && !StringUtils.isNull(iVar2.aOQ.getUserId()) && !iVar.aOQ.getUserId().equals(iVar2.aOQ.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
