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
    private JSONArray bOv;
    private HttpMessageListener bOw;
    private String mFrom;
    private BdUniqueId bOx = BdUniqueId.gen();
    private BdUniqueId bOy = BdUniqueId.gen();
    private CustomMessageListener bOz = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.ox() && a.this.bOv != null) {
                a.this.a(a.this.bOv, a.this.bOy);
            }
        }
    };
    private CustomMessageListener bOA = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.p((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.bOw == null) {
            this.bOw = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.bOv = null;
                    }
                }
            };
        }
        this.bOw.setTag(this.bOy);
        MessageManager.getInstance().registerListener(this.bOw);
        MessageManager.getInstance().registerListener(this.bOz);
        this.bOA.setTag(tbPageContext.getUniqueId());
        this.bOA.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bOA);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bOw);
        MessageManager.getInstance().unRegisterListener(this.bOz);
        MessageManager.getInstance().unRegisterListener(this.bOA);
        this.bOv = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.ox()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.bOx);
                return;
            }
            if (this.bOv == null) {
                this.bOv = new JSONArray();
            }
            if (this.bOv.length() <= 100) {
                this.bOv.put(jSONObject);
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
