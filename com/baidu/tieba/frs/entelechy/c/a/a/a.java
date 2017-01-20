package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c {
    private c.b Vd;
    private FrsActivity bMj;
    private int bMs;
    private List<bt> mDatas;

    public a(FrsActivity frsActivity, c.b bVar) {
        super(frsActivity.getActivity());
        this.bMs = 0;
        if (frsActivity != null && bVar != null) {
            this.bMj = frsActivity;
            this.Vd = bVar;
        }
    }

    public void setData(List<bt> list) {
        if (!w.s(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                bt btVar = new bt();
                btVar.name = this.bMj.getResources().getString(r.l.attention_users_thread);
                btVar.bIQ = 6;
                this.mDatas.add(btVar);
            }
            ArrayList arrayList = new ArrayList();
            for (bt btVar2 : this.mDatas) {
                if (btVar2 != null) {
                    arrayList.add(btVar2.name);
                }
            }
            reset();
            a(arrayList, this.Vd);
        }
    }

    public List<bt> aaw() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public c sY() {
        View ch;
        super.sY();
        if (this.mDatas != null && (ch = ch(this.mDatas.size())) != null && (ch.findViewById(r.h.dialog_item_btn) instanceof TextView)) {
            ap.i((View) ((TextView) ch.findViewById(r.h.dialog_item_btn)), r.e.cp_link_tip_a);
        }
        return this;
    }
}
