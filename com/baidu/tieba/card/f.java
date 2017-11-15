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
    private HListView bRB;
    public g bRC;
    private List<com.baidu.tieba.horizonalList.widget.d> bRD;
    private com.baidu.tieba.horizonalList.widget.c bRo;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajr = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ZJ() != null) {
                    f.this.ZJ().a(view, null);
                }
            }
        };
        this.abI = tbPageContext;
        this.bRB = new HListView(getContext());
        this.bRB.setHeaderDividersEnabled(false);
        this.bRB.setFooterDividersEnabled(false);
        this.bRB.setSelector(d.f.list_selector_transparent);
        this.bRB.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.bRC = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bRo = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.card_homepage_rec_god_item, this.bRC);
        this.bRo.setOnClickListener(this.ajr);
        this.bRB.setAdapter((ListAdapter) this.bRo);
        this.bQZ.addView(this.bRB);
        this.bQY.setVisibility(8);
        this.bQS.setTextSize(0, com.baidu.adp.lib.util.l.f(this.abI.getPageActivity(), d.e.ds28));
        this.bQT.setVisibility(0);
        this.bQT.setText(this.abI.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.bQR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.abI.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.abI.getPageActivity())));
                }
            }
        });
        this.bRC.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bRB != null && this.bRo != null) {
            aj.i(this.bQT, d.C0080d.cp_cont_d);
            aj.i(this.bQS, d.C0080d.cp_cont_d);
            this.bRo.di(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.v(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.bQS.setText(this.abI.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (aj(hVar.getDataList())) {
                this.bRD = hVar.getDataList();
                this.bRo.setData(this.bRD);
                this.bRo.notifyDataSetChanged();
            }
        }
    }

    private boolean aj(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.v(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.v(this.bRD) && com.baidu.tbadk.core.util.v.u(this.bRD) == com.baidu.tbadk.core.util.v.u(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.u(this.bRD); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(this.bRD, i);
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
