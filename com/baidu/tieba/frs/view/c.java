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
    private View.OnClickListener afS;
    private com.baidu.tieba.horizonalList.widget.b gow;
    private HListView hCa;
    public x hCb;
    private List<com.baidu.tieba.horizonalList.widget.c> hCc;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.afS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bEy() != null) {
                    c.this.bEy().a(view, null);
                }
            }
        };
        this.hCa = new HListView(getContext());
        this.hCa.setHeaderDividersEnabled(false);
        this.hCa.setFooterDividersEnabled(false);
        this.hCa.setSelector(R.drawable.list_selector_transparent);
        this.hCb = new x(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.gow = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.hCb);
        this.gow.setOnClickListener(this.afS);
        this.hCa.setAdapter((ListAdapter) this.gow);
        this.gmR.addView(this.hCa);
        this.gmQ.setVisibility(8);
        this.gmK.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.hCa != null && this.gow != null) {
            am.setViewTextColor(this.gmK, (int) R.color.cp_cont_d);
            this.gow.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(w wVar) {
        super.a((c) wVar);
        if (wVar != null && !v.isEmpty(wVar.getDataList())) {
            if (StringUtils.isNull(wVar.mGroupTitle)) {
                this.gmK.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.gmK.setText(wVar.mGroupTitle);
            }
            if (cF(wVar.getDataList())) {
                this.hCc = wVar.getDataList();
                this.gow.setData(this.hCc);
                this.gow.notifyDataSetChanged();
            }
        }
    }

    private boolean cF(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        if (!v.isEmpty(this.hCc) && v.getCount(this.hCc) == v.getCount(list)) {
            for (int i = 0; i < v.getCount(this.hCc); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.getItem(this.hCc, i);
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
