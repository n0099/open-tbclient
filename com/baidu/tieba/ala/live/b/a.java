package com.baidu.tieba.ala.live.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import java.util.HashMap;
/* loaded from: classes4.dex */
public abstract class a extends BdBaseModel {
    private InterfaceC0656a gPd;
    private HashMap<String, String> gPe;
    private String gPf;
    protected TbPageContext mPageContext;
    private PayChannelType mPayChannelType;

    /* renamed from: com.baidu.tieba.ala.live.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0656a {
        void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage);

        void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z);
    }

    public abstract void Hz(String str);

    public abstract void a(PayConfig payConfig);

    public abstract void bVi();

    public a(TbPageContext tbPageContext, PayChannelType payChannelType, InterfaceC0656a interfaceC0656a) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mPayChannelType = payChannelType;
        this.gPd = interfaceC0656a;
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
        if (this.gPd != null) {
            this.gPf = str2;
            this.gPe = hashMap;
            this.gPd.a(this.mPayChannelType, i, str, hashMap, str3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        if (this.gPd != null) {
            this.gPd.a(this.mPayChannelType, i, str, i2, httpResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ep(String str, String str2) {
        if (this.gPe != null && str != null) {
            this.gPe.put(str, str2);
        }
    }

    public HashMap<String, String> bVg() {
        return this.gPe;
    }

    public String bVj() {
        return this.gPf;
    }
}
