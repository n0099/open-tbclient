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
    private static CustomMessageTask axM = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> axB;
    private ArrayList<String> axC;
    private ArrayList<String> axD;
    private j axH;
    private com.baidu.tbadk.performanceLog.a axI;
    private int axJ;
    private int axE = 0;
    private int axF = 3;
    private int axG = 0;
    private int axK = 0;
    private j.a axL = new f(this);
    private a.InterfaceC0055a axq = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        Ew();
    }

    public void onDestroy() {
        if (this.axH != null) {
            this.axH.a((j.a) null);
        }
        if (this.axI != null) {
            this.axI.a((a.InterfaceC0055a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Ev() {
        if (this.axE < this.axF) {
            this.axE++;
            Ex();
            if (this.axH == null) {
                this.axH = new j();
                this.axH.a(this.axL);
                this.axH.start();
            }
            if (this.axI == null) {
                this.axI = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m411getInst().getContext());
                this.axI.a(this.axq);
                this.axI.start();
            }
        }
    }

    private void Ew() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Ex() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(int i) {
        String valueOf = String.valueOf(i);
        if (this.axB == null) {
            this.axB = new ArrayList<>();
        }
        this.axB.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fR(String str) {
        if (this.axC == null) {
            this.axC = new ArrayList<>();
        }
        if (str != null) {
            this.axC.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eK(int i) {
        String valueOf = String.valueOf(i);
        if (this.axD == null) {
            this.axD = new ArrayList<>();
        }
        this.axD.add(valueOf);
    }

    public String Ey() {
        return s(this.axB);
    }

    public String Ez() {
        return String.valueOf(this.axJ);
    }

    public String EA() {
        return s(this.axC);
    }

    public String getCpuString() {
        return s(this.axD);
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
    public void EB() {
        aa aaVar;
        if (this.axG == this.axF && this.axF == this.axK && (aaVar = (aa) y.ES().eN(this.mSubType)) != null) {
            aaVar.g(this);
        }
    }

    static {
        axM.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(axM);
    }

    /* loaded from: classes.dex */
    public class a {
        public String axO;
        public int axP;

        public a() {
        }
    }
}
