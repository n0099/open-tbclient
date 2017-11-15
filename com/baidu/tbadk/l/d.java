package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.l.a;
import com.baidu.tbadk.l.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends k {
    private static CustomMessageTask aJn = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.l.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aJp = r.Gt().Gv();
            data.aJq = r.Gt().Gx();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private ArrayList<String> aJc;
    private ArrayList<String> aJd;
    private ArrayList<String> aJe;
    private e aJi;
    private com.baidu.tbadk.l.a aJj;
    private int aJk;
    private int aJf = 0;
    private int aJg = 3;
    private int aJh = 0;
    private int aJl = 0;
    private e.a aJm = new e.a() { // from class: com.baidu.tbadk.l.d.1
        @Override // com.baidu.tbadk.l.e.a
        public void fp(int i) {
            d.this.aJi.a((e.a) null);
            d.this.aJi.stop();
            d.this.aJk = i;
            t tVar = (t) r.Gt().fu(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0061a aIR = new a.InterfaceC0061a() { // from class: com.baidu.tbadk.l.d.2
        @Override // com.baidu.tbadk.l.a.InterfaceC0061a
        public void fp(int i) {
            d.this.aJl++;
            if (d.this.aJg == d.this.aJl) {
                d.this.aJj.a((a.InterfaceC0061a) null);
                d.this.aJj.stop();
                d.this.Gh();
            }
            d.this.fq(i);
        }
    };
    private CustomMessageListener customNormalListener = new CustomMessageListener(CmdConfigCustom.CMD_PERF_SAMPLE) { // from class: com.baidu.tbadk.l.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar;
            if (customResponsedMessage != null && (aVar = (a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                d.this.aJh++;
                d.this.gF(aVar.aJp);
                d.this.fr(aVar.aJq);
                d.this.Gh();
            }
        }
    };

    public d() {
        Gb();
    }

    public void onDestroy() {
        if (this.aJi != null) {
            this.aJi.a((e.a) null);
        }
        if (this.aJj != null) {
            this.aJj.a((a.InterfaceC0061a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Ga() {
        if (this.aJf < this.aJg) {
            this.aJf++;
            Gc();
            if (this.aJi == null) {
                this.aJi = new e();
                this.aJi.a(this.aJm);
                this.aJi.start();
            }
            if (this.aJj == null) {
                this.aJj = new com.baidu.tbadk.l.a(TbadkCoreApplication.getInst().getContext());
                this.aJj.a(this.aIR);
                this.aJj.start();
            }
        }
    }

    private void Gb() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Gc() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(int i) {
        String valueOf = String.valueOf(i);
        if (this.aJc == null) {
            this.aJc = new ArrayList<>();
        }
        this.aJc.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(String str) {
        if (this.aJd == null) {
            this.aJd = new ArrayList<>();
        }
        if (str != null) {
            this.aJd.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fr(int i) {
        String valueOf = String.valueOf(i);
        if (this.aJe == null) {
            this.aJe = new ArrayList<>();
        }
        this.aJe.add(valueOf);
    }

    public String Gd() {
        return r(this.aJc);
    }

    public String Ge() {
        return String.valueOf(this.aJk);
    }

    public String Gf() {
        return r(this.aJd);
    }

    public String Gg() {
        return r(this.aJe);
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
    public void Gh() {
        t tVar;
        if (this.aJh == this.aJg && this.aJg == this.aJl && (tVar = (t) r.Gt().fu(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aJn.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aJn);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aJp;
        public int aJq;

        public a() {
        }
    }
}
