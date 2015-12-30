package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.view.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements r.a {
    final /* synthetic */ e aRi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aRi = eVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        ChosenPostActivity chosenPostActivity;
        chosenPostActivity = this.aRi.aRb;
        chosenPostActivity.IN().bP(z);
    }
}
