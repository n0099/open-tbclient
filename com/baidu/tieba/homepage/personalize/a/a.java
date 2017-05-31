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
    public JSONArray cAA;
    private HttpMessageListener cAB;
    private BdUniqueId cAC = BdUniqueId.gen();
    private BdUniqueId cAD = BdUniqueId.gen();
    private CustomMessageListener cAE = new b(this, 2000994);
    private CustomMessageListener cAF = new c(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    public a() {
        if (this.cAB == null) {
            this.cAB = new d(this, CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.cAB.setTag(this.cAD);
        MessageManager.getInstance().registerListener(this.cAB);
        MessageManager.getInstance().registerListener(this.cAE);
        MessageManager.getInstance().registerListener(this.cAF);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cAB);
        MessageManager.getInstance().unRegisterListener(this.cAE);
        MessageManager.getInstance().unRegisterListener(this.cAF);
        this.cAA = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.gY()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cAC);
                return;
            }
            if (this.cAA == null) {
                this.cAA = new JSONArray();
            }
            if (this.cAA.length() <= 100) {
                this.cAA.put(jSONObject);
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
