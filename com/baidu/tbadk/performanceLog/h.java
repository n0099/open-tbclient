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
    private ArrayList<String> apN;
    private ArrayList<String> apO;
    private ArrayList<String> apP;
    private n apT;
    private a apU;
    private int apV;
    private int apQ = 0;
    private int apR = 3;
    private int apS = 0;
    private int apW = 0;
    private q apX = new i(this);
    private c apC = new j(this);
    private CustomMessageListener customNormalListener = new l(this, 2016100);

    public h() {
        Dg();
    }

    public void onDestroy() {
        if (this.apT != null) {
            this.apT.a((q) null);
        }
        if (this.apU != null) {
            this.apU.a((c) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Df() {
        if (this.apQ < this.apR) {
            this.apQ++;
            Dh();
            if (this.apT == null) {
                this.apT = new n();
                this.apT.a(this.apX);
                this.apT.start();
            }
            if (this.apU == null) {
                this.apU = new a(TbadkCoreApplication.m411getInst().getContext());
                this.apU.a(this.apC);
                this.apU.start();
            }
        }
    }

    private void Dg() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Dh() {
        CustomMessage customMessage = new CustomMessage(2016100, new m(this));
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ej(int i) {
        String valueOf = String.valueOf(i);
        if (this.apN == null) {
            this.apN = new ArrayList<>();
        }
        this.apN.add(valueOf);
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
    public void ek(int i) {
        String valueOf = String.valueOf(i);
        if (this.apP == null) {
            this.apP = new ArrayList<>();
        }
        this.apP.add(valueOf);
    }

    public String Di() {
        return r(this.apN);
    }

    public String Dj() {
        return String.valueOf(this.apV);
    }

    public String Dk() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void Dl() {
        aj ajVar;
        if (this.apS == this.apR && this.apR == this.apW && (ajVar = (aj) ah.DC().en(this.mSubType)) != null) {
            ajVar.g(this);
        }
    }

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }
}
