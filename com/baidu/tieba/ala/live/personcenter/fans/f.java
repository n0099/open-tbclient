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
/* loaded from: classes11.dex */
public class f extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId hlr = BdUniqueId.gen();
    public static final BdUniqueId hls = BdUniqueId.gen();
    private boolean blC;
    private int cdp;
    private a hlo;
    private PersonListActivity hlt;
    private int hlu;
    private int hlv;
    private String hlw;
    public HttpMessageListener hlx;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface a {
        e a(e eVar, boolean z);

        void aC(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.cdp = 0;
        this.hlu = 0;
        this.hlx = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.hlo != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.hlt.getResources().getString(a.h.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.hlo.aC(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bYC = ((ResponseNetPersonListMessage) httpResponsedMessage).bYC();
                    if (bYC != null) {
                        if (!StringUtils.isNull(bYC.eOV)) {
                            f.this.hlw = bYC.eOV;
                            f.this.hlv = bYC.type;
                        }
                        bYC.type = f.this.hlv;
                        bYC.eOV = f.this.hlw;
                    }
                    if (f.this.hlo != null) {
                        f.this.hlo.a(bYC, false);
                    }
                }
            }
        };
        this.hlt = personListActivity;
        this.blC = false;
        this.mId = null;
        this.hlo = aVar;
        bRh();
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

    public void bz(boolean z) {
        this.blC = z;
    }

    public boolean bYA() {
        return this.blC;
    }

    private void bRh() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.blC) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.hlx);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bYB() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.blC) {
            httpMessage.setTag(hls);
        } else {
            httpMessage.setTag(hlr);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.cdp != 0) {
            this.cdp++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.cdp));
        }
        httpMessage.addParam("tab", this.hlu);
        hashMap.put("page", String.valueOf(this.cdp));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
