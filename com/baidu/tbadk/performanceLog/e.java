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
    private ArrayList<String> awI;
    private ArrayList<String> awJ;
    private ArrayList<String> awK;
    private j awO;
    private com.baidu.tbadk.performanceLog.a awP;
    private int awQ;
    private int awL = 0;
    private int awM = 3;
    private int awN = 0;
    private int awR = 0;
    private j.a awS = new f(this);
    private a.InterfaceC0053a awx = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        DC();
    }

    public void onDestroy() {
        if (this.awO != null) {
            this.awO.a((j.a) null);
        }
        if (this.awP != null) {
            this.awP.a((a.InterfaceC0053a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void DB() {
        if (this.awL < this.awM) {
            this.awL++;
            DD();
            if (this.awO == null) {
                this.awO = new j();
                this.awO.a(this.awS);
                this.awO.start();
            }
            if (this.awP == null) {
                this.awP = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m411getInst().getContext());
                this.awP.a(this.awx);
                this.awP.start();
            }
        }
    }

    private void DC() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void DD() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(int i) {
        String valueOf = String.valueOf(i);
        if (this.awI == null) {
            this.awI = new ArrayList<>();
        }
        this.awI.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB(String str) {
        if (this.awJ == null) {
            this.awJ = new ArrayList<>();
        }
        if (str != null) {
            this.awJ.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ey(int i) {
        String valueOf = String.valueOf(i);
        if (this.awK == null) {
            this.awK = new ArrayList<>();
        }
        this.awK.add(valueOf);
    }

    public String DE() {
        return r(this.awI);
    }

    public String DF() {
        return String.valueOf(this.awQ);
    }

    public String DG() {
        return r(this.awJ);
    }

    public String getCpuString() {
        return r(this.awK);
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
    public void DH() {
        aa aaVar;
        if (this.awN == this.awM && this.awM == this.awR && (aaVar = (aa) y.DY().eB(this.mSubType)) != null) {
            aaVar.g(this);
        }
    }

    static {
        customNormalTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    /* loaded from: classes.dex */
    public class a {
        public String awU;
        public int awV;

        public a() {
        }
    }
}
