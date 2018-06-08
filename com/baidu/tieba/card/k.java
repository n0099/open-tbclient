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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends b<com.baidu.tieba.card.data.h> {
    private View.OnClickListener ato;
    private HListView cxD;
    public l cxE;
    private List<com.baidu.tieba.horizonalList.widget.c> cxF;
    private com.baidu.tieba.horizonalList.widget.b cxu;
    private TbPageContext<?> mContext;

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ato = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.aiI() != null) {
                    k.this.aiI().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.cxD = new HListView(getContext());
        this.cxD.setHeaderDividersEnabled(false);
        this.cxD.setFooterDividersEnabled(false);
        this.cxD.setSelector(d.f.list_selector_transparent);
        this.cxD.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.cxE = new l(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cxu = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.card_homepage_rec_god_item, this.cxE);
        this.cxu.setOnClickListener(this.ato);
        this.cxD.setAdapter((ListAdapter) this.cxu);
        this.cvJ.addView(this.cxD);
        this.cvI.setVisibility(8);
        this.cvC.setTextSize(0, com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.ds28));
        this.cvD.setVisibility(0);
        this.cvD.setText(this.mContext.getResources().getString(d.k.recommend_frs_hot_thread_more));
        this.cvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    k.this.mContext.showToast(d.k.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(k.this.mContext.getPageActivity())));
                }
            }
        });
        this.cxE.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cxD != null && this.cxu != null) {
            al.h(this.cvD, d.C0141d.cp_cont_d);
            al.h(this.cvC, d.C0141d.cp_cont_d);
            this.cxu.dk(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((k) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.w.z(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cvC.setText(this.mContext.getPageActivity().getResources().getString(d.k.the_gods_you_may_interest_in));
            }
            if (aI(hVar.getDataList())) {
                this.cxF = hVar.getDataList();
                this.cxu.setData(this.cxF);
                this.cxu.notifyDataSetChanged();
            }
        }
    }

    private boolean aI(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.w.z(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.w.z(this.cxF) && com.baidu.tbadk.core.util.w.y(this.cxF) == com.baidu.tbadk.core.util.w.y(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.w.y(this.cxF); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.c(this.cxF, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.c(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.aik != null && !StringUtils.isNull(iVar.aik.getUserId()) && iVar2.aik != null && !StringUtils.isNull(iVar2.aik.getUserId()) && !iVar.aik.getUserId().equals(iVar2.aik.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
