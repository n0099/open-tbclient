package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.person.b.a;
/* loaded from: classes3.dex */
public class d implements com.baidu.live.liveroom.d.d {
    private CustomMessageListener fHR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.gma != null && d.this.gma.isEmpty() && !d.this.gma.isLoading()) {
                d.this.gma.refreshData();
            }
        }
    };
    private BdUniqueId fpc;
    private int glW;
    private b gma;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fpc = null;
        this.mPageContext = tbPageContext;
        this.glW = i;
        this.mUserId = str;
        this.fpc = bdUniqueId;
        this.gma = new b(this.mPageContext, this.glW, this.mUserId, this.fpc);
        if (this.gma != null && this.gma.isEmpty() && !this.gma.isLoading()) {
            this.gma.refreshData();
        }
        MessageManager.getInstance().registerListener(this.fHR);
    }

    public void as(String str, boolean z) {
        if (this.gma != null) {
            this.gma.as(str, z);
        }
    }

    public int getTabType() {
        return this.glW;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gma == null) {
            return null;
        }
        return this.gma.aWN();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.glW == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Ci() {
        return null;
    }

    public void a(a.InterfaceC0581a interfaceC0581a) {
        if (this.gma != null) {
            this.gma.a(interfaceC0581a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Cj() {
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
        MessageManager.getInstance().unRegisterListener(this.fHR);
        if (this.gma != null) {
            this.gma.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gma != null) {
            this.gma.onChangeSkinType(i);
        }
    }
}
