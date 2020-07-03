package com.baidu.tieba.ala.person.c;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class d extends BdBaseModel {
    private a gzo;
    private HttpMessageListener gzp;
    private TbPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void bKY();

        void onFail(String str);
    }

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gzp = new HttpMessageListener(1021030) { // from class: com.baidu.tieba.ala.person.c.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021030 && d.this.gzo != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.gzo.onFail(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.gzo.bKY();
                    } else {
                        d.this.gzo.onFail(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.gzp.setSelfListener(true);
        this.gzp.setTag(tbPageContext.getUniqueId());
        registerListener(this.gzp);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021030, com.baidu.live.a.atv);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void Dv(String str) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.gzo != null) {
                this.gzo.onFail(this.mContext.getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021030);
        httpMessage.addParam("target_user_id", str);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        this.mContext.sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.gzo = aVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        if (this.gzo != null) {
            this.gzo.onFail(null);
            return false;
        }
        return false;
    }

    public void onDestroy() {
        cancelMessage();
        if (this.gzo != null) {
            this.gzo.onFail(null);
        }
        MessageManager.getInstance().unRegisterTask(1021030);
    }
}
