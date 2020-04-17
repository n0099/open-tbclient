package com.baidu.tieba.ala.live.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class a extends BdBaseModel {
    private InterfaceC0482a fpp;
    private HashMap<String, String> fpq;
    private String fpr;
    protected TbPageContext mPageContext;
    private PayChannelType mPayChannelType;

    /* renamed from: com.baidu.tieba.ala.live.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0482a {
        void a(PayChannelType payChannelType, int i, String str, int i2);

        void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z);
    }

    public abstract void Ap(String str);

    public abstract void a(PayConfig payConfig);

    public abstract void bpO();

    public a(TbPageContext tbPageContext, PayChannelType payChannelType, InterfaceC0482a interfaceC0482a) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mPayChannelType = payChannelType;
        this.fpp = interfaceC0482a;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, String str, String str2, HashMap<String, String> hashMap, String str3, boolean z) {
        if (this.fpp != null) {
            this.fpr = str2;
            this.fpq = hashMap;
            this.fpp.a(this.mPayChannelType, i, str, hashMap, str3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i, String str, int i2) {
        if (this.fpp != null) {
            this.fpp.a(this.mPayChannelType, i, str, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dg(String str, String str2) {
        if (this.fpq != null && str != null) {
            this.fpq.put(str, str2);
        }
    }

    public HashMap<String, String> bpM() {
        return this.fpq;
    }

    public String bpP() {
        return this.fpr;
    }
}
