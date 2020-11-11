package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.data.be;
import com.baidu.live.liveroom.d.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
/* loaded from: classes4.dex */
public class a implements e {
    private String aFp;
    private boolean bkL;
    private c hBq;
    private int hBr;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mUserId;
    private String mUserName;
    private BdUniqueId gwz = BdUniqueId.gen();
    private InterfaceC0694a hBs = new InterfaceC0694a() { // from class: com.baidu.tieba.ala.person.b.a.1
        @Override // com.baidu.tieba.ala.person.b.a.InterfaceC0694a
        public void a(be beVar, View view, int i) {
            if (beVar.live_status != 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mPageContext.getPageActivity(), beVar.id, beVar.name, beVar.portrait, 0, 0, null, null, 0L, 0L, 0L, beVar.aOM, a.this.mGroupId, a.this.mLiveId, a.this.bkL, a.this.aFp, null, beVar.getNameShow(), "")));
            }
        }
    };
    private CustomMessageListener biW = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (a.this.hBq != null) {
                            a.this.hBq.aC(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
                        }
                        Message<?> message = updateAttentionMessage.getmOrginalMessage();
                        if (message != null && message.getTag() != null && message.getTag().equals(a.this.gwz)) {
                            if (updateAttentionMessage.getData().isAttention) {
                                com.baidu.live.view.a.Wx().a(a.this.mPageContext, true);
                                return;
                            } else {
                                CustomToast.newInstance().showToast(a.this.mPageContext.getPageActivity().getResources().getString(a.h.sdk_unfollow_success_toast));
                                return;
                            }
                        }
                        return;
                    }
                    if (a.this.hBq != null) {
                        a.this.hBq.aC(updateAttentionMessage.getData().toUid, !updateAttentionMessage.isAttention());
                    }
                    if (!com.baidu.live.view.a.Wx().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false) && updateAttentionMessage.getData().errorString != null) {
                        CustomToast.newInstance().showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.person.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0694a {
        void a(be beVar, View view, int i);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.biW);
    }

    private void createView() {
        if (this.hBq == null) {
            this.hBq = new c(this.mPageContext, this.mUserId, this.gwz);
            if (this.hBr == 1) {
                this.hBq.ws(0);
            } else if (this.hBr == 2) {
                this.hBq.ws(1);
            }
            this.hBq.a(this.hBs);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hBq == null) {
            createView();
        }
        if (this.hBq == null) {
            return null;
        }
        return this.hBq.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mUserName;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Lr() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ls() {
        return (short) 4;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.hBq != null) {
            this.hBq.enterForeground();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.biW);
        if (this.hBq != null) {
            this.hBq.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hBq != null) {
            this.hBq.onChangeSkinType(i);
        }
    }
}
