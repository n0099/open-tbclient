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
    private JSONArray dPJ;
    private HttpMessageListener dPK;
    private BdUniqueId dPL = BdUniqueId.gen();
    private BdUniqueId dPM = BdUniqueId.gen();
    private CustomMessageListener dPN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetworkAvailableForImmediately() && a.this.dPJ != null) {
                a.this.a(a.this.dPJ, a.this.dPM);
            }
        }
    };
    private CustomMessageListener dPO = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.cr((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.dPK == null) {
            this.dPK = new HttpMessageListener(1003184) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.dPJ = null;
                    }
                }
            };
        }
        this.dPK.setTag(this.dPM);
        MessageManager.getInstance().registerListener(this.dPK);
        MessageManager.getInstance().registerListener(this.dPN);
        this.dPO.setTag(tbPageContext.getUniqueId());
        this.dPO.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.dPO);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dPK);
        MessageManager.getInstance().unRegisterListener(this.dPN);
        MessageManager.getInstance().unRegisterListener(this.dPO);
        this.dPJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.isNetworkAvailableForImmediately()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.dPL);
                return;
            }
            if (this.dPJ == null) {
                this.dPJ = new JSONArray();
            }
            if (this.dPJ.length() <= 100) {
                this.dPJ.put(jSONObject);
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
