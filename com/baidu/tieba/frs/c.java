package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes.dex */
public class c {
    private v jdX;
    private BawuThrones jdY;

    private c() {
    }

    public static c cEc() {
        return a.jdZ;
    }

    public void a(BawuThrones bawuThrones) {
        this.jdY = bawuThrones;
    }

    public BawuThrones cEd() {
        return this.jdY;
    }

    public void eY(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.jdX == null) {
            this.jdX = new v();
        }
        this.jdX.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.jdY = null;
        if (this.jdX != null) {
            this.jdX.onDestory();
        }
        this.jdX = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c jdZ = new c();
    }
}
