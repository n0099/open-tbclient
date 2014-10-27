package com.baidu.tieba.game.base;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.ai;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
/* loaded from: classes.dex */
public abstract class AbsGameClassifyActivity extends NavigationBarActivity {
    private String cacheKey;

    protected abstract NetMessage HU();

    protected abstract String HV();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Class<? extends HttpResponsedMessage> HW();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Class<? extends SocketResponsedMessage> HX();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void d(HttpResponsedMessage httpResponsedMessage);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void e(SocketResponsedMessage socketResponsedMessage);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e(bundle);
        showLoadingView(abP(), true);
        if (HP() && !StringUtils.isNull(this.cacheKey)) {
            HQ();
        } else if (HR()) {
            HT();
        }
    }

    protected boolean HP() {
        return true;
    }

    private void HQ() {
        MessageManager.getInstance().registerTask(new CustomMessageTask(2001239, new c()));
        registerListener(HS());
        sendMessage(new CacheReadRequest(this.cacheKey));
    }

    protected boolean HR() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fx(String str) {
        this.cacheKey = str;
    }

    private HttpMessageTask a(NetMessage netMessage, String str, Class<? extends HttpResponsedMessage> cls) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        HttpMessageTask httpMessageTask = new HttpMessageTask(netMessage.getHttpMessage().getCmd(), ai.s(str, netMessage.getSocketMessage().getCmd()));
        httpMessageTask.setResponsedClass(cls);
        return httpMessageTask;
    }

    private SocketMessageTask a(NetMessage netMessage, Class<? extends SocketResponsedMessage> cls) {
        SocketMessageTask socketMessageTask = new SocketMessageTask(netMessage.getSocketMessage().getCmd());
        socketMessageTask.e(true);
        socketMessageTask.setResponsedClass(cls);
        socketMessageTask.f(false);
        return socketMessageTask;
    }

    private com.baidu.adp.framework.listener.a a(NetMessage netMessage) {
        return new a(this, netMessage.getHttpMessage().getCmd(), netMessage.getSocketMessage().getCmd());
    }

    private CustomMessageListener HS() {
        return new b(this, 2001239, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HT() {
        NetMessage HU = HU();
        if (HU != null) {
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.registerTask(a(HU, HV(), HW()));
            messageManager.registerTask(a(HU, HX()));
            registerListener(a(HU));
            sendMessage(HU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EG() {
    }
}
