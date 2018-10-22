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
    private LinearLayout dGn;
    private ImageView eCc;
    private LinearLayout eCd;
    private LinearLayout eCe;
    private OfficialSecondMenuPopupWindow eCf;
    private a[] eCg;
    private boolean eCh;
    private TextView eyX;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eCh = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(e.j.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.eyX = (TextView) this.mBtnGroupInfo.findViewById(e.g.group_info_btn_txt);
            this.eyX.setText(string);
        }
        this.dGn = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.official_bar_memu_stub)).inflate();
        this.dGn.setVisibility(0);
        this.eCc = (ImageView) this.dGn.findViewById(e.g.official_bar_toggle_button);
        this.eCc.setVisibility(0);
        this.eCg = new a[3];
        a aVar = new a();
        aVar.eCl = false;
        aVar.eCm = (LinearLayout) this.dGn.findViewById(e.g.menu_frist);
        aVar.eCn = (TextView) this.dGn.findViewById(e.g.menu_frist_text);
        aVar.eCo = (ImageView) this.dGn.findViewById(e.g.menu_frist_tip);
        this.eCg[0] = aVar;
        a aVar2 = new a();
        aVar2.eCl = false;
        aVar2.eCm = (LinearLayout) this.dGn.findViewById(e.g.menu_second);
        aVar2.eCn = (TextView) this.dGn.findViewById(e.g.menu_second_text);
        aVar2.eCo = (ImageView) this.dGn.findViewById(e.g.menu_second_tip);
        this.eCg[1] = aVar2;
        a aVar3 = new a();
        aVar3.eCl = false;
        aVar3.eCm = (LinearLayout) this.dGn.findViewById(e.g.menu_third);
        aVar3.eCn = (TextView) this.dGn.findViewById(e.g.menu_third_text);
        aVar3.eCo = (ImageView) this.dGn.findViewById(e.g.menu_third_tip);
        this.eCg[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.eCg[i].eCm.setOnClickListener(talkableActivity);
        }
        this.eCd = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.official_bar_memu_down_line)).inflate();
        this.eCd.setVisibility(0);
        this.eCe = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.official_bar_menu_loading)).inflate();
        this.eCe.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.eCc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.hX(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.eCf = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.eCf);
        this.eCf.setVisibility(8);
        this.eCf.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.eCh = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(e.d.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(e.d.cp_bg_line_c);
        this.mTool.bY(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.aTV != null && (this.mSendTool.aTV instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.aTV;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.aUK = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.w(arrayList);
        k fi = this.mTool.fi(5);
        if (fi != null) {
            fi.aUK = 3;
            fi.aUI = e.f.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.aTV != null && (aVar.aTV instanceof EditText)) {
            ((EditText) aVar.aTV).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(e.C0175e.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(e.j.send_msg);
        this.mTool.b(aVar2);
        if (this.eCh) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.KI();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.eCh) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.hX(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow aNn() {
        return this.eCf;
    }

    public void H(boolean z, boolean z2) {
        if (this.eCh != z) {
            if (!this.eCh) {
                this.mTool.ca(false);
                return;
            }
            this.dGn.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.eCd.setVisibility(0);
            return;
        }
        this.eCh = !z;
        if (z) {
            this.dGn.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.ca(true);
                } else {
                    this.mTool.ca(false);
                }
            }
            this.eCd.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.dGn.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.eCd.setVisibility(0);
    }

    public a[] aNo() {
        return this.eCg;
    }

    public void ct(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.eCg[i].eCn.setText(bVar.getName());
                if (bVar.aOS() != 0) {
                    this.eCg[i].eCo.setVisibility(8);
                }
            }
        }
    }

    public void hW(boolean z) {
        this.eCe.setVisibility(z ? 0 : 8);
    }

    public void hX(final boolean z) {
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
                    OfficialBarMsglistView.this.dGn.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.dGn.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.pQ();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.eCg[i];
                        if (aVar.eCl) {
                            aVar.eCl = false;
                            OfficialBarMsglistView.this.w(i, aVar.eCl);
                            OfficialBarMsglistView.this.eCf.awl();
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
        a aVar = this.eCg[i];
        if (z) {
            aVar.eCo.setImageResource(e.f.icon_bottombar_arrow_s);
            aVar.eCn.setTextColor(this.mContext.getResources().getColor(e.d.cp_link_tip_a));
            return;
        }
        aVar.eCo.setImageResource(e.f.icon_bottombar_arrow_n);
        aVar.eCn.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_f));
    }

    public int bc(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.eCg[i].eCm) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean eCl;
        LinearLayout eCm;
        TextView eCn;
        ImageView eCo;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void oR(int i) {
        if (this.eyX != null) {
            this.eyX.setText(i);
        }
    }

    public void aNp() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.c(this.eyX, e.d.cp_link_tip_a, 1);
    }
}
