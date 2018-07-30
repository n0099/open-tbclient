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
    private View.OnClickListener atE;
    private com.baidu.tieba.horizonalList.widget.b cyd;
    private HListView cym;
    private List<com.baidu.tieba.horizonalList.widget.c> cyo;
    public t dKp;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.atE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiz() != null) {
                    c.this.aiz().a(view, null);
                }
            }
        };
        this.cym = new HListView(getContext());
        this.cym.setHeaderDividersEnabled(false);
        this.cym.setFooterDividersEnabled(false);
        this.cym.setSelector(d.f.list_selector_transparent);
        this.dKp = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cyd = new com.baidu.tieba.horizonalList.widget.b(getContext(), d.h.frs_school_recommend_user, this.dKp);
        this.cyd.setOnClickListener(this.atE);
        this.cym.setAdapter((ListAdapter) this.cyd);
        this.cws.addView(this.cym);
        this.cwr.setVisibility(8);
        this.cwl.setTextSize(0, l.f(tbPageContext.getPageActivity(), d.e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cym != null && this.cyd != null) {
            am.h(this.cwl, d.C0140d.cp_cont_d);
            this.cyd.dn(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((c) sVar);
        if (sVar != null && !w.z(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.cwl.setText(getContext().getResources().getString(d.j.school_recommend));
            } else {
                this.cwl.setText(sVar.mGroupTitle);
            }
            if (aI(sVar.getDataList())) {
                this.cyo = sVar.getDataList();
                this.cyd.setData(this.cyo);
                this.cyd.notifyDataSetChanged();
            }
        }
    }

    private boolean aI(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (w.z(list)) {
            return false;
        }
        if (!w.z(this.cyo) && w.y(this.cyo) == w.y(list)) {
            for (int i = 0; i < w.y(this.cyo); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) w.d(this.cyo, i);
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
