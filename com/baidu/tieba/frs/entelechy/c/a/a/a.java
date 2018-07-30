package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends b {
    private b.InterfaceC0101b akR;
    private FrsFragment dnR;
    private int duU;
    private List<x> mDatas;

    public a(FrsFragment frsFragment, b.InterfaceC0101b interfaceC0101b) {
        super(frsFragment.getActivity());
        this.duU = 0;
        if (frsFragment != null && interfaceC0101b != null) {
            this.dnR = frsFragment;
            this.akR = interfaceC0101b;
        }
    }

    public void setData(List<x> list) {
        if (!w.z(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                x xVar = new x();
                xVar.name = this.dnR.getResources().getString(d.j.attention_users_thread);
                xVar.dpu = 6;
                this.mDatas.add(xVar);
            }
            ArrayList arrayList = new ArrayList();
            for (x xVar2 : this.mDatas) {
                if (xVar2 != null) {
                    arrayList.add(xVar2.name);
                }
            }
            reset();
            a(arrayList, this.akR);
        }
    }

    public List<x> axv() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b xi() {
        View cn;
        super.xi();
        if (this.mDatas != null && (cn = cn(this.mDatas.size())) != null && (cn.findViewById(d.g.dialog_item_btn) instanceof TextView)) {
            am.h((TextView) cn.findViewById(d.g.dialog_item_btn), d.C0140d.cp_link_tip_a);
        }
        return this;
    }
}
