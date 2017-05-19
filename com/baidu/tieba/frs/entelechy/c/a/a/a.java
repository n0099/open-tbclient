package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c {
    private c.b aaa;
    private r bPw;
    private int bTv;
    private List<bo> mDatas;

    public a(r rVar, c.b bVar) {
        super(rVar.getActivity());
        this.bTv = 0;
        if (rVar != null && bVar != null) {
            this.bPw = rVar;
            this.aaa = bVar;
        }
    }

    public void setData(List<bo> list) {
        if (!x.r(list)) {
            this.mDatas = new ArrayList();
            this.mDatas.addAll(list);
            if (TbadkCoreApplication.isLogin()) {
                bo boVar = new bo();
                boVar.name = this.bPw.getResources().getString(w.l.attention_users_thread);
                boVar.bQR = 6;
                this.mDatas.add(boVar);
            }
            ArrayList arrayList = new ArrayList();
            for (bo boVar2 : this.mDatas) {
                if (boVar2 != null) {
                    arrayList.add(boVar2.name);
                }
            }
            reset();
            a(arrayList, this.aaa);
        }
    }

    public List<bo> aaX() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.c
    public c tg() {
        View ce;
        super.tg();
        if (this.mDatas != null && (ce = ce(this.mDatas.size())) != null && (ce.findViewById(w.h.dialog_item_btn) instanceof TextView)) {
            aq.i((TextView) ce.findViewById(w.h.dialog_item_btn), w.e.cp_link_tip_a);
        }
        return this;
    }
}
