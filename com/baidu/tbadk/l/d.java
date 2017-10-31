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
    private static CustomMessageTask aJf = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.l.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aJh = r.Gi().Gk();
            data.aJi = r.Gi().Gm();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private ArrayList<String> aIU;
    private ArrayList<String> aIV;
    private ArrayList<String> aIW;
    private e aJa;
    private com.baidu.tbadk.l.a aJb;
    private int aJc;
    private int aIX = 0;
    private int aIY = 3;
    private int aIZ = 0;
    private int aJd = 0;
    private e.a aJe = new e.a() { // from class: com.baidu.tbadk.l.d.1
        @Override // com.baidu.tbadk.l.e.a
        public void fq(int i) {
            d.this.aJa.a((e.a) null);
            d.this.aJa.stop();
            d.this.aJc = i;
            t tVar = (t) r.Gi().fv(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0061a aIJ = new a.InterfaceC0061a() { // from class: com.baidu.tbadk.l.d.2
        @Override // com.baidu.tbadk.l.a.InterfaceC0061a
        public void fq(int i) {
            d.this.aJd++;
            if (d.this.aIY == d.this.aJd) {
                d.this.aJb.a((a.InterfaceC0061a) null);
                d.this.aJb.stop();
                d.this.FW();
            }
            d.this.fr(i);
        }
    };
    private CustomMessageListener customNormalListener = new CustomMessageListener(CmdConfigCustom.CMD_PERF_SAMPLE) { // from class: com.baidu.tbadk.l.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar;
            if (customResponsedMessage != null && (aVar = (a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                d.this.aIZ++;
                d.this.gE(aVar.aJh);
                d.this.fs(aVar.aJi);
                d.this.FW();
            }
        }
    };

    public d() {
        FQ();
    }

    public void onDestroy() {
        if (this.aJa != null) {
            this.aJa.a((e.a) null);
        }
        if (this.aJb != null) {
            this.aJb.a((a.InterfaceC0061a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void FP() {
        if (this.aIX < this.aIY) {
            this.aIX++;
            FR();
            if (this.aJa == null) {
                this.aJa = new e();
                this.aJa.a(this.aJe);
                this.aJa.start();
            }
            if (this.aJb == null) {
                this.aJb = new com.baidu.tbadk.l.a(TbadkCoreApplication.getInst().getContext());
                this.aJb.a(this.aIJ);
                this.aJb.start();
            }
        }
    }

    private void FQ() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void FR() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fr(int i) {
        String valueOf = String.valueOf(i);
        if (this.aIU == null) {
            this.aIU = new ArrayList<>();
        }
        this.aIU.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE(String str) {
        if (this.aIV == null) {
            this.aIV = new ArrayList<>();
        }
        if (str != null) {
            this.aIV.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(int i) {
        String valueOf = String.valueOf(i);
        if (this.aIW == null) {
            this.aIW = new ArrayList<>();
        }
        this.aIW.add(valueOf);
    }

    public String FS() {
        return r(this.aIU);
    }

    public String FT() {
        return String.valueOf(this.aJc);
    }

    public String FU() {
        return r(this.aIV);
    }

    public String FV() {
        return r(this.aIW);
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
    public void FW() {
        t tVar;
        if (this.aIZ == this.aIY && this.aIY == this.aJd && (tVar = (t) r.Gi().fv(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aJf.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aJf);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aJh;
        public int aJi;

        public a() {
        }
    }
}
