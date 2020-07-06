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
import com.baidu.tbadk.core.util.an;
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
    private LinearLayout hGX;
    private TextView iJM;
    private ImageView iMM;
    private LinearLayout iMN;
    private LinearLayout iMO;
    private OfficialSecondMenuPopupWindow iMP;
    private a[] iMQ;
    private boolean iMR;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.iMR = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.iJM = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.iJM.setText(string);
        }
        this.hGX = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.hGX.setVisibility(0);
        this.iMM = (ImageView) this.hGX.findViewById(R.id.official_bar_toggle_button);
        this.iMM.setVisibility(0);
        this.iMQ = new a[3];
        a aVar = new a();
        aVar.bcG = false;
        aVar.iMV = (LinearLayout) this.hGX.findViewById(R.id.menu_frist);
        aVar.iMW = (TextView) this.hGX.findViewById(R.id.menu_frist_text);
        aVar.iMX = (ImageView) this.hGX.findViewById(R.id.menu_frist_tip);
        this.iMQ[0] = aVar;
        a aVar2 = new a();
        aVar2.bcG = false;
        aVar2.iMV = (LinearLayout) this.hGX.findViewById(R.id.menu_second);
        aVar2.iMW = (TextView) this.hGX.findViewById(R.id.menu_second_text);
        aVar2.iMX = (ImageView) this.hGX.findViewById(R.id.menu_second_tip);
        this.iMQ[1] = aVar2;
        a aVar3 = new a();
        aVar3.bcG = false;
        aVar3.iMV = (LinearLayout) this.hGX.findViewById(R.id.menu_third);
        aVar3.iMW = (TextView) this.hGX.findViewById(R.id.menu_third_text);
        aVar3.iMX = (ImageView) this.hGX.findViewById(R.id.menu_third_tip);
        this.iMQ[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.iMQ[i].iMV.setOnClickListener(talkableActivity);
        }
        this.iMN = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.iMN.setVisibility(0);
        this.iMO = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.iMO.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.iMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.oZ(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.iMP = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.iMP);
        this.iMP.setVisibility(8);
        this.iMP.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.iMR = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.m32if(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, l.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (l) runTask.getData();
            if (this.mSendTool.etH != null && (this.mSendTool.etH instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.etH;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.euy = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.aW(arrayList);
        l nB = this.mTool.nB(5);
        if (nB != null) {
            nB.euy = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.etH != null && (aVar.etH instanceof EditText)) {
            ((EditText) aVar.etH).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.iMR) {
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
        if (this.iMR) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.oZ(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cnN() {
        return this.iMP;
    }

    public void Z(boolean z, boolean z2) {
        if (this.iMR != z) {
            if (!this.iMR) {
                this.mTool.ih(false);
                return;
            }
            this.hGX.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.iMN.setVisibility(0);
            return;
        }
        this.iMR = !z;
        if (z) {
            this.hGX.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.ih(true);
                } else {
                    this.mTool.ih(false);
                }
            }
            this.iMN.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.hGX.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.iMN.setVisibility(0);
    }

    public a[] cnO() {
        return this.iMQ;
    }

    public void dl(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.iMQ[i].iMW.setText(bVar.getName());
                if (bVar.cps() != 0) {
                    this.iMQ[i].iMX.setVisibility(8);
                }
            }
        }
    }

    public void oY(boolean z) {
        this.iMO.setVisibility(z ? 0 : 8);
    }

    public void oZ(final boolean z) {
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
                    OfficialBarMsglistView.this.hGX.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.hGX.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.iMQ[i];
                        if (aVar.bcG) {
                            aVar.bcG = false;
                            OfficialBarMsglistView.this.V(i, aVar.bcG);
                            OfficialBarMsglistView.this.iMP.Jd();
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

    public void V(int i, boolean z) {
        a aVar = this.iMQ[i];
        if (z) {
            aVar.iMX.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.iMW.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.iMX.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.iMW.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int co(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.iMQ[i].iMV) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        boolean bcG;
        LinearLayout iMV;
        TextView iMW;
        ImageView iMX;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void yb(int i) {
        if (this.iJM != null) {
            this.iJM.setText(i);
        }
    }

    public void cnP() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        an.setViewTextColor(this.iJM, R.color.cp_link_tip_a, 1);
    }
}
