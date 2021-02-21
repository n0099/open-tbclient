package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes.dex */
public class c {
    private v jfl;
    private BawuThrones jfm;

    private c() {
    }

    public static c cBC() {
        return a.jfn;
    }

    public void a(BawuThrones bawuThrones) {
        this.jfm = bawuThrones;
    }

    public BawuThrones cBD() {
        return this.jfm;
    }

    public void eX(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.jfl == null) {
            this.jfl = new v();
        }
        this.jfl.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.jfm = null;
        if (this.jfl != null) {
            this.jfl.onDestory();
        }
        this.jfl = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c jfn = new c();
    }
}
