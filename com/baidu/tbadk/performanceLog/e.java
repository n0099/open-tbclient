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
    private static CustomMessageTask aAW = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> aAL;
    private ArrayList<String> aAM;
    private ArrayList<String> aAN;
    private j aAR;
    private com.baidu.tbadk.performanceLog.a aAS;
    private int aAT;
    private int aAO = 0;
    private int aAP = 3;
    private int aAQ = 0;
    private int aAU = 0;
    private j.a aAV = new f(this);
    private a.InterfaceC0056a aAA = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        GC();
    }

    public void onDestroy() {
        if (this.aAR != null) {
            this.aAR.a((j.a) null);
        }
        if (this.aAS != null) {
            this.aAS.a((a.InterfaceC0056a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void GB() {
        if (this.aAO < this.aAP) {
            this.aAO++;
            GD();
            if (this.aAR == null) {
                this.aAR = new j();
                this.aAR.a(this.aAV);
                this.aAR.start();
            }
            if (this.aAS == null) {
                this.aAS = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m411getInst().getContext());
                this.aAS.a(this.aAA);
                this.aAS.start();
            }
        }
    }

    private void GC() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void GD() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ff(int i) {
        String valueOf = String.valueOf(i);
        if (this.aAL == null) {
            this.aAL = new ArrayList<>();
        }
        this.aAL.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(String str) {
        if (this.aAM == null) {
            this.aAM = new ArrayList<>();
        }
        if (str != null) {
            this.aAM.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(int i) {
        String valueOf = String.valueOf(i);
        if (this.aAN == null) {
            this.aAN = new ArrayList<>();
        }
        this.aAN.add(valueOf);
    }

    public String GE() {
        return q(this.aAL);
    }

    public String GF() {
        return String.valueOf(this.aAT);
    }

    public String GG() {
        return q(this.aAM);
    }

    public String GH() {
        return q(this.aAN);
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
                stringBuffer.append(String.valueOf(str) + "_");
            }
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GI() {
        ac acVar;
        if (this.aAQ == this.aAP && this.aAP == this.aAU && (acVar = (ac) aa.GU().fj(this.aBr)) != null) {
            acVar.g(this);
        }
    }

    static {
        aAW.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aAW);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aAY;
        public int aAZ;

        public a() {
        }
    }
}
