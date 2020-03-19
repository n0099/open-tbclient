package com.baidu.tieba.ala.live.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class a extends BdBaseModel {
    private InterfaceC0447a eKX;
    private HashMap<String, String> eKY;
    private String eKZ;
    protected TbPageContext mPageContext;
    private PayChannelType mPayChannelType;

    /* renamed from: com.baidu.tieba.ala.live.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0447a {
        void a(PayChannelType payChannelType, int i, String str, int i2);

        void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z);
    }

    public abstract void a(PayConfig payConfig);

    public abstract void bgx();

    public abstract void yH(String str);

    public a(TbPageContext tbPageContext, PayChannelType payChannelType, InterfaceC0447a interfaceC0447a) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mPayChannelType = payChannelType;
        this.eKX = interfaceC0447a;
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
        if (this.eKX != null) {
            this.eKZ = str2;
            this.eKY = hashMap;
            this.eKX.a(this.mPayChannelType, i, str, hashMap, str3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i, String str, int i2) {
        if (this.eKX != null) {
            this.eKX.a(this.mPayChannelType, i, str, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cS(String str, String str2) {
        if (this.eKY != null && str != null) {
            this.eKY.put(str, str2);
        }
    }

    public HashMap<String, String> bgv() {
        return this.eKY;
    }

    public String bgy() {
        return this.eKZ;
    }
}
