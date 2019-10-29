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
/* loaded from: classes3.dex */
public class d {
    private HttpMessageListener dcx;
    private String mFrom;
    private a ddj = null;
    private CustomMessageListener dcB = new CustomMessageListener(2016489) { // from class: com.baidu.tieba.NEGFeedBack.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                d.this.bB((JSONObject) customResponsedMessage.getData());
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(DeleteThreadHttpResponseMessage deleteThreadHttpResponseMessage);
    }

    public d(String str) {
        this.mFrom = str;
        if (this.dcx == null) {
            this.dcx = new HttpMessageListener(CmdConfigHttp.CMD_NEG_DELETE_THREAD) { // from class: com.baidu.tieba.NEGFeedBack.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003185 && (httpResponsedMessage instanceof DeleteThreadHttpResponseMessage) && httpResponsedMessage.isSuccess() && d.this.ddj != null) {
                        d.this.ddj.a((DeleteThreadHttpResponseMessage) httpResponsedMessage);
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.dcx);
        MessageManager.getInstance().registerListener(this.dcB);
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.dcx);
        MessageManager.getInstance().registerListener(this.dcB);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dcB);
        MessageManager.getInstance().unRegisterListener(this.dcx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(JSONObject jSONObject) {
        if (jSONObject != null && j.isNetworkAvailableForImmediately()) {
            try {
                int i = jSONObject.getInt("type");
                String G = aq.G(jSONObject.getJSONArray("thread_ids"));
                String G2 = aq.G(jSONObject.getJSONArray(TiebaInitialize.LogFields.REASON));
                String string = jSONObject.getString("forum_id");
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_DELETE_THREAD);
                httpMessage.addParam("type", i);
                httpMessage.addParam("thread_ids", G);
                httpMessage.addParam(TiebaInitialize.LogFields.REASON, G2);
                httpMessage.addParam("forum_id", string);
                httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                MessageManager.getInstance().sendMessage(httpMessage);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.ddj = aVar;
    }
}
