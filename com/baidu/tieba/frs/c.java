package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes21.dex */
public class c {
    private x iAg;
    private BawuThrones iAh;

    private c() {
    }

    public static c cuP() {
        return a.iAi;
    }

    public void a(BawuThrones bawuThrones) {
        this.iAh = bawuThrones;
    }

    public BawuThrones cuQ() {
        return this.iAh;
    }

    public void eS(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.iAg == null) {
            this.iAg = new x();
        }
        this.iAg.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.iAh = null;
        if (this.iAg != null) {
            this.iAg.onDestory();
        }
        this.iAg = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static class a {
        private static c iAi = new c();
    }
}
