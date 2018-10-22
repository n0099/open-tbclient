package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<s> {
    private View.OnClickListener aAK;
    private com.baidu.tieba.horizonalList.widget.b cMl;
    private HListView cMu;
    public t dZr;
    private List<com.baidu.tieba.horizonalList.widget.c> mItemList;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aAK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anP() != null) {
                    c.this.anP().a(view, null);
                }
            }
        };
        this.cMu = new HListView(getContext());
        this.cMu.setHeaderDividersEnabled(false);
        this.cMu.setFooterDividersEnabled(false);
        this.cMu.setSelector(e.f.list_selector_transparent);
        this.dZr = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cMl = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.frs_school_recommend_user, this.dZr);
        this.cMl.setOnClickListener(this.aAK);
        this.cMu.setAdapter((ListAdapter) this.cMl);
        this.cKA.addView(this.cMu);
        this.cKz.setVisibility(8);
        this.cKt.setTextSize(0, l.h(tbPageContext.getPageActivity(), e.C0175e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cMu != null && this.cMl != null) {
            al.h(this.cKt, e.d.cp_cont_d);
            this.cMl.dH(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((c) sVar);
        if (sVar != null && !v.J(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.cKt.setText(getContext().getResources().getString(e.j.school_recommend));
            } else {
                this.cKt.setText(sVar.mGroupTitle);
            }
            if (aZ(sVar.getDataList())) {
                this.mItemList = sVar.getDataList();
                this.cMl.setData(this.mItemList);
                this.cMl.notifyDataSetChanged();
            }
        }
    }

    private boolean aZ(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.J(list)) {
            return false;
        }
        if (!v.J(this.mItemList) && v.I(this.mItemList) == v.I(list)) {
            for (int i = 0; i < v.I(this.mItemList); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.d(this.mItemList, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) v.d(list, i);
                if ((cVar instanceof ap) && (cVar2 instanceof ap) && !((ap) cVar).metaData.getUserId().equals(((ap) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
