package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends u {
    private static CustomMessageTask customNormalTask = new CustomMessageTask(2016100, new k());
    private ArrayList<String> agi;
    private ArrayList<String> agj;
    private ArrayList<String> agk;
    private n ago;
    private a agp;
    private int agq;
    private int agl = 0;
    private int agm = 3;
    private int agn = 0;
    private int agr = 0;
    private q ags = new i(this);
    private c afX = new j(this);
    private CustomMessageListener customNormalListener = new l(this, 2016100);

    public h() {
        zg();
    }

    public void onDestroy() {
        if (this.ago != null) {
            this.ago.a((q) null);
        }
        if (this.agp != null) {
            this.agp.a((c) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void zf() {
        if (this.agl < this.agm) {
            this.agl++;
            zh();
            if (this.ago == null) {
                this.ago = new n();
                this.ago.a(this.ags);
                this.ago.start();
            }
            if (this.agp == null) {
                this.agp = new a(TbadkCoreApplication.m255getInst().getContext());
                this.agp.a(this.afX);
                this.agp.start();
            }
        }
    }

    private void zg() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void zh() {
        CustomMessage customMessage = new CustomMessage(2016100, new m(this));
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dV(int i) {
        String valueOf = String.valueOf(i);
        if (this.agi == null) {
            this.agi = new ArrayList<>();
        }
        this.agi.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB(String str) {
        if (this.agj == null) {
            this.agj = new ArrayList<>();
        }
        if (str != null) {
            this.agj.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dW(int i) {
        String valueOf = String.valueOf(i);
        if (this.agk == null) {
            this.agk = new ArrayList<>();
        }
        this.agk.add(valueOf);
    }

    public String zi() {
        return w(this.agi);
    }

    public String zj() {
        return String.valueOf(this.agq);
    }

    public String zk() {
        return w(this.agj);
    }

    public String getCpuString() {
        return w(this.agk);
    }

    private String w(ArrayList<String> arrayList) {
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
    public void zl() {
        ae aeVar;
        if (this.agn == this.agm && this.agm == this.agr && (aeVar = (ae) ac.zy().dZ(this.mSubType)) != null) {
            aeVar.g(this);
        }
    }

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }
}
