package com.baidu.tbadk.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.j.a;
import com.baidu.tbadk.j.j;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends t {
    private static CustomMessageTask aHh = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> aGW;
    private ArrayList<String> aGX;
    private ArrayList<String> aGY;
    private j aHc;
    private com.baidu.tbadk.j.a aHd;
    private int aHe;
    private int aGZ = 0;
    private int aHa = 3;
    private int aHb = 0;
    private int aHf = 0;
    private j.a aHg = new f(this);
    private a.InterfaceC0050a aGL = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        FJ();
    }

    public void onDestroy() {
        if (this.aHc != null) {
            this.aHc.a((j.a) null);
        }
        if (this.aHd != null) {
            this.aHd.a((a.InterfaceC0050a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void FI() {
        if (this.aGZ < this.aHa) {
            this.aGZ++;
            FK();
            if (this.aHc == null) {
                this.aHc = new j();
                this.aHc.a(this.aHg);
                this.aHc.start();
            }
            if (this.aHd == null) {
                this.aHd = new com.baidu.tbadk.j.a(TbadkCoreApplication.m9getInst().getContext());
                this.aHd.a(this.aGL);
                this.aHd.start();
            }
        }
    }

    private void FJ() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void FK() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(int i) {
        String valueOf = String.valueOf(i);
        if (this.aGW == null) {
            this.aGW = new ArrayList<>();
        }
        this.aGW.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gr(String str) {
        if (this.aGX == null) {
            this.aGX = new ArrayList<>();
        }
        if (str != null) {
            this.aGX.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(int i) {
        String valueOf = String.valueOf(i);
        if (this.aGY == null) {
            this.aGY = new ArrayList<>();
        }
        this.aGY.add(valueOf);
    }

    public String FL() {
        return r(this.aGW);
    }

    public String FM() {
        return String.valueOf(this.aHe);
    }

    public String FN() {
        return r(this.aGX);
    }

    public String FO() {
        return r(this.aGY);
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
    public void FP() {
        ac acVar;
        if (this.aHb == this.aHa && this.aHa == this.aHf && (acVar = (ac) aa.Gb().ff(this.mSubType)) != null) {
            acVar.g(this);
        }
    }

    static {
        aHh.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aHh);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aHj;
        public int aHk;

        public a() {
        }
    }
}
