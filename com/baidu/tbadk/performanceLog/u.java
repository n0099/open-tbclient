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
    public static int aqr = 0;
    public static int aqs = 1;
    public static int aqt = 2;
    private static CustomMessageTask customNormalTask = new CustomMessageTask(2016103, new v());
    private ArrayList<String> apO;
    private ArrayList<String> apP;
    private ArrayList<String> aqp;
    private boolean aqq;
    private CustomMessageListener customNormalListener = new w(this, 2016103);

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    public u() {
        Df();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public boolean Dp() {
        return this.aqq;
    }

    public void bj(boolean z) {
        this.aqq = z;
    }

    public void De() {
        Dg();
    }

    public void A(int i, int i2) {
        if (i != 0) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(aqr, 6);
            sparseArray.put(aqs, Integer.valueOf((int) a0.f37long));
            sparseArray.put(aqt, Integer.valueOf(i));
            MessageManager.getInstance().sendMessage(new CustomMessage(2905002, sparseArray));
        }
        if (i2 != 0) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(aqr, 6);
            sparseArray2.put(aqs, Integer.valueOf((int) a0.t));
            sparseArray2.put(aqt, Integer.valueOf(i2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2905002, sparseArray2));
        }
    }

    public void Dq() {
        Ds();
        if (this.apP != null) {
            this.apP.clear();
        }
        if (this.apO != null) {
            this.apO.clear();
        }
        if (this.aqp != null) {
            this.aqp.clear();
        }
    }

    private void Df() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Dg() {
        CustomMessage customMessage = new CustomMessage(2016103, new x(this));
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(String str) {
        if (this.apO == null) {
            this.apO = new ArrayList<>();
        }
        if (str != null) {
            this.apO.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(String str) {
        if (this.aqp == null) {
            this.aqp = new ArrayList<>();
        }
        if (str != null) {
            this.aqp.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ek(int i) {
        String valueOf = String.valueOf(i);
        if (this.apP == null) {
            this.apP = new ArrayList<>();
        }
        this.apP.add(valueOf);
    }

    public String Dr() {
        return r(this.aqp);
    }

    public String Dj() {
        return r(this.apO);
    }

    public String getCpuString() {
        return r(this.apP);
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

    private void Ds() {
        af afVar;
        if (this.apO != null && this.apO.size() > 0 && this.apP != null && this.apP.size() > 0 && this.aqp != null && this.aqp.size() > 0 && (afVar = (af) ah.DB().en(this.mSubType)) != null) {
            afVar.b(this);
        }
    }
}
