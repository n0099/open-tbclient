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
    private BdUniqueId fRe;
    private int gRa;
    private b gRe;
    private CustomMessageListener gkG = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.gRe != null && d.this.gRe.isEmpty() && !d.this.gRe.isLoading()) {
                d.this.gRe.refreshData();
            }
        }
    };
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fRe = null;
        this.mPageContext = tbPageContext;
        this.gRa = i;
        this.mUserId = str;
        this.fRe = bdUniqueId;
        this.gRe = new b(this.mPageContext, this.gRa, this.mUserId, this.fRe);
        if (this.gRe != null && this.gRe.isEmpty() && !this.gRe.isLoading()) {
            this.gRe.refreshData();
        }
        MessageManager.getInstance().registerListener(this.gkG);
    }

    public void aw(String str, boolean z) {
        if (this.gRe != null) {
            this.gRe.aw(str, z);
        }
    }

    public int getTabType() {
        return this.gRa;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gRe == null) {
            return null;
        }
        return this.gRe.blc();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gRa == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String IM() {
        return null;
    }

    public void a(a.InterfaceC0649a interfaceC0649a) {
        if (this.gRe != null) {
            this.gRe.a(interfaceC0649a);
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
        MessageManager.getInstance().unRegisterListener(this.gkG);
        if (this.gRe != null) {
            this.gRe.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gRe != null) {
            this.gRe.onChangeSkinType(i);
        }
    }
}
