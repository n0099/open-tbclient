package com.baidu.tieba.im.forum.detail;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ ItemFootNavView baV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ItemFootNavView itemFootNavView) {
        this.baV = itemFootNavView;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar2 = this.baV.baU;
        aVar2.dismiss();
    }
}
