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
    private static CustomMessageTask aAh = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private j aAc;
    private com.baidu.tbadk.performanceLog.a aAd;
    private int aAe;
    private ArrayList<String> azW;
    private ArrayList<String> azX;
    private ArrayList<String> azY;
    private int azZ = 0;
    private int aAa = 3;
    private int aAb = 0;
    private int aAf = 0;
    private j.a aAg = new f(this);
    private a.InterfaceC0056a azL = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        FG();
    }

    public void onDestroy() {
        if (this.aAc != null) {
            this.aAc.a((j.a) null);
        }
        if (this.aAd != null) {
            this.aAd.a((a.InterfaceC0056a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void FF() {
        if (this.azZ < this.aAa) {
            this.azZ++;
            FH();
            if (this.aAc == null) {
                this.aAc = new j();
                this.aAc.a(this.aAg);
                this.aAc.start();
            }
            if (this.aAd == null) {
                this.aAd = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m411getInst().getContext());
                this.aAd.a(this.azL);
                this.aAd.start();
            }
        }
    }

    private void FG() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void FH() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(int i) {
        String valueOf = String.valueOf(i);
        if (this.azW == null) {
            this.azW = new ArrayList<>();
        }
        this.azW.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(String str) {
        if (this.azX == null) {
            this.azX = new ArrayList<>();
        }
        if (str != null) {
            this.azX.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(int i) {
        String valueOf = String.valueOf(i);
        if (this.azY == null) {
            this.azY = new ArrayList<>();
        }
        this.azY.add(valueOf);
    }

    public String FI() {
        return t(this.azW);
    }

    public String FJ() {
        return String.valueOf(this.aAe);
    }

    public String FK() {
        return t(this.azX);
    }

    public String getCpuString() {
        return t(this.azY);
    }

    private String t(ArrayList<String> arrayList) {
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
    public void FL() {
        ac acVar;
        if (this.aAb == this.aAa && this.aAa == this.aAf && (acVar = (ac) aa.FY().fb(this.aAC)) != null) {
            acVar.g(this);
        }
    }

    static {
        aAh.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aAh);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aAj;
        public int aAk;

        public a() {
        }
    }
}
