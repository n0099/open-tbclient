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
    private com.baidu.tieba.horizonalList.widget.b iwh;
    private HListView jRf;
    public FrsSchoolRecommendItemView jRg;
    private List<com.baidu.tieba.horizonalList.widget.c> jRh;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.crV() != null) {
                    d.this.crV().a(view, null);
                }
            }
        };
        this.jRf = new HListView(getContext());
        this.jRf.setHeaderDividersEnabled(false);
        this.jRf.setFooterDividersEnabled(false);
        this.jRf.setSelector(R.drawable.list_selector_transparent);
        this.jRg = new FrsSchoolRecommendItemView(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.iwh = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.jRg);
        this.iwh.setOnClickListener(this.ajT);
        this.jRf.setAdapter((ListAdapter) this.iwh);
        this.iuC.addView(this.jRf);
        this.iuB.setVisibility(8);
        this.iuv.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.jRf != null && this.iwh != null) {
            ap.setViewTextColor(this.iuv, R.color.CAM_X0109);
            this.iwh.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(x xVar) {
        super.a((d) xVar);
        if (xVar != null && !y.isEmpty(xVar.getDataList())) {
            if (StringUtils.isNull(xVar.mGroupTitle)) {
                this.iuv.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.iuv.setText(xVar.mGroupTitle);
            }
            if (dH(xVar.getDataList())) {
                this.jRh = xVar.getDataList();
                this.iwh.setData(this.jRh);
                this.iwh.notifyDataSetChanged();
            }
        }
    }

    private boolean dH(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        if (!y.isEmpty(this.jRh) && y.getCount(this.jRh) == y.getCount(list)) {
            for (int i = 0; i < y.getCount(this.jRh); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) y.getItem(this.jRh, i);
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
