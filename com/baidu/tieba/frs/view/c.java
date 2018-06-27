package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<s> {
    private View.OnClickListener aua;
    private com.baidu.tieba.horizonalList.widget.b cvB;
    private HListView cvK;
    private List<com.baidu.tieba.horizonalList.widget.c> cvM;
    public t dHA;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aua = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aia() != null) {
                    c.this.aia().a(view, null);
                }
            }
        };
        this.cvK = new HListView(getContext());
        this.cvK.setHeaderDividersEnabled(false);
        this.cvK.setFooterDividersEnabled(false);
        this.cvK.setSelector(d.f.list_selector_transparent);
        this.dHA = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cvB = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.frs_school_recommend_user, this.dHA);
        this.cvB.setOnClickListener(this.aua);
        this.cvK.setAdapter((ListAdapter) this.cvB);
        this.ctP.addView(this.cvK);
        this.ctO.setVisibility(8);
        this.ctI.setTextSize(0, l.e(tbPageContext.getPageActivity(), d.e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cvK != null && this.cvB != null) {
            am.h(this.ctI, d.C0142d.cp_cont_d);
            this.cvB.dl(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((c) sVar);
        if (sVar != null && !w.A(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.ctI.setText(getContext().getResources().getString(d.k.school_recommend));
            } else {
                this.ctI.setText(sVar.mGroupTitle);
            }
            if (aJ(sVar.getDataList())) {
                this.cvM = sVar.getDataList();
                this.cvB.setData(this.cvM);
                this.cvB.notifyDataSetChanged();
            }
        }
    }

    private boolean aJ(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (w.A(list)) {
            return false;
        }
        if (!w.A(this.cvM) && w.z(this.cvM) == w.z(list)) {
            for (int i = 0; i < w.z(this.cvM); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) w.d(this.cvM, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) w.d(list, i);
                if ((cVar instanceof ap) && (cVar2 instanceof ap) && !((ap) cVar).metaData.getUserId().equals(((ap) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
