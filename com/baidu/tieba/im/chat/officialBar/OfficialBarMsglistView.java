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
/* loaded from: classes20.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout ibf;
    private TextView jeW;
    private ImageView jiD;
    private LinearLayout jiE;
    private LinearLayout jiF;
    private OfficialSecondMenuPopupWindow jiG;
    private a[] jiH;
    private boolean jiI;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jiI = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.jeW = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jeW.setText(string);
        }
        this.ibf = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.ibf.setVisibility(0);
        this.jiD = (ImageView) this.ibf.findViewById(R.id.official_bar_toggle_button);
        this.jiD.setVisibility(0);
        this.jiH = new a[3];
        a aVar = new a();
        aVar.biF = false;
        aVar.jiM = (LinearLayout) this.ibf.findViewById(R.id.menu_frist);
        aVar.jiN = (TextView) this.ibf.findViewById(R.id.menu_frist_text);
        aVar.jiO = (ImageView) this.ibf.findViewById(R.id.menu_frist_tip);
        this.jiH[0] = aVar;
        a aVar2 = new a();
        aVar2.biF = false;
        aVar2.jiM = (LinearLayout) this.ibf.findViewById(R.id.menu_second);
        aVar2.jiN = (TextView) this.ibf.findViewById(R.id.menu_second_text);
        aVar2.jiO = (ImageView) this.ibf.findViewById(R.id.menu_second_tip);
        this.jiH[1] = aVar2;
        a aVar3 = new a();
        aVar3.biF = false;
        aVar3.jiM = (LinearLayout) this.ibf.findViewById(R.id.menu_third);
        aVar3.jiN = (TextView) this.ibf.findViewById(R.id.menu_third_text);
        aVar3.jiO = (ImageView) this.ibf.findViewById(R.id.menu_third_tip);
        this.jiH[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.jiH[i].jiM.setOnClickListener(talkableActivity);
        }
        this.jiE = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.jiE.setVisibility(0);
        this.jiF = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.jiF.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.jiD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.qm(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.jiG = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.jiG);
        this.jiG.setVisibility(8);
        this.jiG.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.jiI = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.jj(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (m) runTask.getData();
            if (this.mSendTool.eKB != null && (this.mSendTool.eKB instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.eKB;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.eLu = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.bc(arrayList);
        m qe = this.mTool.qe(5);
        if (qe != null) {
            qe.eLu = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.eKB != null && (aVar.eKB instanceof EditText)) {
            ((EditText) aVar.eKB).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.jiI) {
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
        if (this.jiI) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.qm(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cCj() {
        return this.jiG;
    }

    public void ae(boolean z, boolean z2) {
        if (this.jiI != z) {
            if (!this.jiI) {
                this.mTool.jl(false);
                return;
            }
            this.ibf.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.jiE.setVisibility(0);
            return;
        }
        this.jiI = !z;
        if (z) {
            this.ibf.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.jl(true);
                } else {
                    this.mTool.jl(false);
                }
            }
            this.jiE.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.ibf.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.jiE.setVisibility(0);
    }

    public a[] cCk() {
        return this.jiH;
    }

    public void dx(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.jiH[i].jiN.setText(bVar.getName());
                if (bVar.cDP() != 0) {
                    this.jiH[i].jiO.setVisibility(8);
                }
            }
        }
    }

    public void ql(boolean z) {
        this.jiF.setVisibility(z ? 0 : 8);
    }

    public void qm(final boolean z) {
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
                    OfficialBarMsglistView.this.ibf.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.ibf.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.jiH[i];
                        if (aVar.biF) {
                            aVar.biF = false;
                            OfficialBarMsglistView.this.X(i, aVar.biF);
                            OfficialBarMsglistView.this.jiG.Pb();
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

    public void X(int i, boolean z) {
        a aVar = this.jiH[i];
        if (z) {
            aVar.jiO.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.jiN.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.jiO.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.jiN.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cx(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.jiH[i].jiM) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public static class a {
        boolean biF;
        LinearLayout jiM;
        TextView jiN;
        ImageView jiO;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void AN(int i) {
        if (this.jeW != null) {
            this.jeW.setText(i);
        }
    }

    public void cCl() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.jeW, R.color.cp_link_tip_a, 1);
    }
}
