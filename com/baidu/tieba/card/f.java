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
    private TbPageContext<?> aRI;
    private View.OnClickListener aZD;
    private com.baidu.tieba.horizonalList.widget.c cVH;
    private HListView cVT;
    public g cVU;
    private List<com.baidu.tieba.horizonalList.widget.d> cVV;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aZD = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.akP() != null) {
                    f.this.akP().a(view, null);
                }
            }
        };
        this.aRI = tbPageContext;
        this.cVT = new HListView(getContext());
        this.cVT.setHeaderDividersEnabled(false);
        this.cVT.setFooterDividersEnabled(false);
        this.cVT.setSelector(d.f.list_selector_transparent);
        this.cVT.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.cVU = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cVH = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.card_homepage_rec_god_item, this.cVU);
        this.cVH.setOnClickListener(this.aZD);
        this.cVT.setAdapter((ListAdapter) this.cVH);
        this.cVu.addView(this.cVT);
        this.cVt.setVisibility(8);
        this.cVn.setTextSize(0, com.baidu.adp.lib.util.l.t(this.aRI.getPageActivity(), d.e.ds28));
        this.cVo.setVisibility(0);
        this.cVo.setText(this.aRI.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.cVm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.aRI.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(f.this.aRI.getPageActivity())));
                }
            }
        });
        this.cVU.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cVT != null && this.cVH != null) {
            aj.r(this.cVo, d.C0141d.cp_cont_d);
            aj.r(this.cVn, d.C0141d.cp_cont_d);
            this.cVH.gi(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.E(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cVn.setText(this.aRI.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (aH(hVar.getDataList())) {
                this.cVV = hVar.getDataList();
                this.cVH.setData(this.cVV);
                this.cVH.notifyDataSetChanged();
            }
        }
    }

    private boolean aH(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.E(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.E(this.cVV) && com.baidu.tbadk.core.util.v.D(this.cVV) == com.baidu.tbadk.core.util.v.D(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.D(this.cVV); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(this.cVV, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(list, i);
                if ((dVar instanceof com.baidu.tieba.card.data.i) && (dVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) dVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) dVar2;
                    if (iVar.aOG != null && !StringUtils.isNull(iVar.aOG.getUserId()) && iVar2.aOG != null && !StringUtils.isNull(iVar2.aOG.getUserId()) && !iVar.aOG.getUserId().equals(iVar2.aOG.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
