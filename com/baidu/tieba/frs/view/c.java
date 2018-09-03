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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<s> {
    private View.OnClickListener atF;
    private com.baidu.tieba.horizonalList.widget.b cya;
    private HListView cyj;
    private List<com.baidu.tieba.horizonalList.widget.c> cyl;
    public t dKl;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.atF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.aiC() != null) {
                    c.this.aiC().a(view, null);
                }
            }
        };
        this.cyj = new HListView(getContext());
        this.cyj.setHeaderDividersEnabled(false);
        this.cyj.setFooterDividersEnabled(false);
        this.cyj.setSelector(f.C0146f.list_selector_transparent);
        this.dKl = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(f.h.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cya = new com.baidu.tieba.horizonalList.widget.b(getContext(), f.h.frs_school_recommend_user, this.dKl);
        this.cya.setOnClickListener(this.atF);
        this.cyj.setAdapter((ListAdapter) this.cya);
        this.cwp.addView(this.cyj);
        this.cwo.setVisibility(8);
        this.cwi.setTextSize(0, l.f(tbPageContext.getPageActivity(), f.e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cyj != null && this.cya != null) {
            am.h(this.cwi, f.d.cp_cont_d);
            this.cya.dm(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((c) sVar);
        if (sVar != null && !w.z(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.cwi.setText(getContext().getResources().getString(f.j.school_recommend));
            } else {
                this.cwi.setText(sVar.mGroupTitle);
            }
            if (aI(sVar.getDataList())) {
                this.cyl = sVar.getDataList();
                this.cya.setData(this.cyl);
                this.cya.notifyDataSetChanged();
            }
        }
    }

    private boolean aI(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (w.z(list)) {
            return false;
        }
        if (!w.z(this.cyl) && w.y(this.cyl) == w.y(list)) {
            for (int i = 0; i < w.y(this.cyl); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) w.d(this.cyl, i);
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
