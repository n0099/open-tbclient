package com.baidu.tieba.frs;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements LiveBroadcastCard.a {
    final /* synthetic */ bv aXL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bv bvVar) {
        this.aXL = bvVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.LiveBroadcastCard.a
    public boolean zo() {
        BaseActivity baseActivity;
        baseActivity = this.aXL.aSX;
        return baseActivity.checkUpIsLogin();
    }
}
