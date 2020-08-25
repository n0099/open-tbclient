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
/* loaded from: classes7.dex */
public class a implements d {
    private String aAE;
    private boolean bbH;
    private String fPH;
    private com.baidu.tieba.ala.charm.model.a fPM;
    private b fQK;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean fQL = true;
    a.InterfaceC0597a fPQ = new a.InterfaceC0597a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0597a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.fQK.hideLoadingView();
            a.this.fQK.completePullRefresh();
            a.this.fQK.aa(aLaCharmDataList.data);
            a.this.fQL = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0597a
        public void az(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.fQK.completePullRefresh();
            a.this.fQK.hideLoadingView();
            a.this.fQK.bIt();
            a.this.fQL = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener fQM = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fPM != null) {
                a.this.fPM.bE(1, 10);
            }
        }
    };
    private CustomMessageListener aZZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.fQK != null) {
                        a.this.fQK.at(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Qx().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.fQK != null) {
                        a.this.fQK.at(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Qx().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aZZ);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.fQK == null) {
            this.fQK = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.bbH, this.aAE);
            this.fQK.Fa(this.fPH);
            this.fQK.a(this.fQM);
        }
        this.fPM = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.fPQ);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.fQK.showLoadingView();
            this.fPM.bE(1, 10);
        }
    }

    public a EW(String str) {
        this.mGroupId = str;
        return this;
    }

    public a EX(String str) {
        this.mLiveId = str;
        return this;
    }

    public a EY(String str) {
        this.mUid = str;
        return this;
    }

    public a EZ(String str) {
        this.fPH = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fQK == null) {
            createView();
        }
        if (this.fQK == null) {
            return null;
        }
        return this.fQK.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String IM() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short IN() {
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
        MessageManager.getInstance().unRegisterListener(this.aZZ);
        if (this.fPM != null) {
            this.fPM.onDestroy();
        }
        if (this.fQK != null) {
            this.fQK.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.fQK != null) {
            this.fQK.onSkinTypeChanged(i);
        }
    }
}
