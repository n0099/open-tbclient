package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.em;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c {
    private c.b RV;
    int bpC;
    private com.baidu.adp.framework.listener.a bpD;
    private FrsActivity bpt;
    private List<em> mDatas;

    public a(FrsActivity frsActivity, c.b bVar) {
        super(frsActivity.getActivity());
        this.bpC = 0;
        this.bpD = new b(this, CmdConfigHttp.GET_FRS_TAB_FOLLOW_POST_NUM, 309346);
        if (frsActivity != null && bVar != null) {
            this.bpt = frsActivity;
            this.RV = bVar;
            this.bpD.setTag(frsActivity.getUniqueId());
            if (this.bpD.bm() != null) {
                this.bpD.bm().setSelfListener(true);
            }
            if (this.bpD.bn() != null) {
                this.bpD.bn().setSelfListener(true);
            }
            MessageManager.getInstance().registerListener(this.bpD);
        }
    }

    public void setData(List<em> list) {
        if (!y.s(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (this.bpC != 0) {
                em emVar = new em();
                emVar.name = this.bpt.getResources().getString(t.j.attention_users_thread);
                emVar.blZ = 6;
                this.mDatas.add(emVar);
            }
            ArrayList arrayList = new ArrayList();
            for (em emVar2 : this.mDatas) {
                if (emVar2 != null) {
                    arrayList.add(emVar2.name);
                }
            }
            reset();
            a(arrayList, this.RV);
        }
    }

    public List<em> SK() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public c rY() {
        View bS;
        super.rY();
        if (this.mDatas != null && (bS = bS(this.mDatas.size())) != null && (bS.findViewById(t.g.dialog_item_btn) instanceof TextView)) {
            at.j((View) ((TextView) bS.findViewById(t.g.dialog_item_btn)), t.d.cp_link_tip_a);
        }
        return this;
    }
}
