package com.baidu.tbadk.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.j.a;
import com.baidu.tbadk.j.j;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends t {
    private static CustomMessageTask aGa = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> aFP;
    private ArrayList<String> aFQ;
    private ArrayList<String> aFR;
    private j aFV;
    private com.baidu.tbadk.j.a aFW;
    private int aFX;
    private int aFS = 0;
    private int aFT = 3;
    private int aFU = 0;
    private int aFY = 0;
    private j.a aFZ = new f(this);
    private a.InterfaceC0044a aFE = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        Go();
    }

    public void onDestroy() {
        if (this.aFV != null) {
            this.aFV.a((j.a) null);
        }
        if (this.aFW != null) {
            this.aFW.a((a.InterfaceC0044a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Gn() {
        if (this.aFS < this.aFT) {
            this.aFS++;
            Gp();
            if (this.aFV == null) {
                this.aFV = new j();
                this.aFV.a(this.aFZ);
                this.aFV.start();
            }
            if (this.aFW == null) {
                this.aFW = new com.baidu.tbadk.j.a(TbadkCoreApplication.m9getInst().getContext());
                this.aFW.a(this.aFE);
                this.aFW.start();
            }
        }
    }

    private void Go() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Gp() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(int i) {
        String valueOf = String.valueOf(i);
        if (this.aFP == null) {
            this.aFP = new ArrayList<>();
        }
        this.aFP.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(String str) {
        if (this.aFQ == null) {
            this.aFQ = new ArrayList<>();
        }
        if (str != null) {
            this.aFQ.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(int i) {
        String valueOf = String.valueOf(i);
        if (this.aFR == null) {
            this.aFR = new ArrayList<>();
        }
        this.aFR.add(valueOf);
    }

    public String Gq() {
        return r(this.aFP);
    }

    public String Gr() {
        return String.valueOf(this.aFX);
    }

    public String Gs() {
        return r(this.aFQ);
    }

    public String Gt() {
        return r(this.aFR);
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
    public void Gu() {
        ac acVar;
        if (this.aFU == this.aFT && this.aFT == this.aFY && (acVar = (ac) aa.GG().fg(this.mSubType)) != null) {
            acVar.g(this);
        }
    }

    static {
        aGa.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aGa);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aGc;
        public int aGd;

        public a() {
        }
    }
}
