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
    final /* synthetic */ v.a crP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v.a aVar) {
        this.crP = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        u uVar;
        u uVar2;
        v vVar;
        u uVar3;
        v vVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.fr()) {
            vVar2 = v.this;
            context = vVar2.mContext;
            com.baidu.adp.lib.util.k.showToast(context, u.j.neterror);
            return;
        }
        uVar = this.crP.crM;
        com.baidu.tieba.homepage.personalize.data.i item = uVar.getItem(i);
        item.csA = !item.csA;
        uVar2 = this.crP.crM;
        uVar2.notifyDataSetChanged();
        vVar = v.this;
        uVar3 = this.crP.crM;
        vVar.b(uVar3.ahh());
        TiebaStatic.log(new ay("c10986").ab("obj_name", item.csz));
    }
}
