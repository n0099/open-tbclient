package com.baidu.tieba.frs;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements LiveBroadcastCard.a {
    final /* synthetic */ cv bdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cv cvVar) {
        this.bdx = cvVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.LiveBroadcastCard.a
    public boolean zV() {
        BaseActivity baseActivity;
        baseActivity = this.bdx.aXA;
        return baseActivity.checkUpIsLogin();
    }
}
