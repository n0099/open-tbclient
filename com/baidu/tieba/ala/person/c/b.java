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
/* loaded from: classes7.dex */
public class b extends BdBaseModel {
    private int aRK;
    private int gRi;
    private a gRj;
    private HttpMessageListener gRk;
    private String uid;

    /* loaded from: classes7.dex */
    public interface a {
        void a(e eVar);

        void onFail(String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aRK = -1;
        this.gRk = new HttpMessageListener(1021027) { // from class: com.baidu.tieba.ala.person.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021027 && b.this.gRj != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PlaybacksResponseMessage)) {
                        b.this.gRj.onFail(httpResponsedMessage.getErrorString());
                        return;
                    }
                    PlaybacksResponseMessage playbacksResponseMessage = (PlaybacksResponseMessage) httpResponsedMessage;
                    if (playbacksResponseMessage.getError() != 0) {
                        b.this.gRj.onFail(httpResponsedMessage.getErrorString());
                        return;
                    }
                    b.this.gRi = playbacksResponseMessage.gRc.gPI.has_more;
                    b.this.gRj.a(playbacksResponseMessage.gRc);
                }
            }
        };
        this.gRk.setSelfListener(true);
        this.gRk.setTag(getUniqueId());
        registerListener(this.gRk);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        if (TextUtils.isEmpty(this.uid)) {
            return false;
        }
        return GF(this.uid);
    }

    public void setCurrentPage(int i) {
        this.aRK = i;
    }

    public boolean GF(String str) {
        this.aRK++;
        if (!TextUtils.isEmpty(str) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            HttpMessage httpMessage = new HttpMessage(1021027);
            httpMessage.addParam("user_id", str);
            httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
            httpMessage.addParam("ps", "20");
            httpMessage.addParam(Config.PACKAGE_NAME, this.aRK);
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
        this.gRj = aVar;
    }
}
