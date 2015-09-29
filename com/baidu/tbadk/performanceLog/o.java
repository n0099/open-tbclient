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
    public static int axl = 0;
    public static int axm = 1;
    public static int axn = 2;
    private static CustomMessageTask customNormalTask = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new p());
    private ArrayList<String> awI;
    private ArrayList<String> awJ;
    private ArrayList<String> axj;
    private boolean axk;
    private CustomMessageListener customNormalListener = new q(this, CmdConfigCustom.CMD_PERF_LIVE_SAMPLE);

    static {
        customNormalTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    public o() {
        DF();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public boolean DP() {
        return this.axk;
    }

    public void bp(boolean z) {
        this.axk = z;
    }

    public void DE() {
        DG();
    }

    public void K(int i, int i2) {
        if (i != 0) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(axl, 6);
            sparseArray.put(axm, Integer.valueOf((int) a0.f37long));
            sparseArray.put(axn, Integer.valueOf(i));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray));
        }
        if (i2 != 0) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(axl, 6);
            sparseArray2.put(axm, Integer.valueOf((int) a0.t));
            sparseArray2.put(axn, Integer.valueOf(i2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray2));
        }
    }

    public void DQ() {
        DS();
        if (this.awJ != null) {
            this.awJ.clear();
        }
        if (this.awI != null) {
            this.awI.clear();
        }
        if (this.axj != null) {
            this.axj.clear();
        }
    }

    private void DF() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void DG() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
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
    public void fC(String str) {
        if (this.axj == null) {
            this.axj = new ArrayList<>();
        }
        if (str != null) {
            this.axj.add(str);
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

    public String DR() {
        return r(this.axj);
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

    private void DS() {
        w wVar;
        if (this.awI != null && this.awI.size() > 0 && this.awJ != null && this.awJ.size() > 0 && this.axj != null && this.axj.size() > 0 && (wVar = (w) y.Eb().eB(this.mSubType)) != null) {
            wVar.b(this);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public String awT;
        public int awU;
        public String axp;

        public a() {
        }
    }
}
