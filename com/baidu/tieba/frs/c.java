package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes15.dex */
public class c {
    private x hRD;
    private BawuThrones hRE;

    private c() {
    }

    public static c ckW() {
        return a.hRF;
    }

    public void a(BawuThrones bawuThrones) {
        this.hRE = bawuThrones;
    }

    public BawuThrones ckX() {
        return this.hRE;
    }

    public void eB(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.hRD == null) {
            this.hRD = new x();
        }
        this.hRD.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.hRE = null;
        if (this.hRD != null) {
            this.hRD.onDestory();
        }
        this.hRD = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a {
        private static c hRF = new c();
    }
}
