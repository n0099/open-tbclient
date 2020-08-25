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
    public static final BdUniqueId ghD = BdUniqueId.gen();
    public static final BdUniqueId ghE = BdUniqueId.gen();
    private boolean aZT;
    private a ghA;
    private int ghF;
    private PersonListActivity ghG;
    private int ghH;
    private int ghI;
    private String ghJ;
    public HttpMessageListener ghK;
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
        this.ghF = 0;
        this.ghH = 0;
        this.ghK = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.ghA != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.ghG.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.ghA.av(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bLG = ((ResponseNetPersonListMessage) httpResponsedMessage).bLG();
                    if (bLG != null) {
                        if (!StringUtils.isNull(bLG.dZF)) {
                            f.this.ghJ = bLG.dZF;
                            f.this.ghI = bLG.type;
                        }
                        bLG.type = f.this.ghI;
                        bLG.dZF = f.this.ghJ;
                    }
                    if (f.this.ghA != null) {
                        f.this.ghA.a(bLG, false);
                    }
                }
            }
        };
        this.ghG = personListActivity;
        this.aZT = false;
        this.mId = null;
        this.ghA = aVar;
        bFB();
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

    public void lx(boolean z) {
        this.aZT = z;
    }

    public boolean bLE() {
        return this.aZT;
    }

    private void bFB() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.aZT) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.ghK);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bLF() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.aZT) {
            httpMessage.setTag(ghE);
        } else {
            httpMessage.setTag(ghD);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.ghF != 0) {
            this.ghF++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.ghF));
        }
        httpMessage.addParam("tab", this.ghH);
        hashMap.put("page", String.valueOf(this.ghF));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
