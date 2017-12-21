package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.k.a;
import com.baidu.tbadk.k.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends k {
    private static CustomMessageTask aJV = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aJX = r.GB().GD();
            data.aJY = r.GB().GF();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private ArrayList<String> aJK;
    private ArrayList<String> aJL;
    private ArrayList<String> aJM;
    private e aJQ;
    private com.baidu.tbadk.k.a aJR;
    private int aJS;
    private int aJN = 0;
    private int aJO = 3;
    private int aJP = 0;
    private int aJT = 0;
    private e.a aJU = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void fo(int i) {
            d.this.aJQ.a((e.a) null);
            d.this.aJQ.stop();
            d.this.aJS = i;
            t tVar = (t) r.GB().ft(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0074a aJz = new a.InterfaceC0074a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0074a
        public void fo(int i) {
            d.this.aJT++;
            if (d.this.aJO == d.this.aJT) {
                d.this.aJR.a((a.InterfaceC0074a) null);
                d.this.aJR.stop();
                d.this.Gp();
            }
            d.this.fp(i);
        }
    };
    private CustomMessageListener customNormalListener = new CustomMessageListener(CmdConfigCustom.CMD_PERF_SAMPLE) { // from class: com.baidu.tbadk.k.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar;
            if (customResponsedMessage != null && (aVar = (a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                d.this.aJP++;
                d.this.gH(aVar.aJX);
                d.this.fq(aVar.aJY);
                d.this.Gp();
            }
        }
    };

    public d() {
        Gj();
    }

    public void onDestroy() {
        if (this.aJQ != null) {
            this.aJQ.a((e.a) null);
        }
        if (this.aJR != null) {
            this.aJR.a((a.InterfaceC0074a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Gi() {
        if (this.aJN < this.aJO) {
            this.aJN++;
            Gk();
            if (this.aJQ == null) {
                this.aJQ = new e();
                this.aJQ.a(this.aJU);
                this.aJQ.start();
            }
            if (this.aJR == null) {
                this.aJR = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.aJR.a(this.aJz);
                this.aJR.start();
            }
        }
    }

    private void Gj() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Gk() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(int i) {
        String valueOf = String.valueOf(i);
        if (this.aJK == null) {
            this.aJK = new ArrayList<>();
        }
        this.aJK.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gH(String str) {
        if (this.aJL == null) {
            this.aJL = new ArrayList<>();
        }
        if (str != null) {
            this.aJL.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(int i) {
        String valueOf = String.valueOf(i);
        if (this.aJM == null) {
            this.aJM = new ArrayList<>();
        }
        this.aJM.add(valueOf);
    }

    public String Gl() {
        return r(this.aJK);
    }

    public String Gm() {
        return String.valueOf(this.aJS);
    }

    public String Gn() {
        return r(this.aJL);
    }

    public String Go() {
        return r(this.aJM);
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
                stringBuffer.append(str + "_");
            }
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gp() {
        t tVar;
        if (this.aJP == this.aJO && this.aJO == this.aJT && (tVar = (t) r.GB().ft(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aJV.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aJV);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aJX;
        public int aJY;

        public a() {
        }
    }
}
