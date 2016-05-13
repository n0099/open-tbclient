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
    private static CustomMessageTask awZ = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private ArrayList<String> awO;
    private ArrayList<String> awP;
    private ArrayList<String> awQ;
    private j awU;
    private com.baidu.tbadk.performanceLog.a awV;
    private int awW;
    private int awR = 0;
    private int awS = 3;
    private int awT = 0;
    private int awX = 0;
    private j.a awY = new f(this);
    private a.InterfaceC0047a awD = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        Ev();
    }

    public void onDestroy() {
        if (this.awU != null) {
            this.awU.a((j.a) null);
        }
        if (this.awV != null) {
            this.awV.a((a.InterfaceC0047a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Eu() {
        if (this.awR < this.awS) {
            this.awR++;
            Ew();
            if (this.awU == null) {
                this.awU = new j();
                this.awU.a(this.awY);
                this.awU.start();
            }
            if (this.awV == null) {
                this.awV = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m11getInst().getContext());
                this.awV.a(this.awD);
                this.awV.start();
            }
        }
    }

    private void Ev() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Ew() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(int i) {
        String valueOf = String.valueOf(i);
        if (this.awO == null) {
            this.awO = new ArrayList<>();
        }
        this.awO.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ(String str) {
        if (this.awP == null) {
            this.awP = new ArrayList<>();
        }
        if (str != null) {
            this.awP.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eK(int i) {
        String valueOf = String.valueOf(i);
        if (this.awQ == null) {
            this.awQ = new ArrayList<>();
        }
        this.awQ.add(valueOf);
    }

    public String Ex() {
        return q(this.awO);
    }

    public String Ey() {
        return String.valueOf(this.awW);
    }

    public String Ez() {
        return q(this.awP);
    }

    public String EA() {
        return q(this.awQ);
    }

    private String q(ArrayList<String> arrayList) {
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
    public void EB() {
        ac acVar;
        if (this.awT == this.awS && this.awS == this.awX && (acVar = (ac) aa.EN().eN(this.axu)) != null) {
            acVar.g(this);
        }
    }

    static {
        awZ.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(awZ);
    }

    /* loaded from: classes.dex */
    public class a {
        public String axb;
        public int axc;

        public a() {
        }
    }
}
