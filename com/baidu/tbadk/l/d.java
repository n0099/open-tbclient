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
    private static CustomMessageTask aJk = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.l.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aJm = r.Gx().Gz();
            data.aJn = r.Gx().GB();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private ArrayList<String> aIZ;
    private ArrayList<String> aJa;
    private ArrayList<String> aJb;
    private e aJf;
    private com.baidu.tbadk.l.a aJg;
    private int aJh;
    private int aJc = 0;
    private int aJd = 3;
    private int aJe = 0;
    private int aJi = 0;
    private e.a aJj = new e.a() { // from class: com.baidu.tbadk.l.d.1
        @Override // com.baidu.tbadk.l.e.a
        public void ff(int i) {
            d.this.aJf.a((e.a) null);
            d.this.aJf.stop();
            d.this.aJh = i;
            t tVar = (t) r.Gx().fk(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0063a aIO = new a.InterfaceC0063a() { // from class: com.baidu.tbadk.l.d.2
        @Override // com.baidu.tbadk.l.a.InterfaceC0063a
        public void ff(int i) {
            d.this.aJi++;
            if (d.this.aJd == d.this.aJi) {
                d.this.aJg.a((a.InterfaceC0063a) null);
                d.this.aJg.stop();
                d.this.Gl();
            }
            d.this.fg(i);
        }
    };
    private CustomMessageListener customNormalListener = new CustomMessageListener(CmdConfigCustom.CMD_PERF_SAMPLE) { // from class: com.baidu.tbadk.l.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar;
            if (customResponsedMessage != null && (aVar = (a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                d.this.aJe++;
                d.this.gB(aVar.aJm);
                d.this.fh(aVar.aJn);
                d.this.Gl();
            }
        }
    };

    public d() {
        Gf();
    }

    public void onDestroy() {
        if (this.aJf != null) {
            this.aJf.a((e.a) null);
        }
        if (this.aJg != null) {
            this.aJg.a((a.InterfaceC0063a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Ge() {
        if (this.aJc < this.aJd) {
            this.aJc++;
            Gg();
            if (this.aJf == null) {
                this.aJf = new e();
                this.aJf.a(this.aJj);
                this.aJf.start();
            }
            if (this.aJg == null) {
                this.aJg = new com.baidu.tbadk.l.a(TbadkCoreApplication.getInst().getContext());
                this.aJg.a(this.aIO);
                this.aJg.start();
            }
        }
    }

    private void Gf() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Gg() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(int i) {
        String valueOf = String.valueOf(i);
        if (this.aIZ == null) {
            this.aIZ = new ArrayList<>();
        }
        this.aIZ.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(String str) {
        if (this.aJa == null) {
            this.aJa = new ArrayList<>();
        }
        if (str != null) {
            this.aJa.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh(int i) {
        String valueOf = String.valueOf(i);
        if (this.aJb == null) {
            this.aJb = new ArrayList<>();
        }
        this.aJb.add(valueOf);
    }

    public String Gh() {
        return r(this.aIZ);
    }

    public String Gi() {
        return String.valueOf(this.aJh);
    }

    public String Gj() {
        return r(this.aJa);
    }

    public String Gk() {
        return r(this.aJb);
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
    public void Gl() {
        t tVar;
        if (this.aJe == this.aJd && this.aJd == this.aJi && (tVar = (t) r.Gx().fk(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aJk.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aJk);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aJm;
        public int aJn;

        public a() {
        }
    }
}
