package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private TextView aOf;
    private LinearLayout aRE;
    private ImageView aRF;
    private LinearLayout aRG;
    private LinearLayout aRH;
    private LinearLayout aRI;
    private com.baidu.tieba.im.view.k aRJ;
    private ao[] aRK;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getString(com.baidu.tieba.y.msglist_officialInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.group_info_btn, talkableActivity);
            this.aOf = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.v.group_info_btn_txt);
            this.aOf.setText(string);
        }
        this.aRE = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_toggle_stub)).inflate();
        this.aRF = (ImageView) this.aRE.findViewById(com.baidu.tieba.v.official_bar_toggle_button);
        this.aRF.setVisibility(0);
        this.aRG = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_stub)).inflate();
        this.aRG.setVisibility(0);
        this.aRK = new ao[3];
        ao aoVar = new ao();
        aoVar.aRO = false;
        aoVar.aRP = (LinearLayout) this.aRG.findViewById(com.baidu.tieba.v.menu_frist);
        aoVar.aRQ = (TextView) this.aRG.findViewById(com.baidu.tieba.v.menu_frist_text);
        aoVar.aRR = (ImageView) this.aRG.findViewById(com.baidu.tieba.v.menu_frist_tip);
        this.aRK[0] = aoVar;
        ao aoVar2 = new ao();
        aoVar2.aRO = false;
        aoVar2.aRP = (LinearLayout) this.aRG.findViewById(com.baidu.tieba.v.menu_second);
        aoVar2.aRQ = (TextView) this.aRG.findViewById(com.baidu.tieba.v.menu_second_text);
        aoVar2.aRR = (ImageView) this.aRG.findViewById(com.baidu.tieba.v.menu_second_tip);
        this.aRK[1] = aoVar2;
        ao aoVar3 = new ao();
        aoVar3.aRO = false;
        aoVar3.aRP = (LinearLayout) this.aRG.findViewById(com.baidu.tieba.v.menu_third);
        aoVar3.aRQ = (TextView) this.aRG.findViewById(com.baidu.tieba.v.menu_third_text);
        aoVar3.aRR = (ImageView) this.aRG.findViewById(com.baidu.tieba.v.menu_third_tip);
        this.aRK[2] = aoVar3;
        for (int i = 0; i < 3; i++) {
            this.aRK[i].aRP.setOnClickListener(talkableActivity);
        }
        this.aRH = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_down_line)).inflate();
        this.aRH.setVisibility(0);
        this.aRI = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_menu_loading)).inflate();
        this.aRI.setVisibility(8);
        this.mInputControl.setVisibility(8);
        this.aRF.setOnClickListener(talkableActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.aRJ = new com.baidu.tieba.im.view.k(msglistActivity);
        getListMain().addView(this.aRJ);
        this.aRJ.setVisibility(8);
        this.aRJ.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
    }

    public com.baidu.tieba.im.view.k Kv() {
        return this.aRJ;
    }

    public void cI(boolean z) {
        if (z) {
            this.aRE.setVisibility(8);
            this.aRG.setVisibility(8);
            this.mInputControl.setVisibility(0);
            this.aRH.setVisibility(8);
            return;
        }
        this.aRE.setVisibility(0);
        this.aRG.setVisibility(0);
        this.mInputControl.setVisibility(8);
        this.aRH.setVisibility(0);
    }

    public ao[] Kw() {
        return this.aRK;
    }

    public void P(List<com.baidu.tieba.im.data.f> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.f fVar = list.get(i);
                this.aRK[i].aRQ.setText(fVar.getName());
                if (fVar.Mo() != 0) {
                    this.aRK[i].aRR.setVisibility(8);
                }
            }
        }
    }

    public void cJ(boolean z) {
        this.aRI.setVisibility(z ? 0 : 8);
    }

    public void cK(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.parent_menu_down);
        loadAnimation2.setAnimationListener(new an(this, z, loadAnimation));
        sendmsgCloseSoftkey();
        if (isMoreVisible()) {
            hideMore();
        }
        getLayoutBottom().startAnimation(loadAnimation2);
    }

    public void q(int i, boolean z) {
        ao aoVar = this.aRK[i];
        if (z) {
            aoVar.aRR.setImageResource(com.baidu.tieba.u.icon_bottombar_arrow_s);
        } else {
            aoVar.aRR.setImageResource(com.baidu.tieba.u.icon_bottombar_arrow_n);
        }
    }

    public int L(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.aRK[i].aRP) {
                return i;
            }
        }
        return 0;
    }

    public ImageView Kx() {
        return this.aRF;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }
}
