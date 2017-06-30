package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements BdListView.d {
    final /* synthetic */ i cIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(i iVar) {
        this.cIQ = iVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.d
    public void onScrollStop(int i, int i2) {
        long j;
        x xVar;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.cIQ.cIM;
        if (currentTimeMillis - j >= TbConfig.NOTIFY_SOUND_INTERVAL) {
            xVar = this.cIQ.cIH;
            xVar.ay(i, i2);
        }
    }
}
