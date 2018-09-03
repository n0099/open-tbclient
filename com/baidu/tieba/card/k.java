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
import com.baidu.tieba.f;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends b<com.baidu.tieba.card.data.h> {
    private View.OnClickListener atF;
    private com.baidu.tieba.horizonalList.widget.b cya;
    private HListView cyj;
    public l cyk;
    private List<com.baidu.tieba.horizonalList.widget.c> cyl;
    private TbPageContext<?> mContext;

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.atF = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.aiC() != null) {
                    k.this.aiC().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.cyj = new HListView(getContext());
        this.cyj.setHeaderDividersEnabled(false);
        this.cyj.setFooterDividersEnabled(false);
        this.cyj.setSelector(f.C0146f.list_selector_transparent);
        this.cyj.setPadding(tbPageContext.getResources().getDimensionPixelSize(f.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(f.e.ds4), 0);
        this.cyk = new l(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(f.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cya = new com.baidu.tieba.horizonalList.widget.b(getContext(), f.h.card_homepage_rec_god_item, this.cyk);
        this.cya.setOnClickListener(this.atF);
        this.cyj.setAdapter((ListAdapter) this.cya);
        this.cwp.addView(this.cyj);
        this.cwo.setVisibility(8);
        this.cwi.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), f.e.ds28));
        this.cwj.setVisibility(0);
        this.cwj.setText(this.mContext.getResources().getString(f.j.recommend_frs_hot_thread_more));
        this.cwh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    k.this.mContext.showToast(f.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(k.this.mContext.getPageActivity())));
                }
            }
        });
        this.cyk.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cyj != null && this.cya != null) {
            am.h(this.cwj, f.d.cp_cont_d);
            am.h(this.cwi, f.d.cp_cont_d);
            this.cya.dm(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((k) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.w.z(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cwi.setText(this.mContext.getPageActivity().getResources().getString(f.j.the_gods_you_may_interest_in));
            }
            if (aI(hVar.getDataList())) {
                this.cyl = hVar.getDataList();
                this.cya.setData(this.cyl);
                this.cya.notifyDataSetChanged();
            }
        }
    }

    private boolean aI(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.w.z(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.w.z(this.cyl) && com.baidu.tbadk.core.util.w.y(this.cyl) == com.baidu.tbadk.core.util.w.y(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.w.y(this.cyl); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.d(this.cyl, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.d(list, i);
                if ((cVar instanceof com.baidu.tieba.card.data.i) && (cVar2 instanceof com.baidu.tieba.card.data.i)) {
                    com.baidu.tieba.card.data.i iVar = (com.baidu.tieba.card.data.i) cVar;
                    com.baidu.tieba.card.data.i iVar2 = (com.baidu.tieba.card.data.i) cVar2;
                    if (iVar.aib != null && !StringUtils.isNull(iVar.aib.getUserId()) && iVar2.aib != null && !StringUtils.isNull(iVar2.aib.getUserId()) && !iVar.aib.getUserId().equals(iVar2.aib.getUserId())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
}
