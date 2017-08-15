package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.data.g;
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
    private static final HashMap<String, Long> dvS = new HashMap<>();
    private static final HashMap<String, Integer> dvT = new HashMap<>();
    private static final HashMap<String, Long> dvU = new HashMap<>();
    private static c dwa;
    private List<b> dvV;
    private List<a> dvW;
    private String dvX = null;
    private String dvY = null;
    private long yQ = -1;
    private boolean dvZ = false;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.im.a.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                c.this.mHandler.removeMessages(2);
                if (c.this.awY()) {
                    c.this.yQ = System.currentTimeMillis();
                    if (MessageManager.getInstance().getSocketClient().isValid()) {
                        c.this.awV();
                    }
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.axa());
            }
            if (message.what == 1) {
                c.this.mHandler.removeMessages(2);
                c.this.yQ = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.awV();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.axa());
            }
            if (message.what == 3) {
                c.this.mHandler.removeMessages(3);
                c.this.awU();
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.axc());
            }
            if (message.what == 4) {
                c.this.mHandler.removeMessages(3);
                c.this.mHandler.removeMessages(2);
                c.this.yQ = System.currentTimeMillis();
                c.this.awU();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.awV();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.axc());
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.axa());
            }
        }
    };
    private com.baidu.adp.framework.listener.c dwb = new com.baidu.adp.framework.listener.c(202006) { // from class: com.baidu.tieba.im.a.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (c.this.awW() && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
                PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
                if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                    b bVar = new b();
                    bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                    bVar.netType = c.this.awR();
                    bVar.dvR = c.this.awT();
                    if (c.this.dvX == null) {
                        c.this.dvX = bVar.emitTime;
                    }
                    if (c.this.dvY == null) {
                        c.this.dvY = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.d(c.this.dvY, 0L) < com.baidu.adp.lib.g.b.d(bVar.emitTime, 0L)) {
                        c.this.dvY = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.d(c.this.dvX, 0L) > com.baidu.adp.lib.g.b.d(bVar.emitTime, 0L)) {
                        c.this.dvX = bVar.emitTime;
                    }
                    c.this.dvV.add(bVar);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dwc = new com.baidu.adp.framework.listener.c(202005) { // from class: com.baidu.tieba.im.a.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseUploadClientLogMessage)) {
                c.this.dvZ = false;
                if (socketResponsedMessage.getError() == 0) {
                    c.this.dvW.clear();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dwd = new com.baidu.adp.framework.listener.c(202003) { // from class: com.baidu.tieba.im.a.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePullMessage) && socketResponsedMessage.getError() == 0) {
                c.this.awN();
            }
        }
    };
    private final CustomMessageListener dwe = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.a.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                c.this.awQ();
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.im.a.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                c.this.mt(c.this.awR());
            }
        }
    };

    static {
        dvS.put("2g", 60L);
        dvS.put("3g", 40L);
        dvS.put("4g", 40L);
        dvS.put("wifi", 10L);
        dvT.put("2g", 10);
        dvT.put("3g", 10);
        dvT.put("4g", 10);
        dvT.put("wifi", 10);
        dvU.put("2g", 300L);
        dvU.put("3g", 60L);
        dvU.put("4g", 60L);
        dvU.put("wifi", 5L);
        dwa = null;
    }

    public String awL() {
        return this.dvY;
    }

    public String awM() {
        return this.dvX;
    }

    public void awN() {
        this.dvX = null;
        this.dvY = null;
    }

    public static synchronized c awO() {
        c cVar;
        synchronized (c.class) {
            if (dwa == null) {
                dwa = new c();
            }
            cVar = dwa;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), axc());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), axa());
    }

    public c() {
        this.dvV = null;
        this.dvW = null;
        awP();
        this.dvW = new ArrayList();
        this.dvV = new ArrayList();
    }

    private void awP() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.dwb);
        MessageManager.getInstance().registerListener(this.dwc);
        MessageManager.getInstance().registerListener(this.dwd);
        MessageManager.getInstance().registerListener(this.dwe);
    }

    public void awQ() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void mt(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (awY() && System.currentTimeMillis() - this.yQ > axa()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String awR() {
        return String.valueOf(i.hx());
    }

    public String awS() {
        switch (i.hx()) {
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

    public int awT() {
        return TbadkCoreApplication.getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awU() {
        if (!this.dvZ) {
            if (this.dvV != null && this.dvV.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dvV.size()) {
                        break;
                    }
                    b bVar = this.dvV.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.dvR = bVar.dvR;
                        aVar.dvQ = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dvV.size(); i3++) {
                            b bVar2 = this.dvV.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.dvR == aVar.dvR) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.d(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.d(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dvQ++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dvW.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dvV.clear();
            if (this.dvW.size() > axb() && awX() && i.hr()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dvW.size() > 100 && !awY() && !awX()) {
                this.dvW.clear();
            }
        }
    }

    public void awV() {
        if (this.dvW.size() > 0) {
            this.dvZ = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dvW) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.dvQ);
                builder.process_type = Integer.valueOf(aVar.dvR);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awW() {
        String str;
        g awZ = awZ();
        return (awZ == null || (str = awZ.aAM) == null || !str.equals("1")) ? false : true;
    }

    private boolean awX() {
        String str;
        g awZ = awZ();
        return awZ == null || (str = awZ.aAK.get(awS())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awY() {
        String str;
        g awZ = awZ();
        return awZ == null || (str = awZ.aAJ.get(awS())) == null || !str.equals("-1");
    }

    private g awZ() {
        return g.Cu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long axa() {
        String str;
        g awZ = awZ();
        if (awZ != null && (str = awZ.aAJ.get(awS())) != null && str.length() > 0) {
            long d = com.baidu.adp.lib.g.b.d(str, 0L);
            if (d > 2) {
                return d * 1000;
            }
        }
        return dvS.get(awS()).longValue() * 1000;
    }

    private int axb() {
        String str;
        int g;
        g awZ = awZ();
        return (awZ == null || (str = awZ.aAK.get(awS())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dvT.get(awS()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long axc() {
        String str;
        int g;
        g awZ = awZ();
        return (awZ == null || (str = awZ.aAL.get(awS())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dvU.get(awS()).longValue() * 1000 : g * 1000;
    }
}
