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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes8.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout jnt;
    private TextView kww;
    private a[] kzA;
    private boolean kzB;
    private ImageView kzw;
    private LinearLayout kzx;
    private LinearLayout kzy;
    private OfficialSecondMenuPopupWindow kzz;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.kzB = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.kww = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.kww.setText(string);
        }
        this.jnt = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.jnt.setVisibility(0);
        this.kzw = (ImageView) this.jnt.findViewById(R.id.official_bar_toggle_button);
        this.kzw.setVisibility(0);
        this.kzA = new a[3];
        a aVar = new a();
        aVar.bAD = false;
        aVar.kzF = (LinearLayout) this.jnt.findViewById(R.id.menu_frist);
        aVar.kzG = (TextView) this.jnt.findViewById(R.id.menu_frist_text);
        aVar.kzH = (ImageView) this.jnt.findViewById(R.id.menu_frist_tip);
        this.kzA[0] = aVar;
        a aVar2 = new a();
        aVar2.bAD = false;
        aVar2.kzF = (LinearLayout) this.jnt.findViewById(R.id.menu_second);
        aVar2.kzG = (TextView) this.jnt.findViewById(R.id.menu_second_text);
        aVar2.kzH = (ImageView) this.jnt.findViewById(R.id.menu_second_tip);
        this.kzA[1] = aVar2;
        a aVar3 = new a();
        aVar3.bAD = false;
        aVar3.kzF = (LinearLayout) this.jnt.findViewById(R.id.menu_third);
        aVar3.kzG = (TextView) this.jnt.findViewById(R.id.menu_third_text);
        aVar3.kzH = (ImageView) this.jnt.findViewById(R.id.menu_third_tip);
        this.kzA[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.kzA[i].kzF.setOnClickListener(talkableActivity);
        }
        this.kzx = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.kzx.setVisibility(0);
        this.kzy = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.kzy.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.kzw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.sz(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.kzz = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.kzz);
        this.kzz.setVisibility(8);
        this.kzz.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.kzB = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.CAM_X0207);
        this.mTool.setMoreDeskBgColorId(R.color.CAM_X0207);
        this.mTool.kO(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (m) runTask.getData();
            if (this.mSendTool.fDH != null && (this.mSendTool.fDH instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.fDH;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.fEA = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.bL(arrayList);
        m sv = this.mTool.sv(5);
        if (sv != null) {
            sv.fEA = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.fDH != null && (aVar.fDH instanceof EditText)) {
            ((EditText) aVar.fDH).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.kzB) {
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
        if (this.kzB) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.sz(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cWN() {
        return this.kzz;
    }

    public void aj(boolean z, boolean z2) {
        if (this.kzB != z) {
            if (!this.kzB) {
                this.mTool.kQ(false);
                return;
            }
            this.jnt.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.kzx.setVisibility(0);
            return;
        }
        this.kzB = !z;
        if (z) {
            this.jnt.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.kQ(true);
                } else {
                    this.mTool.kQ(false);
                }
            }
            this.kzx.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.jnt.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.kzx.setVisibility(0);
    }

    public a[] cWO() {
        return this.kzA;
    }

    public void er(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.kzA[i].kzG.setText(bVar.getName());
                if (bVar.cXd() != 0) {
                    this.kzA[i].kzH.setVisibility(8);
                }
            }
        }
    }

    public void sy(boolean z) {
        this.kzy.setVisibility(z ? 0 : 8);
    }

    public void sz(final boolean z) {
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
                    OfficialBarMsglistView.this.jnt.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.jnt.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.rV();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.kzA[i];
                        if (aVar.bAD) {
                            aVar.bAD = false;
                            OfficialBarMsglistView.this.Z(i, aVar.bAD);
                            OfficialBarMsglistView.this.kzz.Xf();
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

    public void Z(int i, boolean z) {
        a aVar = this.kzA[i];
        if (z) {
            aVar.kzH.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.kzG.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0302));
            return;
        }
        aVar.kzH.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.kzG.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
    }

    public int dp(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.kzA[i].kzF) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        boolean bAD;
        LinearLayout kzF;
        TextView kzG;
        ImageView kzH;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void DZ(int i) {
        if (this.kww != null) {
            this.kww.setText(i);
        }
    }

    public void cWP() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.kww, R.color.CAM_X0302, 1);
    }
}
