package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes20.dex */
public class c {
    private x hYJ;
    private BawuThrones hYK;

    private c() {
    }

    public static c cok() {
        return a.hYL;
    }

    public void a(BawuThrones bawuThrones) {
        this.hYK = bawuThrones;
    }

    public BawuThrones col() {
        return this.hYK;
    }

    public void eG(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.hYJ == null) {
            this.hYJ = new x();
        }
        this.hYJ.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.hYK = null;
        if (this.hYJ != null) {
            this.hYJ.onDestory();
        }
        this.hYJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class a {
        private static c hYL = new c();
    }
}
