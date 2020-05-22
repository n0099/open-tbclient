package com.baidu.tieba.NEGFeedBack;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.deletethread.DeleteThreadHttpResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    private HttpMessageListener eJb;
    private String mFrom;
    private a eJM = null;
    private CustomMessageListener eJf = new CustomMessageListener(2016489) { // from class: com.baidu.tieba.NEGFeedBack.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                d.this.cI((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage);
    }

    public d(String str) {
        this.mFrom = str;
        if (this.eJb == null) {
            this.eJb = new HttpMessageListener(CmdConfigHttp.CMD_NEG_DELETE_THREAD) { // from class: com.baidu.tieba.NEGFeedBack.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003185 && (httpResponsedMessage instanceof DeleteThreadHttpResponseMessage) && httpResponsedMessage.isSuccess() && d.this.eJM != null) {
                        d.this.eJM.a((DeleteThreadHttpResponseMessage) httpResponsedMessage);
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.eJb);
        MessageManager.getInstance().registerListener(this.eJf);
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.eJb);
        MessageManager.getInstance().registerListener(this.eJf);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eJf);
        MessageManager.getInstance().unRegisterListener(this.eJb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(JSONObject jSONObject) {
        if (jSONObject != null && j.isNetworkAvailableForImmediately()) {
            try {
                int i = jSONObject.getInt("type");
                String O = aq.O(jSONObject.getJSONArray("thread_ids"));
                String O2 = aq.O(jSONObject.getJSONArray(TiebaInitialize.LogFields.REASON));
                String string = jSONObject.getString("forum_id");
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_DELETE_THREAD);
                httpMessage.addParam("type", i);
                httpMessage.addParam("thread_ids", O);
                httpMessage.addParam(TiebaInitialize.LogFields.REASON, O2);
                httpMessage.addParam("forum_id", string);
                httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                MessageManager.getInstance().sendMessage(httpMessage);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.eJM = aVar;
    }
}
