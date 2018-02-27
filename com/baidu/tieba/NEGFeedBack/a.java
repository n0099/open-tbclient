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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private JSONArray bOs;
    private HttpMessageListener bOt;
    private BdUniqueId bOu = BdUniqueId.gen();
    private BdUniqueId bOv = BdUniqueId.gen();
    private CustomMessageListener bOw = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.ox() && a.this.bOs != null) {
                a.this.a(a.this.bOs, a.this.bOv);
            }
        }
    };
    private CustomMessageListener bOx = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.p((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.bOt == null) {
            this.bOt = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.bOs = null;
                    }
                }
            };
        }
        this.bOt.setTag(this.bOv);
        MessageManager.getInstance().registerListener(this.bOt);
        MessageManager.getInstance().registerListener(this.bOw);
        this.bOx.setTag(tbPageContext.getUniqueId());
        this.bOx.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bOx);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bOt);
        MessageManager.getInstance().unRegisterListener(this.bOw);
        MessageManager.getInstance().unRegisterListener(this.bOx);
        this.bOs = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.ox()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.bOu);
                return;
            }
            if (this.bOs == null) {
                this.bOs = new JSONArray();
            }
            if (this.bOs.length() <= 100) {
                this.bOs.put(jSONObject);
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
