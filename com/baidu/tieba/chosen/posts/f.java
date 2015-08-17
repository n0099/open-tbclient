package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.view.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements x.a {
    final /* synthetic */ e aKD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aKD = eVar;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        ChosenPostActivity chosenPostActivity;
        chosenPostActivity = this.aKD.aKw;
        chosenPostActivity.HB().bz(z);
    }
}
