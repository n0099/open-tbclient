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
    private static CustomMessageTask bzY = new CustomMessageTask(2016100, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.bAa = p.Ow().Oy();
            data.bAb = p.Ow().Oz();
            return new CustomResponsedMessage<>(2016100, data);
        }
    });
    private ArrayList<String> bzN;
    private ArrayList<String> bzO;
    private ArrayList<String> bzP;
    private e bzT;
    private com.baidu.tbadk.k.a bzU;
    private int bzV;
    private int bzQ = 0;
    private int bzR = 3;
    private int bzS = 0;
    private int bzW = 0;
    private e.a bzX = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void ig(int i) {
            d.this.bzT.a((e.a) null);
            d.this.bzT.stop();
            d.this.bzV = i;
            r rVar = (r) p.Ow().il(d.this.mSubType);
            if (rVar != null) {
                rVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0112a bzC = new a.InterfaceC0112a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0112a
        public void ig(int i) {
            d.this.bzW++;
            if (d.this.bzR == d.this.bzW) {
                d.this.bzU.a((a.InterfaceC0112a) null);
                d.this.bzU.stop();
                d.this.Ok();
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
                d.this.bzS++;
                d.this.hc(aVar.bAa);
                d.this.ii(aVar.bAb);
                d.this.Ok();
            }
        }
    };

    public d() {
        Oe();
    }

    public void onDestroy() {
        if (this.bzT != null) {
            this.bzT.a((e.a) null);
        }
        if (this.bzU != null) {
            this.bzU.a((a.InterfaceC0112a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Od() {
        if (this.bzQ < this.bzR) {
            this.bzQ++;
            Of();
            if (this.bzT == null) {
                this.bzT = new e();
                this.bzT.a(this.bzX);
                this.bzT.start();
            }
            if (this.bzU == null) {
                this.bzU = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.bzU.a(this.bzC);
                this.bzU.start();
            }
        }
    }

    private void Oe() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Of() {
        CustomMessage customMessage = new CustomMessage(2016100, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih(int i) {
        String valueOf = String.valueOf(i);
        if (this.bzN == null) {
            this.bzN = new ArrayList<>();
        }
        this.bzN.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(String str) {
        if (this.bzO == null) {
            this.bzO = new ArrayList<>();
        }
        if (str != null) {
            this.bzO.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii(int i) {
        String valueOf = String.valueOf(i);
        if (this.bzP == null) {
            this.bzP = new ArrayList<>();
        }
        this.bzP.add(valueOf);
    }

    public String Og() {
        return s(this.bzN);
    }

    public String Oh() {
        return String.valueOf(this.bzV);
    }

    public String Oi() {
        return s(this.bzO);
    }

    public String Oj() {
        return s(this.bzP);
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
    public void Ok() {
        r rVar;
        if (this.bzS == this.bzR && this.bzR == this.bzW && (rVar = (r) p.Ow().il(this.mSubType)) != null) {
            rVar.g(this);
        }
    }

    static {
        bzY.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(bzY);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bAa;
        public int bAb;

        public a() {
        }
    }
}
