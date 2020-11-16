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
/* loaded from: classes4.dex */
public class f extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId gQq = BdUniqueId.gen();
    public static final BdUniqueId gQr = BdUniqueId.gen();
    private boolean bhc;
    private a gQn;
    private int gQs;
    private PersonListActivity gQt;
    private int gQu;
    private int gQv;
    private String gQw;
    public HttpMessageListener gQx;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        e a(e eVar, boolean z);

        void aB(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.gQs = 0;
        this.gQu = 0;
        this.gQx = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.gQn != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.gQt.getResources().getString(a.h.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.gQn.aB(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bUX = ((ResponseNetPersonListMessage) httpResponsedMessage).bUX();
                    if (bUX != null) {
                        if (!StringUtils.isNull(bUX.eAE)) {
                            f.this.gQw = bUX.eAE;
                            f.this.gQv = bUX.type;
                        }
                        bUX.type = f.this.gQv;
                        bUX.eAE = f.this.gQw;
                    }
                    if (f.this.gQn != null) {
                        f.this.gQn.a(bUX, false);
                    }
                }
            }
        };
        this.gQt = personListActivity;
        this.bhc = false;
        this.mId = null;
        this.gQn = aVar;
        bNZ();
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

    public void mE(boolean z) {
        this.bhc = z;
    }

    public boolean bUV() {
        return this.bhc;
    }

    private void bNZ() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bhc) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.gQx);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bUW() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.bhc) {
            httpMessage.setTag(gQr);
        } else {
            httpMessage.setTag(gQq);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.gQs != 0) {
            this.gQs++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.gQs));
        }
        httpMessage.addParam("tab", this.gQu);
        hashMap.put("page", String.valueOf(this.gQs));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
