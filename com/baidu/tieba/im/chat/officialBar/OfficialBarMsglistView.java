package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private TextView evk;
    private ImageView eyr;
    private LinearLayout eys;
    private LinearLayout eyt;
    private LinearLayout eyu;
    private com.baidu.tieba.im.view.a eyv;
    private a[] eyw;
    private boolean eyx;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eyx = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(d.j.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.evk = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.evk.setText(string);
        }
        this.eys = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_memu_stub)).inflate();
        this.eys.setVisibility(0);
        this.eyr = (ImageView) this.eys.findViewById(d.g.official_bar_toggle_button);
        this.eyr.setVisibility(0);
        this.eyw = new a[3];
        a aVar = new a();
        aVar.eyB = false;
        aVar.eyC = (LinearLayout) this.eys.findViewById(d.g.menu_frist);
        aVar.eyD = (TextView) this.eys.findViewById(d.g.menu_frist_text);
        aVar.eyE = (ImageView) this.eys.findViewById(d.g.menu_frist_tip);
        this.eyw[0] = aVar;
        a aVar2 = new a();
        aVar2.eyB = false;
        aVar2.eyC = (LinearLayout) this.eys.findViewById(d.g.menu_second);
        aVar2.eyD = (TextView) this.eys.findViewById(d.g.menu_second_text);
        aVar2.eyE = (ImageView) this.eys.findViewById(d.g.menu_second_tip);
        this.eyw[1] = aVar2;
        a aVar3 = new a();
        aVar3.eyB = false;
        aVar3.eyC = (LinearLayout) this.eys.findViewById(d.g.menu_third);
        aVar3.eyD = (TextView) this.eys.findViewById(d.g.menu_third_text);
        aVar3.eyE = (ImageView) this.eys.findViewById(d.g.menu_third_tip);
        this.eyw[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.eyw[i].eyC.setOnClickListener(talkableActivity);
        }
        this.eyt = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_memu_down_line)).inflate();
        this.eyt.setVisibility(0);
        this.eyu = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_menu_loading)).inflate();
        this.eyu.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.eyr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.hn(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.eyv = new com.baidu.tieba.im.view.a(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.eyv);
        this.eyv.setVisibility(8);
        this.eyv.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.eyx = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new com.baidu.tbadk.editortools.i(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(d.C0141d.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(d.C0141d.cp_bg_line_c);
        this.mTool.cf(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, r.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (r) runTask.getData();
            if (this.mSendTool.bsm != null && (this.mSendTool.bsm instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.bsm;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.btb = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.K(arrayList);
        r hI = this.mTool.hI(5);
        if (hI != null) {
            hI.btb = 3;
            hI.bsZ = d.f.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.bsm != null && (aVar.bsm instanceof EditText)) {
            ((EditText) aVar.bsm).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(d.e.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(d.j.send_msg);
        this.mTool.b(aVar2);
        if (this.eyx) {
            this.mTool.b(new b(talkableActivity.getActivity()));
        }
        this.mTool.Ld();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.a(24, this.mActionListener);
        this.mTool.a(8, this.mActionListener);
        this.mTool.a(4, this.mActionListener);
        this.mTool.a(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.eyx) {
            this.mTool.a(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.hn(true);
                }
            });
        }
    }

    public com.baidu.tieba.im.view.a aGk() {
        return this.eyv;
    }

    public void F(boolean z, boolean z2) {
        if (this.eyx != z) {
            if (!this.eyx) {
                this.mTool.ch(false);
                return;
            }
            this.eys.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.eyt.setVisibility(0);
            return;
        }
        this.eyx = !z;
        if (z) {
            this.eys.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.ch(true);
                } else {
                    this.mTool.ch(false);
                }
            }
            this.eyt.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.eys.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.eyt.setVisibility(0);
    }

    public a[] aGl() {
        return this.eyw;
    }

    public void bY(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.eyw[i].eyD.setText(bVar.getName());
                if (bVar.aHR() != 0) {
                    this.eyw[i].eyE.setVisibility(8);
                }
            }
        }
    }

    public void hm(boolean z) {
        this.eyu.setVisibility(z ? 0 : 8);
    }

    public void hn(final boolean z) {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), d.a.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), d.a.parent_menu_down);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z) {
                    OfficialBarMsglistView.this.eys.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.eys.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.th();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.eyw[i];
                        if (aVar.eyB) {
                            aVar.eyB = false;
                            OfficialBarMsglistView.this.K(i, aVar.eyB);
                            OfficialBarMsglistView.this.eyv.asK();
                        }
                    }
                }
                OfficialBarMsglistView.this.getLayoutBottom().startAnimation(loadAnimation);
            }
        });
        sendmsgCloseSoftkey();
        if (isMoreVisible()) {
            hideMore();
        }
        getLayoutBottom().startAnimation(loadAnimation2);
    }

    public void K(int i, boolean z) {
        a aVar = this.eyw[i];
        if (z) {
            aVar.eyE.setImageResource(d.f.icon_bottombar_arrow_s);
            aVar.eyD.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_link_tip_a));
            return;
        }
        aVar.eyE.setImageResource(d.f.icon_bottombar_arrow_n);
        aVar.eyD.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_f));
    }

    public int cb(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.eyw[i].eyC) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean eyB;
        LinearLayout eyC;
        TextView eyD;
        ImageView eyE;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void pL(int i) {
        if (this.evk != null) {
            this.evk.setText(i);
        }
    }

    public void aGm() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.e(this.evk, d.C0141d.cp_link_tip_a, 1);
    }
}
