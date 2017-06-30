package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.homepage.personalize.b.x;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements AdapterView.OnItemClickListener {
    final /* synthetic */ x.a cKd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x.a aVar) {
        this.cKd = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        w wVar;
        w wVar2;
        x xVar;
        w wVar3;
        x xVar2;
        Context context;
        if (!com.baidu.adp.lib.util.i.hj()) {
            xVar2 = x.this;
            context = xVar2.mContext;
            com.baidu.adp.lib.util.k.showToast(context, w.l.neterror);
            return;
        }
        wVar = this.cKd.cKa;
        com.baidu.tieba.homepage.personalize.data.g item = wVar.getItem(i);
        item.isSelect = !item.isSelect;
        wVar2 = this.cKd.cKa;
        wVar2.notifyDataSetChanged();
        xVar = x.this;
        wVar3 = this.cKd.cKa;
        xVar.b(wVar3.amP());
        TiebaStatic.log(new au("c10986").Z("obj_name", item.Tw));
    }
}
