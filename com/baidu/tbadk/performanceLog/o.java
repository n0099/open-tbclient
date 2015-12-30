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
    public static int azJ = 0;
    public static int azK = 1;
    public static int azL = 2;
    private static CustomMessageTask azq = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new p());
    private ArrayList<String> azH;
    private boolean azI;
    private ArrayList<String> azg;
    private ArrayList<String> azh;
    private CustomMessageListener customNormalListener = new q(this, CmdConfigCustom.CMD_PERF_LIVE_SAMPLE);

    static {
        azq.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(azq);
    }

    public o() {
        El();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public boolean Ev() {
        return this.azI;
    }

    public void bB(boolean z) {
        this.azI = z;
    }

    public void Ek() {
        Em();
    }

    public void L(int i, int i2) {
        if (i != 0) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(azJ, 6);
            sparseArray.put(azK, Integer.valueOf((int) a0.f37long));
            sparseArray.put(azL, Integer.valueOf(i));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray));
        }
        if (i2 != 0) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(azJ, 6);
            sparseArray2.put(azK, Integer.valueOf((int) a0.t));
            sparseArray2.put(azL, Integer.valueOf(i2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray2));
        }
    }

    public void Ew() {
        Ey();
        if (this.azh != null) {
            this.azh.clear();
        }
        if (this.azg != null) {
            this.azg.clear();
        }
        if (this.azH != null) {
            this.azH.clear();
        }
    }

    private void El() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Em() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV(String str) {
        if (this.azg == null) {
            this.azg = new ArrayList<>();
        }
        if (str != null) {
            this.azg.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(String str) {
        if (this.azH == null) {
            this.azH = new ArrayList<>();
        }
        if (str != null) {
            this.azH.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(int i) {
        String valueOf = String.valueOf(i);
        if (this.azh == null) {
            this.azh = new ArrayList<>();
        }
        this.azh.add(valueOf);
    }

    public String Ex() {
        return s(this.azH);
    }

    public String Ep() {
        return s(this.azg);
    }

    public String getCpuString() {
        return s(this.azh);
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

    private void Ey() {
        w wVar;
        if (this.azg != null && this.azg.size() > 0 && this.azh != null && this.azh.size() > 0 && this.azH != null && this.azH.size() > 0 && (wVar = (w) y.EH().eH(this.mSubType)) != null) {
            wVar.b(this);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public String azN;
        public String azs;
        public int azt;

        public a() {
        }
    }
}
