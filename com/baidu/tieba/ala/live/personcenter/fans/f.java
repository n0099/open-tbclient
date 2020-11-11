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
    public static final BdUniqueId gQJ = BdUniqueId.gen();
    public static final BdUniqueId gQK = BdUniqueId.gen();
    private boolean biQ;
    private a gQG;
    private int gQL;
    private PersonListActivity gQM;
    private int gQN;
    private int gQO;
    private String gQP;
    public HttpMessageListener gQQ;
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
        this.gQL = 0;
        this.gQN = 0;
        this.gQQ = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.gQG != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.gQM.getResources().getString(a.h.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.gQG.aB(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bVE = ((ResponseNetPersonListMessage) httpResponsedMessage).bVE();
                    if (bVE != null) {
                        if (!StringUtils.isNull(bVE.eCn)) {
                            f.this.gQP = bVE.eCn;
                            f.this.gQO = bVE.type;
                        }
                        bVE.type = f.this.gQO;
                        bVE.eCn = f.this.gQP;
                    }
                    if (f.this.gQG != null) {
                        f.this.gQG.a(bVE, false);
                    }
                }
            }
        };
        this.gQM = personListActivity;
        this.biQ = false;
        this.mId = null;
        this.gQG = aVar;
        bOG();
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

    public void mD(boolean z) {
        this.biQ = z;
    }

    public boolean bVC() {
        return this.biQ;
    }

    private void bOG() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.biQ) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.gQQ);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bVD() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.biQ) {
            httpMessage.setTag(gQK);
        } else {
            httpMessage.setTag(gQJ);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.gQL != 0) {
            this.gQL++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.gQL));
        }
        httpMessage.addParam("tab", this.gQN);
        hashMap.put("page", String.valueOf(this.gQL));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
