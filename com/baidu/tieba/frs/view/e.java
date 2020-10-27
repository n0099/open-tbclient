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
    private View.OnClickListener ajp;
    private com.baidu.tieba.horizonalList.widget.b hRt;
    private HListView jhX;
    public ab jhY;
    private List<com.baidu.tieba.horizonalList.widget.c> jhZ;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ajp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cls() != null) {
                    e.this.cls().a(view, null);
                }
            }
        };
        this.jhX = new HListView(getContext());
        this.jhX.setHeaderDividersEnabled(false);
        this.jhX.setFooterDividersEnabled(false);
        this.jhX.setSelector(R.drawable.list_selector_transparent);
        this.jhY = new ab(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.hRt = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.jhY);
        this.hRt.setOnClickListener(this.ajp);
        this.jhX.setAdapter((ListAdapter) this.hRt);
        this.hPO.addView(this.jhX);
        this.hPN.setVisibility(8);
        this.hPH.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.jhX != null && this.hRt != null) {
            ap.setViewTextColor(this.hPH, (int) R.color.cp_cont_d);
            this.hRt.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(aa aaVar) {
        super.a((e) aaVar);
        if (aaVar != null && !y.isEmpty(aaVar.getDataList())) {
            if (StringUtils.isNull(aaVar.mGroupTitle)) {
                this.hPH.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.hPH.setText(aaVar.mGroupTitle);
            }
            if (dl(aaVar.getDataList())) {
                this.jhZ = aaVar.getDataList();
                this.hRt.setData(this.jhZ);
                this.hRt.notifyDataSetChanged();
            }
        }
    }

    private boolean dl(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        if (!y.isEmpty(this.jhZ) && y.getCount(this.jhZ) == y.getCount(list)) {
            for (int i = 0; i < y.getCount(this.jhZ); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) y.getItem(this.jhZ, i);
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
