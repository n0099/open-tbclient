package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c {
    private c.b aaa;
    private r cdv;
    private int chw;
    private List<bq> mDatas;

    public a(r rVar, c.b bVar) {
        super(rVar.getActivity());
        this.chw = 0;
        if (rVar != null && bVar != null) {
            this.cdv = rVar;
            this.aaa = bVar;
        }
    }

    public void setData(List<bq> list) {
        if (!z.t(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                bq bqVar = new bq();
                bqVar.name = this.cdv.getResources().getString(w.l.attention_users_thread);
                bqVar.ceQ = 6;
                this.mDatas.add(bqVar);
            }
            ArrayList arrayList = new ArrayList();
            for (bq bqVar2 : this.mDatas) {
                if (bqVar2 != null) {
                    arrayList.add(bqVar2.name);
                }
            }
            reset();
            a(arrayList, this.aaa);
        }
    }

    public List<bq> afT() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public c td() {
        View cf;
        super.td();
        if (this.mDatas != null && (cf = cf(this.mDatas.size())) != null && (cf.findViewById(w.h.dialog_item_btn) instanceof TextView)) {
            as.i((TextView) cf.findViewById(w.h.dialog_item_btn), w.e.cp_link_tip_a);
        }
        return this;
    }
}
