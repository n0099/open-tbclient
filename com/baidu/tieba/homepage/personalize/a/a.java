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
    public JSONArray cpJ;
    private HttpMessageListener cpK;
    private BdUniqueId cpL = BdUniqueId.gen();
    private BdUniqueId cpM = BdUniqueId.gen();
    private CustomMessageListener cpN = new b(this, 2000994);
    private CustomMessageListener cpO = new c(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    public a() {
        if (this.cpK == null) {
            this.cpK = new d(this, CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.cpK.setTag(this.cpM);
        MessageManager.getInstance().registerListener(this.cpK);
        MessageManager.getInstance().registerListener(this.cpN);
        MessageManager.getInstance().registerListener(this.cpO);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cpK);
        MessageManager.getInstance().unRegisterListener(this.cpN);
        MessageManager.getInstance().unRegisterListener(this.cpO);
        this.cpJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.fZ()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cpL);
                return;
            }
            if (this.cpJ == null) {
                this.cpJ = new JSONArray();
            }
            if (this.cpJ.length() <= 100) {
                this.cpJ.put(jSONObject);
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
