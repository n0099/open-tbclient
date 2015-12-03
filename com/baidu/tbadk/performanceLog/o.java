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
    private ArrayList<String> axC;
    private ArrayList<String> axD;
    private ArrayList<String> aye;
    private boolean ayf;
    private CustomMessageListener customNormalListener = new q(this, CmdConfigCustom.CMD_PERF_LIVE_SAMPLE);
    public static int ayg = 0;
    public static int ayh = 1;
    public static int ayi = 2;
    private static CustomMessageTask axM = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new p());

    static {
        axM.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(axM);
    }

    public o() {
        Ew();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public boolean EG() {
        return this.ayf;
    }

    public void bB(boolean z) {
        this.ayf = z;
    }

    public void Ev() {
        Ex();
    }

    public void L(int i, int i2) {
        if (i != 0) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(ayg, 6);
            sparseArray.put(ayh, Integer.valueOf((int) a0.f37long));
            sparseArray.put(ayi, Integer.valueOf(i));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray));
        }
        if (i2 != 0) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(ayg, 6);
            sparseArray2.put(ayh, Integer.valueOf((int) a0.t));
            sparseArray2.put(ayi, Integer.valueOf(i2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ADD_TRAFFIC_DATA, sparseArray2));
        }
    }

    public void EH() {
        EJ();
        if (this.axD != null) {
            this.axD.clear();
        }
        if (this.axC != null) {
            this.axC.clear();
        }
        if (this.aye != null) {
            this.aye.clear();
        }
    }

    private void Ew() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Ex() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fR(String str) {
        if (this.axC == null) {
            this.axC = new ArrayList<>();
        }
        if (str != null) {
            this.axC.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(String str) {
        if (this.aye == null) {
            this.aye = new ArrayList<>();
        }
        if (str != null) {
            this.aye.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eK(int i) {
        String valueOf = String.valueOf(i);
        if (this.axD == null) {
            this.axD = new ArrayList<>();
        }
        this.axD.add(valueOf);
    }

    public String EI() {
        return s(this.aye);
    }

    public String EA() {
        return s(this.axC);
    }

    public String getCpuString() {
        return s(this.axD);
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

    private void EJ() {
        w wVar;
        if (this.axC != null && this.axC.size() > 0 && this.axD != null && this.axD.size() > 0 && this.aye != null && this.aye.size() > 0 && (wVar = (w) y.ES().eN(this.mSubType)) != null) {
            wVar.b(this);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public String axO;
        public int axP;
        public String ayk;

        public a() {
        }
    }
}
