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
    private BdUniqueId gEP;
    private int hKL;
    private b hKP;
    private CustomMessageListener hdn = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.hKP != null && d.this.hKP.isEmpty() && !d.this.hKP.isLoading()) {
                d.this.hKP.refreshData();
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gEP = null;
        this.mPageContext = tbPageContext;
        this.hKL = i;
        this.mUserId = str;
        this.gEP = bdUniqueId;
        this.hKP = new b(this.mPageContext, this.hKL, this.mUserId, this.gEP);
        if (this.hKP != null && this.hKP.isEmpty() && !this.hKP.isLoading()) {
            this.hKP.refreshData();
        }
        MessageManager.getInstance().registerListener(this.hdn);
    }

    public void aD(String str, boolean z) {
        if (this.hKP != null) {
            this.hKP.aD(str, z);
        }
    }

    public int getTabType() {
        return this.hKL;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hKP == null) {
            return null;
        }
        return this.hKP.bvQ();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.hKL == 0 ? this.mPageContext.getString(a.h.ala_person_fans) : this.mPageContext.getString(a.h.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    public void a(a.InterfaceC0707a interfaceC0707a) {
        if (this.hKP != null) {
            this.hKP.a(interfaceC0707a);
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
        MessageManager.getInstance().unRegisterListener(this.hdn);
        if (this.hKP != null) {
            this.hKP.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hKP != null) {
            this.hKP.onChangeSkinType(i);
        }
    }
}
