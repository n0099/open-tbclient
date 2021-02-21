package com.baidu.tieba.ala.live.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import java.util.HashMap;
/* loaded from: classes11.dex */
public abstract class a extends BdBaseModel {
    private InterfaceC0645a hjL;
    private HashMap<String, String> hjM;
    private String hjN;
    protected TbPageContext mPageContext;
    private PayChannelType mPayChannelType;

    /* renamed from: com.baidu.tieba.ala.live.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0645a {
        void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage);

        void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z);
    }

    public abstract void Hi(String str);

    public abstract void a(PayConfig payConfig);

    public abstract void bYg();

    public a(TbPageContext tbPageContext, PayChannelType payChannelType, InterfaceC0645a interfaceC0645a) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mPayChannelType = payChannelType;
        this.hjL = interfaceC0645a;
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
        if (this.hjL != null) {
            this.hjN = str2;
            this.hjM = hashMap;
            this.hjL.a(this.mPayChannelType, i, str, hashMap, str3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        if (this.hjL != null) {
            this.hjL.a(this.mPayChannelType, i, str, i2, httpResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void et(String str, String str2) {
        if (this.hjM != null && str != null) {
            this.hjM.put(str, str2);
        }
    }

    public HashMap<String, String> bYe() {
        return this.hjM;
    }

    public String bYh() {
        return this.hjN;
    }
}
