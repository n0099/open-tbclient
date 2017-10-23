package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.data.f;
import com.baidu.tieba.im.message.RequestUploadClientLogMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponseUploadClientLogMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import protobuf.UploadClientLog.ClientLog;
/* loaded from: classes.dex */
public class c {
    private static c dzA;
    private static final HashMap<String, Long> dzs = new HashMap<>();
    private static final HashMap<String, Integer> dzt = new HashMap<>();
    private static final HashMap<String, Long> dzu = new HashMap<>();
    private List<b> dzv;
    private List<a> dzw;
    private String dzx = null;
    private String dzy = null;
    private long wN = -1;
    private boolean dzz = false;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.im.a.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                c.this.mHandler.removeMessages(2);
                if (c.this.axA()) {
                    c.this.wN = System.currentTimeMillis();
                    if (MessageManager.getInstance().getSocketClient().isValid()) {
                        c.this.axx();
                    }
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.axC());
            }
            if (message.what == 1) {
                c.this.mHandler.removeMessages(2);
                c.this.wN = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.axx();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.axC());
            }
            if (message.what == 3) {
                c.this.mHandler.removeMessages(3);
                c.this.axw();
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.axE());
            }
            if (message.what == 4) {
                c.this.mHandler.removeMessages(3);
                c.this.mHandler.removeMessages(2);
                c.this.wN = System.currentTimeMillis();
                c.this.axw();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.axx();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.axE());
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.axC());
            }
        }
    };
    private com.baidu.adp.framework.listener.c dzB = new com.baidu.adp.framework.listener.c(202006) { // from class: com.baidu.tieba.im.a.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (c.this.axy() && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
                PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
                if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                    b bVar = new b();
                    bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                    bVar.netType = c.this.axt();
                    bVar.dzr = c.this.axv();
                    if (c.this.dzx == null) {
                        c.this.dzx = bVar.emitTime;
                    }
                    if (c.this.dzy == null) {
                        c.this.dzy = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.c(c.this.dzy, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                        c.this.dzy = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.c(c.this.dzx, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                        c.this.dzx = bVar.emitTime;
                    }
                    c.this.dzv.add(bVar);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dzC = new com.baidu.adp.framework.listener.c(202005) { // from class: com.baidu.tieba.im.a.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseUploadClientLogMessage)) {
                c.this.dzz = false;
                if (socketResponsedMessage.getError() == 0) {
                    c.this.dzw.clear();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dzD = new com.baidu.adp.framework.listener.c(202003) { // from class: com.baidu.tieba.im.a.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePullMessage) && socketResponsedMessage.getError() == 0) {
                c.this.axp();
            }
        }
    };
    private final CustomMessageListener mAppEnterBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.a.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                c.this.axs();
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.im.a.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                c.this.mv(c.this.axt());
            }
        }
    };

    static {
        dzs.put("2g", 60L);
        dzs.put("3g", 40L);
        dzs.put("4g", 40L);
        dzs.put("wifi", 10L);
        dzt.put("2g", 10);
        dzt.put("3g", 10);
        dzt.put("4g", 10);
        dzt.put("wifi", 10);
        dzu.put("2g", 300L);
        dzu.put("3g", 60L);
        dzu.put("4g", 60L);
        dzu.put("wifi", 5L);
        dzA = null;
    }

    public String axn() {
        return this.dzy;
    }

    public String axo() {
        return this.dzx;
    }

    public void axp() {
        this.dzx = null;
        this.dzy = null;
    }

    public static synchronized c axq() {
        c cVar;
        synchronized (c.class) {
            if (dzA == null) {
                dzA = new c();
            }
            cVar = dzA;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), axE());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), axC());
    }

    public c() {
        this.dzv = null;
        this.dzw = null;
        axr();
        this.dzw = new ArrayList();
        this.dzv = new ArrayList();
    }

    private void axr() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.dzB);
        MessageManager.getInstance().registerListener(this.dzC);
        MessageManager.getInstance().registerListener(this.dzD);
        MessageManager.getInstance().registerListener(this.mAppEnterBackgroundListener);
    }

    public void axs() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void mv(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (axA() && System.currentTimeMillis() - this.wN > axC()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String axt() {
        return String.valueOf(j.hn());
    }

    public String axu() {
        switch (j.hn()) {
            case 1:
                return "wifi";
            case 2:
                return "2g";
            case 3:
                return "3g";
            case 4:
                return "4g";
            default:
                return "2g";
        }
    }

    public int axv() {
        return TbadkCoreApplication.getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axw() {
        if (!this.dzz) {
            if (this.dzv != null && this.dzv.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dzv.size()) {
                        break;
                    }
                    b bVar = this.dzv.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.dzr = bVar.dzr;
                        aVar.dzq = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dzv.size(); i3++) {
                            b bVar2 = this.dzv.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.dzr == aVar.dzr) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dzq++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dzw.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dzv.clear();
            if (this.dzw.size() > axD() && axz() && j.hh()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dzw.size() > 100 && !axA() && !axz()) {
                this.dzw.clear();
            }
        }
    }

    public void axx() {
        if (this.dzw.size() > 0) {
            this.dzz = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dzw) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.dzq);
                builder.process_type = Integer.valueOf(aVar.dzr);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axy() {
        String str;
        f axB = axB();
        return (axB == null || (str = axB.azd) == null || !str.equals("1")) ? false : true;
    }

    private boolean axz() {
        String str;
        f axB = axB();
        return axB == null || (str = axB.azb.get(axu())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axA() {
        String str;
        f axB = axB();
        return axB == null || (str = axB.aza.get(axu())) == null || !str.equals("-1");
    }

    private f axB() {
        return f.BM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long axC() {
        String str;
        f axB = axB();
        if (axB != null && (str = axB.aza.get(axu())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dzs.get(axu()).longValue() * 1000;
    }

    private int axD() {
        String str;
        int g;
        f axB = axB();
        return (axB == null || (str = axB.azb.get(axu())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dzt.get(axu()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long axE() {
        String str;
        int g;
        f axB = axB();
        return (axB == null || (str = axB.azc.get(axu())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dzu.get(axu()).longValue() * 1000 : g * 1000;
    }
}
