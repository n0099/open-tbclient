package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.coreExtra.message.PingMessage;
import com.baidu.tbadk.coreExtra.message.ResponsedPingMessage;
/* loaded from: classes.dex */
public class PingManager extends Handler implements com.baidu.adp.framework.client.socket.b {
    private static PingManager a = null;
    private long b = 0;
    private int c = 180000;
    private int d = 900000;
    private int e = this.d;
    private PingMessage f = null;

    public static PingManager d() {
        if (a == null) {
            synchronized (PingManager.class) {
                if (a == null) {
                    a = new PingManager();
                }
            }
        }
        return a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                b();
                a(true, "regular time send");
                return;
            default:
                return;
        }
    }

    private void a(String str) {
        if (BdSocketLinkService.isClose()) {
            BdSocketLinkService.startService(false, str);
        } else if (BdSocketLinkService.isOpen()) {
            a(false, str);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public boolean a(boolean z, String str) {
        if ((z || System.currentTimeMillis() - this.b >= 180000) && BdSocketLinkService.isOpen()) {
            this.b = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(this.f);
            com.baidu.adp.framework.client.socket.m.a("PingManager", this.f.getCmd(), 0, "send_ping", 0, String.valueOf(str) + "-" + (this.e == this.d ? "back" : "fore"));
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void a() {
        removeMessages(1);
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public void b() {
        removeMessages(1);
        sendMessageDelayed(obtainMessage(1), this.e);
        this.b = System.currentTimeMillis();
    }

    public void e() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(1003);
        bVar.a(ResponsedPingMessage.class);
        bVar.b(false);
        bVar.setPriority(-3);
        bVar.a(SocketMessageTask.DupLicateMode.REMOVE_ME);
        bVar.c(false);
        MessageManager.getInstance().registerTask(bVar);
        this.f = new PingMessage();
        f();
        n nVar = new n(this, 1003);
        MessageManager.getInstance().registerListener(new o(this, 2001011));
        MessageManager.getInstance().registerListener(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (responsedMessage.getError() == 0) {
                com.baidu.adp.framework.client.socket.m.a("PingManager", this.f.getCmd(), 0, "ping_succ", com.baidu.tbadk.core.g.f, (String) null);
                return;
            }
            BdSocketLinkService.close(7, "ping error");
            com.baidu.adp.framework.client.socket.m.a("PingManager", this.f.getCmd(), 0, "ping_err", com.baidu.tbadk.core.g.e, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackgroundSwitchMessage backgroundSwitchMessage) {
        if (backgroundSwitchMessage != null) {
            if (backgroundSwitchMessage.getData().booleanValue()) {
                this.e = this.d;
                return;
            }
            this.e = this.c;
            a("switchToForeground");
        }
    }

    public void f() {
        int[] socketHeartBeatStratgy = TbadkApplication.m252getInst().getSocketHeartBeatStratgy();
        if (socketHeartBeatStratgy.length == 2) {
            this.c = socketHeartBeatStratgy[0] * 1000;
            this.d = socketHeartBeatStratgy[1] * 1000;
            if (this.c < 180000) {
                this.c = 180000;
            }
            if (this.d < 180000) {
                this.d = 180000;
            }
        }
    }

    public int g() {
        return this.c;
    }

    @Override // com.baidu.adp.framework.client.socket.b
    public int c() {
        return 1003;
    }

    /* loaded from: classes.dex */
    class PingResponsedMessage extends SocketResponsedMessage {
        public PingResponsedMessage() {
            super(1003);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.b
        public void decodeInBackGround(int i, byte[] bArr) {
        }
    }
}
