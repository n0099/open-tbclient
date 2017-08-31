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
    private TbPageContext<?> aby;
    private View.OnClickListener ajG;
    private com.baidu.tieba.horizonalList.widget.c bJD;
    private HListView bJQ;
    public g bJR;
    private List<com.baidu.tieba.horizonalList.widget.d> bJS;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajG = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.XA() != null) {
                    f.this.XA().a(view, null);
                }
            }
        };
        this.aby = tbPageContext;
        this.bJQ = new HListView(getContext());
        this.bJQ.setHeaderDividersEnabled(false);
        this.bJQ.setFooterDividersEnabled(false);
        this.bJQ.setSelector(d.g.list_selector_transparent);
        this.bJQ.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0);
        this.bJR = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bJD = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.card_homepage_rec_god_item, this.bJR);
        this.bJD.setOnClickListener(this.ajG);
        this.bJQ.setAdapter((ListAdapter) this.bJD);
        this.bJn.addView(this.bJQ);
        this.bJm.setVisibility(8);
        this.bJg.setTextSize(0, com.baidu.adp.lib.util.k.g(this.aby.getPageActivity(), d.f.ds28));
        this.bJh.setVisibility(0);
        this.bJh.setText(this.aby.getResources().getString(d.l.recommend_frs_hot_thread_more));
        this.bJf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.aby.showToast(d.l.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.aby.getPageActivity())));
                }
            }
        });
        this.bJR.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bJQ != null && this.bJD != null) {
            aj.i(this.bJh, d.e.cp_cont_d);
            aj.i(this.bJg, d.e.cp_cont_d);
            this.bJD.dj(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.v(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.bJg.setText(this.aby.getPageActivity().getResources().getString(d.l.the_gods_you_may_interest_in));
            }
            if (ai(hVar.getDataList())) {
                this.bJS = hVar.getDataList();
                this.bJD.setData(this.bJS);
                this.bJD.notifyDataSetChanged();
            }
        }
    }

    private boolean ai(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.v(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.v(this.bJS) && com.baidu.tbadk.core.util.v.u(this.bJS) == com.baidu.tbadk.core.util.v.u(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.u(this.bJS); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(this.bJS, i);
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
