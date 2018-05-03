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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private TextView dPN;
    private ImageView dSR;
    private LinearLayout dSS;
    private LinearLayout dST;
    private LinearLayout dSU;
    private OfficialSecondMenuPopupWindow dSV;
    private a[] dSW;
    private boolean dSX;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dSX = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(d.k.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.dPN = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.dPN.setText(string);
        }
        this.dSS = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_memu_stub)).inflate();
        this.dSS.setVisibility(0);
        this.dSR = (ImageView) this.dSS.findViewById(d.g.official_bar_toggle_button);
        this.dSR.setVisibility(0);
        this.dSW = new a[3];
        a aVar = new a();
        aVar.dTb = false;
        aVar.dTc = (LinearLayout) this.dSS.findViewById(d.g.menu_frist);
        aVar.dTd = (TextView) this.dSS.findViewById(d.g.menu_frist_text);
        aVar.dTe = (ImageView) this.dSS.findViewById(d.g.menu_frist_tip);
        this.dSW[0] = aVar;
        a aVar2 = new a();
        aVar2.dTb = false;
        aVar2.dTc = (LinearLayout) this.dSS.findViewById(d.g.menu_second);
        aVar2.dTd = (TextView) this.dSS.findViewById(d.g.menu_second_text);
        aVar2.dTe = (ImageView) this.dSS.findViewById(d.g.menu_second_tip);
        this.dSW[1] = aVar2;
        a aVar3 = new a();
        aVar3.dTb = false;
        aVar3.dTc = (LinearLayout) this.dSS.findViewById(d.g.menu_third);
        aVar3.dTd = (TextView) this.dSS.findViewById(d.g.menu_third_text);
        aVar3.dTe = (ImageView) this.dSS.findViewById(d.g.menu_third_tip);
        this.dSW[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.dSW[i].dTc.setOnClickListener(talkableActivity);
        }
        this.dST = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_memu_down_line)).inflate();
        this.dST.setVisibility(0);
        this.dSU = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_menu_loading)).inflate();
        this.dSU.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.dSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                OfficialBarMsglistView.this.gN(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.dSV = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.dSV);
        this.dSV.setVisibility(8);
        this.dSV.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.dSX = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(d.C0126d.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(d.C0126d.cp_bg_line_c);
        this.mTool.bx(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.aCM != null && (this.mSendTool.aCM instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.aCM;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.aDB = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.C(arrayList);
        k eH = this.mTool.eH(5);
        if (eH != null) {
            eH.aDB = 3;
            eH.aDz = d.f.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.aCM != null && (aVar.aCM instanceof EditText)) {
            ((EditText) aVar.aCM).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(d.e.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(d.k.send_msg);
        this.mTool.b(aVar2);
        if (this.dSX) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.DG();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.dSX) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.gN(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow aBk() {
        return this.dSV;
    }

    public void B(boolean z, boolean z2) {
        if (this.dSX != z) {
            if (!this.dSX) {
                this.mTool.bz(false);
                return;
            }
            this.dSS.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.dST.setVisibility(0);
            return;
        }
        this.dSX = !z;
        if (z) {
            this.dSS.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.bz(true);
                } else {
                    this.mTool.bz(false);
                }
            }
            this.dST.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.dSS.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.dST.setVisibility(0);
    }

    public a[] aBl() {
        return this.dSW;
    }

    public void bR(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.dSW[i].dTd.setText(bVar.getName());
                if (bVar.aCQ() != 0) {
                    this.dSW[i].dTe.setVisibility(8);
                }
            }
        }
    }

    public void gM(boolean z) {
        this.dSU.setVisibility(z ? 0 : 8);
    }

    public void gN(final boolean z) {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), d.a.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), d.a.parent_menu_down);
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
                    OfficialBarMsglistView.this.dSS.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.dSS.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.lN();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.dSW[i];
                        if (aVar.dTb) {
                            aVar.dTb = false;
                            OfficialBarMsglistView.this.w(i, aVar.dTb);
                            OfficialBarMsglistView.this.dSV.ana();
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

    public void w(int i, boolean z) {
        a aVar = this.dSW[i];
        if (z) {
            aVar.dTe.setImageResource(d.f.icon_bottombar_arrow_s);
            aVar.dTd.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_link_tip_a));
            return;
        }
        aVar.dTe.setImageResource(d.f.icon_bottombar_arrow_n);
        aVar.dTd.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_f));
    }

    public int aH(View view2) {
        for (int i = 0; i < 3; i++) {
            if (view2 == this.dSW[i].dTc) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean dTb;
        LinearLayout dTc;
        TextView dTd;
        ImageView dTe;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void nj(int i) {
        if (this.dPN != null) {
            this.dPN.setText(i);
        }
    }

    public void aBm() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ak.c(this.dPN, d.C0126d.cp_link_tip_a, 1);
    }
}
