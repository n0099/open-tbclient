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
    private static CustomMessageTask ayF = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new h());
    private j ayA;
    private com.baidu.tbadk.performanceLog.a ayB;
    private int ayC;
    private ArrayList<String> ayu;
    private ArrayList<String> ayv;
    private ArrayList<String> ayw;
    private int ayx = 0;
    private int ayy = 3;
    private int ayz = 0;
    private int ayD = 0;
    private j.a ayE = new f(this);
    private a.InterfaceC0048a ayj = new g(this);
    private CustomMessageListener customNormalListener = new i(this, CmdConfigCustom.CMD_PERF_SAMPLE);

    public e() {
        ED();
    }

    public void onDestroy() {
        if (this.ayA != null) {
            this.ayA.a((j.a) null);
        }
        if (this.ayB != null) {
            this.ayB.a((a.InterfaceC0048a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void EC() {
        if (this.ayx < this.ayy) {
            this.ayx++;
            EE();
            if (this.ayA == null) {
                this.ayA = new j();
                this.ayA.a(this.ayE);
                this.ayA.start();
            }
            if (this.ayB == null) {
                this.ayB = new com.baidu.tbadk.performanceLog.a(TbadkCoreApplication.m10getInst().getContext());
                this.ayB.a(this.ayj);
                this.ayB.start();
            }
        }
    }

    private void ED() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void EE() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(int i) {
        String valueOf = String.valueOf(i);
        if (this.ayu == null) {
            this.ayu = new ArrayList<>();
        }
        this.ayu.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd(String str) {
        if (this.ayv == null) {
            this.ayv = new ArrayList<>();
        }
        if (str != null) {
            this.ayv.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(int i) {
        String valueOf = String.valueOf(i);
        if (this.ayw == null) {
            this.ayw = new ArrayList<>();
        }
        this.ayw.add(valueOf);
    }

    public String EF() {
        return r(this.ayu);
    }

    public String EG() {
        return String.valueOf(this.ayC);
    }

    public String EH() {
        return r(this.ayv);
    }

    public String EI() {
        return r(this.ayw);
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
    public void EJ() {
        ac acVar;
        if (this.ayz == this.ayy && this.ayy == this.ayD && (acVar = (ac) aa.EV().eS(this.aza)) != null) {
            acVar.g(this);
        }
    }

    static {
        ayF.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(ayF);
    }

    /* loaded from: classes.dex */
    public class a {
        public String ayH;
        public int ayI;

        public a() {
        }
    }
}
