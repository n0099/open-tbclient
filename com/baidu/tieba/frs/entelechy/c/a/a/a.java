package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends b {
    private b.InterfaceC0097b aRp;
    private i dFD;
    private int dLu;
    private List<z> mDatas;

    public a(i iVar, b.InterfaceC0097b interfaceC0097b) {
        super(iVar.getActivity());
        this.dLu = 0;
        if (iVar != null && interfaceC0097b != null) {
            this.dFD = iVar;
            this.aRp = interfaceC0097b;
        }
    }

    public void setData(List<z> list) {
        if (!v.E(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                z zVar = new z();
                zVar.name = this.dFD.getResources().getString(d.j.attention_users_thread);
                zVar.dHb = 6;
                this.mDatas.add(zVar);
            }
            ArrayList arrayList = new ArrayList();
            for (z zVar2 : this.mDatas) {
                if (zVar2 != null) {
                    arrayList.add(zVar2.name);
                }
            }
            reset();
            a(arrayList, this.aRp);
        }
    }

    public List<z> axH() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b AX() {
        View fj;
        super.AX();
        if (this.mDatas != null && (fj = fj(this.mDatas.size())) != null && (fj.findViewById(d.g.dialog_item_btn) instanceof TextView)) {
            aj.r((TextView) fj.findViewById(d.g.dialog_item_btn), d.C0141d.cp_link_tip_a);
        }
        return this;
    }
}
