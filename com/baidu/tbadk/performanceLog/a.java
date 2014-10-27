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
    private com.baidu.adp.lib.debug.a.e YA;
    private int YB;
    private ArrayList<String> Yt;
    private ArrayList<String> Yu;
    private ArrayList<String> Yv;
    private g Yz;
    private int Yw = 0;
    private int Yx = 3;
    private int Yy = 0;
    private int YC = 0;
    private j YD = new b(this);
    private com.baidu.adp.lib.debug.a.g gp = new c(this);
    private CustomMessageListener customNormalListener = new e(this, 2016100);

    public a() {
        uu();
    }

    public void onDestroy() {
        if (this.Yz != null) {
            this.Yz.a((j) null);
        }
        if (this.YA != null) {
            this.YA.a((com.baidu.adp.lib.debug.a.g) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void ut() {
        if (this.Yw < this.Yx) {
            this.Yw++;
            uv();
            if (this.Yz == null) {
                this.Yz = new g();
                this.Yz.a(this.YD);
                this.Yz.start();
            }
            if (this.YA == null) {
                this.YA = new com.baidu.adp.lib.debug.a.e(TbadkApplication.m251getInst());
                this.YA.a(this.gp);
                this.YA.start();
            }
        }
    }

    private void uu() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void uv() {
        CustomMessage customMessage = new CustomMessage(2016100, new f(this));
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(int i) {
        String valueOf = String.valueOf(i);
        if (this.Yt == null) {
            this.Yt = new ArrayList<>();
        }
        this.Yt.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(String str) {
        if (this.Yu == null) {
            this.Yu = new ArrayList<>();
        }
        if (str != null) {
            this.Yu.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(int i) {
        String valueOf = String.valueOf(i);
        if (this.Yv == null) {
            this.Yv = new ArrayList<>();
        }
        this.Yv.add(valueOf);
    }

    public String uw() {
        return k(this.Yt);
    }

    public String ux() {
        return String.valueOf(this.YB);
    }

    public String uy() {
        return k(this.Yu);
    }

    public String uz() {
        return k(this.Yv);
    }

    private String k(ArrayList<String> arrayList) {
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
    public void uA() {
        x xVar;
        if (this.Yy == this.Yx && this.Yx == this.YC && (xVar = (x) v.uN().dp(this.mSubType)) != null) {
            xVar.g(this);
        }
    }

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }
}
