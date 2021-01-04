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
    private BdUniqueId gQC;
    private int hWZ;
    private b hXd;
    private CustomMessageListener hpc = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.hXd != null && d.this.hXd.isEmpty() && !d.this.hXd.isLoading()) {
                d.this.hXd.refreshData();
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gQC = null;
        this.mPageContext = tbPageContext;
        this.hWZ = i;
        this.mUserId = str;
        this.gQC = bdUniqueId;
        this.hXd = new b(this.mPageContext, this.hWZ, this.mUserId, this.gQC);
        if (this.hXd != null && this.hXd.isEmpty() && !this.hXd.isLoading()) {
            this.hXd.refreshData();
        }
        MessageManager.getInstance().registerListener(this.hpc);
    }

    public void aE(String str, boolean z) {
        if (this.hXd != null) {
            this.hXd.aE(str, z);
        }
    }

    public int getTabType() {
        return this.hWZ;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hXd == null) {
            return null;
        }
        return this.hXd.cpx();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.hWZ == 0 ? this.mPageContext.getString(a.h.ala_person_fans) : this.mPageContext.getString(a.h.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Mh() {
        return null;
    }

    public void a(a.InterfaceC0699a interfaceC0699a) {
        if (this.hXd != null) {
            this.hXd.a(interfaceC0699a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Mi() {
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
        MessageManager.getInstance().unRegisterListener(this.hpc);
        if (this.hXd != null) {
            this.hXd.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hXd != null) {
            this.hXd.onChangeSkinType(i);
        }
    }
}
