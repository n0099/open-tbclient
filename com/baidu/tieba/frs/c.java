package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes21.dex */
public class c {
    private x iGd;
    private BawuThrones iGe;

    private c() {
    }

    public static c cxq() {
        return a.iGf;
    }

    public void a(BawuThrones bawuThrones) {
        this.iGe = bawuThrones;
    }

    public BawuThrones cxr() {
        return this.iGe;
    }

    public void eS(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.iGd == null) {
            this.iGd = new x();
        }
        this.iGd.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.iGe = null;
        if (this.iGd != null) {
            this.iGd.onDestory();
        }
        this.iGd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static class a {
        private static c iGf = new c();
    }
}
