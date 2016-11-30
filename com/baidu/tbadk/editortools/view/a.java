package com.baidu.tbadk.editortools.view;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
/* loaded from: classes.dex */
class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ CommonTabContentView axs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CommonTabContentView commonTabContentView) {
        this.axs = commonTabContentView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CommonTabContentView.c cVar;
        CommonTabContentView.b bVar;
        CommonTabContentView.b bVar2;
        CommonTabContentView.c cVar2;
        cVar = this.axs.axr;
        if (cVar != null) {
            bVar = this.axs.axp;
            if (bVar != null) {
                bVar2 = this.axs.axp;
                if (bVar2.L(adapterView) != 0) {
                    i = -1;
                }
                cVar2 = this.axs.axr;
                cVar2.a(view, i, j);
            }
        }
    }
}
