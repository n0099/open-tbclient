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
    private static CustomMessageTask bzV = new CustomMessageTask(2016100, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.bzX = p.Ov().Ox();
            data.bzY = p.Ov().Oy();
            return new CustomResponsedMessage<>(2016100, data);
        }
    });
    private ArrayList<String> bzK;
    private ArrayList<String> bzL;
    private ArrayList<String> bzM;
    private e bzQ;
    private com.baidu.tbadk.k.a bzR;
    private int bzS;
    private int bzN = 0;
    private int bzO = 3;
    private int bzP = 0;
    private int bzT = 0;
    private e.a bzU = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void ig(int i) {
            d.this.bzQ.a((e.a) null);
            d.this.bzQ.stop();
            d.this.bzS = i;
            r rVar = (r) p.Ov().il(d.this.mSubType);
            if (rVar != null) {
                rVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0112a bzz = new a.InterfaceC0112a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0112a
        public void ig(int i) {
            d.this.bzT++;
            if (d.this.bzO == d.this.bzT) {
                d.this.bzR.a((a.InterfaceC0112a) null);
                d.this.bzR.stop();
                d.this.Oj();
            }
            d.this.ih(i);
        }
    };
    private CustomMessageListener customNormalListener = new CustomMessageListener(2016100) { // from class: com.baidu.tbadk.k.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar;
            if (customResponsedMessage != null && (aVar = (a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                d.this.bzP++;
                d.this.hc(aVar.bzX);
                d.this.ii(aVar.bzY);
                d.this.Oj();
            }
        }
    };

    public d() {
        Od();
    }

    public void onDestroy() {
        if (this.bzQ != null) {
            this.bzQ.a((e.a) null);
        }
        if (this.bzR != null) {
            this.bzR.a((a.InterfaceC0112a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Oc() {
        if (this.bzN < this.bzO) {
            this.bzN++;
            Oe();
            if (this.bzQ == null) {
                this.bzQ = new e();
                this.bzQ.a(this.bzU);
                this.bzQ.start();
            }
            if (this.bzR == null) {
                this.bzR = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.bzR.a(this.bzz);
                this.bzR.start();
            }
        }
    }

    private void Od() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Oe() {
        CustomMessage customMessage = new CustomMessage(2016100, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih(int i) {
        String valueOf = String.valueOf(i);
        if (this.bzK == null) {
            this.bzK = new ArrayList<>();
        }
        this.bzK.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(String str) {
        if (this.bzL == null) {
            this.bzL = new ArrayList<>();
        }
        if (str != null) {
            this.bzL.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii(int i) {
        String valueOf = String.valueOf(i);
        if (this.bzM == null) {
            this.bzM = new ArrayList<>();
        }
        this.bzM.add(valueOf);
    }

    public String Of() {
        return s(this.bzK);
    }

    public String Og() {
        return String.valueOf(this.bzS);
    }

    public String Oh() {
        return s(this.bzL);
    }

    public String Oi() {
        return s(this.bzM);
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
    public void Oj() {
        r rVar;
        if (this.bzP == this.bzO && this.bzO == this.bzT && (rVar = (r) p.Ov().il(this.mSubType)) != null) {
            rVar.g(this);
        }
    }

    static {
        bzV.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(bzV);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bzX;
        public int bzY;

        public a() {
        }
    }
}
