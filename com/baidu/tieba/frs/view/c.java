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
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<w> {
    private View.OnClickListener afV;
    private com.baidu.tieba.horizonalList.widget.b goC;
    private HListView hCg;
    public x hCh;
    private List<com.baidu.tieba.horizonalList.widget.c> hCi;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.afV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bEw() != null) {
                    c.this.bEw().a(view, null);
                }
            }
        };
        this.hCg = new HListView(getContext());
        this.hCg.setHeaderDividersEnabled(false);
        this.hCg.setFooterDividersEnabled(false);
        this.hCg.setSelector(R.drawable.list_selector_transparent);
        this.hCh = new x(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.goC = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.hCh);
        this.goC.setOnClickListener(this.afV);
        this.hCg.setAdapter((ListAdapter) this.goC);
        this.gmX.addView(this.hCg);
        this.gmW.setVisibility(8);
        this.gmQ.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.hCg != null && this.goC != null) {
            am.setViewTextColor(this.gmQ, (int) R.color.cp_cont_d);
            this.goC.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(w wVar) {
        super.a((c) wVar);
        if (wVar != null && !v.isEmpty(wVar.getDataList())) {
            if (StringUtils.isNull(wVar.mGroupTitle)) {
                this.gmQ.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.gmQ.setText(wVar.mGroupTitle);
            }
            if (cF(wVar.getDataList())) {
                this.hCi = wVar.getDataList();
                this.goC.setData(this.hCi);
                this.goC.notifyDataSetChanged();
            }
        }
    }

    private boolean cF(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        if (!v.isEmpty(this.hCi) && v.getCount(this.hCi) == v.getCount(list)) {
            for (int i = 0; i < v.getCount(this.hCi); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.getItem(this.hCi, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) v.getItem(list, i);
                if ((cVar instanceof at) && (cVar2 instanceof at) && !((at) cVar).metaData.getUserId().equals(((at) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
