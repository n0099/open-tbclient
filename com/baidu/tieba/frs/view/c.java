package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<s> {
    private View.OnClickListener aEZ;
    private com.baidu.tieba.horizonalList.widget.b cTY;
    private HListView cUh;
    public t ehn;
    private List<com.baidu.tieba.horizonalList.widget.c> mItemList;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.aEZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.apc() != null) {
                    c.this.apc().a(view, null);
                }
            }
        };
        this.cUh = new HListView(getContext());
        this.cUh.setHeaderDividersEnabled(false);
        this.cUh.setFooterDividersEnabled(false);
        this.cUh.setSelector(e.f.list_selector_transparent);
        this.ehn = new t(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.cTY = new com.baidu.tieba.horizonalList.widget.b(getContext(), e.h.frs_school_recommend_user, this.ehn);
        this.cTY.setOnClickListener(this.aEZ);
        this.cUh.setAdapter((ListAdapter) this.cTY);
        this.cSn.addView(this.cUh);
        this.cSm.setVisibility(8);
        this.cSg.setTextSize(0, l.h(tbPageContext.getPageActivity(), e.C0210e.ds28));
    }

    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        super.d(tbPageContext, i);
        if (this.cUh != null && this.cTY != null) {
            al.h(this.cSg, e.d.cp_cont_d);
            this.cTY.ej(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b, com.baidu.tieba.card.a
    public void a(s sVar) {
        super.a((c) sVar);
        if (sVar != null && !v.I(sVar.getDataList())) {
            if (StringUtils.isNull(sVar.mGroupTitle)) {
                this.cSg.setText(getContext().getResources().getString(e.j.school_recommend));
            } else {
                this.cSg.setText(sVar.mGroupTitle);
            }
            if (aZ(sVar.getDataList())) {
                this.mItemList = sVar.getDataList();
                this.cTY.setData(this.mItemList);
                this.cTY.notifyDataSetChanged();
            }
        }
    }

    private boolean aZ(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (v.I(list)) {
            return false;
        }
        if (!v.I(this.mItemList) && v.H(this.mItemList) == v.H(list)) {
            for (int i = 0; i < v.H(this.mItemList); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) v.d(this.mItemList, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) v.d(list, i);
                if ((cVar instanceof ap) && (cVar2 instanceof ap) && !((ap) cVar).metaData.getUserId().equals(((ap) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
