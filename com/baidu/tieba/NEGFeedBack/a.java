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
    private JSONArray bhO;
    private HttpMessageListener bhP;
    private BdUniqueId bhQ = BdUniqueId.gen();
    private BdUniqueId bhR = BdUniqueId.gen();
    private CustomMessageListener bhS = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jr() && a.this.bhO != null) {
                a.this.a(a.this.bhO, a.this.bhR);
            }
        }
    };
    private CustomMessageListener bhT = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.w((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.bhP == null) {
            this.bhP = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.bhO = null;
                    }
                }
            };
        }
        this.bhP.setTag(this.bhR);
        MessageManager.getInstance().registerListener(this.bhP);
        MessageManager.getInstance().registerListener(this.bhS);
        this.bhT.setTag(tbPageContext.getUniqueId());
        this.bhT.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bhT);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bhP);
        MessageManager.getInstance().unRegisterListener(this.bhS);
        MessageManager.getInstance().unRegisterListener(this.bhT);
        this.bhO = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.jr()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.bhQ);
                return;
            }
            if (this.bhO == null) {
                this.bhO = new JSONArray();
            }
            if (this.bhO.length() <= 100) {
                this.bhO.put(jSONObject);
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
