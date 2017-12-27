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
    private TbPageContext<?> aQq;
    private View.OnClickListener aXW;
    private com.baidu.tieba.horizonalList.widget.c cNZ;
    private HListView cOm;
    public g cOn;
    private List<com.baidu.tieba.horizonalList.widget.d> cOo;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aXW = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aiY() != null) {
                    f.this.aiY().a(view, null);
                }
            }
        };
        this.aQq = tbPageContext;
        this.cOm = new HListView(getContext());
        this.cOm.setHeaderDividersEnabled(false);
        this.cOm.setFooterDividersEnabled(false);
        this.cOm.setSelector(d.f.list_selector_transparent);
        this.cOm.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.cOn = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cNZ = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.card_homepage_rec_god_item, this.cOn);
        this.cNZ.setOnClickListener(this.aXW);
        this.cOm.setAdapter((ListAdapter) this.cNZ);
        this.cNL.addView(this.cOm);
        this.cNK.setVisibility(8);
        this.cNE.setTextSize(0, com.baidu.adp.lib.util.l.s(this.aQq.getPageActivity(), d.e.ds28));
        this.cNF.setVisibility(0);
        this.cNF.setText(this.aQq.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.cND.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.aQq.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.aQq.getPageActivity())));
                }
            }
        });
        this.cOn.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cOm != null && this.cNZ != null) {
            aj.r(this.cNF, d.C0108d.cp_cont_d);
            aj.r(this.cNE, d.C0108d.cp_cont_d);
            this.cNZ.gi(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.G(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cNE.setText(this.aQq.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (aG(hVar.getDataList())) {
                this.cOo = hVar.getDataList();
                this.cNZ.setData(this.cOo);
                this.cNZ.notifyDataSetChanged();
            }
        }
    }

    private boolean aG(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.G(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.G(this.cOo) && com.baidu.tbadk.core.util.v.F(this.cOo) == com.baidu.tbadk.core.util.v.F(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.F(this.cOo); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(this.cOo, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(list, i);
                if ((dVar instanceof com.baidu.tieba.card.data.i) && (dVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) dVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) dVar2;
                    if (iVar.aNy != null && !StringUtils.isNull(iVar.aNy.getUserId()) && iVar2.aNy != null && !StringUtils.isNull(iVar2.aNy.getUserId()) && !iVar.aNy.getUserId().equals(iVar2.aNy.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
