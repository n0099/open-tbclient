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
    private static CustomMessageTask customNormalTask = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> ayi;
    private ArrayList<String> ayj;
    private ArrayList<String> ayk;
    private j ayo;
    private com.baidu.tbadk.performanceLog.a ayp;
    private int ayq;
    private int ayl = 0;
    private int aym = 3;
    private int ayn = 0;
    private int ayr = 0;
    private j.a ays = new f(this);
    private a.InterfaceC0053a axX = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        DS();
    }

    public void onDestroy() {
        if (this.ayo != null) {
            this.ayo.a((j.a) null);
        }
        if (this.ayp != null) {
            this.ayp.a((a.InterfaceC0053a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void DR() {
        if (this.ayl < this.aym) {
            this.ayl++;
            DT();
            if (this.ayo == null) {
                this.ayo = new j();
                this.ayo.a(this.ays);
                this.ayo.start();
            }
            if (this.ayp == null) {
                this.ayp = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m411getInst().getContext());
                this.ayp.a(this.axX);
                this.ayp.start();
            }
        }
    }

    private void DS() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void DT() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew(int i) {
        String valueOf = String.valueOf(i);
        if (this.ayi == null) {
            this.ayi = new ArrayList<>();
        }
        this.ayi.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw(String str) {
        if (this.ayj == null) {
            this.ayj = new ArrayList<>();
        }
        if (str != null) {
            this.ayj.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(int i) {
        String valueOf = String.valueOf(i);
        if (this.ayk == null) {
            this.ayk = new ArrayList<>();
        }
        this.ayk.add(valueOf);
    }

    public String DU() {
        return r(this.ayi);
    }

    public String DV() {
        return String.valueOf(this.ayq);
    }

    public String DW() {
        return r(this.ayj);
    }

    public String getCpuString() {
        return r(this.ayk);
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
    public void DX() {
        aa aaVar;
        if (this.ayn == this.aym && this.aym == this.ayr && (aaVar = (aa) y.Eo().eA(this.mSubType)) != null) {
            aaVar.g(this);
        }
    }

    static {
        customNormalTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }

    /* loaded from: classes.dex */
    public class a {
        public String ayu;
        public int ayv;

        public a() {
        }
    }
}
