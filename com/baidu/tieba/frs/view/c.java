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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<q> {
    private View.OnClickListener ato;
    private HListView cxD;
    private List<com.baidu.tieba.horizonalList.widget.c> cxF;
    private com.baidu.tieba.horizonalList.widget.b cxu;
    public r dEf;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ato = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiI() != null) {
                    c.this.aiI().a(view, null);
                }
            }
        };
        this.cxD = new HListView(getContext());
        this.cxD.setHeaderDividersEnabled(false);
        this.cxD.setFooterDividersEnabled(false);
        this.cxD.setSelector(d.f.list_selector_transparent);
        this.dEf = new r(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.i.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cxu = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.i.frs_school_recommend_user, this.dEf);
        this.cxu.setOnClickListener(this.ato);
        this.cxD.setAdapter((ListAdapter) this.cxu);
        this.cvJ.addView(this.cxD);
        this.cvI.setVisibility(8);
        this.cvC.setTextSize(0, l.e(tbPageContext.getPageActivity(), d.e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cxD != null && this.cxu != null) {
            al.h(this.cvC, d.C0141d.cp_cont_d);
            this.cxu.dk(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(q qVar) {
        super.a((c) qVar);
        if (qVar != null && !w.z(qVar.getDataList())) {
            if (StringUtils.isNull(qVar.mGroupTitle)) {
                this.cvC.setText(getContext().getResources().getString(d.k.school_recommend));
            } else {
                this.cvC.setText(qVar.mGroupTitle);
            }
            if (aI(qVar.getDataList())) {
                this.cxF = qVar.getDataList();
                this.cxu.setData(this.cxF);
                this.cxu.notifyDataSetChanged();
            }
        }
    }

    private boolean aI(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (w.z(list)) {
            return false;
        }
        if (!w.z(this.cxF) && w.y(this.cxF) == w.y(list)) {
            for (int i = 0; i < w.y(this.cxF); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) w.c(this.cxF, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) w.c(list, i);
                if ((cVar instanceof an) && (cVar2 instanceof an) && !((an) cVar).metaData.getUserId().equals(((an) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
