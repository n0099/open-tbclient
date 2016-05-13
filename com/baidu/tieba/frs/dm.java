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
public class dm extends bw<com.baidu.tieba.tbadkCore.aa, dl> implements View.OnClickListener {
    private boolean biL;
    private boolean blg;

    public dm(BaseActivity baseActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseActivity, bdUniqueId);
        this.blg = TbadkCoreApplication.m11getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.biL = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: r */
    public dl b(ViewGroup viewGroup) {
        return new dl(LayoutInflater.from(this.mContext).inflate(t.h.frs_official_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.aa aaVar, dl dlVar) {
        super.a(i, view, viewGroup, (ViewGroup) aaVar, (com.baidu.tieba.tbadkCore.aa) dlVar);
        if (aaVar.aTe()) {
            String aTf = aaVar.aTf();
            if (aTf != null) {
                dlVar.bld.setText(aTf);
            } else if (this.bgq.avD() != null && this.bgq.avD().getName() != null) {
                dlVar.bld.setText(this.mContext.getString(t.j.get_fortune_hint_format, this.bgq.avD().getName()));
            }
            dlVar.blc.setTag(Integer.valueOf(i));
            dlVar.blc.setOnClickListener(this);
            dlVar.blc.setVisibility(0);
        } else {
            dlVar.blc.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p aTg = aaVar.aTg();
        if (aTg != null && aTg.aSZ() && !TextUtils.isEmpty(aTg.aTa())) {
            dlVar.blf.setText(aTg.aTa());
            dlVar.ble.setTag(Integer.valueOf(i));
            dlVar.ble.setOnClickListener(this);
            dlVar.ble.setVisibility(0);
        } else {
            dlVar.ble.setVisibility(8);
        }
        if (this.biL) {
            dlVar.biH.setVisibility(0);
        } else {
            dlVar.biH.setVisibility(8);
        }
        this.bek.getLayoutMode().ae(this.mSkinType == 1);
        this.bek.getLayoutMode().x(view);
        if (!this.blg && !aaVar.aTe()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int Rv() {
        return t.g.frs_fortune_bag_item;
    }

    public int Rw() {
        return t.g.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bix != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.bfr.getChildAt(intValue - (this.bfr.getFirstVisiblePosition() - this.bfr.getHeaderViewsCount()));
            this.bix.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.ax) as(intValue));
        }
    }
}
