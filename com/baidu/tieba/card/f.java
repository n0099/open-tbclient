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
    private TbPageContext<?> acd;
    private View.OnClickListener ajN;
    public g bZA;
    private List<com.baidu.tieba.horizonalList.widget.d> bZB;
    private com.baidu.tieba.horizonalList.widget.c bZm;
    private HListView bZz;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.abs() != null) {
                    f.this.abs().a(view, null);
                }
            }
        };
        this.acd = tbPageContext;
        this.bZz = new HListView(getContext());
        this.bZz.setHeaderDividersEnabled(false);
        this.bZz.setFooterDividersEnabled(false);
        this.bZz.setSelector(d.f.list_selector_transparent);
        this.bZz.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.bZA = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bZm = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.card_homepage_rec_god_item, this.bZA);
        this.bZm.setOnClickListener(this.ajN);
        this.bZz.setAdapter((ListAdapter) this.bZm);
        this.bYX.addView(this.bZz);
        this.bYW.setVisibility(8);
        this.bYQ.setTextSize(0, com.baidu.adp.lib.util.l.f(this.acd.getPageActivity(), d.e.ds28));
        this.bYR.setVisibility(0);
        this.bYR.setText(this.acd.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.bYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.acd.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.acd.getPageActivity())));
                }
            }
        });
        this.bZA.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bZz != null && this.bZm != null) {
            aj.i(this.bYR, d.C0082d.cp_cont_d);
            aj.i(this.bYQ, d.C0082d.cp_cont_d);
            this.bZm.dj(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.w(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.bYQ.setText(this.acd.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (av(hVar.getDataList())) {
                this.bZB = hVar.getDataList();
                this.bZm.setData(this.bZB);
                this.bZm.notifyDataSetChanged();
            }
        }
    }

    private boolean av(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.w(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.w(this.bZB) && com.baidu.tbadk.core.util.v.v(this.bZB) == com.baidu.tbadk.core.util.v.v(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.v(this.bZB); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(this.bZB, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(list, i);
                if ((dVar instanceof com.baidu.tieba.card.data.i) && (dVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) dVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) dVar2;
                    if (iVar.Zc != null && !StringUtils.isNull(iVar.Zc.getUserId()) && iVar2.Zc != null && !StringUtils.isNull(iVar2.Zc.getUserId()) && !iVar.Zc.getUserId().equals(iVar2.Zc.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
