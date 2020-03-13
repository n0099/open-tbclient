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
    private CustomMessageListener eOX = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.fsh != null && d.this.fsh.isEmpty() && !d.this.fsh.isLoading()) {
                d.this.fsh.refreshData();
            }
        }
    };
    private BdUniqueId ewV;
    private int fsd;
    private b fsh;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.ewV = null;
        this.mPageContext = tbPageContext;
        this.fsd = i;
        this.mUserId = str;
        this.ewV = bdUniqueId;
        this.fsh = new b(this.mPageContext, this.fsd, this.mUserId, this.ewV);
        if (this.fsh != null && this.fsh.isEmpty() && !this.fsh.isLoading()) {
            this.fsh.refreshData();
        }
        MessageManager.getInstance().registerListener(this.eOX);
    }

    public void Z(String str, boolean z) {
        if (this.fsh != null) {
            this.fsh.Z(str, z);
        }
    }

    public int getTabType() {
        return this.fsd;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View we() {
        if (this.fsh == null) {
            return null;
        }
        return this.fsh.aIi();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fsd == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wf() {
        return null;
    }

    public void a(a.InterfaceC0474a interfaceC0474a) {
        if (this.fsh != null) {
            this.fsh.a(interfaceC0474a);
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
        MessageManager.getInstance().unRegisterListener(this.eOX);
        if (this.fsh != null) {
            this.fsh.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.fsh != null) {
            this.fsh.onChangeSkinType(i);
        }
    }
}
