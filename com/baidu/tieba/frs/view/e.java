package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes21.dex */
public class e extends com.baidu.tieba.card.c<aa> {
    private View.OnClickListener aju;
    private com.baidu.tieba.horizonalList.widget.b hXQ;
    private HListView joI;
    public ab joJ;
    private List<com.baidu.tieba.horizonalList.widget.c> joK;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aju = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cnv() != null) {
                    e.this.cnv().a(view, null);
                }
            }
        };
        this.joI = new HListView(getContext());
        this.joI.setHeaderDividersEnabled(false);
        this.joI.setFooterDividersEnabled(false);
        this.joI.setSelector(R.drawable.list_selector_transparent);
        this.joJ = new ab(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.hXQ = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.joJ);
        this.hXQ.setOnClickListener(this.aju);
        this.joI.setAdapter((ListAdapter) this.hXQ);
        this.hWl.addView(this.joI);
        this.hWk.setVisibility(8);
        this.hWe.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.joI != null && this.hXQ != null) {
            ap.setViewTextColor(this.hWe, (int) R.color.CAM_X0109);
            this.hXQ.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(aa aaVar) {
        super.a((e) aaVar);
        if (aaVar != null && !y.isEmpty(aaVar.getDataList())) {
            if (StringUtils.isNull(aaVar.mGroupTitle)) {
                this.hWe.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.hWe.setText(aaVar.mGroupTitle);
            }
            if (dt(aaVar.getDataList())) {
                this.joK = aaVar.getDataList();
                this.hXQ.setData(this.joK);
                this.hXQ.notifyDataSetChanged();
            }
        }
    }

    private boolean dt(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        if (!y.isEmpty(this.joK) && y.getCount(this.joK) == y.getCount(list)) {
            for (int i = 0; i < y.getCount(this.joK); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) y.getItem(this.joK, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) y.getItem(list, i);
                if ((cVar instanceof bb) && (cVar2 instanceof bb) && !((bb) cVar).metaData.getUserId().equals(((bb) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
