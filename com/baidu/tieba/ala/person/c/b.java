package com.baidu.tieba.ala.person.c;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.person.a.e;
import com.baidu.tieba.ala.person.messages.PlaybacksResponseMessage;
/* loaded from: classes6.dex */
public class b extends BdBaseModel {
    private int ZN;
    private int evJ;
    private a evK;
    private HttpMessageListener evL;
    private String uid;

    /* loaded from: classes6.dex */
    public interface a {
        void a(e eVar);

        void onFail(String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ZN = -1;
        this.evL = new HttpMessageListener(1021027) { // from class: com.baidu.tieba.ala.person.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021027 && b.this.evK != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PlaybacksResponseMessage)) {
                        b.this.evK.onFail(httpResponsedMessage.getErrorString());
                        return;
                    }
                    PlaybacksResponseMessage playbacksResponseMessage = (PlaybacksResponseMessage) httpResponsedMessage;
                    if (playbacksResponseMessage.getError() != 0) {
                        b.this.evK.onFail(httpResponsedMessage.getErrorString());
                        return;
                    }
                    b.this.evJ = playbacksResponseMessage.evD.euh.has_more;
                    b.this.evK.a(playbacksResponseMessage.evD);
                }
            }
        };
        this.evL.setSelfListener(true);
        this.evL.setTag(getUniqueId());
        registerListener(this.evL);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        if (TextUtils.isEmpty(this.uid)) {
            return false;
        }
        return uh(this.uid);
    }

    public void setCurrentPage(int i) {
        this.ZN = i;
    }

    public boolean uh(String str) {
        this.ZN++;
        if (!TextUtils.isEmpty(str) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            HttpMessage httpMessage = new HttpMessage(1021027);
            httpMessage.addParam("user_id", str);
            httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
            httpMessage.addParam("ps", "20");
            httpMessage.addParam(Config.PACKAGE_NAME, this.ZN);
            httpMessage.addParam("need_records", 1);
            sendMessage(httpMessage);
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void a(a aVar) {
        this.evK = aVar;
    }
}
