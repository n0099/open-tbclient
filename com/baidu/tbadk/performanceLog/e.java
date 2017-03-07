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
    private static CustomMessageTask aFK = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> aFA;
    private ArrayList<String> aFB;
    private j aFF;
    private com.baidu.tbadk.performanceLog.a aFG;
    private int aFH;
    private ArrayList<String> aFz;
    private int aFC = 0;
    private int aFD = 3;
    private int aFE = 0;
    private int aFI = 0;
    private j.a aFJ = new f(this);
    private a.InterfaceC0046a aFo = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        FQ();
    }

    public void onDestroy() {
        if (this.aFF != null) {
            this.aFF.a((j.a) null);
        }
        if (this.aFG != null) {
            this.aFG.a((a.InterfaceC0046a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void FP() {
        if (this.aFC < this.aFD) {
            this.aFC++;
            FR();
            if (this.aFF == null) {
                this.aFF = new j();
                this.aFF.a(this.aFJ);
                this.aFF.start();
            }
            if (this.aFG == null) {
                this.aFG = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m9getInst().getContext());
                this.aFG.a(this.aFo);
                this.aFG.start();
            }
        }
    }

    private void FQ() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void FR() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eZ(int i) {
        String valueOf = String.valueOf(i);
        if (this.aFz == null) {
            this.aFz = new ArrayList<>();
        }
        this.aFz.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fU(String str) {
        if (this.aFA == null) {
            this.aFA = new ArrayList<>();
        }
        if (str != null) {
            this.aFA.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fa(int i) {
        String valueOf = String.valueOf(i);
        if (this.aFB == null) {
            this.aFB = new ArrayList<>();
        }
        this.aFB.add(valueOf);
    }

    public String FS() {
        return r(this.aFz);
    }

    public String FT() {
        return String.valueOf(this.aFH);
    }

    public String FU() {
        return r(this.aFA);
    }

    public String FV() {
        return r(this.aFB);
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
    public void FW() {
        ac acVar;
        if (this.aFE == this.aFD && this.aFD == this.aFI && (acVar = (ac) aa.Gi().fd(this.aGf)) != null) {
            acVar.g(this);
        }
    }

    static {
        aFK.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aFK);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aFM;
        public int aFN;

        public a() {
        }
    }
}
