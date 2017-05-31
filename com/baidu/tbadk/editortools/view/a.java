package com.baidu.tbadk.editortools.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
/* loaded from: classes.dex */
class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ CommonTabContentView aBs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CommonTabContentView commonTabContentView) {
        this.aBs = commonTabContentView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CommonTabContentView.c cVar;
        CommonTabContentView.b bVar;
        CommonTabContentView.b bVar2;
        CommonTabContentView.c cVar2;
        cVar = this.aBs.aBr;
        if (cVar != null) {
            bVar = this.aBs.aBp;
            if (bVar != null) {
                bVar2 = this.aBs.aBp;
                if (bVar2.G(adapterView) != 0) {
                    i = -1;
                }
                cVar2 = this.aBs.aBr;
                cVar2.a(view, i, j);
            }
        }
    }
}
