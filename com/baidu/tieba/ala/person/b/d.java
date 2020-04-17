package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.person.b.a;
/* loaded from: classes3.dex */
public class d implements com.baidu.live.liveroom.d.d {
    private int fWX;
    private b fXb;
    private BdUniqueId fbv;
    private CustomMessageListener ftQ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.fXb != null && d.this.fXb.isEmpty() && !d.this.fXb.isLoading()) {
                d.this.fXb.refreshData();
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fbv = null;
        this.mPageContext = tbPageContext;
        this.fWX = i;
        this.mUserId = str;
        this.fbv = bdUniqueId;
        this.fXb = new b(this.mPageContext, this.fWX, this.mUserId, this.fbv);
        if (this.fXb != null && this.fXb.isEmpty() && !this.fXb.isLoading()) {
            this.fXb.refreshData();
        }
        MessageManager.getInstance().registerListener(this.ftQ);
    }

    public void af(String str, boolean z) {
        if (this.fXb != null) {
            this.fXb.af(str, z);
        }
    }

    public int getTabType() {
        return this.fWX;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fXb == null) {
            return null;
        }
        return this.fXb.aQI();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fWX == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String AT() {
        return null;
    }

    public void a(a.InterfaceC0510a interfaceC0510a) {
        if (this.fXb != null) {
            this.fXb.a(interfaceC0510a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short AU() {
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
        MessageManager.getInstance().unRegisterListener(this.ftQ);
        if (this.fXb != null) {
            this.fXb.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.fXb != null) {
            this.fXb.onChangeSkinType(i);
        }
    }
}
