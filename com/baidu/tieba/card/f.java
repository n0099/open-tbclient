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
    private TbPageContext<?> abm;
    private View.OnClickListener aiV;
    private HListView bJI;
    public g bJJ;
    private List<com.baidu.tieba.horizonalList.widget.d> bJK;
    private com.baidu.tieba.horizonalList.widget.c bJv;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aiV = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.Xn() != null) {
                    f.this.Xn().a(view, null);
                }
            }
        };
        this.abm = tbPageContext;
        this.bJI = new HListView(getContext());
        this.bJI.setHeaderDividersEnabled(false);
        this.bJI.setFooterDividersEnabled(false);
        this.bJI.setSelector(d.g.list_selector_transparent);
        this.bJI.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0);
        this.bJJ = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bJv = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.card_homepage_rec_god_item, this.bJJ);
        this.bJv.setOnClickListener(this.aiV);
        this.bJI.setAdapter((ListAdapter) this.bJv);
        this.bJg.addView(this.bJI);
        this.bJf.setVisibility(8);
        this.bIZ.setTextSize(0, com.baidu.adp.lib.util.l.f(this.abm.getPageActivity(), d.f.ds28));
        this.bJa.setVisibility(0);
        this.bJa.setText(this.abm.getResources().getString(d.l.recommend_frs_hot_thread_more));
        this.bIY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.abm.showToast(d.l.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.abm.getPageActivity())));
                }
            }
        });
        this.bJJ.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bJI != null && this.bJv != null) {
            aj.i(this.bJa, d.e.cp_cont_d);
            aj.i(this.bIZ, d.e.cp_cont_d);
            this.bJv.di(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.u(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.bIZ.setText(this.abm.getPageActivity().getResources().getString(d.l.the_gods_you_may_interest_in));
            }
            if (ah(hVar.getDataList())) {
                this.bJK = hVar.getDataList();
                this.bJv.setData(this.bJK);
                this.bJv.notifyDataSetChanged();
            }
        }
    }

    private boolean ah(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.u(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.u(this.bJK) && com.baidu.tbadk.core.util.v.t(this.bJK) == com.baidu.tbadk.core.util.v.t(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.t(this.bJK); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(this.bJK, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(list, i);
                if ((dVar instanceof com.baidu.tieba.card.data.i) && (dVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) dVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) dVar2;
                    if (iVar.author != null && !StringUtils.isNull(iVar.author.getUserId()) && iVar2.author != null && !StringUtils.isNull(iVar2.author.getUserId()) && !iVar.author.getUserId().equals(iVar2.author.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
