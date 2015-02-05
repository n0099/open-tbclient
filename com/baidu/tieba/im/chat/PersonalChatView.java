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
    private static /* synthetic */ int[] aSY;
    private PersonalChatActivity aSR;
    private LinearLayout aSS;
    private LinearLayout aST;
    private TextView aSU;
    private TextView aSV;
    private TextView aSW;
    private Button aSX;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] KK() {
        int[] iArr = aSY;
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
            aSY = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.aSR = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(com.baidu.tieba.z.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.group_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.w.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.aSR.KD()) {
            this.mGroupInfoBtnTxt.setVisibility(8);
            this.aSS = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.stranger_person_add_friend_stub)).inflate();
            this.aST = (LinearLayout) this.aSS.findViewById(com.baidu.tieba.w.add_friend_tip_full);
            this.aSU = (TextView) this.aSS.findViewById(com.baidu.tieba.w.add_friend_tip_title);
            this.aSV = (TextView) this.aSS.findViewById(com.baidu.tieba.w.add_friend_tip_content);
            this.aSW = (TextView) this.aSS.findViewById(com.baidu.tieba.w.add_friend_tip_center);
            this.aSX = (Button) this.aSS.findViewById(com.baidu.tieba.w.add_friend_tip_button);
            this.aSX.setOnClickListener(talkableActivity);
            return;
        }
        this.mGroupInfoBtnTxt.setVisibility(0);
    }

    public TextView KH() {
        return this.mGroupInfoBtnTxt;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgsendVoice(MsglistActivity msglistActivity) {
        super.initMsgsendVoice(msglistActivity);
        this.mBtnMsgSendSoftkey.setOnClickListener(new cl(this));
        this.mBtnMsgSendMore1.setOnClickListener(new cm(this));
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgsendText(TalkableActivity talkableActivity) {
        super.initMsgsendText(talkableActivity);
        this.mBtnMsgSendGovoice.setOnClickListener(new cn(this));
        this.mBtnMsgSendMore2.setOnClickListener(new co(this));
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (KK()[cardStatus.ordinal()]) {
            case 1:
                KI();
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

    private void KI() {
        this.aST.setVisibility(0);
        this.aSW.setVisibility(8);
        this.aSU.setText(com.baidu.tieba.z.add_friend_title);
        this.aSV.setText(com.baidu.tieba.z.add_friend_content);
        this.aSX.setText(com.baidu.tieba.z.add_friend_button);
    }

    private void ct(boolean z) {
        if (this.aSR.KA().getCardStatus() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new cp(this, translateAnimation));
            this.aSW.startAnimation(translateAnimation2);
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
            this.aST.setVisibility(8);
            this.aST.startAnimation(translateAnimation4);
        } else {
            this.aST.setVisibility(8);
            this.aSW.setVisibility(0);
        }
        this.aSW.setText(com.baidu.tieba.z.add_friend_wait);
        this.aSX.setText(com.baidu.tieba.z.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.aSR.KA().getUser().getUserName();
        this.aSW.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new cr(this, userName, str, translateAnimation));
            this.aST.setVisibility(0);
            this.aST.startAnimation(translateAnimation2);
        } else {
            this.aST.setVisibility(0);
            this.aSU.setText(this.aSR.getResources().getString(com.baidu.tieba.z.add_friend_agree_title, userName));
            this.aSV.setText(str);
        }
        this.aSX.setText(com.baidu.tieba.z.add_friend_agree_button);
    }

    private void cu(boolean z) {
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new cs(this));
            this.aSS.startAnimation(translateAnimation);
            return;
        }
        this.aSS.setVisibility(8);
    }

    public Button KJ() {
        return this.aSX;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
