package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class g extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId dRW = BdUniqueId.gen();
    public static final BdUniqueId dRX = BdUniqueId.gen();
    private boolean afP;
    private a dRT;
    private int dRY;
    private PersonListActivity dRZ;
    private int dSa;
    private int dSb;
    private String dSc;
    public HttpMessageListener dSd;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        void U(String str, boolean z);

        f a(f fVar, boolean z);
    }

    public g(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.dRY = 0;
        this.dSa = 0;
        this.dSd = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (g.this.dRT != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = g.this.dRZ.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            g.this.dRT.U(errorString, false);
                            return;
                        }
                        return;
                    }
                    f aMD = ((ResponseNetPersonListMessage) httpResponsedMessage).aMD();
                    if (aMD != null) {
                        if (!StringUtils.isNull(aMD.cas)) {
                            g.this.dSc = aMD.cas;
                            g.this.dSb = aMD.type;
                        }
                        aMD.type = g.this.dSb;
                        aMD.cas = g.this.dSc;
                    }
                    if (g.this.dRT != null) {
                        g.this.dRT.a(aMD, false);
                    }
                }
            }
        };
        this.dRZ = personListActivity;
        this.afP = false;
        this.mId = null;
        this.dRT = aVar;
        aIU();
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

    public void hi(boolean z) {
        this.afP = z;
    }

    public boolean aMB() {
        return this.afP;
    }

    public void aIU() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.afP) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.dSd);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void aMC() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.afP) {
            httpMessage.setTag(dRX);
        } else {
            httpMessage.setTag(dRW);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.dRY != 0) {
            this.dRY++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.dRY));
        }
        httpMessage.addParam("tab", this.dSa);
        hashMap.put("page", String.valueOf(this.dRY));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
