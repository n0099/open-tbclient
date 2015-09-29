package com.baidu.tieba.frs;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements LiveBroadcastCard.a {
    final /* synthetic */ cf aXf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cf cfVar) {
        this.aXf = cfVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.LiveBroadcastCard.a
    public boolean yX() {
        BaseActivity baseActivity;
        baseActivity = this.aXf.aRT;
        return baseActivity.checkUpIsLogin();
    }
}
