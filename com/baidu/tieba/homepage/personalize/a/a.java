package com.baidu.tieba.homepage.personalize.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public JSONArray cFb;
    private HttpMessageListener cFc;
    private BdUniqueId cFd = BdUniqueId.gen();
    private BdUniqueId cFe = BdUniqueId.gen();
    private CustomMessageListener cFf = new b(this, 2000994);
    private CustomMessageListener cFg = new c(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    public a() {
        if (this.cFc == null) {
            this.cFc = new d(this, CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.cFc.setTag(this.cFe);
        MessageManager.getInstance().registerListener(this.cFc);
        MessageManager.getInstance().registerListener(this.cFf);
        MessageManager.getInstance().registerListener(this.cFg);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cFc);
        MessageManager.getInstance().unRegisterListener(this.cFf);
        MessageManager.getInstance().unRegisterListener(this.cFg);
        this.cFb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.fZ()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cFd);
                return;
            }
            if (this.cFb == null) {
                this.cFb = new JSONArray();
            }
            if (this.cFb.length() <= 100) {
                this.cFb.put(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
