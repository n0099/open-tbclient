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
    private View.OnClickListener aFa;
    private com.baidu.tieba.horizonalList.widget.b cWO;
    private HListView cWX;
    public t eke;
    private List<com.baidu.tieba.horizonalList.widget.c> mItemList;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aFa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apS() != null) {
                    c.this.apS().a(view, null);
                }
            }
        };
        this.cWX = new HListView(getContext());
        this.cWX.setHeaderDividersEnabled(false);
        this.cWX.setFooterDividersEnabled(false);
        this.cWX.setSelector(e.f.list_selector_transparent);
        this.eke = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cWO = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.frs_school_recommend_user, this.eke);
        this.cWO.setOnClickListener(this.aFa);
        this.cWX.setAdapter((ListAdapter) this.cWO);
        this.cVd.addView(this.cWX);
        this.cVc.setVisibility(8);
        this.cUW.setTextSize(0, l.h(tbPageContext.getPageActivity(), e.C0210e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cWX != null && this.cWO != null) {
            al.h(this.cUW, e.d.cp_cont_d);
            this.cWO.ej(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((c) sVar);
        if (sVar != null && !v.I(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.cUW.setText(getContext().getResources().getString(e.j.school_recommend));
            } else {
                this.cUW.setText(sVar.mGroupTitle);
            }
            if (ba(sVar.getDataList())) {
                this.mItemList = sVar.getDataList();
                this.cWO.setData(this.mItemList);
                this.cWO.notifyDataSetChanged();
            }
        }
    }

    private boolean ba(List<com.baidu.tieba.horizonalList.widget.c> list) {
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
