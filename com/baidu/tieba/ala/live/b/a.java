package com.baidu.tieba.ala.live.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import java.util.HashMap;
/* loaded from: classes4.dex */
public abstract class a extends BdBaseModel {
    private InterfaceC0669a gXZ;
    private HashMap<String, String> gYa;
    private String gYb;
    protected TbPageContext mPageContext;
    private PayChannelType mPayChannelType;

    /* renamed from: com.baidu.tieba.ala.live.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0669a {
        void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage);

        void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z);
    }

    public abstract void HO(String str);

    public abstract void a(PayConfig payConfig);

    public abstract void bYl();

    public a(TbPageContext tbPageContext, PayChannelType payChannelType, InterfaceC0669a interfaceC0669a) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mPayChannelType = payChannelType;
        this.gXZ = interfaceC0669a;
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
        if (this.gXZ != null) {
            this.gYb = str2;
            this.gYa = hashMap;
            this.gXZ.a(this.mPayChannelType, i, str, hashMap, str3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        if (this.gXZ != null) {
            this.gXZ.a(this.mPayChannelType, i, str, i2, httpResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ew(String str, String str2) {
        if (this.gYa != null && str != null) {
            this.gYa.put(str, str2);
        }
    }

    public HashMap<String, String> bYj() {
        return this.gYa;
    }

    public String bYm() {
        return this.gYb;
    }
}
