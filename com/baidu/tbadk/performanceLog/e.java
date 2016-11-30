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
public class e extends t {
    private static CustomMessageTask aCg = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> aBV;
    private ArrayList<String> aBW;
    private ArrayList<String> aBX;
    private j aCb;
    private com.baidu.tbadk.performanceLog.a aCc;
    private int aCd;
    private int aBY = 0;
    private int aBZ = 3;
    private int aCa = 0;
    private int aCe = 0;
    private j.a aCf = new f(this);
    private a.InterfaceC0048a aBK = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        Gc();
    }

    public void onDestroy() {
        if (this.aCb != null) {
            this.aCb.a((j.a) null);
        }
        if (this.aCc != null) {
            this.aCc.a((a.InterfaceC0048a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Gb() {
        if (this.aBY < this.aBZ) {
            this.aBY++;
            Gd();
            if (this.aCb == null) {
                this.aCb = new j();
                this.aCb.a(this.aCf);
                this.aCb.start();
            }
            if (this.aCc == null) {
                this.aCc = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m9getInst().getContext());
                this.aCc.a(this.aBK);
                this.aCc.start();
            }
        }
    }

    private void Gc() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Gd() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fe(int i) {
        String valueOf = String.valueOf(i);
        if (this.aBV == null) {
            this.aBV = new ArrayList<>();
        }
        this.aBV.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gn(String str) {
        if (this.aBW == null) {
            this.aBW = new ArrayList<>();
        }
        if (str != null) {
            this.aBW.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ff(int i) {
        String valueOf = String.valueOf(i);
        if (this.aBX == null) {
            this.aBX = new ArrayList<>();
        }
        this.aBX.add(valueOf);
    }

    public String Ge() {
        return s(this.aBV);
    }

    public String Gf() {
        return String.valueOf(this.aCd);
    }

    public String Gg() {
        return s(this.aBW);
    }

    public String Gh() {
        return s(this.aBX);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void Gi() {
        ac acVar;
        if (this.aCa == this.aBZ && this.aBZ == this.aCe && (acVar = (ac) aa.Gu().fi(this.aCB)) != null) {
            acVar.g(this);
        }
    }

    static {
        aCg.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aCg);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aCi;
        public int aCj;

        public a() {
        }
    }
}
