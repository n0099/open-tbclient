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
    private CustomMessageListener fIc = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.person.b.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable() && d.this.gml != null && d.this.gml.isEmpty() && !d.this.gml.isLoading()) {
                d.this.gml.refreshData();
            }
        }
    };
    private BdUniqueId fpn;
    private int gmh;
    private b gml;
    private TbPageContext mPageContext;
    private String mUserId;

    public d(TbPageContext tbPageContext, int i, String str, BdUniqueId bdUniqueId) {
        this.fpn = null;
        this.mPageContext = tbPageContext;
        this.gmh = i;
        this.mUserId = str;
        this.fpn = bdUniqueId;
        this.gml = new b(this.mPageContext, this.gmh, this.mUserId, this.fpn);
        if (this.gml != null && this.gml.isEmpty() && !this.gml.isLoading()) {
            this.gml.refreshData();
        }
        MessageManager.getInstance().registerListener(this.fIc);
    }

    public void as(String str, boolean z) {
        if (this.gml != null) {
            this.gml.as(str, z);
        }
    }

    public int getTabType() {
        return this.gmh;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gml == null) {
            return null;
        }
        return this.gml.aWO();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.gmh == 0 ? this.mPageContext.getString(a.i.ala_person_fans) : this.mPageContext.getString(a.i.ala_person_attentions);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Ci() {
        return null;
    }

    public void a(a.InterfaceC0581a interfaceC0581a) {
        if (this.gml != null) {
            this.gml.a(interfaceC0581a);
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
        MessageManager.getInstance().unRegisterListener(this.fIc);
        if (this.gml != null) {
            this.gml.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gml != null) {
            this.gml.onChangeSkinType(i);
        }
    }
}
