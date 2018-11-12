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
    private JSONArray bsZ;
    private HttpMessageListener bta;
    private BdUniqueId btb = BdUniqueId.gen();
    private BdUniqueId btc = BdUniqueId.gen();
    private CustomMessageListener btd = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kK() && a.this.bsZ != null) {
                a.this.a(a.this.bsZ, a.this.btc);
            }
        }
    };
    private CustomMessageListener bte = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.I((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.bta == null) {
            this.bta = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.bsZ = null;
                    }
                }
            };
        }
        this.bta.setTag(this.btc);
        MessageManager.getInstance().registerListener(this.bta);
        MessageManager.getInstance().registerListener(this.btd);
        this.bte.setTag(tbPageContext.getUniqueId());
        this.bte.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bte);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bta);
        MessageManager.getInstance().unRegisterListener(this.btd);
        MessageManager.getInstance().unRegisterListener(this.bte);
        this.bsZ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.kK()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.btb);
                return;
            }
            if (this.bsZ == null) {
                this.bsZ = new JSONArray();
            }
            if (this.bsZ.length() <= 100) {
                this.bsZ.put(jSONObject);
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
