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
    private View.OnClickListener bWq;
    private List<com.baidu.tieba.horizonalList.widget.c> brG;
    private com.baidu.tieba.horizonalList.widget.b eBP;
    private HListView eBY;
    public k eBZ;
    private TbPageContext<?> mContext;

    public j(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bWq = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aZq() != null) {
                    j.this.aZq().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.eBY = new HListView(getContext());
        this.eBY.setHeaderDividersEnabled(false);
        this.eBY.setFooterDividersEnabled(false);
        this.eBY.setSelector(R.drawable.list_selector_transparent);
        this.eBY.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        this.eBZ = new k(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.eBP = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.card_homepage_rec_god_item, this.eBZ);
        this.eBP.setOnClickListener(this.bWq);
        this.eBY.setAdapter((ListAdapter) this.eBP);
        this.eAj.addView(this.eBY);
        this.eAi.setVisibility(8);
        this.eAc.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds28));
        this.eAd.setVisibility(0);
        this.eAd.setText(this.mContext.getResources().getString(R.string.recommend_frs_hot_thread_more));
        this.eAb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    j.this.mContext.showToast(R.string.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(j.this.mContext.getPageActivity())));
                }
            }
        });
        this.eBZ.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.eBY != null && this.eBP != null) {
            am.j(this.eAd, R.color.cp_cont_d);
            am.j(this.eAc, R.color.cp_cont_d);
            this.eBP.iG(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((j) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.aa(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.eAc.setText(this.mContext.getPageActivity().getResources().getString(R.string.the_gods_you_may_interest_in));
            }
            if (bx(hVar.getDataList())) {
                this.brG = hVar.getDataList();
                this.eBP.setData(this.brG);
                this.eBP.notifyDataSetChanged();
            }
        }
    }

    private boolean bx(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.brG) && com.baidu.tbadk.core.util.v.Z(this.brG) == com.baidu.tbadk.core.util.v.Z(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.Z(this.brG); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(this.brG, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.bKg != null && !StringUtils.isNull(iVar.bKg.getUserId()) && iVar2.bKg != null && !StringUtils.isNull(iVar2.bKg.getUserId()) && !iVar.bKg.getUserId().equals(iVar2.bKg.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
