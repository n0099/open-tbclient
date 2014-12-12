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
    private static /* synthetic */ int[] aRQ;
    private PersonalChatActivity aRJ;
    private LinearLayout aRK;
    private LinearLayout aRL;
    private TextView aRM;
    private TextView aRN;
    private TextView aRO;
    private Button aRP;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] Ku() {
        int[] iArr = aRQ;
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
            aRQ = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.aRJ = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(com.baidu.tieba.z.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.group_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.w.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.aRJ.Kn()) {
            this.mGroupInfoBtnTxt.setVisibility(8);
            this.aRK = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.stranger_person_add_friend_stub)).inflate();
            this.aRL = (LinearLayout) this.aRK.findViewById(com.baidu.tieba.w.add_friend_tip_full);
            this.aRM = (TextView) this.aRK.findViewById(com.baidu.tieba.w.add_friend_tip_title);
            this.aRN = (TextView) this.aRK.findViewById(com.baidu.tieba.w.add_friend_tip_content);
            this.aRO = (TextView) this.aRK.findViewById(com.baidu.tieba.w.add_friend_tip_center);
            this.aRP = (Button) this.aRK.findViewById(com.baidu.tieba.w.add_friend_tip_button);
            this.aRP.setOnClickListener(talkableActivity);
            return;
        }
        this.mGroupInfoBtnTxt.setVisibility(0);
    }

    public TextView Kr() {
        return this.mGroupInfoBtnTxt;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgsendVoice(MsglistActivity msglistActivity) {
        super.initMsgsendVoice(msglistActivity);
        this.mBtnMsgSendSoftkey.setOnClickListener(new ci(this));
        this.mBtnMsgSendMore1.setOnClickListener(new cj(this));
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgsendText(TalkableActivity talkableActivity) {
        super.initMsgsendText(talkableActivity);
        this.mBtnMsgSendGovoice.setOnClickListener(new ck(this));
        this.mBtnMsgSendMore2.setOnClickListener(new cl(this));
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (Ku()[cardStatus.ordinal()]) {
            case 1:
                Ks();
                return;
            case 2:
                cp(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case 4:
                cq(z);
                return;
            default:
                return;
        }
    }

    private void Ks() {
        this.aRL.setVisibility(0);
        this.aRO.setVisibility(8);
        this.aRM.setText(com.baidu.tieba.z.add_friend_title);
        this.aRN.setText(com.baidu.tieba.z.add_friend_content);
        this.aRP.setText(com.baidu.tieba.z.add_friend_button);
    }

    private void cp(boolean z) {
        if (this.aRJ.Kk().getCardStatus() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new cm(this, translateAnimation));
            this.aRO.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new cn(this, translateAnimation3));
            this.aRL.setVisibility(8);
            this.aRL.startAnimation(translateAnimation4);
        } else {
            this.aRL.setVisibility(8);
            this.aRO.setVisibility(0);
        }
        this.aRO.setText(com.baidu.tieba.z.add_friend_wait);
        this.aRP.setText(com.baidu.tieba.z.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.aRJ.Kk().getUser().getUserName();
        this.aRO.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new co(this, userName, str, translateAnimation));
            this.aRL.setVisibility(0);
            this.aRL.startAnimation(translateAnimation2);
        } else {
            this.aRL.setVisibility(0);
            this.aRM.setText(this.aRJ.getResources().getString(com.baidu.tieba.z.add_friend_agree_title, userName));
            this.aRN.setText(str);
        }
        this.aRP.setText(com.baidu.tieba.z.add_friend_agree_button);
    }

    private void cq(boolean z) {
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new cp(this));
            this.aRK.startAnimation(translateAnimation);
            return;
        }
        this.aRK.setVisibility(8);
    }

    public Button Kt() {
        return this.aRP;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
