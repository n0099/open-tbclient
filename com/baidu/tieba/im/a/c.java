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
    private static final HashMap<String, Long> dDr = new HashMap<>();
    private static final HashMap<String, Integer> dDs = new HashMap<>();
    private static final HashMap<String, Long> dDt = new HashMap<>();
    private static c dDz;
    private List<b> dDu;
    private List<a> dDv;
    private String dDw = null;
    private String dDx = null;
    private long wK = -1;
    private boolean dDy = false;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.im.a.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                c.this.mHandler.removeMessages(2);
                if (c.this.ayT()) {
                    c.this.wK = System.currentTimeMillis();
                    if (MessageManager.getInstance().getSocketClient().isValid()) {
                        c.this.ayQ();
                    }
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.ayV());
            }
            if (message.what == 1) {
                c.this.mHandler.removeMessages(2);
                c.this.wK = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.ayQ();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.ayV());
            }
            if (message.what == 3) {
                c.this.mHandler.removeMessages(3);
                c.this.ayP();
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.ayX());
            }
            if (message.what == 4) {
                c.this.mHandler.removeMessages(3);
                c.this.mHandler.removeMessages(2);
                c.this.wK = System.currentTimeMillis();
                c.this.ayP();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.ayQ();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.ayX());
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.ayV());
            }
        }
    };
    private com.baidu.adp.framework.listener.c dDA = new com.baidu.adp.framework.listener.c(202006) { // from class: com.baidu.tieba.im.a.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (c.this.ayR() && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
                PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
                if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                    b bVar = new b();
                    bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                    bVar.netType = c.this.ayM();
                    bVar.dDq = c.this.ayO();
                    if (c.this.dDw == null) {
                        c.this.dDw = bVar.emitTime;
                    }
                    if (c.this.dDx == null) {
                        c.this.dDx = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.c(c.this.dDx, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                        c.this.dDx = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.c(c.this.dDw, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                        c.this.dDw = bVar.emitTime;
                    }
                    c.this.dDu.add(bVar);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dDB = new com.baidu.adp.framework.listener.c(202005) { // from class: com.baidu.tieba.im.a.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseUploadClientLogMessage)) {
                c.this.dDy = false;
                if (socketResponsedMessage.getError() == 0) {
                    c.this.dDv.clear();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dDC = new com.baidu.adp.framework.listener.c(202003) { // from class: com.baidu.tieba.im.a.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePullMessage) && socketResponsedMessage.getError() == 0) {
                c.this.ayI();
            }
        }
    };
    private final CustomMessageListener mAppEnterBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.a.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                c.this.ayL();
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.im.a.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                c.this.mS(c.this.ayM());
            }
        }
    };

    static {
        dDr.put("2g", 60L);
        dDr.put("3g", 40L);
        dDr.put("4g", 40L);
        dDr.put("wifi", 10L);
        dDs.put("2g", 10);
        dDs.put("3g", 10);
        dDs.put("4g", 10);
        dDs.put("wifi", 10);
        dDt.put("2g", 300L);
        dDt.put("3g", 60L);
        dDt.put("4g", 60L);
        dDt.put("wifi", 5L);
        dDz = null;
    }

    public String ayG() {
        return this.dDx;
    }

    public String ayH() {
        return this.dDw;
    }

    public void ayI() {
        this.dDw = null;
        this.dDx = null;
    }

    public static synchronized c ayJ() {
        c cVar;
        synchronized (c.class) {
            if (dDz == null) {
                dDz = new c();
            }
            cVar = dDz;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), ayX());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), ayV());
    }

    public c() {
        this.dDu = null;
        this.dDv = null;
        ayK();
        this.dDv = new ArrayList();
        this.dDu = new ArrayList();
    }

    private void ayK() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.dDA);
        MessageManager.getInstance().registerListener(this.dDB);
        MessageManager.getInstance().registerListener(this.dDC);
        MessageManager.getInstance().registerListener(this.mAppEnterBackgroundListener);
    }

    public void ayL() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void mS(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (ayT() && System.currentTimeMillis() - this.wK > ayV()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String ayM() {
        return String.valueOf(i.ho());
    }

    public String ayN() {
        switch (i.ho()) {
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

    public int ayO() {
        return TbadkCoreApplication.getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayP() {
        if (!this.dDy) {
            if (this.dDu != null && this.dDu.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dDu.size()) {
                        break;
                    }
                    b bVar = this.dDu.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.dDq = bVar.dDq;
                        aVar.dDp = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dDu.size(); i3++) {
                            b bVar2 = this.dDu.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.dDq == aVar.dDq) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dDp++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dDv.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dDu.clear();
            if (this.dDv.size() > ayW() && ayS() && i.hi()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dDv.size() > 100 && !ayT() && !ayS()) {
                this.dDv.clear();
            }
        }
    }

    public void ayQ() {
        if (this.dDv.size() > 0) {
            this.dDy = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dDv) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.dDp);
                builder.process_type = Integer.valueOf(aVar.dDq);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayR() {
        String str;
        g ayU = ayU();
        return (ayU == null || (str = ayU.azV) == null || !str.equals("1")) ? false : true;
    }

    private boolean ayS() {
        String str;
        g ayU = ayU();
        return ayU == null || (str = ayU.azT.get(ayN())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayT() {
        String str;
        g ayU = ayU();
        return ayU == null || (str = ayU.azS.get(ayN())) == null || !str.equals("-1");
    }

    private g ayU() {
        return g.Cp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ayV() {
        String str;
        g ayU = ayU();
        if (ayU != null && (str = ayU.azS.get(ayN())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dDr.get(ayN()).longValue() * 1000;
    }

    private int ayW() {
        String str;
        int g;
        g ayU = ayU();
        return (ayU == null || (str = ayU.azT.get(ayN())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dDs.get(ayN()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ayX() {
        String str;
        int g;
        g ayU = ayU();
        return (ayU == null || (str = ayU.azU.get(ayN())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dDt.get(ayN()).longValue() * 1000 : g * 1000;
    }
}
