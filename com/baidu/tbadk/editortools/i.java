package com.baidu.tbadk.editortools;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ h aqp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aqp = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        w wVar;
        w wVar2;
        wVar = this.aqp.aql;
        if (wVar != null) {
            wVar2 = this.aqp.aql;
            wVar2.ov();
        }
    }
}
