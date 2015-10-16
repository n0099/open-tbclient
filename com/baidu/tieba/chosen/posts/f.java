package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements p.a {
    final /* synthetic */ e aJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aJU = eVar;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        ChosenPostActivity chosenPostActivity;
        chosenPostActivity = this.aJU.aJN;
        chosenPostActivity.Hj().bB(z);
    }
}
