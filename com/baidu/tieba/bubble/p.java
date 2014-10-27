package com.baidu.tieba.bubble;
/* loaded from: classes.dex */
class p implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ s ajk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(s sVar) {
        this.ajk = sVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (this.ajk != null) {
            this.ajk.yi();
        }
    }
}
