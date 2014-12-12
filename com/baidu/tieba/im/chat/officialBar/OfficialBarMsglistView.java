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
    private LinearLayout aTl;
    private ImageView aTm;
    private LinearLayout aTn;
    private LinearLayout aTo;
    private LinearLayout aTp;
    private com.baidu.tieba.im.view.k aTq;
    private ah[] aTr;
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
        this.aTl = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.official_bar_memu_toggle_stub)).inflate();
        this.aTm = (ImageView) this.aTl.findViewById(com.baidu.tieba.w.official_bar_toggle_button);
        this.aTm.setVisibility(0);
        this.aTn = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.official_bar_memu_stub)).inflate();
        this.aTn.setVisibility(0);
        this.aTr = new ah[3];
        ah ahVar = new ah();
        ahVar.aTv = false;
        ahVar.aTw = (LinearLayout) this.aTn.findViewById(com.baidu.tieba.w.menu_frist);
        ahVar.aTx = (TextView) this.aTn.findViewById(com.baidu.tieba.w.menu_frist_text);
        ahVar.aTy = (ImageView) this.aTn.findViewById(com.baidu.tieba.w.menu_frist_tip);
        this.aTr[0] = ahVar;
        ah ahVar2 = new ah();
        ahVar2.aTv = false;
        ahVar2.aTw = (LinearLayout) this.aTn.findViewById(com.baidu.tieba.w.menu_second);
        ahVar2.aTx = (TextView) this.aTn.findViewById(com.baidu.tieba.w.menu_second_text);
        ahVar2.aTy = (ImageView) this.aTn.findViewById(com.baidu.tieba.w.menu_second_tip);
        this.aTr[1] = ahVar2;
        ah ahVar3 = new ah();
        ahVar3.aTv = false;
        ahVar3.aTw = (LinearLayout) this.aTn.findViewById(com.baidu.tieba.w.menu_third);
        ahVar3.aTx = (TextView) this.aTn.findViewById(com.baidu.tieba.w.menu_third_text);
        ahVar3.aTy = (ImageView) this.aTn.findViewById(com.baidu.tieba.w.menu_third_tip);
        this.aTr[2] = ahVar3;
        for (int i = 0; i < 3; i++) {
            this.aTr[i].aTw.setOnClickListener(talkableActivity);
        }
        this.aTo = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.official_bar_memu_down_line)).inflate();
        this.aTo.setVisibility(0);
        this.aTp = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.w.official_bar_menu_loading)).inflate();
        this.aTp.setVisibility(8);
        this.mInputControl.setVisibility(8);
        this.aTm.setOnClickListener(talkableActivity);
        cv(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.aTq = new com.baidu.tieba.im.view.k(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.aTq);
        this.aTq.setVisibility(8);
        this.aTq.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
    }

    public com.baidu.tieba.im.view.k KF() {
        return this.aTq;
    }

    public void cv(boolean z) {
        if (z) {
            this.aTl.setVisibility(8);
            this.aTn.setVisibility(8);
            this.mInputControl.setVisibility(0);
            this.aTo.setVisibility(8);
            return;
        }
        this.aTl.setVisibility(0);
        this.aTn.setVisibility(0);
        this.mInputControl.setVisibility(8);
        this.aTo.setVisibility(0);
    }

    public ah[] KG() {
        return this.aTr;
    }

    public void ak(List<com.baidu.tieba.im.data.c> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.c cVar = list.get(i);
                this.aTr[i].aTx.setText(cVar.getName());
                if (cVar.Ml() != 0) {
                    this.aTr[i].aTy.setVisibility(8);
                }
            }
        }
    }

    public void cw(boolean z) {
        this.aTp.setVisibility(z ? 0 : 8);
    }

    public void cx(boolean z) {
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
        ah ahVar = this.aTr[i];
        if (z) {
            ahVar.aTy.setImageResource(com.baidu.tieba.v.icon_bottombar_arrow_s);
            ahVar.aTx.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_link_tip_a));
            return;
        }
        ahVar.aTy.setImageResource(com.baidu.tieba.v.icon_bottombar_arrow_n);
        ahVar.aTx.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_f));
    }

    public int E(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.aTr[i].aTw) {
                return i;
            }
        }
        return 0;
    }

    public ImageView KH() {
        return this.aTm;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void KI() {
        if (this.mBtnGroupInfo != null) {
            this.mBtnGroupInfo.setVisibility(8);
        }
    }

    public void KJ() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }
}
