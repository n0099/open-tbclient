package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes15.dex */
public class c {
    private w hEp;
    private BawuThrones hEq;

    private c() {
    }

    public static c caA() {
        return a.hEr;
    }

    public void a(BawuThrones bawuThrones) {
        this.hEq = bawuThrones;
    }

    public BawuThrones caB() {
        return this.hEq;
    }

    public void ek(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.hEp == null) {
            this.hEp = new w();
        }
        this.hEp.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.hEq = null;
        if (this.hEp != null) {
            this.hEp.onDestory();
        }
        this.hEp = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a {
        private static c hEr = new c();
    }
}
