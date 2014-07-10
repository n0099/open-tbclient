package com.baidu.tieba.bubble;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(s sVar) {
        this.a = sVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.c();
        if (this.a != null) {
            this.a.a();
        }
    }
}
