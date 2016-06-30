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
    private static CustomMessageTask axP = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> axE;
    private ArrayList<String> axF;
    private ArrayList<String> axG;
    private j axK;
    private com.baidu.tbadk.performanceLog.a axL;
    private int axM;
    private int axH = 0;
    private int axI = 3;
    private int axJ = 0;
    private int axN = 0;
    private j.a axO = new f(this);
    private a.InterfaceC0047a axt = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        EE();
    }

    public void onDestroy() {
        if (this.axK != null) {
            this.axK.a((j.a) null);
        }
        if (this.axL != null) {
            this.axL.a((a.InterfaceC0047a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void ED() {
        if (this.axH < this.axI) {
            this.axH++;
            EF();
            if (this.axK == null) {
                this.axK = new j();
                this.axK.a(this.axO);
                this.axK.start();
            }
            if (this.axL == null) {
                this.axL = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m9getInst().getContext());
                this.axL.a(this.axt);
                this.axL.start();
            }
        }
    }

    private void EE() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void EF() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(int i) {
        String valueOf = String.valueOf(i);
        if (this.axE == null) {
            this.axE = new ArrayList<>();
        }
        this.axE.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gf(String str) {
        if (this.axF == null) {
            this.axF = new ArrayList<>();
        }
        if (str != null) {
            this.axF.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(int i) {
        String valueOf = String.valueOf(i);
        if (this.axG == null) {
            this.axG = new ArrayList<>();
        }
        this.axG.add(valueOf);
    }

    public String EG() {
        return q(this.axE);
    }

    public String EH() {
        return String.valueOf(this.axM);
    }

    public String EI() {
        return q(this.axF);
    }

    public String EJ() {
        return q(this.axG);
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
    public void EK() {
        ac acVar;
        if (this.axJ == this.axI && this.axI == this.axN && (acVar = (ac) aa.EW().eS(this.ayk)) != null) {
            acVar.g(this);
        }
    }

    static {
        axP.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(axP);
    }

    /* loaded from: classes.dex */
    public class a {
        public String axR;
        public int axS;

        public a() {
        }
    }
}
