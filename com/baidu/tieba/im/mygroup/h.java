package com.baidu.tieba.im.mygroup;

import android.view.View;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ PersonGroupActivity bfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonGroupActivity personGroupActivity) {
        this.bfQ = personGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AddGroupActivity.k(this.bfQ);
    }
}
