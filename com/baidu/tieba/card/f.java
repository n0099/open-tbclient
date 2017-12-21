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
    private TbPageContext<?> aca;
    private View.OnClickListener ajN;
    private HListView bZH;
    public g bZI;
    private List<com.baidu.tieba.horizonalList.widget.d> bZJ;
    private com.baidu.tieba.horizonalList.widget.c bZu;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajN = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.abt() != null) {
                    f.this.abt().a(view, null);
                }
            }
        };
        this.aca = tbPageContext;
        this.bZH = new HListView(getContext());
        this.bZH.setHeaderDividersEnabled(false);
        this.bZH.setFooterDividersEnabled(false);
        this.bZH.setSelector(d.f.list_selector_transparent);
        this.bZH.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.bZI = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bZu = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.card_homepage_rec_god_item, this.bZI);
        this.bZu.setOnClickListener(this.ajN);
        this.bZH.setAdapter((ListAdapter) this.bZu);
        this.bZf.addView(this.bZH);
        this.bZe.setVisibility(8);
        this.bYY.setTextSize(0, com.baidu.adp.lib.util.l.f(this.aca.getPageActivity(), d.e.ds28));
        this.bYZ.setVisibility(0);
        this.bYZ.setText(this.aca.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.bYX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.aca.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.aca.getPageActivity())));
                }
            }
        });
        this.bZI.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bZH != null && this.bZu != null) {
            aj.i(this.bYZ, d.C0095d.cp_cont_d);
            aj.i(this.bYY, d.C0095d.cp_cont_d);
            this.bZu.dj(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.w(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.bYY.setText(this.aca.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (av(hVar.getDataList())) {
                this.bZJ = hVar.getDataList();
                this.bZu.setData(this.bZJ);
                this.bZu.notifyDataSetChanged();
            }
        }
    }

    private boolean av(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.w(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.w(this.bZJ) && com.baidu.tbadk.core.util.v.v(this.bZJ) == com.baidu.tbadk.core.util.v.v(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.v(this.bZJ); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(this.bZJ, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(list, i);
                if ((dVar instanceof com.baidu.tieba.card.data.i) && (dVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) dVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) dVar2;
                    if (iVar.YZ != null && !StringUtils.isNull(iVar.YZ.getUserId()) && iVar2.YZ != null && !StringUtils.isNull(iVar2.YZ.getUserId()) && !iVar.YZ.getUserId().equals(iVar2.YZ.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
