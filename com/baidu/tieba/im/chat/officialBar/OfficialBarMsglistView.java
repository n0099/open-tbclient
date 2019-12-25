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
/* loaded from: classes10.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout gpP;
    private TextView hmb;
    private ImageView hpb;
    private LinearLayout hpc;
    private LinearLayout hpd;
    private OfficialSecondMenuPopupWindow hpe;
    private a[] hpf;
    private boolean hpg;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.hpg = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.hmb = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.hmb.setText(string);
        }
        this.gpP = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.gpP.setVisibility(0);
        this.hpb = (ImageView) this.gpP.findViewById(R.id.official_bar_toggle_button);
        this.hpb.setVisibility(0);
        this.hpf = new a[3];
        a aVar = new a();
        aVar.hpk = false;
        aVar.hpl = (LinearLayout) this.gpP.findViewById(R.id.menu_frist);
        aVar.hpm = (TextView) this.gpP.findViewById(R.id.menu_frist_text);
        aVar.hpn = (ImageView) this.gpP.findViewById(R.id.menu_frist_tip);
        this.hpf[0] = aVar;
        a aVar2 = new a();
        aVar2.hpk = false;
        aVar2.hpl = (LinearLayout) this.gpP.findViewById(R.id.menu_second);
        aVar2.hpm = (TextView) this.gpP.findViewById(R.id.menu_second_text);
        aVar2.hpn = (ImageView) this.gpP.findViewById(R.id.menu_second_tip);
        this.hpf[1] = aVar2;
        a aVar3 = new a();
        aVar3.hpk = false;
        aVar3.hpl = (LinearLayout) this.gpP.findViewById(R.id.menu_third);
        aVar3.hpm = (TextView) this.gpP.findViewById(R.id.menu_third_text);
        aVar3.hpn = (ImageView) this.gpP.findViewById(R.id.menu_third_tip);
        this.hpf[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.hpf[i].hpl.setOnClickListener(talkableActivity);
        }
        this.hpc = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.hpc.setVisibility(0);
        this.hpd = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.hpd.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.hpb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.mV(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.hpe = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.hpe);
        this.hpe.setVisibility(8);
        this.hpe.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.hpg = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.gp(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, l.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (l) runTask.getData();
            if (this.mSendTool.dsh != null && (this.mSendTool.dsh instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.dsh;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.dsY = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.aJ(arrayList);
        l lX = this.mTool.lX(5);
        if (lX != null) {
            lX.dsY = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.dsh != null && (aVar.dsh instanceof EditText)) {
            ((EditText) aVar.dsh).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.hpg) {
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
        if (this.hpg) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.mV(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow bPN() {
        return this.hpe;
    }

    public void T(boolean z, boolean z2) {
        if (this.hpg != z) {
            if (!this.hpg) {
                this.mTool.gr(false);
                return;
            }
            this.gpP.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.hpc.setVisibility(0);
            return;
        }
        this.hpg = !z;
        if (z) {
            this.gpP.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.gr(true);
                } else {
                    this.mTool.gr(false);
                }
            }
            this.hpc.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.gpP.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.hpc.setVisibility(0);
    }

    public a[] bPO() {
        return this.hpf;
    }

    public void cR(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.hpf[i].hpm.setText(bVar.getName());
                if (bVar.bRr() != 0) {
                    this.hpf[i].hpn.setVisibility(8);
                }
            }
        }
    }

    public void mU(boolean z) {
        this.hpd.setVisibility(z ? 0 : 8);
    }

    public void mV(final boolean z) {
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
                    OfficialBarMsglistView.this.gpP.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.gpP.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.lw();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.hpf[i];
                        if (aVar.hpk) {
                            aVar.hpk = false;
                            OfficialBarMsglistView.this.K(i, aVar.hpk);
                            OfficialBarMsglistView.this.hpe.yk();
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
        a aVar = this.hpf[i];
        if (z) {
            aVar.hpn.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.hpm.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.hpn.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.hpm.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int ca(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.hpf[i].hpl) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a {
        boolean hpk;
        LinearLayout hpl;
        TextView hpm;
        ImageView hpn;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void vS(int i) {
        if (this.hmb != null) {
            this.hmb.setText(i);
        }
    }

    public void bPP() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.hmb, R.color.cp_link_tip_a, 1);
    }
}
