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
    private LinearLayout aZm;
    private ImageView aZn;
    private LinearLayout aZo;
    private LinearLayout aZp;
    private LinearLayout aZq;
    private com.baidu.tieba.im.view.a aZr;
    private ai[] aZs;
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
        this.aZm = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_toggle_stub)).inflate();
        this.aZn = (ImageView) this.aZm.findViewById(com.baidu.tieba.v.official_bar_toggle_button);
        this.aZn.setVisibility(0);
        this.aZo = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_stub)).inflate();
        this.aZo.setVisibility(0);
        this.aZs = new ai[3];
        ai aiVar = new ai();
        aiVar.aZw = false;
        aiVar.aZx = (LinearLayout) this.aZo.findViewById(com.baidu.tieba.v.menu_frist);
        aiVar.aZy = (TextView) this.aZo.findViewById(com.baidu.tieba.v.menu_frist_text);
        aiVar.aZz = (ImageView) this.aZo.findViewById(com.baidu.tieba.v.menu_frist_tip);
        this.aZs[0] = aiVar;
        ai aiVar2 = new ai();
        aiVar2.aZw = false;
        aiVar2.aZx = (LinearLayout) this.aZo.findViewById(com.baidu.tieba.v.menu_second);
        aiVar2.aZy = (TextView) this.aZo.findViewById(com.baidu.tieba.v.menu_second_text);
        aiVar2.aZz = (ImageView) this.aZo.findViewById(com.baidu.tieba.v.menu_second_tip);
        this.aZs[1] = aiVar2;
        ai aiVar3 = new ai();
        aiVar3.aZw = false;
        aiVar3.aZx = (LinearLayout) this.aZo.findViewById(com.baidu.tieba.v.menu_third);
        aiVar3.aZy = (TextView) this.aZo.findViewById(com.baidu.tieba.v.menu_third_text);
        aiVar3.aZz = (ImageView) this.aZo.findViewById(com.baidu.tieba.v.menu_third_tip);
        this.aZs[2] = aiVar3;
        for (int i = 0; i < 3; i++) {
            this.aZs[i].aZx.setOnClickListener(talkableActivity);
        }
        this.aZp = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_down_line)).inflate();
        this.aZp.setVisibility(0);
        this.aZq = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_menu_loading)).inflate();
        this.aZq.setVisibility(8);
        this.mInputControl.setVisibility(8);
        this.aZn.setOnClickListener(talkableActivity);
        cu(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.aZr = new com.baidu.tieba.im.view.a(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.aZr);
        this.aZr.setVisibility(8);
        this.aZr.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
    }

    public com.baidu.tieba.im.view.a Ob() {
        return this.aZr;
    }

    public void cu(boolean z) {
        if (z) {
            this.aZm.setVisibility(8);
            this.aZo.setVisibility(8);
            this.mInputControl.setVisibility(0);
            this.aZp.setVisibility(8);
            return;
        }
        this.aZm.setVisibility(0);
        this.aZo.setVisibility(0);
        this.mInputControl.setVisibility(8);
        this.aZp.setVisibility(0);
    }

    public ai[] Oc() {
        return this.aZs;
    }

    public void aw(List<com.baidu.tieba.im.data.d> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.d dVar = list.get(i);
                this.aZs[i].aZy.setText(dVar.getName());
                if (dVar.PB() != 0) {
                    this.aZs[i].aZz.setVisibility(8);
                }
            }
        }
    }

    public void cv(boolean z) {
        this.aZq.setVisibility(z ? 0 : 8);
    }

    public void cw(boolean z) {
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
        ai aiVar = this.aZs[i];
        if (z) {
            aiVar.aZz.setImageResource(com.baidu.tieba.u.icon_bottombar_arrow_s);
            aiVar.aZy.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_link_tip_a));
            return;
        }
        aiVar.aZz.setImageResource(com.baidu.tieba.u.icon_bottombar_arrow_n);
        aiVar.aZy.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_f));
    }

    public int D(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.aZs[i].aZx) {
                return i;
            }
        }
        return 0;
    }

    public ImageView Od() {
        return this.aZn;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void fB(int i) {
        if (this.mGroupInfoBtnTxt != null) {
            this.mGroupInfoBtnTxt.setText(i);
        }
    }

    public void Oe() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }
}
