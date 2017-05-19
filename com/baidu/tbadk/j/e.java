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
    private static CustomMessageTask aGg = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> aFV;
    private ArrayList<String> aFW;
    private ArrayList<String> aFX;
    private j aGb;
    private com.baidu.tbadk.j.a aGc;
    private int aGd;
    private int aFY = 0;
    private int aFZ = 3;
    private int aGa = 0;
    private int aGe = 0;
    private j.a aGf = new f(this);
    private a.InterfaceC0048a aFK = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        Fs();
    }

    public void onDestroy() {
        if (this.aGb != null) {
            this.aGb.a((j.a) null);
        }
        if (this.aGc != null) {
            this.aGc.a((a.InterfaceC0048a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Fr() {
        if (this.aFY < this.aFZ) {
            this.aFY++;
            Ft();
            if (this.aGb == null) {
                this.aGb = new j();
                this.aGb.a(this.aGf);
                this.aGb.start();
            }
            if (this.aGc == null) {
                this.aGc = new com.baidu.tbadk.j.a(TbadkCoreApplication.m9getInst().getContext());
                this.aGc.a(this.aFK);
                this.aGc.start();
            }
        }
    }

    private void Fs() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Ft() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(int i) {
        String valueOf = String.valueOf(i);
        if (this.aFV == null) {
            this.aFV = new ArrayList<>();
        }
        this.aFV.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fX(String str) {
        if (this.aFW == null) {
            this.aFW = new ArrayList<>();
        }
        if (str != null) {
            this.aFW.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eZ(int i) {
        String valueOf = String.valueOf(i);
        if (this.aFX == null) {
            this.aFX = new ArrayList<>();
        }
        this.aFX.add(valueOf);
    }

    public String Fu() {
        return r(this.aFV);
    }

    public String Fv() {
        return String.valueOf(this.aGd);
    }

    public String Fw() {
        return r(this.aFW);
    }

    public String Fx() {
        return r(this.aFX);
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
    public void Fy() {
        ac acVar;
        if (this.aGa == this.aFZ && this.aFZ == this.aGe && (acVar = (ac) aa.FK().fc(this.mSubType)) != null) {
            acVar.g(this);
        }
    }

    static {
        aGg.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aGg);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aGi;
        public int aGj;

        public a() {
        }
    }
}
