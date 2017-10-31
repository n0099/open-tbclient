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
    private b.InterfaceC0047b abo;
    private int cFf;
    private f cyR;
    private List<y> mDatas;

    public a(f fVar, b.InterfaceC0047b interfaceC0047b) {
        super(fVar.getActivity());
        this.cFf = 0;
        if (fVar != null && interfaceC0047b != null) {
            this.cyR = fVar;
            this.abo = interfaceC0047b;
        }
    }

    public void setData(List<y> list) {
        if (!v.v(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                y yVar = new y();
                yVar.name = this.cyR.getResources().getString(d.j.attention_users_thread);
                yVar.cAw = 6;
                this.mDatas.add(yVar);
            }
            ArrayList arrayList = new ArrayList();
            for (y yVar2 : this.mDatas) {
                if (yVar2 != null) {
                    arrayList.add(yVar2.name);
                }
            }
            reset();
            a(arrayList, this.abo);
        }
    }

    public List<y> alK() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b tl() {
        View ck;
        super.tl();
        if (this.mDatas != null && (ck = ck(this.mDatas.size())) != null && (ck.findViewById(d.g.dialog_item_btn) instanceof TextView)) {
            aj.i((TextView) ck.findViewById(d.g.dialog_item_btn), d.C0080d.cp_link_tip_a);
        }
        return this;
    }
}
