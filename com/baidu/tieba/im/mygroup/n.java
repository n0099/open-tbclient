package com.baidu.tieba.im.mygroup;

import android.view.View;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MyGroupActivity myGroupActivity;
        myGroupActivity = this.a.a;
        AddGroupActivity.a(myGroupActivity);
    }
}
