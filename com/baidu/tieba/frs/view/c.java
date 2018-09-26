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
    private View.OnClickListener avZ;
    private com.baidu.tieba.horizonalList.widget.b cDQ;
    private HListView cDZ;
    private List<com.baidu.tieba.horizonalList.widget.c> cEb;
    public t dRv;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.avZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akm() != null) {
                    c.this.akm().a(view, null);
                }
            }
        };
        this.cDZ = new HListView(getContext());
        this.cDZ.setHeaderDividersEnabled(false);
        this.cDZ.setFooterDividersEnabled(false);
        this.cDZ.setSelector(e.f.list_selector_transparent);
        this.dRv = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cDQ = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.frs_school_recommend_user, this.dRv);
        this.cDQ.setOnClickListener(this.avZ);
        this.cDZ.setAdapter((ListAdapter) this.cDQ);
        this.cCf.addView(this.cDZ);
        this.cCe.setVisibility(8);
        this.cBY.setTextSize(0, l.h(tbPageContext.getPageActivity(), e.C0141e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cDZ != null && this.cDQ != null) {
            al.h(this.cBY, e.d.cp_cont_d);
            this.cDQ.dx(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((c) sVar);
        if (sVar != null && !v.z(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.cBY.setText(getContext().getResources().getString(e.j.school_recommend));
            } else {
                this.cBY.setText(sVar.mGroupTitle);
            }
            if (aJ(sVar.getDataList())) {
                this.cEb = sVar.getDataList();
                this.cDQ.setData(this.cEb);
                this.cDQ.notifyDataSetChanged();
            }
        }
    }

    private boolean aJ(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.z(list)) {
            return false;
        }
        if (!v.z(this.cEb) && v.y(this.cEb) == v.y(list)) {
            for (int i = 0; i < v.y(this.cEb); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.d(this.cEb, i);
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
