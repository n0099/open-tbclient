package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.data.bf;
import com.baidu.live.liveroom.d.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
/* loaded from: classes4.dex */
public class a implements e {
    private String aGk;
    private boolean bns;
    private c hKE;
    private int hKF;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mUserId;
    private String mUserName;
    private BdUniqueId gER = BdUniqueId.gen();
    private InterfaceC0707a hKG = new InterfaceC0707a() { // from class: com.baidu.tieba.ala.person.b.a.1
        @Override // com.baidu.tieba.ala.person.b.a.InterfaceC0707a
        public void a(bf bfVar, View view, int i) {
            if (bfVar.live_status != 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mPageContext.getPageActivity(), bfVar.id, bfVar.name, bfVar.portrait, 0, 0, null, null, 0L, 0L, 0L, bfVar.aQa, a.this.mGroupId, a.this.mLiveId, a.this.bns, a.this.aGk, null, bfVar.getNameShow(), "")));
            }
        }
    };
    private CustomMessageListener blx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (a.this.hKE != null) {
                            a.this.hKE.aD(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
                        }
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && message.getTag().equals(a.this.gER)) {
                            if (updateAttentionMessage.getData().isAttention) {
                                com.baidu.live.view.a.Yo().a(a.this.mPageContext, true);
                                return;
                            } else {
                                CustomToast.newInstance().showToast(a.this.mPageContext.getPageActivity().getResources().getString(a.h.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        return;
                    }
                    if (a.this.hKE != null) {
                        a.this.hKE.aD(updateAttentionMessage.getData().toUid, !updateAttentionMessage.isAttention());
                    }
                    if (!com.baidu.live.view.a.Yo().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                        CustomToast.newInstance().showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.person.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0707a {
        void a(bf bfVar, View view, int i);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.blx);
    }

    private void createView() {
        if (this.hKE == null) {
            this.hKE = new c(this.mPageContext, this.mUserId, this.gER);
            if (this.hKF == 1) {
                this.hKE.xv(0);
            } else if (this.hKF == 2) {
                this.hKE.xv(1);
            }
            this.hKE.a(this.hKG);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hKE == null) {
            createView();
        }
        if (this.hKE == null) {
            return null;
        }
        return this.hKE.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mUserName;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String MK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short ML() {
        return (short) 4;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.hKE != null) {
            this.hKE.enterForeground();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.blx);
        if (this.hKE != null) {
            this.hKE.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hKE != null) {
            this.hKE.onChangeSkinType(i);
        }
    }
}
