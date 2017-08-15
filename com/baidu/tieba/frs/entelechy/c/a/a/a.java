package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends b {
    private b.InterfaceC0043b abY;
    private f ckZ;
    private int cpm;
    private List<x> mDatas;

    public a(f fVar, b.InterfaceC0043b interfaceC0043b) {
        super(fVar.getActivity());
        this.cpm = 0;
        if (fVar != null && interfaceC0043b != null) {
            this.ckZ = fVar;
            this.abY = interfaceC0043b;
        }
    }

    public void setData(List<x> list) {
        if (!u.v(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                x xVar = new x();
                xVar.name = this.ckZ.getResources().getString(d.l.attention_users_thread);
                xVar.cmw = 6;
                this.mDatas.add(xVar);
            }
            ArrayList arrayList = new ArrayList();
            for (x xVar2 : this.mDatas) {
                if (xVar2 != null) {
                    arrayList.add(xVar2.name);
                }
            }
            reset();
            a(arrayList, this.abY);
        }
    }

    public List<x> ahF() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b tu() {
        View cj;
        super.tu();
        if (this.mDatas != null && (cj = cj(this.mDatas.size())) != null && (cj.findViewById(d.h.dialog_item_btn) instanceof TextView)) {
            ai.i((TextView) cj.findViewById(d.h.dialog_item_btn), d.e.cp_link_tip_a);
        }
        return this;
    }
}
