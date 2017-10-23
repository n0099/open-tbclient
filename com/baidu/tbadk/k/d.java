package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.k.a;
import com.baidu.tbadk.k.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends k {
    private static CustomMessageTask aIv = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aIx = r.FW().FY();
            data.aIy = r.FW().Ga();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private ArrayList<String> aIk;
    private ArrayList<String> aIl;
    private ArrayList<String> aIm;
    private e aIq;
    private com.baidu.tbadk.k.a aIr;
    private int aIs;
    private int aIn = 0;
    private int aIo = 3;
    private int aIp = 0;
    private int aIt = 0;
    private e.a aIu = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void fp(int i) {
            d.this.aIq.a((e.a) null);
            d.this.aIq.stop();
            d.this.aIs = i;
            t tVar = (t) r.FW().fu(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0061a aHZ = new a.InterfaceC0061a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0061a
        public void fp(int i) {
            d.this.aIt++;
            if (d.this.aIo == d.this.aIt) {
                d.this.aIr.a((a.InterfaceC0061a) null);
                d.this.aIr.stop();
                d.this.FK();
            }
            d.this.fq(i);
        }
    };
    private CustomMessageListener customNormalListener = new CustomMessageListener(CmdConfigCustom.CMD_PERF_SAMPLE) { // from class: com.baidu.tbadk.k.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar;
            if (customResponsedMessage != null && (aVar = (a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                d.this.aIp++;
                d.this.gx(aVar.aIx);
                d.this.fr(aVar.aIy);
                d.this.FK();
            }
        }
    };

    public d() {
        FE();
    }

    public void onDestroy() {
        if (this.aIq != null) {
            this.aIq.a((e.a) null);
        }
        if (this.aIr != null) {
            this.aIr.a((a.InterfaceC0061a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void FD() {
        if (this.aIn < this.aIo) {
            this.aIn++;
            FF();
            if (this.aIq == null) {
                this.aIq = new e();
                this.aIq.a(this.aIu);
                this.aIq.start();
            }
            if (this.aIr == null) {
                this.aIr = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.aIr.a(this.aHZ);
                this.aIr.start();
            }
        }
    }

    private void FE() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void FF() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(int i) {
        String valueOf = String.valueOf(i);
        if (this.aIk == null) {
            this.aIk = new ArrayList<>();
        }
        this.aIk.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(String str) {
        if (this.aIl == null) {
            this.aIl = new ArrayList<>();
        }
        if (str != null) {
            this.aIl.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fr(int i) {
        String valueOf = String.valueOf(i);
        if (this.aIm == null) {
            this.aIm = new ArrayList<>();
        }
        this.aIm.add(valueOf);
    }

    public String FG() {
        return q(this.aIk);
    }

    public String FH() {
        return String.valueOf(this.aIs);
    }

    public String FI() {
        return q(this.aIl);
    }

    public String FJ() {
        return q(this.aIm);
    }

    private String q(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return "()";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = arrayList.get(i);
            if (i == size - 1) {
                stringBuffer.append(str);
            } else {
                stringBuffer.append(str + "_");
            }
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FK() {
        t tVar;
        if (this.aIp == this.aIo && this.aIo == this.aIt && (tVar = (t) r.FW().fu(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aIv.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aIv);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aIx;
        public int aIy;

        public a() {
        }
    }
}
