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
    public static int axm = 0;
    public static int axn = 1;
    public static int axo = 2;
    private static CustomMessageTask customNormalTask = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new p());
    private ArrayList<String> awJ;
    private ArrayList<String> awK;
    private ArrayList<String> axk;
    private boolean axl;
    private CustomMessageListener customNormalListener = new q(this, CmdConfigCustom.CMD_PERF_LIVE_SAMPLE);

    static {
        customNormalTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    public o() {
        DC();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public boolean DM() {
        return this.axl;
    }

    public void bp(boolean z) {
        this.axl = z;
    }

    public void DB() {
        DD();
    }

    public void K(int i, int i2) {
        if (i != 0) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(axm, 6);
            sparseArray.put(axn, Integer.valueOf((int) a0.f37long));
            sparseArray.put(axo, Integer.valueOf(i));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray));
        }
        if (i2 != 0) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(axm, 6);
            sparseArray2.put(axn, Integer.valueOf((int) a0.t));
            sparseArray2.put(axo, Integer.valueOf(i2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray2));
        }
    }

    public void DN() {
        DP();
        if (this.awK != null) {
            this.awK.clear();
        }
        if (this.awJ != null) {
            this.awJ.clear();
        }
        if (this.axk != null) {
            this.axk.clear();
        }
    }

    private void DC() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void DD() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
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
    public void fC(String str) {
        if (this.axk == null) {
            this.axk = new ArrayList<>();
        }
        if (str != null) {
            this.axk.add(str);
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

    public String DO() {
        return r(this.axk);
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

    private void DP() {
        w wVar;
        if (this.awJ != null && this.awJ.size() > 0 && this.awK != null && this.awK.size() > 0 && this.axk != null && this.axk.size() > 0 && (wVar = (w) y.DY().eB(this.mSubType)) != null) {
            wVar.b(this);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public String awU;
        public int awV;
        public String axq;

        public a() {
        }
    }
}
