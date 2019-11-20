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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout fBB;
    private ImageView gAW;
    private LinearLayout gAX;
    private LinearLayout gAY;
    private OfficialSecondMenuPopupWindow gAZ;
    private a[] gBa;
    private boolean gBb;
    private TextView gxS;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gBb = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.gxS = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.gxS.setText(string);
        }
        this.fBB = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.fBB.setVisibility(0);
        this.gAW = (ImageView) this.fBB.findViewById(R.id.official_bar_toggle_button);
        this.gAW.setVisibility(0);
        this.gBa = new a[3];
        a aVar = new a();
        aVar.gBf = false;
        aVar.gBg = (LinearLayout) this.fBB.findViewById(R.id.menu_frist);
        aVar.gBh = (TextView) this.fBB.findViewById(R.id.menu_frist_text);
        aVar.gBi = (ImageView) this.fBB.findViewById(R.id.menu_frist_tip);
        this.gBa[0] = aVar;
        a aVar2 = new a();
        aVar2.gBf = false;
        aVar2.gBg = (LinearLayout) this.fBB.findViewById(R.id.menu_second);
        aVar2.gBh = (TextView) this.fBB.findViewById(R.id.menu_second_text);
        aVar2.gBi = (ImageView) this.fBB.findViewById(R.id.menu_second_tip);
        this.gBa[1] = aVar2;
        a aVar3 = new a();
        aVar3.gBf = false;
        aVar3.gBg = (LinearLayout) this.fBB.findViewById(R.id.menu_third);
        aVar3.gBh = (TextView) this.fBB.findViewById(R.id.menu_third_text);
        aVar3.gBi = (ImageView) this.fBB.findViewById(R.id.menu_third_tip);
        this.gBa[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.gBa[i].gBg.setOnClickListener(talkableActivity);
        }
        this.gAX = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.gAX.setVisibility(0);
        this.gAY = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.gAY.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.gAW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.lH(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.gAZ = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.gAZ);
        this.gAZ.setVisibility(8);
        this.gAZ.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.gBb = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.fe(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.cEn != null && (this.mSendTool.cEn instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.cEn;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.cFe = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.aC(arrayList);
        k jK = this.mTool.jK(5);
        if (jK != null) {
            jK.cFe = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.cEn != null && (aVar.cEn instanceof EditText)) {
            ((EditText) aVar.cEn).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.gBb) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.build();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.gBb) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.lH(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow byv() {
        return this.gAZ;
    }

    public void U(boolean z, boolean z2) {
        if (this.gBb != z) {
            if (!this.gBb) {
                this.mTool.fg(false);
                return;
            }
            this.fBB.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.gAX.setVisibility(0);
            return;
        }
        this.gBb = !z;
        if (z) {
            this.fBB.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.fg(true);
                } else {
                    this.mTool.fg(false);
                }
            }
            this.gAX.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.fBB.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.gAX.setVisibility(0);
    }

    public a[] byw() {
        return this.gBa;
    }

    public void dc(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.gBa[i].gBh.setText(bVar.getName());
                if (bVar.bAb() != 0) {
                    this.gBa[i].gBi.setVisibility(8);
                }
            }
        }
    }

    public void lG(boolean z) {
        this.gAY.setVisibility(z ? 0 : 8);
    }

    public void lH(final boolean z) {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), R.anim.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), R.anim.parent_menu_down);
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
                    OfficialBarMsglistView.this.fBB.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.fBB.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.le();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.gBa[i];
                        if (aVar.gBf) {
                            aVar.gBf = false;
                            OfficialBarMsglistView.this.I(i, aVar.gBf);
                            OfficialBarMsglistView.this.gAZ.wm();
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

    public void I(int i, boolean z) {
        a aVar = this.gBa[i];
        if (z) {
            aVar.gBi.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.gBh.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.gBi.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.gBh.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int ce(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.gBa[i].gBg) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean gBf;
        LinearLayout gBg;
        TextView gBh;
        ImageView gBi;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void tQ(int i) {
        if (this.gxS != null) {
            this.gxS.setText(i);
        }
    }

    public void byx() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.gxS, R.color.cp_link_tip_a, 1);
    }
}
