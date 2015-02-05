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
    final /* synthetic */ b aYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aYL = bVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.view.e
    public void NA() {
        boolean z;
        boolean z2;
        a aVar;
        z = this.aYL.aYx;
        if (!z) {
            z2 = this.aYL.aYw;
            if (!z2) {
                aVar = this.aYL.aYB;
                ArrayList<UserData> Nl = aVar.Nl();
                if (Nl != null && !Nl.isEmpty()) {
                    this.aYL.Nw();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002011, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m255getInst(), Nl)));
                }
            }
        }
    }
}
