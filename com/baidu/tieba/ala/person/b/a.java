package com.baidu.tieba.ala.person.b;

import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.data.bh;
import com.baidu.live.liveroom.d.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
/* loaded from: classes11.dex */
public class a implements e {
    private String aGB;
    private boolean boZ;
    private c hWQ;
    private int hWR;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mUserId;
    private String mUserName;
    private BdUniqueId gQC = BdUniqueId.gen();
    private InterfaceC0699a hWS = new InterfaceC0699a() { // from class: com.baidu.tieba.ala.person.b.a.1
        @Override // com.baidu.tieba.ala.person.b.a.InterfaceC0699a
        public void a(bh bhVar, View view, int i) {
            if (bhVar.live_status != 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mPageContext.getPageActivity(), bhVar.id, bhVar.name, bhVar.portrait, 0, 0, null, null, 0L, 0L, 0L, bhVar.aQP, a.this.mGroupId, a.this.mLiveId, a.this.boZ, a.this.aGB, null, bhVar.getNameShow())));
            }
        }
    };
    private CustomMessageListener aWQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (!updateAttentionMessage.getData().isSucc || updateAttentionMessage.getData().errno != 0) {
                        if (a.this.hWQ != null) {
                            a.this.hWQ.aE(updateAttentionMessage.getData().toUid, !updateAttentionMessage.isAttention());
                        }
                        if (!com.baidu.live.view.a.Zx().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false)) {
                            if (!TextUtils.isEmpty(updateAttentionMessage.getData().usermsg)) {
                                string = updateAttentionMessage.getData().usermsg;
                            } else if (!TextUtils.isEmpty(updateAttentionMessage.getData().errmsg)) {
                                string = updateAttentionMessage.getData().errmsg;
                            } else if (TextUtils.isEmpty(updateAttentionMessage.getData().errorString)) {
                                string = a.this.mPageContext.getPageActivity().getResources().getString(a.h.sdk_op_failed_toast);
                            } else {
                                string = updateAttentionMessage.getData().errorString;
                            }
                            CustomToast.newInstance().showToast(string);
                            return;
                        }
                        return;
                    }
                    if (a.this.hWQ != null) {
                        a.this.hWQ.aE(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.gQC)) {
                        if (updateAttentionMessage.getData().isAttention) {
                            com.baidu.live.view.a.Zx().a(a.this.mPageContext, true);
                        } else {
                            CustomToast.newInstance().showToast(a.this.mPageContext.getPageActivity().getResources().getString(a.h.sdk_unfollow_success_toast));
                        }
                    }
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.person.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0699a {
        void a(bh bhVar, View view, int i);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aWQ);
    }

    private void createView() {
        if (this.hWQ == null) {
            this.hWQ = new c(this.mPageContext, this.mUserId, this.gQC);
            if (this.hWR == 1) {
                this.hWQ.xI(0);
            } else if (this.hWR == 2) {
                this.hWQ.xI(1);
            }
            this.hWQ.a(this.hWS);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hWQ == null) {
            createView();
        }
        if (this.hWQ == null) {
            return null;
        }
        return this.hWQ.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mUserName;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Mh() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Mi() {
        return (short) 4;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.hWQ != null) {
            this.hWQ.enterForeground();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aWQ);
        if (this.hWQ != null) {
            this.hWQ.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hWQ != null) {
            this.hWQ.onChangeSkinType(i);
        }
    }
}
