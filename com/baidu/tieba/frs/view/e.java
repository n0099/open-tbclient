package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.List;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.card.c<z> {
    private View.OnClickListener ahn;
    private com.baidu.tieba.horizonalList.widget.b gWd;
    private HListView ilf;
    public aa ilg;
    private List<com.baidu.tieba.horizonalList.widget.c> ilh;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.ahn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bRn() != null) {
                    e.this.bRn().a(view, null);
                }
            }
        };
        this.ilf = new HListView(getContext());
        this.ilf.setHeaderDividersEnabled(false);
        this.ilf.setFooterDividersEnabled(false);
        this.ilf.setSelector(R.drawable.list_selector_transparent);
        this.ilg = new aa(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_school_recommend_user, (ViewGroup) null), tbPageContext, bdUniqueId);
        this.gWd = new com.baidu.tieba.horizonalList.widget.b(getContext(), R.layout.frs_school_recommend_user, this.ilg);
        this.gWd.setOnClickListener(this.ahn);
        this.ilf.setAdapter((ListAdapter) this.gWd);
        this.gUy.addView(this.ilf);
        this.gUx.setVisibility(8);
        this.gUr.setTextSize(0, l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds28));
    }

    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.ilf != null && this.gWd != null) {
            ao.setViewTextColor(this.gUr, R.color.cp_cont_d);
            this.gWd.onSkinTypeChanged(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.c, com.baidu.tieba.card.b
    public void a(z zVar) {
        super.a((e) zVar);
        if (zVar != null && !x.isEmpty(zVar.getDataList())) {
            if (StringUtils.isNull(zVar.mGroupTitle)) {
                this.gUr.setText(getContext().getResources().getString(R.string.school_recommend));
            } else {
                this.gUr.setText(zVar.mGroupTitle);
            }
            if (cS(zVar.getDataList())) {
                this.ilh = zVar.getDataList();
                this.gWd.setData(this.ilh);
                this.gWd.notifyDataSetChanged();
            }
        }
    }

    private boolean cS(List<com.baidu.tieba.horizonalList.widget.c> list) {
        if (x.isEmpty(list)) {
            return false;
        }
        if (!x.isEmpty(this.ilh) && x.getCount(this.ilh) == x.getCount(list)) {
            for (int i = 0; i < x.getCount(this.ilh); i++) {
                com.baidu.tieba.horizonalList.widget.c cVar = (com.baidu.tieba.horizonalList.widget.c) x.getItem(this.ilh, i);
                com.baidu.tieba.horizonalList.widget.c cVar2 = (com.baidu.tieba.horizonalList.widget.c) x.getItem(list, i);
                if ((cVar instanceof az) && (cVar2 instanceof az) && !((az) cVar).metaData.getUserId().equals(((az) cVar2).metaData.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
