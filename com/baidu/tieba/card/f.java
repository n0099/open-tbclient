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
    private View.OnClickListener ajF;
    private HListView bKH;
    public g bKI;
    private List<com.baidu.tieba.horizonalList.widget.d> bKJ;
    private com.baidu.tieba.horizonalList.widget.c bKu;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajF = new View.OnClickListener() { // from class: com.baidu.tieba.card.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.XL() != null) {
                    f.this.XL().a(view, null);
                }
            }
        };
        this.aby = tbPageContext;
        this.bKH = new HListView(getContext());
        this.bKH.setHeaderDividersEnabled(false);
        this.bKH.setFooterDividersEnabled(false);
        this.bKH.setSelector(d.g.list_selector_transparent);
        this.bKH.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.f.ds4), 0);
        this.bKI = new g(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.j.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.bKu = new com.baidu.tieba.horizonalList.widget.c(getContext(), d.j.card_homepage_rec_god_item, this.bKI);
        this.bKu.setOnClickListener(this.ajF);
        this.bKH.setAdapter((ListAdapter) this.bKu);
        this.bKe.addView(this.bKH);
        this.bKd.setVisibility(8);
        this.bJX.setTextSize(0, com.baidu.adp.lib.util.k.f(this.aby.getPageActivity(), d.f.ds28));
        this.bJY.setVisibility(0);
        this.bJY.setText(this.aby.getResources().getString(d.l.recommend_frs_hot_thread_more));
        this.bJW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    f.this.aby.showToast(d.l.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GodSquareActivityConfig(f.this.aby.getPageActivity())));
                }
            }
        });
        this.bKI.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.bKH != null && this.bKu != null) {
            aj.i(this.bJY, d.e.cp_cont_d);
            aj.i(this.bJX, d.e.cp_cont_d);
            this.bKu.dj(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((f) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.v(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.bJX.setText(this.aby.getPageActivity().getResources().getString(d.l.the_gods_you_may_interest_in));
            }
            if (ai(hVar.getDataList())) {
                this.bKJ = hVar.getDataList();
                this.bKu.setData(this.bKJ);
                this.bKu.notifyDataSetChanged();
            }
        }
    }

    private boolean ai(List<com.baidu.tieba.horizonalList.widget.d> list) {
        if (com.baidu.tbadk.core.util.v.v(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.v(this.bKJ) && com.baidu.tbadk.core.util.v.u(this.bKJ) == com.baidu.tbadk.core.util.v.u(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.u(this.bKJ); i++) {
                com.baidu.tieba.horizonalList.widget.d dVar = (com.baidu.tieba.horizonalList.widget.d) com.baidu.tbadk.core.util.v.c(this.bKJ, i);
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
