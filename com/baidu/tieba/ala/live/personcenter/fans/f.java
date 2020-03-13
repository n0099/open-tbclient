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
    public static final BdUniqueId eMe = BdUniqueId.gen();
    public static final BdUniqueId eMf = BdUniqueId.gen();
    private boolean arF;
    private a eMb;
    private int eMg;
    private PersonListActivity eMh;
    private int eMi;
    private int eMj;
    private String eMk;
    public HttpMessageListener eMl;
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
        this.eMg = 0;
        this.eMi = 0;
        this.eMl = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.eMb != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.eMh.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.eMb.Y(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bgO = ((ResponseNetPersonListMessage) httpResponsedMessage).bgO();
                    if (bgO != null) {
                        if (!StringUtils.isNull(bgO.cQi)) {
                            f.this.eMk = bgO.cQi;
                            f.this.eMj = bgO.type;
                        }
                        bgO.type = f.this.eMj;
                        bgO.cQi = f.this.eMk;
                    }
                    if (f.this.eMb != null) {
                        f.this.eMb.a(bgO, false);
                    }
                }
            }
        };
        this.eMh = personListActivity;
        this.arF = false;
        this.mId = null;
        this.eMb = aVar;
        bce();
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
        this.arF = z;
    }

    public boolean bgM() {
        return this.arF;
    }

    private void bce() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.arF) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.eMl);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bgN() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.arF) {
            httpMessage.setTag(eMf);
        } else {
            httpMessage.setTag(eMe);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.eMg != 0) {
            this.eMg++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.eMg));
        }
        httpMessage.addParam("tab", this.eMi);
        hashMap.put("page", String.valueOf(this.eMg));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
