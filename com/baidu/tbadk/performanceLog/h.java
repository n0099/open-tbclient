package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends u {
    private static CustomMessageTask customNormalTask = new CustomMessageTask(2016100, new k());
    private ArrayList<String> afK;
    private ArrayList<String> afL;
    private ArrayList<String> afM;
    private n afQ;
    private a afR;
    private int afS;
    private int afN = 0;
    private int afO = 3;
    private int afP = 0;
    private int afT = 0;
    private q afU = new i(this);
    private c afA = new j(this);
    private CustomMessageListener customNormalListener = new l(this, 2016100);

    public h() {
        yP();
    }

    public void onDestroy() {
        if (this.afQ != null) {
            this.afQ.a((q) null);
        }
        if (this.afR != null) {
            this.afR.a((c) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void yO() {
        if (this.afN < this.afO) {
            this.afN++;
            yQ();
            if (this.afQ == null) {
                this.afQ = new n();
                this.afQ.a(this.afU);
                this.afQ.start();
            }
            if (this.afR == null) {
                this.afR = new a(TbadkCoreApplication.m255getInst().getContext());
                this.afR.a(this.afA);
                this.afR.start();
            }
        }
    }

    private void yP() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void yQ() {
        CustomMessage customMessage = new CustomMessage(2016100, new m(this));
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP(int i) {
        String valueOf = String.valueOf(i);
        if (this.afK == null) {
            this.afK = new ArrayList<>();
        }
        this.afK.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB(String str) {
        if (this.afL == null) {
            this.afL = new ArrayList<>();
        }
        if (str != null) {
            this.afL.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(int i) {
        String valueOf = String.valueOf(i);
        if (this.afM == null) {
            this.afM = new ArrayList<>();
        }
        this.afM.add(valueOf);
    }

    public String yR() {
        return v(this.afK);
    }

    public String yS() {
        return String.valueOf(this.afS);
    }

    public String yT() {
        return v(this.afL);
    }

    public String getCpuString() {
        return v(this.afM);
    }

    private String v(ArrayList<String> arrayList) {
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
    public void yU() {
        ae aeVar;
        if (this.afP == this.afO && this.afO == this.afT && (aeVar = (ae) ac.zh().dT(this.mSubType)) != null) {
            aeVar.g(this);
        }
    }

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }
}
