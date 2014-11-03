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
    private TextView aOt;
    private LinearLayout aRS;
    private ImageView aRT;
    private LinearLayout aRU;
    private LinearLayout aRV;
    private LinearLayout aRW;
    private com.baidu.tieba.im.view.k aRX;
    private ao[] aRY;

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
            this.aOt = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.v.group_info_btn_txt);
            this.aOt.setText(string);
        }
        this.aRS = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_toggle_stub)).inflate();
        this.aRT = (ImageView) this.aRS.findViewById(com.baidu.tieba.v.official_bar_toggle_button);
        this.aRT.setVisibility(0);
        this.aRU = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_stub)).inflate();
        this.aRU.setVisibility(0);
        this.aRY = new ao[3];
        ao aoVar = new ao();
        aoVar.aSc = false;
        aoVar.aSd = (LinearLayout) this.aRU.findViewById(com.baidu.tieba.v.menu_frist);
        aoVar.aSe = (TextView) this.aRU.findViewById(com.baidu.tieba.v.menu_frist_text);
        aoVar.aSf = (ImageView) this.aRU.findViewById(com.baidu.tieba.v.menu_frist_tip);
        this.aRY[0] = aoVar;
        ao aoVar2 = new ao();
        aoVar2.aSc = false;
        aoVar2.aSd = (LinearLayout) this.aRU.findViewById(com.baidu.tieba.v.menu_second);
        aoVar2.aSe = (TextView) this.aRU.findViewById(com.baidu.tieba.v.menu_second_text);
        aoVar2.aSf = (ImageView) this.aRU.findViewById(com.baidu.tieba.v.menu_second_tip);
        this.aRY[1] = aoVar2;
        ao aoVar3 = new ao();
        aoVar3.aSc = false;
        aoVar3.aSd = (LinearLayout) this.aRU.findViewById(com.baidu.tieba.v.menu_third);
        aoVar3.aSe = (TextView) this.aRU.findViewById(com.baidu.tieba.v.menu_third_text);
        aoVar3.aSf = (ImageView) this.aRU.findViewById(com.baidu.tieba.v.menu_third_tip);
        this.aRY[2] = aoVar3;
        for (int i = 0; i < 3; i++) {
            this.aRY[i].aSd.setOnClickListener(talkableActivity);
        }
        this.aRV = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_down_line)).inflate();
        this.aRV.setVisibility(0);
        this.aRW = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_menu_loading)).inflate();
        this.aRW.setVisibility(8);
        this.mInputControl.setVisibility(8);
        this.aRT.setOnClickListener(talkableActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.aRX = new com.baidu.tieba.im.view.k(msglistActivity);
        getListMain().addView(this.aRX);
        this.aRX.setVisibility(8);
        this.aRX.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
    }

    public com.baidu.tieba.im.view.k Kz() {
        return this.aRX;
    }

    public void cI(boolean z) {
        if (z) {
            this.aRS.setVisibility(8);
            this.aRU.setVisibility(8);
            this.mInputControl.setVisibility(0);
            this.aRV.setVisibility(8);
            return;
        }
        this.aRS.setVisibility(0);
        this.aRU.setVisibility(0);
        this.mInputControl.setVisibility(8);
        this.aRV.setVisibility(0);
    }

    public ao[] KA() {
        return this.aRY;
    }

    public void P(List<com.baidu.tieba.im.data.f> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.f fVar = list.get(i);
                this.aRY[i].aSe.setText(fVar.getName());
                if (fVar.Ms() != 0) {
                    this.aRY[i].aSf.setVisibility(8);
                }
            }
        }
    }

    public void cJ(boolean z) {
        this.aRW.setVisibility(z ? 0 : 8);
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
        ao aoVar = this.aRY[i];
        if (z) {
            aoVar.aSf.setImageResource(com.baidu.tieba.u.icon_bottombar_arrow_s);
        } else {
            aoVar.aSf.setImageResource(com.baidu.tieba.u.icon_bottombar_arrow_n);
        }
    }

    public int L(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.aRY[i].aSd) {
                return i;
            }
        }
        return 0;
    }

    public ImageView KB() {
        return this.aRT;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }
}
