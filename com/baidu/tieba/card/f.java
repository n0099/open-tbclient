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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes.dex */
public class f extends b<com.baidu.tieba.card.data.h> {
    private TbPageContext<?> aQp;
    private View.OnClickListener aXV;
    private com.baidu.tieba.horizonalList.widget.c cSA;
    private HListView cSN;
    public g cSO;
    private List<com.baidu.tieba.horizonalList.widget.d> cSP;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aXV = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.akb() != null) {
                    f.this.akb().a(view, null);
                }
            }
        };
        this.aQp = tbPageContext;
        this.cSN = new HListView(getContext());
        this.cSN.setHeaderDividersEnabled(false);
        this.cSN.setFooterDividersEnabled(false);
        this.cSN.setSelector(d.f.list_selector_transparent);
        this.cSN.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.cSO = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cSA = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.card_homepage_rec_god_item, this.cSO);
        this.cSA.setOnClickListener(this.aXV);
        this.cSN.setAdapter((ListAdapter) this.cSA);
        this.cSm.addView(this.cSN);
        this.cSl.setVisibility(8);
        this.cSf.setTextSize(0, com.baidu.adp.lib.util.l.s(this.aQp.getPageActivity(), d.e.ds28));
        this.cSg.setVisibility(0);
        this.cSg.setText(this.aQp.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.cSe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.aQp.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.aQp.getPageActivity())));
                }
            }
        });
        this.cSO.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cSN != null && this.cSA != null) {
            aj.r(this.cSg, d.C0107d.cp_cont_d);
            aj.r(this.cSf, d.C0107d.cp_cont_d);
            this.cSA.gg(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.E(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cSf.setText(this.aQp.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (aE(hVar.getDataList())) {
                this.cSP = hVar.getDataList();
                this.cSA.setData(this.cSP);
                this.cSA.notifyDataSetChanged();
            }
        }
    }

    private boolean aE(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.E(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.E(this.cSP) && com.baidu.tbadk.core.util.v.D(this.cSP) == com.baidu.tbadk.core.util.v.D(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.D(this.cSP); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(this.cSP, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(list, i);
                if ((dVar instanceof com.baidu.tieba.card.data.i) && (dVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) dVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) dVar2;
                    if (iVar.aNu != null && !StringUtils.isNull(iVar.aNu.getUserId()) && iVar2.aNu != null && !StringUtils.isNull(iVar2.aNu.getUserId()) && !iVar.aNu.getUserId().equals(iVar2.aNu.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
