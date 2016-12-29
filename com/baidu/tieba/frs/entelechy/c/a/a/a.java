package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c {
    private c.b VN;
    private FrsActivity bFS;
    private int bGb;
    private List<bv> mDatas;

    public a(FrsActivity frsActivity, c.b bVar) {
        super(frsActivity.getActivity());
        this.bGb = 0;
        if (frsActivity != null && bVar != null) {
            this.bFS = frsActivity;
            this.VN = bVar;
        }
    }

    public void setData(List<bv> list) {
        if (!x.t(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                bv bvVar = new bv();
                bvVar.name = this.bFS.getResources().getString(r.j.attention_users_thread);
                bvVar.bBw = 6;
                this.mDatas.add(bvVar);
            }
            ArrayList arrayList = new ArrayList();
            for (bv bvVar2 : this.mDatas) {
                if (bvVar2 != null) {
                    arrayList.add(bvVar2.name);
                }
            }
            reset();
            a(arrayList, this.VN);
        }
    }

    public List<bv> Zt() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public c te() {
        View ci;
        super.te();
        if (this.mDatas != null && (ci = ci(this.mDatas.size())) != null && (ci.findViewById(r.g.dialog_item_btn) instanceof TextView)) {
            ar.j((View) ((TextView) ci.findViewById(r.g.dialog_item_btn)), r.d.cp_link_tip_a);
        }
        return this;
    }
}
