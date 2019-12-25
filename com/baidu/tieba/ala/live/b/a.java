package com.baidu.tieba.ala.live.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class a extends BdBaseModel {
    private InterfaceC0433a eFj;
    private HashMap<String, String> eFk;
    private String eFl;
    protected TbPageContext mPageContext;
    private PayChannelType mPayChannelType;

    /* renamed from: com.baidu.tieba.ala.live.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0433a {
        void a(PayChannelType payChannelType, int i, String str, int i2);

        void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z);
    }

    public abstract void a(PayConfig payConfig);

    public abstract void bdK();

    public abstract void ye(String str);

    public a(TbPageContext tbPageContext, PayChannelType payChannelType, InterfaceC0433a interfaceC0433a) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mPayChannelType = payChannelType;
        this.eFj = interfaceC0433a;
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
        if (this.eFj != null) {
            this.eFl = str2;
            this.eFk = hashMap;
            this.eFj.a(this.mPayChannelType, i, str, hashMap, str3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i, String str, int i2) {
        if (this.eFj != null) {
            this.eFj.a(this.mPayChannelType, i, str, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cI(String str, String str2) {
        if (this.eFk != null && str != null) {
            this.eFk.put(str, str2);
        }
    }

    public HashMap<String, String> bdI() {
        return this.eFk;
    }

    public String bdL() {
        return this.eFl;
    }
}
