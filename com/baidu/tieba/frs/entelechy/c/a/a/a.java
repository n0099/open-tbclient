package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c {
    private c.b aao;
    private FrsActivity bTp;
    private int bTy;
    private List<bt> mDatas;

    public a(FrsActivity frsActivity, c.b bVar) {
        super(frsActivity.getActivity());
        this.bTy = 0;
        if (frsActivity != null && bVar != null) {
            this.bTp = frsActivity;
            this.aao = bVar;
        }
    }

    public void setData(List<bt> list) {
        if (!x.q(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                bt btVar = new bt();
                btVar.name = this.bTp.getResources().getString(w.l.attention_users_thread);
                btVar.bPZ = 6;
                this.mDatas.add(btVar);
            }
            ArrayList arrayList = new ArrayList();
            for (bt btVar2 : this.mDatas) {
                if (btVar2 != null) {
                    arrayList.add(btVar2.name);
                }
            }
            reset();
            a(arrayList, this.aao);
        }
    }

    public List<bt> abt() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public c tv() {
        View cd;
        super.tv();
        if (this.mDatas != null && (cd = cd(this.mDatas.size())) != null && (cd.findViewById(w.h.dialog_item_btn) instanceof TextView)) {
            aq.i((View) ((TextView) cd.findViewById(w.h.dialog_item_btn)), w.e.cp_link_tip_a);
        }
        return this;
    }
}
