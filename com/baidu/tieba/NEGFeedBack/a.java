package com.baidu.tieba.NEGFeedBack;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private BdUniqueId bMA = BdUniqueId.gen();
    private BdUniqueId bMB = BdUniqueId.gen();
    private CustomMessageListener bMC = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.ox() && a.this.bMy != null) {
                a.this.a(a.this.bMy, a.this.bMB);
            }
        }
    };
    private CustomMessageListener bMD = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.k((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private JSONArray bMy;
    private HttpMessageListener bMz;
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.bMz == null) {
            this.bMz = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.bMy = null;
                    }
                }
            };
        }
        this.bMz.setTag(this.bMB);
        MessageManager.getInstance().registerListener(this.bMz);
        MessageManager.getInstance().registerListener(this.bMC);
        this.bMD.setTag(tbPageContext.getUniqueId());
        this.bMD.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bMD);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bMz);
        MessageManager.getInstance().unRegisterListener(this.bMC);
        MessageManager.getInstance().unRegisterListener(this.bMD);
        this.bMy = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.ox()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.bMA);
                return;
            }
            if (this.bMy == null) {
                this.bMy = new JSONArray();
            }
            if (this.bMy.length() <= 100) {
                this.bMy.put(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.mFrom);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
