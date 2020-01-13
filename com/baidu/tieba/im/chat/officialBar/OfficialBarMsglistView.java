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
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout gsY;
    private TextView hpE;
    private ImageView hsE;
    private LinearLayout hsF;
    private LinearLayout hsG;
    private OfficialSecondMenuPopupWindow hsH;
    private a[] hsI;
    private boolean hsJ;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.hsJ = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.hpE = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.hpE.setText(string);
        }
        this.gsY = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.gsY.setVisibility(0);
        this.hsE = (ImageView) this.gsY.findViewById(R.id.official_bar_toggle_button);
        this.hsE.setVisibility(0);
        this.hsI = new a[3];
        a aVar = new a();
        aVar.hsN = false;
        aVar.hsO = (LinearLayout) this.gsY.findViewById(R.id.menu_frist);
        aVar.hsP = (TextView) this.gsY.findViewById(R.id.menu_frist_text);
        aVar.hsQ = (ImageView) this.gsY.findViewById(R.id.menu_frist_tip);
        this.hsI[0] = aVar;
        a aVar2 = new a();
        aVar2.hsN = false;
        aVar2.hsO = (LinearLayout) this.gsY.findViewById(R.id.menu_second);
        aVar2.hsP = (TextView) this.gsY.findViewById(R.id.menu_second_text);
        aVar2.hsQ = (ImageView) this.gsY.findViewById(R.id.menu_second_tip);
        this.hsI[1] = aVar2;
        a aVar3 = new a();
        aVar3.hsN = false;
        aVar3.hsO = (LinearLayout) this.gsY.findViewById(R.id.menu_third);
        aVar3.hsP = (TextView) this.gsY.findViewById(R.id.menu_third_text);
        aVar3.hsQ = (ImageView) this.gsY.findViewById(R.id.menu_third_tip);
        this.hsI[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.hsI[i].hsO.setOnClickListener(talkableActivity);
        }
        this.hsF = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.hsF.setVisibility(0);
        this.hsG = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.hsG.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.hsE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.nh(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.hsH = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.hsH);
        this.hsH.setVisibility(8);
        this.hsH.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.hsJ = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.gu(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, l.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (l) runTask.getData();
            if (this.mSendTool.dss != null && (this.mSendTool.dss instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.dss;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.dtj = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.aI(arrayList);
        l lX = this.mTool.lX(5);
        if (lX != null) {
            lX.dtj = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.dss != null && (aVar.dss instanceof EditText)) {
            ((EditText) aVar.dss).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.hsJ) {
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
        if (this.hsJ) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.nh(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow bQW() {
        return this.hsH;
    }

    public void T(boolean z, boolean z2) {
        if (this.hsJ != z) {
            if (!this.hsJ) {
                this.mTool.gw(false);
                return;
            }
            this.gsY.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.hsF.setVisibility(0);
            return;
        }
        this.hsJ = !z;
        if (z) {
            this.gsY.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.gw(true);
                } else {
                    this.mTool.gw(false);
                }
            }
            this.hsF.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.gsY.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.hsF.setVisibility(0);
    }

    public a[] bQX() {
        return this.hsI;
    }

    public void cR(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.hsI[i].hsP.setText(bVar.getName());
                if (bVar.bSA() != 0) {
                    this.hsI[i].hsQ.setVisibility(8);
                }
            }
        }
    }

    public void ng(boolean z) {
        this.hsG.setVisibility(z ? 0 : 8);
    }

    public void nh(final boolean z) {
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
                    OfficialBarMsglistView.this.gsY.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.gsY.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.hsI[i];
                        if (aVar.hsN) {
                            aVar.hsN = false;
                            OfficialBarMsglistView.this.K(i, aVar.hsN);
                            OfficialBarMsglistView.this.hsH.yA();
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
        a aVar = this.hsI[i];
        if (z) {
            aVar.hsQ.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.hsP.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.hsQ.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.hsP.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cf(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.hsI[i].hsO) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a {
        boolean hsN;
        LinearLayout hsO;
        TextView hsP;
        ImageView hsQ;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void vX(int i) {
        if (this.hpE != null) {
            this.hpE.setText(i);
        }
    }

    public void bQY() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.hpE, R.color.cp_link_tip_a, 1);
    }
}
