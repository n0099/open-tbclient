package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c {
    private c.b aaE;
    private FrsActivity bTd;
    private int bTm;
    private List<bv> mDatas;

    public a(FrsActivity frsActivity, c.b bVar) {
        super(frsActivity.getActivity());
        this.bTm = 0;
        if (frsActivity != null && bVar != null) {
            this.bTd = frsActivity;
            this.aaE = bVar;
        }
    }

    public void setData(List<bv> list) {
        if (!x.q(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                bv bvVar = new bv();
                bvVar.name = this.bTd.getResources().getString(w.l.attention_users_thread);
                bvVar.bPO = 6;
                this.mDatas.add(bvVar);
            }
            ArrayList arrayList = new ArrayList();
            for (bv bvVar2 : this.mDatas) {
                if (bvVar2 != null) {
                    arrayList.add(bvVar2.name);
                }
            }
            reset();
            a(arrayList, this.aaE);
        }
    }

    public List<bv> abP() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public c tT() {
        View cg;
        super.tT();
        if (this.mDatas != null && (cg = cg(this.mDatas.size())) != null && (cg.findViewById(w.h.dialog_item_btn) instanceof TextView)) {
            aq.i((TextView) cg.findViewById(w.h.dialog_item_btn), w.e.cp_link_tip_a);
        }
        return this;
    }
}
