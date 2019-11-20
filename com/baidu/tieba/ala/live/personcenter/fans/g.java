package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class g extends BdBaseModel<PersonListActivity> {
    public static final BdUniqueId dRf = BdUniqueId.gen();
    public static final BdUniqueId dRg = BdUniqueId.gen();
    private boolean afx;
    private a dRc;
    private int dRh;
    private PersonListActivity dRi;
    private int dRj;
    private int dRk;
    private String dRl;
    public HttpMessageListener dRm;
    private String mId;
    private int mSex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        void U(String str, boolean z);

        f a(f fVar, boolean z);
    }

    public g(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.dRh = 0;
        this.dRj = 0;
        this.dRm = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.ala.live.personcenter.fans.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (g.this.dRc != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = g.this.dRi.getResources().getString(a.i.sdk_neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            g.this.dRc.U(errorString, false);
                            return;
                        }
                        return;
                    }
                    f aMB = ((ResponseNetPersonListMessage) httpResponsedMessage).aMB();
                    if (aMB != null) {
                        if (!StringUtils.isNull(aMB.bZB)) {
                            g.this.dRl = aMB.bZB;
                            g.this.dRk = aMB.type;
                        }
                        aMB.type = g.this.dRk;
                        aMB.bZB = g.this.dRl;
                    }
                    if (g.this.dRc != null) {
                        g.this.dRc.a(aMB, false);
                    }
                }
            }
        };
        this.dRi = personListActivity;
        this.afx = false;
        this.mId = null;
        this.dRc = aVar;
        aIS();
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

    public void hi(boolean z) {
        this.afx = z;
    }

    public boolean aMz() {
        return this.afx;
    }

    public void aIS() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.afx) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.dRm);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void aMA() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.afx) {
            httpMessage.setTag(dRg);
        } else {
            httpMessage.setTag(dRf);
        }
        httpMessage.addParam("uid", this.mId);
        hashMap.put("id", String.valueOf(this.mId));
        if (this.dRh != 0) {
            this.dRh++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.dRh));
        }
        httpMessage.addParam("tab", this.dRj);
        hashMap.put("page", String.valueOf(this.dRh));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
