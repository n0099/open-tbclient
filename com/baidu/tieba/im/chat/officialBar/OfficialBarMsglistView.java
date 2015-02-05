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
    private LinearLayout aUA;
    private ImageView aUB;
    private LinearLayout aUC;
    private LinearLayout aUD;
    private LinearLayout aUE;
    private com.baidu.tieba.im.view.k aUF;
    private ah[] aUG;
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
        this.aUA = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.official_bar_memu_toggle_stub)).inflate();
        this.aUB = (ImageView) this.aUA.findViewById(com.baidu.tieba.w.official_bar_toggle_button);
        this.aUB.setVisibility(0);
        this.aUC = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.official_bar_memu_stub)).inflate();
        this.aUC.setVisibility(0);
        this.aUG = new ah[3];
        ah ahVar = new ah();
        ahVar.aUK = false;
        ahVar.aUL = (LinearLayout) this.aUC.findViewById(com.baidu.tieba.w.menu_frist);
        ahVar.aUM = (TextView) this.aUC.findViewById(com.baidu.tieba.w.menu_frist_text);
        ahVar.aUN = (ImageView) this.aUC.findViewById(com.baidu.tieba.w.menu_frist_tip);
        this.aUG[0] = ahVar;
        ah ahVar2 = new ah();
        ahVar2.aUK = false;
        ahVar2.aUL = (LinearLayout) this.aUC.findViewById(com.baidu.tieba.w.menu_second);
        ahVar2.aUM = (TextView) this.aUC.findViewById(com.baidu.tieba.w.menu_second_text);
        ahVar2.aUN = (ImageView) this.aUC.findViewById(com.baidu.tieba.w.menu_second_tip);
        this.aUG[1] = ahVar2;
        ah ahVar3 = new ah();
        ahVar3.aUK = false;
        ahVar3.aUL = (LinearLayout) this.aUC.findViewById(com.baidu.tieba.w.menu_third);
        ahVar3.aUM = (TextView) this.aUC.findViewById(com.baidu.tieba.w.menu_third_text);
        ahVar3.aUN = (ImageView) this.aUC.findViewById(com.baidu.tieba.w.menu_third_tip);
        this.aUG[2] = ahVar3;
        for (int i = 0; i < 3; i++) {
            this.aUG[i].aUL.setOnClickListener(talkableActivity);
        }
        this.aUD = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.official_bar_memu_down_line)).inflate();
        this.aUD.setVisibility(0);
        this.aUE = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.official_bar_menu_loading)).inflate();
        this.aUE.setVisibility(8);
        this.mInputControl.setVisibility(8);
        this.aUB.setOnClickListener(talkableActivity);
        cz(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.aUF = new com.baidu.tieba.im.view.k(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.aUF);
        this.aUF.setVisibility(8);
        this.aUF.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
    }

    public com.baidu.tieba.im.view.k KV() {
        return this.aUF;
    }

    public void cz(boolean z) {
        if (z) {
            this.aUA.setVisibility(8);
            this.aUC.setVisibility(8);
            this.mInputControl.setVisibility(0);
            this.aUD.setVisibility(8);
            return;
        }
        this.aUA.setVisibility(0);
        this.aUC.setVisibility(0);
        this.mInputControl.setVisibility(8);
        this.aUD.setVisibility(0);
    }

    public ah[] KW() {
        return this.aUG;
    }

    public void am(List<com.baidu.tieba.im.data.d> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.d dVar = list.get(i);
                this.aUG[i].aUM.setText(dVar.getName());
                if (dVar.MC() != 0) {
                    this.aUG[i].aUN.setVisibility(8);
                }
            }
        }
    }

    public void cA(boolean z) {
        this.aUE.setVisibility(z ? 0 : 8);
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
        ah ahVar = this.aUG[i];
        if (z) {
            ahVar.aUN.setImageResource(com.baidu.tieba.v.icon_bottombar_arrow_s);
            ahVar.aUM.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_link_tip_a));
            return;
        }
        ahVar.aUN.setImageResource(com.baidu.tieba.v.icon_bottombar_arrow_n);
        ahVar.aUM.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_f));
    }

    public int F(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.aUG[i].aUL) {
                return i;
            }
        }
        return 0;
    }

    public ImageView KX() {
        return this.aUB;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void KY() {
        if (this.mBtnGroupInfo != null) {
            this.mBtnGroupInfo.setVisibility(8);
        }
    }

    public void KZ() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }
}
