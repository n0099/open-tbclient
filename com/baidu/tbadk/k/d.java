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
    private static CustomMessageTask aJS = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aJU = r.GB().GD();
            data.aJV = r.GB().GF();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private ArrayList<String> aJH;
    private ArrayList<String> aJI;
    private ArrayList<String> aJJ;
    private e aJN;
    private com.baidu.tbadk.k.a aJO;
    private int aJP;
    private int aJK = 0;
    private int aJL = 3;
    private int aJM = 0;
    private int aJQ = 0;
    private e.a aJR = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void fo(int i) {
            d.this.aJN.a((e.a) null);
            d.this.aJN.stop();
            d.this.aJP = i;
            t tVar = (t) r.GB().ft(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0075a aJw = new a.InterfaceC0075a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0075a
        public void fo(int i) {
            d.this.aJQ++;
            if (d.this.aJL == d.this.aJQ) {
                d.this.aJO.a((a.InterfaceC0075a) null);
                d.this.aJO.stop();
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
                d.this.aJM++;
                d.this.gH(aVar.aJU);
                d.this.fq(aVar.aJV);
                d.this.Gp();
            }
        }
    };

    public d() {
        Gj();
    }

    public void onDestroy() {
        if (this.aJN != null) {
            this.aJN.a((e.a) null);
        }
        if (this.aJO != null) {
            this.aJO.a((a.InterfaceC0075a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Gi() {
        if (this.aJK < this.aJL) {
            this.aJK++;
            Gk();
            if (this.aJN == null) {
                this.aJN = new e();
                this.aJN.a(this.aJR);
                this.aJN.start();
            }
            if (this.aJO == null) {
                this.aJO = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.aJO.a(this.aJw);
                this.aJO.start();
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
        if (this.aJH == null) {
            this.aJH = new ArrayList<>();
        }
        this.aJH.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gH(String str) {
        if (this.aJI == null) {
            this.aJI = new ArrayList<>();
        }
        if (str != null) {
            this.aJI.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(int i) {
        String valueOf = String.valueOf(i);
        if (this.aJJ == null) {
            this.aJJ = new ArrayList<>();
        }
        this.aJJ.add(valueOf);
    }

    public String Gl() {
        return r(this.aJH);
    }

    public String Gm() {
        return String.valueOf(this.aJP);
    }

    public String Gn() {
        return r(this.aJI);
    }

    public String Go() {
        return r(this.aJJ);
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
        if (this.aJM == this.aJL && this.aJL == this.aJQ && (tVar = (t) r.GB().ft(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aJS.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aJS);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aJU;
        public int aJV;

        public a() {
        }
    }
}
