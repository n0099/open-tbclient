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
    private static CustomMessageTask aJG = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.l.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aJI = r.Gz().GB();
            data.aJJ = r.Gz().GD();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private e aJB;
    private com.baidu.tbadk.l.a aJC;
    private int aJD;
    private ArrayList<String> aJv;
    private ArrayList<String> aJw;
    private ArrayList<String> aJx;
    private int aJy = 0;
    private int aJz = 3;
    private int aJA = 0;
    private int aJE = 0;
    private e.a aJF = new e.a() { // from class: com.baidu.tbadk.l.d.1
        @Override // com.baidu.tbadk.l.e.a
        public void ff(int i) {
            d.this.aJB.a((e.a) null);
            d.this.aJB.stop();
            d.this.aJD = i;
            t tVar = (t) r.Gz().fk(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0060a aJk = new a.InterfaceC0060a() { // from class: com.baidu.tbadk.l.d.2
        @Override // com.baidu.tbadk.l.a.InterfaceC0060a
        public void ff(int i) {
            d.this.aJE++;
            if (d.this.aJz == d.this.aJE) {
                d.this.aJC.a((a.InterfaceC0060a) null);
                d.this.aJC.stop();
                d.this.Gn();
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
                d.this.aJA++;
                d.this.gF(aVar.aJI);
                d.this.fh(aVar.aJJ);
                d.this.Gn();
            }
        }
    };

    public d() {
        Gh();
    }

    public void onDestroy() {
        if (this.aJB != null) {
            this.aJB.a((e.a) null);
        }
        if (this.aJC != null) {
            this.aJC.a((a.InterfaceC0060a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Gg() {
        if (this.aJy < this.aJz) {
            this.aJy++;
            Gi();
            if (this.aJB == null) {
                this.aJB = new e();
                this.aJB.a(this.aJF);
                this.aJB.start();
            }
            if (this.aJC == null) {
                this.aJC = new com.baidu.tbadk.l.a(TbadkCoreApplication.getInst().getContext());
                this.aJC.a(this.aJk);
                this.aJC.start();
            }
        }
    }

    private void Gh() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Gi() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(int i) {
        String valueOf = String.valueOf(i);
        if (this.aJv == null) {
            this.aJv = new ArrayList<>();
        }
        this.aJv.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(String str) {
        if (this.aJw == null) {
            this.aJw = new ArrayList<>();
        }
        if (str != null) {
            this.aJw.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh(int i) {
        String valueOf = String.valueOf(i);
        if (this.aJx == null) {
            this.aJx = new ArrayList<>();
        }
        this.aJx.add(valueOf);
    }

    public String Gj() {
        return r(this.aJv);
    }

    public String Gk() {
        return String.valueOf(this.aJD);
    }

    public String Gl() {
        return r(this.aJw);
    }

    public String Gm() {
        return r(this.aJx);
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
    public void Gn() {
        t tVar;
        if (this.aJA == this.aJz && this.aJz == this.aJE && (tVar = (t) r.Gz().fk(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aJG.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aJG);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aJI;
        public int aJJ;

        public a() {
        }
    }
}
