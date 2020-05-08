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
    private int fXc;
    private b fXg;
    private BdUniqueId fbA;
    private CustomMessageListener ftV = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.fXg != null && d.this.fXg.isEmpty() && !d.this.fXg.isLoading()) {
                d.this.fXg.refreshData();
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fbA = null;
        this.mPageContext = tbPageContext;
        this.fXc = i;
        this.mUserId = str;
        this.fbA = bdUniqueId;
        this.fXg = new b(this.mPageContext, this.fXc, this.mUserId, this.fbA);
        if (this.fXg != null && this.fXg.isEmpty() && !this.fXg.isLoading()) {
            this.fXg.refreshData();
        }
        MessageManager.getInstance().registerListener(this.ftV);
    }

    public void af(String str, boolean z) {
        if (this.fXg != null) {
            this.fXg.af(str, z);
        }
    }

    public int getTabType() {
        return this.fXc;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fXg == null) {
            return null;
        }
        return this.fXg.aQF();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fXc == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String AS() {
        return null;
    }

    public void a(a.InterfaceC0531a interfaceC0531a) {
        if (this.fXg != null) {
            this.fXg.a(interfaceC0531a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short AT() {
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
        MessageManager.getInstance().unRegisterListener(this.ftV);
        if (this.fXg != null) {
            this.fXg.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.fXg != null) {
            this.fXg.onChangeSkinType(i);
        }
    }
}
