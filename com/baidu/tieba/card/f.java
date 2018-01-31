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
    private TbPageContext<?> aQs;
    private View.OnClickListener aYd;
    private com.baidu.tieba.horizonalList.widget.c cSV;
    private HListView cTi;
    public g cTj;
    private List<com.baidu.tieba.horizonalList.widget.d> cTk;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aYd = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.akg() != null) {
                    f.this.akg().a(view, null);
                }
            }
        };
        this.aQs = tbPageContext;
        this.cTi = new HListView(getContext());
        this.cTi.setHeaderDividersEnabled(false);
        this.cTi.setFooterDividersEnabled(false);
        this.cTi.setSelector(d.f.list_selector_transparent);
        this.cTi.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.cTj = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cSV = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.h.card_homepage_rec_god_item, this.cTj);
        this.cSV.setOnClickListener(this.aYd);
        this.cTi.setAdapter((ListAdapter) this.cSV);
        this.cSH.addView(this.cTi);
        this.cSG.setVisibility(8);
        this.cSA.setTextSize(0, com.baidu.adp.lib.util.l.s(this.aQs.getPageActivity(), d.e.ds28));
        this.cSB.setVisibility(0);
        this.cSB.setText(this.aQs.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.cSz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.aQs.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.aQs.getPageActivity())));
                }
            }
        });
        this.cTj.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cTi != null && this.cSV != null) {
            aj.r(this.cSB, d.C0108d.cp_cont_d);
            aj.r(this.cSA, d.C0108d.cp_cont_d);
            this.cSV.gg(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.E(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cSA.setText(this.aQs.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (aE(hVar.getDataList())) {
                this.cTk = hVar.getDataList();
                this.cSV.setData(this.cTk);
                this.cSV.notifyDataSetChanged();
            }
        }
    }

    private boolean aE(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.E(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.E(this.cTk) && com.baidu.tbadk.core.util.v.D(this.cTk) == com.baidu.tbadk.core.util.v.D(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.D(this.cTk); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(this.cTk, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.f(list, i);
                if ((dVar instanceof com.baidu.tieba.card.data.i) && (dVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) dVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) dVar2;
                    if (iVar.aNx != null && !StringUtils.isNull(iVar.aNx.getUserId()) && iVar2.aNx != null && !StringUtils.isNull(iVar2.aNx.getUserId()) && !iVar.aNx.getUserId().equals(iVar2.aNx.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
