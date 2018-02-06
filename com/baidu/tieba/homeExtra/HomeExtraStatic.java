package com.baidu.tieba.homeExtra;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class HomeExtraStatic {
    static {
        MessageManager.getInstance().registerTask(new a());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001407, true));
    }
}
