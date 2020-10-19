package com.baidu.tieba.ala.charm.a;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
/* loaded from: classes4.dex */
public class a implements d {
    private String aEr;
    private boolean bhU;
    private String gfp;
    private com.baidu.tieba.ala.charm.model.a gfu;
    private b ggs;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean ggt = true;
    a.InterfaceC0610a gfy = new a.InterfaceC0610a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0610a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.ggs.hideLoadingView();
            a.this.ggs.completePullRefresh();
            a.this.ggs.aa(aLaCharmDataList.data);
            a.this.ggt = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0610a
        public void aK(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.ggs.completePullRefresh();
            a.this.ggs.hideLoadingView();
            a.this.ggs.bMm();
            a.this.ggt = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener ggu = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gfu != null) {
                a.this.gfu.bD(1, 10);
            }
        }
    };
    private CustomMessageListener bgl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.ggs != null) {
                        a.this.ggs.ax(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.SY().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.ggs != null) {
                        a.this.ggs.ax(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.SY().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.bgl);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.ggs == null) {
            this.ggs = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.bhU, this.aEr);
            this.ggs.Gk(this.gfp);
            this.ggs.a(this.ggu);
        }
        this.gfu = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.gfy);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.ggs.showLoadingView();
            this.gfu.bD(1, 10);
        }
    }

    public a Gg(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Gh(String str) {
        this.mLiveId = str;
        return this;
    }

    public a Gi(String str) {
        this.mUid = str;
        return this;
    }

    public a Gj(String str) {
        this.gfp = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.ggs == null) {
            createView();
        }
        if (this.ggs == null) {
            return null;
        }
        return this.ggs.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Kx() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ky() {
        return (short) 3;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bgl);
        if (this.gfu != null) {
            this.gfu.onDestroy();
        }
        if (this.ggs != null) {
            this.ggs.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.ggs != null) {
            this.ggs.onSkinTypeChanged(i);
        }
    }
}
