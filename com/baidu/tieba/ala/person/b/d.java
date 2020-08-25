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
/* loaded from: classes7.dex */
public class d implements com.baidu.live.liveroom.d.d {
    private BdUniqueId fRa;
    private int gQW;
    private b gRa;
    private CustomMessageListener gkC = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.gRa != null && d.this.gRa.isEmpty() && !d.this.gRa.isLoading()) {
                d.this.gRa.refreshData();
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fRa = null;
        this.mPageContext = tbPageContext;
        this.gQW = i;
        this.mUserId = str;
        this.fRa = bdUniqueId;
        this.gRa = new b(this.mPageContext, this.gQW, this.mUserId, this.fRa);
        if (this.gRa != null && this.gRa.isEmpty() && !this.gRa.isLoading()) {
            this.gRa.refreshData();
        }
        MessageManager.getInstance().registerListener(this.gkC);
    }

    public void aw(String str, boolean z) {
        if (this.gRa != null) {
            this.gRa.aw(str, z);
        }
    }

    public int getTabType() {
        return this.gQW;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gRa == null) {
            return null;
        }
        return this.gRa.blc();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gQW == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String IM() {
        return null;
    }

    public void a(a.InterfaceC0649a interfaceC0649a) {
        if (this.gRa != null) {
            this.gRa.a(interfaceC0649a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short IN() {
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
        MessageManager.getInstance().unRegisterListener(this.gkC);
        if (this.gRa != null) {
            this.gRa.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gRa != null) {
            this.gRa.onChangeSkinType(i);
        }
    }
}
