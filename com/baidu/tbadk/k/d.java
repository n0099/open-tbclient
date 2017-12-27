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
    private static CustomMessageTask bxJ = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.bxL = r.Oa().Oc();
            data.bxM = r.Oa().Oe();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private ArrayList<String> bxA;
    private e bxE;
    private com.baidu.tbadk.k.a bxF;
    private int bxG;
    private ArrayList<String> bxy;
    private ArrayList<String> bxz;
    private int bxB = 0;
    private int bxC = 3;
    private int bxD = 0;
    private int bxH = 0;
    private e.a bxI = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void in(int i) {
            d.this.bxE.a((e.a) null);
            d.this.bxE.stop();
            d.this.bxG = i;
            t tVar = (t) r.Oa().is(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0088a bxn = new a.InterfaceC0088a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0088a
        public void in(int i) {
            d.this.bxH++;
            if (d.this.bxC == d.this.bxH) {
                d.this.bxF.a((a.InterfaceC0088a) null);
                d.this.bxF.stop();
                d.this.NO();
            }
            d.this.io(i);
        }
    };
    private CustomMessageListener customNormalListener = new CustomMessageListener(CmdConfigCustom.CMD_PERF_SAMPLE) { // from class: com.baidu.tbadk.k.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar;
            if (customResponsedMessage != null && (aVar = (a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                d.this.bxD++;
                d.this.gK(aVar.bxL);
                d.this.ip(aVar.bxM);
                d.this.NO();
            }
        }
    };

    public d() {
        NI();
    }

    public void onDestroy() {
        if (this.bxE != null) {
            this.bxE.a((e.a) null);
        }
        if (this.bxF != null) {
            this.bxF.a((a.InterfaceC0088a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void NH() {
        if (this.bxB < this.bxC) {
            this.bxB++;
            NJ();
            if (this.bxE == null) {
                this.bxE = new e();
                this.bxE.a(this.bxI);
                this.bxE.start();
            }
            if (this.bxF == null) {
                this.bxF = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.bxF.a(this.bxn);
                this.bxF.start();
            }
        }
    }

    private void NI() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void NJ() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void io(int i) {
        String valueOf = String.valueOf(i);
        if (this.bxy == null) {
            this.bxy = new ArrayList<>();
        }
        this.bxy.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gK(String str) {
        if (this.bxz == null) {
            this.bxz = new ArrayList<>();
        }
        if (str != null) {
            this.bxz.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ip(int i) {
        String valueOf = String.valueOf(i);
        if (this.bxA == null) {
            this.bxA = new ArrayList<>();
        }
        this.bxA.add(valueOf);
    }

    public String NK() {
        return s(this.bxy);
    }

    public String NL() {
        return String.valueOf(this.bxG);
    }

    public String NM() {
        return s(this.bxz);
    }

    public String NN() {
        return s(this.bxA);
    }

    private String s(ArrayList<String> arrayList) {
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
    public void NO() {
        t tVar;
        if (this.bxD == this.bxC && this.bxC == this.bxH && (tVar = (t) r.Oa().is(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        bxJ.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(bxJ);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bxL;
        public int bxM;

        public a() {
        }
    }
}
