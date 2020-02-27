package com.baidu.tieba.ala.person.c;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class d extends BdBaseModel {
    private a fsi;
    private HttpMessageListener fsj;
    private TbPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void brO();

        void onFail(String str);
    }

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fsj = new HttpMessageListener(1021030) { // from class: com.baidu.tieba.ala.person.c.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021030 && d.this.fsi != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.fsi.onFail(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.fsi.brO();
                    } else {
                        d.this.fsi.onFail(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fsj.setSelfListener(true);
        this.fsj.setTag(tbPageContext.getUniqueId());
        registerListener(this.fsj);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021030, com.baidu.live.a.Vg);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void zC(String str) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.fsi != null) {
                this.fsi.onFail(this.mContext.getResources().getString(a.i.sdk_no_network));
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
        this.fsi = aVar;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        if (this.fsi != null) {
            this.fsi.onFail(null);
            return false;
        }
        return false;
    }

    public void onDestroy() {
        cancelMessage();
        if (this.fsi != null) {
            this.fsi.onFail(null);
        }
        MessageManager.getInstance().unRegisterTask(1021030);
    }
}
