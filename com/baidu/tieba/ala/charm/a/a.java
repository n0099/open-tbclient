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
/* loaded from: classes3.dex */
public class a implements d {
    private boolean aVc;
    private String aVd;
    private b fAj;
    private String fzj;
    private com.baidu.tieba.ala.charm.model.a fzo;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean fAk = true;
    a.InterfaceC0540a fzs = new a.InterfaceC0540a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0540a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.fAj.hideLoadingView();
            a.this.fAj.completePullRefresh();
            a.this.fAj.T(aLaCharmDataList.data);
            a.this.fAk = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0540a
        public void az(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.fAj.completePullRefresh();
            a.this.fAj.hideLoadingView();
            a.this.fAj.bwb();
            a.this.fAk = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener fAl = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fzo != null) {
                a.this.fzo.bs(1, 10);
            }
        }
    };
    private CustomMessageListener aTs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.fAj != null) {
                        a.this.fAj.ar(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Ky().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.fAj != null) {
                        a.this.fAj.ar(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Ky().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aTs);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.fAj == null) {
            this.fAj = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.aVc, this.aVd);
            this.fAj.BU(this.fzj);
            this.fAj.a(this.fAl);
        }
        this.fzo = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.fzs);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.fAj.showLoadingView();
            this.fzo.bs(1, 10);
        }
    }

    public a BQ(String str) {
        this.mGroupId = str;
        return this;
    }

    public a BR(String str) {
        this.mLiveId = str;
        return this;
    }

    public a BS(String str) {
        this.mUid = str;
        return this;
    }

    public a BT(String str) {
        this.fzj = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fAj == null) {
            createView();
        }
        if (this.fAj == null) {
            return null;
        }
        return this.fAj.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String CI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short CJ() {
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
        MessageManager.getInstance().unRegisterListener(this.aTs);
        if (this.fzo != null) {
            this.fzo.onDestroy();
        }
        if (this.fAj != null) {
            this.fAj.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.fAj != null) {
            this.fAj.onSkinTypeChanged(i);
        }
    }
}
