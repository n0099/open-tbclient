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
import com.baidu.tbadk.data.h;
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
    private static final HashMap<String, Long> dHg = new HashMap<>();
    private static final HashMap<String, Integer> dHh = new HashMap<>();
    private static final HashMap<String, Long> dHi = new HashMap<>();
    private static c dHo;
    private List<b> dHj;
    private List<a> dHk;
    private String dHl = null;
    private String dHm = null;
    private long wN = -1;
    private boolean dHn = false;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.im.a.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                c.this.mHandler.removeMessages(2);
                if (c.this.azV()) {
                    c.this.wN = System.currentTimeMillis();
                    if (MessageManager.getInstance().getSocketClient().isValid()) {
                        c.this.azS();
                    }
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.azX());
            }
            if (message.what == 1) {
                c.this.mHandler.removeMessages(2);
                c.this.wN = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.azS();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.azX());
            }
            if (message.what == 3) {
                c.this.mHandler.removeMessages(3);
                c.this.azR();
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.azZ());
            }
            if (message.what == 4) {
                c.this.mHandler.removeMessages(3);
                c.this.mHandler.removeMessages(2);
                c.this.wN = System.currentTimeMillis();
                c.this.azR();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.azS();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.azZ());
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.azX());
            }
        }
    };
    private com.baidu.adp.framework.listener.c dHp = new com.baidu.adp.framework.listener.c(202006) { // from class: com.baidu.tieba.im.a.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (c.this.azT() && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
                PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
                if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                    b bVar = new b();
                    bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                    bVar.netType = c.this.azO();
                    bVar.dHf = c.this.azQ();
                    if (c.this.dHl == null) {
                        c.this.dHl = bVar.emitTime;
                    }
                    if (c.this.dHm == null) {
                        c.this.dHm = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.c(c.this.dHm, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                        c.this.dHm = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.c(c.this.dHl, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                        c.this.dHl = bVar.emitTime;
                    }
                    c.this.dHj.add(bVar);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dHq = new com.baidu.adp.framework.listener.c(202005) { // from class: com.baidu.tieba.im.a.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseUploadClientLogMessage)) {
                c.this.dHn = false;
                if (socketResponsedMessage.getError() == 0) {
                    c.this.dHk.clear();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dHr = new com.baidu.adp.framework.listener.c(202003) { // from class: com.baidu.tieba.im.a.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePullMessage) && socketResponsedMessage.getError() == 0) {
                c.this.azK();
            }
        }
    };
    private final CustomMessageListener mAppEnterBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.a.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                c.this.azN();
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.im.a.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                c.this.mQ(c.this.azO());
            }
        }
    };

    static {
        dHg.put("2g", 60L);
        dHg.put("3g", 40L);
        dHg.put("4g", 40L);
        dHg.put("wifi", 10L);
        dHh.put("2g", 10);
        dHh.put("3g", 10);
        dHh.put("4g", 10);
        dHh.put("wifi", 10);
        dHi.put("2g", 300L);
        dHi.put("3g", 60L);
        dHi.put("4g", 60L);
        dHi.put("wifi", 5L);
        dHo = null;
    }

    public String azI() {
        return this.dHm;
    }

    public String azJ() {
        return this.dHl;
    }

    public void azK() {
        this.dHl = null;
        this.dHm = null;
    }

    public static synchronized c azL() {
        c cVar;
        synchronized (c.class) {
            if (dHo == null) {
                dHo = new c();
            }
            cVar = dHo;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), azZ());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), azX());
    }

    public c() {
        this.dHj = null;
        this.dHk = null;
        azM();
        this.dHk = new ArrayList();
        this.dHj = new ArrayList();
    }

    private void azM() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.dHp);
        MessageManager.getInstance().registerListener(this.dHq);
        MessageManager.getInstance().registerListener(this.dHr);
        MessageManager.getInstance().registerListener(this.mAppEnterBackgroundListener);
    }

    public void azN() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void mQ(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (azV() && System.currentTimeMillis() - this.wN > azX()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String azO() {
        return String.valueOf(j.hn());
    }

    public String azP() {
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

    public int azQ() {
        return TbadkCoreApplication.getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azR() {
        if (!this.dHn) {
            if (this.dHj != null && this.dHj.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dHj.size()) {
                        break;
                    }
                    b bVar = this.dHj.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.dHf = bVar.dHf;
                        aVar.dHe = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dHj.size(); i3++) {
                            b bVar2 = this.dHj.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.dHf == aVar.dHf) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dHe++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dHk.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dHj.clear();
            if (this.dHk.size() > azY() && azU() && j.hh()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dHk.size() > 100 && !azV() && !azU()) {
                this.dHk.clear();
            }
        }
    }

    public void azS() {
        if (this.dHk.size() > 0) {
            this.dHn = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dHk) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.dHe);
                builder.process_type = Integer.valueOf(aVar.dHf);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azT() {
        String str;
        h azW = azW();
        return (azW == null || (str = azW.azO) == null || !str.equals("1")) ? false : true;
    }

    private boolean azU() {
        String str;
        h azW = azW();
        return azW == null || (str = azW.azM.get(azP())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azV() {
        String str;
        h azW = azW();
        return azW == null || (str = azW.azL.get(azP())) == null || !str.equals("-1");
    }

    private h azW() {
        return h.Cb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long azX() {
        String str;
        h azW = azW();
        if (azW != null && (str = azW.azL.get(azP())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dHg.get(azP()).longValue() * 1000;
    }

    private int azY() {
        String str;
        int g;
        h azW = azW();
        return (azW == null || (str = azW.azM.get(azP())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dHh.get(azP()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long azZ() {
        String str;
        int g;
        h azW = azW();
        return (azW == null || (str = azW.azN.get(azP())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dHi.get(azP()).longValue() * 1000 : g * 1000;
    }
}
