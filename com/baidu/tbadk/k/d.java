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
    private static CustomMessageTask aII = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aIK = r.Gc().Ge();
            data.aIL = r.Gc().Gg();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private e aID;
    private com.baidu.tbadk.k.a aIE;
    private int aIF;
    private ArrayList<String> aIx;
    private ArrayList<String> aIy;
    private ArrayList<String> aIz;
    private int aIA = 0;
    private int aIB = 3;
    private int aIC = 0;
    private int aIG = 0;
    private e.a aIH = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void fq(int i) {
            d.this.aID.a((e.a) null);
            d.this.aID.stop();
            d.this.aIF = i;
            t tVar = (t) r.Gc().fv(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0061a aIm = new a.InterfaceC0061a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0061a
        public void fq(int i) {
            d.this.aIG++;
            if (d.this.aIB == d.this.aIG) {
                d.this.aIE.a((a.InterfaceC0061a) null);
                d.this.aIE.stop();
                d.this.FQ();
            }
            d.this.fr(i);
        }
    };
    private CustomMessageListener customNormalListener = new CustomMessageListener(CmdConfigCustom.CMD_PERF_SAMPLE) { // from class: com.baidu.tbadk.k.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar;
            if (customResponsedMessage != null && (aVar = (a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                d.this.aIC++;
                d.this.gy(aVar.aIK);
                d.this.fs(aVar.aIL);
                d.this.FQ();
            }
        }
    };

    public d() {
        FK();
    }

    public void onDestroy() {
        if (this.aID != null) {
            this.aID.a((e.a) null);
        }
        if (this.aIE != null) {
            this.aIE.a((a.InterfaceC0061a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void FJ() {
        if (this.aIA < this.aIB) {
            this.aIA++;
            FL();
            if (this.aID == null) {
                this.aID = new e();
                this.aID.a(this.aIH);
                this.aID.start();
            }
            if (this.aIE == null) {
                this.aIE = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.aIE.a(this.aIm);
                this.aIE.start();
            }
        }
    }

    private void FK() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void FL() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fr(int i) {
        String valueOf = String.valueOf(i);
        if (this.aIx == null) {
            this.aIx = new ArrayList<>();
        }
        this.aIx.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gy(String str) {
        if (this.aIy == null) {
            this.aIy = new ArrayList<>();
        }
        if (str != null) {
            this.aIy.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(int i) {
        String valueOf = String.valueOf(i);
        if (this.aIz == null) {
            this.aIz = new ArrayList<>();
        }
        this.aIz.add(valueOf);
    }

    public String FM() {
        return q(this.aIx);
    }

    public String FN() {
        return String.valueOf(this.aIF);
    }

    public String FO() {
        return q(this.aIy);
    }

    public String FP() {
        return q(this.aIz);
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
    public void FQ() {
        t tVar;
        if (this.aIC == this.aIB && this.aIB == this.aIG && (tVar = (t) r.Gc().fv(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aII.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aII);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aIK;
        public int aIL;

        public a() {
        }
    }
}
