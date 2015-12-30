package com.baidu.tieba.frs;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db implements LiveBroadcastCard.a {
    final /* synthetic */ cy bhx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(cy cyVar) {
        this.bhx = cyVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.LiveBroadcastCard.a
    public boolean zH() {
        BaseActivity baseActivity;
        baseActivity = this.bhx.bbA;
        return baseActivity.checkUpIsLogin();
    }
}
