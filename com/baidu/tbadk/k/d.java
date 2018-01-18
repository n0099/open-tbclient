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
    private static CustomMessageTask bxS = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.bxU = r.NO().NQ();
            data.bxV = r.NO().NS();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private ArrayList<String> bxH;
    private ArrayList<String> bxI;
    private ArrayList<String> bxJ;
    private e bxN;
    private com.baidu.tbadk.k.a bxO;
    private int bxP;
    private int bxK = 0;
    private int bxL = 3;
    private int bxM = 0;
    private int bxQ = 0;
    private e.a bxR = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void ij(int i) {
            d.this.bxN.a((e.a) null);
            d.this.bxN.stop();
            d.this.bxP = i;
            t tVar = (t) r.NO().io(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0087a bxw = new a.InterfaceC0087a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0087a
        public void ij(int i) {
            d.this.bxQ++;
            if (d.this.bxL == d.this.bxQ) {
                d.this.bxO.a((a.InterfaceC0087a) null);
                d.this.bxO.stop();
                d.this.NC();
            }
            d.this.ik(i);
        }
    };
    private CustomMessageListener customNormalListener = new CustomMessageListener(CmdConfigCustom.CMD_PERF_SAMPLE) { // from class: com.baidu.tbadk.k.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar;
            if (customResponsedMessage != null && (aVar = (a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                d.this.bxM++;
                d.this.gL(aVar.bxU);
                d.this.il(aVar.bxV);
                d.this.NC();
            }
        }
    };

    public d() {
        Nw();
    }

    public void onDestroy() {
        if (this.bxN != null) {
            this.bxN.a((e.a) null);
        }
        if (this.bxO != null) {
            this.bxO.a((a.InterfaceC0087a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Nv() {
        if (this.bxK < this.bxL) {
            this.bxK++;
            Nx();
            if (this.bxN == null) {
                this.bxN = new e();
                this.bxN.a(this.bxR);
                this.bxN.start();
            }
            if (this.bxO == null) {
                this.bxO = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.bxO.a(this.bxw);
                this.bxO.start();
            }
        }
    }

    private void Nw() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Nx() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ik(int i) {
        String valueOf = String.valueOf(i);
        if (this.bxH == null) {
            this.bxH = new ArrayList<>();
        }
        this.bxH.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gL(String str) {
        if (this.bxI == null) {
            this.bxI = new ArrayList<>();
        }
        if (str != null) {
            this.bxI.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void il(int i) {
        String valueOf = String.valueOf(i);
        if (this.bxJ == null) {
            this.bxJ = new ArrayList<>();
        }
        this.bxJ.add(valueOf);
    }

    public String Ny() {
        return s(this.bxH);
    }

    public String Nz() {
        return String.valueOf(this.bxP);
    }

    public String NA() {
        return s(this.bxI);
    }

    public String NB() {
        return s(this.bxJ);
    }

    private String s(ArrayList<String> arrayList) {
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
    public void NC() {
        t tVar;
        if (this.bxM == this.bxL && this.bxL == this.bxQ && (tVar = (t) r.NO().io(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        bxS.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(bxS);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bxU;
        public int bxV;

        public a() {
        }
    }
}
