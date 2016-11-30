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
    public JSONArray cKo;
    private HttpMessageListener cKp;
    private BdUniqueId cKq = BdUniqueId.gen();
    private BdUniqueId cKr = BdUniqueId.gen();
    private CustomMessageListener cKs = new b(this, 2000994);
    private CustomMessageListener cKt = new c(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    public a() {
        if (this.cKp == null) {
            this.cKp = new d(this, CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.cKp.setTag(this.cKr);
        MessageManager.getInstance().registerListener(this.cKp);
        MessageManager.getInstance().registerListener(this.cKs);
        MessageManager.getInstance().registerListener(this.cKt);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cKp);
        MessageManager.getInstance().unRegisterListener(this.cKs);
        MessageManager.getInstance().unRegisterListener(this.cKt);
        this.cKo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.fZ()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cKq);
                return;
            }
            if (this.cKo == null) {
                this.cKo = new JSONArray();
            }
            if (this.cKo.length() <= 100) {
                this.cKo.put(jSONObject);
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
