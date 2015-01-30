package com.baidu.tieba.im.chat;

import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] aSZ;
    private PersonalChatActivity aSS;
    private LinearLayout aST;
    private LinearLayout aSU;
    private TextView aSV;
    private TextView aSW;
    private TextView aSX;
    private Button aSY;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] KP() {
        int[] iArr = aSZ;
        if (iArr == null) {
            iArr = new int[PersonalMsglistModel.CardStatus.valuesCustom().length];
            try {
                iArr[PersonalMsglistModel.CardStatus.AGREE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.PASS.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            aSZ = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.aSS = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(com.baidu.tieba.z.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.group_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.w.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.aSS.KI()) {
            this.mGroupInfoBtnTxt.setVisibility(8);
            this.aST = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.stranger_person_add_friend_stub)).inflate();
            this.aSU = (LinearLayout) this.aST.findViewById(com.baidu.tieba.w.add_friend_tip_full);
            this.aSV = (TextView) this.aST.findViewById(com.baidu.tieba.w.add_friend_tip_title);
            this.aSW = (TextView) this.aST.findViewById(com.baidu.tieba.w.add_friend_tip_content);
            this.aSX = (TextView) this.aST.findViewById(com.baidu.tieba.w.add_friend_tip_center);
            this.aSY = (Button) this.aST.findViewById(com.baidu.tieba.w.add_friend_tip_button);
            this.aSY.setOnClickListener(talkableActivity);
            return;
        }
        this.mGroupInfoBtnTxt.setVisibility(0);
    }

    public TextView KM() {
        return this.mGroupInfoBtnTxt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsgsendVoice(MsglistActivity msglistActivity) {
        super.initMsgsendVoice(msglistActivity);
        this.mBtnMsgSendSoftkey.setOnClickListener(new cl(this));
        this.mBtnMsgSendMore1.setOnClickListener(new cm(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsgsendText(TalkableActivity talkableActivity) {
        super.initMsgsendText(talkableActivity);
        this.mBtnMsgSendGovoice.setOnClickListener(new cn(this));
        this.mBtnMsgSendMore2.setOnClickListener(new co(this));
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (KP()[cardStatus.ordinal()]) {
            case 1:
                KN();
                return;
            case 2:
                ct(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case 4:
                cu(z);
                return;
            default:
                return;
        }
    }

    private void KN() {
        this.aSU.setVisibility(0);
        this.aSX.setVisibility(8);
        this.aSV.setText(com.baidu.tieba.z.add_friend_title);
        this.aSW.setText(com.baidu.tieba.z.add_friend_content);
        this.aSY.setText(com.baidu.tieba.z.add_friend_button);
    }

    private void ct(boolean z) {
        if (this.aSS.KF().getCardStatus() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new cp(this, translateAnimation));
            this.aSX.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new cq(this, translateAnimation3));
            this.aSU.setVisibility(8);
            this.aSU.startAnimation(translateAnimation4);
        } else {
            this.aSU.setVisibility(8);
            this.aSX.setVisibility(0);
        }
        this.aSX.setText(com.baidu.tieba.z.add_friend_wait);
        this.aSY.setText(com.baidu.tieba.z.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.aSS.KF().getUser().getUserName();
        this.aSX.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new cr(this, userName, str, translateAnimation));
            this.aSU.setVisibility(0);
            this.aSU.startAnimation(translateAnimation2);
        } else {
            this.aSU.setVisibility(0);
            this.aSV.setText(this.aSS.getResources().getString(com.baidu.tieba.z.add_friend_agree_title, userName));
            this.aSW.setText(str);
        }
        this.aSY.setText(com.baidu.tieba.z.add_friend_agree_button);
    }

    private void cu(boolean z) {
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new cs(this));
            this.aST.startAnimation(translateAnimation);
            return;
        }
        this.aST.setVisibility(8);
    }

    public Button KO() {
        return this.aSY;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
