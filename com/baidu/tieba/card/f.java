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
    private TbPageContext<?> abX;
    private View.OnClickListener ajK;
    private HListView bZD;
    public g bZE;
    private List<com.baidu.tieba.horizonalList.widget.d> bZF;
    private com.baidu.tieba.horizonalList.widget.c bZq;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajK = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.abt() != null) {
                    f.this.abt().a(view, null);
                }
            }
        };
        this.abX = tbPageContext;
        this.bZD = new HListView(getContext());
        this.bZD.setHeaderDividersEnabled(false);
        this.bZD.setFooterDividersEnabled(false);
        this.bZD.setSelector(d.f.list_selector_transparent);
        this.bZD.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.bZE = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bZq = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.card_homepage_rec_god_item, this.bZE);
        this.bZq.setOnClickListener(this.ajK);
        this.bZD.setAdapter((ListAdapter) this.bZq);
        this.bZb.addView(this.bZD);
        this.bZa.setVisibility(8);
        this.bYU.setTextSize(0, com.baidu.adp.lib.util.l.f(this.abX.getPageActivity(), d.e.ds28));
        this.bYV.setVisibility(0);
        this.bYV.setText(this.abX.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.bYT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.abX.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.abX.getPageActivity())));
                }
            }
        });
        this.bZE.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bZD != null && this.bZq != null) {
            aj.i(this.bYV, d.C0096d.cp_cont_d);
            aj.i(this.bYU, d.C0096d.cp_cont_d);
            this.bZq.dj(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.w(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.bYU.setText(this.abX.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (av(hVar.getDataList())) {
                this.bZF = hVar.getDataList();
                this.bZq.setData(this.bZF);
                this.bZq.notifyDataSetChanged();
            }
        }
    }

    private boolean av(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.w(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.w(this.bZF) && com.baidu.tbadk.core.util.v.v(this.bZF) == com.baidu.tbadk.core.util.v.v(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.v(this.bZF); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(this.bZF, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(list, i);
                if ((dVar instanceof com.baidu.tieba.card.data.i) && (dVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) dVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) dVar2;
                    if (iVar.YW != null && !StringUtils.isNull(iVar.YW.getUserId()) && iVar2.YW != null && !StringUtils.isNull(iVar2.YW.getUserId()) && !iVar.YW.getUserId().equals(iVar2.YW.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
