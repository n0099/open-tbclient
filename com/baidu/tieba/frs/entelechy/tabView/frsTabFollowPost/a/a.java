package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c {
    private c.b Sn;
    private FrsActivity bKb;
    int bKl;
    private List<dc> mDatas;

    public a(FrsActivity frsActivity, c.b bVar) {
        super(frsActivity.getActivity());
        this.bKl = 0;
        if (frsActivity != null && bVar != null) {
            this.bKb = frsActivity;
            this.Sn = bVar;
        }
    }

    public void setData(List<dc> list) {
        if (!y.t(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                dc dcVar = new dc();
                dcVar.name = this.bKb.getResources().getString(u.j.attention_users_thread);
                dcVar.bGN = 6;
                this.mDatas.add(dcVar);
            }
            ArrayList arrayList = new ArrayList();
            for (dc dcVar2 : this.mDatas) {
                if (dcVar2 != null) {
                    arrayList.add(dcVar2.name);
                }
            }
            reset();
            a(arrayList, this.Sn);
        }
    }

    public List<dc> Yl() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public c rW() {
        View bT;
        super.rW();
        if (this.mDatas != null && (bT = bT(this.mDatas.size())) != null && (bT.findViewById(u.g.dialog_item_btn) instanceof TextView)) {
            av.j((View) ((TextView) bT.findViewById(u.g.dialog_item_btn)), u.d.cp_link_tip_a);
        }
        return this;
    }
}
