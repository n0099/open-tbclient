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
import com.baidu.tieba.frs.FrsSchoolRecommendItemView;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.c<x> {
    private View.OnClickListener ajT;
    private com.baidu.tieba.horizonalList.widget.b iwv;
    private HListView jRt;
    public FrsSchoolRecommendItemView jRu;
    private List<com.baidu.tieba.horizonalList.widget.c> jRv;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.csc() != null) {
                    d.this.csc().a(view, null);
                }
            }
        };
        this.jRt = new HListView(getContext());
        this.jRt.setHeaderDividersEnabled(false);
        this.jRt.setFooterDividersEnabled(false);
        this.jRt.setSelector(R.drawable.list_selector_transparent);
        this.jRu = new FrsSchoolRecommendItemView(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.iwv = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.jRu);
        this.iwv.setOnClickListener(this.ajT);
        this.jRt.setAdapter((ListAdapter) this.iwv);
        this.iuQ.addView(this.jRt);
        this.iuP.setVisibility(8);
        this.iuJ.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.jRt != null && this.iwv != null) {
            ap.setViewTextColor(this.iuJ, R.color.CAM_X0109);
            this.iwv.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(x xVar) {
        super.a((d) xVar);
        if (xVar != null && !y.isEmpty(xVar.getDataList())) {
            if (StringUtils.isNull(xVar.mGroupTitle)) {
                this.iuJ.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.iuJ.setText(xVar.mGroupTitle);
            }
            if (dH(xVar.getDataList())) {
                this.jRv = xVar.getDataList();
                this.iwv.setData(this.jRv);
                this.iwv.notifyDataSetChanged();
            }
        }
    }

    private boolean dH(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        if (!y.isEmpty(this.jRv) && y.getCount(this.jRv) == y.getCount(list)) {
            for (int i = 0; i < y.getCount(this.jRv); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) y.getItem(this.jRv, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) y.getItem(list, i);
                if ((cVar instanceof ay) && (cVar2 instanceof ay) && !((ay) cVar).metaData.getUserId().equals(((ay) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
