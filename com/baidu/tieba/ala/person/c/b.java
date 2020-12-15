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
import com.baidu.tieba.ala.person.a.d;
import com.baidu.tieba.ala.person.messages.PlaybacksResponseMessage;
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private int bbx;
    private int hKZ;
    private a hLa;
    private HttpMessageListener hLb;
    private String uid;

    /* loaded from: classes4.dex */
    public interface a {
        void a(d dVar);

        void onFail(String str);
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bbx = -1;
        this.hLb = new HttpMessageListener(1021027) { // from class: com.baidu.tieba.ala.person.c.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021027 && b.this.hLa != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof PlaybacksResponseMessage)) {
                        b.this.hLa.onFail(httpResponsedMessage.getErrorString());
                        return;
                    }
                    PlaybacksResponseMessage playbacksResponseMessage = (PlaybacksResponseMessage) httpResponsedMessage;
                    if (playbacksResponseMessage.getError() != 0) {
                        b.this.hLa.onFail(httpResponsedMessage.getErrorString());
                        return;
                    }
                    b.this.hKZ = playbacksResponseMessage.hKT.hJz.has_more;
                    b.this.hLa.a(playbacksResponseMessage.hKT);
                }
            }
        };
        this.hLb.setSelfListener(true);
        this.hLb.setTag(getUniqueId());
        registerListener(this.hLb);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        if (TextUtils.isEmpty(this.uid)) {
            return false;
        }
        return IT(this.uid);
    }

    public void setCurrentPage(int i) {
        this.bbx = i;
    }

    public boolean IT(String str) {
        this.bbx++;
        if (!TextUtils.isEmpty(str) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            HttpMessage httpMessage = new HttpMessage(1021027);
            httpMessage.addParam("user_id", str);
            httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
            httpMessage.addParam("ps", "20");
            httpMessage.addParam(Config.PACKAGE_NAME, this.bbx);
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
        this.hLa = aVar;
    }
}
