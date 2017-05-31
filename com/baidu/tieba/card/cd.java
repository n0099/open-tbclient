package com.baidu.tieba.card;

import android.view.View;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements com.baidu.tbadk.widget.layout.g {
    private final /* synthetic */ LinkedList bBv;
    private final /* synthetic */ com.baidu.tbadk.core.data.bl bBw;
    final /* synthetic */ bu bCs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bu buVar, LinkedList linkedList, com.baidu.tbadk.core.data.bl blVar) {
        this.bCs = buVar;
        this.bBv = linkedList;
        this.bBw = blVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        if (z) {
            this.bCs.Ur();
        } else {
            this.bCs.a(this.bBv, i, this.bBw);
        }
    }
}
