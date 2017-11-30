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
    private static CustomMessageTask aJO = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aJQ = r.GA().GC();
            data.aJR = r.GA().GE();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private ArrayList<String> aJD;
    private ArrayList<String> aJE;
    private ArrayList<String> aJF;
    private e aJJ;
    private com.baidu.tbadk.k.a aJK;
    private int aJL;
    private int aJG = 0;
    private int aJH = 3;
    private int aJI = 0;
    private int aJM = 0;
    private e.a aJN = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void fo(int i) {
            d.this.aJJ.a((e.a) null);
            d.this.aJJ.stop();
            d.this.aJL = i;
            t tVar = (t) r.GA().ft(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0061a aJs = new a.InterfaceC0061a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0061a
        public void fo(int i) {
            d.this.aJM++;
            if (d.this.aJH == d.this.aJM) {
                d.this.aJK.a((a.InterfaceC0061a) null);
                d.this.aJK.stop();
                d.this.Go();
            }
            d.this.fp(i);
        }
    };
    private CustomMessageListener customNormalListener = new CustomMessageListener(CmdConfigCustom.CMD_PERF_SAMPLE) { // from class: com.baidu.tbadk.k.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar;
            if (customResponsedMessage != null && (aVar = (a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                d.this.aJI++;
                d.this.gI(aVar.aJQ);
                d.this.fq(aVar.aJR);
                d.this.Go();
            }
        }
    };

    public d() {
        Gi();
    }

    public void onDestroy() {
        if (this.aJJ != null) {
            this.aJJ.a((e.a) null);
        }
        if (this.aJK != null) {
            this.aJK.a((a.InterfaceC0061a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Gh() {
        if (this.aJG < this.aJH) {
            this.aJG++;
            Gj();
            if (this.aJJ == null) {
                this.aJJ = new e();
                this.aJJ.a(this.aJN);
                this.aJJ.start();
            }
            if (this.aJK == null) {
                this.aJK = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.aJK.a(this.aJs);
                this.aJK.start();
            }
        }
    }

    private void Gi() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Gj() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(int i) {
        String valueOf = String.valueOf(i);
        if (this.aJD == null) {
            this.aJD = new ArrayList<>();
        }
        this.aJD.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(String str) {
        if (this.aJE == null) {
            this.aJE = new ArrayList<>();
        }
        if (str != null) {
            this.aJE.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(int i) {
        String valueOf = String.valueOf(i);
        if (this.aJF == null) {
            this.aJF = new ArrayList<>();
        }
        this.aJF.add(valueOf);
    }

    public String Gk() {
        return r(this.aJD);
    }

    public String Gl() {
        return String.valueOf(this.aJL);
    }

    public String Gm() {
        return r(this.aJE);
    }

    public String Gn() {
        return r(this.aJF);
    }

    private String r(ArrayList<String> arrayList) {
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
    public void Go() {
        t tVar;
        if (this.aJI == this.aJH && this.aJH == this.aJM && (tVar = (t) r.GA().ft(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aJO.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aJO);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aJQ;
        public int aJR;

        public a() {
        }
    }
}
