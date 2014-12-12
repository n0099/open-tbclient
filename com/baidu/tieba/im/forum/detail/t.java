package com.baidu.tieba.im.forum.detail;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ ItemFootNavView aZz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ItemFootNavView itemFootNavView) {
        this.aZz = itemFootNavView;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar2 = this.aZz.aZy;
        aVar2.dismiss();
    }
}
