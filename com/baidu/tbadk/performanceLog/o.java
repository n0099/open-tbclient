package com.baidu.tbadk.performanceLog;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.location.a0;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o extends r {
    public static int axe = 0;
    public static int axf = 1;
    public static int axg = 2;
    private static CustomMessageTask customNormalTask = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new p());
    private ArrayList<String> awB;
    private ArrayList<String> awC;
    private ArrayList<String> axc;
    private boolean axd;
    private CustomMessageListener customNormalListener = new q(this, CmdConfigCustom.CMD_PERF_LIVE_SAMPLE);

    static {
        customNormalTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    public o() {
        DI();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public boolean DS() {
        return this.axd;
    }

    public void bk(boolean z) {
        this.axd = z;
    }

    public void DH() {
        DJ();
    }

    public void K(int i, int i2) {
        if (i != 0) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(axe, 6);
            sparseArray.put(axf, Integer.valueOf((int) a0.f37long));
            sparseArray.put(axg, Integer.valueOf(i));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray));
        }
        if (i2 != 0) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(axe, 6);
            sparseArray2.put(axf, Integer.valueOf((int) a0.t));
            sparseArray2.put(axg, Integer.valueOf(i2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray2));
        }
    }

    public void DT() {
        DV();
        if (this.awC != null) {
            this.awC.clear();
        }
        if (this.awB != null) {
            this.awB.clear();
        }
        if (this.axc != null) {
            this.axc.clear();
        }
    }

    private void DI() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void DJ() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
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
    public void fp(String str) {
        if (this.axc == null) {
            this.axc = new ArrayList<>();
        }
        if (str != null) {
            this.axc.add(str);
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

    public String DU() {
        return s(this.axc);
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

    private void DV() {
        w wVar;
        if (this.awB != null && this.awB.size() > 0 && this.awC != null && this.awC.size() > 0 && this.axc != null && this.axc.size() > 0 && (wVar = (w) y.Ee().es(this.mSubType)) != null) {
            wVar.b(this);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public String awM;
        public int awN;
        public String axi;

        public a() {
        }
    }
}
