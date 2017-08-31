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
    private static c dCE;
    private static final HashMap<String, Long> dCw = new HashMap<>();
    private static final HashMap<String, Integer> dCx = new HashMap<>();
    private static final HashMap<String, Long> dCy = new HashMap<>();
    private List<a> dCA;
    private List<b> dCz;
    private String dCB = null;
    private String dCC = null;
    private long wK = -1;
    private boolean dCD = false;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.im.a.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                c.this.mHandler.removeMessages(2);
                if (c.this.ayI()) {
                    c.this.wK = System.currentTimeMillis();
                    if (MessageManager.getInstance().getSocketClient().isValid()) {
                        c.this.ayF();
                    }
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.ayK());
            }
            if (message.what == 1) {
                c.this.mHandler.removeMessages(2);
                c.this.wK = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.ayF();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.ayK());
            }
            if (message.what == 3) {
                c.this.mHandler.removeMessages(3);
                c.this.ayE();
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.ayM());
            }
            if (message.what == 4) {
                c.this.mHandler.removeMessages(3);
                c.this.mHandler.removeMessages(2);
                c.this.wK = System.currentTimeMillis();
                c.this.ayE();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.ayF();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.ayM());
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.ayK());
            }
        }
    };
    private com.baidu.adp.framework.listener.c dCF = new com.baidu.adp.framework.listener.c(202006) { // from class: com.baidu.tieba.im.a.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (c.this.ayG() && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
                PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
                if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                    b bVar = new b();
                    bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                    bVar.netType = c.this.ayB();
                    bVar.dCv = c.this.ayD();
                    if (c.this.dCB == null) {
                        c.this.dCB = bVar.emitTime;
                    }
                    if (c.this.dCC == null) {
                        c.this.dCC = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.c(c.this.dCC, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                        c.this.dCC = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.c(c.this.dCB, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                        c.this.dCB = bVar.emitTime;
                    }
                    c.this.dCz.add(bVar);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dCG = new com.baidu.adp.framework.listener.c(202005) { // from class: com.baidu.tieba.im.a.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseUploadClientLogMessage)) {
                c.this.dCD = false;
                if (socketResponsedMessage.getError() == 0) {
                    c.this.dCA.clear();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dCH = new com.baidu.adp.framework.listener.c(202003) { // from class: com.baidu.tieba.im.a.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePullMessage) && socketResponsedMessage.getError() == 0) {
                c.this.ayx();
            }
        }
    };
    private final CustomMessageListener mAppEnterBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.a.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                c.this.ayA();
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.im.a.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                c.this.mQ(c.this.ayB());
            }
        }
    };

    static {
        dCw.put("2g", 60L);
        dCw.put("3g", 40L);
        dCw.put("4g", 40L);
        dCw.put("wifi", 10L);
        dCx.put("2g", 10);
        dCx.put("3g", 10);
        dCx.put("4g", 10);
        dCx.put("wifi", 10);
        dCy.put("2g", 300L);
        dCy.put("3g", 60L);
        dCy.put("4g", 60L);
        dCy.put("wifi", 5L);
        dCE = null;
    }

    public String ayv() {
        return this.dCC;
    }

    public String ayw() {
        return this.dCB;
    }

    public void ayx() {
        this.dCB = null;
        this.dCC = null;
    }

    public static synchronized c ayy() {
        c cVar;
        synchronized (c.class) {
            if (dCE == null) {
                dCE = new c();
            }
            cVar = dCE;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), ayM());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), ayK());
    }

    public c() {
        this.dCz = null;
        this.dCA = null;
        ayz();
        this.dCA = new ArrayList();
        this.dCz = new ArrayList();
    }

    private void ayz() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.dCF);
        MessageManager.getInstance().registerListener(this.dCG);
        MessageManager.getInstance().registerListener(this.dCH);
        MessageManager.getInstance().registerListener(this.mAppEnterBackgroundListener);
    }

    public void ayA() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void mQ(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (ayI() && System.currentTimeMillis() - this.wK > ayK()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String ayB() {
        return String.valueOf(i.ho());
    }

    public String ayC() {
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

    public int ayD() {
        return TbadkCoreApplication.getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayE() {
        if (!this.dCD) {
            if (this.dCz != null && this.dCz.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dCz.size()) {
                        break;
                    }
                    b bVar = this.dCz.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.dCv = bVar.dCv;
                        aVar.dCu = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dCz.size(); i3++) {
                            b bVar2 = this.dCz.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.dCv == aVar.dCv) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dCu++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dCA.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dCz.clear();
            if (this.dCA.size() > ayL() && ayH() && i.hi()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dCA.size() > 100 && !ayI() && !ayH()) {
                this.dCA.clear();
            }
        }
    }

    public void ayF() {
        if (this.dCA.size() > 0) {
            this.dCD = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dCA) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.dCu);
                builder.process_type = Integer.valueOf(aVar.dCv);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayG() {
        String str;
        g ayJ = ayJ();
        return (ayJ == null || (str = ayJ.azY) == null || !str.equals("1")) ? false : true;
    }

    private boolean ayH() {
        String str;
        g ayJ = ayJ();
        return ayJ == null || (str = ayJ.azW.get(ayC())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayI() {
        String str;
        g ayJ = ayJ();
        return ayJ == null || (str = ayJ.azV.get(ayC())) == null || !str.equals("-1");
    }

    private g ayJ() {
        return g.Cp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ayK() {
        String str;
        g ayJ = ayJ();
        if (ayJ != null && (str = ayJ.azV.get(ayC())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dCw.get(ayC()).longValue() * 1000;
    }

    private int ayL() {
        String str;
        int g;
        g ayJ = ayJ();
        return (ayJ == null || (str = ayJ.azW.get(ayC())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dCx.get(ayC()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ayM() {
        String str;
        int g;
        g ayJ = ayJ();
        return (ayJ == null || (str = ayJ.azX.get(ayC())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dCy.get(ayC()).longValue() * 1000 : g * 1000;
    }
}
