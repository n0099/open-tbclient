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
    public JSONArray cwI;
    private HttpMessageListener cwJ;
    private BdUniqueId cwK = BdUniqueId.gen();
    private BdUniqueId cwL = BdUniqueId.gen();
    private CustomMessageListener cwM = new b(this, 2000994);
    private CustomMessageListener cwN = new c(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    public a() {
        if (this.cwJ == null) {
            this.cwJ = new d(this, CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.cwJ.setTag(this.cwL);
        MessageManager.getInstance().registerListener(this.cwJ);
        MessageManager.getInstance().registerListener(this.cwM);
        MessageManager.getInstance().registerListener(this.cwN);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cwJ);
        MessageManager.getInstance().unRegisterListener(this.cwM);
        MessageManager.getInstance().unRegisterListener(this.cwN);
        this.cwI = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.gX()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cwK);
                return;
            }
            if (this.cwI == null) {
                this.cwI = new JSONArray();
            }
            if (this.cwI.length() <= 100) {
                this.cwI.put(jSONObject);
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
