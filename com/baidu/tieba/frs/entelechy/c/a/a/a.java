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
    private b.InterfaceC0073b aQa;
    private i dCx;
    private int dIk;
    private List<z> mDatas;

    public a(i iVar, b.InterfaceC0073b interfaceC0073b) {
        super(iVar.getActivity());
        this.dIk = 0;
        if (iVar != null && interfaceC0073b != null) {
            this.dCx = iVar;
            this.aQa = interfaceC0073b;
        }
    }

    public void setData(List<z> list) {
        if (!v.E(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                z zVar = new z();
                zVar.name = this.dCx.getResources().getString(d.j.attention_users_thread);
                zVar.dDP = 6;
                this.mDatas.add(zVar);
            }
            ArrayList arrayList = new ArrayList();
            for (z zVar2 : this.mDatas) {
                if (zVar2 != null) {
                    arrayList.add(zVar2.name);
                }
            }
            reset();
            a(arrayList, this.aQa);
        }
    }

    public List<z> awE() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b AD() {
        View fj;
        super.AD();
        if (this.mDatas != null && (fj = fj(this.mDatas.size())) != null && (fj.findViewById(d.g.dialog_item_btn) instanceof TextView)) {
            aj.r((TextView) fj.findViewById(d.g.dialog_item_btn), d.C0107d.cp_link_tip_a);
        }
        return this;
    }
}
