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
    private LinearLayout drZ;
    private TextView ejQ;
    private ImageView emW;
    private LinearLayout emX;
    private LinearLayout emY;
    private OfficialSecondMenuPopupWindow emZ;
    private a[] ena;
    private boolean enb;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.enb = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(d.j.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.ejQ = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.ejQ.setText(string);
        }
        this.drZ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_memu_stub)).inflate();
        this.drZ.setVisibility(0);
        this.emW = (ImageView) this.drZ.findViewById(d.g.official_bar_toggle_button);
        this.emW.setVisibility(0);
        this.ena = new a[3];
        a aVar = new a();
        aVar.eng = false;
        aVar.enh = (LinearLayout) this.drZ.findViewById(d.g.menu_frist);
        aVar.eni = (TextView) this.drZ.findViewById(d.g.menu_frist_text);
        aVar.enj = (ImageView) this.drZ.findViewById(d.g.menu_frist_tip);
        this.ena[0] = aVar;
        a aVar2 = new a();
        aVar2.eng = false;
        aVar2.enh = (LinearLayout) this.drZ.findViewById(d.g.menu_second);
        aVar2.eni = (TextView) this.drZ.findViewById(d.g.menu_second_text);
        aVar2.enj = (ImageView) this.drZ.findViewById(d.g.menu_second_tip);
        this.ena[1] = aVar2;
        a aVar3 = new a();
        aVar3.eng = false;
        aVar3.enh = (LinearLayout) this.drZ.findViewById(d.g.menu_third);
        aVar3.eni = (TextView) this.drZ.findViewById(d.g.menu_third_text);
        aVar3.enj = (ImageView) this.drZ.findViewById(d.g.menu_third_tip);
        this.ena[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.ena[i].enh.setOnClickListener(talkableActivity);
        }
        this.emX = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_memu_down_line)).inflate();
        this.emX.setVisibility(0);
        this.emY = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_menu_loading)).inflate();
        this.emY.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.emW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
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
        this.emZ = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.emZ);
        this.emZ.setVisibility(8);
        this.emZ.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.enb = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(d.C0140d.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(d.C0140d.cp_bg_line_c);
        this.mTool.bC(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.aMf != null && (this.mSendTool.aMf instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.aMf;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.aMU = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.F(arrayList);
        k eO = this.mTool.eO(5);
        if (eO != null) {
            eO.aMU = 3;
            eO.aMS = d.f.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.aMf != null && (aVar.aMf instanceof EditText)) {
            ((EditText) aVar.aMf).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(d.e.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(d.j.send_msg);
        this.mTool.b(aVar2);
        if (this.enb) {
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
        if (this.enb) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.hh(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow aHL() {
        return this.emZ;
    }

    public void E(boolean z, boolean z2) {
        if (this.enb != z) {
            if (!this.enb) {
                this.mTool.bE(false);
                return;
            }
            this.drZ.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.emX.setVisibility(0);
            return;
        }
        this.enb = !z;
        if (z) {
            this.drZ.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.bE(true);
                } else {
                    this.mTool.bE(false);
                }
            }
            this.emX.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.drZ.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.emX.setVisibility(0);
    }

    public a[] aHM() {
        return this.ena;
    }

    public void cd(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.ena[i].eni.setText(bVar.getName());
                if (bVar.aJr() != 0) {
                    this.ena[i].enj.setVisibility(8);
                }
            }
        }
    }

    public void hg(boolean z) {
        this.emY.setVisibility(z ? 0 : 8);
    }

    public void hh(final boolean z) {
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
                    OfficialBarMsglistView.this.drZ.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.drZ.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.oF();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.ena[i];
                        if (aVar.eng) {
                            aVar.eng = false;
                            OfficialBarMsglistView.this.v(i, aVar.eng);
                            OfficialBarMsglistView.this.emZ.ara();
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
        a aVar = this.ena[i];
        if (z) {
            aVar.enj.setImageResource(d.f.icon_bottombar_arrow_s);
            aVar.eni.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_link_tip_a));
            return;
        }
        aVar.enj.setImageResource(d.f.icon_bottombar_arrow_n);
        aVar.eni.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_f));
    }

    public int aO(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.ena[i].enh) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean eng;
        LinearLayout enh;
        TextView eni;
        ImageView enj;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void nP(int i) {
        if (this.ejQ != null) {
            this.ejQ.setText(i);
        }
    }

    public void aHN() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.c(this.ejQ, d.C0140d.cp_link_tip_a, 1);
    }
}
