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
    public static int ape = 0;
    public static int apf = 1;
    public static int apg = 2;
    private static CustomMessageTask customNormalTask = new CustomMessageTask(2016103, new v());
    private ArrayList<String> aoB;
    private ArrayList<String> aoC;
    private ArrayList<String> apc;
    private boolean apd;
    private CustomMessageListener customNormalListener = new w(this, 2016103);

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    public u() {
        Co();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public boolean Cy() {
        return this.apd;
    }

    public void bc(boolean z) {
        this.apd = z;
    }

    public void Cn() {
        Cp();
    }

    public void z(int i, int i2) {
        if (i != 0) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(ape, 6);
            sparseArray.put(apf, Integer.valueOf((int) a0.f37long));
            sparseArray.put(apg, Integer.valueOf(i));
            MessageManager.getInstance().sendMessage(new CustomMessage(2905002, sparseArray));
        }
        if (i2 != 0) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(ape, 6);
            sparseArray2.put(apf, Integer.valueOf((int) a0.t));
            sparseArray2.put(apg, Integer.valueOf(i2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2905002, sparseArray2));
        }
    }

    public void Cz() {
        CB();
        if (this.aoC != null) {
            this.aoC.clear();
        }
        if (this.aoB != null) {
            this.aoB.clear();
        }
        if (this.apc != null) {
            this.apc.clear();
        }
    }

    private void Co() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Cp() {
        CustomMessage customMessage = new CustomMessage(2016103, new x(this));
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(String str) {
        if (this.aoB == null) {
            this.aoB = new ArrayList<>();
        }
        if (str != null) {
            this.aoB.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(String str) {
        if (this.apc == null) {
            this.apc = new ArrayList<>();
        }
        if (str != null) {
            this.apc.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea(int i) {
        String valueOf = String.valueOf(i);
        if (this.aoC == null) {
            this.aoC = new ArrayList<>();
        }
        this.aoC.add(valueOf);
    }

    public String CA() {
        return t(this.apc);
    }

    public String Cs() {
        return t(this.aoB);
    }

    public String getCpuString() {
        return t(this.aoC);
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

    private void CB() {
        af afVar;
        if (this.aoB != null && this.aoB.size() > 0 && this.aoC != null && this.aoC.size() > 0 && this.apc != null && this.apc.size() > 0 && (afVar = (af) ah.CK().ed(this.mSubType)) != null) {
            afVar.b(this);
        }
    }
}
