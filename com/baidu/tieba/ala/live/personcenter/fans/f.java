package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.u.a;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId fER = BdUniqueId.gen();
    public static final BdUniqueId fES = BdUniqueId.gen();
    private boolean aQG;
    private a fEO;
    private int fET;
    private PersonListActivity fEU;
    private int fEV;
    private int fEW;
    private String fEX;
    public HttpMessageListener fEY;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        e a(e eVar, boolean z);

        void ar(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.fET = 0;
        this.fEV = 0;
        this.fEY = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.fEO != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.fEU.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.fEO.ar(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bwa = ((ResponseNetPersonListMessage) httpResponsedMessage).bwa();
                    if (bwa != null) {
                        if (!StringUtils.isNull(bwa.dDE)) {
                            f.this.fEX = bwa.dDE;
                            f.this.fEW = bwa.type;
                        }
                        bwa.type = f.this.fEW;
                        bwa.dDE = f.this.fEX;
                    }
                    if (f.this.fEO != null) {
                        f.this.fEO.a(bwa, false);
                    }
                }
            }
        };
        this.fEU = personListActivity;
        this.aQG = false;
        this.mId = null;
        this.fEO = aVar;
        bqt();
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

    public void kf(boolean z) {
        this.aQG = z;
    }

    public boolean bvY() {
        return this.aQG;
    }

    private void bqt() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.aQG) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.fEY);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bvZ() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.aQG) {
            httpMessage.setTag(fES);
        } else {
            httpMessage.setTag(fER);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.fET != 0) {
            this.fET++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.fET));
        }
        httpMessage.addParam("tab", this.fEV);
        hashMap.put("page", String.valueOf(this.fET));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
