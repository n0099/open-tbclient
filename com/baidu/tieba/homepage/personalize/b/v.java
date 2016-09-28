package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.homepage.personalize.b.u;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements AdapterView.OnItemClickListener {
    final /* synthetic */ u.a cGR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u.a aVar) {
        this.cGR = aVar;
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
        tVar = this.cGR.cGO;
        com.baidu.tieba.homepage.personalize.data.i item = tVar.getItem(i);
        item.cHD = !item.cHD;
        tVar2 = this.cGR.cGO;
        tVar2.notifyDataSetChanged();
        uVar = u.this;
        tVar3 = this.cGR.cGO;
        uVar.b(tVar3.amT());
        TiebaStatic.log(new ax("c10986").ab("obj_name", item.PC));
    }
}
