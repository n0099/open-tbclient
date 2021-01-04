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
    public static final BdUniqueId hlu = BdUniqueId.gen();
    public static final BdUniqueId hlv = BdUniqueId.gen();
    private boolean bmX;
    private int cea;
    public HttpMessageListener hlA;
    private a hlr;
    private PersonListActivity hlw;
    private int hlx;
    private int hly;
    private String hlz;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface a {
        e a(e eVar, boolean z);

        void aD(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.cea = 0;
        this.hlx = 0;
        this.hlA = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.hlr != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.hlw.getResources().getString(a.h.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.hlr.aD(errorString, false);
                            return;
                        }
                        return;
                    }
                    e cbm = ((ResponseNetPersonListMessage) httpResponsedMessage).cbm();
                    if (cbm != null) {
                        if (!StringUtils.isNull(cbm.eRu)) {
                            f.this.hlz = cbm.eRu;
                            f.this.hly = cbm.type;
                        }
                        cbm.type = f.this.hly;
                        cbm.eRu = f.this.hlz;
                    }
                    if (f.this.hlr != null) {
                        f.this.hlr.a(cbm, false);
                    }
                }
            }
        };
        this.hlw = personListActivity;
        this.bmX = false;
        this.mId = null;
        this.hlr = aVar;
        bUn();
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

    public void by(boolean z) {
        this.bmX = z;
    }

    public boolean cbk() {
        return this.bmX;
    }

    private void bUn() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bmX) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.hlA);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void cbl() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.bmX) {
            httpMessage.setTag(hlv);
        } else {
            httpMessage.setTag(hlu);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.cea != 0) {
            this.cea++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.cea));
        }
        httpMessage.addParam("tab", this.hlx);
        hashMap.put("page", String.valueOf(this.cea));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
