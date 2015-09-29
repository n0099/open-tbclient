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
    private ArrayList<String> awH;
    private ArrayList<String> awI;
    private ArrayList<String> awJ;
    private j awN;
    private com.baidu.tbadk.performanceLog.a awO;
    private int awP;
    private int awK = 0;
    private int awL = 3;
    private int awM = 0;
    private int awQ = 0;
    private j.a awR = new f(this);
    private a.InterfaceC0053a aww = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        DF();
    }

    public void onDestroy() {
        if (this.awN != null) {
            this.awN.a((j.a) null);
        }
        if (this.awO != null) {
            this.awO.a((a.InterfaceC0053a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void DE() {
        if (this.awK < this.awL) {
            this.awK++;
            DG();
            if (this.awN == null) {
                this.awN = new j();
                this.awN.a(this.awR);
                this.awN.start();
            }
            if (this.awO == null) {
                this.awO = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m411getInst().getContext());
                this.awO.a(this.aww);
                this.awO.start();
            }
        }
    }

    private void DF() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void DG() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(int i) {
        String valueOf = String.valueOf(i);
        if (this.awH == null) {
            this.awH = new ArrayList<>();
        }
        this.awH.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB(String str) {
        if (this.awI == null) {
            this.awI = new ArrayList<>();
        }
        if (str != null) {
            this.awI.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ey(int i) {
        String valueOf = String.valueOf(i);
        if (this.awJ == null) {
            this.awJ = new ArrayList<>();
        }
        this.awJ.add(valueOf);
    }

    public String DH() {
        return r(this.awH);
    }

    public String DI() {
        return String.valueOf(this.awP);
    }

    public String DJ() {
        return r(this.awI);
    }

    public String getCpuString() {
        return r(this.awJ);
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
                stringBuffer.append(String.valueOf(str) + "_");
            }
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DK() {
        aa aaVar;
        if (this.awM == this.awL && this.awL == this.awQ && (aaVar = (aa) y.Eb().eB(this.mSubType)) != null) {
            aaVar.g(this);
        }
    }

    static {
        customNormalTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    /* loaded from: classes.dex */
    public class a {
        public String awT;
        public int awU;

        public a() {
        }
    }
}
