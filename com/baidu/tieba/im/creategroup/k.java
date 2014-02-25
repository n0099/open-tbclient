package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.mygroup.MyGroupActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnClickListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        CreateGroupStepActivity createGroupStepActivity;
        CreateGroupStepActivity createGroupStepActivity2;
        createGroupStepActivity = this.a.a;
        createGroupStepActivity.finish();
        createGroupStepActivity2 = this.a.a;
        MyGroupActivity.a(createGroupStepActivity2);
    }
}
