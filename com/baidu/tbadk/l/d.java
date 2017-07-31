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
    private static CustomMessageTask aJE = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.l.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aJG = r.Gz().GB();
            data.aJH = r.Gz().GD();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private com.baidu.tbadk.l.a aJA;
    private int aJB;
    private ArrayList<String> aJt;
    private ArrayList<String> aJu;
    private ArrayList<String> aJv;
    private e aJz;
    private int aJw = 0;
    private int aJx = 3;
    private int aJy = 0;
    private int aJC = 0;
    private e.a aJD = new e.a() { // from class: com.baidu.tbadk.l.d.1
        @Override // com.baidu.tbadk.l.e.a
        public void ff(int i) {
            d.this.aJz.a((e.a) null);
            d.this.aJz.stop();
            d.this.aJB = i;
            t tVar = (t) r.Gz().fk(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0060a aJi = new a.InterfaceC0060a() { // from class: com.baidu.tbadk.l.d.2
        @Override // com.baidu.tbadk.l.a.InterfaceC0060a
        public void ff(int i) {
            d.this.aJC++;
            if (d.this.aJx == d.this.aJC) {
                d.this.aJA.a((a.InterfaceC0060a) null);
                d.this.aJA.stop();
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
                d.this.aJy++;
                d.this.gC(aVar.aJG);
                d.this.fh(aVar.aJH);
                d.this.Gn();
            }
        }
    };

    public d() {
        Gh();
    }

    public void onDestroy() {
        if (this.aJz != null) {
            this.aJz.a((e.a) null);
        }
        if (this.aJA != null) {
            this.aJA.a((a.InterfaceC0060a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Gg() {
        if (this.aJw < this.aJx) {
            this.aJw++;
            Gi();
            if (this.aJz == null) {
                this.aJz = new e();
                this.aJz.a(this.aJD);
                this.aJz.start();
            }
            if (this.aJA == null) {
                this.aJA = new com.baidu.tbadk.l.a(TbadkCoreApplication.getInst().getContext());
                this.aJA.a(this.aJi);
                this.aJA.start();
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
        if (this.aJt == null) {
            this.aJt = new ArrayList<>();
        }
        this.aJt.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(String str) {
        if (this.aJu == null) {
            this.aJu = new ArrayList<>();
        }
        if (str != null) {
            this.aJu.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh(int i) {
        String valueOf = String.valueOf(i);
        if (this.aJv == null) {
            this.aJv = new ArrayList<>();
        }
        this.aJv.add(valueOf);
    }

    public String Gj() {
        return r(this.aJt);
    }

    public String Gk() {
        return String.valueOf(this.aJB);
    }

    public String Gl() {
        return r(this.aJu);
    }

    public String Gm() {
        return r(this.aJv);
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
        if (this.aJy == this.aJx && this.aJx == this.aJC && (tVar = (t) r.Gz().fk(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aJE.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aJE);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aJG;
        public int aJH;

        public a() {
        }
    }
}
