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
    public static final BdUniqueId gkQ = BdUniqueId.gen();
    public static final BdUniqueId gkR = BdUniqueId.gen();
    private boolean bct;
    private a gkN;
    private int gkS;
    private PersonListActivity gkT;
    private int gkU;
    private int gkV;
    private String gkW;
    public HttpMessageListener gkX;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        e a(e eVar, boolean z);

        void av(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.gkS = 0;
        this.gkU = 0;
        this.gkX = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.gkN != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.gkT.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.gkN.av(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bMR = ((ResponseNetPersonListMessage) httpResponsedMessage).bMR();
                    if (bMR != null) {
                        if (!StringUtils.isNull(bMR.ebT)) {
                            f.this.gkW = bMR.ebT;
                            f.this.gkV = bMR.type;
                        }
                        bMR.type = f.this.gkV;
                        bMR.ebT = f.this.gkW;
                    }
                    if (f.this.gkN != null) {
                        f.this.gkN.a(bMR, false);
                    }
                }
            }
        };
        this.gkT = personListActivity;
        this.bct = false;
        this.mId = null;
        this.gkN = aVar;
        bGS();
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

    public void lB(boolean z) {
        this.bct = z;
    }

    public boolean bMP() {
        return this.bct;
    }

    private void bGS() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bct) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.gkX);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bMQ() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.bct) {
            httpMessage.setTag(gkR);
        } else {
            httpMessage.setTag(gkQ);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.gkS != 0) {
            this.gkS++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.gkS));
        }
        httpMessage.addParam("tab", this.gkU);
        hashMap.put("page", String.valueOf(this.gkS));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
