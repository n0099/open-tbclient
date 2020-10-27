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
    private CustomMessageListener gNU = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.hvG != null && d.this.hvG.isEmpty() && !d.this.hvG.isLoading()) {
                d.this.hvG.refreshData();
            }
        }
    };
    private BdUniqueId gqL;
    private int hvC;
    private b hvG;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gqL = null;
        this.mPageContext = tbPageContext;
        this.hvC = i;
        this.mUserId = str;
        this.gqL = bdUniqueId;
        this.hvG = new b(this.mPageContext, this.hvC, this.mUserId, this.gqL);
        if (this.hvG != null && this.hvG.isEmpty() && !this.hvG.isLoading()) {
            this.hvG.refreshData();
        }
        MessageManager.getInstance().registerListener(this.gNU);
    }

    public void aC(String str, boolean z) {
        if (this.hvG != null) {
            this.hvG.aC(str, z);
        }
    }

    public int getTabType() {
        return this.hvC;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hvG == null) {
            return null;
        }
        return this.hvG.bqA();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.hvC == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KR() {
        return null;
    }

    public void a(a.InterfaceC0680a interfaceC0680a) {
        if (this.hvG != null) {
            this.hvG.a(interfaceC0680a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KS() {
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
        MessageManager.getInstance().unRegisterListener(this.gNU);
        if (this.hvG != null) {
            this.hvG.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hvG != null) {
            this.hvG.onChangeSkinType(i);
        }
    }
}
