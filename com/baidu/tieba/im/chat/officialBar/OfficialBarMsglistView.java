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
/* loaded from: classes13.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout guZ;
    private TextView hrD;
    private ImageView huD;
    private LinearLayout huE;
    private LinearLayout huF;
    private OfficialSecondMenuPopupWindow huG;
    private a[] huH;
    private boolean huI;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.huI = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.hrD = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.hrD.setText(string);
        }
        this.guZ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.guZ.setVisibility(0);
        this.huD = (ImageView) this.guZ.findViewById(R.id.official_bar_toggle_button);
        this.huD.setVisibility(0);
        this.huH = new a[3];
        a aVar = new a();
        aVar.huM = false;
        aVar.huN = (LinearLayout) this.guZ.findViewById(R.id.menu_frist);
        aVar.huO = (TextView) this.guZ.findViewById(R.id.menu_frist_text);
        aVar.huP = (ImageView) this.guZ.findViewById(R.id.menu_frist_tip);
        this.huH[0] = aVar;
        a aVar2 = new a();
        aVar2.huM = false;
        aVar2.huN = (LinearLayout) this.guZ.findViewById(R.id.menu_second);
        aVar2.huO = (TextView) this.guZ.findViewById(R.id.menu_second_text);
        aVar2.huP = (ImageView) this.guZ.findViewById(R.id.menu_second_tip);
        this.huH[1] = aVar2;
        a aVar3 = new a();
        aVar3.huM = false;
        aVar3.huN = (LinearLayout) this.guZ.findViewById(R.id.menu_third);
        aVar3.huO = (TextView) this.guZ.findViewById(R.id.menu_third_text);
        aVar3.huP = (ImageView) this.guZ.findViewById(R.id.menu_third_tip);
        this.huH[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.huH[i].huN.setOnClickListener(talkableActivity);
        }
        this.huE = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.huE.setVisibility(0);
        this.huF = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.huF.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.huD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.nj(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.huG = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.huG);
        this.huG.setVisibility(8);
        this.huG.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.huI = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.gB(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, l.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (l) runTask.getData();
            if (this.mSendTool.dwz != null && (this.mSendTool.dwz instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.dwz;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.dxp = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.aI(arrayList);
        l mp = this.mTool.mp(5);
        if (mp != null) {
            mp.dxp = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.dwz != null && (aVar.dwz instanceof EditText)) {
            ((EditText) aVar.dwz).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.huI) {
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
        if (this.huI) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.nj(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow bSx() {
        return this.huG;
    }

    public void V(boolean z, boolean z2) {
        if (this.huI != z) {
            if (!this.huI) {
                this.mTool.gD(false);
                return;
            }
            this.guZ.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.huE.setVisibility(0);
            return;
        }
        this.huI = !z;
        if (z) {
            this.guZ.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.gD(true);
                } else {
                    this.mTool.gD(false);
                }
            }
            this.huE.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.guZ.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.huE.setVisibility(0);
    }

    public a[] bSy() {
        return this.huH;
    }

    public void cN(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.huH[i].huO.setText(bVar.getName());
                if (bVar.bUb() != 0) {
                    this.huH[i].huP.setVisibility(8);
                }
            }
        }
    }

    public void ni(boolean z) {
        this.huF.setVisibility(z ? 0 : 8);
    }

    public void nj(final boolean z) {
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
                    OfficialBarMsglistView.this.guZ.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.guZ.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.huH[i];
                        if (aVar.huM) {
                            aVar.huM = false;
                            OfficialBarMsglistView.this.J(i, aVar.huM);
                            OfficialBarMsglistView.this.huG.AR();
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

    public void J(int i, boolean z) {
        a aVar = this.huH[i];
        if (z) {
            aVar.huP.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.huO.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.huP.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.huO.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cf(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.huH[i].huN) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        boolean huM;
        LinearLayout huN;
        TextView huO;
        ImageView huP;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void wd(int i) {
        if (this.hrD != null) {
            this.hrD.setText(i);
        }
    }

    public void bSz() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.hrD, R.color.cp_link_tip_a, 1);
    }
}
