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
    public JSONArray cIm;
    private HttpMessageListener cIn;
    private BdUniqueId cIo = BdUniqueId.gen();
    private BdUniqueId cIp = BdUniqueId.gen();
    private CustomMessageListener cIq = new b(this, 2000994);
    private CustomMessageListener cIr = new c(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    public a() {
        if (this.cIn == null) {
            this.cIn = new d(this, CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.cIn.setTag(this.cIp);
        MessageManager.getInstance().registerListener(this.cIn);
        MessageManager.getInstance().registerListener(this.cIq);
        MessageManager.getInstance().registerListener(this.cIr);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cIn);
        MessageManager.getInstance().unRegisterListener(this.cIq);
        MessageManager.getInstance().unRegisterListener(this.cIr);
        this.cIm = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.gX()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cIo);
                return;
            }
            if (this.cIm == null) {
                this.cIm = new JSONArray();
            }
            if (this.cIm.length() <= 100) {
                this.cIm.put(jSONObject);
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
