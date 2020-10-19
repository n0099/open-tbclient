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
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.c<aa> {
    private View.OnClickListener ajo;
    private com.baidu.tieba.horizonalList.widget.b hEX;
    private HListView iVB;
    public ab iVC;
    private List<com.baidu.tieba.horizonalList.widget.c> iVD;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cil() != null) {
                    e.this.cil().a(view, null);
                }
            }
        };
        this.iVB = new HListView(getContext());
        this.iVB.setHeaderDividersEnabled(false);
        this.iVB.setFooterDividersEnabled(false);
        this.iVB.setSelector(R.drawable.list_selector_transparent);
        this.iVC = new ab(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.hEX = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.iVC);
        this.hEX.setOnClickListener(this.ajo);
        this.iVB.setAdapter((ListAdapter) this.hEX);
        this.hDs.addView(this.iVB);
        this.hDr.setVisibility(8);
        this.hDl.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.iVB != null && this.hEX != null) {
            ap.setViewTextColor(this.hDl, (int) R.color.cp_cont_d);
            this.hEX.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(aa aaVar) {
        super.a((e) aaVar);
        if (aaVar != null && !y.isEmpty(aaVar.getDataList())) {
            if (StringUtils.isNull(aaVar.mGroupTitle)) {
                this.hDl.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.hDl.setText(aaVar.mGroupTitle);
            }
            if (dc(aaVar.getDataList())) {
                this.iVD = aaVar.getDataList();
                this.hEX.setData(this.iVD);
                this.hEX.notifyDataSetChanged();
            }
        }
    }

    private boolean dc(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        if (!y.isEmpty(this.iVD) && y.getCount(this.iVD) == y.getCount(list)) {
            for (int i = 0; i < y.getCount(this.iVD); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) y.getItem(this.iVD, i);
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
