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
/* loaded from: classes3.dex */
public class j extends b<com.baidu.tieba.card.data.h> {
    private View.OnClickListener bNx;
    private List<com.baidu.tieba.horizonalList.widget.c> bkR;
    private com.baidu.tieba.horizonalList.widget.b egV;
    private HListView ehe;
    public k ehf;
    private TbPageContext<?> mContext;

    public j(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.bNx = new View.OnClickListener() { // from class: com.baidu.tieba.card.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.aQf() != null) {
                    j.this.aQf().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ehe = new HListView(getContext());
        this.ehe.setHeaderDividersEnabled(false);
        this.ehe.setFooterDividersEnabled(false);
        this.ehe.setSelector(d.f.list_selector_transparent);
        this.ehe.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.ehf = new k(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.egV = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.card_homepage_rec_god_item, this.ehf);
        this.egV.setOnClickListener(this.bNx);
        this.ehe.setAdapter((ListAdapter) this.egV);
        this.efp.addView(this.ehe);
        this.efo.setVisibility(8);
        this.efi.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.ds28));
        this.efj.setVisibility(0);
        this.efj.setText(this.mContext.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.efh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.j.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    j.this.mContext.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(j.this.mContext.getPageActivity())));
                }
            }
        });
        this.ehf.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.ehe != null && this.egV != null) {
            al.j(this.efj, d.C0277d.cp_cont_d);
            al.j(this.efi, d.C0277d.cp_cont_d);
            this.egV.hM(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((j) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.T(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.efi.setText(this.mContext.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (bn(hVar.getDataList())) {
                this.bkR = hVar.getDataList();
                this.egV.setData(this.bkR);
                this.egV.notifyDataSetChanged();
            }
        }
    }

    private boolean bn(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.T(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.T(this.bkR) && com.baidu.tbadk.core.util.v.S(this.bkR) == com.baidu.tbadk.core.util.v.S(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.S(this.bkR); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(this.bkR, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.bBK != null && !StringUtils.isNull(iVar.bBK.getUserId()) && iVar2.bBK != null && !StringUtils.isNull(iVar2.bBK.getUserId()) && !iVar.bBK.getUserId().equals(iVar2.bBK.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
