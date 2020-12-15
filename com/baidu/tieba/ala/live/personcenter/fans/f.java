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
    public static final BdUniqueId gZF = BdUniqueId.gen();
    public static final BdUniqueId gZG = BdUniqueId.gen();
    private boolean blr;
    private a gZC;
    private int gZH;
    private PersonListActivity gZI;
    private int gZJ;
    private int gZK;
    private String gZL;
    public HttpMessageListener gZM;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        e a(e eVar, boolean z);

        void aC(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.gZH = 0;
        this.gZJ = 0;
        this.gZM = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.gZC != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.gZI.getResources().getString(a.h.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.gZC.aC(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bYH = ((ResponseNetPersonListMessage) httpResponsedMessage).bYH();
                    if (bYH != null) {
                        if (!StringUtils.isNull(bYH.eHD)) {
                            f.this.gZL = bYH.eHD;
                            f.this.gZK = bYH.type;
                        }
                        bYH.type = f.this.gZK;
                        bYH.eHD = f.this.gZL;
                    }
                    if (f.this.gZC != null) {
                        f.this.gZC.a(bYH, false);
                    }
                }
            }
        };
        this.gZI = personListActivity;
        this.blr = false;
        this.mId = null;
        this.gZC = aVar;
        bRL();
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

    public void mZ(boolean z) {
        this.blr = z;
    }

    public boolean bYF() {
        return this.blr;
    }

    private void bRL() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.blr) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.gZM);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bYG() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.blr) {
            httpMessage.setTag(gZG);
        } else {
            httpMessage.setTag(gZF);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.gZH != 0) {
            this.gZH++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.gZH));
        }
        httpMessage.addParam("tab", this.gZJ);
        hashMap.put("page", String.valueOf(this.gZH));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
