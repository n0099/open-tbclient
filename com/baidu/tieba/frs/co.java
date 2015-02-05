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
        cpVar.aGC = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_fortune_bag_content);
        cpVar.aGB = inflate.findViewById(com.baidu.tieba.w.frs_fortune_bag_item);
        cpVar.aGD = inflate.findViewById(com.baidu.tieba.w.frs_my_service_item);
        cpVar.aGE = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_my_service_content);
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
        if (agVar.afb()) {
            String afc = agVar.afc();
            if (afc != null) {
                cpVar.aGC.setText(afc);
            } else if (this.aEF.aeI() != null && this.aEF.aeI().getName() != null) {
                cpVar.aGC.setText(this.mContext.getString(com.baidu.tieba.z.get_fortune_hint_format, this.aEF.aeI().getName()));
            }
            cpVar.aGB.setTag(Integer.valueOf(i));
            cpVar.aGB.setOnClickListener(this);
            cpVar.aGB.setVisibility(0);
        } else {
            cpVar.aGB.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.u afd = agVar.afd();
        if (afd != null && afd.aeX() && !TextUtils.isEmpty(afd.aeY())) {
            cpVar.aGE.setText(afd.aeY());
            cpVar.aGD.setTag(Integer.valueOf(i));
            cpVar.aGD.setOnClickListener(this);
            cpVar.aGD.setVisibility(0);
        } else {
            cpVar.aGD.setVisibility(8);
        }
        this.aEa.getLayoutMode().ab(this.mSkinType == 1);
        this.aEa.getLayoutMode().h(view);
        return view;
    }

    public int Gn() {
        return com.baidu.tieba.w.frs_fortune_bag_item;
    }

    public int Go() {
        return com.baidu.tieba.w.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aEG != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            this.aEG.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.x) aD(intValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof cp);
    }
}
