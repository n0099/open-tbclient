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
    private static final HashMap<String, Long> dtV = new HashMap<>();
    private static final HashMap<String, Integer> dtW = new HashMap<>();
    private static final HashMap<String, Long> dtX = new HashMap<>();
    private static c dud;
    private List<b> dtY;
    private List<a> dtZ;
    private String dua = null;
    private String dub = null;
    private long yO = -1;
    private boolean duc = false;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.im.a.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2) {
                c.this.mHandler.removeMessages(2);
                if (c.this.awr()) {
                    c.this.yO = System.currentTimeMillis();
                    if (MessageManager.getInstance().getSocketClient().isValid()) {
                        c.this.awo();
                    }
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.awt());
            }
            if (message.what == 1) {
                c.this.mHandler.removeMessages(2);
                c.this.yO = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.awo();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.awt());
            }
            if (message.what == 3) {
                c.this.mHandler.removeMessages(3);
                c.this.awn();
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.awv());
            }
            if (message.what == 4) {
                c.this.mHandler.removeMessages(3);
                c.this.mHandler.removeMessages(2);
                c.this.yO = System.currentTimeMillis();
                c.this.awn();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    c.this.awo();
                }
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(3), c.this.awv());
                c.this.mHandler.sendMessageDelayed(c.this.mHandler.obtainMessage(2), c.this.awt());
            }
        }
    };
    private com.baidu.adp.framework.listener.c due = new com.baidu.adp.framework.listener.c(202006) { // from class: com.baidu.tieba.im.a.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (c.this.awp() && socketResponsedMessage != null && 202006 == socketResponsedMessage.getCmd() && (socketResponsedMessage instanceof PushNotifyMessage)) {
                PushNotifyMessage pushNotifyMessage = (PushNotifyMessage) socketResponsedMessage;
                if (pushNotifyMessage.getType() != 3 && pushNotifyMessage.getType() != 4) {
                    b bVar = new b();
                    bVar.emitTime = ((PushNotifyMessage) socketResponsedMessage).getEmitTime();
                    bVar.netType = c.this.awk();
                    bVar.dtU = c.this.awm();
                    if (c.this.dua == null) {
                        c.this.dua = bVar.emitTime;
                    }
                    if (c.this.dub == null) {
                        c.this.dub = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.d(c.this.dub, 0L) < com.baidu.adp.lib.g.b.d(bVar.emitTime, 0L)) {
                        c.this.dub = bVar.emitTime;
                    }
                    if (com.baidu.adp.lib.g.b.d(c.this.dua, 0L) > com.baidu.adp.lib.g.b.d(bVar.emitTime, 0L)) {
                        c.this.dua = bVar.emitTime;
                    }
                    c.this.dtY.add(bVar);
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c duf = new com.baidu.adp.framework.listener.c(202005) { // from class: com.baidu.tieba.im.a.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseUploadClientLogMessage)) {
                c.this.duc = false;
                if (socketResponsedMessage.getError() == 0) {
                    c.this.dtZ.clear();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dug = new com.baidu.adp.framework.listener.c(202003) { // from class: com.baidu.tieba.im.a.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePullMessage) && socketResponsedMessage.getError() == 0) {
                c.this.awg();
            }
        }
    };
    private final CustomMessageListener duh = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.a.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                c.this.awj();
            }
        }
    };
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.im.a.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                c.this.mp(c.this.awk());
            }
        }
    };

    static {
        dtV.put("2g", 60L);
        dtV.put("3g", 40L);
        dtV.put("4g", 40L);
        dtV.put("wifi", 10L);
        dtW.put("2g", 10);
        dtW.put("3g", 10);
        dtW.put("4g", 10);
        dtW.put("wifi", 10);
        dtX.put("2g", 300L);
        dtX.put("3g", 60L);
        dtX.put("4g", 60L);
        dtX.put("wifi", 5L);
        dud = null;
    }

    public String awe() {
        return this.dub;
    }

    public String awf() {
        return this.dua;
    }

    public void awg() {
        this.dua = null;
        this.dub = null;
    }

    public static synchronized c awh() {
        c cVar;
        synchronized (c.class) {
            if (dud == null) {
                dud = new c();
            }
            cVar = dud;
        }
        return cVar;
    }

    public void start() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3), awv());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), awt());
    }

    public c() {
        this.dtY = null;
        this.dtZ = null;
        awi();
        this.dtZ = new ArrayList();
        this.dtY = new ArrayList();
    }

    private void awi() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        MessageManager.getInstance().registerListener(this.due);
        MessageManager.getInstance().registerListener(this.duf);
        MessageManager.getInstance().registerListener(this.dug);
        MessageManager.getInstance().registerListener(this.duh);
    }

    public void awj() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
    }

    public void mp(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
        if (awr() && System.currentTimeMillis() - this.yO > awt()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public String awk() {
        return String.valueOf(i.hx());
    }

    public String awl() {
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

    public int awm() {
        return TbadkCoreApplication.getInst().isInBackground() ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awn() {
        if (!this.duc) {
            if (this.dtY != null && this.dtY.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.dtY.size()) {
                        break;
                    }
                    b bVar = this.dtY.get(i2);
                    if (bVar != null && !arrayList.contains(bVar)) {
                        a aVar = new a();
                        aVar.emitTime = bVar.emitTime;
                        aVar.netType = bVar.netType;
                        aVar.dtU = bVar.dtU;
                        aVar.dtT = 1;
                        arrayList.add(bVar);
                        for (int i3 = i2; i3 < this.dtY.size(); i3++) {
                            b bVar2 = this.dtY.get(i3);
                            if (bVar2 != null && !arrayList.contains(bVar2) && bVar2.netType != null && aVar.netType != null && bVar2.netType.equals(aVar.netType) && bVar2.dtU == aVar.dtU) {
                                if (bVar2.emitTime != null && aVar.emitTime != null && com.baidu.adp.lib.g.b.d(bVar2.emitTime, 0L) < com.baidu.adp.lib.g.b.d(aVar.emitTime, 0L)) {
                                    aVar.emitTime = bVar2.emitTime;
                                }
                                aVar.dtT++;
                                arrayList.add(bVar2);
                            }
                        }
                        this.dtZ.add(aVar);
                    }
                    i = i2 + 1;
                }
            }
            this.dtY.clear();
            if (this.dtZ.size() > awu() && awq() && i.hr()) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
            if (this.dtZ.size() > 100 && !awr() && !awq()) {
                this.dtZ.clear();
            }
        }
    }

    public void awo() {
        if (this.dtZ.size() > 0) {
            this.duc = true;
            ArrayList arrayList = new ArrayList();
            ClientLog.Builder builder = new ClientLog.Builder();
            for (a aVar : this.dtZ) {
                builder.et = aVar.emitTime;
                builder.net = aVar.netType;
                builder.pushcnt = Integer.valueOf(aVar.dtT);
                builder.process_type = Integer.valueOf(aVar.dtU);
                arrayList.add(builder.build(false));
            }
            RequestUploadClientLogMessage requestUploadClientLogMessage = new RequestUploadClientLogMessage();
            requestUploadClientLogMessage.set_client_log(arrayList);
            MessageManager.getInstance().sendMessage(requestUploadClientLogMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awp() {
        String str;
        g aws = aws();
        return (aws == null || (str = aws.aAL) == null || !str.equals("1")) ? false : true;
    }

    private boolean awq() {
        String str;
        g aws = aws();
        return aws == null || (str = aws.aAJ.get(awl())) == null || !str.equals("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awr() {
        String str;
        g aws = aws();
        return aws == null || (str = aws.aAI.get(awl())) == null || !str.equals("-1");
    }

    private g aws() {
        return g.Cu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long awt() {
        String str;
        g aws = aws();
        if (aws != null && (str = aws.aAI.get(awl())) != null && str.length() > 0) {
            long d = com.baidu.adp.lib.g.b.d(str, 0L);
            if (d > 2) {
                return d * 1000;
            }
        }
        return dtV.get(awl()).longValue() * 1000;
    }

    private int awu() {
        String str;
        int g;
        g aws = aws();
        return (aws == null || (str = aws.aAJ.get(awl())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dtW.get(awl()).intValue() : g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long awv() {
        String str;
        int g;
        g aws = aws();
        return (aws == null || (str = aws.aAK.get(awl())) == null || str.length() <= 0 || (g = com.baidu.adp.lib.g.b.g(str, 0)) < 2) ? dtX.get(awl()).longValue() * 1000 : g * 1000;
    }
}
