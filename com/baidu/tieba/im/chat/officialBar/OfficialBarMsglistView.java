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
    private LinearLayout ffp;
    private TextView gay;
    private ImageView gdD;
    private LinearLayout gdE;
    private LinearLayout gdF;
    private OfficialSecondMenuPopupWindow gdG;
    private a[] gdH;
    private boolean gdI;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gdI = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(d.j.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.gay = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.gay.setText(string);
        }
        this.ffp = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_memu_stub)).inflate();
        this.ffp.setVisibility(0);
        this.gdD = (ImageView) this.ffp.findViewById(d.g.official_bar_toggle_button);
        this.gdD.setVisibility(0);
        this.gdH = new a[3];
        a aVar = new a();
        aVar.gdM = false;
        aVar.gdN = (LinearLayout) this.ffp.findViewById(d.g.menu_frist);
        aVar.gdO = (TextView) this.ffp.findViewById(d.g.menu_frist_text);
        aVar.gdP = (ImageView) this.ffp.findViewById(d.g.menu_frist_tip);
        this.gdH[0] = aVar;
        a aVar2 = new a();
        aVar2.gdM = false;
        aVar2.gdN = (LinearLayout) this.ffp.findViewById(d.g.menu_second);
        aVar2.gdO = (TextView) this.ffp.findViewById(d.g.menu_second_text);
        aVar2.gdP = (ImageView) this.ffp.findViewById(d.g.menu_second_tip);
        this.gdH[1] = aVar2;
        a aVar3 = new a();
        aVar3.gdM = false;
        aVar3.gdN = (LinearLayout) this.ffp.findViewById(d.g.menu_third);
        aVar3.gdO = (TextView) this.ffp.findViewById(d.g.menu_third_text);
        aVar3.gdP = (ImageView) this.ffp.findViewById(d.g.menu_third_tip);
        this.gdH[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.gdH[i].gdN.setOnClickListener(talkableActivity);
        }
        this.gdE = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_memu_down_line)).inflate();
        this.gdE.setVisibility(0);
        this.gdF = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.official_bar_menu_loading)).inflate();
        this.gdF.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.gdD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.kM(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.gdG = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.gdG);
        this.gdG.setVisibility(8);
        this.gdG.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.gdI = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(d.C0277d.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(d.C0277d.cp_bg_line_c);
        this.mTool.eH(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.ciw != null && (this.mSendTool.ciw instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.ciw;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.cjm = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.ab(arrayList);
        k jv = this.mTool.jv(5);
        if (jv != null) {
            jv.cjm = 3;
            jv.cjk = d.f.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.ciw != null && (aVar.ciw instanceof EditText)) {
            ((EditText) aVar.ciw).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(d.e.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(d.j.send_msg);
        this.mTool.b(aVar2);
        if (this.gdI) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.alQ();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.gdI) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.kM(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow bqr() {
        return this.gdG;
    }

    public void O(boolean z, boolean z2) {
        if (this.gdI != z) {
            if (!this.gdI) {
                this.mTool.eJ(false);
                return;
            }
            this.ffp.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.gdE.setVisibility(0);
            return;
        }
        this.gdI = !z;
        if (z) {
            this.ffp.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.eJ(true);
                } else {
                    this.mTool.eJ(false);
                }
            }
            this.gdE.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.ffp.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.gdE.setVisibility(0);
    }

    public a[] bqs() {
        return this.gdH;
    }

    public void cG(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.gdH[i].gdO.setText(bVar.getName());
                if (bVar.brW() != 0) {
                    this.gdH[i].gdP.setVisibility(8);
                }
            }
        }
    }

    public void kL(boolean z) {
        this.gdF.setVisibility(z ? 0 : 8);
    }

    public void kM(final boolean z) {
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
                    OfficialBarMsglistView.this.ffp.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.ffp.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.qT();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.gdH[i];
                        if (aVar.gdM) {
                            aVar.gdM = false;
                            OfficialBarMsglistView.this.C(i, aVar.gdM);
                            OfficialBarMsglistView.this.gdG.aXr();
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

    public void C(int i, boolean z) {
        a aVar = this.gdH[i];
        if (z) {
            aVar.gdP.setImageResource(d.f.icon_bottombar_arrow_s);
            aVar.gdO.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_link_tip_a));
            return;
        }
        aVar.gdP.setImageResource(d.f.icon_bottombar_arrow_n);
        aVar.gdO.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_f));
    }

    public int bW(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.gdH[i].gdN) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean gdM;
        LinearLayout gdN;
        TextView gdO;
        ImageView gdP;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void ty(int i) {
        if (this.gay != null) {
            this.gay.setText(i);
        }
    }

    public void bqt() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.d(this.gay, d.C0277d.cp_link_tip_a, 1);
    }
}
