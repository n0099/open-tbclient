package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class dd extends bm<com.baidu.tieba.tbadkCore.aa, dc> implements View.OnClickListener {
    private boolean bdK;

    /* JADX INFO: Access modifiers changed from: protected */
    public dd(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bdK = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: q */
    public dc a(ViewGroup viewGroup) {
        return new dc(LayoutInflater.from(this.mContext).inflate(n.g.frs_official_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.aa aaVar, dc dcVar) {
        super.a(i, view, viewGroup, (ViewGroup) aaVar, (com.baidu.tieba.tbadkCore.aa) dcVar);
        if (aaVar.aCs()) {
            String aCt = aaVar.aCt();
            if (aCt != null) {
                dcVar.bdH.setText(aCt);
            } else if (this.aZs.ajy() != null && this.aZs.ajy().getName() != null) {
                dcVar.bdH.setText(this.mContext.getString(n.i.get_fortune_hint_format, this.aZs.ajy().getName()));
            }
            dcVar.bdG.setTag(Integer.valueOf(i));
            dcVar.bdG.setOnClickListener(this);
            dcVar.bdG.setVisibility(0);
        } else {
            dcVar.bdG.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.q aCu = aaVar.aCu();
        if (aCu != null && aCu.aCn() && !TextUtils.isEmpty(aCu.aCo())) {
            dcVar.bdJ.setText(aCu.aCo());
            dcVar.bdI.setTag(Integer.valueOf(i));
            dcVar.bdI.setOnClickListener(this);
            dcVar.bdI.setVisibility(0);
        } else {
            dcVar.bdI.setVisibility(8);
        }
        this.aXA.getLayoutMode().af(this.mSkinType == 1);
        this.aXA.getLayoutMode().k(view);
        if (!this.bdK && !aaVar.aCs()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int Nh() {
        return n.f.frs_fortune_bag_item;
    }

    public int Nj() {
        return n.f.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbF != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.aYr.getChildAt(intValue - (this.aYr.getFirstVisiblePosition() - this.aYr.getHeaderViewsCount()));
            this.bbF.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.z) aB(intValue));
        }
    }
}
