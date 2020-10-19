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
    private CustomMessageListener gCg = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.hjK != null && d.this.hjK.isEmpty() && !d.this.hjK.isLoading()) {
                d.this.hjK.refreshData();
            }
        }
    };
    private BdUniqueId ggI;
    private int hjG;
    private b hjK;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.ggI = null;
        this.mPageContext = tbPageContext;
        this.hjG = i;
        this.mUserId = str;
        this.ggI = bdUniqueId;
        this.hjK = new b(this.mPageContext, this.hjG, this.mUserId, this.ggI);
        if (this.hjK != null && this.hjK.isEmpty() && !this.hjK.isLoading()) {
            this.hjK.refreshData();
        }
        MessageManager.getInstance().registerListener(this.gCg);
    }

    public void aA(String str, boolean z) {
        if (this.hjK != null) {
            this.hjK.aA(str, z);
        }
    }

    public int getTabType() {
        return this.hjG;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hjK == null) {
            return null;
        }
        return this.hjK.boH();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.hjG == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Kx() {
        return null;
    }

    public void a(a.InterfaceC0664a interfaceC0664a) {
        if (this.hjK != null) {
            this.hjK.a(interfaceC0664a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ky() {
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
        MessageManager.getInstance().unRegisterListener(this.gCg);
        if (this.hjK != null) {
            this.hjK.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hjK != null) {
            this.hjK.onChangeSkinType(i);
        }
    }
}
