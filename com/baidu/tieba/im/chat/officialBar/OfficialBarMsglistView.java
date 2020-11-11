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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout iPA;
    private TextView jUV;
    private LinearLayout jYA;
    private LinearLayout jYB;
    private OfficialSecondMenuPopupWindow jYC;
    private a[] jYD;
    private boolean jYE;
    private ImageView jYz;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jYE = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.jUV = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jUV.setText(string);
        }
        this.iPA = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.iPA.setVisibility(0);
        this.jYz = (ImageView) this.iPA.findViewById(R.id.official_bar_toggle_button);
        this.jYz.setVisibility(0);
        this.jYD = new a[3];
        a aVar = new a();
        aVar.bss = false;
        aVar.jYI = (LinearLayout) this.iPA.findViewById(R.id.menu_frist);
        aVar.jYJ = (TextView) this.iPA.findViewById(R.id.menu_frist_text);
        aVar.jYK = (ImageView) this.iPA.findViewById(R.id.menu_frist_tip);
        this.jYD[0] = aVar;
        a aVar2 = new a();
        aVar2.bss = false;
        aVar2.jYI = (LinearLayout) this.iPA.findViewById(R.id.menu_second);
        aVar2.jYJ = (TextView) this.iPA.findViewById(R.id.menu_second_text);
        aVar2.jYK = (ImageView) this.iPA.findViewById(R.id.menu_second_tip);
        this.jYD[1] = aVar2;
        a aVar3 = new a();
        aVar3.bss = false;
        aVar3.jYI = (LinearLayout) this.iPA.findViewById(R.id.menu_third);
        aVar3.jYJ = (TextView) this.iPA.findViewById(R.id.menu_third_text);
        aVar3.jYK = (ImageView) this.iPA.findViewById(R.id.menu_third_tip);
        this.jYD[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.jYD[i].jYI.setOnClickListener(talkableActivity);
        }
        this.jYA = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.jYA.setVisibility(0);
        this.jYB = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.jYB.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.jYz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.rB(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.jYC = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.jYC);
        this.jYC.setVisibility(8);
        this.jYC.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.jYE = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.kb(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (m) runTask.getData();
            if (this.mSendTool.fnp != null && (this.mSendTool.fnp instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.fnp;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.foi = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.bA(arrayList);
        m rk = this.mTool.rk(5);
        if (rk != null) {
            rk.foi = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.fnp != null && (aVar.fnp instanceof EditText)) {
            ((EditText) aVar.fnp).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.jYE) {
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
        if (this.jYE) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.rB(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cPg() {
        return this.jYC;
    }

    public void ai(boolean z, boolean z2) {
        if (this.jYE != z) {
            if (!this.jYE) {
                this.mTool.kd(false);
                return;
            }
            this.iPA.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.jYA.setVisibility(0);
            return;
        }
        this.jYE = !z;
        if (z) {
            this.iPA.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.kd(true);
                } else {
                    this.mTool.kd(false);
                }
            }
            this.jYA.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.iPA.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.jYA.setVisibility(0);
    }

    public a[] cPh() {
        return this.jYD;
    }

    public void dZ(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.jYD[i].jYJ.setText(bVar.getName());
                if (bVar.cQM() != 0) {
                    this.jYD[i].jYK.setVisibility(8);
                }
            }
        }
    }

    public void rA(boolean z) {
        this.jYB.setVisibility(z ? 0 : 8);
    }

    public void rB(final boolean z) {
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
                    OfficialBarMsglistView.this.iPA.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.iPA.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.jYD[i];
                        if (aVar.bss) {
                            aVar.bss = false;
                            OfficialBarMsglistView.this.aa(i, aVar.bss);
                            OfficialBarMsglistView.this.jYC.Um();
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

    public void aa(int i, boolean z) {
        a aVar = this.jYD[i];
        if (z) {
            aVar.jYK.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.jYJ.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.jYK.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.jYJ.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cT(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.jYD[i].jYI) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class a {
        boolean bss;
        LinearLayout jYI;
        TextView jYJ;
        ImageView jYK;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void CA(int i) {
        if (this.jUV != null) {
            this.jUV.setText(i);
        }
    }

    public void cPi() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.jUV, R.color.cp_link_tip_a, 1);
    }
}
