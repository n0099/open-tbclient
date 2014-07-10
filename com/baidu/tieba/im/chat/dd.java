package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ dc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(dc dcVar) {
        this.a = dcVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        String a;
        if (aVar != null) {
            dc dcVar = this.a;
            a = this.a.a(str, aVar.l());
            dcVar.a(a);
            return;
        }
        this.a.a(this.a.b.getString(com.baidu.tieba.y.save_error));
    }
}
