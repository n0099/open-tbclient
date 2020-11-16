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
    private CustomMessageListener gUa = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.hBk != null && d.this.hBk.isEmpty() && !d.this.hBk.isLoading()) {
                d.this.hBk.refreshData();
            }
        }
    };
    private BdUniqueId gwg;
    private int hBg;
    private b hBk;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gwg = null;
        this.mPageContext = tbPageContext;
        this.hBg = i;
        this.mUserId = str;
        this.gwg = bdUniqueId;
        this.hBk = new b(this.mPageContext, this.hBg, this.mUserId, this.gwg);
        if (this.hBk != null && this.hBk.isEmpty() && !this.hBk.isLoading()) {
            this.hBk.refreshData();
        }
        MessageManager.getInstance().registerListener(this.gUa);
    }

    public void aC(String str, boolean z) {
        if (this.hBk != null) {
            this.hBk.aC(str, z);
        }
    }

    public int getTabType() {
        return this.hBg;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hBk == null) {
            return null;
        }
        return this.hBk.bsq();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.hBg == 0 ? this.mPageContext.getString(a.h.ala_person_fans) : this.mPageContext.getString(a.h.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KI() {
        return null;
    }

    public void a(a.InterfaceC0694a interfaceC0694a) {
        if (this.hBk != null) {
            this.hBk.a(interfaceC0694a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KJ() {
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
        MessageManager.getInstance().unRegisterListener(this.gUa);
        if (this.hBk != null) {
            this.hBk.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hBk != null) {
            this.hBk.onChangeSkinType(i);
        }
    }
}
