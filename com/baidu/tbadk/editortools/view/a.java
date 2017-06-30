package com.baidu.tbadk.editortools.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
/* loaded from: classes.dex */
class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ CommonTabContentView aCv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CommonTabContentView commonTabContentView) {
        this.aCv = commonTabContentView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CommonTabContentView.c cVar;
        CommonTabContentView.b bVar;
        CommonTabContentView.b bVar2;
        CommonTabContentView.c cVar2;
        cVar = this.aCv.aCu;
        if (cVar != null) {
            bVar = this.aCv.aCs;
            if (bVar != null) {
                bVar2 = this.aCv.aCs;
                if (bVar2.H(adapterView) != 0) {
                    i = -1;
                }
                cVar2 = this.aCv.aCu;
                cVar2.a(view, i, j);
            }
        }
    }
}
