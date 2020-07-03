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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONArray eTx;
    private HttpMessageListener eTy;
    private String mFrom;
    private BdUniqueId eTz = BdUniqueId.gen();
    private BdUniqueId eTA = BdUniqueId.gen();
    private CustomMessageListener eTB = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetworkAvailableForImmediately() && a.this.eTx != null) {
                a.this.a(a.this.eTx, a.this.eTA);
            }
        }
    };
    private CustomMessageListener eTC = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.cP((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.eTy == null) {
            this.eTy = new HttpMessageListener(1003184) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.eTx = null;
                    }
                }
            };
        }
        this.eTy.setTag(this.eTA);
        MessageManager.getInstance().registerListener(this.eTy);
        MessageManager.getInstance().registerListener(this.eTB);
        this.eTC.setTag(tbPageContext.getUniqueId());
        this.eTC.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.eTC);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eTy);
        MessageManager.getInstance().unRegisterListener(this.eTB);
        MessageManager.getInstance().unRegisterListener(this.eTC);
        this.eTx = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.isNetworkAvailableForImmediately()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.eTz);
                return;
            }
            if (this.eTx == null) {
                this.eTx = new JSONArray();
            }
            if (this.eTx.length() <= 100) {
                this.eTx.put(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(1003184);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.mFrom);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
