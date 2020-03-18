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
    public static final BdUniqueId eMA = BdUniqueId.gen();
    public static final BdUniqueId eMB = BdUniqueId.gen();
    private boolean arP;
    private int eMC;
    private PersonListActivity eMD;
    private int eME;
    private int eMF;
    private String eMG;
    public HttpMessageListener eMH;
    private a eMx;
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
        this.eMC = 0;
        this.eME = 0;
        this.eMH = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.eMx != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.eMD.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.eMx.Y(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bgT = ((ResponseNetPersonListMessage) httpResponsedMessage).bgT();
                    if (bgT != null) {
                        if (!StringUtils.isNull(bgT.cQv)) {
                            f.this.eMG = bgT.cQv;
                            f.this.eMF = bgT.type;
                        }
                        bgT.type = f.this.eMF;
                        bgT.cQv = f.this.eMG;
                    }
                    if (f.this.eMx != null) {
                        f.this.eMx.a(bgT, false);
                    }
                }
            }
        };
        this.eMD = personListActivity;
        this.arP = false;
        this.mId = null;
        this.eMx = aVar;
        bci();
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

    public void iL(boolean z) {
        this.arP = z;
    }

    public boolean bgR() {
        return this.arP;
    }

    private void bci() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.arP) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.eMH);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bgS() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.arP) {
            httpMessage.setTag(eMB);
        } else {
            httpMessage.setTag(eMA);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.eMC != 0) {
            this.eMC++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.eMC));
        }
        httpMessage.addParam("tab", this.eME);
        hashMap.put("page", String.valueOf(this.eMC));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
