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
    public static int ayM = 0;
    public static int ayN = 1;
    public static int ayO = 2;
    private static CustomMessageTask customNormalTask = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new p());
    private ArrayList<String> ayK;
    private boolean ayL;
    private ArrayList<String> ayj;
    private ArrayList<String> ayk;
    private CustomMessageListener customNormalListener = new q(this, CmdConfigCustom.CMD_PERF_LIVE_SAMPLE);

    static {
        customNormalTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    public o() {
        DS();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public boolean Ec() {
        return this.ayL;
    }

    public void br(boolean z) {
        this.ayL = z;
    }

    public void DR() {
        DT();
    }

    public void K(int i, int i2) {
        if (i != 0) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(ayM, 6);
            sparseArray.put(ayN, Integer.valueOf((int) a0.f37long));
            sparseArray.put(ayO, Integer.valueOf(i));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray));
        }
        if (i2 != 0) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(ayM, 6);
            sparseArray2.put(ayN, Integer.valueOf((int) a0.t));
            sparseArray2.put(ayO, Integer.valueOf(i2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray2));
        }
    }

    public void Ed() {
        Ef();
        if (this.ayk != null) {
            this.ayk.clear();
        }
        if (this.ayj != null) {
            this.ayj.clear();
        }
        if (this.ayK != null) {
            this.ayK.clear();
        }
    }

    private void DS() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void DT() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw(String str) {
        if (this.ayj == null) {
            this.ayj = new ArrayList<>();
        }
        if (str != null) {
            this.ayj.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(String str) {
        if (this.ayK == null) {
            this.ayK = new ArrayList<>();
        }
        if (str != null) {
            this.ayK.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(int i) {
        String valueOf = String.valueOf(i);
        if (this.ayk == null) {
            this.ayk = new ArrayList<>();
        }
        this.ayk.add(valueOf);
    }

    public String Ee() {
        return r(this.ayK);
    }

    public String DW() {
        return r(this.ayj);
    }

    public String getCpuString() {
        return r(this.ayk);
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

    private void Ef() {
        w wVar;
        if (this.ayj != null && this.ayj.size() > 0 && this.ayk != null && this.ayk.size() > 0 && this.ayK != null && this.ayK.size() > 0 && (wVar = (w) y.Eo().eA(this.mSubType)) != null) {
            wVar.b(this);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public String ayQ;
        public String ayu;
        public int ayv;

        public a() {
        }
    }
}
