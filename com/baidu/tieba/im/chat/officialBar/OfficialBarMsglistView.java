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
    private LinearLayout fvE;
    private TextView grP;
    private ImageView guR;
    private LinearLayout guS;
    private LinearLayout guT;
    private OfficialSecondMenuPopupWindow guU;
    private a[] guV;
    private boolean guW;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.guW = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.grP = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.grP.setText(string);
        }
        this.fvE = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.fvE.setVisibility(0);
        this.guR = (ImageView) this.fvE.findViewById(R.id.official_bar_toggle_button);
        this.guR.setVisibility(0);
        this.guV = new a[3];
        a aVar = new a();
        aVar.gva = false;
        aVar.gvb = (LinearLayout) this.fvE.findViewById(R.id.menu_frist);
        aVar.gvc = (TextView) this.fvE.findViewById(R.id.menu_frist_text);
        aVar.gvd = (ImageView) this.fvE.findViewById(R.id.menu_frist_tip);
        this.guV[0] = aVar;
        a aVar2 = new a();
        aVar2.gva = false;
        aVar2.gvb = (LinearLayout) this.fvE.findViewById(R.id.menu_second);
        aVar2.gvc = (TextView) this.fvE.findViewById(R.id.menu_second_text);
        aVar2.gvd = (ImageView) this.fvE.findViewById(R.id.menu_second_tip);
        this.guV[1] = aVar2;
        a aVar3 = new a();
        aVar3.gva = false;
        aVar3.gvb = (LinearLayout) this.fvE.findViewById(R.id.menu_third);
        aVar3.gvc = (TextView) this.fvE.findViewById(R.id.menu_third_text);
        aVar3.gvd = (ImageView) this.fvE.findViewById(R.id.menu_third_tip);
        this.guV[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.guV[i].gvb.setOnClickListener(talkableActivity);
        }
        this.guS = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.guS.setVisibility(0);
        this.guT = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.guT.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.guR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
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
        this.guU = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.guU);
        this.guU.setVisibility(8);
        this.guU.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.guW = true;
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
        if (this.guW) {
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
        if (this.guW) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.lB(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow byg() {
        return this.guU;
    }

    public void P(boolean z, boolean z2) {
        if (this.guW != z) {
            if (!this.guW) {
                this.mTool.ff(false);
                return;
            }
            this.fvE.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.guS.setVisibility(0);
            return;
        }
        this.guW = !z;
        if (z) {
            this.fvE.setVisibility(8);
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
            this.guS.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.fvE.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.guS.setVisibility(0);
    }

    public a[] byh() {
        return this.guV;
    }

    public void cO(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.guV[i].gvc.setText(bVar.getName());
                if (bVar.bzL() != 0) {
                    this.guV[i].gvd.setVisibility(8);
                }
            }
        }
    }

    public void lA(boolean z) {
        this.guT.setVisibility(z ? 0 : 8);
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
                    OfficialBarMsglistView.this.fvE.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.fvE.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.pO();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.guV[i];
                        if (aVar.gva) {
                            aVar.gva = false;
                            OfficialBarMsglistView.this.H(i, aVar.gva);
                            OfficialBarMsglistView.this.guU.beJ();
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
        a aVar = this.guV[i];
        if (z) {
            aVar.gvd.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.gvc.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.gvd.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.gvc.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cd(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.guV[i].gvb) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean gva;
        LinearLayout gvb;
        TextView gvc;
        ImageView gvd;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void uF(int i) {
        if (this.grP != null) {
            this.grP.setText(i);
        }
    }

    public void byi() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.f(this.grP, R.color.cp_link_tip_a, 1);
    }
}
