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
    private View.OnClickListener aBz;
    private HListView cNA;
    private com.baidu.tieba.horizonalList.widget.b cNr;
    public t eaK;
    private List<com.baidu.tieba.horizonalList.widget.c> mItemList;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aBz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.anq() != null) {
                    c.this.anq().a(view, null);
                }
            }
        };
        this.cNA = new HListView(getContext());
        this.cNA.setHeaderDividersEnabled(false);
        this.cNA.setFooterDividersEnabled(false);
        this.cNA.setSelector(e.f.list_selector_transparent);
        this.eaK = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cNr = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.frs_school_recommend_user, this.eaK);
        this.cNr.setOnClickListener(this.aBz);
        this.cNA.setAdapter((ListAdapter) this.cNr);
        this.cLG.addView(this.cNA);
        this.cLF.setVisibility(8);
        this.cLz.setTextSize(0, l.h(tbPageContext.getPageActivity(), e.C0200e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cNA != null && this.cNr != null) {
            al.h(this.cLz, e.d.cp_cont_d);
            this.cNr.dV(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((c) sVar);
        if (sVar != null && !v.I(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.cLz.setText(getContext().getResources().getString(e.j.school_recommend));
            } else {
                this.cLz.setText(sVar.mGroupTitle);
            }
            if (aX(sVar.getDataList())) {
                this.mItemList = sVar.getDataList();
                this.cNr.setData(this.mItemList);
                this.cNr.notifyDataSetChanged();
            }
        }
    }

    private boolean aX(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.I(list)) {
            return false;
        }
        if (!v.I(this.mItemList) && v.H(this.mItemList) == v.H(list)) {
            for (int i = 0; i < v.H(this.mItemList); i++) {
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
