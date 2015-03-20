package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class by extends av<com.baidu.tieba.tbadkCore.aj, bx> implements View.OnClickListener {
    private boolean aMm;

    /* JADX INFO: Access modifiers changed from: protected */
    public by(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
        this.aMm = TbadkCoreApplication.m411getInst().appResponseToCmd(2002006);
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
        if (ajVar.akQ()) {
            String akR = ajVar.akR();
            if (akR != null) {
                bxVar.aMj.setText(akR);
            } else if (this.aIV.YO() != null && this.aIV.YO().getName() != null) {
                bxVar.aMj.setText(this.mContext.getString(com.baidu.tieba.y.get_fortune_hint_format, this.aIV.YO().getName()));
            }
            bxVar.aMi.setTag(Integer.valueOf(i));
            bxVar.aMi.setOnClickListener(this);
            bxVar.aMi.setVisibility(0);
        } else {
            bxVar.aMi.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.x akS = ajVar.akS();
        if (akS != null && akS.akM() && !TextUtils.isEmpty(akS.akN())) {
            bxVar.aMl.setText(akS.akN());
            bxVar.aMk.setTag(Integer.valueOf(i));
            bxVar.aMk.setOnClickListener(this);
            bxVar.aMk.setVisibility(0);
        } else {
            bxVar.aMk.setVisibility(8);
        }
        this.aJT.getLayoutMode().X(this.mSkinType == 1);
        this.aJT.getLayoutMode().h(view);
        if (!this.aMm && !ajVar.akQ()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int JJ() {
        return com.baidu.tieba.v.frs_fortune_bag_item;
    }

    public int JK() {
        return com.baidu.tieba.v.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aKC != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            this.aKC.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.w) aA(intValue));
        }
    }
}
