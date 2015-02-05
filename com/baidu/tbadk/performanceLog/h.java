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
    private ArrayList<String> agf;
    private ArrayList<String> agg;
    private ArrayList<String> agh;
    private n agl;
    private a agm;
    private int agn;
    private int agi = 0;
    private int agj = 3;
    private int agk = 0;
    private int ago = 0;
    private q agp = new i(this);
    private c afU = new j(this);
    private CustomMessageListener customNormalListener = new l(this, 2016100);

    public h() {
        za();
    }

    public void onDestroy() {
        if (this.agl != null) {
            this.agl.a((q) null);
        }
        if (this.agm != null) {
            this.agm.a((c) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void yZ() {
        if (this.agi < this.agj) {
            this.agi++;
            zb();
            if (this.agl == null) {
                this.agl = new n();
                this.agl.a(this.agp);
                this.agl.start();
            }
            if (this.agm == null) {
                this.agm = new a(TbadkCoreApplication.m255getInst().getContext());
                this.agm.a(this.afU);
                this.agm.start();
            }
        }
    }

    private void za() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void zb() {
        CustomMessage customMessage = new CustomMessage(2016100, new m(this));
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dV(int i) {
        String valueOf = String.valueOf(i);
        if (this.agf == null) {
            this.agf = new ArrayList<>();
        }
        this.agf.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ey(String str) {
        if (this.agg == null) {
            this.agg = new ArrayList<>();
        }
        if (str != null) {
            this.agg.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dW(int i) {
        String valueOf = String.valueOf(i);
        if (this.agh == null) {
            this.agh = new ArrayList<>();
        }
        this.agh.add(valueOf);
    }

    public String zc() {
        return w(this.agf);
    }

    public String zd() {
        return String.valueOf(this.agn);
    }

    public String ze() {
        return w(this.agg);
    }

    public String getCpuString() {
        return w(this.agh);
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
    public void zf() {
        ae aeVar;
        if (this.agk == this.agj && this.agj == this.ago && (aeVar = (ae) ac.zs().dZ(this.mSubType)) != null) {
            aeVar.g(this);
        }
    }

    static {
        customNormalTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customNormalTask);
    }
}
