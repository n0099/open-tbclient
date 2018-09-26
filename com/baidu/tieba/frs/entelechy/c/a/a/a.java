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
/* loaded from: classes2.dex */
public class a extends b {
    private b.InterfaceC0100b anx;
    private int dBz;
    private FrsFragment dtN;
    private List<x> mDatas;

    public a(FrsFragment frsFragment, b.InterfaceC0100b interfaceC0100b) {
        super(frsFragment.getActivity());
        this.dBz = 0;
        if (frsFragment != null && interfaceC0100b != null) {
            this.dtN = frsFragment;
            this.anx = interfaceC0100b;
        }
    }

    public void setData(List<x> list) {
        if (!v.z(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                x xVar = new x();
                xVar.name = this.dtN.getResources().getString(e.j.attention_users_thread);
                xVar.dvz = 6;
                this.mDatas.add(xVar);
            }
            ArrayList arrayList = new ArrayList();
            for (x xVar2 : this.mDatas) {
                if (xVar2 != null) {
                    arrayList.add(xVar2.name);
                }
            }
            reset();
            a(arrayList, this.anx);
        }
    }

    public List<x> azI() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b yo() {
        View cx;
        super.yo();
        if (this.mDatas != null && (cx = cx(this.mDatas.size())) != null && (cx.findViewById(e.g.dialog_item_btn) instanceof TextView)) {
            al.h((TextView) cx.findViewById(e.g.dialog_item_btn), e.d.cp_link_tip_a);
        }
        return this;
    }
}
