package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes8.dex */
public class c {
    private w hyB;
    private BawuThrones hyC;

    private c() {
    }

    public static c bXh() {
        return a.hyD;
    }

    public void a(BawuThrones bawuThrones) {
        this.hyC = bawuThrones;
    }

    public BawuThrones bXi() {
        return this.hyC;
    }

    public void ei(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void b(TbPageContext tbPageContext, String str, String str2) {
        if (this.hyB == null) {
            this.hyB = new w();
        }
        this.hyB.b(tbPageContext, str, str2);
    }

    public void destory() {
        this.hyC = null;
        if (this.hyB != null) {
            this.hyB.onDestory();
        }
        this.hyB = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static c hyD = new c();
    }
}
