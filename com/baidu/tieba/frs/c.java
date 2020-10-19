package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes21.dex */
public class c {
    private x inK;
    private BawuThrones inL;

    private c() {
    }

    public static c crI() {
        return a.inM;
    }

    public void a(BawuThrones bawuThrones) {
        this.inL = bawuThrones;
    }

    public BawuThrones crJ() {
        return this.inL;
    }

    public void eN(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.inK == null) {
            this.inK = new x();
        }
        this.inK.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.inL = null;
        if (this.inK != null) {
            this.inK.onDestory();
        }
        this.inK = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static class a {
        private static c inM = new c();
    }
}
