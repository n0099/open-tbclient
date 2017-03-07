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
    final /* synthetic */ v.a czL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v.a aVar) {
        this.czL = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        u uVar;
        u uVar2;
        v vVar;
        u uVar3;
        v vVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.he()) {
            vVar2 = v.this;
            context = vVar2.mContext;
            com.baidu.adp.lib.util.k.showToast(context, w.l.neterror);
            return;
        }
        uVar = this.czL.czI;
        com.baidu.tieba.homepage.personalize.data.g item = uVar.getItem(i);
        item.cAx = !item.cAx;
        uVar2 = this.czL.czI;
        uVar2.notifyDataSetChanged();
        vVar = v.this;
        uVar3 = this.czL.czI;
        vVar.b(uVar3.ajH());
        TiebaStatic.log(new as("c10986").Z("obj_name", item.Uc));
    }
}
