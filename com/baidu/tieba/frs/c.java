package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes21.dex */
public class c {
    private w iRJ;
    private BawuThrones iRK;

    private c() {
    }

    public static c cBh() {
        return a.iRL;
    }

    public void a(BawuThrones bawuThrones) {
        this.iRK = bawuThrones;
    }

    public BawuThrones cBi() {
        return this.iRK;
    }

    public void eX(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.iRJ == null) {
            this.iRJ = new w();
        }
        this.iRJ.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.iRK = null;
        if (this.iRJ != null) {
            this.iRJ.onDestory();
        }
        this.iRJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static class a {
        private static c iRL = new c();
    }
}
