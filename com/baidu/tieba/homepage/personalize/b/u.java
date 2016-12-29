package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.homepage.personalize.b.t;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemClickListener {
    final /* synthetic */ t.a crm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t.a aVar) {
        this.crm = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        s sVar;
        s sVar2;
        t tVar;
        s sVar3;
        t tVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.gm()) {
            tVar2 = t.this;
            context = tVar2.mContext;
            com.baidu.adp.lib.util.k.showToast(context, r.j.neterror);
            return;
        }
        sVar = this.crm.crj;
        com.baidu.tieba.homepage.personalize.data.g item = sVar.getItem(i);
        item.crV = !item.crV;
        sVar2 = this.crm.crj;
        sVar2.notifyDataSetChanged();
        tVar = t.this;
        sVar3 = this.crm.crj;
        tVar.b(sVar3.ajo());
        TiebaStatic.log(new at("c10986").ab("obj_name", item.PR));
    }
}
