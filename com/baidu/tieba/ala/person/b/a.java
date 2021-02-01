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
import com.baidu.live.data.bl;
import com.baidu.live.liveroom.d.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
/* loaded from: classes11.dex */
public class a implements e {
    private String aDB;
    private boolean bnF;
    private c hWE;
    private int hWF;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mUserId;
    private String mUserName;
    private BdUniqueId gOC = BdUniqueId.gen();
    private InterfaceC0682a hWG = new InterfaceC0682a() { // from class: com.baidu.tieba.ala.person.b.a.1
        @Override // com.baidu.tieba.ala.person.b.a.InterfaceC0682a
        public void a(bl blVar, View view, int i) {
            if (blVar.live_status != 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(a.this.mPageContext.getPageActivity(), blVar.id, blVar.name, blVar.portrait, 0, 0, null, null, 0L, 0L, 0L, blVar.aOZ, a.this.mGroupId, a.this.mLiveId, a.this.bnF, a.this.aDB, null, blVar.getNameShow())));
            }
        }
    };
    private CustomMessageListener aVh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.person.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String string;
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                    if (!updateAttentionMessage.getData().isSucc || updateAttentionMessage.getData().errno != 0) {
                        if (a.this.hWE != null) {
                            a.this.hWE.aD(updateAttentionMessage.getData().toUid, !updateAttentionMessage.isAttention());
                        }
                        if (!com.baidu.live.view.a.Xo().a(updateAttentionMessage.getData(), (BdPageContext<?>) a.this.mPageContext, false)) {
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
                    if (a.this.hWE != null) {
                        a.this.hWE.aD(updateAttentionMessage.getData().toUid, updateAttentionMessage.isAttention());
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(a.this.gOC)) {
                        if (updateAttentionMessage.getData().isAttention) {
                            com.baidu.live.view.a.Xo().a(a.this.mPageContext, true);
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
    public interface InterfaceC0682a {
        void a(bl blVar, View view, int i);
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.aVh);
    }

    private void createView() {
        if (this.hWE == null) {
            this.hWE = new c(this.mPageContext, this.mUserId, this.gOC);
            if (this.hWF == 1) {
                this.hWE.wn(0);
            } else if (this.hWF == 2) {
                this.hWE.wn(1);
            }
            this.hWE.a(this.hWG);
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        if (this.hWE == null) {
            createView();
        }
        if (this.hWE == null) {
            return null;
        }
        return this.hWE.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mUserName;
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
        return (short) 4;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
        if (this.hWE != null) {
            this.hWE.enterForeground();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aVh);
        if (this.hWE != null) {
            this.hWE.onDestory();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
        if (this.hWE != null) {
            this.hWE.onChangeSkinType(i);
        }
    }
}
