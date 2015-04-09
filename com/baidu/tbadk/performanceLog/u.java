package com.baidu.tbadk.performanceLog;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.location.a0;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends y {
    public static int apn = 0;
    public static int apo = 1;
    public static int apq = 2;
    private static CustomMessageTask customNormalTask = new CustomMessageTask(2016103, new v());
    private ArrayList<String> aoJ;
    private ArrayList<String> aoK;
    private ArrayList<String> apl;
    private boolean apm;
    private CustomMessageListener customNormalListener = new w(this, 2016103);

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    public u() {
        Cu();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public boolean CE() {
        return this.apm;
    }

    public void bc(boolean z) {
        this.apm = z;
    }

    public void Ct() {
        Cv();
    }

    public void z(int i, int i2) {
        if (i != 0) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(apn, 6);
            sparseArray.put(apo, Integer.valueOf((int) a0.f37long));
            sparseArray.put(apq, Integer.valueOf(i));
            MessageManager.getInstance().sendMessage(new CustomMessage(2905002, sparseArray));
        }
        if (i2 != 0) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(apn, 6);
            sparseArray2.put(apo, Integer.valueOf((int) a0.t));
            sparseArray2.put(apq, Integer.valueOf(i2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2905002, sparseArray2));
        }
    }

    public void CF() {
        CH();
        if (this.aoK != null) {
            this.aoK.clear();
        }
        if (this.aoJ != null) {
            this.aoJ.clear();
        }
        if (this.apl != null) {
            this.apl.clear();
        }
    }

    private void Cu() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Cv() {
        CustomMessage customMessage = new CustomMessage(2016103, new x(this));
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eF(String str) {
        if (this.aoJ == null) {
            this.aoJ = new ArrayList<>();
        }
        if (str != null) {
            this.aoJ.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eG(String str) {
        if (this.apl == null) {
            this.apl = new ArrayList<>();
        }
        if (str != null) {
            this.apl.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea(int i) {
        String valueOf = String.valueOf(i);
        if (this.aoK == null) {
            this.aoK = new ArrayList<>();
        }
        this.aoK.add(valueOf);
    }

    public String CG() {
        return t(this.apl);
    }

    public String Cy() {
        return t(this.aoJ);
    }

    public String getCpuString() {
        return t(this.aoK);
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

    private void CH() {
        af afVar;
        if (this.aoJ != null && this.aoJ.size() > 0 && this.aoK != null && this.aoK.size() > 0 && this.apl != null && this.apl.size() > 0 && (afVar = (af) ah.CQ().ed(this.mSubType)) != null) {
            afVar.b(this);
        }
    }
}
