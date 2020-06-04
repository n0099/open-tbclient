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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
/* loaded from: classes3.dex */
public class a implements d {
    private boolean aSw;
    private String aSx;
    private String fnW;
    private b foX;
    private com.baidu.tieba.ala.charm.model.a fob;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean foY = true;
    a.InterfaceC0532a fof = new a.InterfaceC0532a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0532a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.foX.hideLoadingView();
            a.this.foX.completePullRefresh();
            a.this.foX.T(aLaCharmDataList.data);
            a.this.foY = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0532a
        public void ax(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.foX.completePullRefresh();
            a.this.foX.hideLoadingView();
            a.this.foX.bth();
            a.this.foY = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener foZ = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fob != null) {
                a.this.fob.bo(1, 10);
            }
        }
    };
    private CustomMessageListener aQM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.foX != null) {
                        a.this.foX.ap(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Jl().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.foX != null) {
                        a.this.foX.ap(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Jl().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aQM);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.foX == null) {
            this.foX = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.aSw, this.aSx);
            this.foX.Bw(this.fnW);
            this.foX.a(this.foZ);
        }
        this.fob = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.fof);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.foX.showLoadingView();
            this.fob.bo(1, 10);
        }
    }

    public a Bs(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Bt(String str) {
        this.mLiveId = str;
        return this;
    }

    public a Bu(String str) {
        this.mUid = str;
        return this;
    }

    public a Bv(String str) {
        this.fnW = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.foX == null) {
            createView();
        }
        if (this.foX == null) {
            return null;
        }
        return this.foX.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Ci() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Cj() {
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
        MessageManager.getInstance().unRegisterListener(this.aQM);
        if (this.fob != null) {
            this.fob.onDestroy();
        }
        if (this.foX != null) {
            this.foX.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.foX != null) {
            this.foX.onSkinTypeChanged(i);
        }
    }
}
