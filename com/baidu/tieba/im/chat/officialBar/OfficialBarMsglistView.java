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
/* loaded from: classes26.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout jbe;
    private TextView kjk;
    private ImageView kmO;
    private LinearLayout kmP;
    private LinearLayout kmQ;
    private OfficialSecondMenuPopupWindow kmR;
    private a[] kmS;
    private boolean kmT;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.kmT = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.kjk = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.kjk.setText(string);
        }
        this.jbe = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.jbe.setVisibility(0);
        this.kmO = (ImageView) this.jbe.findViewById(R.id.official_bar_toggle_button);
        this.kmO.setVisibility(0);
        this.kmS = new a[3];
        a aVar = new a();
        aVar.bvS = false;
        aVar.kmX = (LinearLayout) this.jbe.findViewById(R.id.menu_frist);
        aVar.kmY = (TextView) this.jbe.findViewById(R.id.menu_frist_text);
        aVar.kmZ = (ImageView) this.jbe.findViewById(R.id.menu_frist_tip);
        this.kmS[0] = aVar;
        a aVar2 = new a();
        aVar2.bvS = false;
        aVar2.kmX = (LinearLayout) this.jbe.findViewById(R.id.menu_second);
        aVar2.kmY = (TextView) this.jbe.findViewById(R.id.menu_second_text);
        aVar2.kmZ = (ImageView) this.jbe.findViewById(R.id.menu_second_tip);
        this.kmS[1] = aVar2;
        a aVar3 = new a();
        aVar3.bvS = false;
        aVar3.kmX = (LinearLayout) this.jbe.findViewById(R.id.menu_third);
        aVar3.kmY = (TextView) this.jbe.findViewById(R.id.menu_third_text);
        aVar3.kmZ = (ImageView) this.jbe.findViewById(R.id.menu_third_tip);
        this.kmS[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.kmS[i].kmX.setOnClickListener(talkableActivity);
        }
        this.kmP = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.kmP.setVisibility(0);
        this.kmQ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.kmQ.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.kmO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.sg(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.kmR = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.kmR);
        this.kmR.setVisibility(8);
        this.kmR.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.kmT = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.CAM_X0207);
        this.mTool.setMoreDeskBgColorId(R.color.CAM_X0207);
        this.mTool.ks(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (m) runTask.getData();
            if (this.mSendTool.fub != null && (this.mSendTool.fub instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.fub;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.fuU = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.bE(arrayList);
        m sj = this.mTool.sj(5);
        if (sj != null) {
            sj.fuU = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.fub != null && (aVar.fub instanceof EditText)) {
            ((EditText) aVar.fub).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.kmT) {
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
        if (this.kmT) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.sg(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cUa() {
        return this.kmR;
    }

    public void ai(boolean z, boolean z2) {
        if (this.kmT != z) {
            if (!this.kmT) {
                this.mTool.ku(false);
                return;
            }
            this.jbe.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.kmP.setVisibility(0);
            return;
        }
        this.kmT = !z;
        if (z) {
            this.jbe.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.ku(true);
                } else {
                    this.mTool.ku(false);
                }
            }
            this.kmP.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.jbe.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.kmP.setVisibility(0);
    }

    public a[] cUb() {
        return this.kmS;
    }

    public void ek(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.kmS[i].kmY.setText(bVar.getName());
                if (bVar.cVG() != 0) {
                    this.kmS[i].kmZ.setVisibility(8);
                }
            }
        }
    }

    public void sf(boolean z) {
        this.kmQ.setVisibility(z ? 0 : 8);
    }

    public void sg(final boolean z) {
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
                    OfficialBarMsglistView.this.jbe.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.jbe.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.su();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.kmS[i];
                        if (aVar.bvS) {
                            aVar.bvS = false;
                            OfficialBarMsglistView.this.aa(i, aVar.bvS);
                            OfficialBarMsglistView.this.kmR.Wd();
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
        a aVar = this.kmS[i];
        if (z) {
            aVar.kmZ.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.kmY.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0302));
            return;
        }
        aVar.kmZ.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.kmY.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
    }

    public int df(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.kmS[i].kmX) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class a {
        boolean bvS;
        LinearLayout kmX;
        TextView kmY;
        ImageView kmZ;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void DN(int i) {
        if (this.kjk != null) {
            this.kjk.setText(i);
        }
    }

    public void cUc() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.kjk, R.color.CAM_X0302, 1);
    }
}
