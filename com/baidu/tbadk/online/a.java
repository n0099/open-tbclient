package com.baidu.tbadk.online;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
class a implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().sendMessage(new GeOnLineInfoReqMessage());
    }
}
