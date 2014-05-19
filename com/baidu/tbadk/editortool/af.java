package com.baidu.tbadk.editortool;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.message.EmptyMessage;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ ac a;
    private final /* synthetic */ ArrayList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ac acVar, ArrayList arrayList) {
        this.a = acVar;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b = this.b;
        MessageManager.getInstance().dispatchResponsedMessageToUI(new EmptyMessage(MessageTypes.CMD_EMOTIONS_GROUP_CHANGED));
    }
}
