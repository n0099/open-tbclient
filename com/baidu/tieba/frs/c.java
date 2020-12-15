package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes21.dex */
public class c {
    private w iRL;
    private BawuThrones iRM;

    private c() {
    }

    public static c cBi() {
        return a.iRN;
    }

    public void a(BawuThrones bawuThrones) {
        this.iRM = bawuThrones;
    }

    public BawuThrones cBj() {
        return this.iRM;
    }

    public void eX(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.iRL == null) {
            this.iRL = new w();
        }
        this.iRL.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.iRM = null;
        if (this.iRL != null) {
            this.iRL.onDestory();
        }
        this.iRL = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static class a {
        private static c iRN = new c();
    }
}
