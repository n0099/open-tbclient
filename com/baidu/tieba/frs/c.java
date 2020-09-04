package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes15.dex */
public class c {
    private x hRJ;
    private BawuThrones hRK;

    private c() {
    }

    public static c ckX() {
        return a.hRL;
    }

    public void a(BawuThrones bawuThrones) {
        this.hRK = bawuThrones;
    }

    public BawuThrones ckY() {
        return this.hRK;
    }

    public void eC(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.hRJ == null) {
            this.hRJ = new x();
        }
        this.hRJ.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.hRK = null;
        if (this.hRJ != null) {
            this.hRJ.onDestory();
        }
        this.hRJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a {
        private static c hRL = new c();
    }
}
