package com.baidu.tieba.history;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class PbHistoryStatic {
    private static com.baidu.tbadk.mainTab.f aPi;

    static {
        g gVar = new g(2007007);
        gVar.setPriority(2);
        MessageManager.getInstance().registerListener(gVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001274));
    }
}
