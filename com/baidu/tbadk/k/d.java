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
    private static CustomMessageTask byb = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.byd = r.NQ().NS();
            data.bye = r.NQ().NU();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private ArrayList<String> bxQ;
    private ArrayList<String> bxR;
    private ArrayList<String> bxS;
    private e bxW;
    private com.baidu.tbadk.k.a bxX;
    private int bxY;
    private int bxT = 0;
    private int bxU = 3;
    private int bxV = 0;
    private int bxZ = 0;
    private e.a bya = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void ij(int i) {
            d.this.bxW.a((e.a) null);
            d.this.bxW.stop();
            d.this.bxY = i;
            t tVar = (t) r.NQ().io(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0088a bxF = new a.InterfaceC0088a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0088a
        public void ij(int i) {
            d.this.bxZ++;
            if (d.this.bxU == d.this.bxZ) {
                d.this.bxX.a((a.InterfaceC0088a) null);
                d.this.bxX.stop();
                d.this.NE();
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
                d.this.bxV++;
                d.this.gS(aVar.byd);
                d.this.il(aVar.bye);
                d.this.NE();
            }
        }
    };

    public d() {
        Ny();
    }

    public void onDestroy() {
        if (this.bxW != null) {
            this.bxW.a((e.a) null);
        }
        if (this.bxX != null) {
            this.bxX.a((a.InterfaceC0088a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Nx() {
        if (this.bxT < this.bxU) {
            this.bxT++;
            Nz();
            if (this.bxW == null) {
                this.bxW = new e();
                this.bxW.a(this.bya);
                this.bxW.start();
            }
            if (this.bxX == null) {
                this.bxX = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.bxX.a(this.bxF);
                this.bxX.start();
            }
        }
    }

    private void Ny() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Nz() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ik(int i) {
        String valueOf = String.valueOf(i);
        if (this.bxQ == null) {
            this.bxQ = new ArrayList<>();
        }
        this.bxQ.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gS(String str) {
        if (this.bxR == null) {
            this.bxR = new ArrayList<>();
        }
        if (str != null) {
            this.bxR.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void il(int i) {
        String valueOf = String.valueOf(i);
        if (this.bxS == null) {
            this.bxS = new ArrayList<>();
        }
        this.bxS.add(valueOf);
    }

    public String NA() {
        return s(this.bxQ);
    }

    public String NB() {
        return String.valueOf(this.bxY);
    }

    public String NC() {
        return s(this.bxR);
    }

    public String ND() {
        return s(this.bxS);
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
    public void NE() {
        t tVar;
        if (this.bxV == this.bxU && this.bxU == this.bxZ && (tVar = (t) r.NQ().io(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        byb.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(byb);
    }

    /* loaded from: classes.dex */
    public class a {
        public String byd;
        public int bye;

        public a() {
        }
    }
}
