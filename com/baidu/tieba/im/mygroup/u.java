package com.baidu.tieba.im.mygroup;

import android.view.View;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PersonGroupActivity personGroupActivity) {
        this.a = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AddGroupActivity.a(this.a);
    }
}
