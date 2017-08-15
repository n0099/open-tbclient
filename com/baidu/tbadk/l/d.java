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
    private static CustomMessageTask aJF = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.l.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aJH = r.Gz().GB();
            data.aJI = r.Gz().GD();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private e aJA;
    private com.baidu.tbadk.l.a aJB;
    private int aJC;
    private ArrayList<String> aJu;
    private ArrayList<String> aJv;
    private ArrayList<String> aJw;
    private int aJx = 0;
    private int aJy = 3;
    private int aJz = 0;
    private int aJD = 0;
    private e.a aJE = new e.a() { // from class: com.baidu.tbadk.l.d.1
        @Override // com.baidu.tbadk.l.e.a
        public void ff(int i) {
            d.this.aJA.a((e.a) null);
            d.this.aJA.stop();
            d.this.aJC = i;
            t tVar = (t) r.Gz().fk(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0060a aJj = new a.InterfaceC0060a() { // from class: com.baidu.tbadk.l.d.2
        @Override // com.baidu.tbadk.l.a.InterfaceC0060a
        public void ff(int i) {
            d.this.aJD++;
            if (d.this.aJy == d.this.aJD) {
                d.this.aJB.a((a.InterfaceC0060a) null);
                d.this.aJB.stop();
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
                d.this.aJz++;
                d.this.gC(aVar.aJH);
                d.this.fh(aVar.aJI);
                d.this.Gn();
            }
        }
    };

    public d() {
        Gh();
    }

    public void onDestroy() {
        if (this.aJA != null) {
            this.aJA.a((e.a) null);
        }
        if (this.aJB != null) {
            this.aJB.a((a.InterfaceC0060a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Gg() {
        if (this.aJx < this.aJy) {
            this.aJx++;
            Gi();
            if (this.aJA == null) {
                this.aJA = new e();
                this.aJA.a(this.aJE);
                this.aJA.start();
            }
            if (this.aJB == null) {
                this.aJB = new com.baidu.tbadk.l.a(TbadkCoreApplication.getInst().getContext());
                this.aJB.a(this.aJj);
                this.aJB.start();
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
        if (this.aJu == null) {
            this.aJu = new ArrayList<>();
        }
        this.aJu.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(String str) {
        if (this.aJv == null) {
            this.aJv = new ArrayList<>();
        }
        if (str != null) {
            this.aJv.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh(int i) {
        String valueOf = String.valueOf(i);
        if (this.aJw == null) {
            this.aJw = new ArrayList<>();
        }
        this.aJw.add(valueOf);
    }

    public String Gj() {
        return r(this.aJu);
    }

    public String Gk() {
        return String.valueOf(this.aJC);
    }

    public String Gl() {
        return r(this.aJv);
    }

    public String Gm() {
        return r(this.aJw);
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
        if (this.aJz == this.aJy && this.aJy == this.aJD && (tVar = (t) r.Gz().fk(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aJF.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aJF);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aJH;
        public int aJI;

        public a() {
        }
    }
}
