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
    private LinearLayout aZC;
    private ImageView aZD;
    private LinearLayout aZE;
    private LinearLayout aZF;
    private LinearLayout aZG;
    private com.baidu.tieba.im.view.a aZH;
    private ai[] aZI;
    private TextView mGroupInfoBtnTxt;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(com.baidu.tieba.y.msglist_officialInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.group_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.v.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        this.aZC = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_toggle_stub)).inflate();
        this.aZD = (ImageView) this.aZC.findViewById(com.baidu.tieba.v.official_bar_toggle_button);
        this.aZD.setVisibility(0);
        this.aZE = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_stub)).inflate();
        this.aZE.setVisibility(0);
        this.aZI = new ai[3];
        ai aiVar = new ai();
        aiVar.aZM = false;
        aiVar.aZN = (LinearLayout) this.aZE.findViewById(com.baidu.tieba.v.menu_frist);
        aiVar.aZO = (TextView) this.aZE.findViewById(com.baidu.tieba.v.menu_frist_text);
        aiVar.aZP = (ImageView) this.aZE.findViewById(com.baidu.tieba.v.menu_frist_tip);
        this.aZI[0] = aiVar;
        ai aiVar2 = new ai();
        aiVar2.aZM = false;
        aiVar2.aZN = (LinearLayout) this.aZE.findViewById(com.baidu.tieba.v.menu_second);
        aiVar2.aZO = (TextView) this.aZE.findViewById(com.baidu.tieba.v.menu_second_text);
        aiVar2.aZP = (ImageView) this.aZE.findViewById(com.baidu.tieba.v.menu_second_tip);
        this.aZI[1] = aiVar2;
        ai aiVar3 = new ai();
        aiVar3.aZM = false;
        aiVar3.aZN = (LinearLayout) this.aZE.findViewById(com.baidu.tieba.v.menu_third);
        aiVar3.aZO = (TextView) this.aZE.findViewById(com.baidu.tieba.v.menu_third_text);
        aiVar3.aZP = (ImageView) this.aZE.findViewById(com.baidu.tieba.v.menu_third_tip);
        this.aZI[2] = aiVar3;
        for (int i = 0; i < 3; i++) {
            this.aZI[i].aZN.setOnClickListener(talkableActivity);
        }
        this.aZF = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_down_line)).inflate();
        this.aZF.setVisibility(0);
        this.aZG = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_menu_loading)).inflate();
        this.aZG.setVisibility(8);
        this.mInputControl.setVisibility(8);
        this.aZD.setOnClickListener(talkableActivity);
        cs(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.aZH = new com.baidu.tieba.im.view.a(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.aZH);
        this.aZH.setVisibility(8);
        this.aZH.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
    }

    public com.baidu.tieba.im.view.a Oo() {
        return this.aZH;
    }

    public void cs(boolean z) {
        if (z) {
            this.aZC.setVisibility(8);
            this.aZE.setVisibility(8);
            this.mInputControl.setVisibility(0);
            this.aZF.setVisibility(8);
            return;
        }
        this.aZC.setVisibility(0);
        this.aZE.setVisibility(0);
        this.mInputControl.setVisibility(8);
        this.aZF.setVisibility(0);
    }

    public ai[] Op() {
        return this.aZI;
    }

    public void ay(List<com.baidu.tieba.im.data.d> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.d dVar = list.get(i);
                this.aZI[i].aZO.setText(dVar.getName());
                if (dVar.PO() != 0) {
                    this.aZI[i].aZP.setVisibility(8);
                }
            }
        }
    }

    public void ct(boolean z) {
        this.aZG.setVisibility(z ? 0 : 8);
    }

    public void cu(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), com.baidu.tieba.p.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), com.baidu.tieba.p.parent_menu_down);
        loadAnimation2.setAnimationListener(new ah(this, z, loadAnimation));
        sendmsgCloseSoftkey();
        if (isMoreVisible()) {
            hideMore();
        }
        getLayoutBottom().startAnimation(loadAnimation2);
    }

    public void m(int i, boolean z) {
        ai aiVar = this.aZI[i];
        if (z) {
            aiVar.aZP.setImageResource(com.baidu.tieba.u.icon_bottombar_arrow_s);
            aiVar.aZO.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_link_tip_a));
            return;
        }
        aiVar.aZP.setImageResource(com.baidu.tieba.u.icon_bottombar_arrow_n);
        aiVar.aZO.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_f));
    }

    public int D(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.aZI[i].aZN) {
                return i;
            }
        }
        return 0;
    }

    public ImageView Oq() {
        return this.aZD;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void fD(int i) {
        if (this.mGroupInfoBtnTxt != null) {
            this.mGroupInfoBtnTxt.setText(i);
        }
    }

    public void Or() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }
}
