package com.baidu.tieba.guide;

import android.view.ViewGroup;
import com.baidu.tbadk.core.util.br;
import com.baidu.tbadk.core.util.bt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ h a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ViewGroup viewGroup) {
        this.a = hVar;
        this.b = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null) {
            br.a(this.b, false, (bt) new j(this, str));
        }
    }
}
