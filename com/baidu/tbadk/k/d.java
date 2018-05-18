package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.k.a;
import com.baidu.tbadk.k.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends j {
    private static CustomMessageTask aKv = new CustomMessageTask(2016100, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aKx = p.GY().Ha();
            data.aKy = p.GY().Hb();
            return new CustomResponsedMessage<>(2016100, data);
        }
    });
    private ArrayList<String> aKk;
    private ArrayList<String> aKl;
    private ArrayList<String> aKm;
    private e aKq;
    private com.baidu.tbadk.k.a aKr;
    private int aKs;
    private int aKn = 0;
    private int aKo = 3;
    private int aKp = 0;
    private int aKt = 0;
    private e.a aKu = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void fg(int i) {
            d.this.aKq.a((e.a) null);
            d.this.aKq.stop();
            d.this.aKs = i;
            r rVar = (r) p.GY().fm(d.this.mSubType);
            if (rVar != null) {
                rVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0101a aKa = new a.InterfaceC0101a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0101a
        public void fg(int i) {
            d.this.aKt++;
            if (d.this.aKo == d.this.aKt) {
                d.this.aKr.a((a.InterfaceC0101a) null);
                d.this.aKr.stop();
                d.this.GK();
            }
            d.this.fh(i);
        }
    };
    private CustomMessageListener customNormalListener = new CustomMessageListener(2016100) { // from class: com.baidu.tbadk.k.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar;
            if (customResponsedMessage != null && (aVar = (a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                d.this.aKp++;
                d.this.gR(aVar.aKx);
                d.this.fi(aVar.aKy);
                d.this.GK();
            }
        }
    };

    public d() {
        GE();
    }

    public void onDestroy() {
        if (this.aKq != null) {
            this.aKq.a((e.a) null);
        }
        if (this.aKr != null) {
            this.aKr.a((a.InterfaceC0101a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void GD() {
        if (this.aKn < this.aKo) {
            this.aKn++;
            GF();
            if (this.aKq == null) {
                this.aKq = new e();
                this.aKq.a(this.aKu);
                this.aKq.start();
            }
            if (this.aKr == null) {
                this.aKr = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.aKr.a(this.aKa);
                this.aKr.start();
            }
        }
    }

    private void GE() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void GF() {
        CustomMessage customMessage = new CustomMessage(2016100, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh(int i) {
        String valueOf = String.valueOf(i);
        if (this.aKk == null) {
            this.aKk = new ArrayList<>();
        }
        this.aKk.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(String str) {
        if (this.aKl == null) {
            this.aKl = new ArrayList<>();
        }
        if (str != null) {
            this.aKl.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(int i) {
        String valueOf = String.valueOf(i);
        if (this.aKm == null) {
            this.aKm = new ArrayList<>();
        }
        this.aKm.add(valueOf);
    }

    public String GG() {
        return r(this.aKk);
    }

    public String GH() {
        return String.valueOf(this.aKs);
    }

    public String GI() {
        return r(this.aKl);
    }

    public String GJ() {
        return r(this.aKm);
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
    public void GK() {
        r rVar;
        if (this.aKp == this.aKo && this.aKo == this.aKt && (rVar = (r) p.GY().fm(this.mSubType)) != null) {
            rVar.g(this);
        }
    }

    static {
        aKv.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aKv);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aKx;
        public int aKy;

        public a() {
        }
    }
}
