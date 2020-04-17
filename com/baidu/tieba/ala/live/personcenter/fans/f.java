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
    public static final BdUniqueId fqS = BdUniqueId.gen();
    public static final BdUniqueId fqT = BdUniqueId.gen();
    private boolean aKM;
    private a fqP;
    private int fqU;
    private PersonListActivity fqV;
    private int fqW;
    private int fqX;
    private String fqY;
    public HttpMessageListener fqZ;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        e a(e eVar, boolean z);

        void ae(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.fqU = 0;
        this.fqW = 0;
        this.fqZ = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.fqP != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.fqV.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.fqP.ae(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bqk = ((ResponseNetPersonListMessage) httpResponsedMessage).bqk();
                    if (bqk != null) {
                        if (!StringUtils.isNull(bqk.dpB)) {
                            f.this.fqY = bqk.dpB;
                            f.this.fqX = bqk.type;
                        }
                        bqk.type = f.this.fqX;
                        bqk.dpB = f.this.fqY;
                    }
                    if (f.this.fqP != null) {
                        f.this.fqP.a(bqk, false);
                    }
                }
            }
        };
        this.fqV = personListActivity;
        this.aKM = false;
        this.mId = null;
        this.fqP = aVar;
        bkZ();
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

    public void jM(boolean z) {
        this.aKM = z;
    }

    public boolean bqi() {
        return this.aKM;
    }

    private void bkZ() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.aKM) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.fqZ);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bqj() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.aKM) {
            httpMessage.setTag(fqT);
        } else {
            httpMessage.setTag(fqS);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.fqU != 0) {
            this.fqU++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.fqU));
        }
        httpMessage.addParam("tab", this.fqW);
        hashMap.put("page", String.valueOf(this.fqU));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
