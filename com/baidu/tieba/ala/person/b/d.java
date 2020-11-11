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
    private CustomMessageListener gUt = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.hBD != null && d.this.hBD.isEmpty() && !d.this.hBD.isLoading()) {
                d.this.hBD.refreshData();
            }
        }
    };
    private BdUniqueId gwz;
    private b hBD;
    private int hBz;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gwz = null;
        this.mPageContext = tbPageContext;
        this.hBz = i;
        this.mUserId = str;
        this.gwz = bdUniqueId;
        this.hBD = new b(this.mPageContext, this.hBz, this.mUserId, this.gwz);
        if (this.hBD != null && this.hBD.isEmpty() && !this.hBD.isLoading()) {
            this.hBD.refreshData();
        }
        MessageManager.getInstance().registerListener(this.gUt);
    }

    public void aC(String str, boolean z) {
        if (this.hBD != null) {
            this.hBD.aC(str, z);
        }
    }

    public int getTabType() {
        return this.hBz;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hBD == null) {
            return null;
        }
        return this.hBD.bta();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.hBz == 0 ? this.mPageContext.getString(a.h.ala_person_fans) : this.mPageContext.getString(a.h.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    public void a(a.InterfaceC0694a interfaceC0694a) {
        if (this.hBD != null) {
            this.hBD.a(interfaceC0694a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
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
        MessageManager.getInstance().unRegisterListener(this.gUt);
        if (this.hBD != null) {
            this.hBD.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hBD != null) {
            this.hBD.onChangeSkinType(i);
        }
    }
}
