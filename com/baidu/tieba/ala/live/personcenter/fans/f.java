package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class f extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId eGM = BdUniqueId.gen();
    public static final BdUniqueId eGN = BdUniqueId.gen();
    private boolean anz;
    private a eGJ;
    private int eGO;
    private PersonListActivity eGP;
    private int eGQ;
    private int eGR;
    private String eGS;
    public HttpMessageListener eGT;
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
        this.eGO = 0;
        this.eGQ = 0;
        this.eGT = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.eGJ != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.eGP.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.eGJ.Y(errorString, false);
                            return;
                        }
                        return;
                    }
                    e beg = ((ResponseNetPersonListMessage) httpResponsedMessage).beg();
                    if (beg != null) {
                        if (!StringUtils.isNull(beg.cLT)) {
                            f.this.eGS = beg.cLT;
                            f.this.eGR = beg.type;
                        }
                        beg.type = f.this.eGR;
                        beg.cLT = f.this.eGS;
                    }
                    if (f.this.eGJ != null) {
                        f.this.eGJ.a(beg, false);
                    }
                }
            }
        };
        this.eGP = personListActivity;
        this.anz = false;
        this.mId = null;
        this.eGJ = aVar;
        aZq();
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

    public void is(boolean z) {
        this.anz = z;
    }

    public boolean bee() {
        return this.anz;
    }

    public void aZq() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.anz) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.eGT);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bef() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.anz) {
            httpMessage.setTag(eGN);
        } else {
            httpMessage.setTag(eGM);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.eGO != 0) {
            this.eGO++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.eGO));
        }
        httpMessage.addParam("tab", this.eGQ);
        hashMap.put("page", String.valueOf(this.eGO));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
