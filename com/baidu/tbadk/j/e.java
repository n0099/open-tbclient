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
    private static CustomMessageTask aFT = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> aFI;
    private ArrayList<String> aFJ;
    private ArrayList<String> aFK;
    private j aFO;
    private com.baidu.tbadk.j.a aFP;
    private int aFQ;
    private int aFL = 0;
    private int aFM = 3;
    private int aFN = 0;
    private int aFR = 0;
    private j.a aFS = new f(this);
    private a.InterfaceC0048a aFx = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        Fm();
    }

    public void onDestroy() {
        if (this.aFO != null) {
            this.aFO.a((j.a) null);
        }
        if (this.aFP != null) {
            this.aFP.a((a.InterfaceC0048a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Fl() {
        if (this.aFL < this.aFM) {
            this.aFL++;
            Fn();
            if (this.aFO == null) {
                this.aFO = new j();
                this.aFO.a(this.aFS);
                this.aFO.start();
            }
            if (this.aFP == null) {
                this.aFP = new com.baidu.tbadk.j.a(TbadkCoreApplication.m9getInst().getContext());
                this.aFP.a(this.aFx);
                this.aFP.start();
            }
        }
    }

    private void Fm() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Fn() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eZ(int i) {
        String valueOf = String.valueOf(i);
        if (this.aFI == null) {
            this.aFI = new ArrayList<>();
        }
        this.aFI.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(String str) {
        if (this.aFJ == null) {
            this.aFJ = new ArrayList<>();
        }
        if (str != null) {
            this.aFJ.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fa(int i) {
        String valueOf = String.valueOf(i);
        if (this.aFK == null) {
            this.aFK = new ArrayList<>();
        }
        this.aFK.add(valueOf);
    }

    public String Fo() {
        return r(this.aFI);
    }

    public String Fp() {
        return String.valueOf(this.aFQ);
    }

    public String Fq() {
        return r(this.aFJ);
    }

    public String Fr() {
        return r(this.aFK);
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
    public void Fs() {
        ac acVar;
        if (this.aFN == this.aFM && this.aFM == this.aFR && (acVar = (ac) aa.FE().fd(this.mSubType)) != null) {
            acVar.g(this);
        }
    }

    static {
        aFT.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aFT);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aFV;
        public int aFW;

        public a() {
        }
    }
}
