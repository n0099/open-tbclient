package com.baidu.tieba.ala.live.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import java.util.HashMap;
/* loaded from: classes4.dex */
public abstract class a extends BdBaseModel {
    private InterfaceC0611a gjk;
    private HashMap<String, String> gjl;
    private String gjm;
    protected TbPageContext mPageContext;
    private PayChannelType mPayChannelType;

    /* renamed from: com.baidu.tieba.ala.live.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0611a {
        void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage);

        void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z);
    }

    public abstract void Gc(String str);

    public abstract void a(PayConfig payConfig);

    public abstract void bMv();

    public a(TbPageContext tbPageContext, PayChannelType payChannelType, InterfaceC0611a interfaceC0611a) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mPayChannelType = payChannelType;
        this.gjk = interfaceC0611a;
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
        if (this.gjk != null) {
            this.gjm = str2;
            this.gjl = hashMap;
            this.gjk.a(this.mPayChannelType, i, str, hashMap, str3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        if (this.gjk != null) {
            this.gjk.a(this.mPayChannelType, i, str, i2, httpResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eb(String str, String str2) {
        if (this.gjl != null && str != null) {
            this.gjl.put(str, str2);
        }
    }

    public HashMap<String, String> bMt() {
        return this.gjl;
    }

    public String bMw() {
        return this.gjm;
    }
}
