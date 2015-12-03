package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements q.a {
    final /* synthetic */ e aNp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aNp = eVar;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        ChosenPostActivity chosenPostActivity;
        chosenPostActivity = this.aNp.aNi;
        chosenPostActivity.Iv().bO(z);
    }
}
