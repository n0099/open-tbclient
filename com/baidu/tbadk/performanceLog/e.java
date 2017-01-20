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
    private static CustomMessageTask aAs = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> aAh;
    private ArrayList<String> aAi;
    private ArrayList<String> aAj;
    private j aAn;
    private com.baidu.tbadk.performanceLog.a aAo;
    private int aAp;
    private int aAk = 0;
    private int aAl = 3;
    private int aAm = 0;
    private int aAq = 0;
    private j.a aAr = new f(this);
    private a.InterfaceC0047a azW = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        Fw();
    }

    public void onDestroy() {
        if (this.aAn != null) {
            this.aAn.a((j.a) null);
        }
        if (this.aAo != null) {
            this.aAo.a((a.InterfaceC0047a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Fv() {
        if (this.aAk < this.aAl) {
            this.aAk++;
            Fx();
            if (this.aAn == null) {
                this.aAn = new j();
                this.aAn.a(this.aAr);
                this.aAn.start();
            }
            if (this.aAo == null) {
                this.aAo = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m9getInst().getContext());
                this.aAo.a(this.azW);
                this.aAo.start();
            }
        }
    }

    private void Fw() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Fx() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ff(int i) {
        String valueOf = String.valueOf(i);
        if (this.aAh == null) {
            this.aAh = new ArrayList<>();
        }
        this.aAh.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gf(String str) {
        if (this.aAi == null) {
            this.aAi = new ArrayList<>();
        }
        if (str != null) {
            this.aAi.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(int i) {
        String valueOf = String.valueOf(i);
        if (this.aAj == null) {
            this.aAj = new ArrayList<>();
        }
        this.aAj.add(valueOf);
    }

    public String Fy() {
        return s(this.aAh);
    }

    public String Fz() {
        return String.valueOf(this.aAp);
    }

    public String FA() {
        return s(this.aAi);
    }

    public String FB() {
        return s(this.aAj);
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
    public void FC() {
        ac acVar;
        if (this.aAm == this.aAl && this.aAl == this.aAq && (acVar = (ac) aa.FO().fj(this.aAN)) != null) {
            acVar.g(this);
        }
    }

    static {
        aAs.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aAs);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aAu;
        public int aAv;

        public a() {
        }
    }
}
