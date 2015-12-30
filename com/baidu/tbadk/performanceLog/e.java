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
    private static CustomMessageTask azq = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> azf;
    private ArrayList<String> azg;
    private ArrayList<String> azh;
    private j azl;
    private com.baidu.tbadk.performanceLog.a azm;
    private int azn;
    private int azi = 0;
    private int azj = 3;
    private int azk = 0;
    private int azo = 0;
    private j.a azp = new f(this);
    private a.InterfaceC0055a ayU = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        El();
    }

    public void onDestroy() {
        if (this.azl != null) {
            this.azl.a((j.a) null);
        }
        if (this.azm != null) {
            this.azm.a((a.InterfaceC0055a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Ek() {
        if (this.azi < this.azj) {
            this.azi++;
            Em();
            if (this.azl == null) {
                this.azl = new j();
                this.azl.a(this.azp);
                this.azl.start();
            }
            if (this.azm == null) {
                this.azm = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m411getInst().getContext());
                this.azm.a(this.ayU);
                this.azm.start();
            }
        }
    }

    private void El() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Em() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(int i) {
        String valueOf = String.valueOf(i);
        if (this.azf == null) {
            this.azf = new ArrayList<>();
        }
        this.azf.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV(String str) {
        if (this.azg == null) {
            this.azg = new ArrayList<>();
        }
        if (str != null) {
            this.azg.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(int i) {
        String valueOf = String.valueOf(i);
        if (this.azh == null) {
            this.azh = new ArrayList<>();
        }
        this.azh.add(valueOf);
    }

    public String En() {
        return s(this.azf);
    }

    public String Eo() {
        return String.valueOf(this.azn);
    }

    public String Ep() {
        return s(this.azg);
    }

    public String getCpuString() {
        return s(this.azh);
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
    public void Eq() {
        aa aaVar;
        if (this.azk == this.azj && this.azj == this.azo && (aaVar = (aa) y.EH().eH(this.mSubType)) != null) {
            aaVar.g(this);
        }
    }

    static {
        azq.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(azq);
    }

    /* loaded from: classes.dex */
    public class a {
        public String azs;
        public int azt;

        public a() {
        }
    }
}
