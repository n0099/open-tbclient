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
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.c<z> {
    private View.OnClickListener akt;
    private com.baidu.tieba.horizonalList.widget.b iiP;
    private HListView jCm;
    public aa jCn;
    private List<com.baidu.tieba.horizonalList.widget.c> jCo;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.crJ() != null) {
                    e.this.crJ().a(view, null);
                }
            }
        };
        this.jCm = new HListView(getContext());
        this.jCm.setHeaderDividersEnabled(false);
        this.jCm.setFooterDividersEnabled(false);
        this.jCm.setSelector(R.drawable.list_selector_transparent);
        this.jCn = new aa(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.iiP = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.jCn);
        this.iiP.setOnClickListener(this.akt);
        this.jCm.setAdapter((ListAdapter) this.iiP);
        this.ihk.addView(this.jCm);
        this.ihj.setVisibility(8);
        this.ihd.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.jCm != null && this.iiP != null) {
            ap.setViewTextColor(this.ihd, (int) R.color.CAM_X0109);
            this.iiP.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c
    public void a(z zVar) {
        super.a((e) zVar);
        if (zVar != null && !y.isEmpty(zVar.getDataList())) {
            if (StringUtils.isNull(zVar.mGroupTitle)) {
                this.ihd.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.ihd.setText(zVar.mGroupTitle);
            }
            if (dC(zVar.getDataList())) {
                this.jCo = zVar.getDataList();
                this.iiP.setData(this.jCo);
                this.iiP.notifyDataSetChanged();
            }
        }
    }

    private boolean dC(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (y.isEmpty(list)) {
            return false;
        }
        if (!y.isEmpty(this.jCo) && y.getCount(this.jCo) == y.getCount(list)) {
            for (int i = 0; i < y.getCount(this.jCo); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) y.getItem(this.jCo, i);
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
