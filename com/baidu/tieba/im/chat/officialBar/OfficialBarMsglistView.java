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
/* loaded from: classes7.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout jiM;
    private TextView krR;
    private ImageView kuR;
    private LinearLayout kuS;
    private LinearLayout kuT;
    private OfficialSecondMenuPopupWindow kuU;
    private a[] kuV;
    private boolean kuW;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.kuW = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.krR = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.krR.setText(string);
        }
        this.jiM = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.jiM.setVisibility(0);
        this.kuR = (ImageView) this.jiM.findViewById(R.id.official_bar_toggle_button);
        this.kuR.setVisibility(0);
        this.kuV = new a[3];
        a aVar = new a();
        aVar.bvR = false;
        aVar.kva = (LinearLayout) this.jiM.findViewById(R.id.menu_frist);
        aVar.kvb = (TextView) this.jiM.findViewById(R.id.menu_frist_text);
        aVar.kvc = (ImageView) this.jiM.findViewById(R.id.menu_frist_tip);
        this.kuV[0] = aVar;
        a aVar2 = new a();
        aVar2.bvR = false;
        aVar2.kva = (LinearLayout) this.jiM.findViewById(R.id.menu_second);
        aVar2.kvb = (TextView) this.jiM.findViewById(R.id.menu_second_text);
        aVar2.kvc = (ImageView) this.jiM.findViewById(R.id.menu_second_tip);
        this.kuV[1] = aVar2;
        a aVar3 = new a();
        aVar3.bvR = false;
        aVar3.kva = (LinearLayout) this.jiM.findViewById(R.id.menu_third);
        aVar3.kvb = (TextView) this.jiM.findViewById(R.id.menu_third_text);
        aVar3.kvc = (ImageView) this.jiM.findViewById(R.id.menu_third_tip);
        this.kuV[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.kuV[i].kva.setOnClickListener(talkableActivity);
        }
        this.kuS = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.kuS.setVisibility(0);
        this.kuT = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.kuT.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.kuR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.sv(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.kuU = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.kuU);
        this.kuU.setVisibility(8);
        this.kuU.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.kuW = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.CAM_X0207);
        this.mTool.setMoreDeskBgColorId(R.color.CAM_X0207);
        this.mTool.kK(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (m) runTask.getData();
            if (this.mSendTool.fyZ != null && (this.mSendTool.fyZ instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.fyZ;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.fzS = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.bL(arrayList);
        m qP = this.mTool.qP(5);
        if (qP != null) {
            qP.fzS = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.fyZ != null && (aVar.fyZ instanceof EditText)) {
            ((EditText) aVar.fyZ).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.kuW) {
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
        if (this.kuW) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.sv(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cSW() {
        return this.kuU;
    }

    public void aj(boolean z, boolean z2) {
        if (this.kuW != z) {
            if (!this.kuW) {
                this.mTool.kM(false);
                return;
            }
            this.jiM.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.kuS.setVisibility(0);
            return;
        }
        this.kuW = !z;
        if (z) {
            this.jiM.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.kM(true);
                } else {
                    this.mTool.kM(false);
                }
            }
            this.kuS.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.jiM.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.kuS.setVisibility(0);
    }

    public a[] cSX() {
        return this.kuV;
    }

    public void er(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.kuV[i].kvb.setText(bVar.getName());
                if (bVar.cTm() != 0) {
                    this.kuV[i].kvc.setVisibility(8);
                }
            }
        }
    }

    public void su(boolean z) {
        this.kuT.setVisibility(z ? 0 : 8);
    }

    public void sv(final boolean z) {
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
                    OfficialBarMsglistView.this.jiM.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.jiM.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.rV();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.kuV[i];
                        if (aVar.bvR) {
                            aVar.bvR = false;
                            OfficialBarMsglistView.this.Z(i, aVar.bvR);
                            OfficialBarMsglistView.this.kuU.Tn();
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
        a aVar = this.kuV[i];
        if (z) {
            aVar.kvc.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.kvb.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0302));
            return;
        }
        aVar.kvc.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.kvb.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
    }

    public int dp(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.kuV[i].kva) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a {
        boolean bvR;
        LinearLayout kva;
        TextView kvb;
        ImageView kvc;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void Cs(int i) {
        if (this.krR != null) {
            this.krR.setText(i);
        }
    }

    public void cSY() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setViewTextColor(this.krR, R.color.CAM_X0302, 1);
    }
}
