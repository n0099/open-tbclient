package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.homepage.personalize.b.x;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements AdapterView.OnItemClickListener {
    final /* synthetic */ x.a cCf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x.a aVar) {
        this.cCf = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        w wVar;
        w wVar2;
        x xVar;
        w wVar3;
        x xVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.hk()) {
            xVar2 = x.this;
            context = xVar2.mContext;
            com.baidu.adp.lib.util.k.showToast(context, w.l.neterror);
            return;
        }
        wVar = this.cCf.cCc;
        com.baidu.tieba.homepage.personalize.data.g item = wVar.getItem(i);
        item.cCO = !item.cCO;
        wVar2 = this.cCf.cCc;
        wVar2.notifyDataSetChanged();
        xVar = x.this;
        wVar3 = this.cCf.cCc;
        xVar.b(wVar3.ajd());
        TiebaStatic.log(new as("c10986").Z("obj_name", item.TB));
    }
}
