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
/* loaded from: classes10.dex */
public class d implements com.baidu.live.liveroom.d.d {
    private BdUniqueId gQz;
    private int hYK;
    private b hYO;
    private CustomMessageListener hqK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.hYO != null && d.this.hYO.isEmpty() && !d.this.hYO.isLoading()) {
                d.this.hYO.refreshData();
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gQz = null;
        this.mPageContext = tbPageContext;
        this.hYK = i;
        this.mUserId = str;
        this.gQz = bdUniqueId;
        this.hYO = new b(this.mPageContext, this.hYK, this.mUserId, this.gQz);
        if (this.hYO != null && this.hYO.isEmpty() && !this.hYO.isLoading()) {
            this.hYO.refreshData();
        }
        MessageManager.getInstance().registerListener(this.hqK);
    }

    public void aD(String str, boolean z) {
        if (this.hYO != null) {
            this.hYO.aD(str, z);
        }
    }

    public int getTabType() {
        return this.hYK;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hYO == null) {
            return null;
        }
        return this.hYO.cmR();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.hYK == 0 ? this.mPageContext.getString(a.h.ala_person_fans) : this.mPageContext.getString(a.h.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JN() {
        return null;
    }

    public void a(a.InterfaceC0689a interfaceC0689a) {
        if (this.hYO != null) {
            this.hYO.a(interfaceC0689a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JO() {
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
        MessageManager.getInstance().unRegisterListener(this.hqK);
        if (this.hYO != null) {
            this.hYO.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hYO != null) {
            this.hYO.onChangeSkinType(i);
        }
    }
}
