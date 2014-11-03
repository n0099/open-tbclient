package com.baidu.tieba.bubble;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ s ajt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(s sVar) {
        this.ajt = sVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.ajt != null) {
            this.ajt.yk();
        }
    }
}
