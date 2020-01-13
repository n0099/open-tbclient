package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
/* loaded from: classes2.dex */
public class d implements com.baidu.live.liveroom.c.d {
    private CustomMessageListener eKK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.fpp != null && d.this.fpp.isEmpty() && !d.this.fpp.isLoading()) {
                d.this.fpp.refreshData();
            }
        }
    };
    private BdUniqueId esx;
    private int fpl;
    private b fpp;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.esx = null;
        this.mPageContext = tbPageContext;
        this.fpl = i;
        this.mUserId = str;
        this.esx = bdUniqueId;
        this.fpp = new b(this.mPageContext, this.fpl, this.mUserId, this.esx);
        if (this.fpp != null && this.fpp.isEmpty() && !this.fpp.isLoading()) {
            this.fpp.refreshData();
        }
        MessageManager.getInstance().registerListener(this.eKK);
    }

    public void Z(String str, boolean z) {
        if (this.fpp != null) {
            this.fpp.Z(str, z);
        }
    }

    public int getTabType() {
        return this.fpl;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uA() {
        if (this.fpp == null) {
            return null;
        }
        return this.fpp.aFQ();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.fpl == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uB() {
        return null;
    }

    public void a(a.InterfaceC0466a interfaceC0466a) {
        if (this.fpp != null) {
            this.fpp.a(interfaceC0466a);
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public short uC() {
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
        MessageManager.getInstance().unRegisterListener(this.eKK);
        if (this.fpp != null) {
            this.fpp.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
        if (this.fpp != null) {
            this.fpp.onChangeSkinType(i);
        }
    }
}
