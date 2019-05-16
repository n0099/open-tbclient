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
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends b<com.baidu.tieba.card.data.h> {
    private View.OnClickListener bVi;
    private List<com.baidu.tieba.horizonalList.widget.c> bqT;
    private com.baidu.tieba.horizonalList.widget.b ewI;
    private HListView ewR;
    public k ewS;
    private TbPageContext<?> mContext;

    public j(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bVi = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aXo() != null) {
                    j.this.aXo().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ewR = new HListView(getContext());
        this.ewR.setHeaderDividersEnabled(false);
        this.ewR.setFooterDividersEnabled(false);
        this.ewR.setSelector(R.drawable.list_selector_transparent);
        this.ewR.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        this.ewS = new k(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.ewI = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.card_homepage_rec_god_item, this.ewS);
        this.ewI.setOnClickListener(this.bVi);
        this.ewR.setAdapter((ListAdapter) this.ewI);
        this.evc.addView(this.ewR);
        this.evb.setVisibility(8);
        this.euV.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds28));
        this.euW.setVisibility(0);
        this.euW.setText(this.mContext.getResources().getString(R.string.recommend_frs_hot_thread_more));
        this.euU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    j.this.mContext.showToast(R.string.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(j.this.mContext.getPageActivity())));
                }
            }
        });
        this.ewS.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.ewR != null && this.ewI != null) {
            al.j(this.euW, R.color.cp_cont_d);
            al.j(this.euV, R.color.cp_cont_d);
            this.ewI.iA(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((j) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.aa(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.euV.setText(this.mContext.getPageActivity().getResources().getString(R.string.the_gods_you_may_interest_in));
            }
            if (bv(hVar.getDataList())) {
                this.bqT = hVar.getDataList();
                this.ewI.setData(this.bqT);
                this.ewI.notifyDataSetChanged();
            }
        }
    }

    private boolean bv(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.bqT) && com.baidu.tbadk.core.util.v.Z(this.bqT) == com.baidu.tbadk.core.util.v.Z(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.Z(this.bqT); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(this.bqT, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.bJa != null && !StringUtils.isNull(iVar.bJa.getUserId()) && iVar2.bJa != null && !StringUtils.isNull(iVar2.bJa.getUserId()) && !iVar.bJa.getUserId().equals(iVar2.bJa.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
