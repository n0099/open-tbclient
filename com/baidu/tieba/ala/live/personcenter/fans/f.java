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
/* loaded from: classes4.dex */
public class f extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId fVE = BdUniqueId.gen();
    public static final BdUniqueId fVF = BdUniqueId.gen();
    private boolean aUF;
    private a fVB;
    private int fVG;
    private PersonListActivity fVH;
    private int fVI;
    private int fVJ;
    private String fVK;
    public HttpMessageListener fVL;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        e a(e eVar, boolean z);

        void ar(String str, boolean z);
    }

    public f(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.fVG = 0;
        this.fVI = 0;
        this.fVL = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (f.this.fVB != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = f.this.fVH.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            f.this.fVB.ar(errorString, false);
                            return;
                        }
                        return;
                    }
                    e bCm = ((ResponseNetPersonListMessage) httpResponsedMessage).bCm();
                    if (bCm != null) {
                        if (!StringUtils.isNull(bCm.dQm)) {
                            f.this.fVK = bCm.dQm;
                            f.this.fVJ = bCm.type;
                        }
                        bCm.type = f.this.fVJ;
                        bCm.dQm = f.this.fVK;
                    }
                    if (f.this.fVB != null) {
                        f.this.fVB.a(bCm, false);
                    }
                }
            }
        };
        this.fVH = personListActivity;
        this.aUF = false;
        this.mId = null;
        this.fVB = aVar;
        bwC();
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

    public void kX(boolean z) {
        this.aUF = z;
    }

    public boolean bCk() {
        return this.aUF;
    }

    private void bwC() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.aUF) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.fVL);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void bCl() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.aUF) {
            httpMessage.setTag(fVF);
        } else {
            httpMessage.setTag(fVE);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.fVG != 0) {
            this.fVG++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.fVG));
        }
        httpMessage.addParam("tab", this.fVI);
        hashMap.put("page", String.valueOf(this.fVG));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
