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
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout fvD;
    private TextView grO;
    private ImageView guQ;
    private LinearLayout guR;
    private LinearLayout guS;
    private OfficialSecondMenuPopupWindow guT;
    private a[] guU;
    private boolean guV;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.guV = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.grO = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.grO.setText(string);
        }
        this.fvD = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.fvD.setVisibility(0);
        this.guQ = (ImageView) this.fvD.findViewById(R.id.official_bar_toggle_button);
        this.guQ.setVisibility(0);
        this.guU = new a[3];
        a aVar = new a();
        aVar.guZ = false;
        aVar.gva = (LinearLayout) this.fvD.findViewById(R.id.menu_frist);
        aVar.gvb = (TextView) this.fvD.findViewById(R.id.menu_frist_text);
        aVar.gvc = (ImageView) this.fvD.findViewById(R.id.menu_frist_tip);
        this.guU[0] = aVar;
        a aVar2 = new a();
        aVar2.guZ = false;
        aVar2.gva = (LinearLayout) this.fvD.findViewById(R.id.menu_second);
        aVar2.gvb = (TextView) this.fvD.findViewById(R.id.menu_second_text);
        aVar2.gvc = (ImageView) this.fvD.findViewById(R.id.menu_second_tip);
        this.guU[1] = aVar2;
        a aVar3 = new a();
        aVar3.guZ = false;
        aVar3.gva = (LinearLayout) this.fvD.findViewById(R.id.menu_third);
        aVar3.gvb = (TextView) this.fvD.findViewById(R.id.menu_third_text);
        aVar3.gvc = (ImageView) this.fvD.findViewById(R.id.menu_third_tip);
        this.guU[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.guU[i].gva.setOnClickListener(talkableActivity);
        }
        this.guR = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.guR.setVisibility(0);
        this.guS = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.guS.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.guQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.lB(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.guT = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.guT);
        this.guT.setVisibility(8);
        this.guT.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.guV = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_c);
        this.mTool.fd(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.cqE != null && (this.mSendTool.cqE instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.cqE;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.crv = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.ai(arrayList);
        k kj = this.mTool.kj(5);
        if (kj != null) {
            kj.crv = 3;
            kj.crt = R.drawable.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.cqE != null && (aVar.cqE instanceof EditText)) {
            ((EditText) aVar.cqE).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.guV) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.aqT();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.guV) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.lB(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow byd() {
        return this.guT;
    }

    public void P(boolean z, boolean z2) {
        if (this.guV != z) {
            if (!this.guV) {
                this.mTool.ff(false);
                return;
            }
            this.fvD.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.guR.setVisibility(0);
            return;
        }
        this.guV = !z;
        if (z) {
            this.fvD.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.ff(true);
                } else {
                    this.mTool.ff(false);
                }
            }
            this.guR.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.fvD.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.guR.setVisibility(0);
    }

    public a[] bye() {
        return this.guU;
    }

    public void cO(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.guU[i].gvb.setText(bVar.getName());
                if (bVar.bzI() != 0) {
                    this.guU[i].gvc.setVisibility(8);
                }
            }
        }
    }

    public void lA(boolean z) {
        this.guS.setVisibility(z ? 0 : 8);
    }

    public void lB(final boolean z) {
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
                    OfficialBarMsglistView.this.fvD.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.fvD.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.pO();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.guU[i];
                        if (aVar.guZ) {
                            aVar.guZ = false;
                            OfficialBarMsglistView.this.H(i, aVar.guZ);
                            OfficialBarMsglistView.this.guT.beG();
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

    public void H(int i, boolean z) {
        a aVar = this.guU[i];
        if (z) {
            aVar.gvc.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.gvb.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.gvc.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.gvb.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cd(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.guU[i].gva) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean guZ;
        LinearLayout gva;
        TextView gvb;
        ImageView gvc;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void uF(int i) {
        if (this.grO != null) {
            this.grO.setText(i);
        }
    }

    public void byf() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.f(this.grO, R.color.cp_link_tip_a, 1);
    }
}
