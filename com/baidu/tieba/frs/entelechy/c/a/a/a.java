package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c {
    private c.b Wt;
    private FrsActivity cai;
    private int car;
    private List<bw> mDatas;

    public a(FrsActivity frsActivity, c.b bVar) {
        super(frsActivity.getActivity());
        this.car = 0;
        if (frsActivity != null && bVar != null) {
            this.cai = frsActivity;
            this.Wt = bVar;
        }
    }

    public void setData(List<bw> list) {
        if (!x.t(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                bw bwVar = new bw();
                bwVar.name = this.cai.getResources().getString(r.j.attention_users_thread);
                bwVar.bVo = 6;
                this.mDatas.add(bwVar);
            }
            ArrayList arrayList = new ArrayList();
            for (bw bwVar2 : this.mDatas) {
                if (bwVar2 != null) {
                    arrayList.add(bwVar2.name);
                }
            }
            reset();
            a(arrayList, this.Wt);
        }
    }

    public List<bw> aeY() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public c tt() {
        View ch;
        super.tt();
        if (this.mDatas != null && (ch = ch(this.mDatas.size())) != null && (ch.findViewById(r.g.dialog_item_btn) instanceof TextView)) {
            at.j((View) ((TextView) ch.findViewById(r.g.dialog_item_btn)), r.d.cp_link_tip_a);
        }
        return this;
    }
}
