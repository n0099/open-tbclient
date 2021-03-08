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
/* loaded from: classes10.dex */
public class f extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId hna = BdUniqueId.gen();
    public static final BdUniqueId hnb = BdUniqueId.gen();
    private boolean bnd;
    private int ceQ;
    private a hmX;
    private PersonListActivity hnc;
    private int hnd;
    private int hne;
    private String hnf;
    public HttpMessageListener hng;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface a {
        e a(e eVar, boolean z);

        void aC(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.ceQ = 0;
        this.hnd = 0;
        this.hng = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.hmX != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.hnc.getResources().getString(a.h.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.hmX.aC(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bYI = ((ResponseNetPersonListMessage) httpResponsedMessage).bYI();
                    if (bYI != null) {
                        if (!StringUtils.isNull(bYI.eQw)) {
                            f.this.hnf = bYI.eQw;
                            f.this.hne = bYI.type;
                        }
                        bYI.type = f.this.hne;
                        bYI.eQw = f.this.hnf;
                    }
                    if (f.this.hmX != null) {
                        f.this.hmX.a(bYI, false);
                    }
                }
            }
        };
        this.hnc = personListActivity;
        this.bnd = false;
        this.mId = null;
        this.hmX = aVar;
        bRn();
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
        this.bnd = z;
    }

    public boolean bYG() {
        return this.bnd;
    }

    private void bRn() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bnd) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.hng);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bYH() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.bnd) {
            httpMessage.setTag(hnb);
        } else {
            httpMessage.setTag(hna);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.ceQ != 0) {
            this.ceQ++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.ceQ));
        }
        httpMessage.addParam("tab", this.hnd);
        hashMap.put("page", String.valueOf(this.ceQ));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
