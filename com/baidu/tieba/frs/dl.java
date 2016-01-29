package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dl extends bv<com.baidu.tieba.tbadkCore.z, dk> implements View.OnClickListener {
    private boolean bkB;

    /* JADX INFO: Access modifiers changed from: protected */
    public dl(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bkB = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public dk b(ViewGroup viewGroup) {
        return new dk(LayoutInflater.from(this.mContext).inflate(t.h.frs_official_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bv, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.z zVar, dk dkVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tieba.tbadkCore.z) dkVar);
        if (zVar.aLF()) {
            String aLG = zVar.aLG();
            if (aLG != null) {
                dkVar.bky.setText(aLG);
            } else if (this.bfF.aoE() != null && this.bfF.aoE().getName() != null) {
                dkVar.bky.setText(this.mContext.getString(t.j.get_fortune_hint_format, this.bfF.aoE().getName()));
            }
            dkVar.bkx.setTag(Integer.valueOf(i));
            dkVar.bkx.setOnClickListener(this);
            dkVar.bkx.setVisibility(0);
        } else {
            dkVar.bkx.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p aLH = zVar.aLH();
        if (aLH != null && aLH.aLB() && !TextUtils.isEmpty(aLH.aLC())) {
            dkVar.bkA.setText(aLH.aLC());
            dkVar.bkz.setTag(Integer.valueOf(i));
            dkVar.bkz.setOnClickListener(this);
            dkVar.bkz.setVisibility(0);
        } else {
            dkVar.bkz.setVisibility(8);
        }
        this.bdK.getLayoutMode().ac(this.mSkinType == 1);
        this.bdK.getLayoutMode().x(view);
        if (!this.bkB && !zVar.aLF()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int PA() {
        return t.g.frs_fortune_bag_item;
    }

    public int PC() {
        return t.g.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bim != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.beF.getChildAt(intValue - (this.beF.getFirstVisiblePosition() - this.beF.getHeaderViewsCount()));
            this.bim.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.ah) aG(intValue));
        }
    }
}
