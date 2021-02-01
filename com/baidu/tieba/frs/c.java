package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes.dex */
public class c {
    private v jeX;
    private BawuThrones jeY;

    private c() {
    }

    public static c cBv() {
        return a.jeZ;
    }

    public void a(BawuThrones bawuThrones) {
        this.jeY = bawuThrones;
    }

    public BawuThrones cBw() {
        return this.jeY;
    }

    public void eX(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.jeX == null) {
            this.jeX = new v();
        }
        this.jeX.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.jeY = null;
        if (this.jeX != null) {
            this.jeX.onDestory();
        }
        this.jeX = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c jeZ = new c();
    }
}
