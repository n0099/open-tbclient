package com.baidu.tbadk.editortools.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
/* loaded from: classes.dex */
class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ CommonTabContentView aBo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CommonTabContentView commonTabContentView) {
        this.aBo = commonTabContentView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CommonTabContentView.c cVar;
        CommonTabContentView.b bVar;
        CommonTabContentView.b bVar2;
        CommonTabContentView.c cVar2;
        cVar = this.aBo.aBn;
        if (cVar != null) {
            bVar = this.aBo.aBl;
            if (bVar != null) {
                bVar2 = this.aBo.aBl;
                if (bVar2.H(adapterView) != 0) {
                    i = -1;
                }
                cVar2 = this.aBo.aBn;
                cVar2.a(view, i, j);
            }
        }
    }
}
