package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes.dex */
public class c {
    private v jgU;
    private BawuThrones jgV;

    private c() {
    }

    public static c cBI() {
        return a.jgW;
    }

    public void a(BawuThrones bawuThrones) {
        this.jgV = bawuThrones;
    }

    public BawuThrones cBJ() {
        return this.jgV;
    }

    public void eX(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.jgU == null) {
            this.jgU = new v();
        }
        this.jgU.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.jgV = null;
        if (this.jgU != null) {
            this.jgU.onDestory();
        }
        this.jgU = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c jgW = new c();
    }
}
