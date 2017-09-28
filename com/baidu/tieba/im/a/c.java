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
    private static final HashMap<String, Long> dzG = new HashMap<>();
    private static final HashMap<String, Integer> dzH = new HashMap<>();
    private static final HashMap<String, Long> dzI = new HashMap<>();
    private static c dzO;
    private List<b> dzJ;
    private List<a> dzK;
    private String dzL = null;
    private String dzM = null;
    private long wM = -1;
    private boolean dzN = false;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.im.a.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                c.this.mHandler.removeMessages(2);
                if (c.this.axF()) {
                    c.this.wM = System.currentTimeMillis();
                    if (MessageManager.getInstance().getSocketClient().isValid()) {
                        c.this.axC();
                    }
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.axH());
            }
            if (message.what == 1) {
                c.this.mHandler.removeMessages(2);
                c.this.wM = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.axC();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.axH());
            }
            if (message.what == 3) {
                c.this.mHandler.removeMessages(3);
                c.this.axB();
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.axJ());
            }
            if (message.what == 4) {
                c.this.mHandler.removeMessages(3);
                c.this.mHandler.removeMessages(2);
                c.this.wM = System.currentTimeMillis();
                c.this.axB();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.axC();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.axJ());
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.axH());
            }
        }
    };
    private com.baidu.adp.framework.listener.c dzP = new com.baidu.adp.framework.listener.c(202006) { // from class: com.baidu.tieba.im.a.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (c.this.axD() && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
                PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
                if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                    b bVar = new b();
                    bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                    bVar.netType = c.this.axy();
                    bVar.dzF = c.this.axA();
                    if (c.this.dzL == null) {
                        c.this.dzL = bVar.emitTime;
                    }
                    if (c.this.dzM == null) {
                        c.this.dzM = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.c(c.this.dzM, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                        c.this.dzM = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.c(c.this.dzL, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                        c.this.dzL = bVar.emitTime;
                    }
                    c.this.dzJ.add(bVar);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dzQ = new com.baidu.adp.framework.listener.c(202005) { // from class: com.baidu.tieba.im.a.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseUploadClientLogMessage)) {
                c.this.dzN = false;
                if (socketResponsedMessage.getError() == 0) {
                    c.this.dzK.clear();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dzR = new com.baidu.adp.framework.listener.c(202003) { // from class: com.baidu.tieba.im.a.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePullMessage) && socketResponsedMessage.getError() == 0) {
                c.this.axu();
            }
        }
    };
    private final CustomMessageListener mAppEnterBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.a.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                c.this.axx();
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.im.a.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                c.this.mw(c.this.axy());
            }
        }
    };

    static {
        dzG.put("2g", 60L);
        dzG.put("3g", 40L);
        dzG.put("4g", 40L);
        dzG.put("wifi", 10L);
        dzH.put("2g", 10);
        dzH.put("3g", 10);
        dzH.put("4g", 10);
        dzH.put("wifi", 10);
        dzI.put("2g", 300L);
        dzI.put("3g", 60L);
        dzI.put("4g", 60L);
        dzI.put("wifi", 5L);
        dzO = null;
    }

    public String axs() {
        return this.dzM;
    }

    public String axt() {
        return this.dzL;
    }

    public void axu() {
        this.dzL = null;
        this.dzM = null;
    }

    public static synchronized c axv() {
        c cVar;
        synchronized (c.class) {
            if (dzO == null) {
                dzO = new c();
            }
            cVar = dzO;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), axJ());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), axH());
    }

    public c() {
        this.dzJ = null;
        this.dzK = null;
        axw();
        this.dzK = new ArrayList();
        this.dzJ = new ArrayList();
    }

    private void axw() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.dzP);
        MessageManager.getInstance().registerListener(this.dzQ);
        MessageManager.getInstance().registerListener(this.dzR);
        MessageManager.getInstance().registerListener(this.mAppEnterBackgroundListener);
    }

    public void axx() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void mw(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (axF() && System.currentTimeMillis() - this.wM > axH()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String axy() {
        return String.valueOf(j.hn());
    }

    public String axz() {
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

    public int axA() {
        return TbadkCoreApplication.getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axB() {
        if (!this.dzN) {
            if (this.dzJ != null && this.dzJ.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dzJ.size()) {
                        break;
                    }
                    b bVar = this.dzJ.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.dzF = bVar.dzF;
                        aVar.dzE = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dzJ.size(); i3++) {
                            b bVar2 = this.dzJ.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.dzF == aVar.dzF) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dzE++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dzK.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dzJ.clear();
            if (this.dzK.size() > axI() && axE() && j.hh()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dzK.size() > 100 && !axF() && !axE()) {
                this.dzK.clear();
            }
        }
    }

    public void axC() {
        if (this.dzK.size() > 0) {
            this.dzN = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dzK) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.dzE);
                builder.process_type = Integer.valueOf(aVar.dzF);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axD() {
        String str;
        f axG = axG();
        return (axG == null || (str = axG.azp) == null || !str.equals("1")) ? false : true;
    }

    private boolean axE() {
        String str;
        f axG = axG();
        return axG == null || (str = axG.azn.get(axz())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axF() {
        String str;
        f axG = axG();
        return axG == null || (str = axG.azm.get(axz())) == null || !str.equals("-1");
    }

    private f axG() {
        return f.BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long axH() {
        String str;
        f axG = axG();
        if (axG != null && (str = axG.azm.get(axz())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dzG.get(axz()).longValue() * 1000;
    }

    private int axI() {
        String str;
        int g;
        f axG = axG();
        return (axG == null || (str = axG.azn.get(axz())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dzH.get(axz()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long axJ() {
        String str;
        int g;
        f axG = axG();
        return (axG == null || (str = axG.azo.get(axz())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dzI.get(axz()).longValue() * 1000 : g * 1000;
    }
}
