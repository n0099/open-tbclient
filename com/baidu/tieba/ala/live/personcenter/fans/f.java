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
/* loaded from: classes10.dex */
public class f extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId hgN = BdUniqueId.gen();
    public static final BdUniqueId hgO = BdUniqueId.gen();
    private int bZk;
    private boolean bik;
    private a hgK;
    private PersonListActivity hgP;
    private int hgQ;
    private int hgR;
    private String hgS;
    public HttpMessageListener hgT;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        e a(e eVar, boolean z);

        void aD(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.bZk = 0;
        this.hgQ = 0;
        this.hgT = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.hgK != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.hgP.getResources().getString(a.h.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.hgK.aD(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bXv = ((ResponseNetPersonListMessage) httpResponsedMessage).bXv();
                    if (bXv != null) {
                        if (!StringUtils.isNull(bXv.eMJ)) {
                            f.this.hgS = bXv.eMJ;
                            f.this.hgR = bXv.type;
                        }
                        bXv.type = f.this.hgR;
                        bXv.eMJ = f.this.hgS;
                    }
                    if (f.this.hgK != null) {
                        f.this.hgK.a(bXv, false);
                    }
                }
            }
        };
        this.hgP = personListActivity;
        this.bik = false;
        this.mId = null;
        this.hgK = aVar;
        bQw();
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

    public void bu(boolean z) {
        this.bik = z;
    }

    public boolean bXt() {
        return this.bik;
    }

    private void bQw() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bik) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.hgT);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bXu() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.bik) {
            httpMessage.setTag(hgO);
        } else {
            httpMessage.setTag(hgN);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.bZk != 0) {
            this.bZk++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.bZk));
        }
        httpMessage.addParam("tab", this.hgQ);
        hashMap.put("page", String.valueOf(this.bZk));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
