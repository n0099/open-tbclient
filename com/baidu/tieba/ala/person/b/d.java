package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
/* loaded from: classes6.dex */
public class d implements com.baidu.live.liveroom.c.d {
    private BdUniqueId dFi;
    private CustomMessageListener dTU = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.euK != null && d.this.euK.isEmpty() && !d.this.euK.isLoading()) {
                d.this.euK.refreshData();
            }
        }
    };
    private int euG;
    private b euK;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.dFi = null;
        this.mPageContext = tbPageContext;
        this.euG = i;
        this.mUserId = str;
        this.dFi = bdUniqueId;
        this.euK = new b(this.mPageContext, this.euG, this.mUserId, this.dFi);
        if (this.euK != null && this.euK.isEmpty() && !this.euK.isLoading()) {
            this.euK.refreshData();
        }
        MessageManager.getInstance().registerListener(this.dTU);
    }

    public void V(String str, boolean z) {
        if (this.euK != null) {
            this.euK.V(str, z);
        }
    }

    public int getTabType() {
        return this.euG;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View ss() {
        if (this.euK == null) {
            return null;
        }
        return this.euK.aod();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.euG == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String st() {
        return null;
    }

    public void a(a.InterfaceC0373a interfaceC0373a) {
        if (this.euK != null) {
            this.euK.a(interfaceC0373a);
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public short su() {
        return (short) 0;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dTU);
        if (this.euK != null) {
            this.euK.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
        if (this.euK != null) {
            this.euK.onChangeSkinType(i);
        }
    }
}
