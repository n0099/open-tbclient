package com.baidu.tieba.ala.charm.a;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.liveroom.c.d;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import com.baidu.tieba.ala.charm.model.a;
/* loaded from: classes2.dex */
public class a implements d {
    private boolean aoM;
    private String aoN;
    private b eqW;
    private String eqf;
    private com.baidu.tieba.ala.charm.model.a eqk;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private String mUid;
    private boolean eqX = true;
    a.InterfaceC0414a eqo = new a.InterfaceC0414a() { // from class: com.baidu.tieba.ala.charm.a.a.1
        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0414a
        public void a(ALaCharmDataList aLaCharmDataList) {
            a.this.eqW.hideLoadingView();
            a.this.eqW.completePullRefresh();
            a.this.eqW.Q(aLaCharmDataList.data);
            a.this.eqX = false;
        }

        @Override // com.baidu.tieba.ala.charm.model.a.InterfaceC0414a
        public void aa(int i, String str) {
            if (str != null) {
                CustomToast.newInstance().showToast(str);
            }
            a.this.eqW.completePullRefresh();
            a.this.eqW.hideLoadingView();
            a.this.eqW.bbl();
            a.this.eqX = true;
        }
    };
    private TbListCommonPullView.ListPullRefreshListener eqY = new TbListCommonPullView.ListPullRefreshListener() { // from class: com.baidu.tieba.ala.charm.a.a.2
        @Override // com.baidu.live.tbadk.core.view.TbListCommonPullView.ListPullRefreshListener
        public void onListPullRefresh(boolean z) {
            if (a.this.eqk != null) {
                a.this.eqk.bb(1, 10);
            }
        }
    };
    private CustomMessageListener anF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (a.this.eqW != null) {
                        a.this.eqW.X(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.mPageId) && !com.baidu.live.view.a.yy().a(updateAttentionMessage.getData(), a.this.mPageContext, false) && !StringUtils.isNull(updateAttentionMessage.getData().errorString)) {
                        a.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 == null || message2.getTag() == null || !message2.getTag().equals(a.this.mPageId)) {
                    if (a.this.eqW != null) {
                        a.this.eqW.X(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                } else if (updateAttentionMessage.getData().isAttention) {
                    com.baidu.live.view.a.yy().a(a.this.mPageContext, true);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.anF);
        this.mPageId = BdUniqueId.gen();
    }

    public void createView() {
        if (this.eqW == null) {
            this.eqW = new b(this.mPageContext, this.mPageId, this.mGroupId, this.mLiveId, this.aoM, this.aoN);
            this.eqW.xE(this.eqf);
            this.eqW.a(this.eqY);
        }
        this.eqk = new com.baidu.tieba.ala.charm.model.a(this.mPageContext, this.mUid, this.eqo);
        if (!StringUtils.isNull(this.mUid) && !this.mUid.equals("0")) {
            this.eqW.showLoadingView();
            this.eqk.bb(1, 10);
        }
    }

    public a xA(String str) {
        this.mGroupId = str;
        return this;
    }

    public a xB(String str) {
        this.mLiveId = str;
        return this;
    }

    public a xC(String str) {
        this.mUid = str;
        return this;
    }

    public a xD(String str) {
        this.eqf = str;
        return this;
    }

    @Override // com.baidu.live.liveroom.c.d
    public View uj() {
        if (this.eqW == null) {
            createView();
        }
        if (this.eqW == null) {
            return null;
        }
        return this.eqW.getView();
    }

    @Override // com.baidu.live.liveroom.c.d
    public String getTitle() {
        return this.mPageContext.getResources().getString(a.i.ala_charm_game_live_name_title);
    }

    @Override // com.baidu.live.liveroom.c.d
    public String uk() {
        return null;
    }

    @Override // com.baidu.live.liveroom.c.d
    public short ul() {
        return (short) 3;
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.anF);
        if (this.eqk != null) {
            this.eqk.onDestroy();
        }
        if (this.eqW != null) {
            this.eqW.hideLoadingView();
        }
    }

    @Override // com.baidu.live.liveroom.c.d
    public void onChangeSkinType(int i) {
        if (this.eqW != null) {
            this.eqW.onSkinTypeChanged(i);
        }
    }
}
