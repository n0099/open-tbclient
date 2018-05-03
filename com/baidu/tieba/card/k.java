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
    private TbPageContext<?> adf;
    private View.OnClickListener alg;
    private com.baidu.tieba.horizonalList.widget.b cnH;
    private HListView cnQ;
    public l cnR;
    private List<com.baidu.tieba.horizonalList.widget.c> cnS;

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
        this.adf = tbPageContext;
        this.cnQ = new HListView(getContext());
        this.cnQ.setHeaderDividersEnabled(false);
        this.cnQ.setFooterDividersEnabled(false);
        this.cnQ.setSelector(d.f.list_selector_transparent);
        this.cnQ.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.cnR = new l(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cnH = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.card_homepage_rec_god_item, this.cnR);
        this.cnH.setOnClickListener(this.alg);
        this.cnQ.setAdapter((ListAdapter) this.cnH);
        this.clU.addView(this.cnQ);
        this.clT.setVisibility(8);
        this.clN.setTextSize(0, com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.ds28));
        this.clO.setVisibility(0);
        this.clO.setText(this.adf.getResources().getString(d.k.recommend_frs_hot_thread_more));
        this.clM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    k.this.adf.showToast(d.k.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(k.this.adf.getPageActivity())));
                }
            }
        });
        this.cnR.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cnQ != null && this.cnH != null) {
            ak.h(this.clO, d.C0126d.cp_cont_d);
            ak.h(this.clN, d.C0126d.cp_cont_d);
            this.cnH.dh(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((k) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.v.w(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.clN.setText(this.adf.getPageActivity().getResources().getString(d.k.the_gods_you_may_interest_in));
            }
            if (aC(hVar.getDataList())) {
                this.cnS = hVar.getDataList();
                this.cnH.setData(this.cnS);
                this.cnH.notifyDataSetChanged();
            }
        }
    }

    private boolean aC(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.v.w(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.v.w(this.cnS) && com.baidu.tbadk.core.util.v.v(this.cnS) == com.baidu.tbadk.core.util.v.v(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.v.v(this.cnS); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(this.cnS, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.v.c(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.aae != null && !StringUtils.isNull(iVar.aae.getUserId()) && iVar2.aae != null && !StringUtils.isNull(iVar2.aae.getUserId()) && !iVar.aae.getUserId().equals(iVar2.aae.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
