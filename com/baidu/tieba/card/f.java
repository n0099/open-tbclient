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
    private TbPageContext<?> abI;
    private View.OnClickListener ajr;
    private com.baidu.tieba.horizonalList.widget.c bRb;
    private HListView bRo;
    public g bRp;
    private List<com.baidu.tieba.horizonalList.widget.d> bRq;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajr = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.Zx() != null) {
                    f.this.Zx().a(view, null);
                }
            }
        };
        this.abI = tbPageContext;
        this.bRo = new HListView(getContext());
        this.bRo.setHeaderDividersEnabled(false);
        this.bRo.setFooterDividersEnabled(false);
        this.bRo.setSelector(d.f.list_selector_transparent);
        this.bRo.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.bRp = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bRb = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.card_homepage_rec_god_item, this.bRp);
        this.bRb.setOnClickListener(this.ajr);
        this.bRo.setAdapter((ListAdapter) this.bRb);
        this.bQM.addView(this.bRo);
        this.bQL.setVisibility(8);
        this.bQF.setTextSize(0, com.baidu.adp.lib.util.l.f(this.abI.getPageActivity(), d.e.ds28));
        this.bQG.setVisibility(0);
        this.bQG.setText(this.abI.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.bQE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.abI.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.abI.getPageActivity())));
                }
            }
        });
        this.bRp.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bRo != null && this.bRb != null) {
            aj.i(this.bQG, d.C0080d.cp_cont_d);
            aj.i(this.bQF, d.C0080d.cp_cont_d);
            this.bRb.dj(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.v(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.bQF.setText(this.abI.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (aj(hVar.getDataList())) {
                this.bRq = hVar.getDataList();
                this.bRb.setData(this.bRq);
                this.bRb.notifyDataSetChanged();
            }
        }
    }

    private boolean aj(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.v(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.v(this.bRq) && com.baidu.tbadk.core.util.v.u(this.bRq) == com.baidu.tbadk.core.util.v.u(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.u(this.bRq); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(this.bRq, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(list, i);
                if ((dVar instanceof com.baidu.tieba.card.data.i) && (dVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) dVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) dVar2;
                    if (iVar.YJ != null && !StringUtils.isNull(iVar.YJ.getUserId()) && iVar2.YJ != null && !StringUtils.isNull(iVar2.YJ.getUserId()) && !iVar.YJ.getUserId().equals(iVar2.YJ.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
