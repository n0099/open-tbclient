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
    private LinearLayout dOb;
    private TextView eHf;
    private ImageView eKk;
    private LinearLayout eKl;
    private LinearLayout eKm;
    private OfficialSecondMenuPopupWindow eKn;
    private a[] eKo;
    private boolean eKp;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eKp = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(e.j.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.eHf = (TextView) this.mBtnGroupInfo.findViewById(e.g.group_info_btn_txt);
            this.eHf.setText(string);
        }
        this.dOb = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.official_bar_memu_stub)).inflate();
        this.dOb.setVisibility(0);
        this.eKk = (ImageView) this.dOb.findViewById(e.g.official_bar_toggle_button);
        this.eKk.setVisibility(0);
        this.eKo = new a[3];
        a aVar = new a();
        aVar.eKt = false;
        aVar.eKu = (LinearLayout) this.dOb.findViewById(e.g.menu_frist);
        aVar.eKv = (TextView) this.dOb.findViewById(e.g.menu_frist_text);
        aVar.eKw = (ImageView) this.dOb.findViewById(e.g.menu_frist_tip);
        this.eKo[0] = aVar;
        a aVar2 = new a();
        aVar2.eKt = false;
        aVar2.eKu = (LinearLayout) this.dOb.findViewById(e.g.menu_second);
        aVar2.eKv = (TextView) this.dOb.findViewById(e.g.menu_second_text);
        aVar2.eKw = (ImageView) this.dOb.findViewById(e.g.menu_second_tip);
        this.eKo[1] = aVar2;
        a aVar3 = new a();
        aVar3.eKt = false;
        aVar3.eKu = (LinearLayout) this.dOb.findViewById(e.g.menu_third);
        aVar3.eKv = (TextView) this.dOb.findViewById(e.g.menu_third_text);
        aVar3.eKw = (ImageView) this.dOb.findViewById(e.g.menu_third_tip);
        this.eKo[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.eKo[i].eKu.setOnClickListener(talkableActivity);
        }
        this.eKl = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.official_bar_memu_down_line)).inflate();
        this.eKl.setVisibility(0);
        this.eKm = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.official_bar_menu_loading)).inflate();
        this.eKm.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.eKk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.ij(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.eKn = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.eKn);
        this.eKn.setVisibility(8);
        this.eKn.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.eKp = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(e.d.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(e.d.cp_bg_line_c);
        this.mTool.cq(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.aYi != null && (this.mSendTool.aYi instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.aYi;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.aYX = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.w(arrayList);
        k fK = this.mTool.fK(5);
        if (fK != null) {
            fK.aYX = 3;
            fK.aYV = e.f.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.aYi != null && (aVar.aYi instanceof EditText)) {
            ((EditText) aVar.aYi).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(e.C0210e.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(e.j.send_msg);
        this.mTool.b(aVar2);
        if (this.eKp) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.LY();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.eKp) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.ij(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow aOB() {
        return this.eKn;
    }

    public void J(boolean z, boolean z2) {
        if (this.eKp != z) {
            if (!this.eKp) {
                this.mTool.cs(false);
                return;
            }
            this.dOb.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.eKl.setVisibility(0);
            return;
        }
        this.eKp = !z;
        if (z) {
            this.dOb.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.cs(true);
                } else {
                    this.mTool.cs(false);
                }
            }
            this.eKl.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.dOb.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.eKl.setVisibility(0);
    }

    public a[] aOC() {
        return this.eKo;
    }

    public void cv(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.eKo[i].eKv.setText(bVar.getName());
                if (bVar.aQg() != 0) {
                    this.eKo[i].eKw.setVisibility(8);
                }
            }
        }
    }

    public void ii(boolean z) {
        this.eKm.setVisibility(z ? 0 : 8);
    }

    public void ij(final boolean z) {
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
                    OfficialBarMsglistView.this.dOb.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.dOb.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.pN();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.eKo[i];
                        if (aVar.eKt) {
                            aVar.eKt = false;
                            OfficialBarMsglistView.this.w(i, aVar.eKt);
                            OfficialBarMsglistView.this.eKn.axu();
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
        a aVar = this.eKo[i];
        if (z) {
            aVar.eKw.setImageResource(e.f.icon_bottombar_arrow_s);
            aVar.eKv.setTextColor(this.mContext.getResources().getColor(e.d.cp_link_tip_a));
            return;
        }
        aVar.eKw.setImageResource(e.f.icon_bottombar_arrow_n);
        aVar.eKv.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_f));
    }

    public int be(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.eKo[i].eKu) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean eKt;
        LinearLayout eKu;
        TextView eKv;
        ImageView eKw;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void pE(int i) {
        if (this.eHf != null) {
            this.eHf.setText(i);
        }
    }

    public void aOD() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.c(this.eHf, e.d.cp_link_tip_a, 1);
    }
}
