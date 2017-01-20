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
    public JSONArray cwJ;
    private HttpMessageListener cwK;
    private BdUniqueId cwL = BdUniqueId.gen();
    private BdUniqueId cwM = BdUniqueId.gen();
    private CustomMessageListener cwN = new b(this, 2000994);
    private CustomMessageListener cwO = new c(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    public a() {
        if (this.cwK == null) {
            this.cwK = new d(this, CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.cwK.setTag(this.cwM);
        MessageManager.getInstance().registerListener(this.cwK);
        MessageManager.getInstance().registerListener(this.cwN);
        MessageManager.getInstance().registerListener(this.cwO);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cwK);
        MessageManager.getInstance().unRegisterListener(this.cwN);
        MessageManager.getInstance().unRegisterListener(this.cwO);
        this.cwJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.fX()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cwL);
                return;
            }
            if (this.cwJ == null) {
                this.cwJ = new JSONArray();
            }
            if (this.cwJ.length() <= 100) {
                this.cwJ.put(jSONObject);
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
