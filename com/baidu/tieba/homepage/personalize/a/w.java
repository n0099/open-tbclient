package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.homepage.personalize.a.v;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemClickListener {
    final /* synthetic */ v.a cuz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v.a aVar) {
        this.cuz = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        u uVar;
        u uVar2;
        v vVar;
        u uVar3;
        v vVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.fq()) {
            vVar2 = v.this;
            context = vVar2.mContext;
            com.baidu.adp.lib.util.k.showToast(context, u.j.neterror);
            return;
        }
        uVar = this.cuz.cuw;
        com.baidu.tieba.homepage.personalize.data.i item = uVar.getItem(i);
        item.cvk = !item.cvk;
        uVar2 = this.cuz.cuw;
        uVar2.notifyDataSetChanged();
        vVar = v.this;
        uVar3 = this.cuz.cuw;
        vVar.b(uVar3.ahQ());
        TiebaStatic.log(new ay("c10986").ab("obj_name", item.cvj));
    }
}
