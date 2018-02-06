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
    private static CustomMessageTask bAi = new CustomMessageTask(2016100, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.bAk = p.Ow().Oy();
            data.bAl = p.Ow().Oz();
            return new CustomResponsedMessage<>(2016100, data);
        }
    });
    private e bAd;
    private com.baidu.tbadk.k.a bAe;
    private int bAf;
    private ArrayList<String> bzX;
    private ArrayList<String> bzY;
    private ArrayList<String> bzZ;
    private int bAa = 0;
    private int bAb = 3;
    private int bAc = 0;
    private int bAg = 0;
    private e.a bAh = new e.a() { // from class: com.baidu.tbadk.k.d.1
        @Override // com.baidu.tbadk.k.e.a
        public void ig(int i) {
            d.this.bAd.a((e.a) null);
            d.this.bAd.stop();
            d.this.bAf = i;
            r rVar = (r) p.Ow().il(d.this.mSubType);
            if (rVar != null) {
                rVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0111a bzM = new a.InterfaceC0111a() { // from class: com.baidu.tbadk.k.d.2
        @Override // com.baidu.tbadk.k.a.InterfaceC0111a
        public void ig(int i) {
            d.this.bAg++;
            if (d.this.bAb == d.this.bAg) {
                d.this.bAe.a((a.InterfaceC0111a) null);
                d.this.bAe.stop();
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
                d.this.bAc++;
                d.this.hc(aVar.bAk);
                d.this.ii(aVar.bAl);
                d.this.Ok();
            }
        }
    };

    public d() {
        Oe();
    }

    public void onDestroy() {
        if (this.bAd != null) {
            this.bAd.a((e.a) null);
        }
        if (this.bAe != null) {
            this.bAe.a((a.InterfaceC0111a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void Od() {
        if (this.bAa < this.bAb) {
            this.bAa++;
            Of();
            if (this.bAd == null) {
                this.bAd = new e();
                this.bAd.a(this.bAh);
                this.bAd.start();
            }
            if (this.bAe == null) {
                this.bAe = new com.baidu.tbadk.k.a(TbadkCoreApplication.getInst().getContext());
                this.bAe.a(this.bzM);
                this.bAe.start();
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
        if (this.bzX == null) {
            this.bzX = new ArrayList<>();
        }
        this.bzX.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(String str) {
        if (this.bzY == null) {
            this.bzY = new ArrayList<>();
        }
        if (str != null) {
            this.bzY.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii(int i) {
        String valueOf = String.valueOf(i);
        if (this.bzZ == null) {
            this.bzZ = new ArrayList<>();
        }
        this.bzZ.add(valueOf);
    }

    public String Og() {
        return s(this.bzX);
    }

    public String Oh() {
        return String.valueOf(this.bAf);
    }

    public String Oi() {
        return s(this.bzY);
    }

    public String Oj() {
        return s(this.bzZ);
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
        if (this.bAc == this.bAb && this.bAb == this.bAg && (rVar = (r) p.Ow().il(this.mSubType)) != null) {
            rVar.g(this);
        }
    }

    static {
        bAi.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(bAi);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bAk;
        public int bAl;

        public a() {
        }
    }
}
