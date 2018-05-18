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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends b<com.baidu.tieba.card.data.h> {
    private View.OnClickListener alg;
    private com.baidu.tieba.horizonalList.widget.b coQ;
    private HListView coZ;
    public l cpa;
    private List<com.baidu.tieba.horizonalList.widget.c> cpb;
    private TbPageContext<?> mContext;

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.alg = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.aeZ() != null) {
                    k.this.aeZ().a(view2, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.coZ = new HListView(getContext());
        this.coZ.setHeaderDividersEnabled(false);
        this.coZ.setFooterDividersEnabled(false);
        this.coZ.setSelector(d.f.list_selector_transparent);
        this.coZ.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.cpa = new l(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.coQ = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.card_homepage_rec_god_item, this.cpa);
        this.coQ.setOnClickListener(this.alg);
        this.coZ.setAdapter((ListAdapter) this.coQ);
        this.cne.addView(this.coZ);
        this.cnd.setVisibility(8);
        this.cmX.setTextSize(0, com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.ds28));
        this.cmY.setVisibility(0);
        this.cmY.setText(this.mContext.getResources().getString(d.k.recommend_frs_hot_thread_more));
        this.cmW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    k.this.mContext.showToast(d.k.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(k.this.mContext.getPageActivity())));
                }
            }
        });
        this.cpa.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.coZ != null && this.coQ != null) {
            ak.h(this.cmY, d.C0126d.cp_cont_d);
            ak.h(this.cmX, d.C0126d.cp_cont_d);
            this.coQ.di(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((k) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.w(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cmX.setText(this.mContext.getPageActivity().getResources().getString(d.k.the_gods_you_may_interest_in));
            }
            if (aF(hVar.getDataList())) {
                this.cpb = hVar.getDataList();
                this.coQ.setData(this.cpb);
                this.coQ.notifyDataSetChanged();
            }
        }
    }

    private boolean aF(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.w(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.w(this.cpb) && com.baidu.tbadk.core.util.v.v(this.cpb) == com.baidu.tbadk.core.util.v.v(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.v(this.cpb); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(this.cpb, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.aaf != null && !StringUtils.isNull(iVar.aaf.getUserId()) && iVar2.aaf != null && !StringUtils.isNull(iVar2.aaf.getUserId()) && !iVar.aaf.getUserId().equals(iVar2.aaf.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
