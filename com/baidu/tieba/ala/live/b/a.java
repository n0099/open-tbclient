package com.baidu.tieba.ala.live.b;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import java.util.HashMap;
/* loaded from: classes7.dex */
public abstract class a extends BdBaseModel {
    private InterfaceC0615a gfV;
    private HashMap<String, String> gfW;
    private String gfX;
    protected TbPageContext mPageContext;
    private PayChannelType mPayChannelType;

    /* renamed from: com.baidu.tieba.ala.live.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0615a {
        void a(PayChannelType payChannelType, int i, String str, int i2, HttpResponsedMessage httpResponsedMessage);

        void a(PayChannelType payChannelType, int i, String str, HashMap<String, String> hashMap, String str2, boolean z);
    }

    public abstract void FE(String str);

    public abstract void a(PayConfig payConfig);

    public abstract void bLk();

    public a(TbPageContext tbPageContext, PayChannelType payChannelType, InterfaceC0615a interfaceC0615a) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mPayChannelType = payChannelType;
        this.gfV = interfaceC0615a;
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
        if (this.gfV != null) {
            this.gfX = str2;
            this.gfW = hashMap;
            this.gfV.a(this.mPayChannelType, i, str, hashMap, str3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, String str, int i2, HttpResponsedMessage httpResponsedMessage) {
        if (this.gfV != null) {
            this.gfV.a(this.mPayChannelType, i, str, i2, httpResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dY(String str, String str2) {
        if (this.gfW != null && str != null) {
            this.gfW.put(str, str2);
        }
    }

    public HashMap<String, String> bLi() {
        return this.gfW;
    }

    public String bLl() {
        return this.gfX;
    }
}
