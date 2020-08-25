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
/* loaded from: classes2.dex */
public class a {
    private JSONArray flj;
    private HttpMessageListener flk;
    private BdUniqueId fll = BdUniqueId.gen();
    private BdUniqueId flm = BdUniqueId.gen();
    private CustomMessageListener fln = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.NEGFeedBack.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetworkAvailableForImmediately() && a.this.flj != null) {
                a.this.a(a.this.flj, a.this.flm);
            }
        }
    };
    private CustomMessageListener flo = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.NEGFeedBack.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                a.this.dc((JSONObject) customResponsedMessage.getData());
            }
        }
    };
    private String mFrom;

    public a(TbPageContext tbPageContext, String str) {
        this.mFrom = str;
        if (this.flk == null) {
            this.flk = new HttpMessageListener(1003184) { // from class: com.baidu.tieba.NEGFeedBack.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                        a.this.flj = null;
                    }
                }
            };
        }
        this.flk.setTag(this.flm);
        MessageManager.getInstance().registerListener(this.flk);
        MessageManager.getInstance().registerListener(this.fln);
        this.flo.setTag(tbPageContext.getUniqueId());
        this.flo.setSelfListener(true);
        this.flo.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.flo);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.flk);
        MessageManager.getInstance().unRegisterListener(this.fln);
        MessageManager.getInstance().unRegisterListener(this.flo);
        this.flj = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (j.isNetworkAvailableForImmediately()) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                a(jSONArray, this.fll);
                return;
            }
            if (this.flj == null) {
                this.flj = new JSONArray();
            }
            if (this.flj.length() <= 100) {
                this.flj.put(jSONObject);
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
