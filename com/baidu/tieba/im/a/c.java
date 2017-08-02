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
    private static final HashMap<String, Long> dsD = new HashMap<>();
    private static final HashMap<String, Integer> dsE = new HashMap<>();
    private static final HashMap<String, Long> dsF = new HashMap<>();
    private static c dsL;
    private List<b> dsG;
    private List<a> dsH;
    private String dsI = null;
    private String dsJ = null;
    private long xo = -1;
    private boolean dsK = false;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.im.a.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                c.this.mHandler.removeMessages(2);
                if (c.this.awg()) {
                    c.this.xo = System.currentTimeMillis();
                    if (MessageManager.getInstance().getSocketClient().isValid()) {
                        c.this.awd();
                    }
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.awi());
            }
            if (message.what == 1) {
                c.this.mHandler.removeMessages(2);
                c.this.xo = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.awd();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.awi());
            }
            if (message.what == 3) {
                c.this.mHandler.removeMessages(3);
                c.this.awc();
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.awk());
            }
            if (message.what == 4) {
                c.this.mHandler.removeMessages(3);
                c.this.mHandler.removeMessages(2);
                c.this.xo = System.currentTimeMillis();
                c.this.awc();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.awd();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.awk());
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.awi());
            }
        }
    };
    private com.baidu.adp.framework.listener.c dsM = new com.baidu.adp.framework.listener.c(202006) { // from class: com.baidu.tieba.im.a.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (c.this.awe() && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
                PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
                if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                    b bVar = new b();
                    bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                    bVar.netType = c.this.avZ();
                    bVar.dsC = c.this.awb();
                    if (c.this.dsI == null) {
                        c.this.dsI = bVar.emitTime;
                    }
                    if (c.this.dsJ == null) {
                        c.this.dsJ = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.c(c.this.dsJ, 0L) < com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                        c.this.dsJ = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.c(c.this.dsI, 0L) > com.baidu.adp.lib.g.b.c(bVar.emitTime, 0L)) {
                        c.this.dsI = bVar.emitTime;
                    }
                    c.this.dsG.add(bVar);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dsN = new com.baidu.adp.framework.listener.c(202005) { // from class: com.baidu.tieba.im.a.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseUploadClientLogMessage)) {
                c.this.dsK = false;
                if (socketResponsedMessage.getError() == 0) {
                    c.this.dsH.clear();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dsO = new com.baidu.adp.framework.listener.c(202003) { // from class: com.baidu.tieba.im.a.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePullMessage) && socketResponsedMessage.getError() == 0) {
                c.this.avV();
            }
        }
    };
    private final CustomMessageListener dsP = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.a.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                c.this.avY();
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.im.a.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                c.this.ml(c.this.avZ());
            }
        }
    };

    static {
        dsD.put("2g", 60L);
        dsD.put("3g", 40L);
        dsD.put("4g", 40L);
        dsD.put("wifi", 10L);
        dsE.put("2g", 10);
        dsE.put("3g", 10);
        dsE.put("4g", 10);
        dsE.put("wifi", 10);
        dsF.put("2g", 300L);
        dsF.put("3g", 60L);
        dsF.put("4g", 60L);
        dsF.put("wifi", 5L);
        dsL = null;
    }

    public String avT() {
        return this.dsJ;
    }

    public String avU() {
        return this.dsI;
    }

    public void avV() {
        this.dsI = null;
        this.dsJ = null;
    }

    public static synchronized c avW() {
        c cVar;
        synchronized (c.class) {
            if (dsL == null) {
                dsL = new c();
            }
            cVar = dsL;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), awk());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), awi());
    }

    public c() {
        this.dsG = null;
        this.dsH = null;
        avX();
        this.dsH = new ArrayList();
        this.dsG = new ArrayList();
    }

    private void avX() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.dsM);
        MessageManager.getInstance().registerListener(this.dsN);
        MessageManager.getInstance().registerListener(this.dsO);
        MessageManager.getInstance().registerListener(this.dsP);
    }

    public void avY() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void ml(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (awg() && System.currentTimeMillis() - this.xo > awi()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String avZ() {
        return String.valueOf(i.hn());
    }

    public String awa() {
        switch (i.hn()) {
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

    public int awb() {
        return TbadkCoreApplication.getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awc() {
        if (!this.dsK) {
            if (this.dsG != null && this.dsG.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dsG.size()) {
                        break;
                    }
                    b bVar = this.dsG.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.dsC = bVar.dsC;
                        aVar.dsB = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dsG.size(); i3++) {
                            b bVar2 = this.dsG.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.dsC == aVar.dsC) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.c(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.c(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dsB++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dsH.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dsG.clear();
            if (this.dsH.size() > awj() && awf() && i.hh()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dsH.size() > 100 && !awg() && !awf()) {
                this.dsH.clear();
            }
        }
    }

    public void awd() {
        if (this.dsH.size() > 0) {
            this.dsK = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dsH) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.dsB);
                builder.process_type = Integer.valueOf(aVar.dsC);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awe() {
        String str;
        g awh = awh();
        return (awh == null || (str = awh.azu) == null || !str.equals("1")) ? false : true;
    }

    private boolean awf() {
        String str;
        g awh = awh();
        return awh == null || (str = awh.azs.get(awa())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awg() {
        String str;
        g awh = awh();
        return awh == null || (str = awh.azr.get(awa())) == null || !str.equals("-1");
    }

    private g awh() {
        return g.Cm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long awi() {
        String str;
        g awh = awh();
        if (awh != null && (str = awh.azr.get(awa())) != null && str.length() > 0) {
            long c = com.baidu.adp.lib.g.b.c(str, 0L);
            if (c > 2) {
                return c * 1000;
            }
        }
        return dsD.get(awa()).longValue() * 1000;
    }

    private int awj() {
        String str;
        int g;
        g awh = awh();
        return (awh == null || (str = awh.azs.get(awa())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dsE.get(awa()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long awk() {
        String str;
        int g;
        g awh = awh();
        return (awh == null || (str = awh.azt.get(awa())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dsF.get(awa()).longValue() * 1000 : g * 1000;
    }
}
