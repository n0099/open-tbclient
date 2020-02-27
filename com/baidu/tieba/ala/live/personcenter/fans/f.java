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
    public static final BdUniqueId eLQ = BdUniqueId.gen();
    public static final BdUniqueId eLR = BdUniqueId.gen();
    private boolean arE;
    private a eLN;
    private int eLS;
    private PersonListActivity eLT;
    private int eLU;
    private int eLV;
    private String eLW;
    public HttpMessageListener eLX;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void Y(String str, boolean z);

        e a(e eVar, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.eLS = 0;
        this.eLU = 0;
        this.eLX = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.eLN != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.eLT.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.eLN.Y(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bgL = ((ResponseNetPersonListMessage) httpResponsedMessage).bgL();
                    if (bgL != null) {
                        if (!StringUtils.isNull(bgL.cQg)) {
                            f.this.eLW = bgL.cQg;
                            f.this.eLV = bgL.type;
                        }
                        bgL.type = f.this.eLV;
                        bgL.cQg = f.this.eLW;
                    }
                    if (f.this.eLN != null) {
                        f.this.eLN.a(bgL, false);
                    }
                }
            }
        };
        this.eLT = personListActivity;
        this.arE = false;
        this.mId = null;
        this.eLN = aVar;
        bcb();
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

    public void iJ(boolean z) {
        this.arE = z;
    }

    public boolean bgJ() {
        return this.arE;
    }

    private void bcb() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.arE) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.eLX);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bgK() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.arE) {
            httpMessage.setTag(eLR);
        } else {
            httpMessage.setTag(eLQ);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.eLS != 0) {
            this.eLS++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.eLS));
        }
        httpMessage.addParam("tab", this.eLU);
        hashMap.put("page", String.valueOf(this.eLS));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
