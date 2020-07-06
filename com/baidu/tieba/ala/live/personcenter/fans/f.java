package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId fQl = BdUniqueId.gen();
    public static final BdUniqueId fQm = BdUniqueId.gen();
    private boolean aTm;
    private a fQi;
    private int fQn;
    private PersonListActivity fQo;
    private int fQp;
    private int fQq;
    private String fQr;
    public HttpMessageListener fQs;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        e a(e eVar, boolean z);

        void at(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.fQn = 0;
        this.fQp = 0;
        this.fQs = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.fQi != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.fQo.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.fQi.at(errorString, false);
                            return;
                        }
                        return;
                    }
                    e byY = ((ResponseNetPersonListMessage) httpResponsedMessage).byY();
                    if (byY != null) {
                        if (!StringUtils.isNull(byY.dKa)) {
                            f.this.fQr = byY.dKa;
                            f.this.fQq = byY.type;
                        }
                        byY.type = f.this.fQq;
                        byY.dKa = f.this.fQr;
                    }
                    if (f.this.fQi != null) {
                        f.this.fQi.a(byY, false);
                    }
                }
            }
        };
        this.fQo = personListActivity;
        this.aTm = false;
        this.mId = null;
        this.fQi = aVar;
        btt();
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getId() {
        return this.mId;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public void kt(boolean z) {
        this.aTm = z;
    }

    public boolean byW() {
        return this.aTm;
    }

    private void btt() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.aTm) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.fQs);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void byX() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.aTm) {
            httpMessage.setTag(fQm);
        } else {
            httpMessage.setTag(fQl);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.fQn != 0) {
            this.fQn++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.fQn));
        }
        httpMessage.addParam("tab", this.fQp);
        hashMap.put("page", String.valueOf(this.fQn));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
