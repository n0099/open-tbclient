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
    private b.InterfaceC0074b aQb;
    private int dDJ;
    private i dxW;
    private List<z> mDatas;

    public a(i iVar, b.InterfaceC0074b interfaceC0074b) {
        super(iVar.getActivity());
        this.dDJ = 0;
        if (iVar != null && interfaceC0074b != null) {
            this.dxW = iVar;
            this.aQb = interfaceC0074b;
        }
    }

    public void setData(List<z> list) {
        if (!v.G(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                z zVar = new z();
                zVar.name = this.dxW.getResources().getString(d.j.attention_users_thread);
                zVar.dzo = 6;
                this.mDatas.add(zVar);
            }
            ArrayList arrayList = new ArrayList();
            for (z zVar2 : this.mDatas) {
                if (zVar2 != null) {
                    arrayList.add(zVar2.name);
                }
            }
            reset();
            a(arrayList, this.aQb);
        }
    }

    public List<z> avB() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b AL() {
        View fl;
        super.AL();
        if (this.mDatas != null && (fl = fl(this.mDatas.size())) != null && (fl.findViewById(d.g.dialog_item_btn) instanceof TextView)) {
            aj.r((TextView) fl.findViewById(d.g.dialog_item_btn), d.C0108d.cp_link_tip_a);
        }
        return this;
    }
}
