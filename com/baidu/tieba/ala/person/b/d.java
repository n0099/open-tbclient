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
    private CustomMessageListener ePv = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.fsG != null && d.this.fsG.isEmpty() && !d.this.fsG.isLoading()) {
                d.this.fsG.refreshData();
            }
        }
    };
    private BdUniqueId exr;
    private int fsC;
    private b fsG;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.exr = null;
        this.mPageContext = tbPageContext;
        this.fsC = i;
        this.mUserId = str;
        this.exr = bdUniqueId;
        this.fsG = new b(this.mPageContext, this.fsC, this.mUserId, this.exr);
        if (this.fsG != null && this.fsG.isEmpty() && !this.fsG.isLoading()) {
            this.fsG.refreshData();
        }
        MessageManager.getInstance().registerListener(this.ePv);
    }

    public void Z(String str, boolean z) {
        if (this.fsG != null) {
            this.fsG.Z(str, z);
        }
    }

    public int getTabType() {
        return this.fsC;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View wj() {
        if (this.fsG == null) {
            return null;
        }
        return this.fsG.aIm();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.fsC == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wk() {
        return null;
    }

    public void a(a.InterfaceC0474a interfaceC0474a) {
        if (this.fsG != null) {
            this.fsG.a(interfaceC0474a);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wl() {
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
        MessageManager.getInstance().unRegisterListener(this.ePv);
        if (this.fsG != null) {
            this.fsG.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.fsG != null) {
            this.fsG.onChangeSkinType(i);
        }
    }
}
