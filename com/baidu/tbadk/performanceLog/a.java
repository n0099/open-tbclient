package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends n {
    private static CustomMessageTask customNormalTask = new CustomMessageTask(2016100, new d());
    private g YD;
    private com.baidu.adp.lib.debug.a.e YE;
    private int YF;
    private ArrayList<String> Yx;
    private ArrayList<String> Yy;
    private ArrayList<String> Yz;
    private int YA = 0;
    private int YB = 3;
    private int YC = 0;
    private int YG = 0;
    private j YH = new b(this);
    private com.baidu.adp.lib.debug.a.g gp = new c(this);
    private CustomMessageListener customNormalListener = new e(this, 2016100);

    public a() {
        uw();
    }

    public void onDestroy() {
        if (this.YD != null) {
            this.YD.a((j) null);
        }
        if (this.YE != null) {
            this.YE.a((com.baidu.adp.lib.debug.a.g) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void uv() {
        if (this.YA < this.YB) {
            this.YA++;
            ux();
            if (this.YD == null) {
                this.YD = new g();
                this.YD.a(this.YH);
                this.YD.start();
            }
            if (this.YE == null) {
                this.YE = new com.baidu.adp.lib.debug.a.e(TbadkApplication.m251getInst());
                this.YE.a(this.gp);
                this.YE.start();
            }
        }
    }

    private void uw() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void ux() {
        CustomMessage customMessage = new CustomMessage(2016100, new f(this));
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(int i) {
        String valueOf = String.valueOf(i);
        if (this.Yx == null) {
            this.Yx = new ArrayList<>();
        }
        this.Yx.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(String str) {
        if (this.Yy == null) {
            this.Yy = new ArrayList<>();
        }
        if (str != null) {
            this.Yy.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(int i) {
        String valueOf = String.valueOf(i);
        if (this.Yz == null) {
            this.Yz = new ArrayList<>();
        }
        this.Yz.add(valueOf);
    }

    public String uy() {
        return l(this.Yx);
    }

    public String uz() {
        return String.valueOf(this.YF);
    }

    public String uA() {
        return l(this.Yy);
    }

    public String uB() {
        return l(this.Yz);
    }

    private String l(ArrayList<String> arrayList) {
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
    public void uC() {
        x xVar;
        if (this.YC == this.YB && this.YB == this.YG && (xVar = (x) v.uP().dp(this.mSubType)) != null) {
            xVar.g(this);
        }
    }

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }
}
