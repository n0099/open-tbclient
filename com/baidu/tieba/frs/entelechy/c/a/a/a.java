package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends b {
    private b.InterfaceC0047b abd;
    private f cqt;
    private int cvS;
    private List<x> mDatas;

    public a(f fVar, b.InterfaceC0047b interfaceC0047b) {
        super(fVar.getActivity());
        this.cvS = 0;
        if (fVar != null && interfaceC0047b != null) {
            this.cqt = fVar;
            this.abd = interfaceC0047b;
        }
    }

    public void setData(List<x> list) {
        if (!v.v(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                x xVar = new x();
                xVar.name = this.cqt.getResources().getString(d.l.attention_users_thread);
                xVar.crR = 6;
                this.mDatas.add(xVar);
            }
            ArrayList arrayList = new ArrayList();
            for (x xVar2 : this.mDatas) {
                if (xVar2 != null) {
                    arrayList.add(xVar2.name);
                }
            }
            reset();
            a(arrayList, this.abd);
        }
    }

    public List<x> ajm() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b tr() {
        View cj;
        super.tr();
        if (this.mDatas != null && (cj = cj(this.mDatas.size())) != null && (cj.findViewById(d.h.dialog_item_btn) instanceof TextView)) {
            aj.i((TextView) cj.findViewById(d.h.dialog_item_btn), d.e.cp_link_tip_a);
        }
        return this;
    }
}
