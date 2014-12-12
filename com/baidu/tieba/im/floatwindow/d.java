package com.baidu.tieba.im.floatwindow;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FloatingPersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.floatwindow.view.e {
    final /* synthetic */ b aXq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aXq = bVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.view.e
    public void Nj() {
        boolean z;
        boolean z2;
        a aVar;
        z = this.aXq.aXc;
        if (!z) {
            z2 = this.aXq.aXb;
            if (!z2) {
                aVar = this.aXq.aXg;
                ArrayList<UserData> MU = aVar.MU();
                if (MU != null && !MU.isEmpty()) {
                    this.aXq.Nf();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002011, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m255getInst(), MU)));
                }
            }
        }
    }
}
