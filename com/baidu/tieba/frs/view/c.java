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
public class c extends com.baidu.tieba.card.c<w> {
    private View.OnClickListener ags;
    private com.baidu.tieba.horizonalList.widget.b gDw;
    private HListView hQT;
    public x hQU;
    private List<com.baidu.tieba.horizonalList.widget.c> hQV;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ags = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.bKS() != null) {
                    c.this.bKS().a(view, null);
                }
            }
        };
        this.hQT = new HListView(getContext());
        this.hQT.setHeaderDividersEnabled(false);
        this.hQT.setFooterDividersEnabled(false);
        this.hQT.setSelector(R.drawable.list_selector_transparent);
        this.hQU = new x(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.gDw = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.hQU);
        this.gDw.setOnClickListener(this.ags);
        this.hQT.setAdapter((ListAdapter) this.gDw);
        this.gBR.addView(this.hQT);
        this.gBQ.setVisibility(8);
        this.gBK.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.hQT != null && this.gDw != null) {
            am.setViewTextColor(this.gBK, (int) R.color.cp_cont_d);
            this.gDw.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(w wVar) {
        super.a((c) wVar);
        if (wVar != null && !v.isEmpty(wVar.getDataList())) {
            if (StringUtils.isNull(wVar.mGroupTitle)) {
                this.gBK.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.gBK.setText(wVar.mGroupTitle);
            }
            if (cC(wVar.getDataList())) {
                this.hQV = wVar.getDataList();
                this.gDw.setData(this.hQV);
                this.gDw.notifyDataSetChanged();
            }
        }
    }

    private boolean cC(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.isEmpty(list)) {
            return false;
        }
        if (!v.isEmpty(this.hQV) && v.getCount(this.hQV) == v.getCount(list)) {
            for (int i = 0; i < v.getCount(this.hQV); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.getItem(this.hQV, i);
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
