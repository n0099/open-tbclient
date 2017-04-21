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
    private static CustomMessageTask aGc = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> aFR;
    private ArrayList<String> aFS;
    private ArrayList<String> aFT;
    private j aFX;
    private com.baidu.tbadk.j.a aFY;
    private int aFZ;
    private int aFU = 0;
    private int aFV = 3;
    private int aFW = 0;
    private int aGa = 0;
    private j.a aGb = new f(this);
    private a.InterfaceC0044a aFG = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        Go();
    }

    public void onDestroy() {
        if (this.aFX != null) {
            this.aFX.a((j.a) null);
        }
        if (this.aFY != null) {
            this.aFY.a((a.InterfaceC0044a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Gn() {
        if (this.aFU < this.aFV) {
            this.aFU++;
            Gp();
            if (this.aFX == null) {
                this.aFX = new j();
                this.aFX.a(this.aGb);
                this.aFX.start();
            }
            if (this.aFY == null) {
                this.aFY = new com.baidu.tbadk.j.a(TbadkCoreApplication.m9getInst().getContext());
                this.aFY.a(this.aFG);
                this.aFY.start();
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
        if (this.aFR == null) {
            this.aFR = new ArrayList<>();
        }
        this.aFR.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(String str) {
        if (this.aFS == null) {
            this.aFS = new ArrayList<>();
        }
        if (str != null) {
            this.aFS.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(int i) {
        String valueOf = String.valueOf(i);
        if (this.aFT == null) {
            this.aFT = new ArrayList<>();
        }
        this.aFT.add(valueOf);
    }

    public String Gq() {
        return r(this.aFR);
    }

    public String Gr() {
        return String.valueOf(this.aFZ);
    }

    public String Gs() {
        return r(this.aFS);
    }

    public String Gt() {
        return r(this.aFT);
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
        if (this.aFW == this.aFV && this.aFV == this.aGa && (acVar = (ac) aa.GG().fg(this.mSubType)) != null) {
            acVar.g(this);
        }
    }

    static {
        aGc.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aGc);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aGe;
        public int aGf;

        public a() {
        }
    }
}
