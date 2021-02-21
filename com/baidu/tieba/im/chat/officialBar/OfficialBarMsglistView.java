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
/* loaded from: classes8.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout joH;
    private TextView kAm;
    private ImageView kDl;
    private LinearLayout kDm;
    private LinearLayout kDn;
    private OfficialSecondMenuPopupWindow kDo;
    private a[] kDp;
    private boolean kDq;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.kDq = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.kAm = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.kAm.setText(string);
        }
        this.joH = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.joH.setVisibility(0);
        this.kDl = (ImageView) this.joH.findViewById(R.id.official_bar_toggle_button);
        this.kDl.setVisibility(0);
        this.kDp = new a[3];
        a aVar = new a();
        aVar.bzt = false;
        aVar.kDu = (LinearLayout) this.joH.findViewById(R.id.menu_frist);
        aVar.kDv = (TextView) this.joH.findViewById(R.id.menu_frist_text);
        aVar.kDw = (ImageView) this.joH.findViewById(R.id.menu_frist_tip);
        this.kDp[0] = aVar;
        a aVar2 = new a();
        aVar2.bzt = false;
        aVar2.kDu = (LinearLayout) this.joH.findViewById(R.id.menu_second);
        aVar2.kDv = (TextView) this.joH.findViewById(R.id.menu_second_text);
        aVar2.kDw = (ImageView) this.joH.findViewById(R.id.menu_second_tip);
        this.kDp[1] = aVar2;
        a aVar3 = new a();
        aVar3.bzt = false;
        aVar3.kDu = (LinearLayout) this.joH.findViewById(R.id.menu_third);
        aVar3.kDv = (TextView) this.joH.findViewById(R.id.menu_third_text);
        aVar3.kDw = (ImageView) this.joH.findViewById(R.id.menu_third_tip);
        this.kDp[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.kDp[i].kDu.setOnClickListener(talkableActivity);
        }
        this.kDm = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.kDm.setVisibility(0);
        this.kDn = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.kDn.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.kDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.sI(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.kDo = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.kDo);
        this.kDo.setVisibility(8);
        this.kDo.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.kDq = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.CAM_X0207);
        this.mTool.setMoreDeskBgColorId(R.color.CAM_X0207);
        this.mTool.kN(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (m) runTask.getData();
            if (this.mSendTool.fBo != null && (this.mSendTool.fBo instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.fBo;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.fCh = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.bG(arrayList);
        m qU = this.mTool.qU(5);
        if (qU != null) {
            qU.fCh = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.fBo != null && (aVar.fBo instanceof EditText)) {
            ((EditText) aVar.fBo).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.kDq) {
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
        if (this.kDq) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.sI(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cVb() {
        return this.kDo;
    }

    public void aj(boolean z, boolean z2) {
        if (this.kDq != z) {
            if (!this.kDq) {
                this.mTool.kP(false);
                return;
            }
            this.joH.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.kDm.setVisibility(0);
            return;
        }
        this.kDq = !z;
        if (z) {
            this.joH.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.kP(true);
                } else {
                    this.mTool.kP(false);
                }
            }
            this.kDm.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.joH.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.kDm.setVisibility(0);
    }

    public a[] cVc() {
        return this.kDp;
    }

    public void ep(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.kDp[i].kDv.setText(bVar.getName());
                if (bVar.cVr() != 0) {
                    this.kDp[i].kDw.setVisibility(8);
                }
            }
        }
    }

    public void sH(boolean z) {
        this.kDn.setVisibility(z ? 0 : 8);
    }

    public void sI(final boolean z) {
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
                    OfficialBarMsglistView.this.joH.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.joH.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.kDp[i];
                        if (aVar.bzt) {
                            aVar.bzt = false;
                            OfficialBarMsglistView.this.Z(i, aVar.bzt);
                            OfficialBarMsglistView.this.kDo.UU();
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
        a aVar = this.kDp[i];
        if (z) {
            aVar.kDw.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.kDv.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0302));
            return;
        }
        aVar.kDw.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.kDv.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
    }

    public int dn(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.kDp[i].kDu) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        boolean bzt;
        LinearLayout kDu;
        TextView kDv;
        ImageView kDw;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void CK(int i) {
        if (this.kAm != null) {
            this.kAm.setText(i);
        }
    }

    public void cVd() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.kAm, R.color.CAM_X0302, 1);
    }
}
