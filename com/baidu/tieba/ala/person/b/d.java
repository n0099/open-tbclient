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
    private BdUniqueId fFJ;
    private CustomMessageListener fYE = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.gEA != null && d.this.gEA.isEmpty() && !d.this.gEA.isLoading()) {
                d.this.gEA.refreshData();
            }
        }
    };
    private b gEA;
    private int gEw;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fFJ = null;
        this.mPageContext = tbPageContext;
        this.gEw = i;
        this.mUserId = str;
        this.fFJ = bdUniqueId;
        this.gEA = new b(this.mPageContext, this.gEw, this.mUserId, this.fFJ);
        if (this.gEA != null && this.gEA.isEmpty() && !this.gEA.isLoading()) {
            this.gEA.refreshData();
        }
        MessageManager.getInstance().registerListener(this.fYE);
    }

    public void as(String str, boolean z) {
        if (this.gEA != null) {
            this.gEA.as(str, z);
        }
    }

    public int getTabType() {
        return this.gEw;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gEA == null) {
            return null;
        }
        return this.gEA.bcE();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gEw == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Dj() {
        return null;
    }

    public void a(a.InterfaceC0599a interfaceC0599a) {
        if (this.gEA != null) {
            this.gEA.a(interfaceC0599a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Dk() {
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
        MessageManager.getInstance().unRegisterListener(this.fYE);
        if (this.gEA != null) {
            this.gEA.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gEA != null) {
            this.gEA.onChangeSkinType(i);
        }
    }
}
