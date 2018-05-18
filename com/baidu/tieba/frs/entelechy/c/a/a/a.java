package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends b {
    private b.InterfaceC0086b acO;
    private FrsFragment cZJ;
    private int dfJ;
    private List<v> mDatas;

    public a(FrsFragment frsFragment, b.InterfaceC0086b interfaceC0086b) {
        super(frsFragment.getActivity());
        this.dfJ = 0;
        if (frsFragment != null && interfaceC0086b != null) {
            this.cZJ = frsFragment;
            this.acO = interfaceC0086b;
        }
    }

    public void setData(List<v> list) {
        if (!com.baidu.tbadk.core.util.v.w(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                v vVar = new v();
                vVar.name = this.cZJ.getResources().getString(d.k.attention_users_thread);
                vVar.dbf = 6;
                this.mDatas.add(vVar);
            }
            ArrayList arrayList = new ArrayList();
            for (v vVar2 : this.mDatas) {
                if (vVar2 != null) {
                    arrayList.add(vVar2.name);
                }
            }
            reset();
            a(arrayList, this.acO);
        }
    }

    public List<v> ash() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b tF() {
        View ci;
        super.tF();
        if (this.mDatas != null && (ci = ci(this.mDatas.size())) != null && (ci.findViewById(d.g.dialog_item_btn) instanceof TextView)) {
            ak.h((TextView) ci.findViewById(d.g.dialog_item_btn), d.C0126d.cp_link_tip_a);
        }
        return this;
    }
}
