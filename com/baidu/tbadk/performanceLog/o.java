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
    private ArrayList<String> avZ;
    private ArrayList<String> avx;
    private ArrayList<String> avy;
    private boolean awa;
    private CustomMessageListener customNormalListener = new q(this, CmdConfigCustom.CMD_PERF_LIVE_SAMPLE);
    public static int awb = 0;
    public static int awc = 1;
    public static int awd = 2;
    private static CustomMessageTask avH = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new p());

    static {
        avH.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(avH);
    }

    public o() {
        Dv();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public boolean DF() {
        return this.awa;
    }

    public void bs(boolean z) {
        this.awa = z;
    }

    public void Du() {
        Dw();
    }

    public void K(int i, int i2) {
        if (i != 0) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(awb, 6);
            sparseArray.put(awc, Integer.valueOf((int) a0.f37long));
            sparseArray.put(awd, Integer.valueOf(i));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray));
        }
        if (i2 != 0) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(awb, 6);
            sparseArray2.put(awc, Integer.valueOf((int) a0.t));
            sparseArray2.put(awd, Integer.valueOf(i2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray2));
        }
    }

    public void DG() {
        DI();
        if (this.avy != null) {
            this.avy.clear();
        }
        if (this.avx != null) {
            this.avx.clear();
        }
        if (this.avZ != null) {
            this.avZ.clear();
        }
    }

    private void Dv() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Dw() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(String str) {
        if (this.avx == null) {
            this.avx = new ArrayList<>();
        }
        if (str != null) {
            this.avx.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(String str) {
        if (this.avZ == null) {
            this.avZ = new ArrayList<>();
        }
        if (str != null) {
            this.avZ.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew(int i) {
        String valueOf = String.valueOf(i);
        if (this.avy == null) {
            this.avy = new ArrayList<>();
        }
        this.avy.add(valueOf);
    }

    public String DH() {
        return r(this.avZ);
    }

    public String Dz() {
        return r(this.avx);
    }

    public String getCpuString() {
        return r(this.avy);
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

    private void DI() {
        w wVar;
        if (this.avx != null && this.avx.size() > 0 && this.avy != null && this.avy.size() > 0 && this.avZ != null && this.avZ.size() > 0 && (wVar = (w) y.DR().ez(this.mSubType)) != null) {
            wVar.b(this);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public String avJ;
        public int avK;
        public String awf;

        public a() {
        }
    }
}
