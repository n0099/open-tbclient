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
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends b<com.baidu.tieba.card.data.h> {
    private View.OnClickListener avZ;
    private com.baidu.tieba.horizonalList.widget.b cDQ;
    private HListView cDZ;
    public l cEa;
    private List<com.baidu.tieba.horizonalList.widget.c> cEb;
    private TbPageContext<?> mContext;

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.avZ = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.akm() != null) {
                    k.this.akm().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.cDZ = new HListView(getContext());
        this.cDZ.setHeaderDividersEnabled(false);
        this.cDZ.setFooterDividersEnabled(false);
        this.cDZ.setSelector(e.f.list_selector_transparent);
        this.cDZ.setPadding(tbPageContext.getResources().getDimensionPixelSize(e.C0141e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(e.C0141e.ds4), 0);
        this.cEa = new l(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cDQ = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.card_homepage_rec_god_item, this.cEa);
        this.cDQ.setOnClickListener(this.avZ);
        this.cDZ.setAdapter((ListAdapter) this.cDQ);
        this.cCf.addView(this.cDZ);
        this.cCe.setVisibility(8);
        this.cBY.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0141e.ds28));
        this.cBZ.setVisibility(0);
        this.cBZ.setText(this.mContext.getResources().getString(e.j.recommend_frs_hot_thread_more));
        this.cBX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    k.this.mContext.showToast(e.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(k.this.mContext.getPageActivity())));
                }
            }
        });
        this.cEa.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cDZ != null && this.cDQ != null) {
            al.h(this.cBZ, e.d.cp_cont_d);
            al.h(this.cBY, e.d.cp_cont_d);
            this.cDQ.dx(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((k) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.z(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cBY.setText(this.mContext.getPageActivity().getResources().getString(e.j.the_gods_you_may_interest_in));
            }
            if (aJ(hVar.getDataList())) {
                this.cEb = hVar.getDataList();
                this.cDQ.setData(this.cEb);
                this.cDQ.notifyDataSetChanged();
            }
        }
    }

    private boolean aJ(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.z(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.z(this.cEb) && com.baidu.tbadk.core.util.v.y(this.cEb) == com.baidu.tbadk.core.util.v.y(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.y(this.cEb); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.d(this.cEb, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.d(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.akB != null && !StringUtils.isNull(iVar.akB.getUserId()) && iVar2.akB != null && !StringUtils.isNull(iVar2.akB.getUserId()) && !iVar.akB.getUserId().equals(iVar2.akB.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
