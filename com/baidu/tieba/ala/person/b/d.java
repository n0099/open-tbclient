package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
/* loaded from: classes2.dex */
public class d implements com.baidu.live.liveroom.c.d {
    private CustomMessageListener eJz = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.fmg != null && d.this.fmg.isEmpty() && !d.this.fmg.isLoading()) {
                d.this.fmg.refreshData();
            }
        }
    };
    private BdUniqueId erl;
    private int fmc;
    private b fmg;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.erl = null;
        this.mPageContext = tbPageContext;
        this.fmc = i;
        this.mUserId = str;
        this.erl = bdUniqueId;
        this.fmg = new b(this.mPageContext, this.fmc, this.mUserId, this.erl);
        if (this.fmg != null && this.fmg.isEmpty() && !this.fmg.isLoading()) {
            this.fmg.refreshData();
        }
        MessageManager.getInstance().registerListener(this.eJz);
    }

    public void Z(String str, boolean z) {
        if (this.fmg != null) {
            this.fmg.Z(str, z);
        }
    }

    public int getTabType() {
        return this.fmc;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uj() {
        if (this.fmg == null) {
            return null;
        }
        return this.fmg.aFx();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.fmc == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uk() {
        return null;
    }

    public void a(a.InterfaceC0462a interfaceC0462a) {
        if (this.fmg != null) {
            this.fmg.a(interfaceC0462a);
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public short ul() {
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
        MessageManager.getInstance().unRegisterListener(this.eJz);
        if (this.fmg != null) {
            this.fmg.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
        if (this.fmg != null) {
            this.fmg.onChangeSkinType(i);
        }
    }
}
