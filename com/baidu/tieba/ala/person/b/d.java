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
    private BdUniqueId dFZ;
    private CustomMessageListener dUL = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.evB != null && d.this.evB.isEmpty() && !d.this.evB.isLoading()) {
                d.this.evB.refreshData();
            }
        }
    };
    private b evB;
    private int evx;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.dFZ = null;
        this.mPageContext = tbPageContext;
        this.evx = i;
        this.mUserId = str;
        this.dFZ = bdUniqueId;
        this.evB = new b(this.mPageContext, this.evx, this.mUserId, this.dFZ);
        if (this.evB != null && this.evB.isEmpty() && !this.evB.isLoading()) {
            this.evB.refreshData();
        }
        MessageManager.getInstance().registerListener(this.dUL);
    }

    public void V(String str, boolean z) {
        if (this.evB != null) {
            this.evB.V(str, z);
        }
    }

    public int getTabType() {
        return this.evx;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View sr() {
        if (this.evB == null) {
            return null;
        }
        return this.evB.aof();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.evx == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String ss() {
        return null;
    }

    public void a(a.InterfaceC0378a interfaceC0378a) {
        if (this.evB != null) {
            this.evB.a(interfaceC0378a);
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public short st() {
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
        MessageManager.getInstance().unRegisterListener(this.dUL);
        if (this.evB != null) {
            this.evB.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
        if (this.evB != null) {
            this.evB.onChangeSkinType(i);
        }
    }
}
