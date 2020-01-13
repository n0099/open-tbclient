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
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.card.b<t> {
    private View.OnClickListener MG;
    private com.baidu.tieba.horizonalList.widget.b fGw;
    private HListView gOE;
    public u gOF;
    private List<com.baidu.tieba.horizonalList.widget.c> gOG;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.MG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bta() != null) {
                    d.this.bta().a(view, null);
                }
            }
        };
        this.gOE = new HListView(getContext());
        this.gOE.setHeaderDividersEnabled(false);
        this.gOE.setFooterDividersEnabled(false);
        this.gOE.setSelector(R.drawable.list_selector_transparent);
        this.gOF = new u(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.fGw = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.gOF);
        this.fGw.setOnClickListener(this.MG);
        this.gOE.setAdapter((ListAdapter) this.fGw);
        this.fER.addView(this.gOE);
        this.fEQ.setVisibility(8);
        this.fEK.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.gOE != null && this.fGw != null) {
            am.setViewTextColor(this.fEK, (int) R.color.cp_cont_d);
            this.fGw.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(t tVar) {
        super.a((d) tVar);
        if (tVar != null && !v.isEmpty(tVar.getDataList())) {
            if (StringUtils.isNull(tVar.mGroupTitle)) {
                this.fEK.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.fEK.setText(tVar.mGroupTitle);
            }
            if (cy(tVar.getDataList())) {
                this.gOG = tVar.getDataList();
                this.fGw.setData(this.gOG);
                this.fGw.notifyDataSetChanged();
            }
        }
    }

    private boolean cy(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        if (!v.isEmpty(this.gOG) && v.getCount(this.gOG) == v.getCount(list)) {
            for (int i = 0; i < v.getCount(this.gOG); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.getItem(this.gOG, i);
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
