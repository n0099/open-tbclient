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
/* loaded from: classes3.dex */
public class d implements com.baidu.live.liveroom.d.d {
    private BdUniqueId fAz;
    private CustomMessageListener fTl = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.gyZ != null && d.this.gyZ.isEmpty() && !d.this.gyZ.isLoading()) {
                d.this.gyZ.refreshData();
            }
        }
    };
    private int gyV;
    private b gyZ;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fAz = null;
        this.mPageContext = tbPageContext;
        this.gyV = i;
        this.mUserId = str;
        this.fAz = bdUniqueId;
        this.gyZ = new b(this.mPageContext, this.gyV, this.mUserId, this.fAz);
        if (this.gyZ != null && this.gyZ.isEmpty() && !this.gyZ.isLoading()) {
            this.gyZ.refreshData();
        }
        MessageManager.getInstance().registerListener(this.fTl);
    }

    public void au(String str, boolean z) {
        if (this.gyZ != null) {
            this.gyZ.au(str, z);
        }
    }

    public int getTabType() {
        return this.gyV;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gyZ == null) {
            return null;
        }
        return this.gyZ.aYH();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gyV == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String CI() {
        return null;
    }

    public void a(a.InterfaceC0590a interfaceC0590a) {
        if (this.gyZ != null) {
            this.gyZ.a(interfaceC0590a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short CJ() {
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
        MessageManager.getInstance().unRegisterListener(this.fTl);
        if (this.gyZ != null) {
            this.gyZ.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gyZ != null) {
            this.gyZ.onChangeSkinType(i);
        }
    }
}
