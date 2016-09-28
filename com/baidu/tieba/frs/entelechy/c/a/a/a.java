package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c {
    private c.b VV;
    private FrsActivity bWR;
    int bXa;
    private List<cy> mDatas;

    public a(FrsActivity frsActivity, c.b bVar) {
        super(frsActivity.getActivity());
        this.bXa = 0;
        if (frsActivity != null && bVar != null) {
            this.bWR = frsActivity;
            this.VV = bVar;
        }
    }

    public void setData(List<cy> list) {
        if (!y.t(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                cy cyVar = new cy();
                cyVar.name = this.bWR.getResources().getString(r.j.attention_users_thread);
                cyVar.bTi = 6;
                this.mDatas.add(cyVar);
            }
            ArrayList arrayList = new ArrayList();
            for (cy cyVar2 : this.mDatas) {
                if (cyVar2 != null) {
                    arrayList.add(cyVar2.name);
                }
            }
            reset();
            a(arrayList, this.VV);
        }
    }

    public List<cy> adF() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public c tp() {
        View cg;
        super.tp();
        if (this.mDatas != null && (cg = cg(this.mDatas.size())) != null && (cg.findViewById(r.g.dialog_item_btn) instanceof TextView)) {
            av.j((View) ((TextView) cg.findViewById(r.g.dialog_item_btn)), r.d.cp_link_tip_a);
        }
        return this;
    }
}
