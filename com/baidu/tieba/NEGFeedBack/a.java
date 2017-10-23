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
    private JSONArray aUV;
    private HttpMessageListener aUW;
    private BdUniqueId aUX = BdUniqueId.gen();
    private BdUniqueId aUY = BdUniqueId.gen();
    private CustomMessageListener aUZ = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.gV() && a.this.aUV != null) {
                a.this.a(a.this.aUV, a.this.aUY);
            }
        }
    };
    private CustomMessageListener aVa = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.l((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String aie;

    public a(TbPageContext tbPageContext, String str) {
        this.aie = str;
        if (this.aUW == null) {
            this.aUW = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.aUV = null;
                    }
                }
            };
        }
        this.aUW.setTag(this.aUY);
        MessageManager.getInstance().registerListener(this.aUW);
        MessageManager.getInstance().registerListener(this.aUZ);
        this.aVa.setTag(tbPageContext.getUniqueId());
        this.aVa.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.aVa);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aUW);
        MessageManager.getInstance().unRegisterListener(this.aUZ);
        MessageManager.getInstance().unRegisterListener(this.aVa);
        this.aUV = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.gV()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.aUX);
                return;
            }
            if (this.aUV == null) {
                this.aUV = new JSONArray();
            }
            if (this.aUV.length() <= 100) {
                this.aUV.put(jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.aie);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
