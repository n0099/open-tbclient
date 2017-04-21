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
    public JSONArray cyZ;
    private HttpMessageListener cza;
    private BdUniqueId czb = BdUniqueId.gen();
    private BdUniqueId czc = BdUniqueId.gen();
    private CustomMessageListener czd = new b(this, 2000994);
    private CustomMessageListener cze = new c(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    public a() {
        if (this.cza == null) {
            this.cza = new d(this, CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.cza.setTag(this.czc);
        MessageManager.getInstance().registerListener(this.cza);
        MessageManager.getInstance().registerListener(this.czd);
        MessageManager.getInstance().registerListener(this.cze);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cza);
        MessageManager.getInstance().unRegisterListener(this.czd);
        MessageManager.getInstance().unRegisterListener(this.cze);
        this.cyZ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.gY()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.czb);
                return;
            }
            if (this.cyZ == null) {
                this.cyZ = new JSONArray();
            }
            if (this.cyZ.length() <= 100) {
                this.cyZ.put(jSONObject);
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
