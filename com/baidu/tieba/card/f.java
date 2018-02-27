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
    private TbPageContext<?> aRG;
    private View.OnClickListener aZB;
    private com.baidu.tieba.horizonalList.widget.c cVE;
    private HListView cVQ;
    public g cVR;
    private List<com.baidu.tieba.horizonalList.widget.d> cVS;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aZB = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.akO() != null) {
                    f.this.akO().a(view, null);
                }
            }
        };
        this.aRG = tbPageContext;
        this.cVQ = new HListView(getContext());
        this.cVQ.setHeaderDividersEnabled(false);
        this.cVQ.setFooterDividersEnabled(false);
        this.cVQ.setSelector(d.f.list_selector_transparent);
        this.cVQ.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.cVR = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cVE = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.card_homepage_rec_god_item, this.cVR);
        this.cVE.setOnClickListener(this.aZB);
        this.cVQ.setAdapter((ListAdapter) this.cVE);
        this.cVr.addView(this.cVQ);
        this.cVq.setVisibility(8);
        this.cVk.setTextSize(0, com.baidu.adp.lib.util.l.t(this.aRG.getPageActivity(), d.e.ds28));
        this.cVl.setVisibility(0);
        this.cVl.setText(this.aRG.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.cVj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.aRG.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(f.this.aRG.getPageActivity())));
                }
            }
        });
        this.cVR.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cVQ != null && this.cVE != null) {
            aj.r(this.cVl, d.C0141d.cp_cont_d);
            aj.r(this.cVk, d.C0141d.cp_cont_d);
            this.cVE.gi(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.E(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cVk.setText(this.aRG.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (aH(hVar.getDataList())) {
                this.cVS = hVar.getDataList();
                this.cVE.setData(this.cVS);
                this.cVE.notifyDataSetChanged();
            }
        }
    }

    private boolean aH(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.E(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.E(this.cVS) && com.baidu.tbadk.core.util.v.D(this.cVS) == com.baidu.tbadk.core.util.v.D(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.D(this.cVS); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(this.cVS, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(list, i);
                if ((dVar instanceof com.baidu.tieba.card.data.i) && (dVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) dVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) dVar2;
                    if (iVar.aOF != null && !StringUtils.isNull(iVar.aOF.getUserId()) && iVar2.aOF != null && !StringUtils.isNull(iVar2.aOF.getUserId()) && !iVar.aOF.getUserId().equals(iVar2.aOF.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
