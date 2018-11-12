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
    private b.InterfaceC0148b ate;
    private FrsFragment dDf;
    private int dKD;
    private List<x> mDatas;

    public a(FrsFragment frsFragment, b.InterfaceC0148b interfaceC0148b) {
        super(frsFragment.getActivity());
        this.dKD = 0;
        if (frsFragment != null && interfaceC0148b != null) {
            this.dDf = frsFragment;
            this.ate = interfaceC0148b;
        }
    }

    public void setData(List<x> list) {
        if (!v.I(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                x xVar = new x();
                xVar.name = this.dDf.getResources().getString(e.j.attention_users_thread);
                xVar.dEQ = 6;
                this.mDatas.add(xVar);
            }
            ArrayList arrayList = new ArrayList();
            for (x xVar2 : this.mDatas) {
                if (xVar2 != null) {
                    arrayList.add(xVar2.name);
                }
            }
            reset();
            a(arrayList, this.ate);
        }
    }

    public List<x> aCw() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b AE() {
        View cV;
        super.AE();
        if (this.mDatas != null && (cV = cV(this.mDatas.size())) != null && (cV.findViewById(e.g.dialog_item_btn) instanceof TextView)) {
            al.h((TextView) cV.findViewById(e.g.dialog_item_btn), e.d.cp_link_tip_a);
        }
        return this;
    }
}
