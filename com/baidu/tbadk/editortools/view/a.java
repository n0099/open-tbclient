package com.baidu.tbadk.editortools.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
/* loaded from: classes.dex */
class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ CommonTabContentView awP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CommonTabContentView commonTabContentView) {
        this.awP = commonTabContentView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CommonTabContentView.c cVar;
        CommonTabContentView.b bVar;
        CommonTabContentView.b bVar2;
        CommonTabContentView.c cVar2;
        cVar = this.awP.awO;
        if (cVar != null) {
            bVar = this.awP.awM;
            if (bVar != null) {
                bVar2 = this.awP.awM;
                if (bVar2.L(adapterView) != 0) {
                    i = -1;
                }
                cVar2 = this.awP.awO;
                cVar2.a(view, i, j);
            }
        }
    }
}
