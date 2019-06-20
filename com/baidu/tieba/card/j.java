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
    private View.OnClickListener bVj;
    private List<com.baidu.tieba.horizonalList.widget.c> bqT;
    private com.baidu.tieba.horizonalList.widget.b ewJ;
    private HListView ewS;
    public k ewT;
    private TbPageContext<?> mContext;

    public j(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bVj = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aXr() != null) {
                    j.this.aXr().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ewS = new HListView(getContext());
        this.ewS.setHeaderDividersEnabled(false);
        this.ewS.setFooterDividersEnabled(false);
        this.ewS.setSelector(R.drawable.list_selector_transparent);
        this.ewS.setPadding(tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds4), 0);
        this.ewT = new k(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.ewJ = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.card_homepage_rec_god_item, this.ewT);
        this.ewJ.setOnClickListener(this.bVj);
        this.ewS.setAdapter((ListAdapter) this.ewJ);
        this.evd.addView(this.ewS);
        this.evc.setVisibility(8);
        this.euW.setTextSize(0, com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.ds28));
        this.euX.setVisibility(0);
        this.euX.setText(this.mContext.getResources().getString(R.string.recommend_frs_hot_thread_more));
        this.euV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    j.this.mContext.showToast(R.string.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(j.this.mContext.getPageActivity())));
                }
            }
        });
        this.ewT.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.ewS != null && this.ewJ != null) {
            al.j(this.euX, R.color.cp_cont_d);
            al.j(this.euW, R.color.cp_cont_d);
            this.ewJ.iA(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((j) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.aa(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.euW.setText(this.mContext.getPageActivity().getResources().getString(R.string.the_gods_you_may_interest_in));
            }
            if (bv(hVar.getDataList())) {
                this.bqT = hVar.getDataList();
                this.ewJ.setData(this.bqT);
                this.ewJ.notifyDataSetChanged();
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
                    if (iVar.bJb != null && !StringUtils.isNull(iVar.bJb.getUserId()) && iVar2.bJb != null && !StringUtils.isNull(iVar2.bJb.getUserId()) && !iVar.bJb.getUserId().equals(iVar2.bJb.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
