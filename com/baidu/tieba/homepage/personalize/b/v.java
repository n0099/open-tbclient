package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.homepage.personalize.b.u;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements AdapterView.OnItemClickListener {
    final /* synthetic */ u.a cMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u.a aVar) {
        this.cMc = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        t tVar;
        t tVar2;
        u uVar;
        t tVar3;
        u uVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.gm()) {
            uVar2 = u.this;
            context = uVar2.mContext;
            com.baidu.adp.lib.util.k.showToast(context, r.j.neterror);
            return;
        }
        tVar = this.cMc.cLZ;
        com.baidu.tieba.homepage.personalize.data.i item = tVar.getItem(i);
        item.cMQ = !item.cMQ;
        tVar2 = this.cMc.cLZ;
        tVar2.notifyDataSetChanged();
        uVar = u.this;
        tVar3 = this.cMc.cLZ;
        uVar.b(tVar3.aoN());
        TiebaStatic.log(new av("c10986").ab("obj_name", item.PW));
    }
}
