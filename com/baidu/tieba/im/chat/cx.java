package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ cw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cw cwVar) {
        this.a = cwVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        String a;
        if (aVar != null) {
            cw cwVar = this.a;
            a = this.a.a(str, aVar.l());
            cwVar.a(a);
            return;
        }
        this.a.a(this.a.b.getString(com.baidu.tieba.y.save_error));
    }
}
