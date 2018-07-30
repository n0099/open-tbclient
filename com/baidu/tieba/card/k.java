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
    private View.OnClickListener atE;
    private com.baidu.tieba.horizonalList.widget.b cyd;
    private HListView cym;
    public l cyn;
    private List<com.baidu.tieba.horizonalList.widget.c> cyo;
    private TbPageContext<?> mContext;

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.atE = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.aiz() != null) {
                    k.this.aiz().a(view, null);
                }
            }
        };
        this.mContext = tbPageContext;
        this.cym = new HListView(getContext());
        this.cym.setHeaderDividersEnabled(false);
        this.cym.setFooterDividersEnabled(false);
        this.cym.setSelector(d.f.list_selector_transparent);
        this.cym.setPadding(tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds4), 0);
        this.cyn = new l(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.card_homepage_rec_god_item, (ViewGroup) null), tbPageContext);
        this.cyd = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.card_homepage_rec_god_item, this.cyn);
        this.cyd.setOnClickListener(this.atE);
        this.cym.setAdapter((ListAdapter) this.cyd);
        this.cws.addView(this.cym);
        this.cwr.setVisibility(8);
        this.cwl.setTextSize(0, com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), d.e.ds28));
        this.cwm.setVisibility(0);
        this.cwm.setText(this.mContext.getResources().getString(d.j.recommend_frs_hot_thread_more));
        this.cwk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(GodSquareActivityConfig.class)) {
                    k.this.mContext.showToast(d.j.pluginstatus_tip_timeout_last);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GodSquareActivityConfig(k.this.mContext.getPageActivity())));
                }
            }
        });
        this.cyn.setUniqueId(bdUniqueId);
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cym != null && this.cyd != null) {
            am.h(this.cwm, d.C0140d.cp_cont_d);
            am.h(this.cwl, d.C0140d.cp_cont_d);
            this.cyd.dn(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.h hVar) {
        super.a((k) hVar);
        if (hVar != null && !com.baidu.tbadk.core.util.w.z(hVar.getDataList())) {
            if (StringUtils.isNull(hVar.mGroupTitle)) {
                this.cwl.setText(this.mContext.getPageActivity().getResources().getString(d.j.the_gods_you_may_interest_in));
            }
            if (aI(hVar.getDataList())) {
                this.cyo = hVar.getDataList();
                this.cyd.setData(this.cyo);
                this.cyd.notifyDataSetChanged();
            }
        }
    }

    private boolean aI(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (com.baidu.tbadk.core.util.w.z(list)) {
            return false;
        }
        if (!com.baidu.tbadk.core.util.w.z(this.cyo) && com.baidu.tbadk.core.util.w.y(this.cyo) == com.baidu.tbadk.core.util.w.y(list)) {
            for (int i = 0; i < com.baidu.tbadk.core.util.w.y(this.cyo); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) com.baidu.tbadk.core.util.w.d(this.cyo, i);
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
