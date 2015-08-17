package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ch extends bc<com.baidu.tieba.tbadkCore.y, cg> implements View.OnClickListener {
    private boolean aYc;

    /* JADX INFO: Access modifiers changed from: protected */
    public ch(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.aYc = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public cg a(ViewGroup viewGroup) {
        return new cg(LayoutInflater.from(this.mContext).inflate(i.g.frs_official_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bc, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.y yVar, cg cgVar) {
        super.a(i, view, viewGroup, (ViewGroup) yVar, (com.baidu.tieba.tbadkCore.y) cgVar);
        if (yVar.apr()) {
            String aps = yVar.aps();
            if (aps != null) {
                cgVar.aXZ.setText(aps);
            } else if (this.aUy.acG() != null && this.aUy.acG().getName() != null) {
                cgVar.aXZ.setText(this.mContext.getString(i.C0057i.get_fortune_hint_format, this.aUy.acG().getName()));
            }
            cgVar.aXY.setTag(Integer.valueOf(i));
            cgVar.aXY.setOnClickListener(this);
            cgVar.aXY.setVisibility(0);
        } else {
            cgVar.aXY.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.o apt = yVar.apt();
        if (apt != null && apt.apn() && !TextUtils.isEmpty(apt.apo())) {
            cgVar.aYb.setText(apt.apo());
            cgVar.aYa.setTag(Integer.valueOf(i));
            cgVar.aYa.setOnClickListener(this);
            cgVar.aYa.setVisibility(0);
        } else {
            cgVar.aYa.setVisibility(8);
        }
        this.aSJ.getLayoutMode().ad(this.mSkinType == 1);
        this.aSJ.getLayoutMode().k(view);
        if (!this.aYc && !yVar.apr()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int LI() {
        return i.f.frs_fortune_bag_item;
    }

    public int LK() {
        return i.f.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aWk != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.aTA.getChildAt(intValue - (this.aTA.getFirstVisiblePosition() - this.aTA.getHeaderViewsCount()));
            this.aWk.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.v) aA(intValue));
        }
    }
}
