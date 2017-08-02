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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes.dex */
public class f extends b<com.baidu.tieba.card.data.h> {
    private TbPageContext<?> aaS;
    private View.OnClickListener aiR;
    private com.baidu.tieba.horizonalList.widget.c bEP;
    private HListView bFc;
    public g bFd;
    private List<com.baidu.tieba.horizonalList.widget.d> bFe;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aiR = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.VZ() != null) {
                    f.this.VZ().a(view, null);
                }
            }
        };
        this.aaS = tbPageContext;
        this.bFc = new HListView(getContext());
        this.bFc.setHeaderDividersEnabled(false);
        this.bFc.setFooterDividersEnabled(false);
        this.bFc.setSelector(d.g.list_selector_transparent);
        this.bFc.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0);
        this.bFd = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bEP = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.card_homepage_rec_god_item, this.bFd);
        this.bEP.setOnClickListener(this.aiR);
        this.bFc.setAdapter((ListAdapter) this.bEP);
        this.bEz.addView(this.bFc);
        this.bEy.setVisibility(8);
        this.bEs.setTextSize(0, com.baidu.adp.lib.util.k.g(this.aaS.getPageActivity(), d.f.ds28));
        this.bEt.setVisibility(0);
        this.bEt.setText(this.aaS.getResources().getString(d.l.recommend_frs_hot_thread_more));
        this.bEr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.aaS.showToast(d.l.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.aaS.getPageActivity())));
                }
            }
        });
        this.bFd.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bFc != null && this.bEP != null) {
            ai.i(this.bEt, d.e.cp_cont_d);
            ai.i(this.bEs, d.e.cp_cont_d);
            this.bEP.dg(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.u.v(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.bEs.setText(this.aaS.getPageActivity().getResources().getString(d.l.the_gods_you_may_interest_in));
            }
            if (ai(hVar.getDataList())) {
                this.bFe = hVar.getDataList();
                this.bEP.setData(this.bFe);
                this.bEP.notifyDataSetChanged();
            }
        }
    }

    private boolean ai(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.u.v(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.u.v(this.bFe) && com.baidu.tbadk.core.util.u.u(this.bFe) == com.baidu.tbadk.core.util.u.u(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.u.u(this.bFe); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.u.c(this.bFe, i);
                com.baidu.tieba.horizonalList.widget.d dVar2 = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.u.c(list, i);
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
