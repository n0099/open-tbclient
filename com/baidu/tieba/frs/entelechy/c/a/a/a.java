package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends b {
    private b.InterfaceC0104b als;
    private FrsFragment dla;
    private int dsh;
    private List<x> mDatas;

    public a(FrsFragment frsFragment, b.InterfaceC0104b interfaceC0104b) {
        super(frsFragment.getActivity());
        this.dsh = 0;
        if (frsFragment != null && interfaceC0104b != null) {
            this.dla = frsFragment;
            this.als = interfaceC0104b;
        }
    }

    public void setData(List<x> list) {
        if (!w.A(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                x xVar = new x();
                xVar.name = this.dla.getResources().getString(d.k.attention_users_thread);
                xVar.dmC = 6;
                this.mDatas.add(xVar);
            }
            ArrayList arrayList = new ArrayList();
            for (x xVar2 : this.mDatas) {
                if (xVar2 != null) {
                    arrayList.add(xVar2.name);
                }
            }
            reset();
            a(arrayList, this.als);
        }
    }

    public List<x> awQ() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b xq() {
        View cl;
        super.xq();
        if (this.mDatas != null && (cl = cl(this.mDatas.size())) != null && (cl.findViewById(d.g.dialog_item_btn) instanceof TextView)) {
            am.h((TextView) cl.findViewById(d.g.dialog_item_btn), d.C0142d.cp_link_tip_a);
        }
        return this;
    }
}
