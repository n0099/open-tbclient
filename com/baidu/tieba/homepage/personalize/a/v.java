package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.homepage.personalize.a.u;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements AdapterView.OnItemClickListener {
    final /* synthetic */ u.a cGd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u.a aVar) {
        this.cGd = aVar;
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
            com.baidu.adp.lib.util.k.showToast(context, t.j.neterror);
            return;
        }
        tVar = this.cGd.cGa;
        com.baidu.tieba.homepage.personalize.data.i item = tVar.getItem(i);
        item.cGO = !item.cGO;
        tVar2 = this.cGd.cGa;
        tVar2.notifyDataSetChanged();
        uVar = u.this;
        tVar3 = this.cGd.cGa;
        uVar.b(tVar3.amF());
        TiebaStatic.log(new ay("c10986").ab("obj_name", item.PE));
    }
}
