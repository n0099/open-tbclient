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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout dym;
    private TextView erf;
    private ImageView eun;
    private LinearLayout euo;
    private LinearLayout eup;
    private OfficialSecondMenuPopupWindow euq;
    private a[] eur;
    private boolean eus;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eus = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(e.j.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.erf = (TextView) this.mBtnGroupInfo.findViewById(e.g.group_info_btn_txt);
            this.erf.setText(string);
        }
        this.dym = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.official_bar_memu_stub)).inflate();
        this.dym.setVisibility(0);
        this.eun = (ImageView) this.dym.findViewById(e.g.official_bar_toggle_button);
        this.eun.setVisibility(0);
        this.eur = new a[3];
        a aVar = new a();
        aVar.euw = false;
        aVar.eux = (LinearLayout) this.dym.findViewById(e.g.menu_frist);
        aVar.euy = (TextView) this.dym.findViewById(e.g.menu_frist_text);
        aVar.euz = (ImageView) this.dym.findViewById(e.g.menu_frist_tip);
        this.eur[0] = aVar;
        a aVar2 = new a();
        aVar2.euw = false;
        aVar2.eux = (LinearLayout) this.dym.findViewById(e.g.menu_second);
        aVar2.euy = (TextView) this.dym.findViewById(e.g.menu_second_text);
        aVar2.euz = (ImageView) this.dym.findViewById(e.g.menu_second_tip);
        this.eur[1] = aVar2;
        a aVar3 = new a();
        aVar3.euw = false;
        aVar3.eux = (LinearLayout) this.dym.findViewById(e.g.menu_third);
        aVar3.euy = (TextView) this.dym.findViewById(e.g.menu_third_text);
        aVar3.euz = (ImageView) this.dym.findViewById(e.g.menu_third_tip);
        this.eur[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.eur[i].eux.setOnClickListener(talkableActivity);
        }
        this.euo = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.official_bar_memu_down_line)).inflate();
        this.euo.setVisibility(0);
        this.eup = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.official_bar_menu_loading)).inflate();
        this.eup.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.eun.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.hF(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.euq = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.euq);
        this.euq.setVisibility(8);
        this.euq.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.eus = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(e.d.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(e.d.cp_bg_line_c);
        this.mTool.bP(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.aPu != null && (this.mSendTool.aPu instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.aPu;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.aQj = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.G(arrayList);
        k eZ = this.mTool.eZ(5);
        if (eZ != null) {
            eZ.aQj = 3;
            eZ.aQh = e.f.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.aPu != null && (aVar.aPu instanceof EditText)) {
            ((EditText) aVar.aPu).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(e.C0141e.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(e.j.send_msg);
        this.mTool.b(aVar2);
        if (this.eus) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.IK();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.eus) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.hF(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow aJX() {
        return this.euq;
    }

    public void G(boolean z, boolean z2) {
        if (this.eus != z) {
            if (!this.eus) {
                this.mTool.bR(false);
                return;
            }
            this.dym.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.euo.setVisibility(0);
            return;
        }
        this.eus = !z;
        if (z) {
            this.dym.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.bR(true);
                } else {
                    this.mTool.bR(false);
                }
            }
            this.euo.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.dym.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.euo.setVisibility(0);
    }

    public a[] aJY() {
        return this.eur;
    }

    public void ce(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.eur[i].euy.setText(bVar.getName());
                if (bVar.aLD() != 0) {
                    this.eur[i].euz.setVisibility(8);
                }
            }
        }
    }

    public void hE(boolean z) {
        this.eup.setVisibility(z ? 0 : 8);
    }

    public void hF(final boolean z) {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), e.a.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), e.a.parent_menu_down);
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
                    OfficialBarMsglistView.this.dym.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.dym.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.pI();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.eur[i];
                        if (aVar.euw) {
                            aVar.euw = false;
                            OfficialBarMsglistView.this.w(i, aVar.euw);
                            OfficialBarMsglistView.this.euq.asO();
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
        a aVar = this.eur[i];
        if (z) {
            aVar.euz.setImageResource(e.f.icon_bottombar_arrow_s);
            aVar.euy.setTextColor(this.mContext.getResources().getColor(e.d.cp_link_tip_a));
            return;
        }
        aVar.euz.setImageResource(e.f.icon_bottombar_arrow_n);
        aVar.euy.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_f));
    }

    public int bc(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.eur[i].eux) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean euw;
        LinearLayout eux;
        TextView euy;
        ImageView euz;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void ot(int i) {
        if (this.erf != null) {
            this.erf.setText(i);
        }
    }

    public void aJZ() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.c(this.erf, e.d.cp_link_tip_a, 1);
    }
}
