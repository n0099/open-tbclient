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
    private static CustomMessageTask aKu = new CustomMessageTask(2016100, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aKw = p.Ha().Hc();
            data.aKx = p.Ha().Hd();
            return new CustomResponsedMessage<>(2016100, data);
        }
    });
    private ArrayList<String> aKj;
    private ArrayList<String> aKk;
    private ArrayList<String> aKl;
    private e aKp;
    private com.baidu.tbadk.k.a aKq;
    private int aKr;
    private int aKm = 0;
    private int aKn = 3;
    private int aKo = 0;
    private int aKs = 0;
    private e.a aKt = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void fg(int i) {
            d.this.aKp.a((e.a) null);
            d.this.aKp.stop();
            d.this.aKr = i;
            r rVar = (r) p.Ha().fm(d.this.mSubType);
            if (rVar != null) {
                rVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0101a aJZ = new a.InterfaceC0101a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0101a
        public void fg(int i) {
            d.this.aKs++;
            if (d.this.aKn == d.this.aKs) {
                d.this.aKq.a((a.InterfaceC0101a) null);
                d.this.aKq.stop();
                d.this.GM();
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
                d.this.aKo++;
                d.this.gR(aVar.aKw);
                d.this.fi(aVar.aKx);
                d.this.GM();
            }
        }
    };

    public d() {
        GG();
    }

    public void onDestroy() {
        if (this.aKp != null) {
            this.aKp.a((e.a) null);
        }
        if (this.aKq != null) {
            this.aKq.a((a.InterfaceC0101a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void GF() {
        if (this.aKm < this.aKn) {
            this.aKm++;
            GH();
            if (this.aKp == null) {
                this.aKp = new e();
                this.aKp.a(this.aKt);
                this.aKp.start();
            }
            if (this.aKq == null) {
                this.aKq = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.aKq.a(this.aJZ);
                this.aKq.start();
            }
        }
    }

    private void GG() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void GH() {
        CustomMessage customMessage = new CustomMessage(2016100, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh(int i) {
        String valueOf = String.valueOf(i);
        if (this.aKj == null) {
            this.aKj = new ArrayList<>();
        }
        this.aKj.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(String str) {
        if (this.aKk == null) {
            this.aKk = new ArrayList<>();
        }
        if (str != null) {
            this.aKk.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(int i) {
        String valueOf = String.valueOf(i);
        if (this.aKl == null) {
            this.aKl = new ArrayList<>();
        }
        this.aKl.add(valueOf);
    }

    public String GI() {
        return r(this.aKj);
    }

    public String GJ() {
        return String.valueOf(this.aKr);
    }

    public String GK() {
        return r(this.aKk);
    }

    public String GL() {
        return r(this.aKl);
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
    public void GM() {
        r rVar;
        if (this.aKo == this.aKn && this.aKn == this.aKs && (rVar = (r) p.Ha().fm(this.mSubType)) != null) {
            rVar.g(this);
        }
    }

    static {
        aKu.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aKu);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aKw;
        public int aKx;

        public a() {
        }
    }
}
