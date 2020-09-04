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
/* loaded from: classes7.dex */
public class f extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId ghH = BdUniqueId.gen();
    public static final BdUniqueId ghI = BdUniqueId.gen();
    private boolean aZV;
    private a ghE;
    private int ghJ;
    private PersonListActivity ghK;
    private int ghL;
    private int ghM;
    private String ghN;
    public HttpMessageListener ghO;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a {
        e a(e eVar, boolean z);

        void av(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.ghJ = 0;
        this.ghL = 0;
        this.ghO = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.ghE != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.ghK.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.ghE.av(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bLH = ((ResponseNetPersonListMessage) httpResponsedMessage).bLH();
                    if (bLH != null) {
                        if (!StringUtils.isNull(bLH.dZJ)) {
                            f.this.ghN = bLH.dZJ;
                            f.this.ghM = bLH.type;
                        }
                        bLH.type = f.this.ghM;
                        bLH.dZJ = f.this.ghN;
                    }
                    if (f.this.ghE != null) {
                        f.this.ghE.a(bLH, false);
                    }
                }
            }
        };
        this.ghK = personListActivity;
        this.aZV = false;
        this.mId = null;
        this.ghE = aVar;
        bFC();
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

    public void lz(boolean z) {
        this.aZV = z;
    }

    public boolean bLF() {
        return this.aZV;
    }

    private void bFC() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.aZV) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.ghO);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bLG() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.aZV) {
            httpMessage.setTag(ghI);
        } else {
            httpMessage.setTag(ghH);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.ghJ != 0) {
            this.ghJ++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.ghJ));
        }
        httpMessage.addParam("tab", this.ghL);
        hashMap.put("page", String.valueOf(this.ghJ));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
