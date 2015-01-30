package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class co extends bh<com.baidu.tieba.tbadkCore.ag> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public co(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        cp cpVar = new cp(null);
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_official_account_item, null);
        cpVar.aGF = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_fortune_bag_content);
        cpVar.aGE = inflate.findViewById(com.baidu.tieba.w.frs_fortune_bag_item);
        cpVar.aGG = inflate.findViewById(com.baidu.tieba.w.frs_my_service_item);
        cpVar.aGH = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_my_service_content);
        inflate.setTag(cpVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bh, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.ag agVar) {
        super.b(i, view, viewGroup, agVar);
        cp cpVar = (cp) view.getTag();
        if (agVar.afg()) {
            String afh = agVar.afh();
            if (afh != null) {
                cpVar.aGF.setText(afh);
            } else if (this.aEI.aeN() != null && this.aEI.aeN().getName() != null) {
                cpVar.aGF.setText(this.mContext.getString(com.baidu.tieba.z.get_fortune_hint_format, this.aEI.aeN().getName()));
            }
            cpVar.aGE.setTag(Integer.valueOf(i));
            cpVar.aGE.setOnClickListener(this);
            cpVar.aGE.setVisibility(0);
        } else {
            cpVar.aGE.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.u afi = agVar.afi();
        if (afi != null && afi.afc() && !TextUtils.isEmpty(afi.afd())) {
            cpVar.aGH.setText(afi.afd());
            cpVar.aGG.setTag(Integer.valueOf(i));
            cpVar.aGG.setOnClickListener(this);
            cpVar.aGG.setVisibility(0);
        } else {
            cpVar.aGG.setVisibility(8);
        }
        this.aEd.getLayoutMode().ab(this.mSkinType == 1);
        this.aEd.getLayoutMode().h(view);
        return view;
    }

    public int Gt() {
        return com.baidu.tieba.w.frs_fortune_bag_item;
    }

    public int Gu() {
        return com.baidu.tieba.w.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aEJ != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            this.aEJ.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.x) aD(intValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof cp);
    }
}
