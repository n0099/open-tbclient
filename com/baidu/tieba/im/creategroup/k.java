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
        int i2;
        CreateGroupStepActivity createGroupStepActivity2;
        CreateGroupStepActivity createGroupStepActivity3;
        createGroupStepActivity = this.a.a;
        i2 = createGroupStepActivity.c;
        if (1012 != i2) {
            createGroupStepActivity3 = this.a.a;
            MyGroupActivity.a(createGroupStepActivity3);
        }
        createGroupStepActivity2 = this.a.a;
        createGroupStepActivity2.finish();
    }
}
