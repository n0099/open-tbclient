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
/* loaded from: classes4.dex */
public class d implements com.baidu.live.liveroom.d.d {
    private BdUniqueId gER;
    private int hKN;
    private b hKR;
    private CustomMessageListener hdp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.hKR != null && d.this.hKR.isEmpty() && !d.this.hKR.isLoading()) {
                d.this.hKR.refreshData();
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gER = null;
        this.mPageContext = tbPageContext;
        this.hKN = i;
        this.mUserId = str;
        this.gER = bdUniqueId;
        this.hKR = new b(this.mPageContext, this.hKN, this.mUserId, this.gER);
        if (this.hKR != null && this.hKR.isEmpty() && !this.hKR.isLoading()) {
            this.hKR.refreshData();
        }
        MessageManager.getInstance().registerListener(this.hdp);
    }

    public void aD(String str, boolean z) {
        if (this.hKR != null) {
            this.hKR.aD(str, z);
        }
    }

    public int getTabType() {
        return this.hKN;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hKR == null) {
            return null;
        }
        return this.hKR.bvQ();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.hKN == 0 ? this.mPageContext.getString(a.h.ala_person_fans) : this.mPageContext.getString(a.h.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    public void a(a.InterfaceC0707a interfaceC0707a) {
        if (this.hKR != null) {
            this.hKR.a(interfaceC0707a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
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
        MessageManager.getInstance().unRegisterListener(this.hdp);
        if (this.hKR != null) {
            this.hKR.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hKR != null) {
            this.hKR.onChangeSkinType(i);
        }
    }
}
