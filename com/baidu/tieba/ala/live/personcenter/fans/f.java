package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class f extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId eHW = BdUniqueId.gen();
    public static final BdUniqueId eHX = BdUniqueId.gen();
    private boolean aom;
    private a eHT;
    private int eHY;
    private PersonListActivity eHZ;
    private int eIa;
    private int eIb;
    private String eIc;
    public HttpMessageListener eId;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void Y(String str, boolean z);

        e a(e eVar, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.eHY = 0;
        this.eIa = 0;
        this.eId = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.eHT != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.eHZ.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.eHT.Y(errorString, false);
                            return;
                        }
                        return;
                    }
                    e beB = ((ResponseNetPersonListMessage) httpResponsedMessage).beB();
                    if (beB != null) {
                        if (!StringUtils.isNull(beB.cMd)) {
                            f.this.eIc = beB.cMd;
                            f.this.eIb = beB.type;
                        }
                        beB.type = f.this.eIb;
                        beB.cMd = f.this.eIc;
                    }
                    if (f.this.eHT != null) {
                        f.this.eHT.a(beB, false);
                    }
                }
            }
        };
        this.eHZ = personListActivity;
        this.aom = false;
        this.mId = null;
        this.eHT = aVar;
        aZL();
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

    public void iC(boolean z) {
        this.aom = z;
    }

    public boolean bez() {
        return this.aom;
    }

    public void aZL() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.aom) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.eId);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void beA() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.aom) {
            httpMessage.setTag(eHX);
        } else {
            httpMessage.setTag(eHW);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.eHY != 0) {
            this.eHY++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.eHY));
        }
        httpMessage.addParam("tab", this.eIa);
        hashMap.put("page", String.valueOf(this.eHY));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
