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
    private BdUniqueId fUp;
    private int gUI;
    private b gUM;
    private CustomMessageListener gnN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.gUM != null && d.this.gUM.isEmpty() && !d.this.gUM.isLoading()) {
                d.this.gUM.refreshData();
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fUp = null;
        this.mPageContext = tbPageContext;
        this.gUI = i;
        this.mUserId = str;
        this.fUp = bdUniqueId;
        this.gUM = new b(this.mPageContext, this.gUI, this.mUserId, this.fUp);
        if (this.gUM != null && this.gUM.isEmpty() && !this.gUM.isLoading()) {
            this.gUM.refreshData();
        }
        MessageManager.getInstance().registerListener(this.gnN);
    }

    public void aw(String str, boolean z) {
        if (this.gUM != null) {
            this.gUM.aw(str, z);
        }
    }

    public int getTabType() {
        return this.gUI;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gUM == null) {
            return null;
        }
        return this.gUM.blX();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gUI == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Jq() {
        return null;
    }

    public void a(a.InterfaceC0646a interfaceC0646a) {
        if (this.gUM != null) {
            this.gUM.a(interfaceC0646a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Jr() {
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
        MessageManager.getInstance().unRegisterListener(this.gnN);
        if (this.gUM != null) {
            this.gUM.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gUM != null) {
            this.gUM.onChangeSkinType(i);
        }
    }
}
