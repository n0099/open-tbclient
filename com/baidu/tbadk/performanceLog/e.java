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
    private static CustomMessageTask aBA = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> aBp;
    private ArrayList<String> aBq;
    private ArrayList<String> aBr;
    private j aBv;
    private com.baidu.tbadk.performanceLog.a aBw;
    private int aBx;
    private int aBs = 0;
    private int aBt = 3;
    private int aBu = 0;
    private int aBy = 0;
    private j.a aBz = new f(this);
    private a.InterfaceC0048a aBe = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        FC();
    }

    public void onDestroy() {
        if (this.aBv != null) {
            this.aBv.a((j.a) null);
        }
        if (this.aBw != null) {
            this.aBw.a((a.InterfaceC0048a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void FB() {
        if (this.aBs < this.aBt) {
            this.aBs++;
            FD();
            if (this.aBv == null) {
                this.aBv = new j();
                this.aBv.a(this.aBz);
                this.aBv.start();
            }
            if (this.aBw == null) {
                this.aBw = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m9getInst().getContext());
                this.aBw.a(this.aBe);
                this.aBw.start();
            }
        }
    }

    private void FC() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void FD() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fe(int i) {
        String valueOf = String.valueOf(i);
        if (this.aBp == null) {
            this.aBp = new ArrayList<>();
        }
        this.aBp.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi(String str) {
        if (this.aBq == null) {
            this.aBq = new ArrayList<>();
        }
        if (str != null) {
            this.aBq.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ff(int i) {
        String valueOf = String.valueOf(i);
        if (this.aBr == null) {
            this.aBr = new ArrayList<>();
        }
        this.aBr.add(valueOf);
    }

    public String FE() {
        return s(this.aBp);
    }

    public String FF() {
        return String.valueOf(this.aBx);
    }

    public String FG() {
        return s(this.aBq);
    }

    public String FH() {
        return s(this.aBr);
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
    public void FI() {
        ac acVar;
        if (this.aBu == this.aBt && this.aBt == this.aBy && (acVar = (ac) aa.FU().fi(this.aBV)) != null) {
            acVar.g(this);
        }
    }

    static {
        aBA.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aBA);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aBC;
        public int aBD;

        public a() {
        }
    }
}
