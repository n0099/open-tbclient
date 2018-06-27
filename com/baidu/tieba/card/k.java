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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends b<com.baidu.tieba.card.data.h> {
    private View.OnClickListener aua;
    private com.baidu.tieba.horizonalList.widget.b cvB;
    private HListView cvK;
    public l cvL;
    private List<com.baidu.tieba.horizonalList.widget.c> cvM;
    private TbPageContext<?> mContext;

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aua = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.aia() != null) {
                    k.this.aia().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.cvK = new HListView(getContext());
        this.cvK.setHeaderDividersEnabled(false);
        this.cvK.setFooterDividersEnabled(false);
        this.cvK.setSelector(d.f.list_selector_transparent);
        this.cvK.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.cvL = new l(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cvB = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.card_homepage_rec_god_item, this.cvL);
        this.cvB.setOnClickListener(this.aua);
        this.cvK.setAdapter((ListAdapter) this.cvB);
        this.ctP.addView(this.cvK);
        this.ctO.setVisibility(8);
        this.ctI.setTextSize(0, com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.ds28));
        this.ctJ.setVisibility(0);
        this.ctJ.setText(this.mContext.getResources().getString(d.k.recommend_frs_hot_thread_more));
        this.ctH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    k.this.mContext.showToast(d.k.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(k.this.mContext.getPageActivity())));
                }
            }
        });
        this.cvL.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cvK != null && this.cvB != null) {
            am.h(this.ctJ, d.C0142d.cp_cont_d);
            am.h(this.ctI, d.C0142d.cp_cont_d);
            this.cvB.dl(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((k) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.w.A(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.ctI.setText(this.mContext.getPageActivity().getResources().getString(d.k.the_gods_you_may_interest_in));
            }
            if (aJ(hVar.getDataList())) {
                this.cvM = hVar.getDataList();
                this.cvB.setData(this.cvM);
                this.cvB.notifyDataSetChanged();
            }
        }
    }

    private boolean aJ(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.w.A(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.w.A(this.cvM) && com.baidu.tbadk.core.util.w.z(this.cvM) == com.baidu.tbadk.core.util.w.z(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.w.z(this.cvM); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.d(this.cvM, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.d(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.aiE != null && !StringUtils.isNull(iVar.aiE.getUserId()) && iVar2.aiE != null && !StringUtils.isNull(iVar2.aiE.getUserId()) && !iVar.aiE.getUserId().equals(iVar2.aiE.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
