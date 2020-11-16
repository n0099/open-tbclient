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
/* loaded from: classes25.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout iQn;
    private TextView jVF;
    private ImageView jZj;
    private LinearLayout jZk;
    private LinearLayout jZl;
    private OfficialSecondMenuPopupWindow jZm;
    private a[] jZn;
    private boolean jZo;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jZo = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.jVF = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jVF.setText(string);
        }
        this.iQn = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.iQn.setVisibility(0);
        this.jZj = (ImageView) this.iQn.findViewById(R.id.official_bar_toggle_button);
        this.jZj.setVisibility(0);
        this.jZn = new a[3];
        a aVar = new a();
        aVar.bqH = false;
        aVar.jZs = (LinearLayout) this.iQn.findViewById(R.id.menu_frist);
        aVar.jZt = (TextView) this.iQn.findViewById(R.id.menu_frist_text);
        aVar.jZu = (ImageView) this.iQn.findViewById(R.id.menu_frist_tip);
        this.jZn[0] = aVar;
        a aVar2 = new a();
        aVar2.bqH = false;
        aVar2.jZs = (LinearLayout) this.iQn.findViewById(R.id.menu_second);
        aVar2.jZt = (TextView) this.iQn.findViewById(R.id.menu_second_text);
        aVar2.jZu = (ImageView) this.iQn.findViewById(R.id.menu_second_tip);
        this.jZn[1] = aVar2;
        a aVar3 = new a();
        aVar3.bqH = false;
        aVar3.jZs = (LinearLayout) this.iQn.findViewById(R.id.menu_third);
        aVar3.jZt = (TextView) this.iQn.findViewById(R.id.menu_third_text);
        aVar3.jZu = (ImageView) this.iQn.findViewById(R.id.menu_third_tip);
        this.jZn[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.jZn[i].jZs.setOnClickListener(talkableActivity);
        }
        this.jZk = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.jZk.setVisibility(0);
        this.jZl = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.jZl.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.jZj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.rE(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.jZm = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.jZm);
        this.jZm.setVisibility(8);
        this.jZm.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.jZo = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.CAM_X0207);
        this.mTool.setMoreDeskBgColorId(R.color.CAM_X0207);
        this.mTool.kc(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (m) runTask.getData();
            if (this.mSendTool.fmx != null && (this.mSendTool.fmx instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.fmx;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.fnq = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.bA(arrayList);
        m rI = this.mTool.rI(5);
        if (rI != null) {
            rI.fnq = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.fmx != null && (aVar.fmx instanceof EditText)) {
            ((EditText) aVar.fmx).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.jZo) {
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
        if (this.jZo) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.rE(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cOM() {
        return this.jZm;
    }

    public void ai(boolean z, boolean z2) {
        if (this.jZo != z) {
            if (!this.jZo) {
                this.mTool.ke(false);
                return;
            }
            this.iQn.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.jZk.setVisibility(0);
            return;
        }
        this.jZo = !z;
        if (z) {
            this.iQn.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.ke(true);
                } else {
                    this.mTool.ke(false);
                }
            }
            this.jZk.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.iQn.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.jZk.setVisibility(0);
    }

    public a[] cON() {
        return this.jZn;
    }

    public void dZ(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.jZn[i].jZt.setText(bVar.getName());
                if (bVar.cQs() != 0) {
                    this.jZn[i].jZu.setVisibility(8);
                }
            }
        }
    }

    public void rD(boolean z) {
        this.jZl.setVisibility(z ? 0 : 8);
    }

    public void rE(final boolean z) {
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
                    OfficialBarMsglistView.this.iQn.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.iQn.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.jZn[i];
                        if (aVar.bqH) {
                            aVar.bqH = false;
                            OfficialBarMsglistView.this.aa(i, aVar.bqH);
                            OfficialBarMsglistView.this.jZm.TD();
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
        a aVar = this.jZn[i];
        if (z) {
            aVar.jZu.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.jZt.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0302));
            return;
        }
        aVar.jZu.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.jZt.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
    }

    public int cY(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.jZn[i].jZs) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static class a {
        boolean bqH;
        LinearLayout jZs;
        TextView jZt;
        ImageView jZu;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void CY(int i) {
        if (this.jVF != null) {
            this.jVF.setText(i);
        }
    }

    public void cOO() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.jVF, R.color.CAM_X0302, 1);
    }
}
