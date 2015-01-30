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
    final /* synthetic */ b aYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aYM = bVar;
    }

    @Override // com.baidu.tieba.im.floatwindow.view.e
    public void NF() {
        boolean z;
        boolean z2;
        a aVar;
        z = this.aYM.aYy;
        if (!z) {
            z2 = this.aYM.aYx;
            if (!z2) {
                aVar = this.aYM.aYC;
                ArrayList<UserData> Nq = aVar.Nq();
                if (Nq != null && !Nq.isEmpty()) {
                    this.aYM.NB();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002011, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m255getInst(), Nq)));
                }
            }
        }
    }
}
