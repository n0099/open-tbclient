package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes20.dex */
public class c {
    private x iGR;
    private BawuThrones iGS;

    private c() {
    }

    public static c cwS() {
        return a.iGT;
    }

    public void a(BawuThrones bawuThrones) {
        this.iGS = bawuThrones;
    }

    public BawuThrones cwT() {
        return this.iGS;
    }

    public void eS(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.iGR == null) {
            this.iGR = new x();
        }
        this.iGR.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.iGS = null;
        if (this.iGR != null) {
            this.iGR.onDestory();
        }
        this.iGR = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class a {
        private static c iGT = new c();
    }
}
