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
    private CustomMessageListener eOK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.frU != null && d.this.frU.isEmpty() && !d.this.frU.isLoading()) {
                d.this.frU.refreshData();
            }
        }
    };
    private BdUniqueId ewI;
    private int frQ;
    private b frU;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.ewI = null;
        this.mPageContext = tbPageContext;
        this.frQ = i;
        this.mUserId = str;
        this.ewI = bdUniqueId;
        this.frU = new b(this.mPageContext, this.frQ, this.mUserId, this.ewI);
        if (this.frU != null && this.frU.isEmpty() && !this.frU.isLoading()) {
            this.frU.refreshData();
        }
        MessageManager.getInstance().registerListener(this.eOK);
    }

    public void Z(String str, boolean z) {
        if (this.frU != null) {
            this.frU.Z(str, z);
        }
    }

    public int getTabType() {
        return this.frQ;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View we() {
        if (this.frU == null) {
            return null;
        }
        return this.frU.aIh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.frQ == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wf() {
        return null;
    }

    public void a(a.InterfaceC0474a interfaceC0474a) {
        if (this.frU != null) {
            this.frU.a(interfaceC0474a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wg() {
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
        MessageManager.getInstance().unRegisterListener(this.eOK);
        if (this.frU != null) {
            this.frU.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.frU != null) {
            this.frU.onChangeSkinType(i);
        }
    }
}
