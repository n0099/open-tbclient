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
    private CustomMessageListener eOJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.frT != null && d.this.frT.isEmpty() && !d.this.frT.isLoading()) {
                d.this.frT.refreshData();
            }
        }
    };
    private BdUniqueId ewH;
    private int frP;
    private b frT;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.ewH = null;
        this.mPageContext = tbPageContext;
        this.frP = i;
        this.mUserId = str;
        this.ewH = bdUniqueId;
        this.frT = new b(this.mPageContext, this.frP, this.mUserId, this.ewH);
        if (this.frT != null && this.frT.isEmpty() && !this.frT.isLoading()) {
            this.frT.refreshData();
        }
        MessageManager.getInstance().registerListener(this.eOJ);
    }

    public void Z(String str, boolean z) {
        if (this.frT != null) {
            this.frT.Z(str, z);
        }
    }

    public int getTabType() {
        return this.frP;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View we() {
        if (this.frT == null) {
            return null;
        }
        return this.frT.aIf();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.frP == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wf() {
        return null;
    }

    public void a(a.InterfaceC0474a interfaceC0474a) {
        if (this.frT != null) {
            this.frT.a(interfaceC0474a);
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
        MessageManager.getInstance().unRegisterListener(this.eOJ);
        if (this.frT != null) {
            this.frT.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.frT != null) {
            this.frT.onChangeSkinType(i);
        }
    }
}
