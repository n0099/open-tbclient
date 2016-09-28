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
    private static CustomMessageTask aBp = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> aBe;
    private ArrayList<String> aBf;
    private ArrayList<String> aBg;
    private j aBk;
    private com.baidu.tbadk.performanceLog.a aBl;
    private int aBm;
    private int aBh = 0;
    private int aBi = 3;
    private int aBj = 0;
    private int aBn = 0;
    private j.a aBo = new f(this);
    private a.InterfaceC0048a aAT = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        FW();
    }

    public void onDestroy() {
        if (this.aBk != null) {
            this.aBk.a((j.a) null);
        }
        if (this.aBl != null) {
            this.aBl.a((a.InterfaceC0048a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void FV() {
        if (this.aBh < this.aBi) {
            this.aBh++;
            FX();
            if (this.aBk == null) {
                this.aBk = new j();
                this.aBk.a(this.aBo);
                this.aBk.start();
            }
            if (this.aBl == null) {
                this.aBl = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m9getInst().getContext());
                this.aBl.a(this.aAT);
                this.aBl.start();
            }
        }
    }

    private void FW() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void FX() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(int i) {
        String valueOf = String.valueOf(i);
        if (this.aBe == null) {
            this.aBe = new ArrayList<>();
        }
        this.aBe.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(String str) {
        if (this.aBf == null) {
            this.aBf = new ArrayList<>();
        }
        if (str != null) {
            this.aBf.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(int i) {
        String valueOf = String.valueOf(i);
        if (this.aBg == null) {
            this.aBg = new ArrayList<>();
        }
        this.aBg.add(valueOf);
    }

    public String FY() {
        return r(this.aBe);
    }

    public String FZ() {
        return String.valueOf(this.aBm);
    }

    public String Ga() {
        return r(this.aBf);
    }

    public String Gb() {
        return r(this.aBg);
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
    public void Gc() {
        ac acVar;
        if (this.aBj == this.aBi && this.aBi == this.aBn && (acVar = (ac) aa.Go().ff(this.aBK)) != null) {
            acVar.g(this);
        }
    }

    static {
        aBp.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aBp);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aBr;
        public int aBs;

        public a() {
        }
    }
}
