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
    private LinearLayout gvn;
    private TextView hrR;
    private ImageView huR;
    private LinearLayout huS;
    private LinearLayout huT;
    private OfficialSecondMenuPopupWindow huU;
    private a[] huV;
    private boolean huW;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.huW = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.hrR = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.hrR.setText(string);
        }
        this.gvn = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.gvn.setVisibility(0);
        this.huR = (ImageView) this.gvn.findViewById(R.id.official_bar_toggle_button);
        this.huR.setVisibility(0);
        this.huV = new a[3];
        a aVar = new a();
        aVar.hva = false;
        aVar.hvb = (LinearLayout) this.gvn.findViewById(R.id.menu_frist);
        aVar.hvc = (TextView) this.gvn.findViewById(R.id.menu_frist_text);
        aVar.hvd = (ImageView) this.gvn.findViewById(R.id.menu_frist_tip);
        this.huV[0] = aVar;
        a aVar2 = new a();
        aVar2.hva = false;
        aVar2.hvb = (LinearLayout) this.gvn.findViewById(R.id.menu_second);
        aVar2.hvc = (TextView) this.gvn.findViewById(R.id.menu_second_text);
        aVar2.hvd = (ImageView) this.gvn.findViewById(R.id.menu_second_tip);
        this.huV[1] = aVar2;
        a aVar3 = new a();
        aVar3.hva = false;
        aVar3.hvb = (LinearLayout) this.gvn.findViewById(R.id.menu_third);
        aVar3.hvc = (TextView) this.gvn.findViewById(R.id.menu_third_text);
        aVar3.hvd = (ImageView) this.gvn.findViewById(R.id.menu_third_tip);
        this.huV[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.huV[i].hvb.setOnClickListener(talkableActivity);
        }
        this.huS = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.huS.setVisibility(0);
        this.huT = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.huT.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.huR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
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
        this.huU = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.huU);
        this.huU.setVisibility(8);
        this.huU.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.huW = true;
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
            if (this.mSendTool.dwN != null && (this.mSendTool.dwN instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.dwN;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.dxD = 1;
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
            mp.dxD = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.dwN != null && (aVar.dwN instanceof EditText)) {
            ((EditText) aVar.dwN).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.huW) {
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
        if (this.huW) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.nj(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow bSA() {
        return this.huU;
    }

    public void V(boolean z, boolean z2) {
        if (this.huW != z) {
            if (!this.huW) {
                this.mTool.gD(false);
                return;
            }
            this.gvn.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.huS.setVisibility(0);
            return;
        }
        this.huW = !z;
        if (z) {
            this.gvn.setVisibility(8);
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
            this.huS.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.gvn.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.huS.setVisibility(0);
    }

    public a[] bSB() {
        return this.huV;
    }

    public void cN(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.huV[i].hvc.setText(bVar.getName());
                if (bVar.bUe() != 0) {
                    this.huV[i].hvd.setVisibility(8);
                }
            }
        }
    }

    public void ni(boolean z) {
        this.huT.setVisibility(z ? 0 : 8);
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
                    OfficialBarMsglistView.this.gvn.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.gvn.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.huV[i];
                        if (aVar.hva) {
                            aVar.hva = false;
                            OfficialBarMsglistView.this.J(i, aVar.hva);
                            OfficialBarMsglistView.this.huU.AT();
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
        a aVar = this.huV[i];
        if (z) {
            aVar.hvd.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.hvc.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.hvd.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.hvc.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cf(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.huV[i].hvb) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        boolean hva;
        LinearLayout hvb;
        TextView hvc;
        ImageView hvd;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void wd(int i) {
        if (this.hrR != null) {
            this.hrR.setText(i);
        }
    }

    public void bSC() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.hrR, R.color.cp_link_tip_a, 1);
    }
}
