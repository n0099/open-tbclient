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
    private static CustomMessageTask aJh = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.l.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aJj = r.Gx().Gz();
            data.aJk = r.Gx().GB();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private ArrayList<String> aIW;
    private ArrayList<String> aIX;
    private ArrayList<String> aIY;
    private e aJc;
    private com.baidu.tbadk.l.a aJd;
    private int aJe;
    private int aIZ = 0;
    private int aJa = 3;
    private int aJb = 0;
    private int aJf = 0;
    private e.a aJg = new e.a() { // from class: com.baidu.tbadk.l.d.1
        @Override // com.baidu.tbadk.l.e.a
        public void ff(int i) {
            d.this.aJc.a((e.a) null);
            d.this.aJc.stop();
            d.this.aJe = i;
            t tVar = (t) r.Gx().fk(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0062a aIL = new a.InterfaceC0062a() { // from class: com.baidu.tbadk.l.d.2
        @Override // com.baidu.tbadk.l.a.InterfaceC0062a
        public void ff(int i) {
            d.this.aJf++;
            if (d.this.aJa == d.this.aJf) {
                d.this.aJd.a((a.InterfaceC0062a) null);
                d.this.aJd.stop();
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
                d.this.aJb++;
                d.this.gB(aVar.aJj);
                d.this.fh(aVar.aJk);
                d.this.Gl();
            }
        }
    };

    public d() {
        Gf();
    }

    public void onDestroy() {
        if (this.aJc != null) {
            this.aJc.a((e.a) null);
        }
        if (this.aJd != null) {
            this.aJd.a((a.InterfaceC0062a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Ge() {
        if (this.aIZ < this.aJa) {
            this.aIZ++;
            Gg();
            if (this.aJc == null) {
                this.aJc = new e();
                this.aJc.a(this.aJg);
                this.aJc.start();
            }
            if (this.aJd == null) {
                this.aJd = new com.baidu.tbadk.l.a(TbadkCoreApplication.getInst().getContext());
                this.aJd.a(this.aIL);
                this.aJd.start();
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
        if (this.aIW == null) {
            this.aIW = new ArrayList<>();
        }
        this.aIW.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(String str) {
        if (this.aIX == null) {
            this.aIX = new ArrayList<>();
        }
        if (str != null) {
            this.aIX.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh(int i) {
        String valueOf = String.valueOf(i);
        if (this.aIY == null) {
            this.aIY = new ArrayList<>();
        }
        this.aIY.add(valueOf);
    }

    public String Gh() {
        return r(this.aIW);
    }

    public String Gi() {
        return String.valueOf(this.aJe);
    }

    public String Gj() {
        return r(this.aIX);
    }

    public String Gk() {
        return r(this.aIY);
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
        if (this.aJb == this.aJa && this.aJa == this.aJf && (tVar = (t) r.Gx().fk(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aJh.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aJh);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aJj;
        public int aJk;

        public a() {
        }
    }
}
