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
    private LinearLayout jot;
    private ImageView kCX;
    private LinearLayout kCY;
    private LinearLayout kCZ;
    private OfficialSecondMenuPopupWindow kDa;
    private a[] kDb;
    private boolean kDc;
    private TextView kzY;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.kDc = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.kzY = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.kzY.setText(string);
        }
        this.jot = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.jot.setVisibility(0);
        this.kCX = (ImageView) this.jot.findViewById(R.id.official_bar_toggle_button);
        this.kCX.setVisibility(0);
        this.kDb = new a[3];
        a aVar = new a();
        aVar.bzt = false;
        aVar.kDg = (LinearLayout) this.jot.findViewById(R.id.menu_frist);
        aVar.kDh = (TextView) this.jot.findViewById(R.id.menu_frist_text);
        aVar.kDi = (ImageView) this.jot.findViewById(R.id.menu_frist_tip);
        this.kDb[0] = aVar;
        a aVar2 = new a();
        aVar2.bzt = false;
        aVar2.kDg = (LinearLayout) this.jot.findViewById(R.id.menu_second);
        aVar2.kDh = (TextView) this.jot.findViewById(R.id.menu_second_text);
        aVar2.kDi = (ImageView) this.jot.findViewById(R.id.menu_second_tip);
        this.kDb[1] = aVar2;
        a aVar3 = new a();
        aVar3.bzt = false;
        aVar3.kDg = (LinearLayout) this.jot.findViewById(R.id.menu_third);
        aVar3.kDh = (TextView) this.jot.findViewById(R.id.menu_third_text);
        aVar3.kDi = (ImageView) this.jot.findViewById(R.id.menu_third_tip);
        this.kDb[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.kDb[i].kDg.setOnClickListener(talkableActivity);
        }
        this.kCY = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.kCY.setVisibility(0);
        this.kCZ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.kCZ.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.kCX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
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
        this.kDa = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.kDa);
        this.kDa.setVisibility(8);
        this.kDa.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.kDc = true;
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
        if (this.kDc) {
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
        if (this.kDc) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.sI(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cUU() {
        return this.kDa;
    }

    public void aj(boolean z, boolean z2) {
        if (this.kDc != z) {
            if (!this.kDc) {
                this.mTool.kP(false);
                return;
            }
            this.jot.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.kCY.setVisibility(0);
            return;
        }
        this.kDc = !z;
        if (z) {
            this.jot.setVisibility(8);
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
            this.kCY.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.jot.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.kCY.setVisibility(0);
    }

    public a[] cUV() {
        return this.kDb;
    }

    public void ep(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.kDb[i].kDh.setText(bVar.getName());
                if (bVar.cVk() != 0) {
                    this.kDb[i].kDi.setVisibility(8);
                }
            }
        }
    }

    public void sH(boolean z) {
        this.kCZ.setVisibility(z ? 0 : 8);
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
                    OfficialBarMsglistView.this.jot.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.jot.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.kDb[i];
                        if (aVar.bzt) {
                            aVar.bzt = false;
                            OfficialBarMsglistView.this.Z(i, aVar.bzt);
                            OfficialBarMsglistView.this.kDa.UU();
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
        a aVar = this.kDb[i];
        if (z) {
            aVar.kDi.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.kDh.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0302));
            return;
        }
        aVar.kDi.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.kDh.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
    }

    public int dn(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.kDb[i].kDg) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        boolean bzt;
        LinearLayout kDg;
        TextView kDh;
        ImageView kDi;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void CK(int i) {
        if (this.kzY != null) {
            this.kzY.setText(i);
        }
    }

    public void cUW() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.kzY, R.color.CAM_X0302, 1);
    }
}
