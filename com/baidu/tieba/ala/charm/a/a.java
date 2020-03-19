package com.baidu.tieba.ala.charm.a;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
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
    private boolean atc;
    private String atd;
    private String ewm;
    private com.baidu.tieba.ala.charm.model.a ewr;
    private b exc;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean exd = true;
    a.InterfaceC0428a ewv = new a.InterfaceC0428a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0428a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.exc.hideLoadingView();
            a.this.exc.completePullRefresh();
            a.this.exc.S(aLaCharmDataList.data);
            a.this.exd = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0428a
        public void ad(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.exc.completePullRefresh();
            a.this.exc.hideLoadingView();
            a.this.exc.bed();
            a.this.exd = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener exe = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.ewr != null) {
                a.this.ewr.bg(1, 10);
            }
        }
    };
    private CustomMessageListener arV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.exc != null) {
                        a.this.exc.X(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.Bq().a(updateAttentionMessage.getData(), a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.exc != null) {
                        a.this.exc.X(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.Bq().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.arV);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.exc == null) {
            this.exc = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.atc, this.atd);
            this.exc.yf(this.ewm);
            this.exc.a(this.exe);
        }
        this.ewr = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.ewv);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.exc.showLoadingView();
            this.ewr.bg(1, 10);
        }
    }

    public a yb(String str) {
        this.mGroupId = str;
        return this;
    }

    public a yc(String str) {
        this.mLiveId = str;
        return this;
    }

    public a yd(String str) {
        this.mUid = str;
        return this;
    }

    public a ye(String str) {
        this.ewm = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.d.d
    public View wj() {
        if (this.exc == null) {
            createView();
        }
        if (this.exc == null) {
            return null;
        }
        return this.exc.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String wk() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short wl() {
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
        MessageManager.getInstance().unRegisterListener(this.arV);
        if (this.ewr != null) {
            this.ewr.onDestroy();
        }
        if (this.exc != null) {
            this.exc.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.exc != null) {
            this.exc.onSkinTypeChanged(i);
        }
    }
}
