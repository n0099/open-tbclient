package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.homepage.personalize.b.v;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemClickListener {
    final /* synthetic */ v.a cyl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v.a aVar) {
        this.cyl = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        u uVar;
        u uVar2;
        v vVar;
        u uVar3;
        v vVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.hj()) {
            vVar2 = v.this;
            context = vVar2.mContext;
            com.baidu.adp.lib.util.k.showToast(context, w.l.neterror);
            return;
        }
        uVar = this.cyl.cyi;
        com.baidu.tieba.homepage.personalize.data.g item = uVar.getItem(i);
        item.cyX = !item.cyX;
        uVar2 = this.cyl.cyi;
        uVar2.notifyDataSetChanged();
        vVar = v.this;
        uVar3 = this.cyl.cyi;
        vVar.b(uVar3.ajB());
        TiebaStatic.log(new as("c10986").aa("obj_name", item.Uu));
    }
}
