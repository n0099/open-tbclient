package com.baidu.tieba.bubble;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Activity activity) {
        this.a = activity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.c();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new at(this.a, true, 23004, "remind")));
    }
}
