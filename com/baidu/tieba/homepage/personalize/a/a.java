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
    public JSONArray cyi;
    private HttpMessageListener cyj;
    private BdUniqueId cyk = BdUniqueId.gen();
    private BdUniqueId cyl = BdUniqueId.gen();
    private CustomMessageListener cym = new b(this, 2000994);
    private CustomMessageListener cyn = new c(this, CmdConfigCustom.NEG_FEED_BACK_DELETE);

    public a() {
        if (this.cyj == null) {
            this.cyj = new d(this, CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.cyj.setTag(this.cyl);
        MessageManager.getInstance().registerListener(this.cyj);
        MessageManager.getInstance().registerListener(this.cym);
        MessageManager.getInstance().registerListener(this.cyn);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cyj);
        MessageManager.getInstance().unRegisterListener(this.cym);
        MessageManager.getInstance().unRegisterListener(this.cyn);
        this.cyi = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (i.gS()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.cyk);
                return;
            }
            if (this.cyi == null) {
                this.cyi = new JSONArray();
            }
            if (this.cyi.length() <= 100) {
                this.cyi.put(jSONObject);
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
