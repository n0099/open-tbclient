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
    private boolean aAr = true;
    private String cacheKey;

    protected abstract NetMessage HY();

    protected abstract String HZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Class<? extends HttpResponsedMessage> Ia();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Class<? extends SocketResponsedMessage> Ib();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(HttpResponsedMessage httpResponsedMessage);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void e(SocketResponsedMessage socketResponsedMessage);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e(bundle);
        if (HT() && !StringUtils.isNull(this.cacheKey)) {
            HU();
        } else if (HV()) {
            HX();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (this.aAr) {
                this.aAr = false;
                showLoadingView(abS(), true);
                return;
            }
            return;
        }
        hideLoadingView(abS());
    }

    protected boolean HT() {
        return true;
    }

    private void HU() {
        MessageManager.getInstance().registerTask(new CustomMessageTask(2001239, new c()));
        registerListener(HW());
        sendMessage(new CacheReadRequest(this.cacheKey));
    }

    protected boolean HV() {
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

    private CustomMessageListener HW() {
        return new b(this, 2001239, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HX() {
        NetMessage HY = HY();
        if (HY != null) {
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.registerTask(a(HY, HZ(), Ia()));
            messageManager.registerTask(a(HY, Ib()));
            registerListener(a(HY));
            sendMessage(HY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EI() {
    }
}
