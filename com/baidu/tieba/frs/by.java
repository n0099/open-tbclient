package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class by extends av<com.baidu.tieba.tbadkCore.aj, bx> implements View.OnClickListener {
    private boolean aMx;

    /* JADX INFO: Access modifiers changed from: protected */
    public by(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aMx = TbadkCoreApplication.m411getInst().appResponseToCmd(2002006);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public bx a(ViewGroup viewGroup) {
        return new bx(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.frs_official_account_item, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.aj ajVar, bx bxVar) {
        super.a(i, view, viewGroup, (ViewGroup) ajVar, (com.baidu.tieba.tbadkCore.aj) bxVar);
        if (ajVar.alf()) {
            String alg = ajVar.alg();
            if (alg != null) {
                bxVar.aMu.setText(alg);
            } else if (this.aJd.Za() != null && this.aJd.Za().getName() != null) {
                bxVar.aMu.setText(this.mContext.getString(com.baidu.tieba.y.get_fortune_hint_format, this.aJd.Za().getName()));
            }
            bxVar.aMt.setTag(Integer.valueOf(i));
            bxVar.aMt.setOnClickListener(this);
            bxVar.aMt.setVisibility(0);
        } else {
            bxVar.aMt.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.x alh = ajVar.alh();
        if (alh != null && alh.alb() && !TextUtils.isEmpty(alh.alc())) {
            bxVar.aMw.setText(alh.alc());
            bxVar.aMv.setTag(Integer.valueOf(i));
            bxVar.aMv.setOnClickListener(this);
            bxVar.aMv.setVisibility(0);
        } else {
            bxVar.aMv.setVisibility(8);
        }
        this.aKd.getLayoutMode().X(this.mSkinType == 1);
        this.aKd.getLayoutMode().h(view);
        if (!this.aMx && !ajVar.alf()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int JQ() {
        return com.baidu.tieba.v.frs_fortune_bag_item;
    }

    public int JR() {
        return com.baidu.tieba.v.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aKM != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            this.aKM.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.w) aA(intValue));
        }
    }
}
