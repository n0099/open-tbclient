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
    public JSONArray cui;
    private HttpMessageListener cuj;
    private BdUniqueId cuk = BdUniqueId.gen();
    private BdUniqueId cul = BdUniqueId.gen();
    private CustomMessageListener cum = new b(this, 2000994);
    private CustomMessageListener cun = new c(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    public a() {
        if (this.cuj == null) {
            this.cuj = new d(this, CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.cuj.setTag(this.cul);
        MessageManager.getInstance().registerListener(this.cuj);
        MessageManager.getInstance().registerListener(this.cum);
        MessageManager.getInstance().registerListener(this.cun);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cuj);
        MessageManager.getInstance().unRegisterListener(this.cum);
        MessageManager.getInstance().unRegisterListener(this.cun);
        this.cui = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.gY()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cuk);
                return;
            }
            if (this.cui == null) {
                this.cui = new JSONArray();
            }
            if (this.cui.length() <= 100) {
                this.cui.put(jSONObject);
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
