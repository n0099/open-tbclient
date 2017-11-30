package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends b {
    private b.InterfaceC0047b abK;
    private f cIp;
    private int cOE;
    private List<y> mDatas;

    public a(f fVar, b.InterfaceC0047b interfaceC0047b) {
        super(fVar.getActivity());
        this.cOE = 0;
        if (fVar != null && interfaceC0047b != null) {
            this.cIp = fVar;
            this.abK = interfaceC0047b;
        }
    }

    public void setData(List<y> list) {
        if (!v.w(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                y yVar = new y();
                yVar.name = this.cIp.getResources().getString(d.j.attention_users_thread);
                yVar.cJT = 6;
                this.mDatas.add(yVar);
            }
            ArrayList arrayList = new ArrayList();
            for (y yVar2 : this.mDatas) {
                if (yVar2 != null) {
                    arrayList.add(yVar2.name);
                }
            }
            reset();
            a(arrayList, this.abK);
        }
    }

    public List<y> anT() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b to() {
        View cl;
        super.to();
        if (this.mDatas != null && (cl = cl(this.mDatas.size())) != null && (cl.findViewById(d.g.dialog_item_btn) instanceof TextView)) {
            aj.i((TextView) cl.findViewById(d.g.dialog_item_btn), d.C0082d.cp_link_tip_a);
        }
        return this;
    }
}
