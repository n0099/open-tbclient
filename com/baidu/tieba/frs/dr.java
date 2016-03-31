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
public class dr extends bx<com.baidu.tieba.tbadkCore.z, dq> implements View.OnClickListener {
    private boolean bpQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public dr(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bpQ = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: y */
    public dq b(ViewGroup viewGroup) {
        return new dq(LayoutInflater.from(this.mContext).inflate(t.h.frs_official_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bx, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.z zVar, dq dqVar) {
        super.a(i, view, viewGroup, (ViewGroup) zVar, (com.baidu.tieba.tbadkCore.z) dqVar);
        if (zVar.aSz()) {
            String aSA = zVar.aSA();
            if (aSA != null) {
                dqVar.bpN.setText(aSA);
            } else if (this.bkq.avu() != null && this.bkq.avu().getName() != null) {
                dqVar.bpN.setText(this.mContext.getString(t.j.get_fortune_hint_format, this.bkq.avu().getName()));
            }
            dqVar.bpM.setTag(Integer.valueOf(i));
            dqVar.bpM.setOnClickListener(this);
            dqVar.bpM.setVisibility(0);
        } else {
            dqVar.bpM.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p aSB = zVar.aSB();
        if (aSB != null && aSB.aSu() && !TextUtils.isEmpty(aSB.aSv())) {
            dqVar.bpP.setText(aSB.aSv());
            dqVar.bpO.setTag(Integer.valueOf(i));
            dqVar.bpO.setOnClickListener(this);
            dqVar.bpO.setVisibility(0);
        } else {
            dqVar.bpO.setVisibility(8);
        }
        this.bix.getLayoutMode().ab(this.mSkinType == 1);
        this.bix.getLayoutMode().x(view);
        if (!this.bpQ && !zVar.aSz()) {
            return new View(this.mContext);
        }
        return view;
    }

    public int Rp() {
        return t.g.frs_fortune_bag_item;
    }

    public int Rr() {
        return t.g.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bmX != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.bjr.getChildAt(intValue - (this.bjr.getFirstVisiblePosition() - this.bjr.getHeaderViewsCount()));
            this.bmX.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.as) aF(intValue));
        }
    }
}
