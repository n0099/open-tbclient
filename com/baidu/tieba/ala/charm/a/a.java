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
    private boolean aMw;
    private String aMx;
    private String fai;
    private com.baidu.tieba.ala.charm.model.a fan;
    private b fbk;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean fbl = true;
    a.InterfaceC0484a far = new a.InterfaceC0484a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0484a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.fbk.hideLoadingView();
            a.this.fbk.completePullRefresh();
            a.this.fbk.T(aLaCharmDataList.data);
            a.this.fbl = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0484a
        public void as(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.fbk.completePullRefresh();
            a.this.fbk.hideLoadingView();
            a.this.fbk.bnn();
            a.this.fbl = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener fbm = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.fan != null) {
                a.this.fan.bl(1, 10);
            }
        }
    };
    private CustomMessageListener aKY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.fbk != null) {
                        a.this.fbk.ac(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Hs().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.fbk != null) {
                        a.this.fbk.ac(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Hs().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aKY);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.fbk == null) {
            this.fbk = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.aMw, this.aMx);
            this.fbk.zP(this.fai);
            this.fbk.a(this.fbm);
        }
        this.fan = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.far);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.fbk.showLoadingView();
            this.fan.bl(1, 10);
        }
    }

    public a zL(String str) {
        this.mGroupId = str;
        return this;
    }

    public a zM(String str) {
        this.mLiveId = str;
        return this;
    }

    public a zN(String str) {
        this.mUid = str;
        return this;
    }

    public a zO(String str) {
        this.fai = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.fbk == null) {
            createView();
        }
        if (this.fbk == null) {
            return null;
        }
        return this.fbk.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String AS() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short AT() {
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
        MessageManager.getInstance().unRegisterListener(this.aKY);
        if (this.fan != null) {
            this.fan.onDestroy();
        }
        if (this.fbk != null) {
            this.fbk.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.fbk != null) {
            this.fbk.onSkinTypeChanged(i);
        }
    }
}
