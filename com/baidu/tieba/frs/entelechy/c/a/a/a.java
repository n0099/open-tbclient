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
    private b.InterfaceC0043b aaz;
    private f cjg;
    private int cns;
    private List<x> mDatas;

    public a(f fVar, b.InterfaceC0043b interfaceC0043b) {
        super(fVar.getActivity());
        this.cns = 0;
        if (fVar != null && interfaceC0043b != null) {
            this.cjg = fVar;
            this.aaz = interfaceC0043b;
        }
    }

    public void setData(List<x> list) {
        if (!u.v(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                x xVar = new x();
                xVar.name = this.cjg.getResources().getString(d.l.attention_users_thread);
                xVar.ckC = 6;
                this.mDatas.add(xVar);
            }
            ArrayList arrayList = new ArrayList();
            for (x xVar2 : this.mDatas) {
                if (xVar2 != null) {
                    arrayList.add(xVar2.name);
                }
            }
            reset();
            a(arrayList, this.aaz);
        }
    }

    public List<x> ahd() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b tk() {
        View ch;
        super.tk();
        if (this.mDatas != null && (ch = ch(this.mDatas.size())) != null && (ch.findViewById(d.h.dialog_item_btn) instanceof TextView)) {
            ai.i((TextView) ch.findViewById(d.h.dialog_item_btn), d.e.cp_link_tip_a);
        }
        return this;
    }
}
