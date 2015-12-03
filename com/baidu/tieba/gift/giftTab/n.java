package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements a.b {
    final /* synthetic */ GiftTabActivity bvt;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(GiftTabActivity giftTabActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.bvt = giftTabActivity;
        this.bvu = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bvu.dismiss();
    }
}
