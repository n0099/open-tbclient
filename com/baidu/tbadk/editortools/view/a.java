package com.baidu.tbadk.editortools.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
/* loaded from: classes.dex */
class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ CommonTabContentView avT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CommonTabContentView commonTabContentView) {
        this.avT = commonTabContentView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CommonTabContentView.c cVar;
        CommonTabContentView.b bVar;
        CommonTabContentView.b bVar2;
        CommonTabContentView.c cVar2;
        cVar = this.avT.avS;
        if (cVar != null) {
            bVar = this.avT.avQ;
            if (bVar != null) {
                bVar2 = this.avT.avQ;
                if (bVar2.J(adapterView) != 0) {
                    i = -1;
                }
                cVar2 = this.avT.avS;
                cVar2.a(view, i, j);
            }
        }
    }
}
