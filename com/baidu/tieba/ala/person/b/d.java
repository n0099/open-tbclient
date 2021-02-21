package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
/* loaded from: classes11.dex */
public class d implements com.baidu.live.liveroom.d.d {
    private BdUniqueId gOQ;
    private int hXb;
    private b hXf;
    private CustomMessageListener hpb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.hXf != null && d.this.hXf.isEmpty() && !d.this.hXf.isLoading()) {
                d.this.hXf.refreshData();
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gOQ = null;
        this.mPageContext = tbPageContext;
        this.hXb = i;
        this.mUserId = str;
        this.gOQ = bdUniqueId;
        this.hXf = new b(this.mPageContext, this.hXb, this.mUserId, this.gOQ);
        if (this.hXf != null && this.hXf.isEmpty() && !this.hXf.isLoading()) {
            this.hXf.refreshData();
        }
        MessageManager.getInstance().registerListener(this.hpb);
    }

    public void aD(String str, boolean z) {
        if (this.hXf != null) {
            this.hXf.aD(str, z);
        }
    }

    public int getTabType() {
        return this.hXb;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hXf == null) {
            return null;
        }
        return this.hXf.cmL();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.hXb == 0 ? this.mPageContext.getString(a.h.ala_person_fans) : this.mPageContext.getString(a.h.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    public void a(a.InterfaceC0683a interfaceC0683a) {
        if (this.hXf != null) {
            this.hXf.a(interfaceC0683a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
        return (short) 0;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hpb);
        if (this.hXf != null) {
            this.hXf.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hXf != null) {
            this.hXf.onChangeSkinType(i);
        }
    }
}
