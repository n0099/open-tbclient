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
    private boolean aWs;
    private String avC;
    private String fEq;
    private com.baidu.tieba.ala.charm.model.a fEv;
    private b fFt;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean fFu = true;
    a.InterfaceC0551a fEz = new a.InterfaceC0551a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0551a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.fFt.hideLoadingView();
            a.this.fFt.completePullRefresh();
            a.this.fFt.U(aLaCharmDataList.data);
            a.this.fFu = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0551a
        public void aB(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.fFt.completePullRefresh();
            a.this.fFt.hideLoadingView();
            a.this.fFt.bzq();
            a.this.fFu = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener fFv = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fEv != null) {
                a.this.fEv.bv(1, 10);
            }
        }
    };
    private CustomMessageListener aUL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.fFt != null) {
                        a.this.fFt.ap(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.KF().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.fFt != null) {
                        a.this.fFt.ap(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.KF().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aUL);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.fFt == null) {
            this.fFt = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.aWs, this.avC);
            this.fFt.CF(this.fEq);
            this.fFt.a(this.fFv);
        }
        this.fEv = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.fEz);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.fFt.showLoadingView();
            this.fEv.bv(1, 10);
        }
    }

    public a CB(String str) {
        this.mGroupId = str;
        return this;
    }

    public a CC(String str) {
        this.mLiveId = str;
        return this;
    }

    public a CD(String str) {
        this.mUid = str;
        return this;
    }

    public a CE(String str) {
        this.fEq = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fFt == null) {
            createView();
        }
        if (this.fFt == null) {
            return null;
        }
        return this.fFt.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Dj() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Dk() {
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
        MessageManager.getInstance().unRegisterListener(this.aUL);
        if (this.fEv != null) {
            this.fEv.onDestroy();
        }
        if (this.fFt != null) {
            this.fFt.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.fFt != null) {
            this.fFt.onSkinTypeChanged(i);
        }
    }
}
