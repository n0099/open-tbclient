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
    private JSONArray bgB;
    private HttpMessageListener bgC;
    private BdUniqueId bgD = BdUniqueId.gen();
    private BdUniqueId bgE = BdUniqueId.gen();
    private CustomMessageListener bgF = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jr() && a.this.bgB != null) {
                a.this.a(a.this.bgB, a.this.bgE);
            }
        }
    };
    private CustomMessageListener bgG = new CustomMessageListener(2016488) { // from class: com.baidu.tieba.NEGFeedBack.a.3
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
        if (this.bgC == null) {
            this.bgC = new HttpMessageListener(CmdConfigHttp.CMD_NEG_FEED_BACK) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.bgB = null;
                    }
                }
            };
        }
        this.bgC.setTag(this.bgE);
        MessageManager.getInstance().registerListener(this.bgC);
        MessageManager.getInstance().registerListener(this.bgF);
        this.bgG.setTag(tbPageContext.getUniqueId());
        this.bgG.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bgG);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bgC);
        MessageManager.getInstance().unRegisterListener(this.bgF);
        MessageManager.getInstance().unRegisterListener(this.bgG);
        this.bgB = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.jr()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.bgD);
                return;
            }
            if (this.bgB == null) {
                this.bgB = new JSONArray();
            }
            if (this.bgB.length() <= 100) {
                this.bgB.put(jSONObject);
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
