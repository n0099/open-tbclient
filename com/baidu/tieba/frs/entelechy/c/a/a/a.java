package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.frs.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends b {
    private b.InterfaceC0061b abE;
    private g cIy;
    private int cOP;
    private List<z> mDatas;

    public a(g gVar, b.InterfaceC0061b interfaceC0061b) {
        super(gVar.getActivity());
        this.cOP = 0;
        if (gVar != null && interfaceC0061b != null) {
            this.cIy = gVar;
            this.abE = interfaceC0061b;
        }
    }

    public void setData(List<z> list) {
        if (!v.w(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                z zVar = new z();
                zVar.name = this.cIy.getResources().getString(d.j.attention_users_thread);
                zVar.cKd = 6;
                this.mDatas.add(zVar);
            }
            ArrayList arrayList = new ArrayList();
            for (z zVar2 : this.mDatas) {
                if (zVar2 != null) {
                    arrayList.add(zVar2.name);
                }
            }
            reset();
            a(arrayList, this.abE);
        }
    }

    public List<z> aoc() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b tl() {
        View cl;
        super.tl();
        if (this.mDatas != null && (cl = cl(this.mDatas.size())) != null && (cl.findViewById(d.g.dialog_item_btn) instanceof TextView)) {
            aj.i((TextView) cl.findViewById(d.g.dialog_item_btn), d.C0096d.cp_link_tip_a);
        }
        return this;
    }
}
