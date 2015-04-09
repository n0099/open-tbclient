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
    private ArrayList<String> aoI;
    private ArrayList<String> aoJ;
    private ArrayList<String> aoK;
    private n aoO;
    private a aoP;
    private int aoQ;
    private int aoL = 0;
    private int aoM = 3;
    private int aoN = 0;
    private int aoR = 0;
    private q aoS = new i(this);
    private c aox = new j(this);
    private CustomMessageListener customNormalListener = new l(this, 2016100);

    public h() {
        Cu();
    }

    public void onDestroy() {
        if (this.aoO != null) {
            this.aoO.a((q) null);
        }
        if (this.aoP != null) {
            this.aoP.a((c) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Ct() {
        if (this.aoL < this.aoM) {
            this.aoL++;
            Cv();
            if (this.aoO == null) {
                this.aoO = new n();
                this.aoO.a(this.aoS);
                this.aoO.start();
            }
            if (this.aoP == null) {
                this.aoP = new a(TbadkCoreApplication.m411getInst().getContext());
                this.aoP.a(this.aox);
                this.aoP.start();
            }
        }
    }

    private void Cu() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Cv() {
        CustomMessage customMessage = new CustomMessage(2016100, new m(this));
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZ(int i) {
        String valueOf = String.valueOf(i);
        if (this.aoI == null) {
            this.aoI = new ArrayList<>();
        }
        this.aoI.add(valueOf);
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
    public void ea(int i) {
        String valueOf = String.valueOf(i);
        if (this.aoK == null) {
            this.aoK = new ArrayList<>();
        }
        this.aoK.add(valueOf);
    }

    public String Cw() {
        return t(this.aoI);
    }

    public String Cx() {
        return String.valueOf(this.aoQ);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void Cz() {
        aj ajVar;
        if (this.aoN == this.aoM && this.aoM == this.aoR && (ajVar = (aj) ah.CQ().ed(this.mSubType)) != null) {
            ajVar.g(this);
        }
    }

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }
}
