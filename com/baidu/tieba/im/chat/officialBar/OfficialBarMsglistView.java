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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout drW;
    private TextView ejM;
    private ImageView emS;
    private LinearLayout emT;
    private LinearLayout emU;
    private OfficialSecondMenuPopupWindow emV;
    private a[] emW;
    private boolean emX;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.emX = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(f.j.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.ejM = (TextView) this.mBtnGroupInfo.findViewById(f.g.group_info_btn_txt);
            this.ejM.setText(string);
        }
        this.drW = (LinearLayout) ((ViewStub) talkableActivity.findViewById(f.g.official_bar_memu_stub)).inflate();
        this.drW.setVisibility(0);
        this.emS = (ImageView) this.drW.findViewById(f.g.official_bar_toggle_button);
        this.emS.setVisibility(0);
        this.emW = new a[3];
        a aVar = new a();
        aVar.enb = false;
        aVar.enc = (LinearLayout) this.drW.findViewById(f.g.menu_frist);
        aVar.ene = (TextView) this.drW.findViewById(f.g.menu_frist_text);
        aVar.enf = (ImageView) this.drW.findViewById(f.g.menu_frist_tip);
        this.emW[0] = aVar;
        a aVar2 = new a();
        aVar2.enb = false;
        aVar2.enc = (LinearLayout) this.drW.findViewById(f.g.menu_second);
        aVar2.ene = (TextView) this.drW.findViewById(f.g.menu_second_text);
        aVar2.enf = (ImageView) this.drW.findViewById(f.g.menu_second_tip);
        this.emW[1] = aVar2;
        a aVar3 = new a();
        aVar3.enb = false;
        aVar3.enc = (LinearLayout) this.drW.findViewById(f.g.menu_third);
        aVar3.ene = (TextView) this.drW.findViewById(f.g.menu_third_text);
        aVar3.enf = (ImageView) this.drW.findViewById(f.g.menu_third_tip);
        this.emW[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.emW[i].enc.setOnClickListener(talkableActivity);
        }
        this.emT = (LinearLayout) ((ViewStub) talkableActivity.findViewById(f.g.official_bar_memu_down_line)).inflate();
        this.emT.setVisibility(0);
        this.emU = (LinearLayout) ((ViewStub) talkableActivity.findViewById(f.g.official_bar_menu_loading)).inflate();
        this.emU.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.emS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.hh(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.emV = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.emV);
        this.emV.setVisibility(8);
        this.emV.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.emX = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(f.d.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(f.d.cp_bg_line_c);
        this.mTool.bD(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.aMc != null && (this.mSendTool.aMc instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.aMc;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.aMR = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.F(arrayList);
        k eN = this.mTool.eN(5);
        if (eN != null) {
            eN.aMR = 3;
            eN.aMP = f.C0146f.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.aMc != null && (aVar.aMc instanceof EditText)) {
            ((EditText) aVar.aMc).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(f.e.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(f.j.send_msg);
        this.mTool.b(aVar2);
        if (this.emX) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.Hu();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.emX) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.hh(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow aHI() {
        return this.emV;
    }

    public void E(boolean z, boolean z2) {
        if (this.emX != z) {
            if (!this.emX) {
                this.mTool.bF(false);
                return;
            }
            this.drW.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.emT.setVisibility(0);
            return;
        }
        this.emX = !z;
        if (z) {
            this.drW.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.bF(true);
                } else {
                    this.mTool.bF(false);
                }
            }
            this.emT.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.drW.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.emT.setVisibility(0);
    }

    public a[] aHJ() {
        return this.emW;
    }

    public void cd(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.emW[i].ene.setText(bVar.getName());
                if (bVar.aJo() != 0) {
                    this.emW[i].enf.setVisibility(8);
                }
            }
        }
    }

    public void hg(boolean z) {
        this.emU.setVisibility(z ? 0 : 8);
    }

    public void hh(final boolean z) {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), f.a.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), f.a.parent_menu_down);
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
                    OfficialBarMsglistView.this.drW.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.drW.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.oC();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.emW[i];
                        if (aVar.enb) {
                            aVar.enb = false;
                            OfficialBarMsglistView.this.v(i, aVar.enb);
                            OfficialBarMsglistView.this.emV.ara();
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

    public void v(int i, boolean z) {
        a aVar = this.emW[i];
        if (z) {
            aVar.enf.setImageResource(f.C0146f.icon_bottombar_arrow_s);
            aVar.ene.setTextColor(this.mContext.getResources().getColor(f.d.cp_link_tip_a));
            return;
        }
        aVar.enf.setImageResource(f.C0146f.icon_bottombar_arrow_n);
        aVar.ene.setTextColor(this.mContext.getResources().getColor(f.d.cp_cont_f));
    }

    public int aO(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.emW[i].enc) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean enb;
        LinearLayout enc;
        TextView ene;
        ImageView enf;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void nP(int i) {
        if (this.ejM != null) {
            this.ejM.setText(i);
        }
    }

    public void aHK() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.c(this.ejM, f.d.cp_link_tip_a, 1);
    }
}
