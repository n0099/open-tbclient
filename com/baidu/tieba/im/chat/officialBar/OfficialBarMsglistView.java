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
    private LinearLayout htW;
    private TextView irT;
    private ImageView iuT;
    private LinearLayout iuU;
    private LinearLayout iuV;
    private OfficialSecondMenuPopupWindow iuW;
    private a[] iuX;
    private boolean iuY;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.iuY = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.irT = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.irT.setText(string);
        }
        this.htW = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.htW.setVisibility(0);
        this.iuT = (ImageView) this.htW.findViewById(R.id.official_bar_toggle_button);
        this.iuT.setVisibility(0);
        this.iuX = new a[3];
        a aVar = new a();
        aVar.ivc = false;
        aVar.ivd = (LinearLayout) this.htW.findViewById(R.id.menu_frist);
        aVar.ive = (TextView) this.htW.findViewById(R.id.menu_frist_text);
        aVar.ivf = (ImageView) this.htW.findViewById(R.id.menu_frist_tip);
        this.iuX[0] = aVar;
        a aVar2 = new a();
        aVar2.ivc = false;
        aVar2.ivd = (LinearLayout) this.htW.findViewById(R.id.menu_second);
        aVar2.ive = (TextView) this.htW.findViewById(R.id.menu_second_text);
        aVar2.ivf = (ImageView) this.htW.findViewById(R.id.menu_second_tip);
        this.iuX[1] = aVar2;
        a aVar3 = new a();
        aVar3.ivc = false;
        aVar3.ivd = (LinearLayout) this.htW.findViewById(R.id.menu_third);
        aVar3.ive = (TextView) this.htW.findViewById(R.id.menu_third_text);
        aVar3.ivf = (ImageView) this.htW.findViewById(R.id.menu_third_tip);
        this.iuX[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.iuX[i].ivd.setOnClickListener(talkableActivity);
        }
        this.iuU = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.iuU.setVisibility(0);
        this.iuV = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.iuV.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.iuT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.oP(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.iuW = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.iuW);
        this.iuW.setVisibility(8);
        this.iuW.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.iuY = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.hW(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, l.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (l) runTask.getData();
            if (this.mSendTool.ekV != null && (this.mSendTool.ekV instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.ekV;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.elL = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.aM(arrayList);
        l nf = this.mTool.nf(5);
        if (nf != null) {
            nf.elL = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.ekV != null && (aVar.ekV instanceof EditText)) {
            ((EditText) aVar.ekV).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.iuY) {
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
        if (this.iuY) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.oP(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cjO() {
        return this.iuW;
    }

    public void Y(boolean z, boolean z2) {
        if (this.iuY != z) {
            if (!this.iuY) {
                this.mTool.hY(false);
                return;
            }
            this.htW.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.iuU.setVisibility(0);
            return;
        }
        this.iuY = !z;
        if (z) {
            this.htW.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.hY(true);
                } else {
                    this.mTool.hY(false);
                }
            }
            this.iuU.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.htW.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.iuU.setVisibility(0);
    }

    public a[] cjP() {
        return this.iuX;
    }

    public void cW(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.iuX[i].ive.setText(bVar.getName());
                if (bVar.clt() != 0) {
                    this.iuX[i].ivf.setVisibility(8);
                }
            }
        }
    }

    public void oO(boolean z) {
        this.iuV.setVisibility(z ? 0 : 8);
    }

    public void oP(final boolean z) {
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
                    OfficialBarMsglistView.this.htW.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.htW.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.iuX[i];
                        if (aVar.ivc) {
                            aVar.ivc = false;
                            OfficialBarMsglistView.this.S(i, aVar.ivc);
                            OfficialBarMsglistView.this.iuW.HQ();
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

    public void S(int i, boolean z) {
        a aVar = this.iuX[i];
        if (z) {
            aVar.ivf.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.ive.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.ivf.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.ive.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cn(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.iuX[i].ivd) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        boolean ivc;
        LinearLayout ivd;
        TextView ive;
        ImageView ivf;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void xp(int i) {
        if (this.irT != null) {
            this.irT.setText(i);
        }
    }

    public void cjQ() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.irT, R.color.cp_link_tip_a, 1);
    }
}
