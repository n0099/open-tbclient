package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.homepage.personalize.b.v;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemClickListener {
    final /* synthetic */ v.a cyp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v.a aVar) {
        this.cyp = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        u uVar;
        u uVar2;
        v vVar;
        u uVar3;
        v vVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.gk()) {
            vVar2 = v.this;
            context = vVar2.mContext;
            com.baidu.adp.lib.util.k.showToast(context, r.l.neterror);
            return;
        }
        uVar = this.cyp.cym;
        com.baidu.tieba.homepage.personalize.data.g item = uVar.getItem(i);
        item.czb = !item.czb;
        uVar2 = this.cyp.cym;
        uVar2.notifyDataSetChanged();
        vVar = v.this;
        uVar3 = this.cyp.cym;
        vVar.b(uVar3.akv());
        TiebaStatic.log(new ar("c10986").ab("obj_name", item.OZ));
    }
}
