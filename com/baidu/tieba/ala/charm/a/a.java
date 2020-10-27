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
    private String aEz;
    private boolean bjr;
    private String gps;
    private com.baidu.tieba.ala.charm.model.a gpx;
    private b gqv;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean gqw = true;
    a.InterfaceC0626a gpB = new a.InterfaceC0626a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0626a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.gqv.hideLoadingView();
            a.this.gqv.completePullRefresh();
            a.this.gqv.aa(aLaCharmDataList.data);
            a.this.gqw = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0626a
        public void t(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.gqv.completePullRefresh();
            a.this.gqv.hideLoadingView();
            a.this.gqv.bOO();
            a.this.gqw = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener gqx = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gpx != null) {
                a.this.gpx.bF(1, 10);
            }
        }
    };
    private CustomMessageListener bhA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.gqv != null) {
                        a.this.gqv.az(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.TX().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.gqv != null) {
                        a.this.gqv.az(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.TX().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.bhA);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.gqv == null) {
            this.gqv = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.bjr, this.aEz);
            this.gqv.GJ(this.gps);
            this.gqv.a(this.gqx);
        }
        this.gpx = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.gpB);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.gqv.showLoadingView();
            this.gpx.bF(1, 10);
        }
    }

    public a GF(String str) {
        this.mGroupId = str;
        return this;
    }

    public a GG(String str) {
        this.mLiveId = str;
        return this;
    }

    public a GH(String str) {
        this.mUid = str;
        return this;
    }

    public a GI(String str) {
        this.gps = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gqv == null) {
            createView();
        }
        if (this.gqv == null) {
            return null;
        }
        return this.gqv.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KR() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KS() {
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
        MessageManager.getInstance().unRegisterListener(this.bhA);
        if (this.gpx != null) {
            this.gpx.onDestroy();
        }
        if (this.gqv != null) {
            this.gqv.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gqv != null) {
            this.gqv.onSkinTypeChanged(i);
        }
    }
}
