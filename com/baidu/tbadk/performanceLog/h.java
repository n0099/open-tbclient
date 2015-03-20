package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends y {
    private static CustomMessageTask customNormalTask = new CustomMessageTask(2016100, new k());
    private ArrayList<String> aoA;
    private ArrayList<String> aoB;
    private ArrayList<String> aoC;
    private n aoG;
    private a aoH;
    private int aoI;
    private int aoD = 0;
    private int aoE = 3;
    private int aoF = 0;
    private int aoJ = 0;
    private q aoK = new i(this);
    private c aop = new j(this);
    private CustomMessageListener customNormalListener = new l(this, 2016100);

    public h() {
        Co();
    }

    public void onDestroy() {
        if (this.aoG != null) {
            this.aoG.a((q) null);
        }
        if (this.aoH != null) {
            this.aoH.a((c) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Cn() {
        if (this.aoD < this.aoE) {
            this.aoD++;
            Cp();
            if (this.aoG == null) {
                this.aoG = new n();
                this.aoG.a(this.aoK);
                this.aoG.start();
            }
            if (this.aoH == null) {
                this.aoH = new a(TbadkCoreApplication.m411getInst().getContext());
                this.aoH.a(this.aop);
                this.aoH.start();
            }
        }
    }

    private void Co() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Cp() {
        CustomMessage customMessage = new CustomMessage(2016100, new m(this));
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZ(int i) {
        String valueOf = String.valueOf(i);
        if (this.aoA == null) {
            this.aoA = new ArrayList<>();
        }
        this.aoA.add(valueOf);
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
    public void ea(int i) {
        String valueOf = String.valueOf(i);
        if (this.aoC == null) {
            this.aoC = new ArrayList<>();
        }
        this.aoC.add(valueOf);
    }

    public String Cq() {
        return t(this.aoA);
    }

    public String Cr() {
        return String.valueOf(this.aoI);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void Ct() {
        aj ajVar;
        if (this.aoF == this.aoE && this.aoE == this.aoJ && (ajVar = (aj) ah.CK().ed(this.mSubType)) != null) {
            ajVar.g(this);
        }
    }

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }
}
