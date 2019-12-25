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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.b<t> {
    private View.OnClickListener Mz;
    private com.baidu.tieba.horizonalList.widget.b fDl;
    private HListView gLq;
    public u gLr;
    private List<com.baidu.tieba.horizonalList.widget.c> gLs;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.Mz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.brY() != null) {
                    d.this.brY().a(view, null);
                }
            }
        };
        this.gLq = new HListView(getContext());
        this.gLq.setHeaderDividersEnabled(false);
        this.gLq.setFooterDividersEnabled(false);
        this.gLq.setSelector(R.drawable.list_selector_transparent);
        this.gLr = new u(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.fDl = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.gLr);
        this.fDl.setOnClickListener(this.Mz);
        this.gLq.setAdapter((ListAdapter) this.fDl);
        this.fBG.addView(this.gLq);
        this.fBF.setVisibility(8);
        this.fBz.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.gLq != null && this.fDl != null) {
            am.setViewTextColor(this.fBz, (int) R.color.cp_cont_d);
            this.fDl.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(t tVar) {
        super.a((d) tVar);
        if (tVar != null && !v.isEmpty(tVar.getDataList())) {
            if (StringUtils.isNull(tVar.mGroupTitle)) {
                this.fBz.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.fBz.setText(tVar.mGroupTitle);
            }
            if (cy(tVar.getDataList())) {
                this.gLs = tVar.getDataList();
                this.fDl.setData(this.gLs);
                this.fDl.notifyDataSetChanged();
            }
        }
    }

    private boolean cy(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        if (!v.isEmpty(this.gLs) && v.getCount(this.gLs) == v.getCount(list)) {
            for (int i = 0; i < v.getCount(this.gLs); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.getItem(this.gLs, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) v.getItem(list, i);
                if ((cVar instanceof ao) && (cVar2 instanceof ao) && !((ao) cVar).metaData.getUserId().equals(((ao) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
