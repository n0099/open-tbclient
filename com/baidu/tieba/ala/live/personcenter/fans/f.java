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
    public static final BdUniqueId eLR = BdUniqueId.gen();
    public static final BdUniqueId eLS = BdUniqueId.gen();
    private boolean arE;
    private a eLO;
    private int eLT;
    private PersonListActivity eLU;
    private int eLV;
    private int eLW;
    private String eLX;
    public HttpMessageListener eLY;
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
        this.eLT = 0;
        this.eLV = 0;
        this.eLY = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.eLO != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.eLU.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.eLO.Y(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bgN = ((ResponseNetPersonListMessage) httpResponsedMessage).bgN();
                    if (bgN != null) {
                        if (!StringUtils.isNull(bgN.cQh)) {
                            f.this.eLX = bgN.cQh;
                            f.this.eLW = bgN.type;
                        }
                        bgN.type = f.this.eLW;
                        bgN.cQh = f.this.eLX;
                    }
                    if (f.this.eLO != null) {
                        f.this.eLO.a(bgN, false);
                    }
                }
            }
        };
        this.eLU = personListActivity;
        this.arE = false;
        this.mId = null;
        this.eLO = aVar;
        bcd();
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
        this.arE = z;
    }

    public boolean bgL() {
        return this.arE;
    }

    private void bcd() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.arE) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.eLY);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bgM() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.arE) {
            httpMessage.setTag(eLS);
        } else {
            httpMessage.setTag(eLR);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.eLT != 0) {
            this.eLT++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.eLT));
        }
        httpMessage.addParam("tab", this.eLV);
        hashMap.put("page", String.valueOf(this.eLT));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
