package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.performanceLog.a;
import com.baidu.tbadk.performanceLog.j;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends r {
    private static CustomMessageTask avH = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private j avC;
    private com.baidu.tbadk.performanceLog.a avD;
    private int avE;
    private ArrayList<String> avw;
    private ArrayList<String> avx;
    private ArrayList<String> avy;
    private int avz = 0;
    private int avA = 3;
    private int avB = 0;
    private int avF = 0;
    private j.a avG = new f(this);
    private a.InterfaceC0053a avl = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        Dv();
    }

    public void onDestroy() {
        if (this.avC != null) {
            this.avC.a((j.a) null);
        }
        if (this.avD != null) {
            this.avD.a((a.InterfaceC0053a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Du() {
        if (this.avz < this.avA) {
            this.avz++;
            Dw();
            if (this.avC == null) {
                this.avC = new j();
                this.avC.a(this.avG);
                this.avC.start();
            }
            if (this.avD == null) {
                this.avD = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m411getInst().getContext());
                this.avD.a(this.avl);
                this.avD.start();
            }
        }
    }

    private void Dv() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Dw() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev(int i) {
        String valueOf = String.valueOf(i);
        if (this.avw == null) {
            this.avw = new ArrayList<>();
        }
        this.avw.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(String str) {
        if (this.avx == null) {
            this.avx = new ArrayList<>();
        }
        if (str != null) {
            this.avx.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew(int i) {
        String valueOf = String.valueOf(i);
        if (this.avy == null) {
            this.avy = new ArrayList<>();
        }
        this.avy.add(valueOf);
    }

    public String Dx() {
        return r(this.avw);
    }

    public String Dy() {
        return String.valueOf(this.avE);
    }

    public String Dz() {
        return r(this.avx);
    }

    public String getCpuString() {
        return r(this.avy);
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
    public void DA() {
        aa aaVar;
        if (this.avB == this.avA && this.avA == this.avF && (aaVar = (aa) y.DR().ez(this.mSubType)) != null) {
            aaVar.g(this);
        }
    }

    static {
        avH.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(avH);
    }

    /* loaded from: classes.dex */
    public class a {
        public String avJ;
        public int avK;

        public a() {
        }
    }
}
