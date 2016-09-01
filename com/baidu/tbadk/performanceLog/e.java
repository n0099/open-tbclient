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
public class e extends t {
    private static CustomMessageTask aBM = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> aBB;
    private ArrayList<String> aBC;
    private ArrayList<String> aBD;
    private j aBH;
    private com.baidu.tbadk.performanceLog.a aBI;
    private int aBJ;
    private int aBE = 0;
    private int aBF = 3;
    private int aBG = 0;
    private int aBK = 0;
    private j.a aBL = new f(this);
    private a.InterfaceC0048a aBq = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        FX();
    }

    public void onDestroy() {
        if (this.aBH != null) {
            this.aBH.a((j.a) null);
        }
        if (this.aBI != null) {
            this.aBI.a((a.InterfaceC0048a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void FW() {
        if (this.aBE < this.aBF) {
            this.aBE++;
            FY();
            if (this.aBH == null) {
                this.aBH = new j();
                this.aBH.a(this.aBL);
                this.aBH.start();
            }
            if (this.aBI == null) {
                this.aBI = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m9getInst().getContext());
                this.aBI.a(this.aBq);
                this.aBI.start();
            }
        }
    }

    private void FX() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void FY() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(int i) {
        String valueOf = String.valueOf(i);
        if (this.aBB == null) {
            this.aBB = new ArrayList<>();
        }
        this.aBB.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(String str) {
        if (this.aBC == null) {
            this.aBC = new ArrayList<>();
        }
        if (str != null) {
            this.aBC.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(int i) {
        String valueOf = String.valueOf(i);
        if (this.aBD == null) {
            this.aBD = new ArrayList<>();
        }
        this.aBD.add(valueOf);
    }

    public String FZ() {
        return r(this.aBB);
    }

    public String Ga() {
        return String.valueOf(this.aBJ);
    }

    public String Gb() {
        return r(this.aBC);
    }

    public String Gc() {
        return r(this.aBD);
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
    public void Gd() {
        ac acVar;
        if (this.aBG == this.aBF && this.aBF == this.aBK && (acVar = (ac) aa.Gp().fg(this.aCh)) != null) {
            acVar.g(this);
        }
    }

    static {
        aBM.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aBM);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aBO;
        public int aBP;

        public a() {
        }
    }
}
