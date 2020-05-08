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
    public static final BdUniqueId fqX = BdUniqueId.gen();
    public static final BdUniqueId fqY = BdUniqueId.gen();
    private boolean aKS;
    private a fqU;
    private int fqZ;
    private PersonListActivity fra;
    private int frb;
    private int frd;
    private String fre;
    public HttpMessageListener frf;
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
        this.fqZ = 0;
        this.frb = 0;
        this.frf = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.fqU != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.fra.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.fqU.ae(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bqi = ((ResponseNetPersonListMessage) httpResponsedMessage).bqi();
                    if (bqi != null) {
                        if (!StringUtils.isNull(bqi.dpF)) {
                            f.this.fre = bqi.dpF;
                            f.this.frd = bqi.type;
                        }
                        bqi.type = f.this.frd;
                        bqi.dpF = f.this.fre;
                    }
                    if (f.this.fqU != null) {
                        f.this.fqU.a(bqi, false);
                    }
                }
            }
        };
        this.fra = personListActivity;
        this.aKS = false;
        this.mId = null;
        this.fqU = aVar;
        bkX();
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
        this.aKS = z;
    }

    public boolean bqg() {
        return this.aKS;
    }

    private void bkX() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.aKS) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.frf);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bqh() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.aKS) {
            httpMessage.setTag(fqY);
        } else {
            httpMessage.setTag(fqX);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.fqZ != 0) {
            this.fqZ++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.fqZ));
        }
        httpMessage.addParam("tab", this.frb);
        hashMap.put("page", String.valueOf(this.fqZ));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
