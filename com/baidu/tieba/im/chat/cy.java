package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ cx a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cx cxVar) {
        this.a = cxVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        String a;
        if (aVar != null) {
            cx cxVar = this.a;
            a = this.a.a(str, aVar.l());
            cxVar.a(a);
            return;
        }
        this.a.a(this.a.b.getString(com.baidu.tieba.u.save_error));
    }
}
