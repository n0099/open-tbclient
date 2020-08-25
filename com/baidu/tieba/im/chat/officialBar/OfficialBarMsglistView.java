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
    private LinearLayout iaZ;
    private TextView jeQ;
    private OfficialSecondMenuPopupWindow jiA;
    private a[] jiB;
    private boolean jiC;
    private ImageView jix;
    private LinearLayout jiy;
    private LinearLayout jiz;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jiC = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.jeQ = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jeQ.setText(string);
        }
        this.iaZ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.iaZ.setVisibility(0);
        this.jix = (ImageView) this.iaZ.findViewById(R.id.official_bar_toggle_button);
        this.jix.setVisibility(0);
        this.jiB = new a[3];
        a aVar = new a();
        aVar.biC = false;
        aVar.jiG = (LinearLayout) this.iaZ.findViewById(R.id.menu_frist);
        aVar.jiH = (TextView) this.iaZ.findViewById(R.id.menu_frist_text);
        aVar.jiI = (ImageView) this.iaZ.findViewById(R.id.menu_frist_tip);
        this.jiB[0] = aVar;
        a aVar2 = new a();
        aVar2.biC = false;
        aVar2.jiG = (LinearLayout) this.iaZ.findViewById(R.id.menu_second);
        aVar2.jiH = (TextView) this.iaZ.findViewById(R.id.menu_second_text);
        aVar2.jiI = (ImageView) this.iaZ.findViewById(R.id.menu_second_tip);
        this.jiB[1] = aVar2;
        a aVar3 = new a();
        aVar3.biC = false;
        aVar3.jiG = (LinearLayout) this.iaZ.findViewById(R.id.menu_third);
        aVar3.jiH = (TextView) this.iaZ.findViewById(R.id.menu_third_text);
        aVar3.jiI = (ImageView) this.iaZ.findViewById(R.id.menu_third_tip);
        this.jiB[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.jiB[i].jiG.setOnClickListener(talkableActivity);
        }
        this.jiy = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.jiy.setVisibility(0);
        this.jiz = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.jiz.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.jix.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.qk(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.jiA = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.jiA);
        this.jiA.setVisibility(8);
        this.jiA.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.jiC = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.jh(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (m) runTask.getData();
            if (this.mSendTool.eKx != null && (this.mSendTool.eKx instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.eKx;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.eLq = 1;
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
            qe.eLq = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.eKx != null && (aVar.eKx instanceof EditText)) {
            ((EditText) aVar.eKx).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.jiC) {
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
        if (this.jiC) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.qk(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cCi() {
        return this.jiA;
    }

    public void ae(boolean z, boolean z2) {
        if (this.jiC != z) {
            if (!this.jiC) {
                this.mTool.jj(false);
                return;
            }
            this.iaZ.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.jiy.setVisibility(0);
            return;
        }
        this.jiC = !z;
        if (z) {
            this.iaZ.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.jj(true);
                } else {
                    this.mTool.jj(false);
                }
            }
            this.jiy.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.iaZ.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.jiy.setVisibility(0);
    }

    public a[] cCj() {
        return this.jiB;
    }

    public void dx(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.jiB[i].jiH.setText(bVar.getName());
                if (bVar.cDO() != 0) {
                    this.jiB[i].jiI.setVisibility(8);
                }
            }
        }
    }

    public void qj(boolean z) {
        this.jiz.setVisibility(z ? 0 : 8);
    }

    public void qk(final boolean z) {
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
                    OfficialBarMsglistView.this.iaZ.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.iaZ.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.jiB[i];
                        if (aVar.biC) {
                            aVar.biC = false;
                            OfficialBarMsglistView.this.X(i, aVar.biC);
                            OfficialBarMsglistView.this.jiA.Pb();
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
        a aVar = this.jiB[i];
        if (z) {
            aVar.jiI.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.jiH.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.jiI.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.jiH.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cx(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.jiB[i].jiG) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public static class a {
        boolean biC;
        LinearLayout jiG;
        TextView jiH;
        ImageView jiI;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void AN(int i) {
        if (this.jeQ != null) {
            this.jeQ.setText(i);
        }
    }

    public void cCk() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.jeQ, R.color.cp_link_tip_a, 1);
    }
}
