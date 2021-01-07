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
/* loaded from: classes11.dex */
public class a implements d {
    private String aGB;
    private boolean boZ;
    private String gPk;
    private com.baidu.tieba.ala.charm.model.a gPp;
    private b gQm;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean gQn = true;
    a.InterfaceC0641a gPt = new a.InterfaceC0641a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0641a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.gQm.hideLoadingView();
            a.this.gQm.completePullRefresh();
            a.this.gQm.ab(aLaCharmDataList.data);
            a.this.gQn = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0641a
        public void v(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.gQm.completePullRefresh();
            a.this.gQm.hideLoadingView();
            a.this.gQm.bWX();
            a.this.gQn = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener gQo = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.gPp != null) {
                a.this.gPp.bG(1, 10);
            }
        }
    };
    private CustomMessageListener aWQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.gQm != null) {
                        a.this.gQm.aB(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Zy().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.gQm != null) {
                        a.this.gQm.aB(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Zy().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aWQ);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.gQm == null) {
            this.gQm = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.boZ, this.aGB);
            this.gQm.Hk(this.gPk);
            this.gQm.a(this.gQo);
        }
        this.gPp = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.gPt);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.gQm.showLoadingView();
            this.gPp.bG(1, 10);
        }
    }

    public a Hg(String str) {
        this.mGroupId = str;
        return this;
    }

    public a Hh(String str) {
        this.mLiveId = str;
        return this;
    }

    public a Hi(String str) {
        this.mUid = str;
        return this;
    }

    public a Hj(String str) {
        this.gPk = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.gQm == null) {
            createView();
        }
        if (this.gQm == null) {
            return null;
        }
        return this.gQm.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.h.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Mh() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Mi() {
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
        MessageManager.getInstance().unRegisterListener(this.aWQ);
        if (this.gPp != null) {
            this.gPp.onDestroy();
        }
        if (this.gQm != null) {
            this.gQm.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.gQm != null) {
            this.gQm.onSkinTypeChanged(i);
        }
    }
}
