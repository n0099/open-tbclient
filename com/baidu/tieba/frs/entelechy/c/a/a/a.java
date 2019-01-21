package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends b {
    private b.InterfaceC0158b axi;
    private FrsFragment dNc;
    private int dUE;
    private List<x> mDatas;

    public a(FrsFragment frsFragment, b.InterfaceC0158b interfaceC0158b) {
        super(frsFragment.getActivity());
        this.dUE = 0;
        if (frsFragment != null && interfaceC0158b != null) {
            this.dNc = frsFragment;
            this.axi = interfaceC0158b;
        }
    }

    public void setData(List<x> list) {
        if (!v.I(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                x xVar = new x();
                xVar.name = this.dNc.getResources().getString(e.j.attention_users_thread);
                xVar.dON = 6;
                this.mDatas.add(xVar);
            }
            ArrayList arrayList = new ArrayList();
            for (x xVar2 : this.mDatas) {
                if (xVar2 != null) {
                    arrayList.add(xVar2.name);
                }
            }
            reset();
            a(arrayList, this.axi);
        }
    }

    public List<x> aFu() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b BV() {
        View dj;
        super.BV();
        if (this.mDatas != null && (dj = dj(this.mDatas.size())) != null && (dj.findViewById(e.g.dialog_item_btn) instanceof TextView)) {
            al.h((TextView) dj.findViewById(e.g.dialog_item_btn), e.d.cp_link_tip_a);
        }
        return this;
    }
}
