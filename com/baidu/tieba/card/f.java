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
    private TbPageContext<?> abz;
    private View.OnClickListener ajh;
    private com.baidu.tieba.horizonalList.widget.c bJH;
    private HListView bJU;
    public g bJV;
    private List<com.baidu.tieba.horizonalList.widget.d> bJW;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajh = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.Xr() != null) {
                    f.this.Xr().a(view, null);
                }
            }
        };
        this.abz = tbPageContext;
        this.bJU = new HListView(getContext());
        this.bJU.setHeaderDividersEnabled(false);
        this.bJU.setFooterDividersEnabled(false);
        this.bJU.setSelector(d.g.list_selector_transparent);
        this.bJU.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0);
        this.bJV = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bJH = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.card_homepage_rec_god_item, this.bJV);
        this.bJH.setOnClickListener(this.ajh);
        this.bJU.setAdapter((ListAdapter) this.bJH);
        this.bJs.addView(this.bJU);
        this.bJr.setVisibility(8);
        this.bJl.setTextSize(0, com.baidu.adp.lib.util.l.f(this.abz.getPageActivity(), d.f.ds28));
        this.bJm.setVisibility(0);
        this.bJm.setText(this.abz.getResources().getString(d.l.recommend_frs_hot_thread_more));
        this.bJk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.abz.showToast(d.l.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.abz.getPageActivity())));
                }
            }
        });
        this.bJV.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bJU != null && this.bJH != null) {
            aj.i(this.bJm, d.e.cp_cont_d);
            aj.i(this.bJl, d.e.cp_cont_d);
            this.bJH.dj(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.u(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.bJl.setText(this.abz.getPageActivity().getResources().getString(d.l.the_gods_you_may_interest_in));
            }
            if (ah(hVar.getDataList())) {
                this.bJW = hVar.getDataList();
                this.bJH.setData(this.bJW);
                this.bJH.notifyDataSetChanged();
            }
        }
    }

    private boolean ah(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.u(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.u(this.bJW) && com.baidu.tbadk.core.util.v.t(this.bJW) == com.baidu.tbadk.core.util.v.t(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.t(this.bJW); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(this.bJW, i);
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
