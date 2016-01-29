package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.fm;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements TabMenuPopView.a {
    final /* synthetic */ p bpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bpu = pVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, fm fmVar) {
        i iVar;
        i.a aVar;
        i iVar2;
        iVar = this.bpu.bpn;
        if (iVar != null) {
            iVar2 = this.bpu.bpn;
            iVar2.RF();
        }
        aVar = this.bpu.bpr;
        aVar.gM(fmVar.blu);
    }
}
