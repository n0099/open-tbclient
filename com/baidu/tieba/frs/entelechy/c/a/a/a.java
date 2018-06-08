package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends b {
    private b.InterfaceC0103b akS;
    private FrsFragment diZ;
    private int doY;
    private List<v> mDatas;

    public a(FrsFragment frsFragment, b.InterfaceC0103b interfaceC0103b) {
        super(frsFragment.getActivity());
        this.doY = 0;
        if (frsFragment != null && interfaceC0103b != null) {
            this.diZ = frsFragment;
            this.akS = interfaceC0103b;
        }
    }

    public void setData(List<v> list) {
        if (!w.z(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                v vVar = new v();
                vVar.name = this.diZ.getResources().getString(d.k.attention_users_thread);
                vVar.dkv = 6;
                this.mDatas.add(vVar);
            }
            ArrayList arrayList = new ArrayList();
            for (v vVar2 : this.mDatas) {
                if (vVar2 != null) {
                    arrayList.add(vVar2.name);
                }
            }
            reset();
            a(arrayList, this.akS);
        }
    }

    public List<v> awm() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b xd() {
        View ck;
        super.xd();
        if (this.mDatas != null && (ck = ck(this.mDatas.size())) != null && (ck.findViewById(d.g.dialog_item_btn) instanceof TextView)) {
            al.h((TextView) ck.findViewById(d.g.dialog_item_btn), d.C0141d.cp_link_tip_a);
        }
        return this;
    }
}
