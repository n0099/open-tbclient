package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c {
    private c.b ZZ;
    private r bVm;
    private int bZn;
    private List<bp> mDatas;

    public a(r rVar, c.b bVar) {
        super(rVar.getActivity());
        this.bZn = 0;
        if (rVar != null && bVar != null) {
            this.bVm = rVar;
            this.ZZ = bVar;
        }
    }

    public void setData(List<bp> list) {
        if (!x.r(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                bp bpVar = new bp();
                bpVar.name = this.bVm.getResources().getString(w.l.attention_users_thread);
                bpVar.bWI = 6;
                this.mDatas.add(bpVar);
            }
            ArrayList arrayList = new ArrayList();
            for (bp bpVar2 : this.mDatas) {
                if (bpVar2 != null) {
                    arrayList.add(bpVar2.name);
                }
            }
            reset();
            a(arrayList, this.ZZ);
        }
    }

    public List<bp> acb() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public c tf() {
        View cf;
        super.tf();
        if (this.mDatas != null && (cf = cf(this.mDatas.size())) != null && (cf.findViewById(w.h.dialog_item_btn) instanceof TextView)) {
            aq.i((TextView) cf.findViewById(w.h.dialog_item_btn), w.e.cp_link_tip_a);
        }
        return this;
    }
}
