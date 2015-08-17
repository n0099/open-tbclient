package com.baidu.tieba.frs;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements LiveBroadcastCard.a {
    final /* synthetic */ bz aXQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bz bzVar) {
        this.aXQ = bzVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.LiveBroadcastCard.a
    public boolean zd() {
        BaseActivity baseActivity;
        baseActivity = this.aXQ.aSJ;
        return baseActivity.checkUpIsLogin();
    }
}
