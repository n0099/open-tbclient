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
    private LinearLayout aUB;
    private ImageView aUC;
    private LinearLayout aUD;
    private LinearLayout aUE;
    private LinearLayout aUF;
    private com.baidu.tieba.im.view.k aUG;
    private ah[] aUH;
    private TextView mGroupInfoBtnTxt;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(com.baidu.tieba.z.msglist_officialInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.group_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.w.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        this.aUB = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.official_bar_memu_toggle_stub)).inflate();
        this.aUC = (ImageView) this.aUB.findViewById(com.baidu.tieba.w.official_bar_toggle_button);
        this.aUC.setVisibility(0);
        this.aUD = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.official_bar_memu_stub)).inflate();
        this.aUD.setVisibility(0);
        this.aUH = new ah[3];
        ah ahVar = new ah();
        ahVar.aUL = false;
        ahVar.aUM = (LinearLayout) this.aUD.findViewById(com.baidu.tieba.w.menu_frist);
        ahVar.aUN = (TextView) this.aUD.findViewById(com.baidu.tieba.w.menu_frist_text);
        ahVar.aUO = (ImageView) this.aUD.findViewById(com.baidu.tieba.w.menu_frist_tip);
        this.aUH[0] = ahVar;
        ah ahVar2 = new ah();
        ahVar2.aUL = false;
        ahVar2.aUM = (LinearLayout) this.aUD.findViewById(com.baidu.tieba.w.menu_second);
        ahVar2.aUN = (TextView) this.aUD.findViewById(com.baidu.tieba.w.menu_second_text);
        ahVar2.aUO = (ImageView) this.aUD.findViewById(com.baidu.tieba.w.menu_second_tip);
        this.aUH[1] = ahVar2;
        ah ahVar3 = new ah();
        ahVar3.aUL = false;
        ahVar3.aUM = (LinearLayout) this.aUD.findViewById(com.baidu.tieba.w.menu_third);
        ahVar3.aUN = (TextView) this.aUD.findViewById(com.baidu.tieba.w.menu_third_text);
        ahVar3.aUO = (ImageView) this.aUD.findViewById(com.baidu.tieba.w.menu_third_tip);
        this.aUH[2] = ahVar3;
        for (int i = 0; i < 3; i++) {
            this.aUH[i].aUM.setOnClickListener(talkableActivity);
        }
        this.aUE = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.official_bar_memu_down_line)).inflate();
        this.aUE.setVisibility(0);
        this.aUF = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.official_bar_menu_loading)).inflate();
        this.aUF.setVisibility(8);
        this.mInputControl.setVisibility(8);
        this.aUC.setOnClickListener(talkableActivity);
        cz(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.aUG = new com.baidu.tieba.im.view.k(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.aUG);
        this.aUG.setVisibility(8);
        this.aUG.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
    }

    public com.baidu.tieba.im.view.k La() {
        return this.aUG;
    }

    public void cz(boolean z) {
        if (z) {
            this.aUB.setVisibility(8);
            this.aUD.setVisibility(8);
            this.mInputControl.setVisibility(0);
            this.aUE.setVisibility(8);
            return;
        }
        this.aUB.setVisibility(0);
        this.aUD.setVisibility(0);
        this.mInputControl.setVisibility(8);
        this.aUE.setVisibility(0);
    }

    public ah[] Lb() {
        return this.aUH;
    }

    public void am(List<com.baidu.tieba.im.data.d> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.d dVar = list.get(i);
                this.aUH[i].aUN.setText(dVar.getName());
                if (dVar.MH() != 0) {
                    this.aUH[i].aUO.setVisibility(8);
                }
            }
        }
    }

    public void cA(boolean z) {
        this.aUF.setVisibility(z ? 0 : 8);
    }

    public void cB(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), com.baidu.tieba.q.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), com.baidu.tieba.q.parent_menu_down);
        loadAnimation2.setAnimationListener(new ag(this, z, loadAnimation));
        sendmsgCloseSoftkey();
        if (isMoreVisible()) {
            hideMore();
        }
        getLayoutBottom().startAnimation(loadAnimation2);
    }

    public void p(int i, boolean z) {
        ah ahVar = this.aUH[i];
        if (z) {
            ahVar.aUO.setImageResource(com.baidu.tieba.v.icon_bottombar_arrow_s);
            ahVar.aUN.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_link_tip_a));
            return;
        }
        ahVar.aUO.setImageResource(com.baidu.tieba.v.icon_bottombar_arrow_n);
        ahVar.aUN.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_f));
    }

    public int F(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.aUH[i].aUM) {
                return i;
            }
        }
        return 0;
    }

    public ImageView Lc() {
        return this.aUC;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void Ld() {
        if (this.mBtnGroupInfo != null) {
            this.mBtnGroupInfo.setVisibility(8);
        }
    }

    public void Le() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }
}
