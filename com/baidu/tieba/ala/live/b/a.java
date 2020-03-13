package com.baidu.tieba.ala.live.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class a extends BdBaseModel {
    private InterfaceC0447a eKB;
    private HashMap<String, String> eKC;
    private String eKD;
    protected TbPageContext mPageContext;
    private PayChannelType mPayChannelType;

    /* renamed from: com.baidu.tieba.ala.live.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0447a {
        void a(PayChannelType payChannelType, int i, String str, int i2);

        void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z);
    }

    public abstract void a(PayConfig payConfig);

    public abstract void bgs();

    public abstract void yG(String str);

    public a(TbPageContext tbPageContext, PayChannelType payChannelType, InterfaceC0447a interfaceC0447a) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mPayChannelType = payChannelType;
        this.eKB = interfaceC0447a;
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
        if (this.eKB != null) {
            this.eKD = str2;
            this.eKC = hashMap;
            this.eKB.a(this.mPayChannelType, i, str, hashMap, str3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i, String str, int i2) {
        if (this.eKB != null) {
            this.eKB.a(this.mPayChannelType, i, str, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cT(String str, String str2) {
        if (this.eKC != null && str != null) {
            this.eKC.put(str, str2);
        }
    }

    public HashMap<String, String> bgq() {
        return this.eKC;
    }

    public String bgt() {
        return this.eKD;
    }
}
