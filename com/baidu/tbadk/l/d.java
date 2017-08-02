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
    private static CustomMessageTask aIp = new CustomMessageTask(CmdConfigCustom.CMD_PERF_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.l.d.3
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aIr = r.Gr().Gt();
            data.aIs = r.Gr().Gv();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
        }
    });
    private ArrayList<String> aIe;
    private ArrayList<String> aIf;
    private ArrayList<String> aIg;
    private e aIk;
    private com.baidu.tbadk.l.a aIl;
    private int aIm;
    private int aIh = 0;
    private int aIi = 3;
    private int aIj = 0;
    private int aIn = 0;
    private e.a aIo = new e.a() { // from class: com.baidu.tbadk.l.d.1
        @Override // com.baidu.tbadk.l.e.a
        public void fd(int i) {
            d.this.aIk.a((e.a) null);
            d.this.aIk.stop();
            d.this.aIm = i;
            t tVar = (t) r.Gr().fi(d.this.mSubType);
            if (tVar != null) {
                tVar.h(d.this);
            }
        }
    };
    private a.InterfaceC0060a aHT = new a.InterfaceC0060a() { // from class: com.baidu.tbadk.l.d.2
        @Override // com.baidu.tbadk.l.a.InterfaceC0060a
        public void fd(int i) {
            d.this.aIn++;
            if (d.this.aIi == d.this.aIn) {
                d.this.aIl.a((a.InterfaceC0060a) null);
                d.this.aIl.stop();
                d.this.Gf();
            }
            d.this.fe(i);
        }
    };
    private CustomMessageListener customNormalListener = new CustomMessageListener(CmdConfigCustom.CMD_PERF_SAMPLE) { // from class: com.baidu.tbadk.l.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar;
            if (customResponsedMessage != null && (aVar = (a) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == d.this.mId) {
                d.this.aIj++;
                d.this.gx(aVar.aIr);
                d.this.ff(aVar.aIs);
                d.this.Gf();
            }
        }
    };

    public d() {
        FZ();
    }

    public void onDestroy() {
        if (this.aIk != null) {
            this.aIk.a((e.a) null);
        }
        if (this.aIl != null) {
            this.aIl.a((a.InterfaceC0060a) null);
        }
        MessageManager.getInstance().unRegisterListener(this.mId);
    }

    public void FY() {
        if (this.aIh < this.aIi) {
            this.aIh++;
            Ga();
            if (this.aIk == null) {
                this.aIk = new e();
                this.aIk.a(this.aIo);
                this.aIk.start();
            }
            if (this.aIl == null) {
                this.aIl = new com.baidu.tbadk.l.a(TbadkCoreApplication.getInst().getContext());
                this.aIl.a(this.aHT);
                this.aIl.start();
            }
        }
    }

    private void FZ() {
        this.customNormalListener.setTag(this.mId);
        MessageManager.getInstance().unRegisterListener(this.mId);
        MessageManager.getInstance().registerListener(this.customNormalListener);
    }

    private void Ga() {
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_PERF_SAMPLE, new a());
        customMessage.setTag(this.mId);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fe(int i) {
        String valueOf = String.valueOf(i);
        if (this.aIe == null) {
            this.aIe = new ArrayList<>();
        }
        this.aIe.add(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(String str) {
        if (this.aIf == null) {
            this.aIf = new ArrayList<>();
        }
        if (str != null) {
            this.aIf.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ff(int i) {
        String valueOf = String.valueOf(i);
        if (this.aIg == null) {
            this.aIg = new ArrayList<>();
        }
        this.aIg.add(valueOf);
    }

    public String Gb() {
        return r(this.aIe);
    }

    public String Gc() {
        return String.valueOf(this.aIm);
    }

    public String Gd() {
        return r(this.aIf);
    }

    public String Ge() {
        return r(this.aIg);
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
    public void Gf() {
        t tVar;
        if (this.aIj == this.aIi && this.aIi == this.aIn && (tVar = (t) r.Gr().fi(this.mSubType)) != null) {
            tVar.g(this);
        }
    }

    static {
        aIp.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aIp);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aIr;
        public int aIs;

        public a() {
        }
    }
}
