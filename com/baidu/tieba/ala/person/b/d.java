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
    private BdUniqueId gLW;
    private int hSs;
    private b hSw;
    private CustomMessageListener hkv = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.hSw != null && d.this.hSw.isEmpty() && !d.this.hSw.isLoading()) {
                d.this.hSw.refreshData();
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.gLW = null;
        this.mPageContext = tbPageContext;
        this.hSs = i;
        this.mUserId = str;
        this.gLW = bdUniqueId;
        this.hSw = new b(this.mPageContext, this.hSs, this.mUserId, this.gLW);
        if (this.hSw != null && this.hSw.isEmpty() && !this.hSw.isLoading()) {
            this.hSw.refreshData();
        }
        MessageManager.getInstance().registerListener(this.hkv);
    }

    public void aE(String str, boolean z) {
        if (this.hSw != null) {
            this.hSw.aE(str, z);
        }
    }

    public int getTabType() {
        return this.hSs;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hSw == null) {
            return null;
        }
        return this.hSw.clG();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.hSs == 0 ? this.mPageContext.getString(a.h.ala_person_fans) : this.mPageContext.getString(a.h.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Im() {
        return null;
    }

    public void a(a.InterfaceC0682a interfaceC0682a) {
        if (this.hSw != null) {
            this.hSw.a(interfaceC0682a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short In() {
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
        MessageManager.getInstance().unRegisterListener(this.hkv);
        if (this.hSw != null) {
            this.hSw.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hSw != null) {
            this.hSw.onChangeSkinType(i);
        }
    }
}
