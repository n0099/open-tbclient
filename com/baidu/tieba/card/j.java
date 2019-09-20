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
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends b<com.baidu.tieba.card.data.h> {
    private View.OnClickListener bXj;
    private List<com.baidu.tieba.horizonalList.widget.c> bse;
    private HListView eDH;
    public k eDI;
    private com.baidu.tieba.horizonalList.widget.b eDy;
    private TbPageContext<?> mContext;

    public j(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bXj = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aZU() != null) {
                    j.this.aZU().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.eDH = new HListView(getContext());
        this.eDH.setHeaderDividersEnabled(false);
        this.eDH.setFooterDividersEnabled(false);
        this.eDH.setSelector(R.drawable.list_selector_transparent);
        this.eDH.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        this.eDI = new k(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.eDy = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.card_homepage_rec_god_item, this.eDI);
        this.eDy.setOnClickListener(this.bXj);
        this.eDH.setAdapter((ListAdapter) this.eDy);
        this.eBS.addView(this.eDH);
        this.eBR.setVisibility(8);
        this.eBL.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds28));
        this.eBM.setVisibility(0);
        this.eBM.setText(this.mContext.getResources().getString(R.string.recommend_frs_hot_thread_more));
        this.eBK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    j.this.mContext.showToast(R.string.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(j.this.mContext.getPageActivity())));
                }
            }
        });
        this.eDI.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eDH != null && this.eDy != null) {
            am.j(this.eBM, R.color.cp_cont_d);
            am.j(this.eBL, R.color.cp_cont_d);
            this.eDy.iJ(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((j) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.aa(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.eBL.setText(this.mContext.getPageActivity().getResources().getString(R.string.the_gods_you_may_interest_in));
            }
            if (bx(hVar.getDataList())) {
                this.bse = hVar.getDataList();
                this.eDy.setData(this.bse);
                this.eDy.notifyDataSetChanged();
            }
        }
    }

    private boolean bx(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.bse) && com.baidu.tbadk.core.util.v.Z(this.bse) == com.baidu.tbadk.core.util.v.Z(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.Z(this.bse); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(this.bse, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.bKE != null && !StringUtils.isNull(iVar.bKE.getUserId()) && iVar2.bKE != null && !StringUtils.isNull(iVar2.bKE.getUserId()) && !iVar.bKE.getUserId().equals(iVar2.bKE.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
