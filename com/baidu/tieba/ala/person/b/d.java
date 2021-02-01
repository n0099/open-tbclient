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
    private BdUniqueId gOC;
    private int hWN;
    private b hWR;
    private CustomMessageListener hoN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.hWR != null && d.this.hWR.isEmpty() && !d.this.hWR.isLoading()) {
                d.this.hWR.refreshData();
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gOC = null;
        this.mPageContext = tbPageContext;
        this.hWN = i;
        this.mUserId = str;
        this.gOC = bdUniqueId;
        this.hWR = new b(this.mPageContext, this.hWN, this.mUserId, this.gOC);
        if (this.hWR != null && this.hWR.isEmpty() && !this.hWR.isLoading()) {
            this.hWR.refreshData();
        }
        MessageManager.getInstance().registerListener(this.hoN);
    }

    public void aD(String str, boolean z) {
        if (this.hWR != null) {
            this.hWR.aD(str, z);
        }
    }

    public int getTabType() {
        return this.hWN;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hWR == null) {
            return null;
        }
        return this.hWR.cmE();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.hWN == 0 ? this.mPageContext.getString(a.h.ala_person_fans) : this.mPageContext.getString(a.h.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    public void a(a.InterfaceC0682a interfaceC0682a) {
        if (this.hWR != null) {
            this.hWR.a(interfaceC0682a);
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
        MessageManager.getInstance().unRegisterListener(this.hoN);
        if (this.hWR != null) {
            this.hWR.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hWR != null) {
            this.hWR.onChangeSkinType(i);
        }
    }
}
