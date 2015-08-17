package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.performanceLog.a;
import com.baidu.tbadk.performanceLog.j;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends r {
    private static CustomMessageTask customNormalTask = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> awA;
    private ArrayList<String> awB;
    private ArrayList<String> awC;
    private j awG;
    private com.baidu.tbadk.performanceLog.a awH;
    private int awI;
    private int awD = 0;
    private int awE = 3;
    private int awF = 0;
    private int awJ = 0;
    private j.a awK = new f(this);
    private a.InterfaceC0053a awp = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        DI();
    }

    public void onDestroy() {
        if (this.awG != null) {
            this.awG.a((j.a) null);
        }
        if (this.awH != null) {
            this.awH.a((a.InterfaceC0053a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void DH() {
        if (this.awD < this.awE) {
            this.awD++;
            DJ();
            if (this.awG == null) {
                this.awG = new j();
                this.awG.a(this.awK);
                this.awG.start();
            }
            if (this.awH == null) {
                this.awH = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m411getInst().getContext());
                this.awH.a(this.awp);
                this.awH.start();
            }
        }
    }

    private void DI() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void DJ() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo(int i) {
        String valueOf = String.valueOf(i);
        if (this.awA == null) {
            this.awA = new ArrayList<>();
        }
        this.awA.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo(String str) {
        if (this.awB == null) {
            this.awB = new ArrayList<>();
        }
        if (str != null) {
            this.awB.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep(int i) {
        String valueOf = String.valueOf(i);
        if (this.awC == null) {
            this.awC = new ArrayList<>();
        }
        this.awC.add(valueOf);
    }

    public String DK() {
        return s(this.awA);
    }

    public String DL() {
        return String.valueOf(this.awI);
    }

    public String DM() {
        return s(this.awB);
    }

    public String getCpuString() {
        return s(this.awC);
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
                stringBuffer.append(String.valueOf(str) + "_");
            }
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DN() {
        aa aaVar;
        if (this.awF == this.awE && this.awE == this.awJ && (aaVar = (aa) y.Ee().es(this.mSubType)) != null) {
            aaVar.g(this);
        }
    }

    static {
        customNormalTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    /* loaded from: classes.dex */
    public class a {
        public String awM;
        public int awN;

        public a() {
        }
    }
}
